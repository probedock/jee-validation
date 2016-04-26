package io.probedock.jee.validation.preprocessing.modifier;

import static org.junit.Assert.*;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
@ProbeTestClass(tags = "modifiers")
public class TrimModifierUnitTest {

	private TrimModifier trim;
	private TestObject testObject;
	private Field valueField;

	@Before
	public void setUp() throws NoSuchFieldException {
		trim = new TrimModifier();
		testObject = new TestObject();
		valueField = testObject.getClass().getDeclaredField("value");
		valueField.setAccessible(true);
	}

	@Test
	@ProbeTest(key = "ac05669354d2")
	public void trimModifierShouldTrimLeadingAndTrailingWhitespace() {
		testObject.value = " \n  foo		";
		trim.process(testObject, valueField, mockAnnotation(false));
		assertEquals(testObject.value, "foo");
	}

	@Test
	@ProbeTest(key = "e8eeabdc0a60")
	public void trimModifierShouldCollapseWhitespace() {
		testObject.value = "foo		\n bar";
		trim.process(testObject, valueField, mockAnnotation(true));
		assertEquals(testObject.value, "foo bar");
	}

	@Test
	@ProbeTest(key = "8397e7b4b1ea")
	public void trimModifierShouldNotCollapseWhitespaceIfDisabled() {
		testObject.value = "foo		\n bar";
		trim.process(testObject, valueField, mockAnnotation(false));
		assertEquals(testObject.value, "foo		\n bar");
	}

	@Test
	@ProbeTest(key = "92537c9b3100")
	public void trimModifierShouldIgnoreNullValue() {
		testObject.value = null;
		trim.process(testObject, valueField, mockAnnotation(false));
		assertEquals(testObject.value, null);
	}

	private Trim mockAnnotation(boolean collapseWhitespace) {
		final Trim annotationMock = Mockito.mock(Trim.class);
		Mockito.when(annotationMock.collapseWhitespace()).thenReturn(collapseWhitespace);
		return annotationMock;
	}

	public static class TestObject {

		private String value;
	}
}
