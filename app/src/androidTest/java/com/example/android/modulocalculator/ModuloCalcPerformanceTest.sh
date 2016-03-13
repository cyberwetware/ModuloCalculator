#!/bin/bash

# Clean previous logcat messages
adb logcat -c

# Execute performance test for modulocalculator
adb shell monkey -p com.example.android.modulocalculator -v 1000 --monitor-native-crashes

# Generate logcat file for analysising
adb logcat -v time -d > logcat-modulocalculator.txt

