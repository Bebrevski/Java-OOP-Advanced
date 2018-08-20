package P03_GraphicEditor;

import P03_GraphicEditor.interfaces.Drawable;
import P03_GraphicEditor.shapes.*;

public class Main {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();

        Drawable circle = new Circle();
        Drawable cubic = new Cubic();
        Drawable rect = new Rectangle();
        Drawable square = new Square();

        Drawable shape = new Shape();

        graphicEditor.drawShape(circle);
        graphicEditor.drawShape(cubic);
        graphicEditor.drawShape(rect);
        graphicEditor.drawShape(square);
        graphicEditor.drawShape(shape);
    }
}
