package com.example.sandwich.model;

public class Sandwiches {

    private long id;
    private String name;
    private String type;
    private long minutes;
    private String bread;
    private String comment;


    public Sandwiches(){

    }

    public Sandwiches(Integer id, String name, String type, long minutes, String bread, String comment){
        this.id = id;
        this.name = name;
        this.type = type;
        this.minutes = minutes;
        this.bread = bread;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


