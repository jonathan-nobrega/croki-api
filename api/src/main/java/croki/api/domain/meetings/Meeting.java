package croki.api.domain.meetings;

import croki.api.domain.clients.Client;
import croki.api.domain.meetings.dto.CreateMeetingDTO;
import croki.api.domain.meetings.dto.UpdateMeetingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "meetings")
@Entity(name = "meeting")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    private String description;
    private LocalDateTime time;
    private String location;

    public Meeting(Client client, CreateMeetingDTO data) {
        this.client = client;
        this.description = data.description();
        this.time = data.time();
        this.location = data.location();
    }

    public void updateMeeting(Client client, UpdateMeetingDTO data) {
        if (client != null) this.client = client;
        if (data.description() != null) this.description = data.description();
        if (data.time() != null) this.time = data.time();
        if (data.location() != null) this.location = data.location();
    }
}
