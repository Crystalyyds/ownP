package com.example.own.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.own.common.Constants;
import com.example.own.entity.User;
import com.example.own.exception.ServiceException;
import com.example.own.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不算映射方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (StrUtil.isBlank(token)) {
            //判断是否为空，为空丢异常
            throw new ServiceException(Constants.CODE_401, "无token，请重新登录");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(Constants.CODE_401, "token解析异常");
        }
        User user = userService.getById(userId);
        if (userId == null) {
            throw new ServiceException(Constants.CODE_401, "用户不存在");
        }
        //用户密码签名认证
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword()))
                .build();
        try {
            jwtVerifier.verify(token);//验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(Constants.CODE_401, "token验证失败");
        }

        return true;
    }

}
