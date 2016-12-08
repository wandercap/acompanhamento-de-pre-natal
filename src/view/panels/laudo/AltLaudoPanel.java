package view.panels.laudo;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.dao.textfiledao.TextFileLaudoDao;
import model.Laudo;
import view.FontsProj;

/**
 * A classe {@code AltLaudoPanel} gera o panel para a alteracao de um laudo
 * @author Wanderlan Carvalho
 *
 */

public class AltLaudoPanel extends JPanel {
	private static final long serialVersionUID = 612611337186410213L;
	private TextFileLaudoDao newLaudo;
	private Laudo laudo;
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
	public AltLaudoPanel(JFrame frame, int idGest, int idProc, int idExam) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		newLaudo = new TextFileLaudoDao();
		laudo = newLaudo.buscar(idProc, idExam);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(196, 137, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(fontes.unDinaru);
		add(lblData);
		
		JLabel lblAlterarLaudo = new JLabel("Alterar Laudo");
		lblAlterarLaudo.setBounds(285, 35, 244, 48);
		lblAlterarLaudo.setFont(fontes.unDinaruB);
		lblAlterarLaudo.setForeground(new Color(255, 255, 255));
		add(lblAlterarLaudo);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(362, 137, 114, 15);
		lblEspecialidade.setFont(fontes.unDinaru);
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBounds(362, 152, 244, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setText(laudo.getEspecialidade());
		txtEspec.setFont(fontes.unDinaru);
		txtEspec.setForeground(new Color(102, 102, 102));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblNomeDoMedico = new JLabel("Médico");
		lblNomeDoMedico.setBounds(196, 194, 114, 15);
		lblNomeDoMedico.setForeground(new Color(255, 255, 255));
		lblNomeDoMedico.setFont(fontes.unDinaru);
		add(lblNomeDoMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(196, 209, 410, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setText(laudo.getMedico());
		txtMedico.setFont(fontes.unDinaru);
		txtMedico.setForeground(new Color(102, 102, 102));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Laudo l = new Laudo(idProc, idExam, txtData.getText(), txtMedico.getText(), txtEspec.getText(), txtLaudo.getText());

				newLaudo = new TextFileLaudoDao();
				if(newLaudo.alterar(l) == true)
					JOptionPane.showMessageDialog(AltLaudoPanel.this, "Laudo alterado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(AltLaudoPanel.this, "Erro ao alterar o laudo!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setFont(fontes.Raleway);
		btnAlterar.setBackground(new Color(153, 51, 255));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setBorder(null);
		btnAlterar.setBounds(550, 530, 200, 40);
		add(btnAlterar);
		
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
		btnVoltar.setFont(fontes.Raleway);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		txtData = new JFormattedTextField();
		txtData.setBorder(null);
		txtData.setText(laudo.getData());
		txtData.setBounds(196, 152, 150, 30);
		add(txtData);
		
		txtLaudo = new JTextArea();
		txtLaudo.setBorder(null);
		txtLaudo.setText(laudo.getLaudo());
		txtLaudo.setForeground(new Color(102, 102, 102));
		txtLaudo.setFont(fontes.unDinaru);
		txtLaudo.setBounds(196, 269, 410, 216);
		add(txtLaudo);
		
		JLabel lblLaudo = new JLabel("Laudo");
		lblLaudo.setForeground(Color.WHITE);
		lblLaudo.setFont(fontes.unDinaru);
		lblLaudo.setBounds(196, 251, 114, 15);
		add(lblLaudo);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
