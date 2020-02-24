package data_perform;

public class TranslationField {
    private static int count = 0;
    private final int id = count++;
    private String word;
    private String translation;

    public TranslationField(String word, String translation){
        this.word = word;
        this.translation = translation;
    }

    public int getId(){
        return id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
