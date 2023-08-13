package br.com.lucas.screenmatch.controller;


import br.com.lucas.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.lucas.screenmatch.domain.filme.FilmeRepository;
import br.com.lucas.screenmatch.domain.filme.Filme;
import br.com.lucas.screenmatch.filme.DadosAlteracaoFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/*
A anotação @GetMapping é usada para mapear uma requisição HTTP GET
para um método específico, enquanto a anotação @PostMapping é usada para
mapear uma requisição HTTP POST.
 */
@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired // Com isso o Spring que vai criar o objeto e vai procurar o repository e instanciar.
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model){
        if (id != null){
            var filme = repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario"; // referenciando o HTML - formulario
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll()); // "Repository eu quero carregar todos os registros "
        return "filmes/listagem"; // referenciando o HTML - listagem
    }

    @PostMapping
    @Transactional
    public String cadastraFilme(DadosCadastroFilme dados){ //classe DadosCadastroFilme passada com o parametro dados
        var filme = new Filme(dados);

        repository.save(filme); // Ele ira fazer um insert na tabela de filme automaticamente

        return "redirect:/filmes"; // referenciando a requisição do HTML do carregaPaginaListagem - listagem
                                  // para que quando cadastar um filme, o usuario já possa ver o mesmo
    }


    @PutMapping
    @Transactional
    public String alteraFilme(DadosAlteracaoFilme dados){ //classe DadosCadastroFilme passada com o parametro dados

        var filme = repository.getReferenceById(dados.id());
        filme.atualizaDados(dados);


        return "redirect:/filmes"; // referenciando a requisição do HTML do carregaPaginaListagem - listagem
        // para que quando cadastar um filme, o usuario já possa ver o mesmo
    }

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id){
       repository.deleteById(id);
        return "redirect:/filmes";
    }



}
