package com.lmcalixto.anotaaidesafio.common.converter;

/**
 * Interface de conversão genérica
 *
 * @author Lucas Martins
 * @param <S> Source objeto de origem
 * @param <D> Destination tipo de destino
 */
public interface GenericConverter <S, D> {

    D toDestination (S source);
}
