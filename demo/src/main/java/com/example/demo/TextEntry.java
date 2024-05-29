package com.example.demo;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "pastedText")
public class TextEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TEXT", unique = true, nullable = false)
    private String content;

    @Column(name = "PREVIEW")
    private String preview;

    public TextEntry() {
    }

    public TextEntry(String content, String preview) {
        this.content = content;
        this.preview = preview;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getPreview() {
        return preview;
    }
    public void setPreview(String preview) {
        this.preview = preview;
    }
}
