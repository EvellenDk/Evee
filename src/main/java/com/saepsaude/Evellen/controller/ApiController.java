package com.saepsaude.Evellen.controller;

import com.saepsaude.Evellen.model.Atividade;
import com.saepsaude.Evellen.repository.AtividadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Generated;

@ReadingConverter
@RequestMapping("/api")
@CrossOrigin("*")

public class ApiController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @GetMapping("/atividade")
    public ResponseEntity<Page<Atividade>> gegetAtividade(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(required = false) String tipo) {
      Pageable pageable = PageRequest.of(page, 4); // 4 por pagina
      return ResponseEntity.ok(atividadeRepository.findByTipoAtividade(tipo, pageable));
        }





    
}
