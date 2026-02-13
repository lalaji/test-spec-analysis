# API Response Examples with _links Field

## Overview

This document provides comprehensive examples of API responses that include the `_links` field, demonstrating both relative and absolute link formats according to Berlin Group requirement REQ_1108.

## Table of Contents

1. [Basic Response Examples](#basic-response-examples)
2. [Paginated Responses](#paginated-responses)
3. [Nested Resources](#nested-resources)
4. [Error Responses](#error-responses)
5. [Consent Responses](#consent-responses)
6. [Payment Responses](#payment-responses)

---

## Basic Response Examples

### Single Resource - Relative Links

```json
{
  "accountId": "3dc3d5b3-7023-4848-9853-f5400a64e80f",
  "iban": "DE89370400440532013000",
  "currency": "EUR",
  "accountType": "Current",
  "cashAccountType": "CACC",
  "status": "enabled",
  "name": "Main Account",
  "product": "Current Account",
  "_links": {
    "self": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f"
    },
    "balances": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/balances"
    },
    "transactions": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/transactions"
    }
  }
}
```

### Single Resource - Absolute Links

```json
{
  "accountId": "3dc3d5b3-7023-4848-9853-f5400a64e80f",
  "iban": "DE89370400440532013000",
  "currency": "EUR",
  "accountType": "Current",
  "cashAccountType": "CACC",
  "status": "enabled",
  "name": "Main Account",
  "product": "Current Account",
  "_links": {
    "self": {
      "href": "https://api.example.com/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f"
    },
    "balances": {
      "href": "https://api.example.com/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/balances"
    },
    "transactions": {
      "href": "https://api.example.com/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/transactions"
    }
  }
}
```

---

## Paginated Responses

### Account List - First Page (Relative Links)

```json
{
  "accounts": [
    {
      "accountId": "3dc3d5b3-7023-4848-9853-f5400a64e80f",
      "iban": "DE89370400440532013000",
      "currency": "EUR",
      "name": "Main Account",
      "_links": {
        "self": {
          "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f"
        }
      }
    },
    {
      "accountId": "8f5a7c2e-1234-5678-9abc-def012345678",
      "iban": "DE89370400440532013001",
      "currency": "EUR",
      "name": "Savings Account",
      "_links": {
        "self": {
          "href": "/v1/accounts/8f5a7c2e-1234-5678-9abc-def012345678"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "/v1/accounts?page=1&size=10"
    },
    "first": {
      "href": "/v1/accounts?page=1&size=10"
    },
    "next": {
      "href": "/v1/accounts?page=2&size=10"
    },
    "last": {
      "href": "/v1/accounts?page=5&size=10"
    }
  },
  "page": {
    "size": 10,
    "totalElements": 45,
    "totalPages": 5,
    "number": 1
  }
}
```

### Account List - Middle Page (Absolute Links)

```json
{
  "accounts": [
    {
      "accountId": "7b9d3f1e-4567-8901-bcde-f23456789012",
      "iban": "DE89370400440532013002",
      "currency": "EUR",
      "name": "Investment Account",
      "_links": {
        "self": {
          "href": "https://api.example.com/v1/accounts/7b9d3f1e-4567-8901-bcde-f23456789012"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "https://api.example.com/v1/accounts?page=3&size=10"
    },
    "first": {
      "href": "https://api.example.com/v1/accounts?page=1&size=10"
    },
    "prev": {
      "href": "https://api.example.com/v1/accounts?page=2&size=10"
    },
    "next": {
      "href": "https://api.example.com/v1/accounts?page=4&size=10"
    },
    "last": {
      "href": "https://api.example.com/v1/accounts?page=5&size=10"
    }
  },
  "page": {
    "size": 10,
    "totalElements": 45,
    "totalPages": 5,
    "number": 3
  }
}
```

### Account List - Last Page (Relative Links)

```json
{
  "accounts": [
    {
      "accountId": "9e8d7c6b-5a4f-3e2d-1c0b-a09876543210",
      "iban": "DE89370400440532013003",
      "currency": "EUR",
      "name": "Business Account",
      "_links": {
        "self": {
          "href": "/v1/accounts/9e8d7c6b-5a4f-3e2d-1c0b-a09876543210"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "/v1/accounts?page=5&size=10"
    },
    "first": {
      "href": "/v1/accounts?page=1&size=10"
    },
    "prev": {
      "href": "/v1/accounts?page=4&size=10"
    },
    "last": {
      "href": "/v1/accounts?page=5&size=10"
    }
  },
  "page": {
    "size": 10,
    "totalElements": 45,
    "totalPages": 5,
    "number": 5
  }
}
```

---

## Nested Resources

### Account with Balances and Transactions Links

```json
{
  "accountId": "3dc3d5b3-7023-4848-9853-f5400a64e80f",
  "iban": "DE89370400440532013000",
  "currency": "EUR",
  "balances": [
    {
      "balanceType": "closingBooked",
      "balanceAmount": {
        "amount": "5000.00",
        "currency": "EUR"
      },
      "referenceDate": "2024-01-15"
    },
    {
      "balanceType": "expected",
      "balanceAmount": {
        "amount": "5200.00",
        "currency": "EUR"
      },
      "referenceDate": "2024-01-15"
    }
  ],
  "_links": {
    "self": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f"
    },
    "balances": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/balances"
    },
    "transactions": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/transactions"
    }
  }
}
```

### Transaction Details with Related Links

```json
{
  "transactionId": "1234567890",
  "bookingDate": "2024-01-15",
  "valueDate": "2024-01-15",
  "transactionAmount": {
    "amount": "-50.00",
    "currency": "EUR"
  },
  "creditorName": "Electricity Company",
  "creditorAccount": {
    "iban": "DE89370400440532013999"
  },
  "remittanceInformationUnstructured": "Invoice 2024-001",
  "proprietaryBankTransactionCode": "PMNT",
  "_links": {
    "self": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/transactions/1234567890"
    },
    "account": {
      "href": "/v1/accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f"
    }
  }
}
```

---

## Error Responses

### Error Response with Support Link

```json
{
  "responseId": "Ec1wMjmiG8",
  "errorMessage": "invalid_request",
  "errorDescription": "The request is missing required parameters",
  "errorCode": "400",
  "_links": {
    "self": {
      "href": "/v1/accounts/invalid-id"
    },
    "support": {
      "href": "/v1/support"
    },
    "documentation": {
      "href": "/v1/docs/errors/invalid_request"
    }
  }
}
```

---

## Consent Responses

### Consent Creation Response (Relative Links)

```json
{
  "consentId": "7890-asdf-4567",
  "consentStatus": "received",
  "validUntil": "2024-12-31",
  "access": {
    "accounts": [
      {
        "iban": "DE89370400440532013000"
      }
    ],
    "balances": [
      {
        "iban": "DE89370400440532013000"
      }
    ],
    "transactions": [
      {
        "iban": "DE89370400440532013000"
      }
    ]
  },
  "_links": {
    "self": {
      "href": "/v1/consents/7890-asdf-4567"
    },
    "status": {
      "href": "/v1/consents/7890-asdf-4567/status"
    },
    "scaRedirect": {
      "href": "/v1/authorize?consentId=7890-asdf-4567"
    },
    "scaStatus": {
      "href": "/v1/consents/7890-asdf-4567/authorisations/123-auth-456"
    }
  }
}
```

### Consent Details (Absolute Links)

```json
{
  "consentId": "7890-asdf-4567",
  "consentStatus": "valid",
  "validUntil": "2024-12-31",
  "recurringIndicator": true,
  "frequencyPerDay": 4,
  "lastActionDate": "2024-01-15",
  "access": {
    "accounts": [
      {
        "iban": "DE89370400440532013000"
      }
    ],
    "balances": [
      {
        "iban": "DE89370400440532013000"
      }
    ],
    "transactions": [
      {
        "iban": "DE89370400440532013000"
      }
    ]
  },
  "_links": {
    "self": {
      "href": "https://api.example.com/v1/consents/7890-asdf-4567"
    },
    "status": {
      "href": "https://api.example.com/v1/consents/7890-asdf-4567/status"
    },
    "delete": {
      "href": "https://api.example.com/v1/consents/7890-asdf-4567"
    }
  }
}
```

---

## Payment Responses

### Payment Initiation Response (Relative Links)

```json
{
  "paymentId": "payment-123456",
  "transactionStatus": "RCVD",
  "creditorName": "Merchant Corp",
  "creditorAccount": {
    "iban": "DE89370400440532013888"
  },
  "instructedAmount": {
    "amount": "100.00",
    "currency": "EUR"
  },
  "_links": {
    "self": {
      "href": "/v1/payments/sepa-credit-transfers/payment-123456"
    },
    "status": {
      "href": "/v1/payments/sepa-credit-transfers/payment-123456/status"
    },
    "scaRedirect": {
      "href": "/v1/authorize?paymentId=payment-123456"
    },
    "scaStatus": {
      "href": "/v1/payments/sepa-credit-transfers/payment-123456/authorisations/auth-789"
    }
  }
}
```

### Payment Status Response (Absolute Links)

```json
{
  "paymentId": "payment-123456",
  "transactionStatus": "ACCP",
  "_links": {
    "self": {
      "href": "https://api.example.com/v1/payments/sepa-credit-transfers/payment-123456/status"
    },
    "payment": {
      "href": "https://api.example.com/v1/payments/sepa-credit-transfers/payment-123456"
    }
  }
}
```

---

## Notes

### Link Relations Used

- **self**: Reference to the current resource
- **first**: First page in a paginated collection
- **prev**: Previous page in a paginated collection
- **next**: Next page in a paginated collection
- **last**: Last page in a paginated collection
- **account**: Reference to the account resource
- **balances**: Reference to account balances
- **transactions**: Reference to account transactions
- **status**: Reference to status information
- **scaRedirect**: URL for Strong Customer Authentication redirect
- **scaStatus**: URL for checking SCA status
- **delete**: URL for deleting the resource
- **support**: URL for support resources
- **documentation**: URL for relevant documentation

### Common Patterns

1. **Collection-level links** appear at the root level of the response
2. **Item-level links** appear within each item in a collection
3. **Pagination links** omit `prev` on first page and `next` on last page
4. **Query parameters** are preserved in pagination links
5. **Resource IDs** are included in the path for resource-specific links

### Implementation Tips

1. Always include a `self` link for every resource
2. Only include links that are relevant and accessible to the current user
3. Ensure all links are properly URL-encoded
4. Use consistent link relation names across all endpoints
5. Consider including links to related resources for better API discoverability

## References

- [_links Field Implementation Guide](./LINKS_FIELD_IMPLEMENTATION.md)
- [Configuration Guide](./CONFIGURATION_GUIDE.md)
- Berlin Group NextGenPSD2 Framework Implementation Guidelines
