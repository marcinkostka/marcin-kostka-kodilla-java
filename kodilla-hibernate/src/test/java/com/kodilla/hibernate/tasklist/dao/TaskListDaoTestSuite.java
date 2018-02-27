package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.task.TaskList;
import com.kodilla.hibernate.task.dao.TaskListDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Hibernate","13.2 Kodilla Module");
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> taskListsByName = taskListDao.findByListName(listName);

        //Then
        Assert.assertEquals(1, taskListsByName.size());
        Assert.assertEquals("Hibernate", taskListsByName.get(0).getListName());

        //CleanUp
        int id = taskListsByName.get(0).getId();
        taskListDao.delete(id);
    }
}