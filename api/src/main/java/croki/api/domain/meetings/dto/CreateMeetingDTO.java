package croki.api.domain.meetings.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateMeetingDTO(
        @NotNull
        Long clientId,
        @NotNull
        String description,
        String location,
        @NotNull @FutureOrPresent
        LocalDateTime time
) {
}
