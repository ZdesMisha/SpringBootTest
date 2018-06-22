package ru.kharkov.tinkoff.service;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
public interface Converter<T, E> {

    T convert(E convertFrom);
}
