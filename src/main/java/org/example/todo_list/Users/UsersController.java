package org.example.todo_list.Users;

import jakarta.persistence.Entity;
import org.example.todo_list.Category.Category;
import org.example.todo_list.Category.CategoryDTO;
import org.example.todo_list.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Users> getAll() {
        List<Users> users = usersRepository.findAllWithCategories();
        System.out.println("Fetched Users: " + users);
        return users;
    }


    @PostMapping("/add")
    public ResponseEntity<UsersDTO> addUser(@RequestBody UsersDTO userDTO) {
        Users user = new Users(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());

        for (CategoryDTO categoryDTO : userDTO.getCategories()) {
            Category category = new Category(categoryDTO.getCategoryName(), categoryDTO.getItems());
            user.addCategory(category);  // This will correctly set the user in the category
        }

        Users savedUser = usersRepository.save(user);
        UsersDTO savedUserDTO = new UsersDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getPassword(), convertToCategoryDTOs(savedUser.getCategories()));

        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

    private List<CategoryDTO> convertToCategoryDTOs(List<Category> categories) {
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO dto = new CategoryDTO(category.getId(), category.getCategoryName(), category.getItems());
            categoryDTOs.add(dto);
        }
        return categoryDTOs;
    }
}
