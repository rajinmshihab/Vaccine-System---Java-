import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.VaccCentre;

/**
 * 
 */

/**
 * @author 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static ArrayList<People> peoples = new ArrayList<>();
	public static ArrayList<VaccCentre> centres = new ArrayList<>();
	
	
	
	
	public static int counter;
	public static int counterCentre = 0;
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("main called");
		readData(peoples);
		readCentres(centres);
		
	}
	
	public static void displayAll(ArrayList<People> peoples) {
		for(int i=0; i<peoples.size(); i++) {
			
			System.out.println(peoples.get(i).toString());
		}
	}
	
	public static void displayAllCentres(ArrayList<VaccCentre> centres) {
		for(int i=0; i<centres.size(); i++) {
			
			System.out.println(centres.get(i).getCentreName());
		}
	}
	
	public static void storeData(ArrayList<People> peoples) throws IOException {
		FileWriter writer = new FileWriter("data.txt");
		
		for(int i=0; i<peoples.size(); i++) {
			String store_text = peoples.get(i).getFirstname()+","+peoples.get(i).getLastname()+","+peoples.get(i).getDOB()+","
		+peoples.get(i).getCNIC()+","+peoples.get(i).getCity()+","+peoples.get(i).getAge()+","+peoples.get(i).getGender()+","+peoples.get(i).isAppointmentSet()
		+","+peoples.get(i).isVaccinated()+","+peoples.get(i).getKey()+","+peoples.get(i).getType()+"\n";
			writer.write(store_text);
		}
		
		writer.close();
	}
	
	public static void storeCentre(ArrayList<VaccCentre> centres) throws IOException {
		FileWriter writer = new FileWriter("centres.txt");
		
		for (int i = 0 ; i < centres.size() ; i++) {
			String s =
					centres.get(i).getCentreName() + "," +
					centres.get(i).getSupply() + "\n";
			
			writer.write(s);
		}
		
		writer.close();
	}
	
	public static void readData(ArrayList<People> peoples) throws FileNotFoundException {
		File file = new File("data.txt");
		File file2 = new File("centres.txt");
		
		Scanner read;
		
		read = new Scanner(file);
		
		while(read.hasNext()) {
			String line = read.nextLine();
			String [] data = line.split(",");
			
		
			peoples.add(new People(data[0], data[1], data[2], data[3], data[4], data[5], data[6], Boolean.parseBoolean(data[7]),Boolean.parseBoolean(data[8]), data[9], data[10] ));
			counter++;
		}
		
		read.close();
		
		read = new Scanner(file2);
		
		while(read.hasNext()) {
			String line = read.nextLine();
			String [] data = line.split(",");
			
			centres.add(new VaccCentre(data[0], Integer.parseInt(data[1])));
		}
		
		read.close();
		
	}
	
	public static void readCentres(ArrayList<VaccCentre> centres) throws FileNotFoundException {
		File file = new File("centres.txt");
		Scanner read = new Scanner(file);
		
		while(read.hasNext()) {
			String line = read.nextLine();
			String [] data = line.split(",");
			
			centres.add(new VaccCentre(data[0], Integer.parseInt(data[1])));
			counterCentre++;
			System.out.println(line);
		}
	}
	
}
