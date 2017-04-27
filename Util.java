import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vigneswara on 18/02/2017.
 */

public class Util {

    public static boolean goodFieldLength(Context context, EditText i, int length, String falseMessage){
        if(i.getText().toString().length()>=length){
            return true;
        }else{
            showToast(context, falseMessage);
            return false;
        }

    }

    public static boolean doFieldsMatch(Context context, EditText i, EditText j, String falseMessage){

        if(i.getText().toString().equals(j.getText().toString())){
            return true;
        }else{
            clearTheFields(new EditText[]{i,j});
            showToast(context, falseMessage);
            return false;
        }

    }

    public static boolean someEmptyFields(Context context, EditText[] fields, String trueMessage){
        for(EditText field: fields){
            if(field.getText().toString().length()<=0){
                showToast(context, trueMessage);
                return true;
            }
        }
        return false;
    }

    public static boolean validDateOfMonth(Context context, int day, String falseMessage){
        if(day > 0 && day <= 31){
            return true;
        }else{
            showToast(context, falseMessage);
            return false;
        }
    }

    public static int intToCents(int value){
        return value * 100;
    }

    public static int stringToCents(String value){
        return Integer.parseInt(value) * 100;
    }

    public static String centsToString(int value){return Integer.toString(value / 100);}

    public static void clearTheFields(EditText[] fields){
        for(EditText field: fields){
            field.setText("");
        }
    }

    public static void showToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    public static String getFromShared(Context context,String item){
        SharedPreferences sp = context.getSharedPreferences(Config.RENTAPP_PREF, Context.MODE_PRIVATE);
        return sp.getString(item,"");

    }

    public static boolean isSharedAvailable(Context context, String item){
        SharedPreferences sp = context.getSharedPreferences(Config.RENTAPP_PREF, Context.MODE_PRIVATE);
        return sp.contains(item);
    }

    public static String getOrdinalSuffix(int i){
        int j = i % 10,
                k = i % 100;
        if (j == 1 && k != 11) {
            return i + "st";
        }
        if (j == 2 && k != 12) {
            return i + "nd";
        }
        if (j == 3 && k != 13) {
            return i + "rd";
        }
        return i + "th";
    }


}