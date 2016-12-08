package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.panels.MainPanel;

/**
 * A classe {@code Main} gera o frame principal da interface grafica
 * @author Wanderlan Carvalho
 *
 */

public class Main extends JFrame {
	private static final long serialVersionUID = -6932656148851689682L;
	private JFrame frame;
	private JPanel panel;
	
	/**
	 * Inicializa a aplicacao.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame.
	 */
	public Main() {
		frame = new JFrame("M@e Digital");
		panel = new MainPanel(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(panel);
		//frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setSize(800, 626);
	}
}
