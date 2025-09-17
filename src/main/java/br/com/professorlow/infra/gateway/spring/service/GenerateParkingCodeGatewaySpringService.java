package br.com.professorlow.infra.gateway.spring.service;

import br.com.professorlow.core.gateway.GenerateParkingCodeGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;


@Service
public class GenerateParkingCodeGatewaySpringService implements GenerateParkingCodeGateway {

    private static final String CHARSET = "ABCDEFGHJKLMNPQRSTUVWXY23456789";
    private static final String DELIMITER = "-";

    @Override
    public String generateCode(String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            sb.append(CHARSET.charAt(ThreadLocalRandom.current().nextInt(0, CHARSET.length())));
        }
        return code.concat(DELIMITER).concat(sb.toString());
    }
}
