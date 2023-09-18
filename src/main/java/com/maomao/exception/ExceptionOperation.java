package com.maomao.exception;

import com.maomao.util.Result;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@CrossOrigin
public class ExceptionOperation {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

}
