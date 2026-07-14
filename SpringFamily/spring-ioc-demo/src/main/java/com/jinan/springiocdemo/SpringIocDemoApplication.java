package com.jinan.springiocdemo;

import com.jinan.springiocdemo.controller.UserController;
import com.jinan.springiocdemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocDemoApplication.class, args);
//		UserController bean = context.getBean(UserController.class);
//		System.out.println(bean);

//		System.out.println(Introspector.decapitalize("UserController"));
//		System.out.println(Introspector.decapitalize("UController"));

//		UserController userController = (UserController) context.getBean("userController");
//		System.out.println(userController);

//		UserController userController = (UserController) context.getBean("userControllerRename");
//		System.out.println(userController);
//
//		UserController userController1 = context.getBean("userController", UserController.class);
//		System.out.println(userController1);

//		UserService bean = context.getBean(UserService.class);
//		System.out.println(bean);
//
//		UserRepository bean1 = context.getBean(UserRepository.class);
//		System.out.println(bean1);
//
//		UserConfig bean2 = context.getBean(UserConfig.class);
//		bean2.doConfiguration();
//		System.out.println(bean2);
//
//		UserComponent bean3 = context.getBean(UserComponent.class);
//		System.out.println(bean3);

//		DefaultShutdownHook bean = context.getBean(DefaultShutdownHook.class);
//		System.out.println(bean);

//		UserInfo bean1 = context.getBean("u2", UserInfo.class);
//		System.out.println(bean1);
//
//		UserInfo bean2 = context.getBean("userInfo2", UserInfo.class);
//		System.out.println(bean2);

        //DI代码
//		UserController bean = context.getBean(UserController.class);
//		bean.sayHello();

		UserService bean = context.getBean(UserService.class);
		bean.doService();
    }

}

