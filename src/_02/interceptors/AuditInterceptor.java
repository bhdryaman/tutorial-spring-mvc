package _02.interceptors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditInterceptor extends HandlerInterceptorAdapter{

	Logger logger = Logger.getLogger("auditLogger");
	
	private String ipAddress;
	private String jobId;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {
		System.out.println("AuditInterceptor class...");
		System.out.println(request.getRequestURI().endsWith("jobs/add"));
		if (request.getRequestURI().endsWith("jobs/add")) {

			if (request.getMethod().equals("GET")) {
				logger.info("preHandle : GET request");
			}

			if (request.getMethod().equals("POST")) {
				ipAddress = request.getRemoteHost();
				jobId = request.getParameter("id");
				logger.info("preHandle : POST request jobId: " + jobId + " ip : "+ipAddress);
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		if (request.getRequestURI().endsWith("jobs/add") && response.getStatus() == 302) {
			logger.info(String.format("A New job[%s] Added by %s on %s", jobId, ipAddress, getCurrentTime()));
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (request.getRequestURI().endsWith("jobs/add")) {

			if (request.getMethod().equals("GET")) {
				logger.info("postHandle : GET request");
			}

			if (request.getMethod().equals("POST")) {
				logger.info("postHandle : POST request");
			}
		}

	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

	
}
