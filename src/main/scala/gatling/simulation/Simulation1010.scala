package gatling.simulation

import io.gatling.kafka.KafkaProducerProtocol

/**
  * Created by wjurasz on 22.03.17.
  */
class Simulation1010 extends BaseSimulation{
  val kafkaTopic = Array(
    "topic10_partition10_1",
    "topic10_partition10_2",
    "topic10_partition10_3",
    "topic10_partition10_4",
    "topic10_partition10_5",
    "topic10_partition10_6",
    "topic10_partition10_7",
    "topic10_partition10_8",
    "topic10_partition10_9",
    "topic10_partition10_10")


  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
