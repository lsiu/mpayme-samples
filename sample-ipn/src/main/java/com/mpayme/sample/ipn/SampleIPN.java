package com.mpayme.sample.ipn;

import static spark.Spark.*;
import spark.*;

/**
 * <p>
 *     Sample Code to receive HTTP post message on <code>http://localhost:4567/ipn.</code>
 * </p>
 * @author Leonard Siu
 */
public class SampleIPN {

    public static void main(String[] args) {

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
