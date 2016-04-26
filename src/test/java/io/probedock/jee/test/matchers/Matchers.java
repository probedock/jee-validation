package io.probedock.jee.test.matchers;

/**
 * This helper class offers additional, custom Hamcrest matchers for our test
 * assertions.
 *
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
public class Matchers {
	public static ApiErrorResponseObjectMatcher isApiErrorResponseObject(int expectedHttpStatusCode) {
		return new ApiErrorResponseObjectMatcher(expectedHttpStatusCode);
	}
	
	public static ApiErrorsExceptionMatcher isApiErrorsException(int expectedHttpStatusCode) {
		return new ApiErrorsExceptionMatcher(expectedHttpStatusCode);
	}
}
