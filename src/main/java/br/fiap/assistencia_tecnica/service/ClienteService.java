package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.web.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(ClienteDTO clienteDTO) {

        // pegando os dados do DTO e passando para o objeto Cliente domain
        // para ser salvo no banco de dados
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(clienteDTO.getSenha());
        cliente.setTelefone(clienteDTO.getTelefone());

        // salvando no banco de dados atraves da variavel
        // do JpaRepository
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


}
