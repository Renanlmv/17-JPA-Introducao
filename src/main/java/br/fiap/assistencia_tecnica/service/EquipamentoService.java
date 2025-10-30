package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;
    private final ClienteRepository clienteRepository;

    public EquipamentoService(EquipamentoRepository repository, ClienteRepository clienteRepository) {
        this.equipamentoRepository = repository;
        this.clienteRepository = clienteRepository;
    }

    public Equipamento cadastrar(EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = new Equipamento();
        equipamento.setCliente(clienteRepository.getReferenceById(equipamentoDTO.getIdCliente()));
        equipamento.setId(equipamentoDTO.getId());
        equipamento.setMarca(equipamentoDTO.getMarca());
        equipamento.setModelo(equipamentoDTO.getModelo());
        equipamento.setTipo(equipamentoDTO.getTipo());
        equipamento.setNumeroSerie(equipamentoDTO.getNumeroSerie());
        equipamento.setDataCadastro(equipamentoDTO.getDataCadastro());

        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id).orElse(null);
    }
}
