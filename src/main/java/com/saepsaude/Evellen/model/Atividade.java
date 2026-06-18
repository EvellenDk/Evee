package com.saepsaude.Evellen.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_atividades")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoAtividade;
    private Double distanciaPercorrida;
    private Integer duracaoAtividade;
    private Integer quantidadeCalorias;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
