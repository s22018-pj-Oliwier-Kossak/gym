package com.example.gym;


import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Person,Long> {

}
