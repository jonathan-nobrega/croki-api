package croki.api.domain.meetings.dto;

import java.time.LocalDateTime;

public record CreateMeetingDTO(
        Long clientId,
        String description,
        String location,
        LocalDateTime time
) {
}
