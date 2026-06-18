package com.saepsaude.Evellen.repository;

import com.saepsaude.Evellen.model.Atividade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query("SELECT A FROM Atividade a WHETE : tipo ORDER BY a.createdAt DESC")
    Page<Atividade> findByTipoAtividade(@Param("tipo") String tipo, Pageable pageable);
   


    long countByTipoAtividade(Long usuarioId);

    @Query("SELECT COALESCE(SUM(a.quantidadeCarlorias), 0) FROM Atividade a WHERE a.usuario.id = :usuarioId")
    long sumQuantidadeCaloriasByUsuarioId(@Param("usuarioId") Long usuarioId );


}
