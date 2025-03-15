package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTitulo(String titulo);

    List<Livro> findTop5ByPrecoAndDataLancamentoGreaterThan( Date dataLancamento);

    List<Livro> findDistinctByAutor( List<String> autor);

    Livro findFirstByCategoria(String categoria);

    List<Livro> findByEbookTrue(boolean ebook);

    List<Livro> findByAutorOrderByPrecoDesc(String autor);

    List<Livro> findByIdIs(long id);

    List<Livro> findByEbookIsNotNull(boolean ebook);

    List<Livro> findByAutorEndingWith(String suffix);

    List<Livro> findByAutorStartinfWith(String infux);

    List<Livro> findByAutorLike(String likePattern);

    List<Livro> findByIdLessThan(long id);

    List<Livro> findByIdGreaterThan(long id);

    List<Livro> findByDataLancamentoBetween( Date dataLancamento, Date hoje);

    List<Livro> findByTituloOrCategoriaAndAutor(String titulo, String categoria,String autor );



}
