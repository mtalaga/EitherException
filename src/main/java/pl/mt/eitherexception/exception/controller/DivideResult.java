package pl.mt.eitherexception.exception.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
record DivideResult(Integer result, String error) {
    public static DivideResult successful(int result) {
        return new DivideResult(result, null);
    }

    public static DivideResult error(String error) {
        return new DivideResult(null, error);
    }
}
