package com.ebook.user.ex;

import com.ebook.user.CMPrespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public CMPrespDto<?> validationException(CustomValidationException e) {

        return new CMPrespDto<>(-1, e.getMessage(), e.getErrorMap());

//    @ExceptionHandler(CustomValidationException.class)
//    public String validationException(CustomValidationException e) {
//        //CMRespDto, Script 비교
//        // 1. 클라이언트한테 응답할때는 Script 좋음.
//        // 2. Ajax통신 - CMPespDto
//        // 3. Android 통신 - CMPespDto
//
//
//        return Script.back(e.getErrorMap().toString());

    }


}
