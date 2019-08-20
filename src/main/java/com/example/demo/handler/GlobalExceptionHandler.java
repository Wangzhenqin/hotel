package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by wangzhenqin on 2019/8/20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",false);
        modelMap.put("errMsq",e.getMessage());
        return modelMap;
    }
}
