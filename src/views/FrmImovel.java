/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import crud.ImovelCRUD;
import crud.UfCRUD;
import database.DatabaseFactory;
import domain.Imovel;
import domain.Uf;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class FrmImovel extends javax.swing.JFrame {

    /**
     * Creates new form FrmImovelFrame
     */
    boolean edit;

    public FrmImovel() {
        initComponents();
        try {
            edit = false;
            UfCRUD ufCrud = new UfCRUD();
            Connection conn = DatabaseFactory.getDatabase("postgres").connect();
            for (Uf uf : ufCrud.read(conn)) {
                cbUf.addItem(uf.getCodigoUf());
            }
            DatabaseFactory.getDatabase("postgres").disconnect(conn);
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
    }

    public FrmImovel(int id) {
        Connection conn = DatabaseFactory.getDatabase("postgres").connect();
        ImovelCRUD imovel = new ImovelCRUD();
        Imovel imo = null;
        UfCRUD ufCRUD = new UfCRUD();
        try {
            for (Imovel c : imovel.read(conn)) {
                if (c.getId() == id) {
                    imo = c;
                }
            }

            if (imo != null) {
                initComponents();
                this.setTitle("Editar imovel ID: " + imo.getId());
                tfId.setText(Integer.toString(imo.getId()));
                tfNome.setText(imo.getNome());
                tfBairro.setText(imo.getBairro());
                tfCep.setText(imo.getCep());
                tfRua.setText(imo.getRua());
                tfPreco.setText(Float.toString(imo.getPreco()));
                tfDescricao.setText(imo.getDescricao());
                tfMetrosQuad.setText(Float.toString(imo.getMetrosQuad()));
                tfNumero.setText(Integer.toString(imo.getNumero()));
                edit = true;
                for (Uf uf : ufCRUD.read(conn)) {
                    cbUf.addItem(uf.getCodigoUf());
                    cbUf.setSelectedItem(imo.getUf().getCodigoUf());
                }
                
            } else {
                throw new IllegalAccessError("Nenhum Cliente Encontrado");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }finally{
            DatabaseFactory.getDatabase("postgres").disconnect(conn);
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

        btCadastrar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        pnLocalizacao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbUf = new javax.swing.JComboBox<>();
        lbId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        lbRua = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        lbCep = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        pnDescricao = new javax.swing.JPanel();
        tfNumero = new javax.swing.JTextField();
        lbMetrosQuad = new javax.swing.JLabel();
        tfMetrosQuad = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescricao = new javax.swing.JTextPane();
        lbNumero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Imovel");
        setResizable(false);

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        pnLocalizacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Uf:");

        cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ES", "RJ", "SP", "MG" }));
        cbUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUfActionPerformed(evt);
            }
        });

        lbId.setText("Id:");

        tfId.setEnabled(false);

        lbRua.setText("Rua:");

        lbCep.setText("Cep");

        lbBairro.setText("Bairro");

        javax.swing.GroupLayout pnLocalizacaoLayout = new javax.swing.GroupLayout(pnLocalizacao);
        pnLocalizacao.setLayout(pnLocalizacaoLayout);
        pnLocalizacaoLayout.setHorizontalGroup(
            pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                                .addComponent(lbBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                                .addComponent(lbCep)
                                .addGap(31, 31, 31)
                                .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbRua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnLocalizacaoLayout.setVerticalGroup(
            pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLocalizacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocalizacaoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCep)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRua)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        lbNome.setText("Nome");

        pnDescricao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbMetrosQuad.setText("Qtd Metros quadrados");

        lbPreco.setText("Preço");

        lbDescricao.setText("Descrição");

        jScrollPane1.setViewportView(tfDescricao);

        lbNumero.setText("Numero");

        javax.swing.GroupLayout pnDescricaoLayout = new javax.swing.GroupLayout(pnDescricao);
        pnDescricao.setLayout(pnDescricaoLayout);
        pnDescricaoLayout.setHorizontalGroup(
            pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
            .addGroup(pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDescricaoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDescricaoLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(lbPreco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNumero)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68))
                        .addGroup(pnDescricaoLayout.createSequentialGroup()
                            .addGroup(pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDescricao)
                                .addGroup(pnDescricaoLayout.createSequentialGroup()
                                    .addComponent(lbMetrosQuad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfMetrosQuad, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6)))
                    .addContainerGap()))
        );
        pnDescricaoLayout.setVerticalGroup(
            pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDescricaoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMetrosQuad)
                        .addComponent(tfMetrosQuad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbDescricao)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPreco)
                        .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNumero)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(pnDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btSair))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        ImovelCRUD imo = new ImovelCRUD();
        Imovel imovel = new Imovel();
        UfCRUD ufcrud = new UfCRUD();
        Connection conn = DatabaseFactory.getDatabase("postgres").connect();
        try {
            if (edit) {
                imovel.setId(Integer.parseInt(tfId.getText()));
            }
            imovel.setNome(tfNome.getText());
            imovel.setMetrosQuad(Float.parseFloat(tfMetrosQuad.getText()));
            imovel.setPreco(Float.parseFloat((tfPreco.getText()).replaceAll(",", ".")));
            imovel.setDescricao(tfDescricao.getText());
            imovel.setRua(tfRua.getText());
            imovel.setNumero(Integer.parseInt(tfNumero.getText()));
            imovel.setCep(tfCep.getText());
            imovel.setBairro(tfBairro.getText());
            for (Uf uf : ufcrud.read(conn)) {
                if (uf.getCodigoUf().equals(cbUf.getSelectedItem())) {
                    imovel.setUf(uf);
                }
            }
            if (edit) {
                imo.update(conn, imovel);
            } else {
                imo.create(conn, imovel);
            }

            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }finally{
            DatabaseFactory.getDatabase("postgres").disconnect(conn);
        }
        this.dispose();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void cbUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUfActionPerformed

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
            java.util.logging.Logger.getLogger(FrmImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmImovel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbMetrosQuad;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbRua;
    private javax.swing.JPanel pnDescricao;
    private javax.swing.JPanel pnLocalizacao;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextPane tfDescricao;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfMetrosQuad;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables
}
