package org.example.todo_list.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u JOIN FETCH u.categories")
    List<Users> findAllWithCategories();
}
