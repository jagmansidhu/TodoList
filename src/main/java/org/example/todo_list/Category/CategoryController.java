package org.example.todo_list.Category;

import org.example.todo_list.Users.Users;
import org.example.todo_list.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //adds new category to user
    @PostMapping("/add/{id}")
    public Category addCategory(@PathVariable Long id, @RequestBody Category category) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        category.setUser(user); // Set the user for the category
        Category savedCategory = categoryRepository.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED).getBody();
    }


}
