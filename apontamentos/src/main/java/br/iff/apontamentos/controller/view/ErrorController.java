package br.iff.apontamentos.controller.view;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController{
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleNotFoundException(HttpServletRequest request, NotFoundException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("timestamp", LocalDateTime.now());
		mav.addObject("status", HttpStatus.NOT_FOUND.value());
		mav.addObject("error", HttpStatus.NOT_FOUND.getReasonPhrase());
		mav.addObject("message", "Página não encontrada");
		mav.addObject("path", request.getRequestURI());
		mav.setViewName("error");
		return mav;
	}
	
	
	public String getErrorPath() {
        return "/error"; 
    }
	
	

}
