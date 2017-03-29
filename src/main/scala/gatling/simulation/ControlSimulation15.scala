package gatling.simulation

import io.gatling.core.Predef.{constantUsersPerSec, scenario}
import io.gatling.kafka.{KafkaProducerBuilder, KafkaProducerProtocol}

import scala.concurrent.duration._
import scala.util.Random

/**
  * Created by wjurasz on 22.03.17.
  */
class ControlSimulation15 extends BaseSimulation{
  val topicName = "topic1_partition_5_1"
  val kafkaTopic = Array("topic1_partition_5_1")

  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
