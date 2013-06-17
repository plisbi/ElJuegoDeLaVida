import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class Panel1 extends JPanel implements MouseListener{
	
	private int altoP;
	private int anchoP;
	private PatronesEnum patronP;
	
	private int porcentajeVivas = 50;
	private int diametroCelula = 20;
	//EspacioCelular pepe1= new EspacioCelular( ancho, alto, porcentajeVivas);
	protected EspacioCelular pepe;
	
	Thread hilo=null;
	boolean inicial=false;
	
//	------------------------------------		Constructor		------------------------------------
	public Panel1() {
		pepe = new EspacioCelular( anchoP, altoP);
		setPreferredSize(new Dimension(altoP*diametroCelula, anchoP*diametroCelula));
		setBackground(Color.BLACK);
		pepe.limpiar();
		addMouseListener(this);
	}
	
	public Panel1(int altoP, int anchoP){
		this.anchoP=anchoP;
		this.altoP=altoP;
		
		pepe = new EspacioCelular( anchoP, altoP);
		setPreferredSize(new Dimension(altoP*diametroCelula, anchoP*diametroCelula));
		setBackground(Color.BLACK);
		pepe.limpiar();
		addMouseListener(this);
	}

//	------------------------------------	Forma y Color de las celulas	------------------------------------
	public void paint(Graphics g) {
		for(int i=0;i<pepe.getAncho(); i++){
			for (int j=0; j<pepe.getAlto(); j++){

				int y=(i*diametroCelula);
				int x=(j*diametroCelula);
				if (pepe.matriz[i][j]==Celula.VI){
					g.setColor(Color.ORANGE);
					g.fillOval(x, y, diametroCelula,diametroCelula);
				}
				if (pepe.matriz[i][j]==Celula.MU){
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(x, y, diametroCelula, diametroCelula);
				}
//				if (pepe.matriz[i][j]==Celula.MO){
//					g.setColor(Color.GRAY);
//					g.fillOval(x, y, diametroCelula, diametroCelula);
//				}
//				if (pepe.matriz[i][j]==Celula.GE){
//					g.setColor(Color.YELLOW);
//					g.fillOval(x, y, diametroCelula, diametroCelula);
//				}
			}	
		}	
	}

//	------------------------------------	Metodos para Pintar		------------------------------------	
	public void inicioP(){
		pepe.limpiar();
		pepe.crearAleatorio(porcentajeVivas);
		//pepe.crearUno();      //prueba que funciona el espacio celular
		repaint();
	}
	
	public void limpiarP(){
		pepe.limpiar();
		repaint();
	}
	
	public void cambioGeneracionP(){
		pepe.cambioGeneracion();
		repaint();
	}
	
	public void crearPatronP(PatronesEnum patronP){
		this.patronP=patronP;
		pepe.crearPatron(patronP);
		repaint();
	}

//	------------------------------------	Metodos para el Hilo	------------------------------------		
	public void hilo(){
		if(hilo==null){
			inicial=true;
			hilo = new Thread(new Runnable() {
				public void run() {
					
					while (inicial) {
						cambioGeneracionP();
						repaint();
						try { Thread.sleep(500); } 
							catch (InterruptedException e1) {}
					}
				}
			});
			hilo.start();
		}
	}
	
	public void dentenHilo(){
		hilo=null;
		inicial=false;
	}
	
//	-------------------------getters y setters------------	
	
	public int getAlto() {
		return altoP;
	}

	public void setAlto(int alto) {
		this.altoP = alto;
	}

	public int getAncho() {
		return anchoP;
	}

	public void setAncho(int ancho) {
		this.anchoP = ancho;
	}

	public int getPorcentajeVivas() {
		return porcentajeVivas;
	}

	public void setPorcentajeVivas(int porcentajeVivas) {
		this.porcentajeVivas = porcentajeVivas;
	}

	public int getDiametroCelula() {
		return diametroCelula;
	}

	public void setDiametroCelula(int diametroCelula) {
		this.diametroCelula = diametroCelula;
	}

//	----------------- metodos del MouseListener

	public void mouseClicked(MouseEvent e) {
		
		int dc=getDiametroCelula();
		int fila = (e.getY()/dc);
		int columna = (e.getX()/dc);	
		if (pepe.matriz[fila][columna] == Celula.MU){
			pepe.matriz[fila][columna] = Celula.VI;
		}else{
			pepe.matriz[fila][columna] = Celula.MU;
		}
		repaint();
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
//llave de fin
}
