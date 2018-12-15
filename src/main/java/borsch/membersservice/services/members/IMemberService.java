package borsch.membersservice.services.members;

import borsch.membersservice.domain.dto.MemberDto;

import java.util.List;

public interface IMemberService {

    List<MemberDto> getList();

    MemberDto getById(String id);

    String create(MemberDto dto);

    boolean update(MemberDto dto);

    boolean delete(String id);

}
