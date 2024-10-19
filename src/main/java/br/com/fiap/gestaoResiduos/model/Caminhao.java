package br.com.fiap.gestaoResiduos.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_caminhao")
public class Caminhao {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
    )
    @Column(name = "caminhao_id")
    private Long caminhaoId;
    private String modelo;
    @Column(name = "capacidade_maxima_litros", precision = 2)
    private Double capacidadeMaximaLitros;
    private Boolean status;

    public Caminhao() {
    }

    public Caminhao(Long caminhaoId, String modelo) {
        this.caminhaoId = caminhaoId;
        this.modelo = modelo;
        this.capacidadeMaximaLitros = 15000.00;
        this.status = true;
    }

    public Caminhao(Long caminhaoId, String modelo, Double capacidadeMaximaLitros, Boolean status) {
        this.caminhaoId = caminhaoId;
        this.modelo = modelo;
        this.capacidadeMaximaLitros = capacidadeMaximaLitros;
        this.status = status;
    }

    public Long getCaminhaoId() {
        return caminhaoId;
    }

    public void setCaminhaoId(Long caminhaoId) {
        this.caminhaoId = caminhaoId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getCapacidadeMaximaLitros() {
        return capacidadeMaximaLitros;
    }

    public void setCapacidadeMaximaLitros(Double capacidadeMaximaLitros) {
        this.capacidadeMaximaLitros = capacidadeMaximaLitros;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "caminhaoId=" + caminhaoId +
                ", modelo='" + modelo + '\'' +
                ", capacidadeMaximaLitros=" + capacidadeMaximaLitros +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caminhao caminhao)) return false;
        return Objects.equals(getCaminhaoId(), caminhao.getCaminhaoId()) && Objects.equals(getModelo(), caminhao.getModelo()) && Objects.equals(getCapacidadeMaximaLitros(), caminhao.getCapacidadeMaximaLitros()) && Objects.equals(getStatus(), caminhao.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCaminhaoId(), getModelo(), getCapacidadeMaximaLitros(), getStatus());
    }
}
