package nextstep.ladder;

import nextstep.ladder.drawPolicy.DrawablePolicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRows {

    private List<LadderRow> ladderRows;

    public LadderRows(List<LadderRow> ladderRows) {
        this.ladderRows = ladderRows;
    }

    public LadderRows(Persons persons, Height height, DrawablePolicy drawablePolicy) {
        ladderRows = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            LadderRow ladderRow = new LadderRow(persons.personListSize(), drawablePolicy);
            ladderRows.add(ladderRow);
        }
    }

    public List<LadderRow> getLadderRows(){
        return Collections.unmodifiableList(ladderRows);
    }

    public int getResultIndex(int index) {
        int currentIndex = index;
        for (LadderRow ladderRow : ladderRows) {
            currentIndex = ladderRow.movedPointIndex(currentIndex);
        }
        return currentIndex;
    }
}
