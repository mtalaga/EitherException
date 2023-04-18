package pl.mt.eitherexception.domainleak.exception.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
record DivideResult(Double result, String error) {
    public static DivideResult successful(double result) {
        return new DivideResult(result, null);
    }

    public static DivideResult error(String error) {
        return new DivideResult(null, error);
    }
}
