package it.polito.tdp.alien;

import java.util.LinkedList;

public class AlienDictionaryDUE {
	
	private LinkedList<WordEnhanced> lista;
	
	public AlienDictionaryDUE(){
		lista = new LinkedList<WordEnhanced>();
	}
	
	public boolean contieneGia(String alienWord){
		boolean ris = false;
		for(WordEnhanced w : lista){
			if(w.compare(alienWord)==true){
				ris = w.compare(alienWord);
				break;
			}
		}
		return ris;
	}
	
	public boolean contieneGiaWild(String alienWord){
		boolean ris = false;
		for(WordEnhanced w : lista){
			if(w.compareWild(alienWord)==true){
				ris=w.compareWild(alienWord);
				break;
			}
		}
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
		StringBuilder ris = new StringBuilder();
		for(WordEnhanced w : lista){
			if(w.compare(alienWord)==true){
				LinkedList<String> traduzioni = w.getTraslation();
				for(String s : traduzioni)
					ris.append(s+" ");
				break;
			}
		}
		return ris.toString();
	}
	
	public void pulisci(){
		lista.clear();
	}
	
	public String traslateWild(String alienWord){
		StringBuilder ris = new StringBuilder();
		//alienWord.replaceAll("\\?", ".");
		for(WordEnhanced w : lista){
			if(w.compareWild(alienWord)==true){
				LinkedList<String> traduzioni = w.getTraslation();
				for(String s : traduzioni)
					ris.append(s+" ");
				break;
			}
		}
		return ris.toString();
	}

}
