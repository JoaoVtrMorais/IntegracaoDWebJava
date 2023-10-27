package ConectaMySQL;

import java.sql.*;

public class ConectaMySQL {

    private static Connection connection = null;
    private static String localBD = "localhost";
    private static String link = 
            "jdbc:mysql://" + localBD + ":3306/seupizza";
    private static final String user = "root";
    private static final String password = "Senai123";

    public Connection connectionMySql() {
        try {
            connection =
                    DriverManager.getConnection(link, user, password);
            System.out.println("conexão OK!");
        } catch (SQLException e) {
            throw new
                    RuntimeException("Ocorreu um problema na conexão com o BD", e);
        }
        return connection;
    }

     public void closeConnectionMySql(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("Fechamento OK");
            }
        } catch (SQLException e) {
            throw new 
        RuntimeException("Ocorreu um problema para encerrar "
                + "a conexão com o BD.", e);
        }
    }    
    
    public void dataBaseInsert(String nome_completo, String email, String telefone, String mensagem,
                               String contato_escolhido, String motivo_contato, boolean receber_novidades) {
        Connection connection = connectionMySql();
        String sql = "INSERT INTO contato (nome_completo, email, telefone, mensagem, contato_escolhido, motivo_contato, receber_novidades) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(sql);
            //Efetua a troca do '?' pelos valores na query
            preparedStmt.setString(1, nome_completo);
            preparedStmt.setString(2, email);
            preparedStmt.setString(3, telefone);
            preparedStmt.setString(4, mensagem);
            preparedStmt.setString(5, contato_escolhido);
            preparedStmt.setString(6, motivo_contato);
            preparedStmt.setBoolean(7, receber_novidades);
            preparedStmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void consulta(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from contato");
            System.out.println("Consulta ao banco:");
            while (rs.next()) {
                System.out.println("Nome completo: " + rs.getString(1) +
                                   " - Email: " + rs.getString(2) +
                                   " - Telefone: " + rs.getString(3) +
                                   " - Mensagem: " + rs.getString(4) +
                                   " - Contato escolhido: " + rs.getString(5) +
                                   " - Motivo de contato: " + rs.getString(6) +
                                   " - Receber novidades: " + rs.getBoolean(7));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
