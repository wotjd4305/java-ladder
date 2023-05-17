package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class MainAction {

    public static void main(String args[]){
        InputView.printPersonInput();
        Persons persons = new Persons(InputView.stringInput()
                .split(","));

        InputView.printLadderHeightInput();
        Height ladderHeight = new Height(InputView.intInput());
        ResultView.printResult(persons);

        List<LadderRow> ladderRowList = initLadderRows(persons, ladderHeight);
        Ladder ladder = new Ladder(ladderRowList);
        ResultView.printLadder(ladder.drawLadder());
    }

    private static List<LadderRow> initLadderRows(Persons persons, Height ladderHeight) {
        List<LadderRow> ladderRowList = new ArrayList<>();
        for(int i = 0; i< ladderHeight.getHeight(); i++) {
            LadderRow ladderRow = new LadderRow(persons.personList.size(), new RandomDraw());
            ladderRowList.add(ladderRow);
        }
        return ladderRowList;
    }
}
