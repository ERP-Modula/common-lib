package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Провайдеры платежных систем
 */
@Getter
@RequiredArgsConstructor
public enum PaymentProvider {
    YOO_KASSA("ЮKassa"),
    STRIPE("Stripe"),
    PAYPAL("PayPal"),
    INTERNAL("Внутренняя система");

    private final String displayName;
}
