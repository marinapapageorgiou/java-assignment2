import java.util.ArrayList;
import java.util.Random;

class Cell
{
	private ArrayList<Cell> neighborcells = new ArrayList<Cell>();  
	private Animal animal;   

	private int i;
	private int j;
	
	
	public void set_i(int i) {
		this.i=i;
	}
	
	public void set_j(int j) {
		this.j=j;
	}
	
	
	public int get_i() {
		return this.i;
	}
	
	public int get_j() {
		return this.j;
	}
	
	public ArrayList<Cell> getNeighborcells(){
		for(int i=0;i<neighborcells.size();i++){
			neighborcells.get(i);
			if(neighborcells.get(i)==null){
				return null;
			}
		}
		return neighborcells;
	}
	
	public void addNeighbor(Cell cell){
		neighborcells.add(cell);
	}
	
	public Cell getRandomNeighbor(){  
		
		Random random = new Random();
		int r=random.nextInt(3);
		
		if(r<this.getNeighborcells().size()) {
				
			if (this.getNeighborcells().get(r)!=null) {
				return this.getNeighborcells().get(r);
			}
            else {
                return null;
			}
		} 
		return null;   
	}
	
	public int numOfNeighnors(){
		return this.neighborcells.size();
	}
		
	public Animal getAnimal(){
		return this.animal;
	}
	
	public void setAnimal(Animal a){
		this.animal=a;
	}
	
	public void removeAnimal(){
		neighborcells.remove(animal);
	}
	
	public boolean isEmpty(){
  
	    if (this.getAnimal()==null){
			return true;
		}
		return false;
	}
	
	public boolean containsRabbit(Cell cell){

		if (!cell.isEmpty()){
			if (cell.getAnimal().isRabbit()) {
				return true;
			}
		}
		return false;                                     
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757