package io.probedock.jee.validation;

import java.lang.annotation.Annotation;

/**
 * Defines a constraint converter.
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public interface IConstraintConverter {
	
	/**
	 * Returns the error code, if one was set in the Annotation.
	 * 
	 * @param annotationType the annotation.
	 * @return an error code or null.
	 */
	IErrorCode getErrorCode(Class<? extends Annotation> annotationType);
	
	/**
	 * Returns the location type, if one was set in the annotation.
	 * 
	 * @param annotationType the annotation.
	 * @return a location type or null.
	 */
	IErrorLocationType getErrorLocationType(Class<? extends Annotation> annotationType);
}
