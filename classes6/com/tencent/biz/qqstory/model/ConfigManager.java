package com.tencent.biz.qqstory.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConfigManager
  implements IManager
{
  protected static final String a = "ConfigManager";
  public static final String b = "qqstory_config";
  protected SharedPreferences a;
  protected Map a;
  protected AtomicBoolean a;
  
  public ConfigManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(String paramString1, Object paramObject, String paramString2)
  {
    paramString2 = new StringBuilder().append("key=").append(paramString1).append(" expected ").append(paramString2).append(" but value was ");
    if (paramObject == null) {}
    for (paramString1 = "null";; paramString1 = paramObject.getClass().getName())
    {
      SLog.d("ConfigManager", paramString1);
      return;
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IllegalStateException("have not attachContext");
    }
  }
  
  public Object a(String paramString, Object paramObject)
  {
    c();
    Object localObject = this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (localObject.getClass() == paramObject.getClass())) {
      return localObject;
    }
    a(paramString, localObject, paramObject.getClass().getName());
    return paramObject;
  }
  
  public void a()
  {
    SLog.b("ConfigManager", "onInit");
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      SLog.b("ConfigManager", "attachContext, " + paramContext);
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("qqstory_config", 0);
      this.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_AndroidContentSharedPreferences.getAll());
      return;
    }
    SLog.d("ConfigManager", "attachContext duplicate");
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramObject.getClass() == Integer.class) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, ((Integer)paramObject).intValue()).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramObject);
      return;
      if (paramObject.getClass() == Long.class)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, ((Long)paramObject).longValue()).commit();
      }
      else if (paramObject.getClass() == String.class)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString, (String)paramObject).commit();
      }
      else
      {
        if (paramObject.getClass() != Boolean.class) {
          break;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, ((Boolean)paramObject).booleanValue()).commit();
      }
    }
    throw new IllegalArgumentException("value class is not support : " + paramObject.getClass());
  }
  
  public void b()
  {
    SLog.b("ConfigManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\ConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */