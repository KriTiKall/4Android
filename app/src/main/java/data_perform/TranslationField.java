package data_perform;

public class TranslationField {
    private int id;
    private String word;
    private String translation;

    public TranslationField(int id, String word, String translation){
        this.id = id;
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
