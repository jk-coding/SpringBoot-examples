package simpletext;

import java.util.Collection;
import java.security.Principal;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SimpleTextController {

  private final SimpleTextRepository repository;

  SimpleTextController() {
    this.repository = new SimpleTextRepository();
  }

  @GetMapping("/")
  String getUser(Principal principal) {
    return ("This is SimpleTextService. You are User: " + principal.getName());
  }

  @GetMapping("/records")
  Collection<SimpleTextRecord> getRecords(Principal principal) {
    System.out.println("Request: GET /records - User: " + principal.getName());
    return repository.getAllRecords();
  }

  @PostMapping("/records")
  SimpleTextRecord addRecord(Principal principal, @RequestBody SimpleTextRecord record) {
    System.out.println("Request: POST /records - User: " + principal.getName());
    return repository.addRecord(record.getTitle(), record.getText());
  }

  @GetMapping("/records/{id}")
  SimpleTextRecord getRecord(Principal principal, @PathVariable Long id) {
    System.out.println("Request: GET /records/" + id + " - User: " + principal.getName());
    return repository.getRecord(id);
  }

  @PutMapping("/records/{id}")
  SimpleTextRecord replaceRecord(Principal principal, @RequestBody SimpleTextRecord newRecord, @PathVariable Long id) {
    System.out.println("Request: PUT /records/" + id + " - User: " + principal.getName());
    return repository.replaceRecord(id, newRecord.getTitle(), newRecord.getText());
  }

  @DeleteMapping("/records/{id}")
  void deleteRecord(Principal principal, @PathVariable Long id) {
    System.out.println("Request: DELETE /records/" + id + " - User: " + principal.getName());
    repository.deleteRecord(id);
  }
}
