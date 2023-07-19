import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

class PopulationSimulator 
{
	private Grid grid = new Grid();
	private HashSet<Rabbit> rabbits = new HashSet<Rabbit>();
	private HashSet<Fox> foxes= new HashSet<Fox>();
	private int NUM_OF_RABBITS;    //=100;        
	private int NUM_OF_FOXES;       //=5;
	
	public void setNumOfRabbits(int rnum) {
		this.NUM_OF_RABBITS=rnum;
	}
	
	public void setNumOfFoxes(int fnum) {
		this.NUM_OF_FOXES=fnum;
	}
	
	public void populateGrid(){
		for(int i=0;i<this.NUM_OF_RABBITS;i++){
			Rabbit rabbit = new Rabbit();
			grid.addRandomly(rabbit);
			rabbits.add(rabbit);
		}
		for(int i=0;i<this.NUM_OF_FOXES;i++){
			Fox fox = new Fox();
			grid.addRandomly(fox);
			foxes.add(fox);
		}
	}

	public void handleFoxes(){
		
		ArrayList<Fox> foxesToAdd = new ArrayList<Fox>();
		ArrayList<Fox> foxesToRemove = new ArrayList<Fox>();
		
		for(Fox fox: foxes){
			fox.move();
			if(!fox.starve()){
				if(fox.timeToBreed()){
					Fox newFox = (Fox) fox.breed();
					if (newFox!=null){
						foxesToAdd.add(newFox);
					}
				}
			}else{			
				foxesToRemove.add(fox);
			}
		}

		for(int i=0;i<foxesToAdd.size();i++){
			foxes.add(foxesToAdd.get(i));
		}
		foxesToAdd.clear();
		
		for(int i=0;i<foxesToRemove.size();i++){
			foxes.remove(foxesToRemove.get(i));
		}
		foxesToRemove.clear();
	}
	
	public void handleRabbits(){
		
		ArrayList<Rabbit> rabbitsToAdd = new ArrayList<Rabbit>();
		ArrayList<Rabbit> rabbitsToRemove = new ArrayList<Rabbit>();
		
		for(Rabbit rabbit: rabbits){
			
			if(!rabbit.isEaten()){
				rabbit.move();
				if(rabbit.timeToBreed()){
					Rabbit newRabbit= (Rabbit) rabbit.breed();
					
					if (newRabbit!=null) {
						rabbitsToAdd.add(newRabbit);
					}
				}
			}
			else {
				rabbitsToRemove.add(rabbit);
			}
		}
		
		for(int i=0;i<rabbitsToAdd.size();i++){
			rabbits.add(rabbitsToAdd.get(i));
		}
		rabbitsToAdd.clear();
		
		for(int i=0;i<rabbitsToRemove.size();i++){
			rabbits.remove(rabbitsToRemove.get(i));
		}
		rabbitsToRemove.clear();
	}
	
	public void simulate(int simulationSteps){
		
		Scanner input=new Scanner(System.in);
		this.populateGrid();
		
		for (int i=0; i<simulationSteps; i++) {
			System.out.println("**************************Simulation Step: "+ i + " ***************************");
			
			System.out.println(this.grid);
			System.out.println("Rabbits: " + this.rabbits.size()+"   Foxes: " + this.foxes.size());
			System.out.println("*******************************************************************************");
			handleFoxes();
			handleRabbits();
			promptEnterKey();

		}
	}
	
	public void promptEnterKey(){
		System.out.println("Press \"ENTER\" to continue...");
		Scanner s = new Scanner(System.in);
		s.nextLine();
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757