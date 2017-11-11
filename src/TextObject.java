import processing.core.PApplet;

import java.util.Random;

public class TextObject {
    private String word;
    private int time;
    private float x;
    private float y;
    private boolean needDelete;

    public TextObject(String word, int time) {
        Random random = new Random();
        this.word = word;
        this.time = time;
        this.x = random.nextInt(800);
        this.y = 0;

        this.needDelete = false;
    }

    public void draw(PApplet applet) {
        applet.text(word, x, y);
        applet.textSize(20);
    }

    public void update() {
        y += (600f / time * 1000f / 30f);
    }

    public String getWord() {
        return word;
    }

    public boolean isBottom() {
        return y >= 600;
    }

    public void setDelete() {
        needDelete = true;
    }

    public boolean isNeedDelete() {
        return needDelete;
    }
}
