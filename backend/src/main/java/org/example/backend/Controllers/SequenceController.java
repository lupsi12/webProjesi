package org.example.backend.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.backend.Services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sequence")
@AllArgsConstructor
@NoArgsConstructor
public class SequenceController {
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    // sequence endpointini kullanarak tüm sıraları siler
    @DeleteMapping
    public void deleteAllSequence(){
        sequenceGeneratorService.deleteAllSequence();
    }
}
