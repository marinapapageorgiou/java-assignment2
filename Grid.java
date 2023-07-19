import java.util.Random;
import java.util.Scanner;

class Grid
{
	private final int SIZE=20;
	private Cell grid[][] = new Cell [SIZE][SIZE];
	
	public Grid() {
		for(int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				grid[i][j]=new Cell();
				grid[i][j].set_i(i);
				grid[i][j].set_j(j);
				if (i>0){
					grid[i-1][j].addNeighbor(grid[i][j]);
					grid[i][j].addNeighbor(grid[i-1][j]);
				}
				
				if (j>0){
					grid[i][j-1].addNeighbor(grid[i][j]);
					grid[i][j].addNeighbor(grid[i][j-1]);
				}
			}
		}
	}
	
	public void addRandomly(Animal animal) {
		
		Random random = new Random();
		int gridLine=random.nextInt(this.SIZE);
		int gridColumn=random.nextInt(this.SIZE);
		
		while (grid[gridLine][gridColumn].getAnimal()!=null) {
			gridLine=random.nextInt(this.SIZE-1);
			gridColumn=random.nextInt(this.SIZE-1);
		}	
		
        animal.setCell(grid[gridLine][gridColumn]);
		grid[gridLine][gridColumn].setAnimal(animal);
	}
	
	public String toString() {
		String gridAsString = new String();
		
		for (int i=0; i<this.SIZE; i++) {
			for (int j=0; j<this.SIZE; j++) {
				
				if (this.grid[i][j].getAnimal()==null) {
					
					gridAsString+=" _ ";
				}
				else {
					
					gridAsString+=" "+this.grid[i][j].getAnimal().toString()+" ";
				}
			}
			gridAsString+="\n";
		}
		return gridAsString;
	}
	
	public static void main(String args[]){	
		Grid grid = new Grid();
	
		for(int i=0; i<10; i++) {
			Rabbit rabbit=new Rabbit();
			grid.addRandomly(rabbit);
		}
		for(int i=0; i<10; i++){
			Fox fox=new Fox();
			grid.addRandomly(fox);
		}
		System.out.println(grid.toString());
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757