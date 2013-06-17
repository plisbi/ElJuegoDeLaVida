
public enum PatronesEnum {

	SAPO (new Celula[][]{{Celula.MU,Celula.VI,Celula.VI,Celula.VI},
			 			 {Celula.VI,Celula.VI,Celula.VI,Celula.MU}}),
			 
	PLANEADOR (new Celula[][]{{Celula.VI,Celula.VI,Celula.VI},
				  			  {Celula.VI,Celula.MU,Celula.MU,},
				  			  {Celula.MU,Celula.VI,Celula.MU}}),
				  
	NAVE_LIGERA (new Celula[][]{{Celula.MU,Celula.VI,Celula.MU,Celula.MU,Celula.VI},
								{Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.MU},
								{Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.VI},
								{Celula.MU,Celula.VI,Celula.VI,Celula.VI,Celula.MU}}),
					
	DIEHARD (new Celula[][]{{Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.VI,Celula.MU},
							{Celula.VI,Celula.VI,Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.MU},
							{Celula.MU,Celula.VI,Celula.MU,Celula.MU,Celula.MU,Celula.VI,Celula.VI,Celula.VI}}),
				
	ACORN (new Celula[][]{{Celula.MU,Celula.VI,Celula.MU,Celula.MU,Celula.MU,Celula.MU,Celula.MU},
						  {Celula.MU,Celula.MU,Celula.MU,Celula.VI,Celula.MU,Celula.MU,Celula.MU},
						  {Celula.VI,Celula.VI,Celula.MU,Celula.MU,Celula.VI,Celula.VI,Celula.VI}});
	
	private Celula[][] patron;
	PatronesEnum (Celula[][] patron){
		this.patron=patron;
	}
	
	public Celula[][] getPatron() {
		return patron;
	}
	
	
}
