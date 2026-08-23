package cadastroee.servlets;

import cadastroee.controller.PessoaFacade;
import cadastroee.model.ProdutoFacade;
import cadastroee.controller.UsuarioFacade;
import cadastroee.model.Pessoa;
import cadastroee.model.Produto;
import cadastroee.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TesteLoader", urlPatterns = {"/TesteLoader"})
public class TesteLoader extends HttpServlet {

    @EJB
    private ProdutoFacade pf;
    @EJB
    private PessoaFacade psf;
    @EJB
    private UsuarioFacade uf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<h1>Testando a Persistência...</h1>");

            // 1. Testando Produto
            Produto p = new Produto();
            p.setNome("Produto de Teste");
            p.setQuantidade(10);
            p.setPrecoVenda(100.0f);
            pf.create(p);
            out.println("<p>Produto criado com sucesso!</p>");

            // 2. Testando Usuário
            Usuario u = new Usuario();
            u.setLogin("admin");
            u.setSenha("1234");
            uf.create(u);
            out.println("<p>Usuário criado com sucesso!</p>");

            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}