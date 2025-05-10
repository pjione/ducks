package com.study.ducks.exception.custom;

import com.study.ducks.exception.ApiException;
import org.springframework.http.HttpStatus;

public class IsNotFoundCommission extends ApiException {
    public IsNotFoundCommission() {
        super("커미션이 존재하지 않습니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
