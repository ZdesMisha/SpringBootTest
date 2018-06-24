package ru.kharkov.tinkoff.service;

import ru.kharkov.tinkoff.exception.ConversionException;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
public interface Converter<T, E> {

    T convert(E from) throws ConversionException;
}
