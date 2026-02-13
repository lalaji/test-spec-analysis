package org.openapitools.api;

import org.openapitools.model.Error400;
import org.openapitools.model.Error401;
import org.openapitools.model.Error403;
import org.openapitools.model.Error404;
import org.openapitools.model.Error429;
import org.openapitools.model.SigningBasketStatus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-13T04:58:28.589036433Z[Etc/UTC]", comments = "Generator version: 7.2.0")
@Controller
@RequestMapping("${openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path:/wso2-f5b/OB4/1.0.0}")
public class V1SigningBasketsApiController implements V1SigningBasketsApi {

    private final NativeWebRequest request;

    @Autowired
    public V1SigningBasketsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
