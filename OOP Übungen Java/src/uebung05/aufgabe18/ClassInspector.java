package uebung05.aufgabe18;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;

public class ClassInspector {

	public static Method[] getMatchingMethods(Class<?> c, String pattern) throws SecurityException {
		Collection<Method> methods = new LinkedList<>();
		Method[] allMethods = c.getDeclaredMethods();
		for (Method method : allMethods) {
			if (method.getName().matches(pattern)) {
				methods.add(method);
			}
		}
		return methods.toArray(new Method[methods.size()]);
	}

	public static Method[] getMethods(Class<?> c, Class<?> returnType) {
		Collection<Method> methods = new LinkedList<>();
		Method[] allMethods = c.getDeclaredMethods();
		for (Method method : allMethods) {
			if (method.getReturnType().equals(returnType)) {
				methods.add(method);
			}
		}
		return methods.toArray(new Method[methods.size()]);
	}

	public static Method[] getMethods(Class<?> c, int modifier) {
		Collection<Method> methods = new LinkedList<>();
		Method[] allMethods = c.getDeclaredMethods();
		for (Method method : allMethods) {
			if (method.getModifiers() == modifier) {
				methods.add(method);
			}
		}
		return methods.toArray(new Method[methods.size()]);
	}

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		Method m = String.class.getDeclaredMethod("substring", int.class);
		System.out.println(m.invoke("foobar", 3));

	}
}
