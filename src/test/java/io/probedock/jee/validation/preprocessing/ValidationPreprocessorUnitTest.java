package io.probedock.jee.validation.preprocessing;

import io.probedock.jee.validation.IValidationContext;
import io.probedock.jee.validation.IValidator;
import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * @see ValidationPreprocessor
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
@ProbeTestClass(tags = {"preprocessing", "validation", "validationPreprocessor"})
public class ValidationPreprocessorUnitTest {

	@Mock
	private IValidationContext context;
	@Mock
	private IPreprocessingConfig config;
	private Object objectToValidate;
	private ValidationPreprocessor preprocessor;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(config.getValidationContext()).thenReturn(context);
		objectToValidate = new Object();
		preprocessor = new ValidationPreprocessor();
	}

	@Test
	@ProbeTest(key = "56cfab281a66")
	@SuppressWarnings("unchecked")
	public void validationPreprocessorShouldNotDoAnythingWhenNoValidatorsAreRegistered() {
		when(config.getValidators()).thenReturn(Collections.EMPTY_LIST);
		assertTrue(preprocessor.process(objectToValidate, config));
	}

	@Test
	@ProbeTest(key = "46c462007c61")
	@SuppressWarnings("unchecked")
	public void validationPreprocessorShouldRunValidatorsInTheOrderTheyWereRegistered() {

		final List<IValidator> validators = Arrays.asList(mock(IValidator.class), mock(IValidator.class), mock(IValidator.class));
		when(config.getValidators()).thenReturn(validators);

		assertTrue(preprocessor.process(objectToValidate, config));

		InOrder inOrder = inOrder(validators.toArray());
		inOrder.verify(validators.get(0)).collectErrors(objectToValidate, context);
		inOrder.verify(validators.get(1)).collectErrors(objectToValidate, context);
		inOrder.verify(validators.get(2)).collectErrors(objectToValidate, context);
	}
}
