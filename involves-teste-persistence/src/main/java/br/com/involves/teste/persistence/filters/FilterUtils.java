package br.com.involves.teste.persistence.filters;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class FilterUtils {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Collection filter (Collection col, Filter filter){
        Collection result = new HashSet();
        for (Iterator it = col.iterator(); it.hasNext();) {
              Object obj = it.next();
              if (filter.accept(obj)) {
            	  result.add(obj);
              }
        }
        return result;
    }
	
	
}
