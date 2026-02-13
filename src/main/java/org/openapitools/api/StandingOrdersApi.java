/*
 * API contract for financial accelerator extension points in WSO2 IS and APIM
 * Standing Orders API for Berlin Group compliance
 */
package org.openapitools.api;

import org.openapitools.model.ErrorResponse;
import org.openapitools.model.StandingOrderCreationRequest;
import org.openapitools.model.StandingOrderCreationResponse;
import org.openapitools.model.StandingOrderResponse;
import org.openapitools.model.StandingOrderListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-13T04:41:00Z[Etc/UTC]")
@Validated
@Tag(name = "Standing Orders", description = "APIs for managing standing orders with Berlin Group compliance")
public interface StandingOrdersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /standing-orders : Create a new standing order
     * Creates a new standing order with structured additional information as per Berlin Group specification
     *
     * @param standingOrderCreationRequest Standing order creation request (required)
     * @return Standing order created successfully (status code 201)
     *         or Bad Request (status code 400)
     *         or Server Error (status code 500)
     */
    @Operation(
        operationId = "createStandingOrder",
        summary = "Create a new standing order",
        description = "Creates a new standing order with structured additional information as per Berlin Group specification",
        tags = { "Standing Orders" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Standing order created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = StandingOrderCreationResponse.class))
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
        value = "/standing-orders",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<StandingOrderCreationResponse> createStandingOrder(
        @Parameter(name = "StandingOrderCreationRequest", description = "Standing order creation request", required = true)
        @Valid @RequestBody StandingOrderCreationRequest standingOrderCreationRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /standing-orders : List all standing orders
     * Retrieves a list of all standing orders
     *
     * @return List of standing orders (status code 200)
     *         or Server Error (status code 500)
     */
    @Operation(
        operationId = "listStandingOrders",
        summary = "List all standing orders",
        description = "Retrieves a list of all standing orders",
        tags = { "Standing Orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of standing orders", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = StandingOrderListResponse.class))
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
        value = "/standing-orders",
        produces = { "application/json" }
    )
    default ResponseEntity<StandingOrderListResponse> listStandingOrders() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /standing-orders/{standingOrderId} : Retrieve a specific standing order
     * Retrieves details of a specific standing order by ID
     *
     * @param standingOrderId The unique identifier of the standing order (required)
     * @return Standing order details (status code 200)
     *         or Standing order not found (status code 404)
     *         or Server Error (status code 500)
     */
    @Operation(
        operationId = "getStandingOrder",
        summary = "Retrieve a specific standing order",
        description = "Retrieves details of a specific standing order by ID",
        tags = { "Standing Orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Standing order details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = StandingOrderResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Standing order not found", content = {
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
        value = "/standing-orders/{standingOrderId}",
        produces = { "application/json" }
    )
    default ResponseEntity<StandingOrderResponse> getStandingOrder(
        @Parameter(name = "standingOrderId", description = "The unique identifier of the standing order", required = true)
        @PathVariable("standingOrderId") String standingOrderId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
