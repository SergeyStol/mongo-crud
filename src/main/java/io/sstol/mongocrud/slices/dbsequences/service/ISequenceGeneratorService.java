package io.sstol.mongocrud.slices.dbsequences.service;

/**
 * @author Sergey Stol
 * 2022-05-25
 */
public interface ISequenceGeneratorService {
    long generateSequence(String seqName);
}
