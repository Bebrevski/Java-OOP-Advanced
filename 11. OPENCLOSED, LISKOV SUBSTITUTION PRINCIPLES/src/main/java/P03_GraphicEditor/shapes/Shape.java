package P03_GraphicEditor.shapes;

import P03_GraphicEditor.interfaces.Drawable;

public class Shape implements Drawable {
    public String draw() {
        return "I am " + this.getClass().getSimpleName();
    }
}
