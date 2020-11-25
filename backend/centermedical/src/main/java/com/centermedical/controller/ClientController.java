package com.centermedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centermedical.db.Cliente;
import com.centermedical.service.ClienteServiveImp;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClientController {
	
	@Autowired
	ClienteServiveImp clienteServiveImp;
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return clienteServiveImp.listarClientes();
	}
	
	@PostMapping("/clientes")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return clienteServiveImp.guardarCliente(cliente);
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente clienteId(@PathVariable(name = "id") Long id) {
		Cliente clienteId = new Cliente();
		clienteId = clienteServiveImp.clienteId(id);
		System.out.println("Cliente seleccionado fue: " + clienteId);
		return clienteId;
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente actualizarCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteSelect = new Cliente();
		Cliente clienteUpdate = new Cliente();
		
		clienteSelect = clienteServiveImp.clienteId(id);
		clienteSelect.setNombre(cliente.getNombre());
		clienteSelect.setTipodocumento(cliente.getTipodocumento());
		clienteSelect.setNumdocumento(cliente.getNumdocumento());
		clienteSelect.setEps(cliente.getEps());
		clienteSelect.setDireccion(cliente.getDireccion());
		clienteSelect.setTelefono(cliente.getTelefono());
		clienteSelect.setEmail(cliente.getEmail());
		clienteSelect.setEdad(cliente.getEdad());
		
		clienteUpdate = clienteServiveImp.actualizarCliente(clienteSelect);
		
		System.out.println("El cliente actualizado es: " + clienteUpdate);
		
		return clienteUpdate;
	}
	
	@DeleteMapping("/clientes/{id}")
	public void clienteDelete(@PathVariable(name = "id") Long id) {
		clienteServiveImp.eliminarCliente(id);
	}
}
