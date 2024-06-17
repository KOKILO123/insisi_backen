package pe.gob.pge.insisi.utility;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayUtil {

    public static ArrayList convert(JSONArray jArr)
    {
        ArrayList list = new ArrayList<>();
        try {
            for (int i=0, l=jArr.length(); i<l; i++){
                list.add(jArr.get(i));
            }
        } catch (JSONException e) {}

        return list;
    }

    public static JSONArray convert(Collection<Object> list)
    {
        return new JSONArray(list);
    }
}
