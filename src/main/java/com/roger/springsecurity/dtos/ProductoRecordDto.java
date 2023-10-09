package com.roger.springsecurity.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductoRecordDto(@NotBlank String descricao, @NotNull BigDecimal price, @NotNull String sku) {
}
