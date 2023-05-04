package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import THUBPROJECT.dto.Message;

public interface MessageDAO extends JpaRepository<Message, Long>{

}
