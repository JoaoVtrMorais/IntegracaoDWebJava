package ConectaMySQL;

import java.sql.*;

public class ConectaMySQL {

    private static Connection connection = null;
    private static String localBD = "localhost";
    private static String link = "jdbc:mysql://" + localBD + ":3306/seupizza";
    private static final String user = "root";
    private static final String password = "root";

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

    public void dataBaseInsert(String nome_completo, String email, int telefone, String mensagem,
                               String contato_escolhido, String motivo_contato, boolean receber_novidades) {
        Connection connection = connectionMySql();
        String sql = "INSERT INTO aluno (nome, email, codcidade) VALUES (?,?,?)";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(sql);
            //Efetua a troca do '?' pelos valores na query
            preparedStmt.setString(2, nome_completo);
            preparedStmt.setString(3, email);
            preparedStmt.setInt(4, telefone);
            preparedStmt.setString(5, mensagem);
            preparedStmt.setString(6, contato_escolhido);
            preparedStmt.setString(7, motivo_contato);
            preparedStmt.setBoolean(8, receber_novidades);
            preparedStmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
