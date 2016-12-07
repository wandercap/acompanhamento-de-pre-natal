package view.panels.consulta;

import java.awt.Color;
import java.awt.Font;
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

import control.dao.textfiledao.TextFileConsultaDao;
import model.Consulta;

/**
 * A classe {@code ListConsAgendPanel} gera o panel com a lista de consultas agendadas
 * @author Wanderlan Carvalho
 *
 */

public class ListConsAgendPanel extends JPanel {
	private static final long serialVersionUID = 2739184501533450895L;
	private TextFileConsultaDao cons;
	private JTable table;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ListConsAgendPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblConsultasAgendadas = new JLabel("Consultas Agendadas");
		lblConsultasAgendadas.setBounds(220, 35, 393, 48);
		lblConsultasAgendadas.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblConsultasAgendadas.setForeground(new Color(255, 255, 255));
		add(lblConsultasAgendadas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ConsultasPanel(frame, idGest));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(153, 51, 255));
		scrollPane.getViewport().setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(50, 95, 704, 423);
		add(scrollPane);
		
		cons = new TextFileConsultaDao();
		
		String[] colNomes = {"ID", "Data", "Horário", "Local", "Especialidade", "Médico", "Comentários", "Realizada"};
		ArrayList<Consulta> lista = cons.listar();
		DefaultTableModel tableModel = new DefaultTableModel(colNomes, 0);
		
		table = new JTable(tableModel);
		table.setBackground(new Color(153, 51, 255));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idCons = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), 0);
				Consulta c = new Consulta(cons.buscar(idCons));
				Object[] opt = {"Sim", "Não"};
				int n = JOptionPane.showOptionDialog(ListConsAgendPanel.this, "Esta consulta foi realizada?", "Consulta!",
					    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
				
				if(n==0) {
					c.setRealizada(true);
					if(cons.alterar(c) == true)
						JOptionPane.showMessageDialog(ListConsAgendPanel.this, "Consulta realizada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(ListConsAgendPanel.this, "Erro ao alterar a consulta!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		table.setBounds(50, 95, 704, 423);
		//add(table);
		scrollPane.setViewportView(table);
		
		for(Consulta c : lista) {
			if((c.getIdGest() == idGest)&&(c.isRealizada() ==  false)) {
				Object[] data = {c.getId(), c.getData(), c.getHorario(), c.getLocal(), c.getEspecialidade(), c.getMedico(), c.getComentarios(), "Não"};
			
				tableModel.addRow(data);
			}
		}
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
