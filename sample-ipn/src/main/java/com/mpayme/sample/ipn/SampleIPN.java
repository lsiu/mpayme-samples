package com.mpayme.sample.ipn;

import static spark.Spark.*;
import spark.*;

/**
 * Created by lsiu on 12/6/13.
 */
public class SampleIPN {

    public static void main(String[] args) {

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });

    }
}
