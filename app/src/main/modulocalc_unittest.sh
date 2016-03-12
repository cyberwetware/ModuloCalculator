#!/bin/bash

adb push libs/armeabi-v7a/libgnustl_shared.so /data/local/tmp
adb push libs/armeabi-v7a/libmodulocalculator.so /data/local/tmp
adb push libs/armeabi-v7a/modulocalculator_unittest /data/local/tmp

adb shell chmod 755 /data/local/tmp/modulocalculator_unittest
adb shell /data/local/tmp/modulocalculator_unittest
adb shell "LD_LIBRARY_PATH=/data/local/tmp /data/local/tmp/modulocalculator_unittest"

