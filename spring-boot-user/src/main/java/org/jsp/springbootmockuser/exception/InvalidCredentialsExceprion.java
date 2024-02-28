package org.jsp.springbootmockuser.exception;

public class InvalidCredentialsExceprion extends RuntimeException {
	@Override
	public String getMessage() {
		return "invalid phone/email/password";
		
	}

}
