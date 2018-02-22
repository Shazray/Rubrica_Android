package accademia.lynxspa.com.accademiaapp.logic;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.Contatto;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;

public class DataAccessUtils {

    /* costanti */
    final static String preferito = "sharePreferences";
    final static String PREFS_FILENAME  ="filename";


    public static List<Contatto> getDataSourceItemList(Context context) {

        return MainSingleton.getInstance().getItemList();
    }

    public static List<Contatto> addItemToDataSource(Context context, Contatto itemToAdd) {
        List<Contatto> datasource = DataAccessUtils.getDataSourceItemList(context);
        datasource.add(itemToAdd);

        MainSingleton.getInstance().setItemList(datasource);
        return datasource;
    }

    public static Contatto getItemAtIndex(Context context, int index) {
        List<Contatto> datasource = DataAccessUtils.getDataSourceItemList(context);
        return datasource.get(index);
    }

    public static List<Contatto> removeItemAtIndex(Context context, int index) {
        List<Contatto> datasource = DataAccessUtils.getDataSourceItemList(context);
        datasource.remove(index);

        MainSingleton.getInstance().setItemList(datasource);
        return datasource;
    }

    public static int getColorForPosition(Context context, int position){

        if(position % 2 == 0){
            return context.getColor(R.color.light_blu);
        }else{
            return context.getColor(R.color.light_gray);
        }

    }


    public static void initDataSource(Context context) {
        Contatto firstContact = new Contatto("Pippo", "+39 1234567");
        addItemToDataSource(context, firstContact);
    }

    /* SharedPrefereces methods */

    private static void setFavoriteValueInPreferences(Context context, String favorite){

        SharedPreferences shadpref =context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shadpref.edit();

        editor.putString(preferito,favorite);
        editor.commit();

    }

    public static String getFavoriteValueInPreferences(Context context){

        SharedPreferences sharedPreferencesc = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
        String favorite = sharedPreferencesc.getString(preferito, null);
        return favorite;
    }
}
