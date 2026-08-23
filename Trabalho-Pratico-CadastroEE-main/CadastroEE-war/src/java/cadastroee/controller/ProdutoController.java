package cadastroee.controller;

import cadastroee.model.Produto;
import cadastroee.model.ProdutoFacade;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Named(value = "produtoController")
@SessionScoped
public class ProdutoController implements Serializable {

    @EJB
    private ProdutoFacade produtoFacade;
    
    private List<Produto> listaProdutos;
    private Produto produto; // Objeto para segurar os dados da tela de cadastro

    @PostConstruct
    public void init() {
        atualizarLista();
    }

    public void atualizarLista() {
        listaProdutos = produtoFacade.findAll();
    }

    // --- Ações de Navegação e Banco de Dados ---

    public String prepararInclusao() {
        this.produto = new Produto(); // Cria um produto em branco
        return "ProdutoDados?faces-redirect=true"; // Vai pra tela de cadastro
    }

    public String prepararAlteracao(Produto p) {
        this.produto = p; // Pega o produto que o usuário clicou
        return "ProdutoDados?faces-redirect=true"; // Vai pra tela de cadastro
    }

    public String salvar() {
        if (produto.getIdProduto() == null) {
            produtoFacade.create(produto); // Se não tem ID, é novo (Insert)
        } else {
            produtoFacade.edit(produto); // Se tem ID, está alterando (Update)
        }
        atualizarLista();
        return "ProdutoLista?faces-redirect=true"; // Volta pra lista
    }

    public String excluir(Produto p) {
        produtoFacade.remove(p); // Deleta do banco
        atualizarLista();
        return "ProdutoLista?faces-redirect=true"; // Recarrega a página
    }

    // --- Getters e Setters obrigatórios ---
    
    public List<Produto> getListaProdutos() { return listaProdutos; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}