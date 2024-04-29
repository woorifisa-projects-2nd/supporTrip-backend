package com.supportrip.core.feign.service;

import com.supportrip.core.feign.controller.InsuranceFeignClient;
import com.supportrip.core.insurance.dto.InsuranceCorporationListResponse;
import com.supportrip.core.insurance.dto.InsuranceListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceClientService {
    private final InsuranceFeignClient insuranceFeignClient;

    public InsuranceListResponse getInsured(String token, String orgCode, String code) {
        return insuranceFeignClient.getInsured(token, orgCode, code);
    }

    public InsuranceCorporationListResponse getInsuredCorporation(String token) {
        return insuranceFeignClient.getInsuredCorporation(token);
    }
}
