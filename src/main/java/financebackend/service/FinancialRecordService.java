package financebackend.service;

import financebackend.model.FinancialRecord;
import financebackend.model.Type;
import financebackend.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
