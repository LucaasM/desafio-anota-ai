package com.lmcalixto.anotaaidesafio.common.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Interface de conversão genérica para listas.
 *
 * @author Lucas Martins
 * @param <S> Source coleção de origem
 * @param <D> Destination tipo de coleção de destino
 */
public interface ListGenericConverter<S, D> extends GenericConverter<S, D>{

    default List<D> toDestination(final Collection<S> source) {
        return source.stream().map(this::toDestination).collect(Collectors.toList());
    }
}
