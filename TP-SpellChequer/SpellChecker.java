import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/** 
 * @author (Guilherme de Andrade, Lucas Martins) 
 */
public class SpellChecker
{
    private DictReader dicionario;
    
    
    public SpellChecker(DictReader dicionario) {
        this.dicionario = dicionario;
    }
    
    public int numbersOfWords() {
        int cont = 0;
        
        for (String word : dicionario.getDictionary()) {
            cont++;
        }
        
        return cont;
    }
    
    public boolean isKnownWord(String word) {
        boolean found = false;
        
        for (String palavra : dicionario.getDictionary()) {
            if (palavra.equals(word)) {
                found = true;
                return found;
            }
        }
        
        return found;
    }
    
    public boolean allKnown(ArrayList<String> words) {
        boolean contem = false;
        
        for(String palavra : words) {
            if(dicionario.getDictionary().contains(palavra)) {
                contem = true;
            } else {
                contem = false;
                return contem;
            }
        }
        
        return contem;
    }
    
    public ArrayList<String> wordsStartingWith(String prefix) {
        ArrayList<String> palavraPrefixo = new ArrayList<String>();
        String prefixForm = prefix.toLowerCase();
        
        for(String palavra : dicionario.getDictionary()) {
            String palavraForm = palavra.toLowerCase();
            if(palavra.startsWith(prefix)) {
                palavraPrefixo.add(palavra);
            }
        }
        
        return palavraPrefixo;
    }
    
    public ArrayList<String> wordsContaining(String text) {
        ArrayList<String> palavras = new ArrayList<String>();
        String textForm = text.toLowerCase();
        
        for(String word : dicionario.getDictionary()) {
            String wordForm = word.toLowerCase();
            if(word.contains(text)) {
                palavras.add(word);
            }
        }
        
        return palavras;
    }
    
    public void insert(String newWord) {
        if(!isKnownWord(newWord)) {
            ArrayList<String> dict = dicionario.getDictionary();
            dict.add(newWord);
            Collections.sort(dict, String.CASE_INSENSITIVE_ORDER);
            dicionario.addDelet(dict);
        }
    }
    
    public boolean remove(String wordRemove) {
        if(!isKnownWord(wordRemove)) {
            ArrayList<String> dict = dicionario.getDictionary();
            dict.remove(wordRemove);
            dicionario.addDelet(dict);
        } else {
            return false;
        }
        
        return true;
    }
    
    public void save() {
        ArrayList<String> dict = dicionario.getDictionary();
        dicionario.save(dict);
    }
    
    public boolean isPalindrome(String word) {
        boolean palindromo = false;
        word = word.toLowerCase();
        
        for(String palavra : dicionario.getDictionary()) {
            palavra = palavra.toLowerCase();
            if(palavra.equals(word)) {
                String wordReverse = "";
                for(int i = (wordReverse.length() - 1); i >= 0; i--) {
                    wordReverse = wordReverse + word.charAt(i);
                    if(word.equals(wordReverse)) {
                        palindromo = true;
                        return palindromo;
                    }
                }
            }
        }
        
        return palindromo;
    }
    
    public ArrayList<String> anagrams(String word) {
        ArrayList<String> anagramas = new ArrayList<String>();
        String wordForm = word.toLowerCase();
        
        for(String palavra : dicionario.getDictionary()) {
            String palavraForm = palavra.toLowerCase();
            boolean eAnagrama = false;
            
            if(palavra.length() == word.length()) {
                char vetor1[] = new char[palavra.length()];
                char vetor2[] = new char[palavra.length()];
                boolean comparacao = true;
                
                for(int i = 0; i < palavra.length(); i++) {
                    vetor1[i] = palavraForm.charAt(i);
                    vetor2[i] = wordForm.charAt(i);
                }
                Arrays.sort(vetor1);
                Arrays.sort(vetor2);
                
                for(int i = 0; i < word.length(); i++) {
                    if(vetor1[i] != vetor2[i]) {
                        comparacao = false;
                    }
                }
                
                if(comparacao) {
                    eAnagrama = true;
                }
            }
            
            if(eAnagrama) {
                anagramas.add(palavra);
            }
        }
        
        return anagramas;
    }
    
    public ArrayList<String> difference(ArrayList<String> dictionary) {
        ArrayList<String> diferentes = new ArrayList<String>();
        
        for(String palavra : dicionario.getDictionary()) {
            boolean contem = false;
            
            if(palavra.equals(dictionary)) {
                contem = true;
            }
            
            if(!contem) {
                diferentes.add(palavra);
            }
        }
        
        for(String palavra : dictionary) {
            boolean contem = false;
            
            if(palavra.equals(dicionario.getDictionary())) {
                contem = true;
            }
            
            if(!contem) {
                diferentes.add(palavra);
            }
        }
        
        return diferentes;
    }
    
    public int distance(String word1, String word2) {
        int distancia = 0;
        int tam1 = word1.length();
        int tam2 = word2.length();
        
        int matriz[][] = new int[tam1 + 1][tam2 + 2];
        
        for(int i = 0; i < tam1; i++) {
            matriz[0][i] = i;
        }
        
        for(int i = 0; i < tam1; i++) {
            matriz[i][0] = i;
        }
        
        for(int i = 0; i < tam1; i++) {
            for(int j = 0; j < tam2; i++) {
                int custo = (word1.charAt(i-1) == word2.charAt(j-1))?0:1;
                int minimo1 = Math.min(matriz[i-1][j]+1,matriz[i][j-1]+1);
                matriz[i][j] = Math.min(minimo1, matriz[i-1][j-1]+custo);
            }
            distancia = matriz[tam1][tam2];
        }
        
        return distancia;
    }
}
