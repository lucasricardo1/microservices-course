package com.lucasricardo.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasricardo.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
