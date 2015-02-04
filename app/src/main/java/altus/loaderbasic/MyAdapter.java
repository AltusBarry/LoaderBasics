package altus.loaderbasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by altus on 2015/02/04.
 */
public class MyAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Model> models;

    public MyAdapter(Context context, List<Model> models) {
        this.models = models;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Model> data) {
        if (models != null) {
            models.clear();
        } else {
            models = new ArrayList<Model>();
        }
        if (data != null) {
            models.addAll(data);
        }
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup parent) {
        Model post = (Model) getItem(i);
        if (view == null) {
            view = inflater.inflate(R.layout.blogpost, null);
        }

        TextView blogTitle = (TextView) view.findViewById(R.id.blogtitle);
        blogTitle.setText(post.title);

        return view;
    }

    public int getCount() {
        return models.size();
    }

    public Object getItem(int i) {
        return models.get(i);
    }

    public long getItemId(int i) {
        return i;
    }


}
