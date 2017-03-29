package gatling.simulation

import io.gatling.kafka.KafkaProducerProtocol

/**
  * Created by wjurasz on 22.03.17.
  */
class Simulation10100 extends BaseSimulation{
  val kafkaTopic = Array(
    "topic10_partition100_1",
    "topic10_partition100_2",
    "topic10_partition100_3",
    "topic10_partition100_4",
    "topic10_partition100_5",
    "topic10_partition100_6",
    "topic10_partition100_7",
    "topic10_partition100_8",
    "topic10_partition100_9",
    "topic10_partition100_10")

  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
