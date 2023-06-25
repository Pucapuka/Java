package com.mycompany.prova;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane.*;

public class Prova extends JFrame 
                   implements ActionListener{
    
//Declarando Objetos
    JLabel lNome, lIdade, lSexo, lEndereco, lEstado, lCidade;
    JTextField tfNome, tfIdade, tfEndereco;
    JButton bGravar, bLimpar, bExcluir, bSair;
    JRadioButton rbM, rbF;
    ButtonGroup bg;
    JCheckBox cbEditavel;
    JComboBox cbEstado, cbCidade;
    String[] est = {"", "Maranhão", "Piauí"};
    String[] ma = {"Imperatriz", "São Luís"};  //estes já são declarados e instanciados
    String[] pi = {"Parnaíba", "Terezina"};
    JMenuBar barra;
    JMenu mArquivo;
    JMenuItem miSair;
    JTable tabela;
    DefaultTableModel modelo;
    String [] colunas = {"Nome", "Idade", "Sexo", "Endereço", "Cidade", "Estado"};
    String [][] linhas = {{}};
    JScrollPane scroll;
    
    
    public Prova(){
      
        //instanciando
       setLayout(new FlowLayout());
     
       lNome = new JLabel("Nome");
       lIdade = new JLabel("Idade");
       lEndereco = new JLabel("Endereço");
       lSexo = new JLabel("Sexo");
       lEstado = new JLabel("Estado");
       lCidade = new JLabel("Cidade");
       tfNome = new JTextField(30);
       tfIdade = new JTextField(3);
       tfEndereco = new JTextField(40);
       rbM = new JRadioButton("Masculino");
       rbF = new JRadioButton("Feminino");
       bg = new ButtonGroup();
       cbEditavel = new JCheckBox("Editável");
       cbEstado = new JComboBox(est);
       cbCidade = new JComboBox();
       barra = new JMenuBar();
       mArquivo = new JMenu("Arquivo");
       miSair = new JMenuItem("Sair");
       bGravar = new JButton("Gravar");
       bLimpar = new JButton ("Limpar");
       bExcluir = new JButton ("Excluir");
       bSair = new JButton ("Sair");
       tabela = new JTable(linhas, colunas);
       modelo = new DefaultTableModel(linhas, colunas);
       scroll = new JScrollPane();
       
       //Características especiais
       
       mArquivo.setMnemonic('A');
       miSair.setMnemonic('S');
       miSair.addActionListener(this);
       tfNome.addActionListener(this);
       tfIdade.addActionListener(this);
       cbEstado.addActionListener(this);
       rbM.addActionListener(this);
       rbF.addActionListener(this);
       bSair.addActionListener(this);
       bGravar.addActionListener(this);
       bLimpar.addActionListener(this);
       bExcluir.addActionListener(this);
       cbEditavel.setSelected(true);
       
        //montando
       
       add(lNome);
       add(tfNome);
       add(lIdade);
       add(tfIdade);
       add(lSexo);
       add(rbM);
       add(rbF);
       bg.add(rbM);
       bg.add(rbF);
       add(lEndereco);
       add(tfEndereco);
       add(lEstado);
       add(cbEstado);
       add(lCidade);
       add(cbCidade);
       add(cbEditavel);
       add(bGravar);
       add(bLimpar);
       add(bExcluir);
       add(bSair);
       mArquivo.add(miSair);
       barra.add(mArquivo);
       setJMenuBar(barra);
       tabela.setModel(modelo);
       add(tabela);
       scroll.setViewportView(tabela);
       add(scroll);
       
        setSize(620,400);
        setVisible(true);
 
    }
    public static void main(String[] args) {
        Prova a = new Prova();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cbEstado){
            if(cbEstado.getSelectedIndex()==0){
                String[] vazio = {""};
                cbCidade.removeAllItems();
                cbCidade.insertItemAt(vazio[0], 0);
            }else if(cbEstado.getSelectedIndex()==1){
                cbCidade.removeAllItems();
                for (int i=0; i<ma.length; i++){
                cbCidade.insertItemAt(ma[i], i);
                }
            }else if(cbEstado.getSelectedIndex()==2){
                cbCidade.removeAllItems();
                for (int i=0; i<pi.length; i++){
                cbCidade.insertItemAt(pi[i], i);
                }
            }
        }
        
        if (ae.getSource()==miSair || ae.getSource()==bSair){
            System.exit(0);
        }
        
        if (ae.getSource()== bGravar){
            if (tfNome.getText().length()>0){
                String sex = " ";
                if (rbM.isSelected()==true){
                    sex = "Masculino";
                }else{
                    sex = "Feminino";
                }
            String [] texto = {tfNome.getText(), tfIdade.getText(), sex, tfEndereco.getText(),
                               cbCidade.getSelectedItem().toString(), cbEstado.getSelectedItem().toString()};
            modelo.addRow(texto);
            }else{
                JOptionPane.showMessageDialog(null, "Campo em branco!");
            
            }
    
        }
        
        if (ae.getSource()==bExcluir){
            if(tabela.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Selecione uma linha com conteúdo.");
            }else{
                modelo.removeRow(tabela.getSelectedRow());
            }
            
        }
        
        if (ae.getSource()==bLimpar){
            tfNome.setText(null);
            tfIdade.setText(null);
            tfEndereco.setText(null);
            bg.clearSelection();
            cbEstado.setSelectedIndex(0);
        }
    }
}
