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
import org.json.simple.JSONObject;


/**
 *
 * @author Vieira
 */
public class Conceito {
    private String nomeConceito;
    private String comentario;
    private String conceitoPai;//quem ela herda
    //private Atributo atributo;
    //private Referencia referencia;

    public Conceito(String nomeConceito) {
        this.nomeConceito = nomeConceito;
    }//fecha construtor Conceito
    
    JSONObject jsonObject = new JSONObject();
    FileWriter writeFile = null;

    /****************************************MÉTODOS ESPECIFICOS*************************************************/
    public void adicionarConceito(String nomeConceito, String comentario, String conceitoPai, 
            Object[][] dadoAtributo, Integer rowAtrib, Integer colAtrib, 
            Object[][] dadoReferencia, Integer rowRef, Integer colRef, String caminhoSalvo){
       /* jsonObject.put("nomeConceito", this.nomeConceito);
        jsonObject.put("comentario", this.comentario);
        jsonObject.put("conceitoPai", this.conceitoPai);
        //   jsonObject.put("atributo", this.atributo);
        //   jsonObject.put("referencia", this.referencia);
	*/	
        JSONObject jsonConceito = new JSONObject();
        JSONArray objArrayConceito = new JSONArray();
        org.json.JSONObject objConceito = new org.json.JSONObject();
        Atributo atributo1 = new Atributo();
        Referencia referencia1 = new Referencia();
        
        try { 
            objConceito.put("nomeConceito", nomeConceito);
        } catch (JSONException ex) {
            Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            objConceito.put("comentario", comentario);
        } catch (JSONException ex) {
            Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            objConceito.put("pai", conceitoPai);
        } catch (JSONException ex) {
            Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        objArrayConceito.put(objConceito);

        objArrayConceito.put( atributo1.adicionarAtributo(dadoAtributo, rowAtrib, colAtrib));
        objArrayConceito.put(referencia1.adicionarReferencia(dadoReferencia, rowRef, colRef));
        jsonConceito.put("Conceito", objArrayConceito); 
        
        
        
        String json_string = jsonConceito.toString();
        System.out.println(json_string);
        
        
        //criarAtributo();
        //criarReferencia();
        try{
            //caminhoSalvo
            System.out.println("Estou recebendo no Conceito.java o caminho: "+caminhoSalvo);
            writeFile = new FileWriter(caminhoSalvo+"\\"+"C_"+nomeConceito+".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonConceito.toJSONString());
            writeFile.close();
        } catch(IOException e){
        }//fehca catch
        
        
    }//fecha adicionarConceito()
    
    private void editarConceito(String nome, String comentario, String conceitoPai){}
    
    private void excluirConceito(){}
   
    private void listarConceito(){}
    
    /****************************************GETTERS AND SETTERS*************************************************/
    public String getNomeConceito() {
        return nomeConceito;
    }

    public void setNome(String nomeConceito) {
        this.nomeConceito = nomeConceito;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getConceitoPai() {
        return conceitoPai;
    }

    public void setConceitoPai(String conceitoPai) {
        this.conceitoPai = conceitoPai;
    }

    
}//fecha conceito Conceito
