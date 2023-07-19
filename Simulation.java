import java.util.Scanner;
class Simulation
{
	public static void main(String args[]){
		PopulationSimulator populationSimulator=new PopulationSimulator();
		
		Scanner input=new Scanner(System.in);
		System.out.println("Give the number of steps: ");
		int numberofsteps=input.nextInt();
		
		System.out.println("Give the initiate number of rabbit's and foxe's;");
		populationSimulator.setNumOfRabbits(input.nextInt()); 
		populationSimulator.setNumOfFoxes(input.nextInt()); 

		populationSimulator.simulate(numberofsteps);
	}
}

//ONOMA: MARINA PAPAGEORGIOU
//AM: 4757