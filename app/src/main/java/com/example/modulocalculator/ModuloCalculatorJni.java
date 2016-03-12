package com.example.modulocalculator;

/**
 * Created by domzjing@gmail.com on 12/03/16.
 */
public class ModuloCalculatorJni {

    public native int nativeAdd(int x, int y);

    public native int nativeSubtract(int x, int y);

    public native int nativeMultiply(int x, int y);

    public native int nativeModulo(int x, int y);

    static {
        System.loadLibrary("modulocalculator");
    }
}
