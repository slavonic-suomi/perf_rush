package pl.jbazil.javabase.classis.orm.persistence.mapper;


import pl.jbazil.javabase.classis.orm.persistence.entity.IEntity;

public interface PersistenceMapper<M, E extends IEntity> {
    E modelToEntity(M model);

    M entityToModel(E entity);
}
