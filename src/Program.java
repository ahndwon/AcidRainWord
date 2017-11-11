import processing.core.PApplet;
import processing.event.KeyEvent;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program extends PApplet {
    private ArrayList<TextObject> textObjects = new ArrayList<>();
    private String typedWord = "";
    private Client client;

    public static void main(String[] args) {
        PApplet.main("Program");

    }

    @Override
    public void setup() {
        client = new Client();
        try {
            client.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textObjects.add(new TextObject("test", 1000));
        textObjects.add(new TextObject("test1", 2000));
        textObjects.add(new TextObject("test2", 3000));
        textObjects.add(new TextObject("test3", 4000));
        textObjects.add(new TextObject("test4", 5000));
        textObjects.add(new TextObject("test5", 6000));
        textObjects.add(new TextObject("test6", 7000));
        textObjects.add(new TextObject("test7", 8000));
        textObjects.add(new TextObject("test8", 9000));
        textObjects.add(new TextObject("test9", 10000));

    }

    @Override
    public void settings() {
        super.settings();
        size(800, 600);
    }

    @Override
    public void draw() {
        background(0);
        for (TextObject t : textObjects) {
            t.update();
        }

        for (int i = 0; i < textObjects.size(); i++) {
            TextObject t = textObjects.get(i);
            if (t.isBottom() || t.isNeedDelete()) {
                textObjects.remove(t);
            }
        }

        for (TextObject t : textObjects) {
            t.draw(this);
        }
    }

    @Override
    public void keyPressed() {

        if (key == ENTER) {
            checkAnswer(typedWord);
            typedWord = "";
        } else {
            typedWord += key;
        }
        System.out.println(typedWord);
    }

    public void checkAnswer(String typedWord) {
        for (TextObject e : textObjects) {
            if (typedWord.equals(e.getWord())) {
                e.setDelete();
            }
        }
    }
}
