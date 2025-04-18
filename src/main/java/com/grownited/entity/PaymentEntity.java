/*
 * package com.grownited.entity;
 * 
 * import java.time.LocalDateTime;
 * 
 * import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
 * import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
 * import jakarta.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="payment") public class PaymentEntity {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer
 * paymentId; private Integer reservationId; private String transactionId;
 * private String responseCode; private String messageCode; private String
 * description; private String authCode; private LocalDateTime paymentDate;
 * public Integer getPaymentId() { return paymentId; } public void
 * setPaymentId(Integer paymentId) { this.paymentId = paymentId; } public
 * Integer getReservationId() { return reservationId; } public void
 * setReservationId(Integer reservationId) { this.reservationId = reservationId;
 * } public String getTransactionId() { return transactionId; } public void
 * setTransactionId(String transactionId) { this.transactionId = transactionId;
 * } public String getResponseCode() { return responseCode; } public void
 * setResponseCode(String responseCode) { this.responseCode = responseCode; }
 * public String getMessageCode() { return messageCode; } public void
 * setMessageCode(String messageCode) { this.messageCode = messageCode; } public
 * String getDescription() { return description; } public void
 * setDescription(String description) { this.description = description; } public
 * String getAuthCode() { return authCode; } public void setAuthCode(String
 * authCode) { this.authCode = authCode; } public LocalDateTime getPaymentDate()
 * { return paymentDate; } public void setPaymentDate(LocalDateTime paymentDate)
 * { this.paymentDate = paymentDate; }
 * 
 * 
 * }
 */