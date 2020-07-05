//package by.learn.mainmicro.aspect;
//
//import by.learn.mainmicro.dto.UserDTOMain;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//
//    @Before(value = "target(by.learn.mainmicro.MainControllerAsp)")
//    public void userCreationMethods() {
//        System.out.println(" created");
//    }
//
//    @Before(value = "execution(* by.learn.mainmicro.MainController.createUser(*)) && args(userDTOMain)")
//    public void userCreationMethod(UserDTOMain userDTOMain) {
//        System.out.println(userDTOMain + " created");
//    }
//}
