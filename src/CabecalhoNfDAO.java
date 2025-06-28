
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author donks
 */
public class CabecalhoNfDAO {
    private Conexao conexao;
    private Connection conn;
    
    public CabecalhoNfDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir(CabecalhoNf cabecalho){
       String sq1 = "INSERT INTO cabecalho_nf  (data,valor_total,descricao,cli_cpf) VALUES (?,?,?,?)";/*,cli_cpf,for_cnpj,Nota_Itens_idNota_Itens*/
       try {
           PreparedStatement stmt = this.conn.prepareStatement(sq1);
           stmt.setString(1,cabecalho.getData());
           stmt.setDouble(2,cabecalho.getValoTotal());
           stmt.setString(3,cabecalho.getDescrição());
           stmt.setString(4,cabecalho.getIdCliente());
         //  stmt.setInt(5,cabecalho.getIdEmpresa());
         //  stmt.setInt(6,cabecalho.getNota_Itens_idNota_Itens());
           stmt.execute();
           
       }catch(SQLException ex){
           System.out.println("Erro ao inserir nf : "+ ex.getMessage());
       }
    }
    public CabecalhoNf getIdCabecalhoNf(int id){
        String sql1 = "SELECT * FROM Cabecalho_nf WHERE idCabecalhoNf = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            CabecalhoNf p = new CabecalhoNf();
                       
            rs.first();
            p.setIdCabecalhoNf(id);
            p.setData(rs.getString("data"));
            p.setValoTotal(rs.getDouble("valor_total"));
            p.setDescrição(rs.getString("descricao"));
                        
            return p;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar: "+ ex.getMessage());
            return null;
            
        }
    }
    public void editar(CabecalhoNf   cabecalho){
        try{
            String sql = "UPDATE produto set data=?,valor_total=?,descricao=? where idCabecalhoNf=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cabecalho.getData());
            stmt.setDouble(2, cabecalho.getValoTotal());
            stmt.setString(3, cabecalho.getDescrição());
            stmt.setInt(4, cabecalho.getIdCabecalhoNf());
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("Erro ao atualizar Cabecalho: "+ex.getMessage());
        }
    }
    public void excluir(int id){
        try {
            String sql= "delete from CabecalhoNf where idCabecalhoNf=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("ERRO ao excluir Cabecalho"+ ex.getMessage());
        }
    }
    
}
    
