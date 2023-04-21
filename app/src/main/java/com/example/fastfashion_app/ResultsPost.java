package com.example.fastfashion_app;


public class ResultsPost {
    private String code;
    private String type;
    private String message;

    public ResultsPost(String code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public String getCode() { return code; }

    public String getType() { return type; }

    public String getMessage() { return message; }
}
