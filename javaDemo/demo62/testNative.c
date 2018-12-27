#include "TestNative.h"

JNIEXPORT jint JNICALL Java_TestNative_methodDemo
  (JNIEnv * env, jobject obj, jint a, jint b) {
      return (a > b ? a: b);
      /* gcc -I C:\PROGRA~1\Java\jdk1.8.0_102\include -I C:\PROGRA~1\Java\jdk1.8.0_102\include\win32 -shared -Wl,–kill-at -s -o Hello.dll HelloJni.c */
      /* gcc -shared  -s -o .\testNative.dll -c .\testNative.c -I D:\JAVA\include\ -I D:\JAVA\include\win32\ */
      /* mingw-w64 ??64? dll */
  }