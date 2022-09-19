package com.company.entity;

public class Company {
    private Integer id;
    private String name;
    private Directory directory;

    public Company() {

    }
    public Company(String name){
        this.name = name;
    }
    public Company(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Company(String name, Directory directory) {
        this.name = name;
        this.directory = directory;
    }

    public Integer getId() {
        return id;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public Directory getDirectory() {
        return directory;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directory=" + directory +
                '}';
    }
}
