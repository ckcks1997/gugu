package org.sample.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice //스프링 컨드롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
@Log4j2
public class CommonExceptionAdvice
{
    @ExceptionHandler(Exception.class)//()에 들어가는 타입 처리
    public String except(Exception ex, Model model){
        log.error("exception.."+ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);
        return "error_page";
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex){
        return "custom404";
    }
}
