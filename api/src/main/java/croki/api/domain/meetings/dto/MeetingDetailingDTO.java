package croki.api.domain.meetings.dto;

import croki.api.domain.meetings.Meeting;

import java.time.LocalDateTime;

public record MeetingDetailingDTO(
        Long id,
        Long clientId,
        String description,
        String location,
        LocalDateTime time
) {

    public MeetingDetailingDTO(Meeting meeting) {
        this(
                meeting.getId(),
                meeting.getClient().getId(),
                meeting.getDescription(),
                meeting.getLocation(),
                meeting.getTime()
        );
    }
}
