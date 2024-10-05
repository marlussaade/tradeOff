package br.com.mrsitech.tradeOff.application.mappers;

import br.com.mrsitech.tradeOff.application.mappers.dto.DddRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class BrasilApiDddRequestMappingImpl implements BrasilApiDddRequestMapping {

    @Override
    public DddRequestDTO brasilApiMappingToGetDdd(String phoneNumber) {
        DddRequestDTO ddd = new DddRequestDTO();
        if(phoneNumber.charAt(0) == '+' &&  phoneNumber.charAt(1) == '5' && phoneNumber.charAt(2) == '5') {
            ddd.setDdd(phoneNumber.substring(3,5));
        } else if (phoneNumber.charAt(0) == '5' && phoneNumber.charAt(1) == '5') {
            ddd.setDdd(phoneNumber.substring(2,4));
        } else{
            ddd.setDdd(phoneNumber.substring(0,2));
        }
        return ddd;

    }
}
