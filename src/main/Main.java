package main;

import java.io.IOException;
import java.util.Scanner;

import model.VallaData;


public class Main {

	private Scanner sc;
	private VallaData data=new VallaData();
	public Main() throws IOException {
		sc= new Scanner(System.in);
		int num=0;
		data.loadData(num);
		
	}
	public static void main(String[] args) throws IOException{
		
		Main menu = new Main();
		
		int answerInitialMenu= 0;
		do {
		    answerInitialMenu =menu.initialMenu();
		    menu.initialMenuOption(answerInitialMenu);
		}while (answerInitialMenu !=0);
		
	}
	public int initialMenu() {
		
		System.out.println("select an option: ");
		System.out.println("");
		System.out.println("_____________________________________________________________________________________________________________");
		System.out.println("(1). Import data CSV");
		System.out.println("(2). Add billboard");
		System.out.println("(3). Show billboard");
		System.out.println("(4). Export risk report");
		System.out.println("(0). Exit");
		int answer=sc.nextInt();
		

		return answer;
	}
	public void initialMenuOption(int answerInitialMenu) throws IOException {
		if(answerInitialMenu!=0 && answerInitialMenu!=1 && answerInitialMenu!=2 && answerInitialMenu!=3 && answerInitialMenu!=4){
			System.out.println("Write the number");
		}
		
		switch(answerInitialMenu) {
		case 0: 
			System.out.println("Bye");
			break;
		case 1:
			int answerMenuImportar=0;
			
			answerMenuImportar=importarMenu();
			optionImportarMenu(answerMenuImportar);
			break;
		case 2:
			agregarValla();
			break;
		case 3: 
			mostrarTodasVallas();
			break;
		case 4: 
			reportePeligrosidad();
			break;
		}
		
	}
	public int importarMenu(){
		System.out.println("");
		System.out.println("_____________________________________________________________________________________________________________");
		System.out.println("");
		System.out.println("(1). Import data 1");
		System.out.println("(2). Import data 2");
		System.out.println("(0). Back to menu");
		System.out.println("");
		int answer=sc.nextInt();
		
		

		return answer;
	}
	public void optionImportarMenu(int answerImportarMenu) throws IOException {
		if(answerImportarMenu!=0&&answerImportarMenu!=1&&answerImportarMenu!=2){
			System.out.println("Write the number");
		}
		int num=0;
		switch(answerImportarMenu) {
		case 0: 
			System.out.println("Back to menu");
			break;
		case 1:
			num=1;
			data.loadData(num);
			break;
		case 2:
			num=2;
			data.loadData(num);
			break;
		}
		
	}
	public void agregarValla() throws IOException {
		System.out.println("Add the billboard in a single line separating the data with ++");
		sc.nextLine();
		String line=sc.nextLine();
		String[] datosSeparados=line.split("\\++");
		int num=3;
		data.agregarValla(datosSeparados,num);
	}
	public void mostrarTodasVallas() {
		System.out.println("_____________________________________________________________________________________________________________");
		System.out.println("\n"+data.mostrarTodasVallas()+"\n");
		System.out.println("_____________________________________________________________________________________________________________");
	}
	public void reportePeligrosidad() throws IOException {
		System.out.println("_____________________________________________________________________________________________________________");
		System.out.println("\n"+data.mostrarReportePeligrosidad()+"\n");
		System.out.println("_____________________________________________________________________________________________________________");
		
	}

}
