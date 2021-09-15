package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(2);
        modelClasses.add(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class);
        modelClasses.add(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(2);
        infoMap.put(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class, io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class, io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            return io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            return io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            return "ModelMovie";
        }
        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            return "ModelTV";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
                return clazz.cast(new io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy());
            }
            if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
                return clazz.cast(new io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.copyOrUpdate(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelMovie) obj, update, cache));
        }
        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.copyOrUpdate(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelTV) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.insert(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelMovie) object, cache);
        } else if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.insert(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelTV) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
                io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.insert(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelMovie) object, cache);
            } else if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
                io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.insert(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelTV) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
                    io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
                    io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.insertOrUpdate(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelMovie) obj, cache);
        } else if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.insertOrUpdate(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelTV) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
                io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.insertOrUpdate(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelMovie) object, cache);
            } else if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
                io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.insertOrUpdate(realm, (com.tugaspts_33_11rpl1.moviedb.model.ModelTV) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
                    io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
                    io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelMovie.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelMovieRealmProxy.createDetachedCopy((com.tugaspts_33_11rpl1.moviedb.model.ModelMovie) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.tugaspts_33_11rpl1.moviedb.model.ModelTV.class)) {
            return clazz.cast(io.realm.com_tugaspts_33_11rpl1_moviedb_model_ModelTVRealmProxy.createDetachedCopy((com.tugaspts_33_11rpl1.moviedb.model.ModelTV) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
