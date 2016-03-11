package com.example.modulocalculator;


public class ModuloCalculatorJni {

    public native int nativeAdd(int x, int y);

    public native int nativeSubtract(int x, int y);

    public native int nativeMultiply(int x, int y);

    public native int nativeModulo(int x, int y);

    static {
        System.loadLibrary("modulocalculator");
    }
}
