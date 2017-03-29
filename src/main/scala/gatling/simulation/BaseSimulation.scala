package gatling.simulation

import java.util
import java.util.concurrent.TimeUnit

import io.gatling.core.Predef.{Simulation, _}
import io.gatling.data.generator.RandomDataGenerator
import io.gatling.kafka.{KafkaProducerBuilder, KafkaProducerProtocol}
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.ByteArraySerializer
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import scala.concurrent.duration._

import scala.concurrent.duration.FiniteDuration
import scala.util.Random

class BaseSimulation extends Simulation {

  val kafkaBrokers: String = "" +
    "nile-kafka-nxcals-test-01.cern.ch:9092"
  System.setProperty("java.security.krb5.conf", "/etc/krb5.conf")
  System.setProperty("java.security.auth.login.config", "/home/wjurasz/jaas.conf")
  System.setProperty("javax.security.auth.useSubjectCredsOnly", "false")

  val props = new util.HashMap[String, Object]()
  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokers)
  props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT")
  props.put("sasl.mechanism", "GSSAPI")
  props.put("sasl.kerberos.service.name", "kafka")
  props.put("max.request.size", "600000000")
  props.put("buffer.memory", "600000000")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[ByteArraySerializer])
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[ByteArraySerializer])


  val dataGenerator = new RandomDataGenerator[Array[Byte], Array[Byte]]()
  val numberOfProducers = 100

  val values900B = Array[Int](250, 600, 850)
  val values9KB = Array[Int](2500, 6000, 8500)
  val values90KB = Array[Int](25000, 60000, 85000)
  val values900KB = Array[Int](250000, 600000, 850000)
  val values9MB = Array[Int](2000050, 6000000, 8500000)
  val values90MB = Array[Int](25000000, 60000000, 85000000)

  val scn = scenario("Kafka Producer Call900B").exec(KafkaProducerBuilder[Array[Byte], Array[Byte]](Option.empty, () => values900B(Random.nextInt(values900B.length))))
  val scn2 = scenario("Kafka Producer Call9KB").exec(KafkaProducerBuilder[Array[Byte], Array[Byte]](Option.empty, () => values9KB(Random.nextInt(values900B.length))))
  val scn3 = scenario("Kafka Producer Call90KB").exec(KafkaProducerBuilder[Array[Byte], Array[Byte]](Option.empty, () => values90KB(Random.nextInt(values900B.length))))
  val scn4 = scenario("Kafka Producer Call900KB").exec(KafkaProducerBuilder[Array[Byte], Array[Byte]](Option.empty, () => values900KB(Random.nextInt(values900B.length))))
  val scn5 = scenario("Kafka Producer Call9MB").exec(KafkaProducerBuilder[Array[Byte], Array[Byte]](Option.empty, () => values9MB(Random.nextInt(values900B.length))))
  val scn6 = scenario("Kafka Producer Call90MB").exec(KafkaProducerBuilder[Array[Byte], Array[Byte]](Option.empty, () => values90MB(Random.nextInt(values900B.length))))


  val time = 10 seconds
  val amount900B = 15000
  val amount9KB = 2000
  val amount90KB = 700
  val amount900KB = 50
  val amount9MB = 2
  val amount90MB = 1
  val throughputPerSecond = amount900B * 0.00045 + amount9KB * 0.0045 + amount90KB * 0.045 + amount900KB * 0.45 + amount9MB * 4.5 + amount90MB * 45


  val scnI = scn.inject(constantUsersPerSec(amount900B) during (time))
  val scnI2 = scn2.inject(constantUsersPerSec(amount9KB) during (time))
  val scnI3 = scn3.inject(constantUsersPerSec(amount90KB) during (time))
  val scnI4 = scn4.inject(constantUsersPerSec(amount900KB) during (time))
  val scnI5 = scn5.inject(constantUsersPerSec(amount9MB) during (time))
  val scnI6 = scn6.inject(constantUsersPerSec(amount90MB) during (time))

  val scnList = List(scnI, scnI2, scnI3, scnI4, scnI5, scnI6)

}

object BaseSimulation {
  def main(args: Array[String]) {

    val printSize = false
    if (printSize) {
      println(new BaseSimulation().throughputPerSecond)
    } else {
      val props = new GatlingPropertiesBuilder
      props.sourcesDirectory("./src/main/scala")
      props.binariesDirectory("./target/scala-2.11/classes")

      var simClass = classOf[ControlSimulation11].getName
      props.simulationClass(simClass)
      Gatling.fromMap(props.build)

      simClass = classOf[ControlSimulation15].getName
      props.simulationClass(simClass)
      Gatling.fromMap(props.build)

      simClass = classOf[Simulation1010].getName
      props.simulationClass(simClass)
      Gatling.fromMap(props.build)

      simClass = classOf[Simulation10100].getName
      props.simulationClass(simClass)
      Gatling.fromMap(props.build)

      simClass = classOf[Simulation101000].getName
      props.simulationClass(simClass)
      Gatling.fromMap(props.build)
    }


  }
}

