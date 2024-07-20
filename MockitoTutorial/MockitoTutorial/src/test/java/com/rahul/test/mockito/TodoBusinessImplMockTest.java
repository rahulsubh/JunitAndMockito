package com.rahul.test.mockito;

import com.rahul.test.Service.TodoService;
import com.rahul.test.impl.TodoBusinessImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;
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
    @Test
    public void testRetrieveTodosRelatedSpring_usingBDD(){

        //Given => Setup
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy"))
                .willReturn(todos);
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceMock);
        //When => Actual Calling
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        //Then => assert statements
//        assertEquals(2, filteredTodos.size());
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD(){

        //Given => Setup
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy"))
                .willReturn(todos);
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceMock);
        //When => Actual Calling
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then => assert statements
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");
        verify(todoServiceMock,never()).deleteTodo("Learn Spring MVC");
//        assertEquals(2, filteredTodos.size());
    }
}
