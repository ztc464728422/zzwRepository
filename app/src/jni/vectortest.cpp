#include <jni.h>
#include <vector>
#include <string>
#include<sstream>



const int len = 2;
int s[len] = {1,2};

int i;

extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_fromVectortest(JNIEnv *env, jclass type) {

    std::vector<int> ss(len);
    for(int i= 0 ;i  <len ; i++){
        ss.push_back((i+1)*11);
    }
    int int_temp = ss.at(len+1);
    std::stringstream stream;
    stream<<int_temp;
    std::string string_temp = stream.str();   //此处也可以用 stream>>string_temp
    // string 转 char*
    const char* chardata =string_temp.c_str();

    return env->NewStringUTF(chardata);
}