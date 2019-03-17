package com.example.sirajulislamsojib.recyclerviewfromsqlitedb;

public class DataModel {
    String id;
    String name;
    String text;

    public DataModel(String id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }


}
