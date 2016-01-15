package test

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class EnumSerializationTest extends FlatSpec with Matchers {
  val mapper = new ObjectMapper()

  "DelegatingFakeRecordType" should "Serialize to/from JSON correctly" in {
    mapper.writeValueAsString(DelegatingFakeRecordType.FAKE1) should equal("""{"@class":"test.DelegatingFakeRecordType","name":"FAKE1"}""")
    mapper.readValue("""{"@class":"test.DelegatingFakeRecordType","name":"FAKE1"}""", classOf[DelegatingFakeRecordType]) should equal(DelegatingFakeRecordType.FAKE1)
  }

  "PropertyFakeRecordType" should "Serialize to/from JSON correctly" in {
    mapper.writeValueAsString(PropertyFakeRecordType.FAKE1) should equal("""{"@class":"test.PropertyFakeRecordType","name":"FAKE1"}""")
    mapper.readValue("""{"@class":"test.PropertyFakeRecordType","name":"FAKE1"}""", classOf[PropertyFakeRecordType]) should equal(PropertyFakeRecordType.FAKE1)
  }
}