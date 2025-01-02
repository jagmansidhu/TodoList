package org.example.todo_list.Category;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String categoryName;
    private List<String> items;

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

    public CategoryDTO() {}

    public CategoryDTO(Long id, String categoryName, List<String> items) {
        this.id = id;
        this.categoryName = categoryName;
        this.items = items;
    }

}
