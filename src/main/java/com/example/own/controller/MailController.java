package com.example.own.controller;


import com.example.own.common.Result;
import com.example.own.service.impl.MailServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mail")
public class MailController {

    /**
    * 发送邮件
    *  toAddress 接收人邮件地址
    *  fromAlias 发送邮箱名称
    *  htmlBody 消息体内容（用html格式发送效果更好）
    *  subject 主题名称
    */

    @GetMapping("/sendMail")
    public void sendMail(@RequestParam String toAddress) {
        String fromAlias = "";
        String htmlBody = "<h1 style=\"text-align:center;\">How do you think</h1>";
        String subject = "测试";
        MailServiceImpl.sendEmail(toAddress, fromAlias, htmlBody, subject);
    }
}
