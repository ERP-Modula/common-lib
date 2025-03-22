package com.modula.common.mapper;

import com.modula.common.domain.step.Step;
import com.modula.common.dto.StepDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StepMapper {

    Step toEntity(StepDTO stepDTO);

    StepDTO toDto(Step step);
}