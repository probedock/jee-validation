package io.probedock.jee.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Apply this annotation to an implementation of {@link AbstractValidator} to skip validation
 * when there are previous errors at the current location (in a nested structure). See the class
 * definition of {@link AbstractValidator}.
 *
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SkipValidationOnPreviousErrorsAtCurrentLocation {
}
