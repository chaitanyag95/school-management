package com.chaitanya.schoolmanagement;

import com.chaitanya.schoolmanagement.ui.forms.main.controller.MainMenuController;
import com.chaitanya.schoolmanagement.util.ui.LookAndFeelUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;
import java.util.List;

@SpringBootApplication
public class SchoolManagementApplication {
    public static void main(String[] args) {
        LookAndFeelUtils.setWindowsLookAndFeel();
        ConfigurableApplicationContext context = createApplicationContext(args);
        displayMainFrame(context);
    }

    private static ConfigurableApplicationContext createApplicationContext(String[] args) {
        return new SpringApplicationBuilder(SchoolManagementApplication.class)
                .headless(false)
                .run(args);
    }

    private static void displayMainFrame(ConfigurableApplicationContext context) {
        SwingUtilities.invokeLater(() -> {
            MainMenuController mainMenuController = context.getBean(MainMenuController.class);
            mainMenuController.prepareAndOpenFrame();
        });
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public ItemProcessor itemProcessor() {
//        return new ItemProcessor() {
//            @Override
//            public Object process(Object item) throws Exception {
//                return null;
//            }
//        };
//    }
//
//    @Bean
//    public ItemWriter itemWriter(){
//        return new ItemWriter() {
//            @Override
//            public void write(List items) throws Exception {
//
//            }
//        };
//    }
}
