
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482321014
 */
public class CategoriaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public CategoriaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir(Categoria categoria){
       String sq1 = "INSERT INTO categoria (cat_nome,cat_descricao) VALUES (?,?)";
       try {
           PreparedStatement stmt = this.conn.prepareStatement(sq1);
           stmt.setString(1,categoria.getNome());
           stmt.setString(2,categoria.getDescricao());
           stmt.execute();
           
       }catch(SQLException ex){
           System.out.println("Erro ao inserir categoria : "+ ex.getMessage());
       }
    }
    /*public Categoria getCategoria(int id){
        String sql1 = "SELECT * FROM categoria WHERE cat_codigo = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            Categoria c = new Categoria();
            rs.first();
            c.setPk(id);
            c.setNome(rs.getString("cat_nome"));
            c.setDescricao(rs.getString("cat_descricao"));
            
            return c;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar: "+ ex.getMessage());
            return null;
            
        }
    }*/
    public void editar(Categoria  categoria){
        try{
            String sql = "UPDATE categoria set cat_nome=?,cat_descricao=? where cat_codigo=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3,categoria.getPk());
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("Erro ao atualizar categoria: "+ex.getMessage());
        }
    }
    public void excluir(int id){
        try {
            String sql= "delete from categoria where cat_codigo=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("ERRO ao excluir categoria"+ ex.getMessage());
        }
    }
    public List<Categoria>getCategoria(){
        String sql = "select * from categoria";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
            ResultSet rs =stmt.executeQuery();
            List<Categoria> listaCategorias = new ArrayList();
            while (rs.next()){
                Categoria c = new Categoria();
                c.setPk(rs.getInt("cat_codigo"));
                c.setNome(rs.getString("cat_nome"));
                c.setDescricao(rs.getString("cat_descricao"));
                listaCategorias.add(c);
            }
                return listaCategorias;
            }catch(SQLException ex){
                System.out.println("Erro ao consultar Categorias"+ ex.getMessage());
                return null;
            }
    }
    
}
