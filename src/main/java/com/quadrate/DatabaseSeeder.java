package com.quadrate;

import com.quadrate.domain.Role;
import com.quadrate.domain.Student;
import com.quadrate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;

    @Autowired
    public DatabaseSeeder(PasswordEncoder passwordEncoder, StudentRepository studentRepository) {
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Creating Role
        Role studentRole = new Role();
        studentRole.setRole("STUDENT");

        Student jhone = new Student();
        jhone.setFirstName("Jhone");
        jhone.setLastName("Mark");
        jhone.setEmail("jhone@quadrate.lk");
        jhone.setPassword(passwordEncoder.encode("12345678"));
        jhone.addRole(studentRole);
        studentRepository.save(jhone);




    }
}
