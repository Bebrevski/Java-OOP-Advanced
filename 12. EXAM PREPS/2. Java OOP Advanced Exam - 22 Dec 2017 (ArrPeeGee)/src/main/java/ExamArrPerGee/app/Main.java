package ExamArrPerGee.app;


import ExamArrPerGee.app.contracts.*;
import ExamArrPerGee.app.core.BattlefieldImplementation;
import ExamArrPerGee.app.engine.EngineImpl;
import ExamArrPerGee.app.factory.ActionFactoryImpl;
import ExamArrPerGee.app.factory.SpecialityFactoryImpl;
import ExamArrPerGee.app.factory.TargetableFactoryImpl;
import ExamArrPerGee.app.io.ConsoleReader;
import ExamArrPerGee.app.io.ConsoleWriter;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        SpecialityFactory specialityFactory = new SpecialityFactoryImpl();

        Battlefield battlefield = new BattlefieldImplementation(writer, targetableFactory, actionFactory, specialityFactory);

        Engine engine = new EngineImpl(battlefield, reader, writer);
        engine.run();
    }
}
