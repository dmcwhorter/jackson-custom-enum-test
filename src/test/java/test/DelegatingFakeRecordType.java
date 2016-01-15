package test;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class")
public enum DelegatingFakeRecordType {
    FAKE1,
    FAKE2,
    FAKE3;

    @JsonGetter("name")
    public String getName() {
        return name();
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DelegatingFakeRecordType create(JsonNode json) {
        return DelegatingFakeRecordType.valueOf(json.get("name").asText());
    }
}
