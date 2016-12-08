package view.panels.gestante;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.dao.textfiledao.TextFileGestanteDao;
import model.Gestante;
import view.FontsProj;
import view.panels.MainPanel;
import view.panels.ProntuarioPanel;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A classe {@code ListGestPanel} gera o panel com a lista de gestantes cadastradas
 * @author Wanderlan Carvalho
 *
 */

public class ListGestPanel extends JPanel {
	private static final long serialVersionUID = 4840640478956635263L;
	private TextFileGestanteDao gest;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListGestPanel(JFrame frame) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		JLabel lblGestantesCadastradas = new JLabel("Gestantes Cadastradas");
		lblGestantesCadastradas.setBounds(220, 35, 393, 48);
		lblGestantesCadastradas.setFont(fontes.unDinaruB);
		lblGestantesCadastradas.setForeground(new Color(255, 255, 255));
		add(lblGestantesCadastradas);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(153, 51, 255));
		scrollPane.getViewport().setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(50, 95, 704, 423);
		add(scrollPane);
		
		gest = new TextFileGestanteDao();
		
		String[] colNomes = {"ID", "Nome", "Telefone", "Celular", "Nascimento", "CEP"};
		ArrayList<Gestante> lista = gest.listar();
		DefaultTableModel tableModel = new DefaultTableModel(colNomes, 0);
		
		table = new JTable(tableModel);
		table.setBackground(new Color(153, 51, 255));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idGest = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), 0);
				frame.setContentPane(new ProntuarioPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		table.setBounds(50, 95, 704, 423);
		//add(table);
		scrollPane.setViewportView(table);
		
		for(Gestante g : lista) {
			if(g != null && g.getNome() != null) {
				Object[] data = {g.getId(), g.getNome(), g.getTelRes(), g.getTelCel(), g.getDataNasc(), g.getCep()};
			
				tableModel.addRow(data);
			}
		}
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
		
	}
}
