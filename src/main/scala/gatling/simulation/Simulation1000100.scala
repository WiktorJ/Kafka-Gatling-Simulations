package gatling.simulation

import io.gatling.kafka.KafkaProducerProtocol

/**
  * Created by wjurasz on 22.03.17.
  */
class Simulation1000100 extends BaseSimulation{
  val topicName = "topic1_partition_5_"
  val kafkaTopic = Array(topicName + "1", topicName + "2", topicName + "3", topicName + "4", topicName + "5")

  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
