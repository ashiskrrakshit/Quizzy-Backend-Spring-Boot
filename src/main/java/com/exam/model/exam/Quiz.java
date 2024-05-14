package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.* ;

//import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long qid;
    private  String title;
    
    @Column(length = 5000)
    private  String description;
    
    private  boolean active=false; 
    private String maxMarks;
    private  String noOfQuestions;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private  Category category;
    

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question>questions =new HashSet<>();
    
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public long getQid() {
        return qid;
    }

    public void setQid(long qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(String noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    

    public Quiz() {
    }

    public Quiz(long qid, String title, String description, boolean active, String maxMarks, String noOfQuestions,
            Category category, Set<Question> questions) {
        this.qid = qid;
        this.title = title;
        this.description = description;
        this.active = active;
        this.maxMarks = maxMarks;
        this.noOfQuestions = noOfQuestions;
        this.category = category;
        // this.results = results;
        this.questions = questions;
    }

    
}