package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String traslation;
	
	public Word(String alienWord, String traslation) {
		this.alienWord = alienWord;
		this.traslation = traslation;
	}
	
	public boolean compare(String parolaAliena){
		String questa = alienWord.toLowerCase();
		String altra = parolaAliena.toLowerCase();
		return questa.equals(altra);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTraslation() {
		return traslation;
	}

	public void setTraslation(String traslation) {
		this.traslation = traslation;
	}
	
	
	

}
