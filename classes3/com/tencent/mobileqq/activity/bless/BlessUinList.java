package com.tencent.mobileqq.activity.bless;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class BlessUinList
{
  public static final String a = "bless_uin_list";
  public static final String b = "bless_uin_list_time_millis";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public BlessUinList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static BlessUinList a(SharedPreferences paramSharedPreferences)
  {
    BlessUinList localBlessUinList = new BlessUinList();
    localBlessUinList.jdField_a_of_type_Long = paramSharedPreferences.getLong("bless_uin_list_time_millis", 0L);
    if (DateUtils.isToday(localBlessUinList.jdField_a_of_type_Long)) {
      try
      {
        paramSharedPreferences = paramSharedPreferences.getString("bless_uin_list", "[]");
        if (QLog.isColorLevel()) {
          QLog.d(BlessManager.a, 2, "read uin list from SP=" + paramSharedPreferences);
        }
        JSONArray localJSONArray = new JSONArray(paramSharedPreferences);
        int i = 0;
        for (;;)
        {
          paramSharedPreferences = localBlessUinList;
          if (i + 1 >= localJSONArray.length()) {
            break;
          }
          localBlessUinList.a(localJSONArray.getString(i), localJSONArray.getInt(i + 1));
          i += 2;
        }
        return paramSharedPreferences;
      }
      catch (Exception paramSharedPreferences)
      {
        paramSharedPreferences.printStackTrace();
        paramSharedPreferences = null;
      }
    }
    localBlessUinList.jdField_a_of_type_Long = System.currentTimeMillis();
    return localBlessUinList;
  }
  
  public static void a(SharedPreferences paramSharedPreferences, BlessUinList paramBlessUinList)
  {
    paramBlessUinList.a();
    Object localObject = new JSONArray();
    Iterator localIterator = paramBlessUinList.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      ((JSONArray)localObject).put(localEntry.getValue());
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    localObject = ((JSONArray)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d(BlessManager.a, 2, "save uin list to SP=" + (String)localObject);
    }
    paramSharedPreferences.putString("bless_uin_list", (String)localObject);
    paramSharedPreferences.putLong("bless_uin_list_time_millis", paramBlessUinList.jdField_a_of_type_Long);
    paramSharedPreferences.commit();
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int += paramInt;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.size();
  }
  
  public int a(String paramString)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
  }
  
  public void a()
  {
    if (!DateUtils.isToday(this.jdField_a_of_type_Long)) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + 1));
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessUinList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */