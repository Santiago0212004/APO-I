package model;

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixCalculator {
	
	private ArrayList<int[][]> numericMatrices;
	private ArrayList<String[][]> stringMatrices;
	
	public MatrixCalculator() {
		numericMatrices= new ArrayList<int[][]>() ;
		stringMatrices= new ArrayList<String[][]>();
		
	}
	
	public String showMatrices() {
		String out="";
		out += "Numeric matrices \n";
		for(int i=0; i< numericMatrices.size(); i++) {
			out+= printNumeric(numericMatrices.get(i));

			if(hasOdd(numericMatrices.get(i))){
				out += "\nHas at least one odd number";
			}
			else{
				out += "\nDoesn't have odd numbers";
			}

			if(hasEven(numericMatrices.get(i))){
				out += "\nHas at least one even number";
			}
			else{
				out += "\nDoesn't have even numbers";
			}
		}


		out += "\n\nString matrices \n";
		for(int i=0; i< stringMatrices.size(); i++) {
			out+= printString(stringMatrices.get(i));
		}
		
		return out;
	}

	private String printString(String[][] matrix) {
		String print ="";
		for (int i=0; i< matrix.length; i++ ) { // filas matrix.length
			for (int j = 0; j < matrix[0].length; j++) { //columnas matrix[0].length
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}

	private String printNumeric(int[][] numbers) {
		String print ="";
		for (int i=0; i< numbers.length; i++ ) { // filas numbers.length
			for (int j = 0; j < numbers[0].length; j++) { //columnas numbers[0].length
				print += numbers[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}

	
	

	public String createMatrix(int type, int rows, int columns) {
		String out="";
		switch(type) {
		case 1: //numeric Matrix
			int [][] newIntMatrix;
			newIntMatrix= new int[rows][columns];
			
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					if(j==i){
						newIntMatrix[i][j] = 1;
					}
					else{
						newIntMatrix[i][j] = 0;
					}
				}
			}

			numericMatrices.add(newIntMatrix);
			out = printNumeric(newIntMatrix);
			
			break;
		case 2:
			String [][] newStringMatrix;
			newStringMatrix = new String[rows][columns];

			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					if(j==i){
						newStringMatrix[i][j] = "A";
					}
					else{
						newStringMatrix[i][j] = "E";
					}
				}
			}

			stringMatrices.add(newStringMatrix);
			out = printString(newStringMatrix);
		}
		
		return out;
	}
	
	public boolean hasOdd (int[][] numMatrix) {
		boolean odd = false;

		for (int i=0; i< numMatrix.length && !odd; i++ ) { 
			for (int j = 0; j < numMatrix[0].length && !odd; j++) { 
				if(numMatrix[i][j]%2==1){
					odd = true;
				}
			}
		}

		return odd;
	}

	public boolean hasEven (int[][] numMatrix) {
		boolean even = false;

		for (int i=0; i< numMatrix.length && !even; i++ ) { 
			for (int j = 0; j < numMatrix[0].length && !even; j++) { 
				if(numMatrix[i][j]%2==0){
					even = true;
				}
			}
		}

		return even;
	}
	
	public boolean hasOddInDiffRows (int[][] numMatrix) {
		boolean oddInRow = false;
		boolean oddInMoreRows = false;

		int odds = 0;


		for (int i=0; i< numMatrix.length && !oddInMoreRows; i++ ) { 
			for (int j = 0; j < numMatrix[0].length && !oddInRow; j++) { 
				if(numMatrix[i][j]%2==1){
					oddInRow = true;
					odds += 1;

					if(odds>1){
						oddInMoreRows = true;
					}
				}
			}
		}

		return oddInMoreRows;
	}

	public void addNumeric(int[][] numMatrix){
		numericMatrices.add(numMatrix);
	}

}
