package com.mycompany.prova2;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Prova2 extends JFrame
                    implements ActionListener{
    JMenuBar menu;
    JMenu mArquivo;
    JMenuItem miSair;
    JLabel lNome, lIdade, lEndereco;
    JTextField tfNome, tfIdade, tfEndereco;
    ButtonGroup bg;
    JRadioButton rbM, rbF;
    JComboBox cbEstado, cbCidade;
    String[] estados = {"","Maranhão", "Piauí"};
    String [] ma = {"Imperatriz", "São Luís"};
    String [] pi = {"Parnaíba", "Terezina"};
    JCheckBox Editavel;
    JButton bGravar, bLimpar, bExcluir, bSair;
    DefaultTableModel modelo;
    JTable tabela;
    String [] colunas = {"Nome", "Idade", "Sexo", "Endereço", "Cidade", "Estado"};
    String [][] linhas = {{}};
    JScrollPane scroll;
    
    public Prova2(){
    setLayout(new FlowLayout());
    //instanciando
    lNome = new JLabel("Nome");
    lIdade = new JLabel("Idade");
    lEndereco = new JLabel("Endereço");
    tfNome = new JTextField(30);
    tfIdade = new JTextField(3); 
    tfEndereco = new JTextField(30); 
    bg = new ButtonGroup();
    rbM = new JRadioButton("Masculino");
    rbF = new JRadioButton("Feminino");
    cbEstado = new JComboBox(estados);
    cbCidade = new JComboBox();
    Editavel = new JCheckBox("Editável");
    bGravar = new JButton("Gravar");
    bLimpar = new JButton("Limpar");
    bSair = new JButton("Sair");
    tabela = new JTable(linhas, colunas);
    modelo = new DefaultTableModel(linhas, colunas);
    scroll = new JScrollPane();
    miSair = new JMenuItem("Sair");
    bExcluir = new JButton("Excluir");
    mArquivo = new JMenu("Arquivo");
    menu = new JMenuBar();
    
    //montando
    miSair.addActionListener(this);
    mArquivo.add(miSair);
    menu.add(mArquivo);
    setJMenuBar(menu);
    add(lNome);
    add(tfNome);
    tfNome.addActionListener(this);
    add(lIdade);
    tfIdade.addActionListener(this);
    add(tfIdade);
    add(lEndereco);
    tfEndereco.addActionListener(this);
    add(tfEndereco);
    rbM.addActionListener(this);
    add(rbM);
    rbF.addActionListener(this);
    add(rbF);
    bg.add(rbM);
    bg.add(rbF);
    cbEstado.addActionListener(this);
    add(cbEstado);
    cbCidade.addActionListener(this);
    add(cbCidade);
    Editavel.setSelected(true);
    add(Editavel);
    bGravar.addActionListener(this);
    add(bGravar);
    bLimpar.addActionListener(this);
    add(bLimpar);
    bExcluir.addActionListener(this);
    add(bExcluir);
    bSair.addActionListener(this);
    add(bSair);
    tabela.setModel(modelo);
    add(tabela);
    scroll.setViewportView(tabela);
    add(scroll);
    
    
    
    
    
    
    
    setSize(620,400);
    setVisible(true);
    
    }
  
    
    //função principal
    public static void main(String[] args) {
        Prova2 a = new Prova2();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //Estabelecer as com o Action Event
@Override
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==tfNome){
            tfIdade.requestFocus();
        }else if(ae.getSource()==tfIdade){
            tfEndereco.requestFocus();
        }else
        if(ae.getSource() == cbEstado){
            cbCidade.removeAllItems();
            if (cbEstado.getSelectedIndex()==1){
                for (int i=0; i<ma.length; i++){
                    cbCidade.insertItemAt(ma[i],i);
                }
            }else if (cbEstado.getSelectedIndex()==2){
                cbCidade.removeAllItems();
                for (int i=0; i<pi.length; i++){
                    cbCidade.insertItemAt(pi[i],i);
                }
            }else{
                cbCidade.removeAllItems();
            }
        }
          else if(ae.getSource()==bGravar){
              if(tfNome.getText().length()<0){
                  JOptionPane.showMessageDialog(null,
                        "Campo nome vazio!");
              }else{
                  String sexo = "";
                  if (rbM.isSelected()==true){
                      sexo = "Masculino";
                  }else if(rbF.isSelected()==true){
                      sexo = "Feminino";
                  }
                  String [] texto = {tfNome.getText(), tfIdade.getText(),
                                    sexo, tfEndereco.getText(), 
                                    cbCidade.getSelectedItem().toString(),
                                    cbEstado.getSelectedItem().toString()};
            
                        modelo.addRow(texto);
              }
          }else if(ae.getSource()==bExcluir){
              
              if (tabela.getSelectedRow()==-1){
                  JOptionPane.showMessageDialog(null, "Uma linha deve ser selecionada.");
              }else{
                  modelo.removeRow(tabela.getSelectedRow());
              }
              
          }else if(ae.getSource()==bLimpar){
              tfNome.setText(null);
              tfIdade.setText(null);
              bg.clearSelection();
              tfEndereco.setText(null);
              cbEstado.setSelectedIndex(0);
          }else if ((ae.getSource()==bSair) || (ae.getSource()==miSair)){
                      System.exit(0);
                      }
        }
}
