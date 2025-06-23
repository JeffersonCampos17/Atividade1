
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
public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir(Produto produto){
       String sq1 = "INSERT INTO produto (pro_nome,pro_preco,Categoria_cat_codigo,pro_codBarras) VALUES (?,?,?,?)";
       try {
           PreparedStatement stmt = this.conn.prepareStatement(sq1);
           stmt.setString(1,produto.getNome());
           stmt.setDouble(2,produto.getPreco());
           stmt.setInt(3,produto.getCategoria());
           stmt.setString(4,produto.getCodBarra());
           stmt.execute();
           
       }catch(SQLException ex){
           System.out.println("Erro ao inserir produto : "+ ex.getMessage());
       }
    }
    public Produto getProduto(int id){
        String sql1 = "SELECT * FROM Produto WHERE pro_codigo = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            Produto p = new Produto();
            rs.first();
            p.setPk(id);
            p.setNome(rs.getString("pro_nome"));
            p.setPreco(rs.getDouble("pro_preco"));
            p.setCategoria(rs.getInt("Categoria_cat_codigo"));
            p.setCodBarra(rs.getString("pro_codBarra"));
            
            return p;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar: "+ ex.getMessage());
            return null;
            
        }
    }
    public void editar(Produto   produto){
        try{
            String sql = "UPDATE produto set pro_nome=?,pro_preco=?,pro_categoria, pro_codBarra where pro_codigo=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getPk());
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("Erro ao atualizar produto: "+ex.getMessage());
        }
    }
    public void excluir(int id){
        try {
            String sql= "delete from produto where pro_codigo=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("ERRO ao excluir produto"+ ex.getMessage());
        }
    }
    
}
