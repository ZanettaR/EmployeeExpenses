package dev.tyler.api;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();


        Handler employee = context -> {
            context.result("");
        };
        Handler expenses = context -> {
            context.html("");
        };

        app.get("/employee", employee);
        app.get("/expenses", expenses);
        app.start(7000);
    }
}
