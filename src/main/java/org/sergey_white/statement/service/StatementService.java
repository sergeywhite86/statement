package org.sergey_white.statement.service;


import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.sergey_white.statement.dto.LoanOfferDto;
import org.sergey_white.statement.dto.LoanStatementRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatementService {

    private final WebClient webClient;

    public List<LoanOfferDto> getLoanOffers(LoanStatementRequestDto input) {
        log.info("Starting to get loan offers : {}", input);
        List<LoanOfferDto> loanOffers;
        String url = "http://localhost:8082/deal/statement";

        try {
            loanOffers = webClient.post()
                    .uri(url)
                    .body(Mono.just(input), LoanStatementRequestDto.class)
                    .retrieve()
                    .bodyToFlux(LoanOfferDto.class)
                    .collectList()
                    .block();
            log.info("Received loan offers: {}", loanOffers);
        } catch (WebClientResponseException.BadRequest ex) {
            throw ex;
        }
        return loanOffers;
    }

    public void selectLoanOffer(LoanOfferDto input) {
        log.info("Starting to select loan offer : {}", input);
        String url = "http://localhost:8082/deal/offer/select";
        try {
            webClient.post()
                    .uri(url)
                    .body(Mono.just(input), LoanOfferDto.class)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
            log.info("Received loan offer : {}", input);
        } catch (WebClientResponseException.BadRequest ex) {
            throw ex;
        }
    }
}


