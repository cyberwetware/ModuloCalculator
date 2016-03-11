#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

jint
Java_com_example_modulocalculator_ModuloCalculatorJni_nativeAdd( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return x + y;
}

jint
Java_com_example_modulocalculator_ModuloCalculatorJni_nativeSubtract( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return x - y;
}

jint
Java_com_example_modulocalculator_ModuloCalculatorJni_nativeMultiply( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    return x * y;
}

jint
Java_com_example_modulocalculator_ModuloCalculatorJni_nativeModulo( JNIEnv* env,
                                                                 jobject thiz, jint x, jint y )
{
    if((x > 0 && y > 0) || (x < 0) && (y < 0))
        return x % y;
    else if((x < 0 && y > 0))
        return -((-x) % y);
    else if((x > 0 && y < 0))
        return -(x % (-y));
}

#ifdef __cplusplus
}
#endif