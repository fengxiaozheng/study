package com.lixw.sync.invoke;

import com.sun.tools.javac.util.Assert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author lixw
 * @date 2020/11/18
 */
public class AnnotationTest {

    public static void main(String[] args) {
        InvokeController invokeController = new InvokeController();
        Class<? extends InvokeController> controllerClass = invokeController.getClass();
        Arrays.stream(controllerClass.getDeclaredFields()).forEach(field -> {
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    Object o = type.newInstance();
                    field.set(invokeController, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(invokeController.getInvokeService());

        String sd = "99.88";
        NumberFormat numberFormat = DecimalFormat.getNumberInstance();
        try {
            System.out.println("numberFormat.parse(sd) = " + numberFormat.parse(sd).toString());
            String s = numberFormat.parse(sd).toString();
            String s1 = new BigDecimal(2300L).multiply(new BigDecimal(s)).divide(new BigDecimal("100")).toString();
            System.out.println("s1 = " + s1);
            System.out.println(new BigDecimal("24.662").divide(new BigDecimal(2), 2, BigDecimal.ROUND_UP).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
