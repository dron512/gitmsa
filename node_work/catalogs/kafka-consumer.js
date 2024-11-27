const { Kafka } = require('kafkajs');

// Kafka 클라이언트 생성
const kafka = new Kafka({
  clientId: 'my-kafka-app', // 클라이언트 식별자
  brokers: ['localhost:9092'], // Kafka 브로커 주소
});

// Consumer 생성
const consumer = kafka.consumer({ groupId: 'test-group' });

const run = async () => {
  // Consumer 연결
  await consumer.connect();

  // 토픽 구독
  await consumer.subscribe({ topic: 'jdbc-orders', fromBeginning: true });

  // 메시지 수신
  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log({
        topic,
        partition,
        key: message.key?.toString(),
        value: message.value?.toString(),
        offset: message.offset,
      });
    },
  });

  console.log('Kafka listener is running...');
};

// 에러 핸들링
consumer.on('consumer.crash', (e) => {
  console.error('Consumer crashed:', e);
});

run().catch((error) => {
  console.error('Error running Kafka listener:', error);
});

