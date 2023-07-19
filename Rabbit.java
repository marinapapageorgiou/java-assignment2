public class Rabbit extends Animal
{
	private boolean eaten=false;
	
	public boolean isRabbit(){
		return true;
	}
	
	public boolean timeToBreed(){
		if((getCell().getAnimal().getTotalSurvivalSteps()>0) && (getCell().getAnimal().getTotalSurvivalSteps()%3==0)){		
			return true;
		}
		return false;
	}
	
	public Rabbit giveBirth(){
		
		Rabbit rabbit = new Rabbit();
		return rabbit;
	}
	
	public void move(){
		getCell().getAnimal().randomMove();
	}
	
	public void becomeEaten(){
		eaten=true;
	}
	
	public boolean isEaten(){
		return this.eaten;
	}
	
	public String toString(){
		return "O";
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757