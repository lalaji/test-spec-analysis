package org.openapitools.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

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
