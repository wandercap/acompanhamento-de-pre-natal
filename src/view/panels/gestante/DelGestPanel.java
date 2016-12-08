package view.panels.gestante;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.dao.textfiledao.TextFileGestanteDao;
import model.Gestante;
import view.FontsProj;
import view.panels.MainPanel;

/**
 * A classe {@code DelGestPanel} gera o panel com a lista de gestantes cadastradas, e ao clicar em uma, a deleta
 * @author Wanderlan Carvalho
 *
 */

public class DelGestPanel extends JPanel {
	private static final long serialVersionUID = -7764056114118506293L;
	private static TextFileGestanteDao gest;
	private JTable table;

	/**
	 * Gera o Panel
	 * @param frame
	 */
	public DelGestPanel(JFrame frame) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		JLabel lblRemoverGestante = new JLabel("Remover Gestante");
		lblRemoverGestante.setBounds(256, 35, 316, 48);
		lblRemoverGestante.setFont(fontes.unDinaruB);
		lblRemoverGestante.setForeground(new Color(255, 255, 255));
		add(lblRemoverGestante);
		
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
		scrollPane.setBorder(null);
		scrollPane.setBounds(50, 95, 704, 423);
		add(scrollPane);
		
		gest = new TextFileGestanteDao();
		
		String[] colNomes = {"ID", "Nome", "Telefone", "Celular", "Nascimento", "CEP"};
		ArrayList<Gestante> lista = gest.listar();
		DefaultTableModel tableModel = new DefaultTableModel(colNomes, 0);
		
		table = new JTable(tableModel);
		table.setBackground(new Color(153, 51, 255));
		table.setForeground(new Color(255, 255, 255));
		table.setBorder(null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idGest = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), 0);
				Gestante g = new Gestante(gest.buscar(idGest));
				Object[] opt = {"Sim", "Não"};
				int n = JOptionPane.showOptionDialog(DelGestPanel.this, "Tem certeza que deseja remover "+g.getNome()+"?", "Atenção!",
					    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
				
				if(n==0) {
					if(gest.deletar(g) == true)
						JOptionPane.showMessageDialog(DelGestPanel.this, g.getNome()+" foi removida!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(DelGestPanel.this, "Erro ao remover a "+g.getNome(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
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
