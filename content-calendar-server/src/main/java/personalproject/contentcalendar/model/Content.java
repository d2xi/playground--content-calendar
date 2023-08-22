package personalproject.contentcalendar.model;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import personalproject.contentcalendar.validation.EnumValue;

public record Content(
        @Digits(integer = 8, fraction = 0) @Min(value = 0, message = "Value must be at least 0") @Max(value = Integer.MAX_VALUE, message = "Value must be at least "
                + Integer.MAX_VALUE) Integer id,
        @NotBlank String title,
        @NotNull @EnumValue(enumClass = Status.class) Status status,
        @NotNull String desc,
        @NotNull @EnumValue(enumClass = Type.class) Type contentType,
        @FutureOrPresent LocalDateTime dateCreated,
        @Nullable @FutureOrPresent LocalDateTime dateUpdated,
        @NotNull String url) {

}