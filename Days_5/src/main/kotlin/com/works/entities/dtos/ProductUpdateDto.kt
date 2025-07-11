package com.works.entities.dtos

import jakarta.validation.constraints.*
import java.io.Serializable

/**
 * DTO for {@link com.works.entities.Product}
 */
data class ProductUpdateDto(
    @field:NotNull @field:Min(1) val pid: Long? = null,
    @field:NotNull @field:Size(min = 2, max = 100) @field:NotEmpty val title: String? = null,
    @field:NotNull @field:Size(min = 2, max = 500) @field:NotEmpty val description: String? = null,
    @field:Min(2) @field:Max(10000000) val price: Double? = null
) : Serializable