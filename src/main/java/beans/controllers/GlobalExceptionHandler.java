package beans.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView redirect(Exception e) {
        ModelAndView view = new ModelAndView("error-page");

        String errorMessage = e.getMessage() == null ? "Unknown error" : e.getMessage();

        view.addObject("error_message", errorMessage);

        return view;
    }
}
