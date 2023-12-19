package Main;

import ConectaMongoDB.ConectaMongoDB;
import ConectaMySQL.ConectaMySQL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import org.springframework.ui.Model;

@Controller
public class WebController {

    @RequestMapping("/index")
    public String paginaPrincipalSeuPizza() {
        System.out.println("Acessando a página principal do Seu Pizza.");
        return "index";
    }

    @RequestMapping("/cardapio")
    public String cardapioSeuPizza() {
        System.out.println("Acessando a página de cardápio do Seu Pizza.");
        return "cardapio";
    }

    @RequestMapping("/contato")
    public String digaOla2 (Model modelo) {
        System.out.println("Estou no form");
        modelo.addAttribute("mensagem2", "Formulario");
        return "contato";
    } 
    
    @RequestMapping(value = "/contato2", method = RequestMethod.POST)
    public String contatoSeuPizza(Model modelo, String nome_completo, String email, String telefone, String mensagem,
                                  String contato_escolhido, String motivo_contato, boolean receber_novidades) {
        System.out.println("Acessando a página de contato do Seu Pizza.");
        
         modelo.addAttribute("mensagem3", "Seu formulário foi enviado com sucesso.");

        // Conexão com o Mongo - insere dados
        ConectaMongoDB con = new ConectaMongoDB();
        con.insertValues(nome_completo, email, telefone, mensagem, contato_escolhido, motivo_contato, receber_novidades);
        con.getValues();

        // Conexão com o MySQL - insere dados
        ConectaMySQL con2 = new ConectaMySQL();
        Connection conexao = con2.connectionMySql();
        con2.dataBaseInsert(nome_completo, email, telefone, mensagem, contato_escolhido, motivo_contato, receber_novidades);
        con2.consulta(conexao);
        return "contato2";
    }
}
