package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Activity;



public interface ActivityDAO extends JpaRepository<Activity, Long> {

}
