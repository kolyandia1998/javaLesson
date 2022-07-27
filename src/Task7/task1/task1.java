package Task7.task1;

import Task7.task1.FigureType.Line.Line;
import Task7.task1.FigureType.Line.LineExeption.LineException;
import Task7.task1.FigureType.Rectangle.Rectangle;
import Task7.task1.FigureType.Rectangle.SizeExeption.SizeException;
import Task7.task1.FigureType.Ring.RadiusException.RadiusException;
import Task7.task1.FigureType.Ring.Ring;

import java.util.ArrayList;

public class task1 {

    public static void showFigureInfo(ArrayList<Figure> MyFigure){

        for (int i =0; i < MyFigure.size(); i++){
            System.out.println(MyFigure.get(i).Draw());
        }

    }


    public static void main(String[] args) throws RadiusException, SizeException, LineException {
        ArrayList<Figure> MyFigure = new ArrayList<Figure>();
        MyFigure.add(new Rectangle(0.0,0.0,10.0,12.0));
        MyFigure.add(new Line(0.0,10.0,5.0,10.0));

       showFigureInfo(MyFigure);

    }

}
