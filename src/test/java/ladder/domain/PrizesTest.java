package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @Test
    @DisplayName("Prizes 객체 생성 테스트")
    void createPrizes() {
        List<String> prizeNames = List.of("꽝", "5000", "꽝", "3000");
        Prizes prizes = Prizes.of(prizeNames, 4);

        assertThat(prizes.getPrizes()).containsExactly(
                new Prize("꽝"),
                new Prize("5000"),
                new Prize("꽝"),
                new Prize("3000")
        );
    }
}
