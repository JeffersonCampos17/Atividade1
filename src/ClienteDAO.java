
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482321014
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir(Cliente cliente){
       String sq1 = "INSERT INTO cliente (cli_cpf, cli_nome,cli_email) VALUES (?,?,?)";
       try {
           PreparedStatement stmt = this.conn.prepareStatement(sq1);
           stmt.setString(1,cliente.getCpf());
           stmt.setString(2,cliente.getNome());
           stmt.setString(3,cliente.getEmail());
           stmt.execute();
           
       }catch(SQLException ex){
           System.out.println("Erro ao inserir cliente : "+ ex.getMessage());
       }
    }
    public Cliente getCliente (String id){
        String sql1 = "SELECT * FROM cliente WHERE cli_cpf = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            Cliente c = new Cliente();
            rs.first();
            c.setCpf(id);
            c.setNome(rs.getString("cli_nome"));
            c.setEmail(rs.getString("cli_email"));
           
            
            return c;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar: "+ ex.getMessage());
            return null;
            
        }
    }
    public void editar(Cliente  cliente){
        try{
            String sql = "UPDATE cliente set cli_nome=?,cli_email=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3,cliente.getCpf());
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("Erro ao atualizar cliente: "+ex.getMessage());
        }
    }
    public void excluir(String cpf){
        try {
            String sql= "delete from cliente where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString (1 , cpf);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("ERRO ao excluir cliente"+ ex.getMessage());
        }
    }
    
}