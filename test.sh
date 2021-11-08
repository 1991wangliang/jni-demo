#!bin/bash

cd src/main/java/
javah -d ../../../cpp com.lorne.jni.JNIDemo
cd ../../../cpp
gcc -fPIC -I$JAVA_HOME/include -I$JAVA_HOME/include/darwin -shared -o ../jnilib/libJNIDemo.jnilib.dylib JNIDemo.cpp
cd ../
mvn clean test
