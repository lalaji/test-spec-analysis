package org.openapitools.api;

import org.openapitools.model.ErrorResponse;
import org.openapitools.model.StandingOrderCreationRequest;
import org.openapitools.model.StandingOrderCreationResponse;
import org.openapitools.model.StandingOrderResponse;
import org.openapitools.model.StandingOrderListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-13T04:41:00Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path:/wso2-f5b/OB4/1.0.0}")
public class StandingOrdersApiController implements StandingOrdersApi {

    private final NativeWebRequest request;

    @Autowired
    public StandingOrdersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
