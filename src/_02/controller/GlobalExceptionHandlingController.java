package _02.controller;

import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlingController {

	@ExceptionHandler({SQLException.class, SQLDataException.class})
	public String handleGenericSQLException() {

		System.out.println("handleGenericSQLException...");
		return "_02.exception/genericSqlException";

	}

	@ExceptionHandler({IndexOutOfBoundsException.class})
	public ModelAndView handleGenericIndexOutOfBoundsException(HttpServletRequest req, Exception exception) {

		System.out.println("handleGenericIndexOutOfBoundsException...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("_02.exception/genericIndexOutOfBoundsException");
		return modelAndView;

	}
	
	// @ExceptionHandler has more priviledge than the class SimpleMappingExceptionResolver

//	@ExceptionHandler({NullPointerException.class})
//	public String handleNullPointerException() {
//		System.out.println("handleNullPointerException...");
//		return "_02.exception/genericNpe";
//	}

}
