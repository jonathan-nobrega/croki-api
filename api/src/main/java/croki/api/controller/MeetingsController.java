package croki.api.controller;

import croki.api.domain.meetings.MeetingsRepository;
import croki.api.domain.meetings.dto.CreateMeetingDTO;
import croki.api.domain.meetings.dto.MeetingDetailingDTO;
import croki.api.domain.meetings.dto.UpdateMeetingDTO;
import croki.api.domain.meetings.services.MeetingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("meetings")
@SecurityRequirement(name = "bearer-key")
public class MeetingsController {

    @Autowired
    private MeetingsRepository meetingsRepository;

    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public ResponseEntity<Page<MeetingDetailingDTO>> findAll(
            @PageableDefault(size = 20, sort = {"id"})
            Pageable page
    ) {
        var result = meetingsRepository.findAll(page).map(MeetingDetailingDTO::new);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDetailingDTO> findOne(@PathVariable Long id) {
        var meeting = meetingsRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new MeetingDetailingDTO(meeting));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MeetingDetailingDTO> create(@RequestBody @Valid CreateMeetingDTO data, UriComponentsBuilder uriBuilder) {
        var newMeeting = meetingService.create(data);
        var uri = uriBuilder.path("/meetings/{id}").buildAndExpand(newMeeting.id()).toUri();

        return ResponseEntity.created(uri).body(newMeeting);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MeetingDetailingDTO> update(@RequestBody @Valid UpdateMeetingDTO data) {
        var meeting = meetingService.update(data);
        return ResponseEntity.ok(meeting);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity.BodyBuilder> delete(@PathVariable Long id) {
        meetingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
