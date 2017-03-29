#!/usr/bin/env python
import subprocess
import time
from topics_managment.topics_manager import topic_configurations_control, topic_configurations_10, topic_configurations_100, \
    topic_configurations_1000


def create_topics(topics_configurations_list):
    for topic_conf_list in topics_configurations_list:
        for topic_conf in topic_conf_list:
            subprocess.call(['java', '-jar', '-Djava.security.auth.login.config=/home/wjurasz/jaas.conf',
                             '/opt/kafka_2.11-0.10.2.0/kafka-topics.jar', '--server',
                             'nile-kafka-nxcals-test-01.cern.ch:9093',
                             '--create', '--topic', topic_conf.topic_name,
                             '--numPartitions', topic_conf.partition_number, '--numReplication', '3'])
            # time.sleep(3)


create_topics(topic_configurations_control())
# create_topics(topic_configurations_10())
