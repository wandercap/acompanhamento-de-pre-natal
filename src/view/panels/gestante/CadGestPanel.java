package view.panels.gestante;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.dao.textfiledao.TextFileGestanteDao;
import model.Gestante;
import view.FontsProj;
import view.panels.MainPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A classe {@code CadGestPanel} gera o panel para cadastro de gestantes
 * @author Wanderlan Carvalho
 *
 */

public class CadGestPanel extends JPanel {
	private static final long serialVersionUID = 6695633955351790590L;
	private TextFileGestanteDao newGest;
	private JTextField txtNome;
	private JTextField txtTelRes;
	private JTextField txtTelCel;
	private JTextField txtMae;
	private JTextField txtPai;
	private JTextField txtEnd;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtDataNasc;

	/**
	 * Gera o Panel
	 * @param frame
	 */
	public CadGestPanel(JFrame frame) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		FontsProj fontes = new FontsProj();
		
		txtNome = new JTextField();
		txtNome.setBounds(196, 152, 250, 30);
		txtNome.setToolTipText("");
		txtNome.setBorder(null);
		txtNome.setFont(fontes.unDinaru);
		txtNome.setForeground(new Color(102, 102, 102));
		txtNome.setBackground(new Color(255, 255, 255));
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(196, 137, 70, 15);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(fontes.unDinaru);
		add(lblNome);
		
		JLabel lblCadastrarGestante = new JLabel("Cadastrar Gestante");
		lblCadastrarGestante.setBounds(240, 35, 336, 48);
		lblCadastrarGestante.setFont(fontes.unDinaruB);
		lblCadastrarGestante.setForeground(new Color(255, 255, 255));
		add(lblCadastrarGestante);
		
		JLabel lblTelefoneResidencial = new JLabel("Telefone Residencial");
		lblTelefoneResidencial.setBounds(196, 194, 143, 15);
		lblTelefoneResidencial.setFont(fontes.unDinaru);
		lblTelefoneResidencial.setForeground(new Color(255, 255, 255));
		add(lblTelefoneResidencial);
		
		txtTelRes = new JTextField();
		txtTelRes.setBounds(196, 209, 200, 30);
		txtTelRes.setToolTipText("");
		txtTelRes.setBorder(null);
		txtTelRes.setFont(fontes.unDinaru);
		txtTelRes.setForeground(new Color(102, 102, 102));
		add(txtTelRes);
		txtTelRes.setColumns(10);
		
		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setBounds(406, 194, 114, 15);
		lblTelefoneCelular.setFont(fontes.unDinaru);
		lblTelefoneCelular.setForeground(new Color(255, 255, 255));
		add(lblTelefoneCelular);
		
		txtTelCel = new JTextField();
		txtTelCel.setBounds(406, 209, 200, 30);
		txtTelCel.setToolTipText("");
		txtTelCel.setBorder(null);
		txtTelCel.setFont(fontes.unDinaru);
		txtTelCel.setForeground(new Color(102, 102, 102));
		add(txtTelCel);
		txtTelCel.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da Mãe");
		lblNomeDaMe.setBounds(196, 251, 114, 15);
		lblNomeDaMe.setForeground(new Color(255, 255, 255));
		lblNomeDaMe.setFont(fontes.unDinaru);
		add(lblNomeDaMe);
		
		txtMae = new JTextField();
		txtMae.setBounds(196, 266, 410, 30);
		txtMae.setToolTipText("");
		txtMae.setBorder(null);
		txtMae.setFont(fontes.unDinaru);
		txtMae.setForeground(new Color(102, 102, 102));
		add(txtMae);
		txtMae.setColumns(10);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai");
		lblNomeDoPai.setBounds(196, 308, 114, 15);
		lblNomeDoPai.setFont(fontes.unDinaru);
		lblNomeDoPai.setForeground(new Color(255, 255, 255));
		add(lblNomeDoPai);
		
		txtPai = new JTextField();
		txtPai.setBounds(196, 323, 410, 30);
		txtPai.setToolTipText("");
		txtPai.setBorder(null);
		txtPai.setFont(fontes.unDinaru);
		txtPai.setForeground(new Color(102, 102, 102));
		add(txtPai);
		txtPai.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(fontes.unDinaru);
		lblEndereo.setForeground(new Color(255, 255, 255));
		lblEndereo.setBounds(196, 365, 84, 15);
		add(lblEndereo);
		
		txtEnd = new JTextField();
		txtEnd.setToolTipText("");
		txtEnd.setBorder(null);
		txtEnd.setFont(fontes.unDinaru);
		txtEnd.setForeground(new Color(102, 102, 102));
		txtEnd.setBounds(196, 380, 410, 30);
		add(txtEnd);
		txtEnd.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(fontes.unDinaru);
		lblBairro.setForeground(new Color(255, 255, 255));
		lblBairro.setBounds(196, 422, 70, 15);
		add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setToolTipText("");
		txtBairro.setBorder(null);
		txtBairro.setFont(fontes.unDinaru);
		txtBairro.setForeground(new Color(102, 102, 102));
		txtBairro.setBounds(196, 437, 200, 30);
		add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(new Color(255, 255, 255));
		lblCep.setFont(fontes.unDinaru);
		lblCep.setBounds(406, 422, 70, 15);
		add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(fontes.unDinaru);
		txtCep.setForeground(new Color(102, 102, 102));
		txtCep.setToolTipText("");
		txtCep.setBorder(null);
		txtCep.setBounds(406, 437, 200, 30);
		add(txtCep);
		txtCep.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestante g = new Gestante(txtNome.getText(), txtTelRes.getText(), txtTelCel.getText(), txtMae.getText(), 
											txtPai.getText(), txtDataNasc.getText(), txtEnd.getText(), txtBairro.getText(), txtCep.getText());
				
				 newGest = new TextFileGestanteDao();
				 if(newGest.adicionar(g) == true)
				 	JOptionPane.showMessageDialog(CadGestPanel.this, "Nova gestante cadastrada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				 else
					JOptionPane.showMessageDialog(CadGestPanel.this, "Erro ao cadastrar nova gestante!", "Erro!", JOptionPane.ERROR_MESSAGE);
				 
			}
		});
		btnCadastrar.setToolTipText("Cadastrar");
		btnCadastrar.setFont(fontes.Raleway);
		btnCadastrar.setBackground(new Color(153, 51, 255));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBorder(null);
		btnCadastrar.setBounds(550, 530, 200, 40);
		add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new MainPanel(frame));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setBackground(new Color(153, 51, 255));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(fontes.Raleway);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setForeground(new Color(255, 255, 255));
		lblDataNasc.setFont(fontes.unDinaru);
		lblDataNasc.setBounds(456, 137, 143, 15);
		add(lblDataNasc);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setToolTipText("");
		txtDataNasc.setBorder(null);
		txtDataNasc.setBounds(456, 152, 150, 30);
		add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);

	}

}
