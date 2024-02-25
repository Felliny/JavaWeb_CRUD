package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProfessorServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Apenas carregar professor.jsp sem nenhum elemento
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Entrada
        String cmd = req.getParameter("botao");
        String codigo = req.getParameter("codigo");
        String nome = req.getParameter("nome");
        String titulacao = req.getParameter("titulacao");

        //Retorno
        String saida = "";
        String erro = "";
        Professor p = new Professor();
        List<Professor> professores= new ArrayList<>();

        if (cmd.contains("Listar")){
            p.setCodigo(Integer.parseInt(codigo));
        }
        if (cmd.contains("Cadastrar") || cmd.contains("Alterar")){
            p.setNome(nome);
            p.setTitulacao(titulacao);
        }
        try {
            if (cmd.contains("Cadastrar")){
                cadastrarProfessor(p);
                saida= "Professor cadastrado com sucesso";
                p= null;
            }
            if (cmd.contains("Alterar")){
                alterarProfessor(p);
                saida= "Professor alterado com sucesso";
                p= null;
            }
            if (cmd.contains("Excluir")){
                excluirProfessor(p);
                saida= "Professor excluido com sucesso";
                p= null;
            }
            if (cmd.contains("Buscar")){
                p= buscarProfessor(p);
            }
            if (cmd.contains("Listar")){
                professores= listarProfessores();
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            erro = e.getMessage();
        } finally {
            req.setAttribute("saida", saida);
            req.setAttribute("erro", erro);
            req.setAttribute("professor", p);
            req.setAttribute("professores", professores);


            RequestDispatcher rd= req.getRequestDispatcher("professor.jsp");
            rd.forward(req, resp);
        }
    }

    private void cadastrarProfessor(Professor p) throws SQLException, ClassNotFoundException {
        System.out.println(p);
    }

    private void alterarProfessor(Professor p) throws SQLException, ClassNotFoundException{
        System.out.println(p);
    }

    private void excluirProfessor(Professor p) throws SQLException, ClassNotFoundException{
        System.out.println(p.getCodigo());
    }

    private Professor buscarProfessor(Professor p) throws SQLException, ClassNotFoundException{
        p.setNome("Fulano");
        p.setTitulacao("Mestre");
        return p;
    }

    private List<Professor> listarProfessores() throws SQLException, ClassNotFoundException{
        List<Professor> professores= new ArrayList<>();

        Professor p1= new Professor();
        p1.setCodigo(10);
        p1.setNome("Beltrano");
        p1.setTitulacao("Doutor");

        Professor p2= new Professor();
        p2.setCodigo(20);
        p2.setNome("Sucrano");
        p2.setTitulacao("Mestre");

        Professor p3= new Professor();
        p3.setCodigo(30);
        p3.setNome("Teltrano");
        p3.setTitulacao("Especialista");

        professores.add(p1);
        professores.add(p2);
        professores.add(p3);

        return professores;
    }
}
