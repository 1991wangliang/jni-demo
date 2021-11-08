package com.lorne.jni;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author lorne
 * @since 1.0.0
 */
class JNIDemoTest {

    @Test
    void hi(){
        JNIDemo jniDemo = new JNIDemo();
        jniDemo.hi("小明");
    }

    @Test
    void getName(){
        JNIDemo jniDemo = new JNIDemo();
        String name = jniDemo.getName();
        assertTrue("lorne".equalsIgnoreCase(name),"get name error.");
    }

}
