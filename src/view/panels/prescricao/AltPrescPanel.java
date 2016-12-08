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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.dao.textfiledao.TextFilePrescricaoDao;
import model.Prescricao;
import view.FontsProj;

/**
 * A classe {@code AltPrescPanel} gera o panel para a alteracao de uma prescricao
 * @author Wanderlan Carvalho
 *
 */

public class AltPrescPanel extends JPanel {
	private static final long serialVersionUID = -4895007324442616339L;
	private TextFilePrescricaoDao newPresc;
	private Prescricao presc;
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
	public AltPrescPanel(JFrame frame, int idGest, int idCons) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		newPresc = new TextFilePrescricaoDao();
		presc = newPresc.buscar(idCons);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(196, 137, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(fontes.unDinaru);
		add(lblData);
		
		JLabel lblAlterarPrescricao = new JLabel("Alterar Precrição");
		lblAlterarPrescricao.setBounds(260, 35, 284, 48);
		lblAlterarPrescricao.setFont(fontes.unDinaruB);
		lblAlterarPrescricao.setForeground(new Color(255, 255, 255));
		add(lblAlterarPrescricao);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(362, 137, 114, 15);
		lblEspecialidade.setFont(fontes.unDinaru);
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBounds(362, 152, 244, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setText(presc.getEspecialidade());
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
		txtMedico.setText(presc.getMedico());
		txtMedico.setFont(fontes.unDinaru);
		txtMedico.setForeground(new Color(102, 102, 102));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prescricao p = new Prescricao(idCons, txtData.getText(), txtMedico.getText(), txtEspec.getText(), txtPresc.getText());

				newPresc = new TextFilePrescricaoDao();
				if(newPresc.alterar(p) == true)
					JOptionPane.showMessageDialog(AltPrescPanel.this, "Prescrição alterada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(AltPrescPanel.this, "Erro ao alterar a prescrição!", "Erro!", JOptionPane.ERROR_MESSAGE);
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
		txtData.setText(presc.getData());
		txtData.setBounds(196, 152, 150, 30);
		add(txtData);
		
		txtPresc = new JTextArea();
		txtPresc.setBorder(null);
		txtPresc.setText(presc.getPrescricao());
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
