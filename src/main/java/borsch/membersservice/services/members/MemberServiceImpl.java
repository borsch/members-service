package borsch.membersservice.services.members;

import borsch.membersservice.domain.dto.MemberDto;
import borsch.membersservice.domain.entities.MemberEntity;
import borsch.membersservice.persistence.dao.MemberRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements IMemberService {

    private final MemberRepository memberRepository;

    private final MapperFacade mapperFacade;

    public MemberServiceImpl(MemberRepository memberRepository, MapperFacade mapperFacade) {
        this.memberRepository = memberRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<MemberDto> getList() {
        List<MemberEntity> entities = memberRepository.findAll();

        return mapperFacade.mapAsList(entities, MemberDto.class);
    }

    @Override
    public MemberDto getById(String id) {
        Optional<MemberEntity> optionalEntity = memberRepository.findById(id);
        MemberEntity entity = optionalEntity.get();

        return mapperFacade.map(entity, MemberDto.class);
    }

    @Override
    public String create(MemberDto dto) {
        MemberEntity entity = mapperFacade.map(dto, MemberEntity.class);

        entity = memberRepository.save(entity);

        return entity.getId();
    }

    @Override
    public boolean update(MemberDto dto) {
        Optional<MemberEntity> optionalEntity = memberRepository.findById(dto.getId());
        MemberEntity entity = optionalEntity.get();

        mapperFacade.map(dto, entity);
        memberRepository.save(entity);

        return true;
    }

    @Override
    public boolean delete(String id) {
        Optional<MemberEntity> optionalEntity = memberRepository.findById(id);
        MemberEntity entity = optionalEntity.get();

        memberRepository.delete(entity);

        return true;
    }
}
