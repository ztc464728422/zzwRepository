#include <jni.h>
#include <vector>
#include <string>
#include<sstream>
#include <ctime>
#include <android/log.h>
#include <stdexcept>
#include <pthread.h>
#include <cstdlib>
#define LOG_TAG "vectortext.cpp"
#define LOGD(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

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

void int2str(const int &int_temp,std::string &string_temp)
{
    std::stringstream stream;
    stream<<int_temp;
    string_temp=stream.str();   //此处也可以用 stream>>string_temp



}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_getCTime(JNIEnv *env, jclass type) {

    std::time_t  now = time(0);

    std::tm *ltm = localtime(&now);
    std::string s;
    int2str( (ltm->tm_year + 1900),s);
    s.append("年");
    const char* chardata =s.c_str();
    return env->NewStringUTF(chardata);

}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_getCTime2(JNIEnv *env, jclass type) {
    std::time_t  now = time(0);

    std::tm *ltm = localtime(&now);
    std::string s;
    int2str( (ltm->tm_year + 1900),s);
    s.append("年");
    const char* chardata =s.c_str();
    return env->NewStringUTF(chardata);
}


class Box
{
public :
    Box(double l=2.0, double b = 2.0, double h = 2.0){
        LOGD("Constructor called.\n");
        length = l;
        breadth = b;
        height = h;
    }
    double Volume(){
        return length*breadth*height;
    }
    int compare(Box box){
        return this->Volume() > box.Volume();
    }

private:
    double length;
    double breadth;
    double height;

};

extern "C"
JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_activity_TestActivity_thistest(JNIEnv *env, jobject instance) {

    Box Box1(3.3, 1.2, 1.5);    // Declare box1
    Box Box2(8.5, 6.0, 2.0);    // Declare box2
    if(Box1.compare(Box2)){
        LOGD("Box2 is smaller than Box1");
    }else{
        LOGD("Box2 is equal to or larger than Box1");
    }
}
class Obj {
    static int i, j;
public:
    void f() const {
//        std::string s_temp;
//        int2str(i++,s_temp);
//        s_temp.append(" is i++");
//        const char* chardata =s_temp.c_str();
//        LOGD(chardata);

        LOGD("i++ = %d\n", i++);
    }
    void g() const {    std::string s_temp;
//        int2str(j++,s_temp);
//        s_temp.append(" is j++");
//        const char* chardata =s_temp.c_str();
//        LOGD(chardata);
        LOGD("j++ = %d\n", j++);

    }
};

// 静态成员定义
int Obj::i = 10;
int Obj::j = 12;

// 为上面的类实现一个容器
class ObjContainer {
    std::vector<Obj*> a;
public:
    void add(Obj* obj)
    {
        a.push_back(obj);  // 调用向量的标准方法
    }
    friend class SmartPointer;
};

// 实现智能指针，用于访问类 Obj 的成员
class SmartPointer {
    ObjContainer oc;
    int index;
public:
    SmartPointer(ObjContainer& objc)
    {
        oc = objc;
        index = 0;
    }
    // 返回值表示列表结束
    bool operator++() // 前缀版本
    {
        if(index >= oc.a.size()) return false;
        if(oc.a[++index] == 0) return false;
        return true;
    }
    bool operator++(int) // 后缀版本
    {
        return operator++();
    }
    // 重载运算符 ->
    Obj* operator->() const
    {
        if(!oc.a[index])
        {
            LOGD("Zero value");
            return (Obj*)0;
        }
        return oc.a[index];
    }
};

extern "C"
JNIEXPORT void JNICALL
//测试重载->符号
Java_com_test_zzw_zzwapp_activity_TestActivity_testoperator(JNIEnv *env, jobject instance) {

    const int sz = 10;
    Obj o[sz];
    ObjContainer oc;
    for(int i = 0; i < sz; i++)
    {
        oc.add(&o[i]);
    }
    SmartPointer sp(oc); // 创建一个迭代器
    do {
        sp->f(); // 智能指针调用
        sp->g();
    } while(sp++);

}

using namespace std;

template <class T>
class Stack{
private:
    vector<T> elems;
public:
    void push(T const&);
    void pull();
    T top() const;
    bool empty() const{
        return elems.empty();
    }
};

template <class T>
void Stack<T>::push(T const& elem) {
    elems.push_back(elem);
}

template <class T>
void Stack<T>::pull() {
    if(elems.empty()){
        throw out_of_range("Stack<>::pop(): empty stack");
    }
    elems.pop_back();
}

template <class T>
T Stack<T>::top() const {
    if(elems.empty()){
        throw out_of_range("Stack<>::top(): empty stack");
    }
    return elems.back();
}

#define concat(a, b) a ## b

extern "C"
JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_gettrycatch(JNIEnv *env, jobject instance) {

    Stack<int> intStack;
    Stack<string> stringStack;
    intStack.push(1);
    stringStack.push("ss");

    int xy = 100;
concat(x, y);

}

#define NUM_THREADS 5

void* say_hello(void* args){
    LOGD("Hello Runoob");
}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_threadTest(JNIEnv *env, jobject instance) {

    pthread_t tids[NUM_THREADS];
    for(int i = 0 ; i< NUM_THREADS ; i++){
        int ret = pthread_create(&tids[i], NULL, say_hello, NULL);
        if (ret != 0)
        {
            LOGD("pthread_create error: error_code= %d\n", ret);
        }

    }
    //等各个线程退出后，进程才结束，否则进程强制结束了，线程可能还没反应过来；
    pthread_exit(NULL);
}


void *PrintHello(void *threadid)
{
    // 对传入的参数进行强制类型转换，由无类型指针变为整形数指针，然后再读取
    int tid = *((int*)threadid);
    LOGD("Hello Runoob! 线程 ID,  %d\n", tid);
    pthread_exit(NULL);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_activity_TestActivity_cThread(JNIEnv *env, jobject instance) {

    pthread_t threads[NUM_THREADS];
    int indexes[NUM_THREADS];// 用数组来保存i的值
    int rc;
    int i;
    for( i=0; i < NUM_THREADS; i++ ){
        LOGD("main() : 创建线程,%d\n", i);
        indexes[i] = i; //先保存i的值
        // 传入的时候必须强制转换为void* 类型，即无类型指针
        rc = pthread_create(&threads[i], NULL,
                            PrintHello, (void *)&(indexes[i]));
        if (rc){
            LOGD("Error:无法创建线程,%d\n",rc);
            exit(-1);
        }
    }
    pthread_exit(NULL);
}

struct thread_data{
    int  thread_id;
    char *message;
};

void *PrintHello2(void *threadarg)
{
    struct thread_data *my_data;

    my_data = (struct thread_data *) threadarg;
    LOGD("Thread ID :%d ", my_data->thread_id);
    LOGD("Message :%s\n", my_data->message);

    pthread_exit(NULL);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_activity_TestActivity_cThread2(JNIEnv *env, jobject instance) {

    pthread_t threads[NUM_THREADS];
    struct thread_data td[NUM_THREADS];
    int rc;
    int i;

    for( i=0; i < NUM_THREADS; i++ ){
        LOGD("main() : creating thread, %d\n", i);
        td[i].thread_id = i;
        td[i].message = "This is message";
        rc = pthread_create(&threads[i], NULL,
                            PrintHello2, (void *)&td[i]);
        if (rc){
            LOGD("Error:unable to create thread, %d\n", rc);
            exit(-1);
        }
    }
    pthread_exit(NULL);
}