package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VallaData {
	private ArrayList<Valla>vallas;
	private String [] datosSeparados= new String[4];;
	
	public VallaData() {
		vallas=new ArrayList<>();
	}
	
	public void loadData(int num) throws IOException {
		String path="";
		if(num==1) {
			path="../seguimiento6/src/Datos1.csv";
		}else if(num==2) {
			path="../seguimiento6/src/Datos2.csv";
		}else if(num==0) {
			path="../seguimiento6/src/DatosPrograma.csv";
		}
		File file=new File(path);
		if(file.exists()) {
			FileInputStream fis=new FileInputStream(file);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(isr);
			String line;
			line=reader.readLine();
			while((line=reader.readLine())!=null) {
				String[] datosSeparados=line.split("\\|");
				agregarValla(datosSeparados,num);
		    }	
		}
	}
	
	public void agregarValla(String [] datosSeparados,int num) throws IOException {
		int altura=Integer.parseInt(datosSeparados[0]);
		int ancho=Integer.parseInt(datosSeparados[1]);
		boolean uso=Boolean.parseBoolean(datosSeparados[2]);
		String empresa=datosSeparados[3];
		Valla valla=new Valla(altura,ancho,uso,empresa);
		vallas.add(valla);
		
		String datosCompletosValla=+ancho+"|"+altura+"|"+uso+"|"+empresa+"\n";
		if(num!=0) {
			File newFolder=new File("../seguimiento6/src/DatosPrograma.csv");
			if (!newFolder.exists()) {
				newFolder.createNewFile();
				FileWriter fw=new FileWriter(newFolder.getAbsoluteFile(), true);
	        	BufferedWriter bw = new BufferedWriter(fw);
	            bw.write("width|height|inUse|brand"+"\n");
	            if (bw != null)bw.close();
	            if (fw != null) fw.close();
				
	        }
			if(newFolder.exists()) {
	        	//FileOutputStream fos=new FileOutputStream(newFolder);
	        	FileWriter fw=new FileWriter(newFolder.getAbsoluteFile(), true);
	        	BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(datosCompletosValla);
	            if (bw != null)bw.close();
	            if (fw != null) fw.close();
	        }
		}
	}
	public String mostrarTodasVallas() {
		int contadorVallas=0;
		String todasVallas="W	H	inUse	Brand"+"\n";
		for(int i=0;i<vallas.size();i++) {
			todasVallas=todasVallas+vallas.get(i).getAncho()+"  "+vallas.get(i).getAltura()+"  "+vallas.get(i).isUso()+" "+vallas.get(i).getEmpresa()+"\n";
			contadorVallas++;
		}
		todasVallas+="TOTAL: "+contadorVallas+" vallas";
		return todasVallas;
	}
	public String mostrarReportePeligrosidad() throws IOException {
		int contador=1;
		int area=0;
		String reporteSinInicio="";
		String reporte="_________________________\r\n"
				+ "DANGEROUS BILLBOARD REPORT\r\n"
				+ "______________________________\r\n"
				+ "The dangerous billboard are:\r\n";
		for(int i=0;i<vallas.size();i++) {
			area=vallas.get(i).getAncho()*vallas.get(i).getAltura();
			if(area>=200000) {
				reporte+=contador+". "+"Billboard "+vallas.get(i).getEmpresa()+" with area "+area+"cm^2"+"\n";
				reporteSinInicio+=contador+". "+"Billboard "+vallas.get(i).getEmpresa()+" with area "+area+"cm^2"+"\n";
				contador++;
			}
		}
		
		File newFolder=new File("../seguimiento6/src/report.txt");
		if (!newFolder.exists()) {
			newFolder.createNewFile();
			FileWriter fw=new FileWriter(newFolder.getAbsoluteFile(), true);
        	BufferedWriter bw = new BufferedWriter(fw);
            bw.write(reporte);
            if (bw != null)bw.close();
            if (fw != null) fw.close();
			
        }
		if(newFolder.exists()) {
        	//FileOutputStream fos=new FileOutputStream(newFolder);
        	FileWriter fw=new FileWriter(newFolder.getAbsoluteFile(), true);
        	BufferedWriter bw = new BufferedWriter(fw);
            bw.write(reporteSinInicio);
            if (bw != null)bw.close();
            if (fw != null) fw.close();
        }
		return reporte;
	}
}
