package ExamArrPerGee.app.engine;

import ExamArrPerGee.app.constants.InputCommands;
import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.Battlefield;
import ExamArrPerGee.app.contracts.Engine;
import ExamArrPerGee.app.contracts.Reader;
import ExamArrPerGee.app.contracts.Writer;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Battlefield battlefield;
    private Reader reader;
    private Writer writer;

    public EngineImpl(Battlefield battlefield, Reader reader, Writer writer) {
        this.battlefield = battlefield;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {
        String line = this.reader.readLine();

        while (!InputCommands.COMMAND_TERMINATE.equals(line)) {
            String[] lineTokens = line.split(InputCommands.COMMAND_PARAMETERS_SEPARATOR);

            switch (lineTokens[0]) {
            case InputCommands.COMMAND_CREATE_PARTICIPANT:
                this.battlefield.createParticipant(lineTokens[1], lineTokens[2]);
                break;
            case InputCommands.COMMAND_CREATE_ACTION:
                this.battlefield.createAction(lineTokens[1],
                        Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                Arrays.stream(lineTokens).skip(2).toArray().length,
                                String[].class));
                break;
            case InputCommands.COMMAND_STAT_ACTIONS:
                this.battlefield.reportActions();
                break;
            case InputCommands.COMMAND_STAT_PARTICIPANTS:
                this.battlefield.reportParticipants();
                break;
            case InputCommands.COMMAND_CREATE_SPECIAL:
                this.battlefield.createSpecial(lineTokens[1], lineTokens[2]);
                break;
            default:
                writer.writeLine(Texts.INVALID_COMMAND);
                break;
            }

            line = reader.readLine();
        }
    }
}
