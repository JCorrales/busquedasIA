/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.ia.busquedas.main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import py.una.ia.busquedas.algoritmos.Aestrella;
import py.una.ia.busquedas.algoritmos.Avaro;
import py.una.ia.busquedas.algoritmos.CostoUniforme;
import py.una.ia.busquedas.domain.Grafo;
import py.una.ia.busquedas.domain.Nodo;
import py.una.ia.busquedas.domain.Tabla; 

/**
 *
 * @author juan
 */
public class Index extends javax.swing.JFrame {
    /**
     * Creates new form Main
     */
    public Index() {
        initComponents();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        fieldN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldMax = new javax.swing.JTextField();
        fieldOrigen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldMin = new javax.swing.JTextField();
        fieldDestino = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldTiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CRITERIO", "COSTO UNIFORME", "AVARO", "A *"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        fieldN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNActionPerformed(evt);
            }
        });

        jLabel1.setText("N:");

        jLabel2.setText("E:");

        jLabel3.setText("Min:");

        jLabel4.setText("Max:");

        fieldMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMaxActionPerformed(evt);
            }
        });

        fieldOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldOrigenActionPerformed(evt);
            }
        });

        jLabel5.setText("Origen:");

        jLabel6.setText("Destino:");

        fieldMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMinActionPerformed(evt);
            }
        });

        fieldDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDestinoActionPerformed(evt);
            }
        });

        jLabel7.setText("Tiempo:");

        fieldTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldE, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldN, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldMin, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldMax, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(fieldDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(fieldOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(fieldMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(fieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(fieldE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(fieldDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int n, e, min, max, origen, destino;
        Long tiempo;
        try{
            n = new Integer(fieldN.getText());
            e = new Integer(fieldE.getText());
            min = new Integer(fieldMin.getText());
            max = new Integer(fieldMax.getText());
            origen = new Integer(fieldOrigen.getText());
            destino = new Integer(fieldDestino.getText());
            tiempo = new Long(fieldTiempo.getText());
        }catch(Exception ex){
            jTextArea1.append(ex.getMessage());
            return;
        }
        Long start = System.currentTimeMillis();
        Grafo g = new Grafo(n, e, min, max, origen, destino);
        /*int count = 0;
        for(int fila=0; fila < g.getN(); fila++){
            for(int columna = 0; columna < g.getN(); columna++){
                if(g.getCiudades()[fila][columna] != Grafo.NO_HAY_RUTA){
                    count = count + 1;
                }
            }
        }
        jTextArea1.setText(null);
        jTextArea1.append("Aristas: "+count/2+"\n");*/
        double mayorH = Integer.MIN_VALUE;
        double menorH = Integer.MAX_VALUE;
        for(int i=0; i<g.getH().length-1; i++){
            if(g.getH()[i]> mayorH){
                mayorH = g.getH()[i];
            }
            if(g.getH()[i]< menorH){
                menorH = g.getH()[i];
            }
        }
        
        jTextArea1.append("h mayor: "+mayorH+"\n");
        jTextArea1.append("h menor: "+menorH+"\n");
        Long end = System.currentTimeMillis();
        jTextArea1.append("Tiempo en generar grafo: "+(end-start)+"\n");
        
        jTextArea1.append("************** Probando costo uniforme ****************"+"\n");
        CostoUniforme costo = new CostoUniforme(g, tiempo);
        costo.buscar();
        jTextArea1.append("Expandidos: "+Nodo.getExpandidos()+"\n");
        jTextArea1.append("Tiempo: "+costo.getTiempo()+"\n");
        if(costo.getSolucion() != null){
            jTextArea1.append("Costo: "+costo.getSolucion().getCosto()+"\n");
        }else{
            jTextArea1.append("Costo: No se encontro solucion \n");
        }
        
        Tabla t1 = new Tabla();
        t1.setCriterio("Expandidos");
        t1.setCostoUniforme(Nodo.getExpandidos()+"");
        
        
        jTextArea1.append("************** Probando avaro ****************"+"\n");
        Nodo.resetExpandidos();
        Avaro avaro = new Avaro(g, tiempo);
        avaro.buscar();
        jTextArea1.append("Expandidos: "+Nodo.getExpandidos()+"\n");
        jTextArea1.append("Tiempo: "+avaro.getTiempo()+"\n");
        if(avaro.getSolucion() != null){
            jTextArea1.append("Costo: "+avaro.getSolucion().getCosto()+"\n");
        }else{
            jTextArea1.append("Costo: No se encontro solucion \n");
        }
        
        t1.setAvaro(Nodo.getExpandidos()+"");
        
        jTextArea1.append("************** Probando A* ****************"+"\n");
        Nodo.resetExpandidos();
        Aestrella estrella = new Aestrella(g, tiempo);
        estrella.buscar();
        jTextArea1.append("Expandidos: "+Nodo.getExpandidos()+"\n");
        jTextArea1.append("Tiempo: "+estrella.getTiempo()+"\n");
        if(estrella.getSolucion() != null){
            jTextArea1.append("Costo: "+estrella.getSolucion().getCosto()+"\n");
        }else{
            jTextArea1.append("Costo: No se encontro solucion \n");
        }
        
        t1.setaEstrella(Nodo.getExpandidos()+"");
        Tabla t2 = new Tabla();
        t2.setCriterio("Tiempo");
        t2.setAvaro(avaro.getTiempo()+"");
        t2.setCostoUniforme(costo.getTiempo()+"");
        t2.setaEstrella(estrella.getTiempo()+"");
        Tabla t3 = new Tabla();
        t3.setCriterio("Costo");
        t3.setAvaro(avaro.getSolucion() == null ? "Sin solucion" : avaro.getSolucion().getCosto() +"");
        t3.setCostoUniforme(costo.getSolucion() == null ? "Sin solucion" : costo.getSolucion().getCosto() +"");
        t3.setaEstrella(estrella.getSolucion() == null ? "Sin solucion" : estrella.getSolucion().getCosto() +"");
        
        List<Tabla> tabla = new ArrayList<>();
        tabla.add(t1);
        tabla.add(t2);
        tabla.add(t3);
        
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        
        
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            try{
                model.removeRow(i);
            }catch(Exception ex){
                
            }
        }
        
        Object[] fila = new Object[model.getColumnCount()];
        for(int i=0; i< tabla.size(); i++){
            fila[0] = tabla.get(i).getCriterio();
            fila[1] = tabla.get(i).getCostoUniforme();
            fila[2] = tabla.get(i).getAvaro();
            fila[3] = tabla.get(i).getaEstrella();
            model.addRow(fila);
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNActionPerformed

    private void fieldMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMaxActionPerformed

    private void fieldOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldOrigenActionPerformed

    private void fieldMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMinActionPerformed

    private void fieldDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDestinoActionPerformed

    private void fieldTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTiempoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldDestino;
    private javax.swing.JTextField fieldE;
    private javax.swing.JTextField fieldMax;
    private javax.swing.JTextField fieldMin;
    private javax.swing.JTextField fieldN;
    private javax.swing.JTextField fieldOrigen;
    private javax.swing.JTextField fieldTiempo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
