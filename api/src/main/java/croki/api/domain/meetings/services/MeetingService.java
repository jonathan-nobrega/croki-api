package croki.api.domain.meetings.services;

import croki.api.domain.clients.services.ClientService;
import croki.api.domain.meetings.Meeting;
import croki.api.domain.meetings.MeetingsRepository;
import croki.api.domain.meetings.dto.CreateMeetingDTO;
import croki.api.domain.meetings.dto.MeetingDetailingDTO;
import croki.api.domain.meetings.dto.UpdateMeetingDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private MeetingsRepository meetingsRepository;

    @Transactional
    public MeetingDetailingDTO create(CreateMeetingDTO data) {
        var client = clientService.checkClient(data.clientId());
        var newMeeting = new Meeting(client, data);

        meetingsRepository.save(newMeeting);
        return new MeetingDetailingDTO(newMeeting);
    }

    @Transactional
    public MeetingDetailingDTO update(UpdateMeetingDTO data) {
        var meeting = checkMeeting(data.id());
        var client = data.clientId() != null ? clientService.checkClient(data.clientId()) : meeting.getClient();

        meeting.updateMeeting(client, data);
        return new MeetingDetailingDTO(meeting);
    }

    @Transactional
    public void delete(Long id) {
        if (!meetingsRepository.existsById(id)) {
            throw new EntityNotFoundException("Meeting doesn't exist");
        }
        meetingsRepository.delete(meetingsRepository.getReferenceById(id));
    }

    public Meeting checkMeeting(Long id) {
        if (!meetingsRepository.existsById(id)) {
            throw new EntityNotFoundException("Meeting doesn't exist");
        }
        return meetingsRepository.getReferenceById(id);
    }
}