package com.snoopy.multithread.communication.methodone;

import com.snoopy.multithread.communication.Helper;


/**
 * 
 * 类名称：MethodOne.java <br>
 * 内容摘要： //说明主要功能。<br>
 * 修改备注： 利用最基本的synchronized、notify、wait<br>
 * 创建时间： 2018年4月27日下午3:12:48<br>
 * @author Snoopy.Li<br>
 */
public class MethodOne {  
    private final ThreadToGo threadToGo = new ThreadToGo();  
    public Runnable newThreadOne() {  
        final String[] inputArr = Helper.buildNoArr(52);  
        return new Runnable() {  
            private String[] arr = inputArr;  
            public void run() {  
                try {  
                    for (int i = 0; i < arr.length; i=i+2) {  
                        synchronized (threadToGo) {  
                            while (threadToGo.value == 2)  
                                threadToGo.wait();  
                            Helper.print(arr[i], arr[i + 1]);  
                            threadToGo.value = 2;  
                            threadToGo.notify();  
                        }  
                    }  
                } catch (InterruptedException e) {  
                    System.out.println("Oops...");  
                }  
            }  
        };  
    }  
    public Runnable newThreadTwo() {  
        final String[] inputArr = Helper.buildCharArr(26);  
        return new Runnable() {  
            private String[] arr = inputArr;  
            public void run() {  
                try {  
                    for (int i = 0; i < arr.length; i++) {  
                        synchronized (threadToGo) {  
                            while (threadToGo.value == 1)  
                                threadToGo.wait();  
                            Helper.print(arr[i]);  
                            threadToGo.value = 1;  
                            threadToGo.notify();  
                        }  
                    }  
                } catch (InterruptedException e) {  
                    System.out.println("Oops...");  
                }  
            }  
        };  
    }  
    class ThreadToGo {  
        int value = 1;  
    }  
    public static void main(String args[]) throws InterruptedException {  
        MethodOne one = new MethodOne();  
        Helper.instance.run(one.newThreadOne());  
        Helper.instance.run(one.newThreadTwo());  
        Helper.instance.shutdown();  
    }  
}  