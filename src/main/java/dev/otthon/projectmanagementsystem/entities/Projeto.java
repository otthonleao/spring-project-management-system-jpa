package dev.otthon.projectmanagementsystem.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    /*
    * Quando é criado um atributo string no banco de dados o varchar tem um tamanho de 255,
    * e para termos uma capacidade indeterminada (como uma descrição), usamos o columnDefinition
    * passando o seu tipo para que a JPA crie essa coluna.
    * */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_inicio", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "cliente_id_fk", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "lider_id_fk", nullable = false)
    private Funcionario lider;

    @Column(nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal orcamento;

    @Column(nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal gastos;

    @ManyToMany
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = @JoinColumn(name = "projeto_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id_fk")
    )
    private List<Funcionario> equipe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void setLider(Funcionario lider) {
        this.lider = lider;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public BigDecimal getGastos() {
        return gastos;
    }

    public void setGastos(BigDecimal gastos) {
        this.gastos = gastos;
    }

    public List<Funcionario> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Funcionario> equipe) {
        this.equipe = equipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return Objects.equals(id, projeto.id) && Objects.equals(nome, projeto.nome) && Objects.equals(descricao, projeto.descricao) && Objects.equals(dataInicio, projeto.dataInicio) && Objects.equals(dataFim, projeto.dataFim) && Objects.equals(cliente, projeto.cliente) && Objects.equals(lider, projeto.lider) && Objects.equals(orcamento, projeto.orcamento) && Objects.equals(gastos, projeto.gastos) && Objects.equals(equipe, projeto.equipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, dataInicio, dataFim, cliente, lider, orcamento, gastos, equipe);
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", cliente=" + cliente +
                ", lider=" + lider +
                ", orcamento=" + orcamento +
                ", gastos=" + gastos +
                ", equipe=" + equipe +
                '}';
    }
}
