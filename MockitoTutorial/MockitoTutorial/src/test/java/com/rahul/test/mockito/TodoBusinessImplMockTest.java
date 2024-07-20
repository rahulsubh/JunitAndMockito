package com.rahul.test.mockito;

import com.rahul.test.Service.TodoService;
import com.rahul.test.impl.TodoBusinessImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedSpring_usingAMock(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }
    @Test
    public void testRetrieveTodosRelatedSpring_withEmptyList(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                List.of();
        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }
}
