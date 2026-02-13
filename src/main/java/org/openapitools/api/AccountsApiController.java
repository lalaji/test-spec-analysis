package org.openapitools.api;

import org.openapitools.model.ErrorResponse;
import org.openapitools.model.MultiCurrencyAccount;
import org.openapitools.model.MultiCurrencyAccountResponse;
import org.openapitools.model.RegisterMultiCurrencyAccountRequest;
import org.openapitools.model.SubAccount;
import org.openapitools.model.SubAccountResponse;
import org.openapitools.service.MultiCurrencyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-13T04:23:17.978812429Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
@Controller
@RequestMapping("${openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path:/wso2-f5b/OB4/1.0.0}")
public class AccountsApiController implements AccountsApi {

    private final NativeWebRequest request;
    private final MultiCurrencyAccountService accountService;

    @Autowired
    public AccountsApiController(NativeWebRequest request, MultiCurrencyAccountService accountService) {
        this.request = request;
        this.accountService = accountService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<MultiCurrencyAccountResponse> registerMultiCurrencyAccount(
            RegisterMultiCurrencyAccountRequest registerMultiCurrencyAccountRequest) {
        try {
            // Register the multi-currency account
            MultiCurrencyAccount account = accountService.registerMultiCurrencyAccount(registerMultiCurrencyAccountRequest);

            // Build response
            MultiCurrencyAccountResponse response = new MultiCurrencyAccountResponse();
            response.setResponseId(registerMultiCurrencyAccountRequest.getRequestId());
            response.setStatus(MultiCurrencyAccountResponse.StatusEnum.SUCCESS);
            response.setMultiCurrencyAccount(account);

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            // Return 400 Bad Request for validation errors
            MultiCurrencyAccountResponse errorResponse = new MultiCurrencyAccountResponse();
            errorResponse.setResponseId(registerMultiCurrencyAccountRequest.getRequestId());
            errorResponse.setStatus(MultiCurrencyAccountResponse.StatusEnum.ERROR);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            // Return 500 Internal Server Error for unexpected errors
            MultiCurrencyAccountResponse errorResponse = new MultiCurrencyAccountResponse();
            errorResponse.setResponseId(registerMultiCurrencyAccountRequest.getRequestId());
            errorResponse.setStatus(MultiCurrencyAccountResponse.StatusEnum.ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @Override
    public ResponseEntity<SubAccountResponse> getSubAccountByIbanAndCurrency(String iban, String currency) {
        try {
            // Retrieve the sub-account by IBAN and currency (REQ_0423 implementation)
            Optional<SubAccount> subAccountOpt = accountService.getSubAccountByIbanAndCurrency(iban, currency);
            
            if (subAccountOpt.isPresent()) {
                // Get the parent account for additional context
                Optional<MultiCurrencyAccount> accountOpt = accountService.getMultiCurrencyAccountByIban(iban);
                
                SubAccountResponse response = new SubAccountResponse();
                response.setIban(iban);
                response.setSubAccount(subAccountOpt.get());
                accountOpt.ifPresent(account -> response.setAccountName(account.getAccountName()));
                
                return ResponseEntity.ok(response);
            } else {
                // Sub-account not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (IllegalArgumentException e) {
            // Return 400 Bad Request for validation errors (invalid IBAN or currency format)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            // Return 500 Internal Server Error for unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

