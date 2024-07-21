package com.rahul.test.mockito;

import com.rahul.test.Service.TodoService;
import com.rahul.test.impl.TodoBusinessImpl;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

    //@RunWith(MockitoJUnitRunner.class)
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    //        TodoService todoServiceMock = mock(TodoService.class);
    @Mock
    TodoService todoServiceMock;

//    TodoBusinessImpl todoBusinessImpl =
//            new TodoBusinessImpl(todoServiceMock);
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

//    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor
//            .forClass(String.class);
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedSpring_usingAMock(){
//        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }
    @Test
    public void testRetrieveTodosRelatedSpring_withEmptyList(){
//        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                List.of();
        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }
    @Test
    public void testRetrieveTodosRelatedSpring_usingBDD(){

        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy"))
                .willReturn(todos);
        //When => Actual Calling
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        //Then => assert statements
//        assertEquals(2, filteredTodos.size());
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD(){

        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy"))
                .willReturn(todos);
        //When => Actual Calling
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then => assert statements
//        verify(todoServiceMock).deleteTodo("Learn to Dance");
        //BDD style
        then(todoServiceMock).should().deleteTodo("Learn to Dance");

//        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
        //BDD style
        then(todoServiceMock).should(times(1)).deleteTodo("Learn to Dance");
//        verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");
        //BDD style
        then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to Dance");
//        verify(todoServiceMock,never()).deleteTodo("Learn Spring MVC");
        //BDD style
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
//        assertEquals(2, filteredTodos.size());
    }
    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCapture(){

        //Declare Argument Captor
        //Define Argument captor on specific method call
        //Capture the argument
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy"))
                .willReturn(todos);
        //When => Actual Calling
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then => assert statements
//        verify(todoServiceMock).deleteTodo("Learn to Dance");
        //BDD style
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }
    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes(){

        //Declare Argument Captor
        //Define Argument captor on specific method call
        //Capture the argument

        List<String> todos =
                Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy"))
                .willReturn(todos);
        //When => Actual Calling
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then => assert statements
//        verify(todoServiceMock).deleteTodo("Learn to Dance");
        //BDD style
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
