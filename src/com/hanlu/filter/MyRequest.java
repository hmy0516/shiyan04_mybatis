package com.hanlu.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * @author HMY
 * @date 2018/11/22-21:27
 */
public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request ;
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        //判Null空
        if(value==null){
            return null;
        }
        //判请求方式
        if(request.getMethod().equalsIgnoreCase("POST")){
            return value;
        }
        try {
            //转换编码方式
            value = new String(value.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}