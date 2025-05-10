package com.study.ducks.exception.custom;

import com.study.ducks.exception.ApiException;
import org.springframework.http.HttpStatus;

public class IsInvalidUser extends ApiException {
    public IsInvalidUser() {
        super("유효하지 않은 유저가 있습니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
