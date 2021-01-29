package com.example.graalvm.callback;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;

@SuppressWarnings("nls")
public class Main {
	public interface ExampleLibrary extends Library {
		void callme(CallMeFunc func);
		int callmebasic(int somearg);
	}
	public interface CallMeFunc extends Callback {
		void invoke(long somearg);
	}

	public static void main(String[] args) {
		try {
			System.out.println("Loaded into Main");
			ExampleLibrary api = Native.load("examplecallback", ExampleLibrary.class);
			System.out.println("Calling the non-callback function: " + api.callmebasic(8));
			api.callme(somearg -> System.out.println("Callback called with " + somearg));
			System.out.println("Finished execution normally");
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}

}
