/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author donks
 */
public class CabecalhoNf {
    
    private int idCabecalhoNf;
    private String data;
    private double valoTotal;
    private String descrição;
    private String idCliente;
    private String idEmpresa;
    private int Nota_Itens_idNota_Itens;

    public int getNota_Itens_idNota_Itens() {
        return Nota_Itens_idNota_Itens;
    }

    public void setNota_Itens_idNota_Itens(int Nota_Itens_idNota_Itens) {
        this.Nota_Itens_idNota_Itens = Nota_Itens_idNota_Itens;
    }

    public int getIdCabecalhoNf() {
        return idCabecalhoNf;
    }

    public void setIdCabecalhoNf(int idCabecalhoNf) {
        this.idCabecalhoNf = idCabecalhoNf;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValoTotal() {
        return valoTotal;
    }

    public void setValoTotal(double valoTotal) {
        this.valoTotal = valoTotal;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    
    
}
