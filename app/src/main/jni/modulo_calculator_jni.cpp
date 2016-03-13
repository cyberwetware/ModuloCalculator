#include <jni.h>
#include "modulo_calculator.h"

#ifdef __cplusplus
extern "C" {
#endif

jint
Java_com_example_android_modulocalculator_ModuloCalculatorJni_nativeAdd( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return add(x, y);
}

jint
Java_com_example_android_modulocalculator_ModuloCalculatorJni_nativeSubtract( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return subtract(x, y);
}

jint
Java_com_example_android_modulocalculator_ModuloCalculatorJni_nativeMultiply( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return multiply(x, y);
}

jint
Java_com_example_android_modulocalculator_ModuloCalculatorJni_nativeModulo( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return modulo(x, y);
}

#ifdef __cplusplus
}
#endif