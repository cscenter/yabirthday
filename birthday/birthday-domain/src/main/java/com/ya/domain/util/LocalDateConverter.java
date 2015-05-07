package com.ya.domain.util;

import javax.persistence.AttributeConverter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Max on 07.05.2015.
 */
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        Instant instant1 = date.toInstant();
        return LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalDate();
    }
}
