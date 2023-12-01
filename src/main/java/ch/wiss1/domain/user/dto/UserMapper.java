package ch.wiss1.domain.user.dto;

import ch.wiss1.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  User UserDTOToUser(UserDTO dto);
}
