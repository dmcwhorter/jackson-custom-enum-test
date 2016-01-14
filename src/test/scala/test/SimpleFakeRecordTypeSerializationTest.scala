package test

import com.fasterxml.jackson.databind.{ObjectMapper, SerializationFeature}
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.typesafe.scalalogging.slf4j.LazyLogging
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class SimpleFakeRecordTypeSerializationTest extends FlatSpec with Matchers with LazyLogging {
  val mapper = new ObjectMapper()
  mapper.registerModule(new JodaModule())
  mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
  mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
  mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false)

  "SimpleFakeRecordType" should "Serialize to/from JSON correctly" in {
    mapper.writeValueAsString(SimpleFakeRecordType.FAKE1) should equal("""{"@class":"test.SimpleFakeRecordType","name":"Fake1"}""")
    mapper.readValue("""{"@class":"test.SimpleFakeRecordType","name":"Fake1"}""", classOf[SimpleFakeRecordType]) should equal(SimpleFakeRecordType.FAKE1)
  }
}