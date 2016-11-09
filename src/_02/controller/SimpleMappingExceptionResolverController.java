package _02.controller;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import _02.model.DatabaseException;


@Controller
public class SimpleMappingExceptionResolverController {

	@RequestMapping("/numberFormatException")
	public ModelAndView throwNumberFormatException() {
		throw new NumberFormatException();
	}

	@RequestMapping("/nullPointerException")
	public ModelAndView throwNullPointerException() {
		throw new NullPointerException();
	}

	@RequestMapping("/databaseException")
	String throwDatabaseException() throws Exception {
		throw new DatabaseException("DB-1000", "DB Connection timeout...");
	}
	
	@RequestMapping("/sqlException3")
	String throwSQLException() throws SQLException {

		System.out.println("SQLException3....");
		throw new SQLException();

	}
	
	@ExceptionHandler({SQLException.class, SQLDataException.class})
	public String handleSQLException() {
		return "_02.exception/sqlException3";
	}
	
}