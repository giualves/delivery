package com.devweb.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import com.devweb.delivery.dto.ClienteDTO;
import com.devweb.delivery.dto.ClienteInputDTO;
import com.devweb.delivery.dto.ClienteResumoDTO;
import com.devweb.delivery.entity.Cliente;
import com.devweb.delivery.mapper.ClienteInputMapper;
import com.devweb.delivery.mapper.ClienteOutputMapper;
import com.devweb.delivery.mapper.ClienteResumoOutputMapper;
import com.devweb.delivery.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteOutputMapper clienteOutputMapper;
    @Autowired
    private ClienteInputMapper clienteInputMapper;
    @Autowired
    private ClienteResumoOutputMapper clienteResumoOutputMapper;    
    
    @GetMapping("/{uuid}")
    @ResponseBody
    public ClienteDTO getClienteById(@PathVariable String uuid) {

        Cliente c = clienteService.getClienteByUuid(uuid);

        ClienteDTO clienteDTO = clienteOutputMapper.mapearDTO(c);

        return clienteDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    private ClienteDTO adicionar(@RequestBody @Valid ClienteInputDTO clienteInputDTO) {
        Cliente c = clienteInputMapper.mapearEntity(clienteInputDTO);

        c = clienteService.salvar(c);

        ClienteDTO clienteDTO = clienteOutputMapper.mapearDTO(c);

        return clienteDTO;

    }

    @PutMapping("/{uuid}")
    @ResponseBody
    private ClienteDTO alterar(@PathVariable String uuid, @Valid @RequestBody ClienteInputDTO clienteInputDTO) {

        Cliente c = clienteInputMapper.mapearEntity(clienteInputDTO);

        c = clienteService.alterar(uuid, c);

        ClienteDTO clienteDTO = clienteOutputMapper.mapearDTO(c);

        return clienteDTO;
    }

    @DeleteMapping("/{uuid}")
    private ResponseEntity<Cliente> deletar(@PathVariable String uuid) {

        if (clienteService.excluir(uuid)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    @ResponseBody
    public List<ClienteResumoDTO> listarTodosClientes(){
        List<Cliente> clientes = clienteService.listarClientes();

        List<ClienteResumoDTO> clienteResumoDTOs = clienteResumoOutputMapper.mapearLista(clientes);

        return clienteResumoDTOs;

    }
}
