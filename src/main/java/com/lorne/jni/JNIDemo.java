package com.lorne.jni;

import com.lorne.jni.utils.LibraryUtils;

/**
 * @author lorne
 * @since 1.0.0
 */
public final class JNIDemo {


    static {
        try{
            LibraryUtils.addLibraryDir("./jnilib/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JNIDemo() {
        System.loadLibrary("JNIDemo.jnilib");
    }

    public native void hi(String msg);

    public native String getName();

}
