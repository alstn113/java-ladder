package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @Test
    @DisplayName("참가자들은 이름을 가진다.")
    void testConstruct() {
        String pobi = "pobi";
        Player player = new Player(pobi);

        assertThat(pobi).isEqualTo(player.name());
    }

    @Nested
    @DisplayName("참가자들의 이름의")
    class InvalidNameTest {

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "666666"})
        @DisplayName("길이가 범위를 벗어나면 예외가 발생한다.")
        void testInvalidNameRange(String name) {
            assertThatThrownBy(() -> new Player(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc!", "!@#"})
        @DisplayName("형식이 한글, 영어, 숫자가 아니라면 예외가 발생한다.")
        void testInvalidNameFormat(String name) {
            assertThatThrownBy(() -> new Player(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
