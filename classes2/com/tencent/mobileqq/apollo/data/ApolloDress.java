package com.tencent.mobileqq.apollo.data;

import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import prc;

public class ApolloDress
  implements Cloneable
{
  public static final String a = "ApolloDress";
  public int a;
  public long a;
  public HashMap a;
  public int b;
  
  public ApolloDress()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ApolloDress a(String paramString)
  {
    ApolloDress localApolloDress = new ApolloDress();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Object localObject1 = localJSONObject.getJSONObject("role");
      localApolloDress.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("id");
      localApolloDress.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("ts");
      localApolloDress.b = localJSONObject.optInt("sex");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDress", 2, "parseApolloDress data:" + paramString);
      }
      paramString = localJSONObject.getJSONArray("dresslist");
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.getJSONObject(i);
        localObject1 = new ApolloDress.Dress();
        ((ApolloDress.Dress)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("id");
        ((ApolloDress.Dress)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("ts");
        ((ApolloDress.Dress)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject2 = ((JSONObject)localObject2).getJSONArray("parts");
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          ((ApolloDress.Dress)localObject1).jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(j));
          j += 1;
        }
        if (localApolloDress.jdField_a_of_type_JavaUtilHashMap == null) {
          localApolloDress.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localApolloDress.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((ApolloDress.Dress)localObject1).jdField_a_of_type_Int), localObject1);
        i += 1;
      }
      if ((localApolloDress.jdField_a_of_type_JavaUtilHashMap == null) || (localApolloDress.jdField_a_of_type_JavaUtilHashMap.size() < 7))
      {
        QLog.e("ApolloDress", 2, "parseApolloDress role dress do not complete :" + localJSONObject.toString());
        if (QLog.isColorLevel())
        {
          i = localApolloDress.jdField_a_of_type_Int;
          ThreadManager.c().post(new prc(i));
        }
      }
      return localApolloDress;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloDress", 2, "parseApolloDress failed", paramString);
      }
    }
    return null;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_Int + "|");
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = new TreeSet(this.jdField_a_of_type_JavaUtilHashMap.keySet()).iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(localIterator.next()).append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public int[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.keySet().size() == 0)) {
      return ApolloResDownloader.a(this.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    int[] arrayOfInt = new int[((Set)localObject).size()];
    localObject = ((Set)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((Integer)((Iterator)localObject).next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      ApolloDress localApolloDress = (ApolloDress)super.clone();
      localObject = localApolloDress;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      ((ApolloDress)localObject).jdField_a_of_type_JavaUtilHashMap = ((HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone());
    }
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[").append("roleId: ").append(this.jdField_a_of_type_Int).append(",roleTs: ").append(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
      localStringBuilder.append(",ids [");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((Integer)((Iterator)localObject).next()).append(",");
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\data\ApolloDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */