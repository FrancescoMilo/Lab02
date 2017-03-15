package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	private String alienWord;
	private LinkedList<String> traslation;
	
	public WordEnhanced(String alienWord, LinkedList<String> traslation) {
		this.alienWord = alienWord;
		this.traslation = traslation;
	}
	
	public boolean compare(String parolaAliena){
		String questa = alienWord.toLowerCase();
		String altra = parolaAliena.toLowerCase();
		return questa.equals(altra);
	}
	
	public boolean compareWild(String parolaAliena){
		String a = parolaAliena.replaceAll("\\?", ".");
		if (alienWord.matches(a))
			return true;
		return false;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public LinkedList<String> getTraslation() {
		return traslation;
	}

	public void addTraslation(String traslation) {
		this.traslation.add(traslation);
	}
	
	
	

}
