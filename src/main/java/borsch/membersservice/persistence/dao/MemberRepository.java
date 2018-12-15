package borsch.membersservice.persistence.dao;

import borsch.membersservice.domain.entities.MemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<MemberEntity, String> {
}
