package com.bytehonor.sdk.server.bytehonor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.bytehonor.sdk.server.bytehonor.config.SpringCloudStandardConfiguration;

/**
 * 启动注解，引入自定义Bean
 * 
 * @author lijianqiang
 *
 */
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SpringCloudStandardConfiguration.class)
public @interface SpringCloudStandard {

}
