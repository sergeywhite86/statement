package org.sergey_white.statement.controller;




import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.sergey_white.statement.dto.LoanOfferDto;
import org.sergey_white.statement.dto.LoanStatementRequestDto;
import org.sergey_white.statement.service.StatementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statement")
@RequiredArgsConstructor
public class DealController {
    private final StatementService service;

    @Operation(summary = "Получить предварительные предложения по кредиту",
            description = "Возвращает список кредитных предложений на основе запроса.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LoanOfferDto.class))),
            @ApiResponse(responseCode = "400", description = "Неверный запрос")
    })
    @PostMapping("/statement")
    public List<LoanOfferDto> calculateLoanOffers(@RequestBody LoanStatementRequestDto req) {
        return service.getLoanOffers(req);
    }

    @Operation(summary = "Выбрать кредитное предложение",
            description = "Выбирает конкретное кредитное предложение.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос")
    })
    @PostMapping("/offer")
    public void chooseLoanOffers(@RequestBody LoanOfferDto req) {
        service.selectLoanOffer(req);
    }

}