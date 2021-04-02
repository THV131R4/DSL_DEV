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
public class Referencia {
    private String nomeReferencia;
    private String tipoReferencia;
    private String multiplicidadeMin;
    private String multiplicidadeMax;
    private String qualificador;
    private String conceitoPertencente;

    JSONObject jsonObject = new JSONObject();
    FileWriter writeFile = null;
    /****************************************MÉTODOS ESPECIFICOS*************************************************/
    
    /**
     * MÉTODOS ESPECIFICOS
     * @param dadoReferencia
     * @param row
     * @param col
     * @return 
     */
    public JSONObject adicionarReferencia(Object[][] dadoReferencia, Integer row, Integer col){

        //montar json
        //cria um JSONArray e preenche com valores string
        JSONObject jsonReferencia = new JSONObject();
        JSONArray objArrayReferencia = new JSONArray();
        //JSONObject objReferencia = new JSONObject();
        for(int i=0;i<row;i++){
            JSONObject objReferencia = new JSONObject();
            try {
                objReferencia.put("nomeReferencia", dadoReferencia[i][0]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                objReferencia.put("tipoReferencia", dadoReferencia[i][1]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                objReferencia.put("multiplicidadeMin", dadoReferencia[i][2]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                objReferencia.put("multiplicidadeMax", dadoReferencia[i][3]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                objReferencia.put("qualificadorReferencia", dadoReferencia[i][3]);
            } catch (JSONException ex) {
                Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
            }
               
               
           
            System.out.println("");
            objArrayReferencia.put(objReferencia);
        }
        
        try {
                  //insere o array no JSONObject com o rótulo "atributo"
                  jsonReferencia.put("referencia", objArrayReferencia);
              } catch (JSONException ex) {
                  Logger.getLogger(CadModConceito.class.getName()).log(Level.SEVERE, null, ex);
              } 
        
        String json_string = jsonReferencia.toString();
        System.out.println(json_string);
        return jsonReferencia;
        /*
        try{
            writeFile = new FileWriter("ref"+".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(json_string);
            writeFile.close();
        } catch(IOException e){
        }//fehca catch
        */
    }
    
    private void editarReferencia(String nomeReferencia, String tipoReferencia, String multiplicidadeMin, String multiplicidadeMax, String qualificador, String conceitoPertencente){}
    
    private void excluirReferencia(){}
   
    private void listarReferencia(){}
    
    /****************************************GETTERS AND SETTERS*************************************************/
    public String getNome() {
        return nomeReferencia;
    }

    public void setNome(String nomeReferencia) {
        this.nomeReferencia = nomeReferencia;
    }

    public String getTipo() {
        return tipoReferencia;
    }

    public void setTipo(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public String getMultiplicidadeMin() {
        return multiplicidadeMin;
    }

    public void setMultiplicidadeMin(String multiplicidadeMin) {
        this.multiplicidadeMin = multiplicidadeMin;
    }

    public String getMultiplicidadeMax() {
        return multiplicidadeMax;
    }

    public void setMultiplicidadeMax(String multiplicidadeMax) {
        this.multiplicidadeMax = multiplicidadeMax;
    }

    public String getQualificador() {
        return qualificador;
    }

    public void setQualificador(String qualificador) {
        this.qualificador = qualificador;
    }
    
    public String getConceitoPertencente() {
        return conceitoPertencente;
    }

    public void setConceitoPertencente(String conceitoPertencente) {
        this.conceitoPertencente = conceitoPertencente;
    }
}//fecha conceito Referencia
