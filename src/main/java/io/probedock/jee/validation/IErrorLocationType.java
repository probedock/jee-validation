package io.probedock.jee.validation;

/**
 * Identifies a specific type of error.
 *
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
public interface IErrorLocationType {

	/**
	 * Returns the location type of the error.
	 *
	 * @return a string type
	 */
	String getLocationType();
}
