package com.mpayme.sample.ipn;

import static spark.Spark.*;
import spark.*;
import spark.utils.IOUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * <p>
 *     Sample Code to receive HTTP post message on <code>http://localhost:4567/ipn.</code>
 * </p>
 * @author Leonard Siu
 */
public class SampleIPN {

    public static void main(String[] args) {

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {

                String html = null;
                try {
                    html = IOUtils.toString(SampleIPN.class.getResourceAsStream("/html/index.html"));
                } catch (IOException e) {
                    response.status(500);
                    try {
                        e.printStackTrace(new PrintWriter(new OutputStreamWriter(response.raw().getOutputStream())));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                response.type("text/html");
                return html;
            }
        });

        post(new Route("/ipn") {
            @Override
            public Object handle(Request request, Response response) {
                StringBuilder sb = new StringBuilder();
                for(String h: request.headers()) {
                    sb.append(String.format("%s:%s\n", h, request.headers(h)));
                }
                sb.append("\n");
                sb.append("body:").append(request.body());
                System.out.print(sb.toString());
                return "Received. OK!";
            }
        });

    }
}
