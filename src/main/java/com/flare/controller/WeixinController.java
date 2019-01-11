package com.flare.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname WeixinController
 * @Description 微信
 * @Date 2019/1/8 19:29
 * @Created by flare
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法。。。");
        log.info("code={}",code);

//        String url = "";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);
//        log.info("response={}",response);
    }
}
