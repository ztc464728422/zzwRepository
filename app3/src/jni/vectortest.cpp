#include <jni.h>
#include <vector>
#include <string>
#include<sstream>
using namespace std;

const int len = 2;
int s[len] = {1,2};

int i;

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_fromVectortest(JNIEnv *env, jclass type) {

    vector<int> ss(len);
    ss[0] = s[0];
    ss[1] = s[1];
    int int_temp = ss.at(1);
    stringstream stream;
    stream<<int_temp;
    string string_temp = stream.str();   //此处也可以用 stream>>string_temp
    // string 转 char*
    const char* chardata =string_temp.c_str();

    return env->NewStringUTF(chardata);
}