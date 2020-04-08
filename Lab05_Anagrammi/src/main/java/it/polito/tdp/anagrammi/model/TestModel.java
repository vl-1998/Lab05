package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.model.Model;

public class TestModel {

	public static void main(String[] args) {
		Model ric = new Model() ;
		
		List<String> ana_ciao = ric.anagrammi("ciao") ;
		System.out.println(ana_ciao);
		
		List <String> corrette= ric.risultatoCorrette(ana_ciao);
		System.out.println(corrette);
		
		List <String> errate= ric.risultatoErrate(ana_ciao);
		System.out.println(errate);
	}

}
