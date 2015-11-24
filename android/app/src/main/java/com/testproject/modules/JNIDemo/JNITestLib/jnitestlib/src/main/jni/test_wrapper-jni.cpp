/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
#include <string>
#include <jni.h>
#include <stdexcept>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCSimplifyInspection"

typedef int SOME_C_OBJECT;

extern "C"
{


JNIEXPORT jlong JNICALL
Java_heron_1systems_jnitestlib_Test_1Wrapper_JNICreateTest(JNIEnv *env, jobject thiz)
{
    long *lp = (long*)new SOME_C_OBJECT();
    return (long)lp;
}

JNIEXPORT jstring JNICALL
Java_heron_1systems_jnitestlib_Test_1Wrapper_JNIGetStringFromNative(JNIEnv *env, jobject thiz)
{
    //convert to java string and return
    jstring Name_java_str = env->NewStringUTF("Hello from C++");
    return Name_java_str;
}


JNIEXPORT void JNICALL
Java_heron_1systems_jnitestlib_Test_1Wrapper_JNIdispose(JNIEnv *env, jobject thiz)
{
    // getting the C++ pointer from the Java object

    // find the ItineraryWrapperClass
    jclass itinerary_wrapper_jclass = env->GetObjectClass(thiz);
    // find the nativeHandle field ID
    jfieldID native_handle_field_id = env->GetFieldID(itinerary_wrapper_jclass, "nativeHandle", "J"); // J is the type signature for long
    SOME_C_OBJECT *it = (SOME_C_OBJECT*)env->GetLongField(thiz, native_handle_field_id);

    delete it;
}



}

#pragma clang diagnostic pop