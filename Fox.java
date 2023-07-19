public class Fox extends Animal
{
	private int lastAteSteps=0;
	
	public boolean isRabbit(){
		return false;
	}
	
	public boolean timeToBreed(){
		if((getCell().getAnimal().getTotalSurvivalSteps()>0) && (getCell().getAnimal().getTotalSurvivalSteps()%8==0)){
			return true;
		}
		return false;
	}

	public void becomeEaten(){
	
	}
	
	public Fox giveBirth(){
		Fox fox = new Fox();
		
		return fox; 
	}
	
	public void move(){
		boolean found=false;
		
		for (int i=0; i<getCell().getNeighborcells().size() && found==false; i++) {
			
			if(getCell().getNeighborcells().get(i).containsRabbit(getCell().getNeighborcells().get(i))){
				
				found=true;
					
				Cell cellContainsRabbit=getCell().getNeighborcells().get(i);
				Cell cellContainsFox=getCell();
				
				cellContainsRabbit.getAnimal().becomeEaten();
				cellContainsRabbit.setAnimal(cellContainsFox.getAnimal());
				cellContainsFox.getAnimal().setCell(cellContainsRabbit);
								
				cellContainsFox.getAnimal().survived();
				cellContainsFox.setAnimal(null);
				
				this.lastAteSteps=0;
			}
		}
		
		if (!found) {
			this.lastAteSteps++;
			getCell().getAnimal().randomMove();
		}
	}	
	
	public boolean starve(){
		if(this.lastAteSteps>3){
			getCell().setAnimal(null);
			return true;
		}
		return false;
	}		
	
	public String toString(){
		return "X";
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757