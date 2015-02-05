import java.util.Scanner; 

public class LearningArrays {

	public static void main(String[] args) {
	
		int emp1 = 5000;
		int emp2 = 6000;
		System.out.println(emp1+emp2);
		
		int[] salary;
		salary  = new int[10];
		
		salary[0] = 5000;
		salary [1] = 6000;
		
		System.out.println(salary[0]+salary[1]);
		
		
		String [] texto = new String[5];
		Scanner sc = new Scanner(System.in);  
		
		for (int i=0; i<10; i++){
			System.out.println("Digite um texto:");
			texto[i] = sc.nextLine(); 
			System.out.println(texto[i]);
		}


	}

}
