package com.lixw.springboot.annotation;

import com.lixw.springboot.configuration.EnableHelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lixw
 * @date 2021/02/07
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {EnableHelloWorldConfiguration.class.getName()};
    }
}
