package financebackend.service;

import financebackend.model.FinancialRecord;
import financebackend.model.Type;
import financebackend.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repository;

    public FinancialRecord save(FinancialRecord record)
    {

        return  repository.save(record);
    }



    public double getTotalIncome() {
        return repository.findByType(Type.INCOME)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return repository.findByType(Type.EXPENSE)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }


    public List<FinancialRecord> getAll() {
        return repository.findAll();
    }

    public FinancialRecord update(Long id, FinancialRecord record) {
        FinancialRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setAmount(record.getAmount());
        existing.setType(record.getType());
        existing.setCategory(record.getCategory());
        existing.setDate(record.getDate());
        existing.setDescription(record.getDescription());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
