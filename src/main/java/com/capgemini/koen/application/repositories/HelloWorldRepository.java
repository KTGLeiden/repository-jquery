package com.capgemini.koen.application.repositories;

import com.capgemini.koen.application.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloWorldRepository extends JpaRepository<Message, Long> {
}
