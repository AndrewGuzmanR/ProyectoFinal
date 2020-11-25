package com.centermedical.service;

import java.util.List;

import com.centermedical.db.Cliente;

public interface IClienteService {
	
	public List<Cliente> listarClientes();
	
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente clienteId(Long id);
	
	public Cliente actualizarCliente(Cliente cliente);
	
	public void eliminarCliente(Long id);
}
