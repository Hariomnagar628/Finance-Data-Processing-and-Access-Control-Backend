package financebackend.repository;

import financebackend.model.FinancialRecord;
import financebackend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord,Long> {

List<FinancialRecord> findByType(Type type);



}
