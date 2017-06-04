package com.test.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Data {
    private List<String> name;
    private List<Integer> value;

    public Data() {
        name = new ArrayList<String>();
        value = new ArrayList<Integer>();
    }

    public Data(List<String> name, List<Integer> value) {
        this.name = name;
        this.value = value;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Integer> getValue() {
        return value;
    }

    public void setValue(List<Integer> value) {
        this.value = value;
    }

    public void addName(String s){
        name.add(s);
    }

    public void addValue(Integer v){
        value.add(v);
    }
}
