package com.baidu.qa.util;

import java.lang.reflect.Constructor;

public class ReflectionUtil {
	public static <T> Constructor<T> getMatchedConstructor(Class<T> targetClass, Object... parameters) throws NoSuchMethodException {
		if (null == targetClass) {
			throw new IllegalArgumentException("Paramter targetClass is null.");
		}

		for (int i = 0; i < parameters.length; i++) {
			if (null == parameters[i]) {
				throw new IllegalArgumentException("Null in parameters, index: " + i);
			}
		}

		Class<?>[] parameterTypes = new Class<?>[parameters.length];
		for (int i = 0; i < parameters.length; i++) {
			parameterTypes[i] = parameters[i].getClass();
		}

		return getMatchedConstructor(targetClass, parameterTypes);
	}

	@SuppressWarnings("unchecked")
	public static <T> Constructor<T> getMatchedConstructor(Class<T> targetClass, Class<?>... parameterTypes) throws NoSuchMethodException {
		Constructor<T>[] constructors = (Constructor<T>[]) targetClass.getConstructors();
		Constructor<T> result = null;
		for (Constructor<T> constructor : constructors) {
			boolean matched = true;

			Class<?>[] consParamTypes = constructor.getParameterTypes();
			if (consParamTypes.length != parameterTypes.length) {
				continue;
			}

			for (int i = 0; i < parameterTypes.length; i++) {
				if (!consParamTypes[i].isAssignableFrom(parameterTypes[i])) {
					matched = false;
					break;
				}
			}

			if (!matched) {
				continue;
			}

			result = constructor;
			break;
		}

		if (null == result) {
			throw new NoSuchMethodException(targetClass.getName() + ".<init>" + argumentTypesToString(parameterTypes));
		}

		return result;
	}

	private static String argumentTypesToString(Class<?>[] argTypes) {
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		if (argTypes != null) {
			for (int i = 0; i < argTypes.length; i++) {
				if (i > 0) {
					buf.append(", ");
				}
				Class<?> c = argTypes[i];
				buf.append((c == null) ? "null" : c.getName());
			}
		}
		buf.append(")");
		return buf.toString();
	}
}
