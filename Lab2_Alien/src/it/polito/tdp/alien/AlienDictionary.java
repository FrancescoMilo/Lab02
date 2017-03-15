package it.polito.tdp.alien;

import java.util.LinkedList;

public class AlienDictionary {
	
	private LinkedList<Word> coppia;

	public AlienDictionary() {
		coppia = new LinkedList<Word>();
	}

	public LinkedList<Word> getCoppia() {
		return coppia;
	}
	
	public void addWord(String alienWord, String traslation){
		boolean ce = false;
		for(Word w : coppia){
			if(w.compare(alienWord)==true){
				ce = true;
				w.setTraslation(traslation);
				break;
			}
		}
		if(ce==false){
			Word w = new Word(alienWord, traslation);
			coppia.add(w);
		}
	}
	
	public String traslateWord(String alienWord){
		String ris = null;
		for(Word w : coppia){
			if(w.compare(alienWord)==true){
				ris = w.getTraslation();
				break;
			}
		}
		return ris;
	}
	
	public void pulisci(){
		coppia.clear();
	}
	

}
