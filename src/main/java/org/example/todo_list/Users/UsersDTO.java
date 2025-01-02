package org.example.todo_list.Users;

import org.example.todo_list.Category.CategoryDTO;

import java.util.List;

public class UsersDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<CategoryDTO> categories;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<CategoryDTO> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public UsersDTO() {}

    public UsersDTO(Long id, String username, String email, String password, List<CategoryDTO> categories) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.categories = categories;
    }

    // Other necessary methods...
}
