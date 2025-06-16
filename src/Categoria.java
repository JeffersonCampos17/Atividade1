


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482321014
 */
public class Categoria {
    private int pk;
    private String nome;
    private String descricao;
    
    public Categoria (){
        
    }
    public Categoria (int pk,String nome, String descricao){
        
        this.pk = pk;
        this.nome = nome;
        this.descricao = descricao;
        
    }

    public int getPk(){
        return pk;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setNome(String nome ){
        this.nome = nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setPk(int pk){
        this.pk = pk;
    }

    
    
    
}//fim da classe 
