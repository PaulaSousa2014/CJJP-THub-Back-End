package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Office;

public interface OfficeDAO extends JpaRepository<Office, Long> {

}
