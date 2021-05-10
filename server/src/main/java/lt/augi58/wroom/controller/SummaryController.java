package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.SummaryDTO;
import lt.augi58.wroom.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @GetMapping(path = "/get/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SummaryDTO getSummary(@PathVariable Long accountId) {
        return summaryService.getSummary(accountId);
    }
}
