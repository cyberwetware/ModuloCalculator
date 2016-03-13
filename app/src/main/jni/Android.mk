# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# This NDK project Makefile only for unit testing purpose by Googletest

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := modulocalculator 
LOCAL_SRC_FILES := modulo_calculator.cpp \
    modulo_calculator_jni.cpp

include $(BUILD_SHARED_LIBRARY)


# Unit test for native functions
include $(CLEAR_VARS)
LOCAL_MODULE := modulocalculator_unittest
LOCAL_SRC_FILES := modulo_calculator_unittest.cc
LOCAL_SHARED_LIBRARIES := modulocalculator
LOCAL_STATIC_LIBRARIES := googletest_main
include $(BUILD_EXECUTABLE)

$(call import-module,third_party/googletest)
