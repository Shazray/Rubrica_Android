package accademia.lynxspa.com.accademiaapp.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.Contatto;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;
import accademia.lynxspa.com.accademiaapp.logic.DataAccessUtils;

public class CustomArrayAdapter extends ArrayAdapter<Contatto> {

    private final Context context;
    private List<Contatto> contattoList;

    public CustomArrayAdapter(Context context) {
        super(context, R.layout.list_item_layout, MainSingleton.getInstance().getItemList());

        contattoList = MainSingleton.getInstance().getItemList();
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewOptimize(position, convertView, parent);

    }

    public View getViewOptimize(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.number = (TextView) convertView.findViewById(R.id.number);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.logo);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contatto contatto = getItem(position);
        viewHolder.name.setText(contatto.getNome() + " " + contatto.getNome());
        viewHolder.number.setText(contatto.getTelefono());

        // Set icon
        viewHolder.image.setBackgroundColor(DataAccessUtils.getColorForPosition(context, position));
        return convertView;

    }


    private class ViewHolder {
        public TextView name;
        public TextView number;
        public ImageView image;
    }
    public void setValues(List<Contatto> contatti) {

        Log.d("DATA SET", "Contacts list count changed in " + contatti.size());

        this.contattoList = contatti;

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contattoList.size();
    }
}
