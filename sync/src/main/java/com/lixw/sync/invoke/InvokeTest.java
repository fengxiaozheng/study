package com.lixw.sync.invoke;

import com.lixw.sync.JOLTest;
import com.lixw.sync.SyncAtomicInteger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lixw
 * @date 2020/11/18
 */
public class InvokeTest {

    public static void main(String[] args) throws Exception {
        InvokeController invokeController = new InvokeController();
        Class<? extends InvokeController> integerClass = invokeController.getClass();
        InvokeService invokeService = new InvokeService();
        Field invokeServiceField = integerClass.getDeclaredField("invokeService");
        invokeServiceField.setAccessible(true);
        String invokeServiceName = invokeServiceField.getName();
        String methodName = invokeServiceName.substring(0, 1).toUpperCase() + invokeServiceName.substring(1);
        String setMethodName = "set" + methodName;
        Method method = integerClass.getMethod(setMethodName, InvokeService.class);
        method.invoke(invokeController, invokeService);
        System.out.println(invokeController.getInvokeService());
    }
}
