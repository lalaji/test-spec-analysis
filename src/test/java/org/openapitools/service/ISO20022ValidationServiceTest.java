package org.openapitools.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ISO20022ValidationService
 */
public class ISO20022ValidationServiceTest {
    
    private ISO20022ValidationService validationService;
    
    @BeforeEach
    public void setUp() {
        validationService = new ISO20022ValidationService();
    }
    
    @Test
    public void testValidateNullContent() {
        ISO20022ValidationService.ValidationResult result = validationService.validate(null);
        
        assertFalse(result.isValid());
        assertNotNull(result.getErrors());
        assertFalse(result.getErrors().isEmpty());
        assertTrue(result.getErrors().get(0).contains("empty"));
    }
    
    @Test
    public void testValidateEmptyContent() {
        ISO20022ValidationService.ValidationResult result = validationService.validate("");
        
        assertFalse(result.isValid());
        assertNotNull(result.getErrors());
        assertFalse(result.getErrors().isEmpty());
        assertTrue(result.getErrors().get(0).contains("empty"));
    }
    
    @Test
    public void testValidateWithoutNamespace() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><Test/></Document>";
        ISO20022ValidationService.ValidationResult result = validationService.validate(xml);
        
        assertFalse(result.isValid());
        assertNotNull(result.getErrors());
        assertFalse(result.getErrors().isEmpty());
        assertTrue(result.getErrors().get(0).contains("namespace"));
    }
    
    @Test
    public void testValidateInvalidXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                     "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">" +
                     "<InvalidElement/></Document>";
        ISO20022ValidationService.ValidationResult result = validationService.validate(xml);
        
        assertFalse(result.isValid());
        assertNotNull(result.getErrors());
        assertFalse(result.getErrors().isEmpty());
    }
    
    @Test
    public void testValidateValidXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                     "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">\n" +
                     "  <CstmrCdtTrfInitn>\n" +
                     "    <GrpHdr>\n" +
                     "      <MsgId>MSG-001</MsgId>\n" +
                     "      <CreDtTm>2024-01-01T10:00:00</CreDtTm>\n" +
                     "      <NbOfTxs>1</NbOfTxs>\n" +
                     "      <InitgPty>\n" +
                     "        <Nm>Initiator Name</Nm>\n" +
                     "      </InitgPty>\n" +
                     "    </GrpHdr>\n" +
                     "    <PmtInf>\n" +
                     "      <PmtInfId>PMT-001</PmtInfId>\n" +
                     "      <PmtMtd>TRF</PmtMtd>\n" +
                     "      <ReqdExctnDt>2024-01-02</ReqdExctnDt>\n" +
                     "      <Dbtr>\n" +
                     "        <Nm>Debtor Name</Nm>\n" +
                     "      </Dbtr>\n" +
                     "      <DbtrAcct>\n" +
                     "        <Id>\n" +
                     "          <IBAN>DE89370400440532013000</IBAN>\n" +
                     "        </Id>\n" +
                     "      </DbtrAcct>\n" +
                     "      <DbtrAgt>\n" +
                     "        <FinInstnId>\n" +
                     "          <BIC>COBADEFFXXX</BIC>\n" +
                     "        </FinInstnId>\n" +
                     "      </DbtrAgt>\n" +
                     "      <CdtTrfTxInf>\n" +
                     "        <PmtId>\n" +
                     "          <EndToEndId>E2E-001</EndToEndId>\n" +
                     "        </PmtId>\n" +
                     "        <Amt>\n" +
                     "          <InstdAmt Ccy=\"EUR\">100.00</InstdAmt>\n" +
                     "        </Amt>\n" +
                     "        <CdtrAgt>\n" +
                     "          <FinInstnId>\n" +
                     "            <BIC>SOGEDEFFXXX</BIC>\n" +
                     "          </FinInstnId>\n" +
                     "        </CdtrAgt>\n" +
                     "        <Cdtr>\n" +
                     "          <Nm>Creditor Name</Nm>\n" +
                     "        </Cdtr>\n" +
                     "        <CdtrAcct>\n" +
                     "          <Id>\n" +
                     "            <IBAN>FR1420041010050500013M02606</IBAN>\n" +
                     "          </Id>\n" +
                     "        </CdtrAcct>\n" +
                     "        <RmtInf>\n" +
                     "          <Ustrd>Payment for invoice 12345</Ustrd>\n" +
                     "        </RmtInf>\n" +
                     "      </CdtTrfTxInf>\n" +
                     "    </PmtInf>\n" +
                     "  </CstmrCdtTrfInitn>\n" +
                     "</Document>";
        
        ISO20022ValidationService.ValidationResult result = validationService.validate(xml);
        
        assertTrue(result.isValid(), "Valid XML should pass validation. Errors: " + result.getErrors());
        assertNotNull(result.getErrors());
        assertTrue(result.getErrors().isEmpty());
    }
    
    @Test
    public void testValidateMissingMandatoryField() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                     "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">\n" +
                     "  <CstmrCdtTrfInitn>\n" +
                     "    <GrpHdr>\n" +
                     "      <MsgId>MSG-001</MsgId>\n" +
                     "      <!-- Missing CreDtTm which is mandatory -->\n" +
                     "      <NbOfTxs>1</NbOfTxs>\n" +
                     "      <InitgPty>\n" +
                     "        <Nm>Initiator Name</Nm>\n" +
                     "      </InitgPty>\n" +
                     "    </GrpHdr>\n" +
                     "  </CstmrCdtTrfInitn>\n" +
                     "</Document>";
        
        ISO20022ValidationService.ValidationResult result = validationService.validate(xml);
        
        assertFalse(result.isValid());
        assertNotNull(result.getErrors());
        assertFalse(result.getErrors().isEmpty());
    }
    
    @Test
    public void testValidateInvalidIBAN() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                     "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">\n" +
                     "  <CstmrCdtTrfInitn>\n" +
                     "    <GrpHdr>\n" +
                     "      <MsgId>MSG-001</MsgId>\n" +
                     "      <CreDtTm>2024-01-01T10:00:00</CreDtTm>\n" +
                     "      <NbOfTxs>1</NbOfTxs>\n" +
                     "      <InitgPty>\n" +
                     "        <Nm>Initiator Name</Nm>\n" +
                     "      </InitgPty>\n" +
                     "    </GrpHdr>\n" +
                     "    <PmtInf>\n" +
                     "      <PmtInfId>PMT-001</PmtInfId>\n" +
                     "      <PmtMtd>TRF</PmtMtd>\n" +
                     "      <ReqdExctnDt>2024-01-02</ReqdExctnDt>\n" +
                     "      <Dbtr>\n" +
                     "        <Nm>Debtor Name</Nm>\n" +
                     "      </Dbtr>\n" +
                     "      <DbtrAcct>\n" +
                     "        <Id>\n" +
                     "          <IBAN>INVALID</IBAN>\n" +
                     "        </Id>\n" +
                     "      </DbtrAcct>\n" +
                     "      <DbtrAgt>\n" +
                     "        <FinInstnId>\n" +
                     "          <BIC>COBADEFFXXX</BIC>\n" +
                     "        </FinInstnId>\n" +
                     "      </DbtrAgt>\n" +
                     "      <CdtTrfTxInf>\n" +
                     "        <PmtId>\n" +
                     "          <EndToEndId>E2E-001</EndToEndId>\n" +
                     "        </PmtId>\n" +
                     "        <Amt>\n" +
                     "          <InstdAmt Ccy=\"EUR\">100.00</InstdAmt>\n" +
                     "        </Amt>\n" +
                     "        <Cdtr>\n" +
                     "          <Nm>Creditor Name</Nm>\n" +
                     "        </Cdtr>\n" +
                     "        <CdtrAcct>\n" +
                     "          <Id>\n" +
                     "            <IBAN>FR1420041010050500013M02606</IBAN>\n" +
                     "          </Id>\n" +
                     "        </CdtrAcct>\n" +
                     "      </CdtTrfTxInf>\n" +
                     "    </PmtInf>\n" +
                     "  </CstmrCdtTrfInitn>\n" +
                     "</Document>";
        
        ISO20022ValidationService.ValidationResult result = validationService.validate(xml);
        
        assertFalse(result.isValid());
        assertNotNull(result.getErrors());
        assertFalse(result.getErrors().isEmpty());
    }
}
