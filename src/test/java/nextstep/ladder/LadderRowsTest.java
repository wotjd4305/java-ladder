package nextstep.ladder;

import nextstep.ladder.drawPolicy.AllDraw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowsTest {

    LadderRows ladderRows;
    Persons persons;

    @BeforeEach
    void init() {
        persons = new Persons(new String[]{"AA", "BB", "CC", "DD", "EE"});
        ladderRows = new LadderRows(persons, new Height(5), new AllDraw());
    }

    @Test
    void getLadderRows() {
        List<LadderRow> ladderRowList = new ArrayList<>();

        ladderRowList.add(new LadderRow(persons.personListSize(), new AllDraw()));
        ladderRowList.add(new LadderRow(persons.personListSize(), new AllDraw()));
        ladderRowList.add(new LadderRow(persons.personListSize(), new AllDraw()));
        ladderRowList.add(new LadderRow(persons.personListSize(), new AllDraw()));
        ladderRowList.add(new LadderRow(persons.personListSize(), new AllDraw()));

        assertThat(ladderRowList).isEqualTo(ladderRows.getLadderRows());
    }

    @Test
    void getResultIndex() {
        var actualResultIndex0 = ladderRows.getResultIndex(0);
        var actualResultIndex1 = ladderRows.getResultIndex(1);
        var actualResultIndex2 = ladderRows.getResultIndex(2);
        var actualResultIndex3 = ladderRows.getResultIndex(3);
        var actualResultIndex4 = ladderRows.getResultIndex(4);

        assertThat(1).isEqualTo(actualResultIndex0);
        assertThat(0).isEqualTo(actualResultIndex1);
        assertThat(3).isEqualTo(actualResultIndex2);
        assertThat(2).isEqualTo(actualResultIndex3);
        assertThat(4).isEqualTo(actualResultIndex4);
    }
}
