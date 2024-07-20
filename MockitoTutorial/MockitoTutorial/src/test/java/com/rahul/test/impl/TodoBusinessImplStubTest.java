package com.rahul.test.impl;

import com.rahul.test.Service.TodoService;
import com.rahul.test.Service.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {
    @Test
    public void testRetrieveTodosRelatedSpring_usingAStub(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = 
                new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
//        assertEquals(2, filteredTodos.size());
        assertEquals(List.of("Learn Spring MVC","Learn Spring"), filteredTodos);
    }

    @Test
    public void testRetrieveTodosRelatedSpring_usingAStub2(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }
}
