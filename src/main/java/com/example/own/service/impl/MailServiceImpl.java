package com.example.own.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.own.common.AlibabaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.IClientProfile;


@Service
@Slf4j
public class MailServiceImpl {


    /**
     * 邮件发送
     * @param toAddress 接收邮箱地址
     * @param fromAlias 发送邮箱名称
     * @param htmlBody 邮箱内容消息体
     * @param subject 邮箱主题
     * @return
     * @throws ClientException
     */
    public static SingleSendMailResponse sendEmail(String toAddress, String fromAlias, String htmlBody, String subject){
        try {
            if (fromAlias == null || fromAlias.length() <= 0) {
                fromAlias = AlibabaConstants.ALI_EMAIL_CN_FROM_ALIAS;
            }
            IClientProfile profile = DefaultProfile.
                    getProfile(AlibabaConstants.ALI_EMAIL_REGION_ID, AlibabaConstants.ALI_EMAIL_ACCESS_KEY_ID, AlibabaConstants.ALI_EMAIL_SECRET);
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendMailRequest request = new SingleSendMailRequest();
            request.setAccountName(AlibabaConstants.ALI_EMAIL_ACCOUNT_NAME);
            request.setFromAlias(fromAlias);
            request.setAddressType(1);
            request.setToAddress(toAddress);
            request.setReplyToAddress(true);
            request.setSubject(subject);
            //如果采用byte[].toString的方式的话请确保最终转换成utf-8的格式再放入htmlbody和textbody，若编码不一致则会被当成垃圾邮件。
            //注意：文本邮件的大小限制为3M，过大的文本会导致连接超时或413错误
            request.setHtmlBody(htmlBody);
            //若textBody、htmlBody或content的大小不确定，建议采用POST方式提交，避免出现uri is not valid异常
            request.setMethod(MethodType.POST);
            SingleSendMailResponse sendMailResponse = client.getAcsResponse(request);
            log.info("邮件发送成功:给邮箱为{},发送的内容为{},主题为{}", toAddress, htmlBody, subject);
            return sendMailResponse;
            }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
