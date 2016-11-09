package _02.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import _02.domain.Job;


@Component
public class JobValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		Job job = (Job) target;

		if (job.getId() == null) {
			errors.rejectValue("id", "required.job.id");
		}
		
		if (job.getId() != null && job.getId() > 5000 ) {
			errors.rejectValue("id", "limit.job.id");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "required.location");

		if (job.getCompany() == null) {
			errors.rejectValue("company", "required.company.name");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description");

	}

}
