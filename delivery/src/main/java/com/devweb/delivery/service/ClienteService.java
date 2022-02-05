package com.devweb.delivery.service;

import java.util.List;

import com.devweb.delivery.entity.Cliente;
import com.devweb.delivery.exception.NotFoundException;
import com.devweb.delivery.repository.ClienteRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {        
        return clienteRepository.findAll();
    }

    public Cliente getClienteByUuid(String uuid) {

        Cliente c = clienteRepository.findByUuid(uuid);

        if (c == null) {
            throw new NotFoundException("Cliente não encontrado");
        }

        return c;
    }    


    public Cliente salvar(Cliente c) {
        return clienteRepository.save(c);
    }

    public boolean excluir(String uuid) {

        Cliente c = this.getClienteByUuid(uuid);

        if (c != null) {
            try {

                clienteRepository.delete(c);

                return true;
            } catch (EmptyResultDataAccessException ex) {
                System.out.println(ex.getMessage());
            }
        
        }
        return false;
    }

    public Cliente alterar(String uuid, Cliente c) {

        Cliente clienteAtual = this.getClienteByUuid(uuid);

        if (clienteAtual != null) {

            BeanUtils.copyProperties(c, clienteAtual, "id", "uuid");

            return clienteRepository.save(clienteAtual);
        }

        return null;
    }
   
    
}
