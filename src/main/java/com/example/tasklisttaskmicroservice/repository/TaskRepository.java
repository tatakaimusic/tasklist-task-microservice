package com.example.tasklisttaskmicroservice.repository;

import com.example.tasklisttaskmicroservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = """
                        SELECT * FROM tasks t 
                        JOIN users u on u.email = t.user_email
                        WHERE u.email = :userEmail
            """, nativeQuery = true)
    Optional<List<Task>> getAllByUserEmail(String userEmail);
}
