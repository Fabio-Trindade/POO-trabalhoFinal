/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AlunoController;
import controller.ProfessorController;
import controller.UsuarioController;
import exceptions.ContratoEtapaNaoEncontrada;
import exceptions.UsuarioNaoEncontradoException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Contrato;
import model.ContratoEtapa;
import model.Usuario;
import persistence.local.AulaDAO;
import persistence.local.AvaliacaoDAO;
import persistence.local.ContratoDAO;
import persistence.local.DisciplinaDAO;
import persistence.local.TopicoDAO;
import persistence.local.UsuarioDAO;

/**
 *
 * @author dener
 */
public class ContratosAceitosView extends javax.swing.JPanel {
    
    private JFrame context;
    private Usuario user;
    private ProfessorController professorController;
    private AlunoController alunoController;
    private List<Contrato> allContratos;
    private int index;
    
    /**
     * Creates new form ContratosPendentesView
     */
    public ContratosAceitosView(JFrame context, Usuario user) {
        initComponents();
        this.context = context;
        this.user = user;
        this.index = 0;
        this.professorController = new ProfessorController(new AulaDAO(), 
                new TopicoDAO(), new UsuarioDAO(), new DisciplinaDAO(), new ContratoDAO());
        this.alunoController = new AlunoController(new ContratoDAO(), new UsuarioDAO(), new AulaDAO());
        
        if (this.user.getTipoUsuario() == 1) {
            try {
                this.allContratos = professorController.getContratosAceitos(this.user.getUsername());
            } catch(Exception e) {

            }
        } else {
            try {
                this.allContratos = alunoController.getContratosByEtapa(this.user.getUsername(), ContratoEtapa.ACEITO);
            } catch (Exception e) {
            } 
        }
        updateView();
        
    }
    
    private void updateView() {
        if(this.allContratos.size() == 0) {
            this.posicao.setText("0 de 0");
            this.nomeAluno.setText("--");
            this.disciplinaAula.setText("--");
        } else {
            this.posicao.setText((index+1) + " de " + this.allContratos.size());
            
            if (this.user.getTipoUsuario() == 0) {
                this.jLabel2.setText("Professor:");
                this.nomeAluno.setText(this.allContratos.get(index).getAula().getProfessor().getNome());
            } else {
                this.nomeAluno.setText(this.allContratos.get(index).getAluno().getNome());
            }
            this.disciplinaAula.setText(this.allContratos.get(index).getAula().getDisciplina().getNome());
        }
        
        if(index > 0) {
            this.anterior.setEnabled(true);
        } else {
            this.anterior.setEnabled(false);
        }
        
        if(index < allContratos.size()-1) {
            this.proximo.setEnabled(true);
        } else {
            this.proximo.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomeAluno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        disciplinaAula = new javax.swing.JLabel();
        anterior = new javax.swing.JButton();
        posicao = new javax.swing.JLabel();
        proximo = new javax.swing.JButton();
        avaliar_botao = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Notificações");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Aluno:");

        nomeAluno.setText("--");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Aula:");

        disciplinaAula.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomeAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(disciplinaAula, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeAluno)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disciplinaAula)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        anterior.setText("anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        posicao.setText("1 de 10");

        proximo.setText("próximo");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        avaliar_botao.setText("Avaliar");
        avaliar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaliar_botaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(posicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(anterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proximo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(avaliar_botao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anterior)
                    .addComponent(proximo)
                    .addComponent(avaliar_botao))
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        index--;
        updateView();
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        index++;
        updateView();
    }//GEN-LAST:event_proximoActionPerformed

    private void avaliar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaliar_botaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avaliar_botaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton avaliar_botao;
    private javax.swing.JLabel disciplinaAula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeAluno;
    private javax.swing.JLabel posicao;
    private javax.swing.JButton proximo;
    // End of variables declaration//GEN-END:variables
}
