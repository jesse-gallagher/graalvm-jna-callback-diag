package com.example.graalvm.callback.jna.thirdparty;

import java.lang.reflect.Constructor;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

public class JNAReplacements {

	@TargetClass(className = "com.sun.jna.Native")
	final static class Target_Native {
		@Substitute
		public static String getWebStartLibraryPath(final String libName) {
			return null;
		}
	}
	
	@TargetClass(className = "java.io.ObjectStreamClass")
	final static class Target_ObjectStreamClass {
		@Substitute
		private static Constructor<?> getSerializableConstructor(Class<?> cl) {
			return null;
		}
	}

}
