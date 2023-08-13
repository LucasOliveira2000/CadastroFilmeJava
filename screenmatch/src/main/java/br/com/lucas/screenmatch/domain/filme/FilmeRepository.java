package br.com.lucas.screenmatch.domain.filme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Long> {  //Com essa herança do Jpa teremos o CRUD = Create-Read-Update-Delete
}
