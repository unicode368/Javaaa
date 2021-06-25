package model;

public class SentenceBuilder {

    Sentence sentence;

    public SentenceBuilder(Sentence sentence) {
        this.sentence = sentence;
    }

    public Sentence getSentence() {
        return sentence;
    }

    public void setSentence(String text) {
        if (this.sentence == null) {
            this.sentence = new Sentence(new Word[] {new Word(text)});
        } else {
            this.sentence.appendNewWord(new Word(text));
        }
    }

    public String generateSentence() {
        String result = "";
        Word[] words = sentence.getWords();
        for (int i = 0; i < words.length; i++) {
            result += words[i].getTextInstance();
            result += i == words.length - 1 ? "" : " ";
        }
        return result;
    }
}
