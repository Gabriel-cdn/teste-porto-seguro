package teste3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

    private static Connection con;

    private static void connect() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_teste_automacao", "root", "password");
        }
    }

    private static void disconnect() throws SQLException {
        con.close();
        con = null;
    }

    public static Produto recuperarProduto() throws SQLException {
        Produto produto = null;
        connect();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from massas limit 1");
            while (rs.next()) {
                produto = new Produto(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12));
            }
        } finally {
            disconnect();
        }
        return produto;
    }

    public static void atualizarProdutoCor(String newColor) throws SQLException {
        connect();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE massas SET COLOR = '" + newColor + "'");
        } finally {
            disconnect();
        }
    }
}
