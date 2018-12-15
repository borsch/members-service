package borsch.membersservice.services.members;


import borsch.membersservice.domain.dto.MemberDto;
import borsch.membersservice.domain.entities.MemberEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;

public class MemberMapperConfiguration {

    public static void configureMapperFactory(MapperFactory mapperFactory) {
        mapperFactory.classMap(MemberEntity.class, MemberDto.class)
                .field("id", "id").mapNulls(false).mapNullsInReverse(false)
                .field("firstName", "firstName").mapNulls(false).mapNullsInReverse(false)
                .field("lastName", "lastName").mapNulls(false).mapNullsInReverse(false)
                .field("postalCode", "postalCode").mapNulls(false).mapNullsInReverse(false)
                .customize(new CustomMemberMapper())
                .register();
    }

    /**
     * implements mapping of {@code MemberEntity.dateOfBirth} field
     */
    private static class CustomMemberMapper extends CustomMapper<MemberEntity, MemberDto> {

        @Override
        public void mapAtoB(MemberEntity memberEntity, MemberDto memberDto, MappingContext context) {

        }

        @Override
        public void mapBtoA(MemberDto memberDto, MemberEntity memberEntity, MappingContext context) {

        }

    }

}
