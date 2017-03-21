import com.google.gson.Gson;
import dto.common.ErrorResponse;
import dto.hello.HelloResponse;
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


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        setErrorResponse(resp, 405, "Method Not Allowed");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Gson gson = new Gson();
        try {

            PrintWriter pw = resp.getWriter();
            resp.setContentType("application/json");

            String name = req.getParameter("name");

           if(StringUtils.isNotBlank(name)){
               HelloResponse helloResponse = new HelloResponse(name);
               gson.toJson(helloResponse, pw);

           }else{
               setErrorResponse(resp, 400, "Invalid Request. Query Param: name expected");
           }

        } catch (Throwable t) {
            setErrorResponse(resp, 500, t.getLocalizedMessage());
        }
    }

    private void setErrorResponse(HttpServletResponse resp, int errorCode, String message) throws IOException {
        Gson gson = new Gson();
        resp.setContentType("application/json");
        resp.setStatus(errorCode);
        PrintWriter pw = resp.getWriter();
        ErrorResponse errorResponse = new ErrorResponse(message);
        gson.toJson(errorResponse, pw);
    }
}