package br.com.dbserver.votacao.utils;

import br.com.dbserver.votacao.domain.generic.GenericDTO;
import br.com.dbserver.votacao.domain.generic.GenericEntity;

public class Util {

    public static boolean isNull(Object o){
        return o == null;
    }

    public static boolean isNotNull(Object o){
        return !isNull(o);
    }

    public static boolean isNew(GenericEntity o) {
        if (isNull(o)) return true;
        return o.getId() == null;
    }
    public static boolean isNew(GenericDTO o) {
        if (isNull(o)) return true;
        return o.getId() == null;
    }
}
