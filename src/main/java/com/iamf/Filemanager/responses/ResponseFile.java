package com.iamf.Filemanager.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseFile {

    private String name;
    private String url;
    private String type;
    private Integer size;

}
