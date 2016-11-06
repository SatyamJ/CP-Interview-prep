package unit1;
import java.util.Scanner;

public class SpiralOrder {

	public static void main(String[] args) {
		
		SpiralOrder so = new SpiralOrder();
		int[][] inputArray = so.takeInput();
//		int[][] inputArray = {{1,2,3},{4,5,6},{7,8,9}};
		so.display(inputArray);
		so.printSpirally(inputArray);
	}
	
	public void printSpirally(int[][] arr){
		int rows = arr.length;
		int cols = arr[0].length;
		
		int rowStart, rowEnd, colStart, colEnd, centralSpiralIndex, decidingFactor;
		rowStart = 0;
		rowEnd = rows-1;
		colStart = 0;
		colEnd = cols-1;
		
		if(cols<rows)
			decidingFactor = cols;
		else
			decidingFactor = rows;
		
		centralSpiralIndex = (int) Math.ceil((double)decidingFactor/2) - 1;
		
		System.out.println("\nArray elements in spiral order:");
		for(int spiral=0; spiral<=centralSpiralIndex; spiral++){
			if((rowStart==rowEnd) || (colStart==colEnd)){
				if(rowStart==rowEnd){
					for(int j=colStart; j<=colEnd; j++)
						System.out.print(arr[rowStart][j]+" ");
				}else{
					for(int i=rowStart; i<=rowEnd; i++)
						System.out.print(arr[i][colStart]+" ");
				}
				break;
			}else{
				for(int j=colStart; j<=colEnd; j++){
					System.out.print(arr[rowStart][j]+" ");
				}
				
				for(int i=rowStart+1; i<=rowEnd; i++){
					System.out.print(arr[i][colEnd] + " ");
				}
				
				for(int j=colEnd-1; j>=colStart; j--){
					System.out.print(arr[rowEnd][j] + " ");
				}
				
				for(int i=rowEnd-1; i>=rowStart+1; i--){
					System.out.print(arr[i][colStart] + " ");
				}
				
				if((rowStart<rowEnd) && (rowStart!=rowEnd-1)){
					rowStart++;
					rowEnd--;
				}
				
				if((colStart<colEnd) && (colStart!=colEnd-1)){
					colStart++;
					colEnd--;
				}
			}
			
		}
	}
	
	public int[][] takeInput(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What will be the number of rows in your array?");
		int rows = sc.nextInt();
		
		System.out.println("What will be the number of columns in your array?");
		int cols = sc.nextInt();
		
		int[][] ipArray = new int[rows][cols];
		
		System.out.println("Now enter the elements of your array..");
		for(int i=0; i<rows; i++){
			System.out.println("Enter the elements of row "+i+":");
			for(int j=0; j<cols; j++){
				ipArray[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		return ipArray;
	}
	
	public void display(int[][] arr){
		int rows = arr.length;
		int cols = arr[0].length;
		
		System.out.print("Your array is:");
		for(int i=0; i<rows; i++){
			System.out.print("\n");
			for(int j=0; j<cols; j++){
				System.out.printf("%4d", arr[i][j]);
			}
		}
	}

}
