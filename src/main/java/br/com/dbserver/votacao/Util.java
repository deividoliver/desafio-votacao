package br.com.dbserver.votacao;

import br.com.dbserver.votacao.domain.generic.SystemAbstractDTO;
import br.com.dbserver.votacao.domain.generic.SystemAbstractEntity;

public class Util {

    public static boolean isNull(Object o){
        return o == null;
    }

    public static boolean isNotNull(Object o){
        return !isNull(o);
    }

    public static boolean isNew(SystemAbstractEntity o) {
        if (isNull(o)) return true;
        return o.getId() == null;
    }
    public static boolean isNew(SystemAbstractDTO o) {
        if (isNull(o)) return true;
        return o.getId() == null;
    }
}
