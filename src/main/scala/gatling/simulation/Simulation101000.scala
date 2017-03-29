package gatling.simulation

import io.gatling.kafka.KafkaProducerProtocol

/**
  * Created by wjurasz on 22.03.17.
  */
class Simulation101000 extends BaseSimulation{
  val kafkaTopic =
    Array(
      "topic10_partition1000_1",
      "topic10_partition1000_2",
      "topic10_partition1000_3",
      "topic10_partition1000_4",
      "topic10_partition1000_5",
      "topic10_partition1000_6",
      "topic10_partition1000_7",
      "topic10_partition1000_8",
      "topic10_partition1000_9",
      "topic10_partition1000_10")

  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
