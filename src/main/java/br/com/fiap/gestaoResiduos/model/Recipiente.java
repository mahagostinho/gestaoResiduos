package br.com.fiap.gestaoResiduos.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_recipiente")
public class Recipiente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_RECIPIENTE"
    )
    @SequenceGenerator(
            name = "SEQ_RECIPIENTE",
            sequenceName = "SEQ_RECIPIENTE",
            allocationSize = 50
    )
    @Column(name = "recipiente_id")
    private Long recipienteId;
    @Column(name = "volume_atual_litros")
    private Double volumeAtualLitros;
    @Column(name = "volume_total_litros")
    private Double volumeTotalLitros;
    private String status;

    public Recipiente() {
    }

    public Recipiente(Long recipienteId) {
        this.recipienteId = recipienteId;
        this.volumeAtualLitros = 0.0;
        this.volumeTotalLitros = 3000.00;

    }

    public Recipiente(Long recipienteId, Double volumeAtualLitros, Double volumeTotalLitros, String status) {
        this.recipienteId = recipienteId;
        this.volumeAtualLitros = volumeAtualLitros;
        this.volumeTotalLitros = volumeTotalLitros;
        this.status = status;
    }

    public Long getRecipienteId() {
        return recipienteId;
    }

    public void setRecipienteId(Long recipienteId) {
        this.recipienteId = recipienteId;
    }

    public Double getVolumeAtualLitros() {
        return volumeAtualLitros;
    }

    public void setVolumeAtualLitros(Double volumeAtualLitros) {
        this.volumeAtualLitros = volumeAtualLitros;
    }

    public Double getVolumeTotalLitros() {
        return volumeTotalLitros;
    }

    public void setVolumeTotalLitros(Double volumeTotalLitros) {
        this.volumeTotalLitros = volumeTotalLitros;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Recipiente{" +
                "recipienteId=" + recipienteId +
                ", volumeAtualLitros=" + volumeAtualLitros +
                ", volumeTotalLitros=" + volumeTotalLitros +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipiente that)) return false;
        return Objects.equals(getRecipienteId(), that.getRecipienteId()) && Objects.equals(getVolumeAtualLitros(), that.getVolumeAtualLitros()) && Objects.equals(getVolumeTotalLitros(), that.getVolumeTotalLitros()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipienteId(), getVolumeAtualLitros(), getVolumeTotalLitros(), getStatus());
    }
}
