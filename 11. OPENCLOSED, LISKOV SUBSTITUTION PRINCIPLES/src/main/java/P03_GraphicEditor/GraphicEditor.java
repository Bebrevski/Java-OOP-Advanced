package P03_GraphicEditor;

import P03_GraphicEditor.interfaces.Drawable;

public class GraphicEditor {
    public void drawShape(Drawable shape) {
        System.out.println(shape.draw());
    }
}
