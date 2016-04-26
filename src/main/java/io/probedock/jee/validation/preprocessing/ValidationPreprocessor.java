package io.probedock.jee.validation.preprocessing;

import io.probedock.jee.validation.IValidationContext;
import io.probedock.jee.validation.IValidator;

/**
 * Applies all validators returned by {@link IPreprocessingConfig#getValidators()} to the processed
 * object. If the object is invalid, errors are collected into the {@link io.probedock.jee.validation.ApiErrorResponse}.
 *
 * <p>Note that the validators are guaranteed to be executed in order.</p>
 *
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
public class ValidationPreprocessor implements IPreprocessor {

	@Override
	@SuppressWarnings("unchecked")
	public boolean process(Object object, IPreprocessingConfig config) {

		// build an initial validation context (its current location is the root of the JSON document)
		final IValidationContext context = config.getValidationContext();

		// collect errors for each validator
		for (IValidator validator : config.getValidators()) {
			validator.collectErrors(object, context);
		}

		return true;
	}
}
