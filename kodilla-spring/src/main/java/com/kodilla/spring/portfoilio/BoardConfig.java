package com.kodilla.spring.portfoilio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Bean
    public Board board() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }

    @Bean
    //@Bean(name = "toDoList")
    //@Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean
    //@Bean(name = "inProgressList")
    //@Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean
    //@Bean(name = "doneList")
    //@Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }
}
