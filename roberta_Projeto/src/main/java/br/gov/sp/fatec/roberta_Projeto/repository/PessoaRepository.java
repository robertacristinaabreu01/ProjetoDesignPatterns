package br.gov.sp.fatec.roberta_Projeto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.roberta_Projeto.domain.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
