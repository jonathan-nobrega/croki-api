package croki.api.domain.meetings;

import croki.api.domain.clients.Client;
import croki.api.domain.meetings.dto.CreateMeetingDTO;
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
}
