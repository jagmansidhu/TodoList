package org.example.todo_list.Category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.example.todo_list.Users.Users;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @ElementCollection
    private List<String> items = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    public Category() {}

    public Category(Long id, String categoryName, List<String> items) {
        this.id = id;
        this.categoryName = categoryName;
        this.items = items;

    }

    public Category(String categoryName, List<String> items) {
        this.categoryName = categoryName;
        this.items = items;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", categoryName=" + categoryName + ", items=" + items + '}';
    }

}
