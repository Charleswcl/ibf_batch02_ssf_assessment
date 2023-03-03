package batch02_ssf_assessment.ssf.assessment.Controller;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import batch02_ssf_assessment.ssf.assessment.Service.QuotationService;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path = "/view", produces = MediaType.APPLICATION_JSON_VALUE)
public class PORestController {

    @Autowired
    private QuotationService qSvc;

    @PostMapping(path = "/quotation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postAsJson(@RequestBody String payload) {

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject json = reader.readObject();

        String quoteId = json.getString("quoteId");

        json = Json.createObjectBuilder()
                .add("Quotation ID:", "%s".formatted(quoteId))
                .build();

        return ResponseEntity
                .status(200)
                .body(json.toString());
    }

}
