package com.rahul.test.Service;

import java.util.Arrays;
import java.util.List;

// dummy implementation od todoService => Stub
//problems with stub => Dynamic conditions
public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
