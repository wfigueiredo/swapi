package com.b2w.swapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Document
public class Planet {

    @Id
    private String objectId;

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String climate;

    @NotNull
    private String terrain;

    private Integer films;

    @JsonIgnore
    @LastModifiedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private DateTime lastModified;

    @JsonIgnore
    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private DateTime createdDate;
}
