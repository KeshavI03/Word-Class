
public class Word {
	private String word;
	
	public Word() {
		word = "";
	}
	
	public Word(String word) {
		this.word = word.toLowerCase();
	}
	
	public int length() {
		return word.length();
	}
	
	public String getWord() {
		return word;
	}
	
	public int numSylab() {
		return Math.max(1, numVowels() - numReductions());
	}
	
	public int numVowels() {
		int j = 0;
		for(int i = 0; i < word.length(); i++)
			if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y')
				j++;
		return j;
	}
	
	public boolean isVowel(int i) {
		return word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y';
	}
	
	public int numReductions() {
		int numRed = 0;
		if(word.charAt(word.length()-1) == 'e' ||
				((word.charAt(word.length()-3) != 'e' && word.charAt(word.length()-3) != 's') && word.substring(word.length()-2).equals("es") || (word.substring(word.length()-2).equals("ed") && word.charAt(word.length()-3) != 't')) ||
				(word.charAt(word.length()-2) == 'a' && (word.charAt(word.length()-1) == 'o' || word.charAt(word.length()-1) == 'u')))                                     
			numRed++;
		
		if(word.substring(word.length()-2).equals("sm"))
			numRed--;
		
		for(int i = 0; i < word.length()-2; i++) 
			if(isVowel(i) && isVowel(i+1)) 
				if(!(word.charAt(i) == 'i' && (word.charAt(i+1) == 'a' || (word.charAt(i+1) == 'o' && word.charAt(i-1) != 't'))) && word.charAt(i+1) != 'y')
					numRed++;
		return numRed;
	}
}
