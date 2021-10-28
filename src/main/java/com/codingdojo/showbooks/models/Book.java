package com.codingdojo.showbooks.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name="books" )
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;
    
    public Book() {
    }
    
    public Book(String title, String desc, String lang, int number_of_pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = number_of_pages;
    }
    
    public Book(Long id, String title, String desc, String lang, int number_of_pages) {
		this.id = id;
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = number_of_pages;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer number_of_pages) {
		this.numberOfPages = number_of_pages;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	@PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }
    
	@PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }
}
