package com.modula.common.mapper;

import com.modula.common.domain.moduleconfiguration.ModuleConfiguration;
import com.modula.common.dto.moduleconfiguration.ModuleConfigurationShortInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModuleShortInfoMapper {
    ModuleConfigurationShortInfoDTO mapToShortInfoDTO(ModuleConfiguration moduleConfiguration);
}
