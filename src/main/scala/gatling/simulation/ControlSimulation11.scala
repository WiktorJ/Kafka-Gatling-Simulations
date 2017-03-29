package gatling.simulation

import io.gatling.core.Predef.{constantUsersPerSec, scenario}
import io.gatling.kafka.{KafkaProducerBuilder, KafkaProducerProtocol}


/**
  * Created by wjurasz on 22.03.17.
  */
class ControlSimulation11 extends BaseSimulation{

  val kafkaTopic = Array("topic1_partition1_1")


  val kafkaProducerProtocol = new KafkaProducerProtocol[Array[Byte], Array[Byte]](props, kafkaTopic, numberOfProducers, dataGenerator)
  setUp(
    scnList
  ).protocols(kafkaProducerProtocol)


}
