package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

public class SharedPreferencesHelper
{
  private static final String PREFS_SUFFIX = ".xml";
  
  public static List<String> getSharedPreferenceTags(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = new File(paramContext.getApplicationInfo().dataDir + "/shared_prefs");
    int j;
    int i;
    if (paramContext.exists())
    {
      paramContext = paramContext.listFiles();
      j = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        Collections.sort(localArrayList);
        return localArrayList;
      }
      String str = paramContext[i].getName();
      if (str.endsWith(".xml")) {
        localArrayList.add(str.substring(0, str.length() - ".xml".length()));
      }
      i += 1;
    }
  }
  
  private static Boolean parseBoolean(String paramString)
    throws IllegalArgumentException
  {
    if (("1".equals(paramString)) || ("true".equalsIgnoreCase(paramString))) {
      return Boolean.TRUE;
    }
    if (("0".equals(paramString)) || ("false".equalsIgnoreCase(paramString))) {
      return Boolean.FALSE;
    }
    throw new IllegalArgumentException("Expected boolean, got " + paramString);
  }
  
  @Nullable
  public static Object valueFromString(String paramString, Object paramObject)
    throws IllegalArgumentException
  {
    Object localObject;
    if ((paramObject instanceof Integer)) {
      localObject = Integer.valueOf(Integer.parseInt(paramString));
    }
    do
    {
      return localObject;
      if ((paramObject instanceof Long)) {
        return Long.valueOf(Long.parseLong(paramString));
      }
      if ((paramObject instanceof Float)) {
        return Float.valueOf(Float.parseFloat(paramString));
      }
      if ((paramObject instanceof Boolean)) {
        return parseBoolean(paramString);
      }
      localObject = paramString;
    } while ((paramObject instanceof String));
    if ((paramObject instanceof Set)) {}
    int j;
    int i;
    do
    {
      try
      {
        paramString = new JSONArray(paramString);
        j = paramString.length();
        paramObject = new HashSet(j);
        i = 0;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException(paramString);
      }
      ((HashSet)paramObject).add(paramString.getString(i));
      i += 1;
      continue;
      throw new IllegalArgumentException("Unsupported type: " + paramObject.getClass().getName());
    } while (i < j);
    return paramObject;
  }
  
  public static String valueToString(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Set))
      {
        JSONArray localJSONArray = new JSONArray();
        paramObject = ((Set)paramObject).iterator();
        for (;;)
        {
          if (!((Iterator)paramObject).hasNext()) {
            return localJSONArray.toString();
          }
          localJSONArray.put((String)((Iterator)paramObject).next());
        }
      }
      return paramObject.toString();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\domstorage\SharedPreferencesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */