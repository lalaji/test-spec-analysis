package org.openapitools.api;

import org.openapitools.model.ErrorResponse;
import org.openapitools.model.MultiCurrencyAccountResponse;
import org.openapitools.model.RegisterMultiCurrencyAccountRequest;
import org.openapitools.model.SubAccountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Optional;

/**
 * APIs for managing multi-currency accounts with IBAN-based identification (Berlin Group REQ_0423)
 */
@Validated
@Tag(name = "Account", description = "APIs for managing multi-currency accounts with IBAN-based identification (Berlin Group REQ_0423)")
public interface AccountsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    String PATH_ACCOUNTS_MULTICURRENCY_POST = "/accounts/multicurrency";
    String PATH_ACCOUNTS_IBAN_CURRENCY_GET = "/accounts/{iban}/{currency}";

    /**
     * POST /accounts/multicurrency : Register a new multi-currency account
     * Creates a new multi-currency account with IBAN-based identification and currency-specific sub-accounts
     *
     * @param registerMultiCurrencyAccountRequest Request containing account details (required)
     * @return Multi-currency account registered successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Server Error (status code 500)
     */
    @Operation(
        operationId = "registerMultiCurrencyAccount",
        summary = "Register a new multi-currency account",
        description = "Creates a new multi-currency account with IBAN-based identification and currency-specific sub-accounts",
        tags = { "Account" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Multi-currency account registered successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MultiCurrencyAccountResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
        },
        security = {
            @SecurityRequirement(name = "OAuth2"),
            @SecurityRequirement(name = "BasicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = PATH_ACCOUNTS_MULTICURRENCY_POST,
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<MultiCurrencyAccountResponse> registerMultiCurrencyAccount(
        @Parameter(name = "RegisterMultiCurrencyAccountRequest", description = "Request containing account details", required = true)
        @Valid @RequestBody RegisterMultiCurrencyAccountRequest registerMultiCurrencyAccountRequest
    ) {
        return ResponseEntity.status(501).build();
    }

    /**
     * GET /accounts/{iban}/{currency} : Retrieve sub-account by IBAN and currency
     * Retrieves a specific sub-account uniquely identified by IBAN and currency according to Berlin Group REQ_0423
     *
     * @param iban The IBAN of the multi-currency account (required)
     * @param currency The ISO 4217 currency code (required)
     * @return Sub-account retrieved successfully (status code 200)
     *         or Bad Request - Invalid IBAN or currency format (status code 400)
     *         or Sub-account not found (status code 404)
     *         or Server Error (status code 500)
     */
    @Operation(
        operationId = "getSubAccountByIbanAndCurrency",
        summary = "Retrieve sub-account by IBAN and currency",
        description = "Retrieves a specific sub-account uniquely identified by IBAN and currency according to Berlin Group REQ_0423",
        tags = { "Account" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Sub-account retrieved successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SubAccountResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid IBAN or currency format", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Sub-account not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
        },
        security = {
            @SecurityRequirement(name = "OAuth2"),
            @SecurityRequirement(name = "BasicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = PATH_ACCOUNTS_IBAN_CURRENCY_GET,
        produces = { "application/json" }
    )
    default ResponseEntity<SubAccountResponse> getSubAccountByIbanAndCurrency(
        @Parameter(name = "iban", description = "The IBAN of the multi-currency account", required = true, example = "DE89370400440532013000")
        @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]+$") @PathVariable("iban") String iban,
        
        @Parameter(name = "currency", description = "The ISO 4217 currency code", required = true, example = "EUR")
        @Pattern(regexp = "^[A-Z]{3}$") @PathVariable("currency") String currency
    ) {
        return ResponseEntity.status(501).build();
    }
}
