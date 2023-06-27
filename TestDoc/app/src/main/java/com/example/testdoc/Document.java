package com.example.testdoc;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String title;
    private String description;
    private List<InformationEntry> informationEntries;

    public Document(String title, String description) {
        this.title = title;
        this.description = description;
        this.informationEntries = new ArrayList<>();
    }

    // Getters and setters for all the fields

    public void addInformationEntry(InformationEntry entry) {
        informationEntries.add(entry);
    }

    public void removeInformationEntry(InformationEntry entry) {
        informationEntries.remove(entry);
    }
}
