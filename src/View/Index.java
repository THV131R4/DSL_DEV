/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.CadModProjeto;
import View.CadModConceito;
import java.io.File;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
//import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

import org.json.simple.parser.JSONParser;
/**
 *
 * @author Vieira
 */

public class Index extends javax.swing.JFrame {

    /**
     * Creates new form Projeto
     */
    public String[] caminhoSalvo = new String[1];
    public String[] nomeNoPai = new String[1];
    private JTree tree;
    private DefaultMutableTreeNode noProjeto;
    private DefaultMutableTreeNode noConceito;
    private DefaultMutableTreeNode noDadoConceito;
    private DefaultMutableTreeNode noDadoAtributo;
    private DefaultMutableTreeNode noDadoReferencia;
    private DefaultMutableTreeNode noNomeAtributo;
    private DefaultMutableTreeNode noNomeReferencia;

    public Index()  {
        initComponents();
        caminhoSalvo[0]="C:\\Users\\Vieira\\Desktop\\PPRR";
        criarArvore();
    }

    public void criarNoProjeto(String nomeNoProjeto){
        noProjeto = new DefaultMutableTreeNode(nomeNoProjeto);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);   
    }
    
    public void criarNoConceito(String nomeNoConceito){
        noConceito = new DefaultMutableTreeNode(nomeNoConceito);
        noProjeto.add(noConceito);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarNoCategoria(String nomeNoConceito){
        noDadoConceito = new DefaultMutableTreeNode(nomeNoConceito);
        noDadoAtributo = new DefaultMutableTreeNode("Atributo(s)");
        noDadoReferencia = new DefaultMutableTreeNode("Referência(s)");
        noConceito.add(noDadoConceito);
        noConceito.add(noDadoAtributo);
        noConceito.add(noDadoReferencia);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarNoDadoConceito(String nomeConceito, String comentario, String conceitoPai){
        DefaultMutableTreeNode noNomeConceito = new DefaultMutableTreeNode("Nome: "+ nomeConceito);
        DefaultMutableTreeNode noComentario = new DefaultMutableTreeNode("Comentario: "+comentario);
        DefaultMutableTreeNode noConceitoPai = new DefaultMutableTreeNode("Herda de: "+conceitoPai);
        noDadoConceito.add(noNomeConceito);
        noDadoConceito.add(noComentario);
        noDadoConceito.add(noConceitoPai);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarNoAtributo(String nomeNoAtributo){
        noNomeAtributo = new DefaultMutableTreeNode(nomeNoAtributo);
        noDadoAtributo.add(noNomeAtributo);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarNoDadoAtributo(String nomeNoAtrib,
        String tipoAtributo,
        String valor,
        String qualificadorAtributo)
    {
        DefaultMutableTreeNode noNomeTipo = new DefaultMutableTreeNode(nomeNoAtrib+":"+tipoAtributo);
        //DefaultMutableTreeNode noTipoAtributo = new DefaultMutableTreeNode("Tipo: "+tipoAtributo);
        DefaultMutableTreeNode noValor = new DefaultMutableTreeNode("Valor: "+valor);
        DefaultMutableTreeNode noQualificadorAtributo = new DefaultMutableTreeNode("Qualificador: "+qualificadorAtributo);
        noNomeAtributo.add(noNomeTipo);
        //noNomeAtributo.add(noTipoAtributo);
        noNomeAtributo.add(noValor);
        noNomeAtributo.add(noQualificadorAtributo);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarNoReferencia(String nomeNoReferencia){
        noNomeReferencia = new DefaultMutableTreeNode(nomeNoReferencia);
        noDadoReferencia.add(noNomeReferencia);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarNoDadoReferencia(String nomeRef,
         String tipoReferencia,
         String multiplicidadeMin,
         String multiplicidadeMax,
         String qualificador)
    {
        DefaultMutableTreeNode noNomeRef= new DefaultMutableTreeNode(nomeRef+":"+tipoReferencia);
        //DefaultMutableTreeNode noTipoReferencia = new DefaultMutableTreeNode("Tipo: "+tipoReferencia);
        DefaultMutableTreeNode noMultiplicidade = new DefaultMutableTreeNode("Multiplicidade: ("+multiplicidadeMin+","+multiplicidadeMax+")");
        //DefaultMutableTreeNode noMultiplicidadeMax = new DefaultMutableTreeNode("Multiplicidade Max.:"+multiplicidadeMax);
        DefaultMutableTreeNode noQualificador = new DefaultMutableTreeNode("Qualificador"+qualificador);
        noNomeReferencia.add(noNomeRef);
        //noNomeReferencia.add(noTipoReferencia);
        noNomeReferencia.add(noMultiplicidade);
        //noNomeReferencia.add(noMultiplicidadeMax);
        noNomeReferencia.add(noQualificador);
        tree = new JTree(noProjeto);
        paneIndex1.setViewportView(tree);
    }
    
    public void criarArvore() { 
        System.out.println(caminhoSalvo[0]);
        try { 
            File arquivo = new File(caminhoSalvo[0]); 
            File[] file = arquivo.listFiles(); 
            List<Object> listaArquivos = new ArrayList<>();
            
            if(file != null){ 
                int length = file.length; 
                for(int i = 0; i < length; ++i){ 
                    File f = file[i]; 
                    if(f.isFile()){ 
                       listaArquivos.add(f.getName());
                        //System.out.println(f.getName()); 
                       //System.out.println(f.getName().); 
                    } 
                }
                //System.out.println(listaArquivos.toArray()[0]);
                //System.out.println(listaArquivos.get(1));
                //System.out.println(listaArquivos.size());
                //System.out.println(listaArquivos.contains("Project_teste.json"));
                String nomeLinguagem;
                int tam = listaArquivos.size()-1;
                for (int i=0; i<=tam; i++){
                    if(listaArquivos.get(i).toString().startsWith("Project_")){
                        Object obj = new JSONParser().parse(new FileReader(caminhoSalvo[0]+"\\"+listaArquivos.get(i).toString()));
                        System.out.println("OBJ:"+obj);
                        JSONObject jo = (JSONObject) obj;
                        nomeLinguagem = (String) jo.get("nomeLinguagem");
                        criarNoProjeto(nomeLinguagem);
                        break;
                    } else {
                       criarNoProjeto("VAZIO");
                    }
                }
                
                for (int i=0; i<=tam; i++){
                    if(listaArquivos.get(i).toString().startsWith("C_")){
                        Object obj1 = new JSONParser().parse(new FileReader(caminhoSalvo[0]+"\\"+listaArquivos.get(i).toString()));
                        JSONObject jo1 = (JSONObject) obj1;
                        //System.out.println(jo1);
                        JSONArray propConceito = (JSONArray) jo1.get("Conceito");
                        //System.out.println(propConceito.get(i));
                        JSONObject prop = (JSONObject) propConceito.get(0);
                        //System.out.println(prop.get("nomeConceito"));
                        
                        /***NOS CONCEITO***/
                        criarNoConceito((String) prop.get("nomeConceito"));
                        criarNoCategoria((String) prop.get("nomeConceito"));
                        criarNoDadoConceito((String) prop.get("nomeConceito"),
                            (String) prop.get("comentario"),
                            (String) prop.get("comentario")
                        );
                        
                        /***NOS ATRIBUTO***/
                        JSONObject atrib = (JSONObject) propConceito.get(1);
                        JSONArray atribConceito = (JSONArray) atrib.get("atributo");
                        for(int j=0;j<atribConceito.size();j++){
                            JSONObject atrib1= (JSONObject) atribConceito.get(0);
                            criarNoAtributo((String) atrib1.get("nomeAtributo"));
                            criarNoDadoAtributo((String) atrib1.get("nomeAtributo"),
                                    (String) atrib1.get("tipoAtributo"),
                                    (String) atrib1.get("valor"),
                                    (String) atrib1.get("qualificador")   
                            );
                        }
                        
                        /***NOS REFERENCIA***/
                        JSONObject refer = (JSONObject) propConceito.get(2);
                        JSONArray referConceito = (JSONArray) refer.get("referencia");
                        for(int j=0;j<referConceito.size();j++){
                            JSONObject refer1= (JSONObject) referConceito.get(0);
                            criarNoReferencia((String) refer1.get("nomeReferencia"));
                            criarNoDadoReferencia((String) refer1.get("nomeReferencia"),
                                    (String) refer1.get("tipoReferencia"),
                                    (String) refer1.get("multiplicidadeMin"),
                                    (String) refer1.get("multiplicidadeMax"),   
                                    (String) refer1.get("qualificadorReferencia")   
                            );
                        }  
                    } 
                }
            }                  
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        paneIndex1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jDialog1.setTitle("Sobre o software");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DSL_DEV");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jMenu1.setText("LOGO");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Arquivo");

        jMenu3.setText("Novo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Novo Projeto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Novo Conceito");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu2.add(jMenu3);

        jMenuItem5.setText("#Importar Projeto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("#Exportar Projeto");
        jMenu2.add(jMenuItem6);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Editar");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Projeto");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Ajuda");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem4.setText("Sobre");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneIndex1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 436, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneIndex1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        CadModProjeto tela1 = new CadModProjeto(nomeNoPai, caminhoSalvo);
        tela1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, caminhoSalvo);
        CadModConceito tela2 = new CadModConceito(caminhoSalvo[0]);
        //tela2.setSelectedIndex(1);
        tela2.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"#FALAR SOBRE PROJETO", "Sobre o DSL_Dev", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowGainedFocus

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:

        
    }//GEN-LAST:event_formFocusGained

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public javax.swing.JScrollPane paneIndex1;
    // End of variables declaration//GEN-END:variables
}
