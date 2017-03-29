class TopicConfiguration:
    def __init__(self, topic_name, partition_number, replica_number=3):
        super().__init__()
        self.topic_name = topic_name
        self.partition_number = partition_number
        self.replica_number = replica_number


def print_topics(topics_list):
    for topics in topics_list:
        print("Array(")
        for topic in topics[:-1]:
            print("\"" + topic.topic_name + "\",")
        if len(topics) != 0:
            print("\"" + topics[-1].topic_name + "\")\n")


def topic_configurations_control():
    return [[TopicConfiguration('topic1_partition1_1', '1')], [TopicConfiguration('topic1_partition1_5', '5')]]


def topic_configurations_10():
    base_name10 = 'topic10_partition10_'
    base_name100 = 'topic10_partition100_'
    base_name1000 = 'topic10_partition1000_'
    base_name10000 = 'topic10_partition10000_'
    # base_name50000 = 'topic10_partition50000_'
    configurations10 = []
    configurations100 = []
    configurations1000 = []
    configurations10000 = []
    # configurations50000 = []

    for i in range(1, 11):
        configurations10.append(TopicConfiguration(base_name10 + str(i), '10'))
    for i in range(1, 11):
        configurations100.append(TopicConfiguration(base_name100 + str(i), '100'))
    for i in range(1, 11):
        configurations1000.append(TopicConfiguration(base_name1000 + str(i), '1000'))
    # for i in range(1, 11):
    #     configurations10000.append(TopicConfiguration(base_name10000 + str(i), '10000'))
    # for i in range(1, 101):
    #     configurations50000.append(TopicConfiguration(base_name50000 + str(i), '50000'))
    topics_list = [configurations10, configurations100, configurations1000, configurations10000]
    print_topics(topics_list)
    return topics_list

def topic_configurations_100():
    base_name1 = 'topic100_partition1_'
    base_name10 = 'topic100_partition10_'
    base_name100 = 'topic100_partition100_'
    base_name1000 = 'topic100_partition1000_'
    # base_name10000 = 'topic100_partition10000_'
    # base_name50000 = 'topic100_partition50000_'
    configurations1 = []
    configurations10 = []
    configurations100 = []
    configurations1000 = []
    # configurations10000 = []
    # configurations50000 = []

    for i in range(1, 101):
        configurations1.append(TopicConfiguration(base_name1 + str(i), '1'))
    for i in range(1, 101):
        configurations10.append(TopicConfiguration(base_name10 + str(i), '10'))
    for i in range(1, 101):
        configurations100.append(TopicConfiguration(base_name100 + str(i), '100'))
    # for i in range(1, 101):
    #     configurations1000.append(TopicConfiguration(base_name1000 + str(i), '1000'))
    # for i in range(1, 101):
    #     configurations10000.append(TopicConfiguration(base_name10000 + str(i), '10000'))
    # for i in range(1, 101):
    #     configurations50000.append(TopicConfiguration(base_name50000 + str(i), '50000'))
    topics_list = [configurations1, configurations10, configurations100, configurations1000]
    print_topics(topics_list)
    return topics_list


def topic_configurations_1000():
    base_name1 = 'topic1000_partition1_'
    base_name10 = 'topic1000_partition10_'
    base_name100 = 'topic1000_partition100_'
    # base_name1000 = 'topic1000_partition1000_'
    # base_name10000 = 'topic1000_partition10000_'
    configurations1 = []
    configurations10 = []
    configurations100 = []
    # configurations1000 = []
    # configurations10000 = []

    for i in range(1, 1001):
        configurations1.append(TopicConfiguration(base_name1 + str(i), '1'))
    for i in range(1, 1001):
        configurations10.append(TopicConfiguration(base_name10 + str(i), '10'))
    for i in range(1, 1001):
        configurations100.append(TopicConfiguration(base_name100 + str(i), '100'))
    # for i in range(1, 1001):
    #     configurations1000.append(TopicConfiguration(base_name1000 + str(i), '1000'))
    # for i in range(1, 1001):
    #     configurations10000.append(TopicConfiguration(base_name10000 + str(i), '10000'))
    topics_list = [configurations1, configurations10, configurations100]
    print_topics(topics_list)
    return topics_list
