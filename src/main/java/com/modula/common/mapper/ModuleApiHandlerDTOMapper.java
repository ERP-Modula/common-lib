package com.modula.common.mapper;

import com.modula.common.domain.moduleconfiguration.ModuleAction;
import com.modula.common.dto.moduleconfiguration.ModuleApiHandlerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.scheduling.Trigger;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModuleApiHandlerDTOMapper {
    ModuleApiHandlerDTO actionToDTO(ModuleAction moduleAction);
    ModuleApiHandlerDTO triggerToDTO(Trigger trigger);
}
