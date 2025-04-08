package br.com.marlussaade.mstradeoffprocessorv1.adapters.outbound.events;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.out.PublishTradeOffProcessed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublishTradeOffProcessedImpl implements PublishTradeOffProcessed {

    private static final Logger logger = LoggerFactory.getLogger(PublishTradeOffProcessedImpl.class);

    @Value(value = "${events.kafka.send.client-interaction-non-sql}")
    private String topicName;

    @Autowired
    KafkaTemplate<String, ProteinTradeOffResultDTO> kafkaTemplate;

    @Override
    public void publishClientInteractionTradeOffProcessor(ProteinTradeOffResultDTO proteinTradeOffResultDTO) {

        logger.info(" Sending msg to Kafka: {}", proteinTradeOffResultDTO);
        try {
            kafkaTemplate.send(topicName, proteinTradeOffResultDTO).get();
        } catch (Exception e ){
            throw new RuntimeException("Fail to send to the Topic client-interaction-non-sql");
        }

    }
}

