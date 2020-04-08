package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.angrammi.DAO.AnagrammaDAO;

public class Model {
	private List <String> soluzioni;
	private AnagrammaDAO dao;

	
	public List <String> anagrammi (String parola){
		this.soluzioni=new ArrayList <>();
		//caso iniziale (imposto il livello e la stringa che passo)
		
		//Creiamo la lista di parole che andro a scandire
		parola=parola.toUpperCase();
		List <Character> disponibili= new ArrayList<>();
		for (int i=0; i<parola.length();i++) {
			disponibili.add(parola.charAt(i));
		}
		
		//avviamo la ricorsione
		cerca("", 0, disponibili);
		return this.soluzioni;
	}
	
	private void cerca (String parziale, int livello, List <Character> disponibili ) {
		//caso terminale
		if (disponibili.size()==0) {//parola.lenght==0
			this.soluzioni.add(parziale); //la soluzione parziale è la soluzione totale e posso uscire
		}
		 //caso normale
		for (Character c: disponibili) {
			String temporaneo = parziale+c;
			
			List <Character> rimanenti = new ArrayList <>(disponibili);
			rimanenti.remove(c);
			cerca(temporaneo,livello+1,rimanenti);
		}
	}
	
	public List <String> risultatoCorrette (List <String> soluzioni){
		soluzioni=this.soluzioni;
		List <String> corrette= new ArrayList <>();
				
		for (String s:soluzioni) {
			if (dao.isCorrect(s)==true) {
				corrette.add(s);
			}
		}
	
		return corrette;	
	}
	
	public List <String> risultatoErrate (List <String> soluzioni){
		soluzioni=this.soluzioni;
		List <String> errate= new ArrayList <>();

		
		for (String s:soluzioni) {
			if (dao.isCorrect(s)==false) {
				errate.add(s);
			}
		}
	
		return errate;	
	}
	
}
