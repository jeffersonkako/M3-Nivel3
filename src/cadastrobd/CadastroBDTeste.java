package cadastrobd;

import java.sql.SQLException;
import java.util.ArrayList;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;

public class CadastroBDTeste {

    public static void main(String[] args) {
        PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
        PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();

        try {
            
            PessoaFisica pf = new PessoaFisica("00033399922", null, "Teobaldo Capotino",
                    "Rua palmeiras", "Fortaleza", "CE", "8520212222", "teo@mail.com.br");

            
            if (pf.getNome() == null || pf.getNome().trim().isEmpty()) {
                System.out.println("O nome está nulo ou vazio antes da chamada de incluir.");
                return; 
            }

            
            int idPf = pfDao.incluir(pf);
            System.out.println("Pessoa Física incluída com o ID: " + idPf);

            
            pf.setCidade("Sao Paulo");
            pf.setEstado("SP");
            pfDao.alterar(pf);

            
            ArrayList<PessoaFisica> listaPf = pfDao.getPessoas();
            listaPf.forEach(pessoa -> System.out.println(pessoa.getNome()));

            
            pfDao.excluir(pf);

            
            PessoaJuridica pj = new PessoaJuridica("00333444000122", null, "Company X Ltda",
                    "Av Santos Dumont, 100", "Fortaleza", "CE", "8532215200", "empresa@empresa.com");

            
            if (pj.getNome() == null || pj.getNome().trim().isEmpty()) {
                System.out.println("O nome está nulo ou vazio antes da chamada de incluir.");
                return; 
            }

            
            int idPj = pjDao.incluir(pj);
            System.out.println("Pessoa Jurídica incluída com o ID: " + idPj);

            
            pj.setEndereco("Av Dom Luis, 1000");
            pjDao.alterar(pj);

            
            ArrayList<PessoaJuridica> listaPj = pjDao.getPessoas();
            listaPj.forEach(empresa -> System.out.println(empresa.getNome()));

            
            pjDao.excluir(pj);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pfDao.close();
                pjDao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
