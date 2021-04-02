/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import org.json.simple.JSONObject;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Vieira
 */
public class Projeto {
    private String nomeLinguagem;
    private String dominio;
    private String autor;
    private String dataCriacao;
    private String caminhoSalvo;
    
    public Projeto(String nomeLinguagem, String dominio, String autor, String dataCriacao, String caminhoSalvo) {
        this.nomeLinguagem = nomeLinguagem;
        this.dominio = dominio;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
        this.caminhoSalvo = caminhoSalvo;
    }//fecha construtor Projeto

    JSONObject jsonObject = new JSONObject();
    FileWriter writeFile = null;


    
    /****************************************MÉTODOS ESPECIFICOS*************************************************/
    public void adicionarProjeto(){
        
        jsonObject.put("nomeLinguagem", this.nomeLinguagem);
        jsonObject.put("dominio", this.dominio);
        jsonObject.put("autor", this.autor);
        jsonObject.put("dataCriacao", this.dataCriacao);
        jsonObject.put("caminhoSalvo", this.caminhoSalvo);
		
       
        try{
            //new File("asdd").mkdir();
            //File diretorio = new File(caminhoSalvo+"\\"+nomeLinguagem);
            File diretorio = new File(caminhoSalvo);
            diretorio.mkdir();
            writeFile = new FileWriter(caminhoSalvo+"\\Project_"+nomeLinguagem+".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
        } catch(IOException e){
        }//fehca catch
    }
    
    public void editarProjeto(){
        
    }
    
    public void excluirProjeto(){
    
    }
    
    public void listarProjeto(){
    
    }
    
    
    /****************************************GETTERS AND SETTERS*************************************************/
    public String getNomeLinguagem() {
        return nomeLinguagem;
    }

    public void setNomeLinguagem(String nomeLinguagem) {
        this.nomeLinguagem = nomeLinguagem;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCaminhoSalvo() {
        return caminhoSalvo;
    }

    public void setCaminhoSalvo(String caminhoSalvo) {
        this.caminhoSalvo = caminhoSalvo;
    }
    
}//fecha conceito Projeto
