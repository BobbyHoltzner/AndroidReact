package heron_systems.jnitestlib;

public class Test_Wrapper {


    public Test_Wrapper()
    {
        CreateTest();
    }

    // the pointer to the original C++ campus object in the heap
    private long nativeHandle;


    /**
     * Create the c++ object
     */
    public void CreateTest() { nativeHandle = JNICreateTest(); }


    /**
     * Call native method getting some string from C++
     * @return Some string
     */
    public String GetStringFromNative() { 
        return JNIGetStringFromNative(); 
    }

    /**
     * I know its weird, but Dispose has to be called since c++ is stored on heap and isn't managed.
     * There is probably a funky c++11 way to get around this but, meh
     */
    public void Dispose() { JNIdispose(); }


    //native prototypes
    private native long JNICreateTest();
    private native String JNIGetStringFromNative();
    private native void JNIdispose();



    static {
        System.loadLibrary("test_wrapper-jni");
    }
}
