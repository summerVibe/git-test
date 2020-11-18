package my.自定义注解;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author  : J
 * @version : Jul 19, 2017  9:58:20 AM
 * explain  : http://blog.csdn.net/sunhuaqiang1/article/details/58626206
 */

// 元注解，就是注解的注解；指定这个注解可以用在什么地方；参数如下：
// TYPE: 类和接口；			FIELD: 成员变量；			METHOD: 方法；		PARAMETER: 参数声明；
// CONSTRUCTOR: 构造器；	LOCAL_VARIABLE: 局部变量；	PACKAGE: 包；		
@Target(ElementType.METHOD)

// 注解的生命周期，参数如下：
// SOURCE: 表明该注解只存在源代码当中，在编译的时候会被编译器丢掉。如重写方法时，方法上面会有@Override注解，这个注解就是source类型的。
// CLASS: 表示注解会被存到字节码文件.class中，但是虚拟机载入class文件的时候不会将注解导入，因此运行时无法得到。如果不在注解中使用Retention指定，则默认的保留策略为CLASS。
// RUNTIME: 不仅保存到class文件，还会被虚拟机载入内存，因此在运行的时候可以通过反射得到并且使用这些注解。我们待会的例子就是以RUNTIME为例。
@Retention(RetentionPolicy.RUNTIME)

// 表示子类可以继承父类的注解
@Inherited

// 表示生成doc文档的时候会包含这个注解。
@Documented


public @interface Ann {
	
	// 这里是变量，不是方法；使用方式  @Ann(name="张三",age=24)
	// 注意：成员变量只能是基本类型、String、class、enum、Annotation和以上类型的数组，而且必须是无参数、不能抛出异常。
	// 如果注解只有一个成员，这个成员必须申明为"value",(不申明为value不会报错，但是不符合规定)，使用注解时直接可以写成 @Ann("张三")
	// 如果一个成员都没有，这个注解就叫标识注解
	
	
	// 如果有默认值，则在使用时可以不写 这个变量；
	String hello() default "";
	String name();
	int age() default 18;
	
}
