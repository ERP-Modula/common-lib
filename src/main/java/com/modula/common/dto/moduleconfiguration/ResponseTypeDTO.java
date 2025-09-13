package com.modula.common.dto.moduleconfiguration;

import com.modula.common.domain.moduleconfiguration.ResponseType;
import lombok.Data;

/**
 * DTO for ResponseType enum.
 * Used in API responses to represent the expected response type.
 */
@Data
public class ResponseTypeDTO {
    private ResponseType responseType;
    private String description;
    
    public ResponseTypeDTO() {}
    
    public ResponseTypeDTO(ResponseType responseType) {
        this.responseType = responseType;
        this.description = getDescriptionForType(responseType);
    }
    
    private String getDescriptionForType(ResponseType type) {
        switch (type) {
            case JSON:
                return "JSON response - default type for most APIs";
            case BINARY:
                return "Binary response - for files, images, audio, video, etc.";
            case TEXT:
                return "Plain text response";
            case HTML:
                return "HTML response";
            case XML:
                return "XML response";
            default:
                return "Unknown response type";
        }
    }
}
