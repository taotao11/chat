package com.chat.result;

/**
 * 展示视图 与 @jsonview 同时使用
 */
public class View {
    public interface Result{};
    public interface User extends Result{}
    public  interface Admin extends Result,User{}

}
