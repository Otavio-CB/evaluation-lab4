package br.gov.sp.fatec.lab4.evaluationlab4.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "alt_alerta")
public class AltAlerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alt_id", nullable = false)
    private Long id;

    @Column(name = "alt_mensagem", nullable = false, length = 100)
    private String altMensagem;

    @Column(name = "alt_detalhe")
    private String altDetalhe;

    @Column(name = "alt_data_hora", nullable = false)
    private LocalDateTime altDataHora;

    @Column(name = "alt_data_hora_verificacao")
    private LocalDateTime altDataHoraVerificacao;

    @Column(name = "alt_nivel")
    private Integer altNivel;

}