package com.prempoint.hello.rest;

import com.google.gson.Gson;
import com.prempoint.hello.dto.common.ErrorResponse;
import com.prempoint.hello.dto.hello.HelloResponse;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by rajjasti on 3/20/17.
 */
public class HelloRestService extends javax.servlet.http.HttpServlet {

    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String QUERY_PARAM_NAME = "name";
    private static final String ERROR_METHOD_NOT_ALLOWED = "Method Not Allowed";
    private static final String ERROR_INVALID_REQUEST = "Invalid Request. Query Param: name expected";


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        setErrorResponse(resp, 405, ERROR_METHOD_NOT_ALLOWED);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Gson gson = new Gson();
        try {

            PrintWriter pw = resp.getWriter();


            String name = req.getParameter(QUERY_PARAM_NAME);

           if(StringUtils.isNotBlank(name)){
               HelloResponse helloResponse = new HelloResponse(name);
               resp.setContentType(JSON_CONTENT_TYPE);
               gson.toJson(helloResponse, pw);

           }else{
               setErrorResponse(resp, 400, ERROR_INVALID_REQUEST);
           }

        } catch (Throwable t) {
            setErrorResponse(resp, 500, t.getLocalizedMessage());
        }
    }

    private void setErrorResponse(HttpServletResponse resp, int errorCode, String message) throws IOException {
        Gson gson = new Gson();
        resp.setContentType(JSON_CONTENT_TYPE);
        resp.setStatus(errorCode);
        PrintWriter pw = resp.getWriter();
        ErrorResponse errorResponse = new ErrorResponse(message);
        gson.toJson(errorResponse, pw);
    }
}