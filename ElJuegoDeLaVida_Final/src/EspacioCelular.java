import java.util.Random;

public class EspacioCelular {


		protected Celula matriz[][];
		private int ancho ;
		private int alto ;
		private int porcentajeVivas ;
		
		 
//constructores
		public EspacioCelular (int ancho, int alto){
			matriz = new Celula [this.ancho = ancho][this.alto = alto];	
			limpiar();
			crearUno();
		}	
		
		public EspacioCelular (int ancho, int alto, int porcentajeVivas){
			matriz = new Celula [ancho][alto];	
			limpiar();
			crearAleatorio(porcentajeVivas);
		}
		
//obtener la matriz		
		public Celula[][] getMatriz(){
			Celula copia[][]= new Celula[matriz.length][matriz[0].length];
			for(int i=0;i<matriz.length;i++)
				copia[i]=matriz[i].clone();
			return copia;
		}
			
//metodo LIMPIAR pulsar 1
		public void limpiar(){
			for(int i=0;i<matriz.length; i++){
				for (int j=0; j<matriz[i].length; j++){
					matriz[i][j]=Celula.MU;
				}
			}
		}
		
//metodo CREAR_ALEATORIO pulsar 2
		public void crearAleatorio(int porcentajeVivas){
			Random r = new Random ();
			int num = matriz.length * matriz[0].length * porcentajeVivas / 100;
			
			for(int i=0; i<num; i++){
				int f=0;
				int c=0;
				do {
					f = r.nextInt(matriz.length);
					c = r.nextInt(matriz[0].length);
				}while (matriz[f][c] != Celula.MU);
				matriz[f][c]=Celula.VI;
			}
		}

//metodo crear MATRIZ CONTROLADA
				public void crearUno(){
						//matriz[1][1]=Celula.VI;
						
						matriz[1][5]=Celula.VI;
						matriz[1][6]=Celula.VI;
						
						matriz[3][1]=Celula.VI;
						matriz[3][2]=Celula.VI;
						matriz[3][3]=Celula.VI;
						
						matriz[3][6]=Celula.VI;
						matriz[3][7]=Celula.VI;
						matriz[3][8]=Celula.VI;
						matriz[3][9]=Celula.VI;
						
						matriz[6][1]=Celula.VI;
						matriz[6][2]=Celula.VI;
						matriz[5][1]=Celula.VI;
						
						matriz[7][6]=Celula.VI;
						matriz[7][7]=Celula.VI;
						matriz[8][6]=Celula.VI;
						matriz[8][7]=Celula.VI;
				}
		

//	---------------------	metodo para poner PatronesEnumen una MATRIZ vacia 
				public void crearPatron(PatronesEnum patron){
					for(int i=0;i<patron.getPatron().length; i++){
						for (int j=0; j<patron.getPatron()[i].length; j++){
							matriz[i+alto/2][j+ancho/2]=patron.getPatron()[i][j];
						}
					}
				}
				
//	-------------------------getters y setters Alto y Ancho				
				public int getAncho() {
									return ancho;
								}
				
				public int getAlto() {
									return alto;
								}
				

				public void setAncho(int ancho) {
					this.ancho = ancho;
				}

				public void setAlto(int alto) {
					this.alto = alto;
				}

		//calcular VIVAS_ALREDEDOR
		public int vivasAlrededor (int i, int j){
			int total=0;
			for (int k=i-1; k<=i+1; k++){
				for (int l=j-1; l<=j+1; l++){
				
					
					try{
						if((matriz[k][l]==Celula.VI || matriz[k][l]==Celula.MO) && (k!=i || l!=j)) 
							total++;
					}catch (ArrayIndexOutOfBoundsException ex){ 	}
				}
			}
			return total;	 
		}
		 	
//cambio de generacion 
		public void cambioGeneracion (){
			for(int i=0;i<matriz.length; i++){
				for (int j=0; j<matriz[i].length; j++){
				if(matriz[i][j] == Celula.MU && vivasAlrededor(i,j)==3)
							matriz[i][j] = Celula.GE;
					if(matriz[i][j] == Celula.VI && (vivasAlrededor(i,j) <= 1 || vivasAlrededor(i,j)>=4))
							matriz[i][j] = Celula.MO;
					}
				}
			
		//para el modo grafico podria .... 
			for(int i=0;i<matriz.length; i++){
				for (int j=0; j<matriz[i].length; j++){
					if(matriz[i][j] == Celula.GE) 	matriz[i][j] = Celula.VI;
					if(matriz[i][j] == Celula.MO) matriz[i][j] = Celula.MU;
					}
				}
			
			}
		
//llave final programa	
}
