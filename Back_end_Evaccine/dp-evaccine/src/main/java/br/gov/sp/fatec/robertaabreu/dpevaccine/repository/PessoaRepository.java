package br.gov.sp.fatec.robertaabreu.dpevaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.robertaabreu.dpevaccine.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
