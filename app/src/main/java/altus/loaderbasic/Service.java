package altus.loaderbasic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by altus on 2015/02/04.
 */
public class Service {
     public ArrayList<Model> getPosts() {
         return new ArrayList<Model>((java.util.Collection<? extends Model>) new Model("Title", "Body"));
     }
}
