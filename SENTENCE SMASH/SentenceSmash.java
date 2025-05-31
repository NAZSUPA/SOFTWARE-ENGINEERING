package Empty;


public class SentenceSmash {
     public static String smash(String [] words){
          String sentence="";
         for (String word : words) {
             sentence += " " + word;
         }
         return sentence.trim();
     }
     public static void main(String[] args) {
        
    }
}

