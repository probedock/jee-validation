package io.probedock.jee.validation;

import java.lang.annotation.Annotation;

/**
 * Common functionality for modifiers (see {@link IModifier}).
 *
 * <p>When implementing a modifier, pass the annotation type to the constructor.</p>
 *
 * <pre>
 *	public class MyModifier&lt;MyAnnotation&gt; extends AbstractModifier&lt;MyAnnotation&gt; {
 *
 *		public MyModifier() {
 *			super(MyAnnotation.class);
 *		}
 *	}
 * </pre>
 *
 * @author Simon Oulevay simon.oulevay@probedock.io
 */
public abstract class AbstractModifier<T extends Annotation> implements IModifier<T> {

	private Class<T> annotationType;

	public AbstractModifier(Class<T> annotationType) {
		this.annotationType = annotationType;
	}

	@Override
	public Class<? extends Annotation> getAnnotationType() {
		return annotationType;
	}
}
