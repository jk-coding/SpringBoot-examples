package simpletext;

import java.util.Collection;

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

  @GetMapping("/records")
  Collection<SimpleTextRecord> getRecords() {
    return repository.getAllRecords();
  }

  @PostMapping("/records")
  SimpleTextRecord addRecord(@RequestBody SimpleTextRecord record) {
    return repository.addRecord(record.getTitle(), record.getText());
  }

  @GetMapping("/records/{id}")
  SimpleTextRecord getRecord(@PathVariable Long id) {
    return repository.getRecord(id);
  }

  @PutMapping("/records/{id}")
  SimpleTextRecord replaceRecord(@RequestBody SimpleTextRecord newRecord, @PathVariable Long id) {
    return repository.replaceRecord(id, newRecord.getTitle(), newRecord.getText());
  }

  @DeleteMapping("/records/{id}")
  void deleteRecord(@PathVariable Long id) {
    repository.deleteRecord(id);
  }
}
