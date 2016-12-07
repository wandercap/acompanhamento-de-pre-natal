package view.panels.laudo;

import java.awt.Color;
import java.awt.Font;
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

import control.dao.textfiledao.TextFileLaudoDao;
import model.Laudo;

/**
 * A classe {@code CadLaudoPanel} gera o panel para o cadastro de laudos
 * @author Wanderlan Carvalho
 *
 */

public class CadLaudoPanel extends JPanel {
	private static final long serialVersionUID = 4170777908335631941L;
	private TextFileLaudoDao newLaudo;
	private JTextField txtEspec;
	private JTextField txtMedico;
	private JFormattedTextField txtData;
	private JTextArea txtLaudo;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 * @param idProc
	 * @param idExam
	 */
	public CadLaudoPanel(JFrame frame, int idGest, int idProc, int idExam) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(196, 137, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		add(lblData);
		
		JLabel lblCadastrarLaudo = new JLabel("Cadastrar Laudo");
		lblCadastrarLaudo.setBounds(260, 35, 282, 48);
		lblCadastrarLaudo.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblCadastrarLaudo.setForeground(new Color(255, 255, 255));
		add(lblCadastrarLaudo);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(362, 137, 114, 15);
		lblEspecialidade.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBounds(362, 152, 244, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtEspec.setForeground(new Color(102, 102, 102));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblNomeDoMedico = new JLabel("Médico");
		lblNomeDoMedico.setBounds(196, 194, 114, 15);
		lblNomeDoMedico.setForeground(new Color(255, 255, 255));
		lblNomeDoMedico.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		add(lblNomeDoMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(196, 209, 410, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtMedico.setForeground(new Color(102, 102, 102));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Laudo l = new Laudo(idProc, idExam, txtData.getText(), txtMedico.getText(), txtEspec.getText(), txtLaudo.getText());

				newLaudo = new TextFileLaudoDao();
				if(newLaudo.adicionar(l) == true)
					JOptionPane.showMessageDialog(CadLaudoPanel.this, "Novo laudo cadastrado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(CadLaudoPanel.this, "Erro ao cadastrar novo laudo!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnCadastrar.setToolTipText("Cadastrar");
		btnCadastrar.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnCadastrar.setBackground(new Color(153, 51, 255));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBorder(null);
		btnCadastrar.setBounds(550, 530, 200, 40);
		add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new LaudoPanel(frame, idGest, idProc, idExam));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setBackground(new Color(153, 51, 255));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		txtData = new JFormattedTextField();
		txtData.setBorder(null);
		txtData.setBounds(196, 152, 150, 30);
		add(txtData);
		
		txtLaudo = new JTextArea();
		txtLaudo.setBorder(null);
		txtLaudo.setForeground(new Color(102, 102, 102));
		txtLaudo.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtLaudo.setBounds(196, 269, 410, 216);
		add(txtLaudo);
		
		JLabel lblLaudo = new JLabel("Laudo");
		lblLaudo.setForeground(Color.WHITE);
		lblLaudo.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblLaudo.setBounds(196, 251, 114, 15);
		add(lblLaudo);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}
}
