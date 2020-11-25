package com.centermedical.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centermedical.db.Cliente;

public interface IClientDao extends JpaRepository<Cliente, Long> {
	
}
