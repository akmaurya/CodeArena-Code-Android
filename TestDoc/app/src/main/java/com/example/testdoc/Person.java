package com.example.testdoc;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String gender;
    private String dob;
    private String contactNumber;
    private List<Document> documents;

    public Person(String name, String gender, String dob, String contactNumber) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.contactNumber = contactNumber;
        this.documents = new ArrayList<>();
    }

    // Getters and setters for all the fields

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
    }
}