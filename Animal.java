public abstract class Animal
{
	private Cell cell;
	private int totalSurvivalSteps=0;
	
	public abstract boolean isRabbit();
	public abstract void becomeEaten();
	public abstract boolean timeToBreed();
	public abstract Animal giveBirth();
	public abstract void move();
	
	public Cell getCell(){
		return this.cell;
	}
	
	public int getTotalSurvivalSteps(){
		return  this.totalSurvivalSteps;
	}
	
	public void setCell(Cell c){
		this.cell=c;
	}
	
	public void survived(){
		this.totalSurvivalSteps++;
	}
	
	public void randomMove(){
		
		Cell randomNeighborCell = getCell().getRandomNeighbor();
		
		if (randomNeighborCell!=null){
			Cell previousCell = getCell();
            
			if(randomNeighborCell.isEmpty()){				
			
				getCell().getAnimal().setCell(randomNeighborCell);
				randomNeighborCell.setAnimal(previousCell.getAnimal());					
				randomNeighborCell.getAnimal().survived();
			
				previousCell.setAnimal(null);			
			}
		}
	}
	
	public Animal breed(){
		Animal newAnimal;
		
		Cell randomNeighborCell=getCell().getRandomNeighbor();
		if (randomNeighborCell!=null && randomNeighborCell.isEmpty()) {
			newAnimal = getCell().getAnimal().giveBirth();
			randomNeighborCell.setAnimal(newAnimal);
			randomNeighborCell.getAnimal().setCell(randomNeighborCell);
			
			return newAnimal;
		}
		return null; 
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757