package ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerDtoTest {

    @Test
    @DisplayName("dto로 변환한다.")
    void toDto() {
        Player player = new Player("pobi");
        PlayerDto playerDto = PlayerDto.from(player);

        assertThat(playerDto.name()).isEqualTo("pobi");
    }
}