package nextstep.ladder;

import java.util.List;

import nextstep.ladder.drawPolicy.DrawablePolicy;

public class Ladder {

    private final LadderRows ladderRows;

    public Ladder(List<LadderRow> ladderRows) {
        this.ladderRows = new LadderRows(ladderRows);
    }

    public Ladder(Persons persons, Height height, DrawablePolicy drawablePolicy) {
        if (persons.personListSize() <= 0) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람은 0또는 음수가 될 수 없습니다");
        }

        ladderRows = new LadderRows(persons, height, drawablePolicy);
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows.getLadderRows();
    };

    public int getResultIndex(int index) {
        return ladderRows.getResultIndex(index);
    }
}
