package altus.loaderbasic;

import android.app.Activity;
import android.content.*;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.app.LoaderManager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyAdapter myAdapter = new MyAdapter(this, new ArrayList<Model>());
        ListView listVeiw = (ListView) findViewById(R.id.list);

        listVeiw.setAdapter(myAdapter);

        getLoaderManager().initLoader(0, savedInstanceState,
                new LoaderManager.LoaderCallbacks<List<Model>>() {
                    @Override public Loader<List<Model>> onCreateLoader(int id, Bundle args) {
                        return new Loader(MainActivity.this);
                    }

                    @Override public void onLoadFinished(Loader<List<Model>> loader, List<Model> data) {
                        myAdapter.setData(data);
                    }

                    @Override public void onLoaderReset(Loader<List<Model>> loader) {
                        myAdapter.setData(new ArrayList<Model>());
                    }
                }
        ).forceLoad();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
