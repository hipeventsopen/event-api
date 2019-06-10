package hipevents.useraccount.repository;

import hipevents.useraccount.domain.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {
}
