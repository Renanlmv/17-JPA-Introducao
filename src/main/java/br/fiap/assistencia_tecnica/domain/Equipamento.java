package br.fiap.assistencia_tecnica.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @Column(name = "MARCA", nullable = false, length = 50)
    private String marca;

    @Column(name = "MODELO", nullable = false, length = 50)
    private String modelo;

    @Column(name = "NUMERO_SERIE", nullable = false, length = 80)
    private String numeroSerie;

    @Column(name = "DATA_CADASTRO", nullable = false, length = 50)
    private LocalDate dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
