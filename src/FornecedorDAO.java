
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
public class FornecedorDAO {
    private Conexao conexao;
    private Connection conn;
    
    public FornecedorDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir(Fornecedor fornecedor){
       String sq1 = "INSERT INTO fornecedor (for_cnpj, for_nome,for_nomeFantasia) VALUES (?,?,?)";
       try {
           PreparedStatement stmt = this.conn.prepareStatement(sq1);
           stmt.setString(1,fornecedor.getCnpj());
           stmt.setString(2,fornecedor.getNome());
           stmt.setString(3,fornecedor.getNomeFantasia());
           stmt.execute();
           
       }catch(SQLException ex){
           System.out.println("Erro ao inserir fornecedor : "+ ex.getMessage());
       }
    }
    public Fornecedor getFornecedor(String id){
        String sql1 = "SELECT * FROM forncedor WHERE for_cnpj = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            Fornecedor f = new Fornecedor();
            rs.first();
            f.setCnpj(id);
            f.setNome(rs.getString("for_nome"));
            f.setNomeFantasia(rs.getString("for_nomeFantasia"));
           
            
            return f;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar: "+ ex.getMessage());
            return null;
            
        }
    }
    public void editar(Fornecedor  fornecedor){
        try{
            String sql = "UPDATE forncedor set for_nome=?,for_nomeFantasia=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNomeFantasia());
            stmt.setString(3,fornecedor.getCnpj());
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("Erro ao atualizar fornecedor: "+ex.getMessage());
        }
    }
    public void excluir(String cnpj){
        try {
            String sql= "delete from fornecedor where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString (1 , cnpj);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("ERRO ao excluir fornecedor"+ ex.getMessage());
        }
    }
    
}