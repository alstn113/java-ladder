package ladder.dto.response.ladder;

import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Rung;

public record LineResponse(List<Boolean> rungsExist) {
    public static LineResponse from(Line line) {
        List<Boolean> rungsExist = line.getRungs().stream()
                .map(Rung::isExist)
                .toList();

        return new LineResponse(rungsExist);
    }
}