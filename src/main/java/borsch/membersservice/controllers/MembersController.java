package borsch.membersservice.controllers;

import borsch.membersservice.domain.dto.MemberDto;
import borsch.membersservice.services.members.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Members")
@RestController
@RequestMapping("/api/members")
public class MembersController {

    private final IMemberService memberService;

    public MembersController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @ApiOperation(value = "Get list of members by criterion")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<MemberDto> getList() {
        return memberService.getList();
    }

    @ApiOperation(value = "Get Specific member by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MemberDto getById(
            @ApiParam(name = "id", value = "Member's id", required = true)
            @PathVariable("id") String id
    ) {
        return memberService.getById(id);
    }

    @ApiOperation(value = "Create new member")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String create(
            @ApiParam(name = "member dto", value = "object to be saved")
            @RequestBody MemberDto dto
    ) {
        return memberService.create(dto);
    }

    @ApiOperation(value = "Update existed member")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Boolean update(
            @ApiParam(name = "member dto", value = "object to be update. contains only fields to be updated within ID")
            @RequestBody MemberDto dto
    ) {
        return memberService.update(dto);
    }

    @ApiOperation(value = "Delete member by specific ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(
            @ApiParam(name = "id", required = true)
            @PathVariable("id") String id
    ) {
        return memberService.delete(id);
    }

}
