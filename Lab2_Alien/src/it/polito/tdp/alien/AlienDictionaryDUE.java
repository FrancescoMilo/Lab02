package it.polito.tdp.alien;

import java.util.LinkedList;

public class AlienDictionaryDUE {
	
	private LinkedList<WordEnhanced> lista;
	
	public AlienDictionaryDUE(){
		lista = new LinkedList<WordEnhanced>();
	}
	
	public boolean contieneGia(String alienWord){
		boolean ris = false;
		for(WordEnhanced w : lista)
			ris = w.compare(alienWord);
		return ris;
	}
	
	public void addWord(String alienWord, String traslation){
		boolean ce = false;
		for(WordEnhanced w : lista){
			if(w.compare(alienWord)==true){
				ce = true;
				w.addTraslation(traslation);
				break;
			}
		}
		if(ce == false){
			LinkedList<String> traduzioni = new LinkedList<String>();
			traduzioni.add(traslation);
			WordEnhanced w = new WordEnhanced(alienWord, traduzioni);
			lista.add(w);
		}
	}
	
	public String traslateWord(String alienWord){
		String ris = "";
		for(WordEnhanced w : lista){
			if(w.compare(alienWord)==true){
				LinkedList<String> traduzioni = w.getTraslation();
				for(String s : traduzioni)
					ris += s+" ";
				break;
			}
		}
		return ris;
	}
	
	public void pulisci(){
		lista.clear();
	}

}
