package test;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class")
public enum PropertyFakeRecordType {
    FAKE1,
    FAKE2,
    FAKE3;

    @JsonGetter("name")
    public String getName() {
        return name();
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static PropertyFakeRecordType create(@JsonProperty("name") String name) {
        return PropertyFakeRecordType.valueOf(name);
    }
}
