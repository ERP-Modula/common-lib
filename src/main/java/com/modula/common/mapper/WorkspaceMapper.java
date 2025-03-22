package com.modula.common.mapper;

import com.modula.common.dto.workspace.CreateCommandWorkspaceDTO;
import com.modula.common.dto.workspace.WorkspaceShortInfoDTO;
import com.modula.common.domain.Workspace;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface    WorkspaceMapper {
    WorkspaceShortInfoDTO toShortDTO(Workspace workspace);

    Workspace toEntityFromCreateCommandWorkspaceDTO(CreateCommandWorkspaceDTO workspaceDTO);
}
