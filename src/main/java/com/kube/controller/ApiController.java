/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kube.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author loren
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/test")
public class ApiController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public HashMap<String, Object> getIp(HttpServletRequest hesderRequest, @RequestBody HashMap<String, Object> request) throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println(hesderRequest.getRemoteAddr());
        System.out.println(hesderRequest.getScheme());
        System.out.println(hesderRequest.getHeader("STGB_ServiceName"));
        System.out.println(hesderRequest.getHeader("STGB_OperationName"));
        System.out.println(hesderRequest.getHeader("CSTGB_Method"));
        System.out.println(hesderRequest.getHeader("STGB_Version"));
        HashMap<String, Object> response = new HashMap<>();
        response.put("ip", ip);
        String rq = request.get("request") != null ? request.get("request").toString() : "";
        System.out.println(rq);
        response.put("response", String.format("Hi %s Welcome to Osb 12c", rq));
        return response;
    }
}
