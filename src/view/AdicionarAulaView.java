/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DisciplinaController;
import controller.ProfessorController;
import controller.TopicoController;
import controller.UsuarioController;
import exceptions.DisciplinaNaoEncontrada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import model.Disciplina;
import model.Topico;
import model.Usuario;
import persistence.local.AulaDAO;
import persistence.local.ContratoDAO;
import persistence.local.DisciplinaDAO;
import persistence.local.UsuarioDAO;
import persistence.local.TopicoDAO;

/**
 *
 * @author dener
 */
public class AdicionarAulaView extends javax.swing.JPanel {
    
    private final String VALOR_INVALIDO = "Valor Inválido";
    private final String TOPICO_INVALIDO = "Selecione um Tópico";
    
    private final JFrame context;
    private final Usuario user;
    
    private DefaultListModel<String> topicosModel;
    private List<Topico> topicosEscolhidos;
    
    private final TopicoController topicoController;
    private DefaultComboBoxModel<String> allTopicosModel;
    private List<Topico> allTopicos;
    
    private final DisciplinaController disciplinaController;
    private DefaultComboBoxModel<String> disciplinasModel;
    private final List<Disciplina> allDisciplinas;
    
    private final ProfessorController professorController;
    
    /**
     * Creates new form AdicionarAulaView
     * @param context
     */
    public AdicionarAulaView(JFrame context, Usuario user) {
        initComponents();
        
        this.context = context;
        this.user = user;
        this.topicosModel = new DefaultListModel();
        this.topicoController = new TopicoController(new UsuarioDAO(), new TopicoDAO());
        this.topicos.setModel(topicosModel);
        this.topicosEscolhidos = new ArrayList<>();
        
        this.allTopicosModel = new DefaultComboBoxModel<>();
        listaTopicos.setModel(allTopicosModel);
        this.allTopicos = topicoController.getAllTopicos();
        for(Topico t : allTopicos) allTopicosModel.addElement(t.getDescricao());
        
        this.disciplinaController = new DisciplinaController(new DisciplinaDAO());
        this.allDisciplinas = disciplinaController.getAll();
        this.disciplinasModel = new DefaultComboBoxModel<>();
        this.disciplina.setModel(disciplinasModel);
        for(Disciplina d : allDisciplinas) {
            disciplinasModel.addElement(d.getNome());
        }
        
        professorController = new ProfessorController(new AulaDAO(), new TopicoDAO(), new UsuarioDAO(), new DisciplinaDAO(), new ContratoDAO());
        
        this.valorInvalido.setText("");
        this.topicoInvalido.setText("");
        
        atualizarTopicos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        disciplina = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        topicos = new javax.swing.JList<>();
        addTopico = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        listaTopicos = new javax.swing.JComboBox<>();
        valorInvalido = new javax.swing.JLabel();
        topicoInvalido = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastrar Aula");

        disciplina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinaActionPerformed(evt);
            }
        });

        jLabel1.setText("Disciplina:");

        jLabel3.setText("Valor:");

        jLabel4.setText("Topicos:");

        topicos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(topicos);

        addTopico.setText("Adicionar");
        addTopico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTopicoActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição:");

        descricao.setColumns(20);
        descricao.setRows(5);
        jScrollPane2.setViewportView(descricao);

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        listaTopicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        valorInvalido.setForeground(new java.awt.Color(255, 0, 0));
        valorInvalido.setText("Valor Inválido");

        topicoInvalido.setForeground(new java.awt.Color(255, 0, 0));
        topicoInvalido.setText("Selecione um Tópico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 429, Short.MAX_VALUE)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(disciplina, 0, 250, Short.MAX_VALUE)
                                .addComponent(valor)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valorInvalido)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(listaTopicos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addTopico))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(topicoInvalido))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(topicoInvalido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTopico)
                    .addComponent(listaTopicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(valorInvalido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(cancelar))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void disciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disciplinaActionPerformed

    private void addTopicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTopicoActionPerformed
        int topicoIndex = listaTopicos.getSelectedIndex();
        Topico t = allTopicos.get(topicoIndex);
        adicionarTopico(t);
        atualizarTopicos();
    }//GEN-LAST:event_addTopicoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        ((MainView) context).voltar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        this.valorInvalido.setText("");
        this.topicoInvalido.setText("");
        
        int indexDisciplina = disciplina.getSelectedIndex();
        double valor = 0;
        List<Integer> topicosID = new ArrayList<>();
        for(Topico t : topicosEscolhidos) {
            topicosID.add(t.getId());
        }
        try {
            if(topicosID.isEmpty()) this.topicoInvalido.setText(TOPICO_INVALIDO);
            valor = Double.parseDouble(this.valor.getText());
            if(!topicosID.isEmpty()) {
                professorController.addAula(user.getUsername(), allDisciplinas.get(indexDisciplina).getNome(), valor, topicosID, this.descricao.getText());
                ((MainView) context).abrirPaginaInicialView(user);
            }
        } catch(DisciplinaNaoEncontrada e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            valorInvalido.setText(VALOR_INVALIDO);
        }
    }//GEN-LAST:event_salvarActionPerformed
    
    public void atualizarTopicos() {
        topicosModel.removeAllElements();
        for(Topico t : topicosEscolhidos) {
            topicosModel.addElement(t.getDescricao());
        }
    }
    
    public void adicionarTopico(Topico topico) {
        for(Topico t : topicosEscolhidos) {
            if(topico.getId() == t.getId()) return;
        }
        topicosEscolhidos.add(topico);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTopico;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextArea descricao;
    private javax.swing.JComboBox<String> disciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listaTopicos;
    private javax.swing.JButton salvar;
    private javax.swing.JLabel topicoInvalido;
    private javax.swing.JList<String> topicos;
    private javax.swing.JTextField valor;
    private javax.swing.JLabel valorInvalido;
    // End of variables declaration//GEN-END:variables
}
