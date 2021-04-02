/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.CadModConceito;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author Vieira
 */
public class Atributo {
    private String nomeAtributo;
    private String tipoAtributo;
    private String valor;
    private String qualificadorAtributo;
    private String conceitoPertencente;
 
  
    FileWriter writeFile = null;
    
    /****************************************MÉTODOS ESPECIFICO************************************************/

    /**
     * MÉTODOS ESPECIFICO
     * @param dadoAtributo
     * @param row
     * @param col
     * @return 
     */
    public JSONObject adicionarAtributo(Object[][] dadoAtributo, Integer row, Integer col){

        //Atributo atrib = new Atributo(dadoAtributo);
        //montar json
        //cria um JSONArray e preenche com valores string
        JSONObject jsonAtributo = new JSONObject();
        JSONArray objArrayAtributo = new JSONArray();
        //JSONObject objAtributo = new JSONObject();
        for(int i=0;i<row;i++){
            JSONObject objAtributo = new JSONObject();
            try {
                objAtributo.put("nomeAtributo", dadoAtributo[i][0]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                objAtributo.put("tipoAtributo", dadoAtributo[i][1]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                objAtributo.put("valor", dadoAtributo[i][2]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                objAtributo.put("qualificador", dadoAtributo[i][3]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
               
           
            System.out.println("");
            objArrayAtributo.put(objAtributo);
        }
        
        try {
            //insere o array no JSONObject com o rótulo "atributo"
            jsonAtributo.put("atributo", objArrayAtributo);
        } catch (JSONException ex) {
            Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
        } 

        String json_string = jsonAtributo.toString();
        System.out.println(json_string);
        return jsonAtributo;
        /*
        try{
            writeFile = new FileWriter("atrib"+".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(json_string);
            writeFile.close();
        } catch(IOException e){
        }//fehca catch
        */
    }
    
    private void editarAtributo(String nomeAtributo, String tipoAtributo, String valor, String qualificadorAtributo, String conceitoPertencente){}
    
    private void excluirAtributo(){}
   
    private void listarAtributo(){}
    
    /****************************************GETTERS AND SETTERS*************************************************/
    public String getQualificador() {
        return qualificadorAtributo;
    }

    public void setQualificador(String qualificadorAtributo) {
        this.qualificadorAtributo = qualificadorAtributo;
    }

    public String getNome() {
        return nomeAtributo;
    }

    public void setNome(String nomeAtributo) {
        this.nomeAtributo = nomeAtributo;
    }

    public String getTipo() {
        return tipoAtributo;
    }

    public void setTipo(String tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String getConceitoPertencente() {
        return conceitoPertencente;
    }

    public void setConceitoPertencente(String conceitoPertencente) {
        this.conceitoPertencente = conceitoPertencente;
    }
    
    
}//fecha conceito Atributo
