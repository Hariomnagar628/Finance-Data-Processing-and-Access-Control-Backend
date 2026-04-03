package financebackend.controllers;

import financebackend.model.FinancialRecord;
import financebackend.repository.FinancialRecordRepository;
import financebackend.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

 @Autowired
    private FinancialRecordService service;

   @PreAuthorize("hasRole('ADMIN')")
   @PostMapping
   public FinancialRecord create(@RequestBody FinancialRecord record,
                                 @RequestHeader("role") String role) {

       if (!role.equals("ADMIN")) {
           throw new RuntimeException("Access Denied: Only ADMIN can create records");
       }

       return service.save(record);
   }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id, @RequestBody FinancialRecord record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Record deleted successfully";
    }

}
