package com.rahul.test.Service;

import java.util.List;

// External Service - Lets say this comes from WunderList
//create todoServiceStub
// test todoBusinessImpl using todoServiceStub
public interface TodoService {
    public List<String> retrieveTodos(String user);
}