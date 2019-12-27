package simpletext;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
// @RequestMapping("/api/v1")
class SimpleTextController {
  @Autowired
  private SimpleTextRepository repository;

  @GetMapping("/records")
  public List<SimpleTextRecord> getRecords() {
    return repository.findAll();
  }

  @PostMapping("/records")
  public SimpleTextRecord addRecord(@RequestBody SimpleTextRecord record) {
    return repository.save(record);
  }

  @GetMapping("/records/{id}")
  public SimpleTextRecord getRecord(@PathVariable Long id) throws ResourceNotFoundException {
    Optional<SimpleTextRecord> optRecord = repository.findById(id);

    if (optRecord.isPresent()) {
      return optRecord.get();
    }

    throw (new ResourceNotFoundException("Record not found"));
  }

  @PutMapping("/records/{id}")
  SimpleTextRecord replaceRecord(@RequestBody SimpleTextRecord newRecord, @PathVariable Long id)
      throws ResourceNotFoundException {
    Optional<SimpleTextRecord> optRecord = repository.findById(id);

    if (optRecord.isPresent()) {
      SimpleTextRecord record = optRecord.get();
      record.setTitle(newRecord.getTitle());
      record.setText(newRecord.getText());

      return repository.save(record);
    }

    throw (new ResourceNotFoundException("Record not found"));
  }

  @DeleteMapping("/records/{id}")
  void deleteRecord(@PathVariable Long id) throws ResourceNotFoundException {
    Optional<SimpleTextRecord> optRecord = repository.findById(id);

    if (optRecord.isPresent()) {
      repository.deleteById(id);
    } else {
      throw (new ResourceNotFoundException("Record not found"));
    }

  }
}
