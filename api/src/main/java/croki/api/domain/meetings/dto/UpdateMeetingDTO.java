package croki.api.domain.meetings.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateMeetingDTO(
        @NotNull
        Long id,
        Long clientId,
        String description,
        String location,
        @FutureOrPresent
        LocalDateTime time
) {
}
