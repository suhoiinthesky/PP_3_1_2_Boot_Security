package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * этот класс с эти методом мне не нужен
 * на сколько я узанал что метод этого класс просто создает
 * примитивный контроллер, без особой механики
 * просто что бы добавить обычное прелставление к примитивному контроллеру.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
