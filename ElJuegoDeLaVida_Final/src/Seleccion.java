import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;




public class Seleccion extends JFrame {

	private JPanel contentPane;
	
	//private Ventana2 v2;
	private PatronesEnum patron;
	private int altoS;
	private int anchoS;
	
	final JButton btnEspacioCelularAutomtico = new JButton("<html>Espacio celular<br>autom\u00E1tico.");
	final JButton btnElijeUnPatron = new JButton("Elije un patr\u00F3n.");
	final JButton btnquieroCrearmi = new JButton("<html>Quiero crear mi <br>propio patr\u00F3n");
	final JButton btncreaTuPropioespacio = new JButton("<html>Crea tu propio<br>espacio celular.");
	final JButton btnPatrnAleatorio = new JButton("Patr\u00F3n aleatorio");
	final JSlider sliderAlto = new JSlider();
	final JSlider sliderAncho = new JSlider();
	final JLabel lblAlto = new JLabel("Alto");
	final JLabel lblAncho = new JLabel("Ancho");
	final JComboBox comboBox = new JComboBox();
	final JButton btnCrear = new JButton("Crear");
	
//	------------------------------------			Constructor		------------------------------------
	public Seleccion() {
		setTitle("-- EL JUEGO DE LA VIDA --");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
//		----------------- EspacioCelular automatico
			btnEspacioCelularAutomtico.setBounds(3, 5, 146, 268);
			contentPane.setLayout(null);
			contentPane.add(btnEspacioCelularAutomtico);

//		----------------- Crea tu propio patron
			btncreaTuPropioespacio.setBounds(152, 5, 146, 126);
			contentPane.add(btncreaTuPropioespacio);
		
	//		----------------- Sliders
			sliderAlto.setEnabled(false);
			sliderAlto.setMinimum(5);
			sliderAlto.setToolTipText("Alto");
			sliderAlto.setBounds(196, 134, 104, 25);
			contentPane.add(sliderAlto);
			lblAlto.setEnabled(false);
			lblAlto.setBounds(161, 138, 49, 16);
			contentPane.add(lblAlto);	
			sliderAncho.setValue(25);
			sliderAncho.setMaximum(50);
			
			sliderAncho.setEnabled(false);
			sliderAncho.setMinimum(5);
			sliderAncho.setToolTipText("Ancho");
			sliderAncho.setBounds(196, 165, 104, 25);
			contentPane.add(sliderAncho);
			lblAncho.setEnabled(false);
			lblAncho.setBounds(161, 169, 49, 16);
			contentPane.add(lblAncho);

		
	//		----------------- EspacioCelular Aleatorio
			btnPatrnAleatorio.setEnabled(false);
			btnPatrnAleatorio.setBounds(149, 192, 153, 29);
			contentPane.add(btnPatrnAleatorio);

		
	//		----------------- EspacioCelular vacio	
			btnquieroCrearmi.setEnabled(false);
			btnquieroCrearmi.setBounds(152, 226, 146, 46);
			contentPane.add(btnquieroCrearmi);
	
//		----------------- elegir Patron
			btnElijeUnPatron.setBounds(301, 5, 146, 126);
			contentPane.add(btnElijeUnPatron);

		
	//		----------------- lista del combobox		
			comboBox.setEnabled(false);
			comboBox.setBounds(299, 132, 150, 28);
			contentPane.add(comboBox);
			comboBox.addItem(PatronesEnum.SAPO);
			comboBox.addItem(PatronesEnum.PLANEADOR);
			comboBox.addItem(PatronesEnum.NAVE_LIGERA);
			comboBox.addItem(PatronesEnum.DIEHARD);
			comboBox.addItem(PatronesEnum.ACORN);
			sliderAlto.setValue(25);
			sliderAlto.setMaximum(50);
		
	//		----------------- Crear (el espacio elejido en el combobox)	
			btnCrear.setBounds(316, 165, 117, 29);
			contentPane.add(btnCrear);
			btnCrear.setEnabled(false);
		
//		----------------- funcionalidades de los botones
		
		btnEspacioCelularAutomtico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnEspacioCelularAutomtico){
					anchoS=30;
					altoS=30;
					setVisible(false);
					final Ventana2 v2= new Ventana2(altoS, anchoS);
					v2.automatico();
					v2.setLocationRelativeTo(null);
					v2.setVisible(true);
				}
			}
		});
		
		btncreaTuPropioespacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btncreaTuPropioespacio){
					btncreaTuPropioespacio.setEnabled(false);
					btnElijeUnPatron.setEnabled(false);
					btnEspacioCelularAutomtico.setEnabled(false);
					lblAlto.setEnabled(true);
					sliderAlto.setEnabled(true);
					lblAncho.setEnabled(true);
					sliderAncho.setEnabled(true);
					btnPatrnAleatorio.setEnabled(true);
					btnquieroCrearmi.setEnabled(true);
					btnCrear.setEnabled(false);
				}
			}
		});
		
		btnPatrnAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altoS=sliderAlto.getValue();
				anchoS=sliderAncho.getValue();
				System.out.println(altoS+"  "+anchoS); //comprobacion en consola de que coje los datos
				setVisible(false);
				final Ventana2 v2= new Ventana2(altoS, anchoS);
				v2.automatico();
				v2.setLocationRelativeTo(null);
				v2.setVisible(true);
			}
		});
		
		btnquieroCrearmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altoS=sliderAlto.getValue();
				anchoS=sliderAncho.getValue();
				System.out.println(altoS+"  "+anchoS);
				setVisible(false);
				final Ventana2 v2= new Ventana2(altoS, anchoS);
				v2.setVisible(true);
				v2.setLocationRelativeTo(null);
			}
		});
		
		btnElijeUnPatron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnElijeUnPatron.setEnabled(false);
				comboBox.setEnabled(true);
				btncreaTuPropioespacio.setEnabled(false);
				btnElijeUnPatron.setEnabled(false);
				btnEspacioCelularAutomtico.setEnabled(false);
				btnCrear.setEnabled(true);
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				patron = (PatronesEnum)cb.getSelectedItem();
				
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (patron==null)
					patron=PatronesEnum.SAPO;
				//System.out.println(patron); //Comprobacion de que recibe el enum correspondiente
				
				anchoS=30;
				altoS=30;
				setVisible(false);
				final Ventana2 v2= new Ventana2(altoS, anchoS);
				v2.conPatron(patron);
				v2.setLocationRelativeTo(null);
				v2.setVisible(true);
			}
		});

				
//		----------------- Salir		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(322, 235, 104, 29);
		contentPane.add(btnSalir);
}
	
	
//	-------------------------getters y setters Alto y Ancho		
	public int getAltoS() {
		return altoS;
	}

	public void setAltoS(int altoS) {
		this.altoS = altoS;
	}

	public int getAnchoS() {
		return anchoS;
	}

	public void setAnchoS(int anchoS) {
		this.anchoS = anchoS;
	}


	/**
	 * Launch the application.
	 */
//	------------------------------------			MAIN		------------------------------------
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion s = new Seleccion();
					s.setLocationRelativeTo(null);
					s.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
