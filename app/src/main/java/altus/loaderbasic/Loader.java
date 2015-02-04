package altus.loaderbasic;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by altus on 2015/02/04.
 */
public class Loader extends AsyncTaskLoader<List<Model>> {


        private Service service = new Service();

        public Loader(Context context) {
            super(context);
        }

        @Override public List<Model> loadInBackground() {
            return service.getPosts();
        }




}
