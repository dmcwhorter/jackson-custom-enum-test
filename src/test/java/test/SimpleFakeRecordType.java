package test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class")
public enum SimpleFakeRecordType {
    FAKE1("Fake1"),
    FAKE2("Fake2"),
    FAKE3("Fake3");

    @JsonProperty("name")
    private String name;

    SimpleFakeRecordType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static SimpleFakeRecordType create(@JsonProperty("name") String name) {
        return SimpleFakeRecordType.valueOf(name);
    }
}
