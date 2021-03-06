package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.dados.ReadTextFile;
import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioRefeicao;
import br.com.dieta_saude.excecoes.CampoVazioException;
import br.com.dieta_saude.java_beans.Alimento;
import br.com.dieta_saude.java_beans.Refeicao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CriarRefeicaoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nomeRef;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarRefeicaoFrame frame = new CriarRefeicaoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CriarRefeicaoFrame() {
		Alimento banana = new Alimento("Banana", 10);
		/*Alimento pao = new Alimento("P�o", 30);
		Alimento copoDeSuco = new Alimento("Copo de Suco (200ml)", 10);
		Alimento porcaoDeBolacha = new Alimento("6unds de Bolacha", 20);
		Alimento fatiaDeBoloSemRecheio = new Alimento("Fatia de Bolo (Sem recheio)", 25);
		RepositorioAlimento.getInstance().cadastrar(banana);
		RepositorioAlimento.getInstance().cadastrar(pao);
		RepositorioAlimento.getInstance().cadastrar(copoDeSuco);
		RepositorioAlimento.getInstance().cadastrar(porcaoDeBolacha);
		RepositorioAlimento.getInstance().cadastrar(fatiaDeBoloSemRecheio);*/

		Refeicao ref = new Refeicao("");
		ReadTextFile application = new ReadTextFile();
		
		application.openFile();
		application.readRecords();
		application.closeFile();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 39, 315, 20);
		contentPane.add(comboBox);
		comboBox.removeAllItems();
		for(int i=0;i<RepositorioAlimento.getInstance().tamanhoRepositorio();i++){
			comboBox.addItem(RepositorioAlimento.getInstance().mostrarAlimentos(i).getNome() + " tem:"+RepositorioAlimento.getInstance().mostrarAlimentos(i).getPontos() + "pontos");
		}
		JLabel lblAlimento = new JLabel("Alimento");
		lblAlimento.setBounds(10, 14, 76, 14);
		contentPane.add(lblAlimento);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if(nomeRef.getText().equals("")){
					throw new CampoVazioException();
				}
				ref.setNome(nomeRef.getText());
				RepositorioRefeicao.getInstance().cadastrar(ref);
				JOptionPane.showMessageDialog(null, ref.toString());
				}catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		btnOk.setBounds(10, 144, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String divComando[] = new String[2];
				divComando = comboBox.getSelectedItem().toString().split(" ");
				ref.adicionarAlimentosNaRefeicao((Alimento) RepositorioAlimento.getInstance().procurar(divComando[0]));
			}
		});
		btnAdicionar.setBounds(335, 38, 89, 23);
		contentPane.add(btnAdicionar);
		
		nomeRef = new JTextField();
		nomeRef.setBounds(10, 113, 315, 20);
		contentPane.add(nomeRef);
		nomeRef.setColumns(10);
		
		JLabel lblNomeDaRefeicao = new JLabel("Nome da Refeicao");
		lblNomeDaRefeicao.setBounds(10, 80, 89, 14);
		contentPane.add(lblNomeDaRefeicao);
	}
}
