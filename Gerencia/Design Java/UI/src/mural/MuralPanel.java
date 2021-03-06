package mural;

import BancoDeDados.Conexao;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Sessao;


/**
 *
 * @author umcan
 */
public class MuralPanel extends javax.swing.JPanel {
    BancoDeDados.Conexao bd;
    int id=0;
    int x=0;
    int a=0;
    String [] usuario = new String[1];
    ResultSet retorno;
    /**
     * Creates new form MuralPanel
     */
    public MuralPanel() {
        initComponents();
        jTextArea1.setEditable(false);
        jEditorPane1.setEditable(false);
       
        bd = new Conexao();
        bd.conectar("localhost:3306", "root", "", "mural");
        //bd.conectar("cefet-inf-2015.ddns.net:43306", "mural", "inf2015", "Mural");
        
        try {
            retorno = bd.enviarQueryResultados("SELECT * FROM Mural");
            ArrayList<String> auxusuario = new ArrayList<>();
            ArrayList<String> auxdata = new ArrayList<>();
            ArrayList<String> auxconteudo = new ArrayList<>();
            
            do {
                
                auxusuario.add(retorno.getString("usuario") + "\n");
                auxdata.add(retorno.getString("data") + "\n\n");
                auxconteudo.add(retorno.getString("conteudo") + "\n________________________________________________________________________________________________________\n");
                a++;
            } while (retorno.next());

            Collections.reverse(auxusuario);
            Collections.reverse(auxdata);
            Collections.reverse(auxconteudo);
            Iterator it1 = auxusuario.iterator();
            Iterator it2 = auxdata.iterator();
            Iterator it3 = auxconteudo.iterator();
            
            while(it1.hasNext()){
                jTextArea1.append((String) it1.next());
                jTextArea1.append((String) it2.next());
                jTextArea1.append((String) it3.next());
                
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(MuralPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("VAZIO");
        }
        jTextArea1.setCaretPosition(0);
        
        

    }
    public void setNome(){
        if(Sessao.usuario!=null){
            jEditorPane1.setText(Sessao.usuario.getPrimeiroNome() + " " + Sessao.usuario.getUltimoNome());
        }else{
            jEditorPane1.setText("Anônimo");
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

        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Publicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jEditorPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String aux = new Date().toString();
        String[] mud = aux.split(" ");
        String formal = mud[2].concat(" ").concat(mud[1]).concat(" ").concat(mud[5]).concat(" às ").concat(mud[3]);
        String usuario = jEditorPane1.getText();
        String conteudo = jTextArea2.getText();
        jTextArea2.setText("");

        try {
            bd.enviarQuery("INSERT INTO Mural (usuario, data, conteudo) VALUES (\'" + usuario + "\',\'" + formal + "\', \'" + conteudo + "\')");

        } catch (SQLException Ex) {
            Logger.getLogger(MuralPanel.class.getName()).log(Level.SEVERE, null, Ex);
        }

        jTextArea1.setText("");

        try {
            retorno = bd.enviarQueryResultados("SELECT * FROM Mural");
            System.out.println(a);
            ArrayList<String> auxusuario = new ArrayList<>();
            ArrayList<String> auxdata = new ArrayList<>();
            ArrayList<String> auxconteudo = new ArrayList<>();

            do {

                auxusuario.add(retorno.getString("usuario") + "\n");
                auxdata.add(retorno.getString("data") + "\n\n");
                auxconteudo.add(retorno.getString("conteudo") + "\n________________________________________________________________________________________________________\n");
                
            } while (retorno.next());

            Collections.reverse(auxusuario);
            Collections.reverse(auxdata);
            Collections.reverse(auxconteudo);
            Iterator it1 = auxusuario.iterator();
            Iterator it2 = auxdata.iterator();
            Iterator it3 = auxconteudo.iterator();

            while (it1.hasNext()) {
                jTextArea1.append((String) it1.next());
                jTextArea1.append((String) it2.next());
                jTextArea1.append((String) it3.next());

            }

        } catch (SQLException ex) {
            Logger.getLogger(MuralPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("VAZIO");
        }
        jTextArea1.setCaretPosition(0);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
