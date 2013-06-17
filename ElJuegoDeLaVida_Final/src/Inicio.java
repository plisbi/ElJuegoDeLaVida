import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;



public class Inicio extends JFrame implements ActionListener{

	private JLabel titulo;
	private JButton cmdComienzo;
	private JButton cmdSalir;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

//	------------------------------------			Constructor		------------------------------------
	public Inicio(){
		
		titulo=new JLabel("-- EL JUEGO DE LA VIDA --");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		cmdComienzo = new JButton("Comienza el juego");
		cmdSalir = new JButton("Salir");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		getContentPane().add (titulo, BorderLayout.NORTH);
		getContentPane().add (cmdComienzo, BorderLayout.CENTER);
		getContentPane().add (cmdSalir, BorderLayout.SOUTH);
		
		lblNewLabel_2 = new JLabel("--------");
		getContentPane().add(lblNewLabel_2, BorderLayout.WEST);
		
		lblNewLabel_3 = new JLabel("--------");
		getContentPane().add(lblNewLabel_3, BorderLayout.EAST);
		
		cmdComienzo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cmdComienzo){
					setVisible(false);
					final Seleccion s= new Seleccion();
					s.setVisible(true);
					s.setLocationRelativeTo(null);
				}
			}
		});
		cmdSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
		
	}

//	------------------------------------			MAIN		------------------------------------
	public static void main(String[] args) {
		final Inicio ini = new Inicio();
		ini.setVisible(true);
		ini.setLocationRelativeTo(null);
		ini.setBounds(100, 100, 450, 300);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
