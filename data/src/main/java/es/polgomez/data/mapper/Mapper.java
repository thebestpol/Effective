package es.polgomez.data.mapper;

public interface Mapper<M, P> {

    P modelToData(M model);

    M dataToModel(P data);
}
