package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.angrammi.DAO.AnagrammaDAO;

public class Model {
	private Set <String> soluzioni;
	private AnagrammaDAO dao= new AnagrammaDAO();

	
	public Set <String> anagrammi (String parola){
		this.soluzioni=new HashSet<>();
		//caso iniziale (imposto il livello e la stringa che passo)
		
		//Creiamo la lista di parole che andro a scandire
		parola=parola.toUpperCase();
		if (this.check(parola)==false) {
			throw new IllegalStateException("I numeri non sono validi. Inserire parola valida!\n");
		}
		
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
	
	public List <String> risultatoCorrette (Set <String> soluzioni){
		soluzioni=this.soluzioni;
		List <String> corrette= new ArrayList <>();
				
		for (String s:soluzioni) {
			if (dao.isCorrect(s)==true) {
				corrette.add(s);
			}
		}
	
		return corrette;	
	}
	
	public List <String> risultatoErrate (Set <String> soluzioni){
		soluzioni=this.soluzioni;
		List <String> errate= new ArrayList <>();

		
		for (String s:soluzioni) {
			if (dao.isCorrect(s)==false) {
				errate.add(s);
			}
		}
	
		return errate;	
	}
	
	public boolean check (String p) {
		boolean check = true;
		for (int i=0; i<p.length();i++) {
			if (!Character.isLetter(p.charAt(i))){
				check=false;
			}
		}
		return check;
	}
	
}
