package io.probedock.jee.validation.preprocessing;

import io.probedock.jee.validation.ApiErrorsException;

/**
 * Process that can be applied to an object before running data access and business operations.
 * Trimming field values and validations are implemented as preprocessors.
 *
 * <p>Preprocessors can be chained with a {@link PreprocessingChain}.</p>
 *
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
public interface IPreprocessor {

	/**
	 * Processes the specified object.
	 *
	 * @param object the object to process
	 * @param config configuration data for preprocessors
	 * @return true if preprocessing was successful
	 */
	boolean process(Object object, IPreprocessingConfig config);
}
