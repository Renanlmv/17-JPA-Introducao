package br.fiap.assistencia_tecnica.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="JAVA_EQUIPAMENTO")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIP")
    private Long id;

    // a relação é considerada da classe atual para fora, ou seja, de Equipamento para Cliente
    // @ManyToOne - muitos (equipamentos) para um (cliente)
    // @JoinColumn para indicar que é a coluna de junção entre as tabelas
    // fetch indica o tipo de carregamento. EAGER - rápido   LAZY - apenas quando for utilizado
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_EQUIP_CLIENTE"), nullable = false)
    private Cliente cliente;

    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @Column(name = "MARCA", length = 50)
    private String marca;

    @Column(name = "MODELO", length = 50)
    private String modelo;

    @Column(name = "NUMERO_SERIE", nullable = false, length = 80)
    private String numeroSerie;

    @Column(name = "DATA_CADASTRO", nullable = false, length = 50)
    private LocalDate dataCadastro;

}
