package view.panels.prescricao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import control.dao.textfiledao.TextFilePrescricaoDao;
import model.Prescricao;
import view.FontsProj;

/**
 * A classe {@code CadPrescPanel} gera o panel para o cadastro de uma Prescricao
 * @author Wanderlan Carvalho
 *
 */

public class CadPrescPanel extends JPanel {
	private static final long serialVersionUID = -5968919872036759151L;
	private TextFilePrescricaoDao newPresc;
	private JFormattedTextField txtData;
	private JTextField txtEspec;
	private JTextField txtMedico;
	private JTextArea txtPresc;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 * @param idCons
	 */
	public CadPrescPanel(JFrame frame, int idGest, int idCons) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(196, 137, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(fontes.unDinaru);
		add(lblData);
		
		JLabel lblCadastrarPrescricao = new JLabel("Cadastrar Precrição");
		lblCadastrarPrescricao.setBounds(235, 35, 336, 48);
		lblCadastrarPrescricao.setFont(fontes.unDinaruB);
		lblCadastrarPrescricao.setForeground(new Color(255, 255, 255));
		add(lblCadastrarPrescricao);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(362, 137, 114, 15);
		lblEspecialidade.setFont(fontes.unDinaru);
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBounds(362, 152, 244, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setFont(fontes.unDinaru);
		txtEspec.setForeground(new Color(102, 102, 102));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblMedico = new JLabel("Médico");
		lblMedico.setBounds(196, 194, 114, 15);
		lblMedico.setForeground(new Color(255, 255, 255));
		lblMedico.setFont(fontes.unDinaru);
		add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(196, 209, 410, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setFont(fontes.unDinaru);
		txtMedico.setForeground(new Color(102, 102, 102));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prescricao p = new Prescricao(idCons, txtData.getText(), txtMedico.getText(), txtEspec.getText(), txtPresc.getText());

				newPresc = new TextFilePrescricaoDao();
				if(newPresc.adicionar(p) == true)
					JOptionPane.showMessageDialog(CadPrescPanel.this, "Nova prescrição cadastrada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(CadPrescPanel.this, "Erro ao cadastrar nova prescrição!", "Erro!", JOptionPane.ERROR_MESSAGE);
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
				frame.setContentPane(new PrescricaoPanel(frame, idGest, idCons));
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
		
		txtData = new JFormattedTextField();
		txtData.setBorder(null);
		txtData.setBounds(196, 152, 150, 30);
		add(txtData);
		
		txtPresc = new JTextArea();
		txtPresc.setBorder(null);
		txtPresc.setForeground(new Color(102, 102, 102));
		txtPresc.setFont(fontes.unDinaru);
		txtPresc.setBounds(196, 269, 410, 240);
		add(txtPresc);
		
		JLabel lblPrescrio = new JLabel("Prescrição");
		lblPrescrio.setForeground(Color.WHITE);
		lblPrescrio.setFont(fontes.unDinaru);
		lblPrescrio.setBounds(196, 251, 114, 15);
		add(lblPrescrio);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}
}
