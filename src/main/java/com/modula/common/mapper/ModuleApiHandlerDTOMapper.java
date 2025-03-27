package com.modula.common.mapper;

import com.modula.common.domain.moduleconfiguration.ModuleAction;
import com.modula.common.domain.moduleconfiguration.ModuleTrigger;
import com.modula.common.dto.moduleconfiguration.ModuleApiHandlerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModuleApiHandlerDTOMapper {
    ModuleApiHandlerDTO actionToDTO(ModuleAction moduleAction);
    ModuleApiHandlerDTO triggerToDTO(ModuleTrigger moduleTrigger);
}
