package model;

public class Sentence {

    private Word[] words;

    public Sentence(Word[] words) {
        this.words = words;
    }

    public Word[] getWords() {
        return words;
    }

    private void setWords(Word[] words) {
        this.words = words;
    }

    public void appendNewWord(Word text) {
        Word[] old_words = this.words;
        Word[] words = new Word[old_words.length + 1];
        for (int i = 0; i < old_words.length; i++) {
            words[i] = old_words[i];
        }
        words[old_words.length] = text;
        setWords(words);
    }
}
