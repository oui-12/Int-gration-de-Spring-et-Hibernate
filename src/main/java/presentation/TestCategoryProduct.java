package presentation;

import metier.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class TestCategoryProduct {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        TestService testService = context.getBean(TestService.class);
        testService.runTest();
    }
}

