package gatling.simulation

import io.gatling.kafka.KafkaProducerProtocol

/**
  * Created by wjurasz on 22.03.17.
  */
class Simulation1010000 extends BaseSimulation{
  val kafkaTopic = Array(
    "topic10_partition10000_1",
    "topic10_partition10000_2",
    "topic10_partition10000_3",
    "topic10_partition10000_4",
    "topic10_partition10000_5",
    "topic10_partition10000_6",
    "topic10_partition10000_7",
    "topic10_partition10000_8",
    "topic10_partition10000_9",
    "topic10_partition10000_10")


  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
