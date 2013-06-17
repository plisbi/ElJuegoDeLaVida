import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.lang.Thread;

public class Ventana2 extends JFrame implements ActionListener{

	
	private JButton cmdInicio;		//crea generaciones sin parar y se comvierte en parar al segundo clic.
	private JButton cmdSiguiente;	//siguiente generacion (solo si paras)
	private JButton cmdLimpiar;		//todas las celulas a muertas
	private JButton cmdSalir;		//cierra la ventana y para la ejecucion
	private JButton cmdVolver;		//vuelve a Seleccion
	
	private static int altoV;
	private static int anchoV;
	private PatronesEnum patronV;
	
	private Panel1 p;
	private boolean hayHilo = false;
	
	private JToolBar barraHerramientas = new JToolBar();
	private JPanel panel;
	private JToolBar toolBar;

	


//	------------------------------------			Constructor		------------------------------------
	public Ventana2(int altoV, int anchoV){
		
		super("-- EL JUEGO DE LA VIDA --");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		this.altoV=altoV;
		this.anchoV=anchoV;
		
		p=new Panel1 (altoV, anchoV);
		
//	----------------- Inicio/Paro
						cmdInicio = new JButton("Iniciar");
						cmdInicio.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e) {
									cmdInicio.setVisible(true);
									cmdSiguiente.setVisible(true);
									cmdLimpiar.setVisible(true);
									cmdVolver.setVisible(true);
									cmdSalir.setVisible(true);
									p.cambioGeneracionP();
									if (!hayHilo){
										cmdSiguiente.setEnabled(false);
										p.hilo();
										hayHilo=true;
										cmdInicio.setText("Detener");
									}else{
										cmdSiguiente.setEnabled(true);
										p.dentenHilo();
										hayHilo=false;
										cmdInicio.setText("Seguir");
									}
							}
						}); // fin del actionListener
						
						//	----------------- Siguiente Generacion	
								cmdSiguiente = new JButton("Siguiente generacion");
								cmdSiguiente.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e) {
											p.cambioGeneracionP();
									}
								});
								barraHerramientas.setFloatable(false);
								
//	----------------- add botones a la barra de herramientas
								barraHerramientas.add(cmdInicio);
								barraHerramientas.add(cmdSiguiente);
										cmdSiguiente.setVisible(true);
										cmdSiguiente.setEnabled(false);
										
//		----------------- add Barra de herramientas y Panel1
										//si anado al inicio del metodo, tarda en leer los botones y crea un retardo.
											getContentPane().add(barraHerramientas, BorderLayout.PAGE_START);
			
			toolBar = new JToolBar();
			barraHerramientas.add(toolBar);
			toolBar.setFloatable(false);
			
			//	----------------- Limpiar
					cmdLimpiar = new JButton("Limpiar");
					toolBar.add(cmdLimpiar);
					cmdLimpiar.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
								p.limpiarP();
								p.dentenHilo();
								hayHilo=false;
								cmdInicio.setText("Iniciar");
						}
					}); 
					cmdLimpiar.setVisible(true);
					
					cmdVolver =new JButton ("Volver");
					toolBar.add(cmdVolver);
					cmdVolver.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							setVisible(false);
							final Seleccion s= new Seleccion();
							s.setVisible(true);
							s.setLocationRelativeTo(null);
						}
					});
					cmdVolver.setVisible(true);
					
					//	----------------- Salir
							cmdSalir = new JButton("Salir");
							toolBar.add(cmdSalir);
							cmdSalir.setHorizontalAlignment(SwingConstants.RIGHT);
							cmdSalir.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e) {
										System.exit(0);
								}
							});
							cmdSalir.setVisible(true);
							
							panel = new JPanel();
							getContentPane().add(panel, BorderLayout.SOUTH);
							panel.add(p);
			setVisible(true);
			pack();
	}
	
//	----------------- EspacioCelular automatico
	public void automatico(){

		cmdInicio.setVisible(true);
		cmdInicio.setEnabled(false);
		cmdSiguiente.setVisible(true);
		cmdLimpiar.setVisible(true);
		cmdVolver.setVisible(true);
		cmdSalir.setVisible(true);
		p.inicioP();
		if (!hayHilo){
			cmdSiguiente.setEnabled(false);
			cmdInicio.setEnabled(true);
			p.hilo();
			hayHilo=true;
			cmdInicio.setText("Detener");
		}else{
			cmdSiguiente.setEnabled(true);
			p.dentenHilo();
			hayHilo=false;
			cmdInicio.setText("Seguir");
		}
	}
	
//	----------------- EspacioCelular con patron
	public void conPatron( PatronesEnum patronV){
		
		this.patronV=patronV;
		
		cmdInicio.setVisible(true);
		cmdInicio.setEnabled(false);
		cmdSiguiente.setVisible(true);
		cmdLimpiar.setVisible(true);
		cmdVolver.setVisible(true);
		cmdSalir.setVisible(true);
		p.crearPatronP(patronV);
		if (!hayHilo){
			cmdSiguiente.setEnabled(false);
			cmdInicio.setEnabled(true);
			p.hilo();
			hayHilo=true;
			cmdInicio.setText("Detener");
		}else{
			cmdSiguiente.setEnabled(true);
			p.dentenHilo();
			hayHilo=false;
			cmdInicio.setText("Seguir");
		}
	}
	
	
	
	public int getAltoV() {
		return altoV;
	}

	public int getAnchoV() {
		return anchoV;
	}

	public void setAltoV(int altoV) {
		this.altoV = altoV;
	}

	public void setAnchoV(int anchoV) {
		this.anchoV = anchoV;
	}

	
	
	//	------------------------------------			MAIN		------------------------------------
	public static void main(String[] args) {
		
		Ventana2 v = new Ventana2(altoV, anchoV);
		System.out.println(v.altoV + " - " + v.anchoV);
		v.setLocationRelativeTo(null);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}