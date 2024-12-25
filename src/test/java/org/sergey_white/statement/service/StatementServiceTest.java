package org.sergey_white.statement.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sergey_white.statement.dto.LoanOfferDto;
import org.sergey_white.statement.dto.LoanStatementRequestDto;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatementServiceTest {
    @Mock
    private WebClient webClient;
    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;
    @Mock
    private WebClient.RequestBodySpec requestBodySpec;
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    @Mock
    private WebClient.ResponseSpec responseSpec;
    @InjectMocks
    private StatementService statementService;

    @Test
    void testGetLoanOffers() {
        LoanStatementRequestDto requestDto = new LoanStatementRequestDto();

        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(String.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any(), eq(LoanStatementRequestDto.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToFlux(LoanOfferDto.class)).thenReturn(Flux.empty());

        statementService.getLoanOffers(requestDto);

        verify(webClient, times(1)).post();
        verify(requestBodyUriSpec, times(1)).uri(any(String.class));
        verify(requestBodySpec, times(1)).body(any(), eq(LoanStatementRequestDto.class));
        verify(requestHeadersSpec, times(1)).retrieve();
        verify(responseSpec, times(1)).bodyToFlux(LoanOfferDto.class);
    }

    @Test
    void testSelectLoanOffer() {
        LoanOfferDto loanOfferDto = new LoanOfferDto();

        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(String.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any(), eq(LoanOfferDto.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Void.class)).thenReturn(Mono.empty());

        statementService.selectLoanOffer(loanOfferDto);

        verify(webClient, times(1)).post();
        verify(requestBodyUriSpec, times(1)).uri(any(String.class));
        verify(requestBodySpec, times(1)).body(any(), eq(LoanOfferDto.class));
        verify(requestHeadersSpec, times(1)).retrieve();
        verify(responseSpec, times(1)).bodyToMono(Void.class);
    }

    @Test
    void testGetLoanOffers_BadRequest() {
        LoanStatementRequestDto requestDto = new LoanStatementRequestDto();

        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(String.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any(), eq(LoanStatementRequestDto.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenThrow(WebClientResponseException.BadRequest.class);

        assertThrows(WebClientResponseException.BadRequest.class, () -> statementService.getLoanOffers(requestDto));
    }
}