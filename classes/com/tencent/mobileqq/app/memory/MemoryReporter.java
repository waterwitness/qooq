package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class MemoryReporter
  implements Handler.Callback
{
  public static final int a = 86400000;
  private static MemoryReporter jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter;
  private static final String jdField_a_of_type_JavaLangString = "MemoryReporter";
  public static ArrayList a;
  private static final int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = "memory_reporter";
  private static final String jdField_c_of_type_JavaLangString = "MemoryReporter";
  private static final String d = "sp_item_memory_last_report_time";
  private static final String e = "sp_key_last_shot_time";
  private static final String f = "sp_key_sharp_pss_";
  private static final String g = "sp_key_sharp_heap_";
  private static final String h = "sp_key_leak_objs_";
  private static final String i = "HeapMax";
  private static final String j = "SystemTotal";
  private static final String k = "SystemThresold";
  private static final String l = "osVersion";
  private static final String m = "resolution";
  private static final String n = "SharpHeap";
  private static final String o = "SharpPss";
  private static final String p = "leaks";
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Vector jdField_a_of_type_JavaUtilVector;
  public boolean a;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = System.currentTimeMillis();
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private MemoryReporter()
  {
    float f1 = MemoryConfigs.a().b;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("memory_reporter", 0);
    long l1 = localSharedPreferences.getLong("sp_key_last_shot_time", 0L);
    if (Math.abs(System.currentTimeMillis() - l1) >= 86400000L) {
      if (f1 >= Math.random())
      {
        this.jdField_a_of_type_Boolean = true;
        localSharedPreferences.edit().putLong("sp_key_last_shot_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.a(), this);
      }
      this.jdField_a_of_type_JavaUtilVector = new Vector();
      return;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static MemoryReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter = new MemoryReporter();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((MemoryReporter.IMemoryListener)localIterator.next()).a(paramLong);
      }
    }
  }
  
  private void b()
  {
    long l1 = MemoryManager.a(Process.myPid());
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = l1;
    }
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    if (l2 > this.jdField_b_of_type_Long)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Long = l2;
      if (this.jdField_b_of_type_Long >= (100 - MemoryConfigs.a().a) * Runtime.getRuntime().maxMemory() / 100L) {
        a(this.jdField_b_of_type_Long);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("PSS=");
      localStringBuilder.append(l1 / 1024L);
      localStringBuilder.append(" KB HeapMax=");
      localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
      localStringBuilder.append(" KB HeapAlloc=");
      localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L);
      localStringBuilder.append(" KB HeapFree=");
      localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L);
      localStringBuilder.append(" KB");
      QLog.d("MemoryReporter", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Int += 1;
    if ((this.jdField_c_of_type_Int >= 12) && ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean)))
    {
      d();
      this.jdField_c_of_type_Int = 0;
    }
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("memory_reporter", 0);
    long l1 = localSharedPreferences.getLong("sp_item_memory_last_report_time", 0L);
    Object localObject1;
    HashMap localHashMap;
    Iterator localIterator;
    Object localObject2;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if ((Math.abs(System.currentTimeMillis() - l1) >= 86400000L) || (!this.jdField_a_of_type_Boolean))
    {
      localObject1 = localSharedPreferences.getAll();
      localHashMap = new HashMap();
      localIterator = ((Map)localObject1).entrySet().iterator();
      localObject2 = new ArrayList();
      localObject1 = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
    }
    for (;;)
    {
      Map.Entry localEntry;
      String str1;
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        str1 = (String)localEntry.getKey();
        if (str1.startsWith("sp_key_sharp_heap_"))
        {
          ((StringBuilder)localObject1).append(String.valueOf(localEntry.getValue()));
          ((StringBuilder)localObject1).append("|");
          ((ArrayList)localObject2).add(str1);
          continue;
        }
        if (str1.startsWith("sp_key_sharp_pss_"))
        {
          localStringBuilder1.append(String.valueOf(localEntry.getValue()));
          localStringBuilder1.append("|");
          ((ArrayList)localObject2).add(str1);
          continue;
        }
        if (!str1.startsWith("sp_key_leak_objs_")) {
          continue;
        }
      }
      try
      {
        String str2 = str1.substring("sp_key_leak_objs_".length());
        localStringBuilder2.append(str2.substring(str2.indexOf("_") + 1));
        localStringBuilder2.append(":");
        localStringBuilder2.append(String.valueOf(localEntry.getValue()));
        localStringBuilder2.append("|");
        ((ArrayList)localObject2).add(str1);
        continue;
        if (((ArrayList)localObject2).size() > 0)
        {
          localIterator = ((ArrayList)localObject2).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (String)localIterator.next();
            localSharedPreferences.edit().remove((String)localObject2).commit();
          }
          if (((StringBuilder)localObject1).length() > 0) {
            localHashMap.put("SharpHeap", ((StringBuilder)localObject1).toString());
          }
          if (localStringBuilder1.length() > 0) {
            localHashMap.put("SharpPss", localStringBuilder1.toString());
          }
          if (localStringBuilder2.length() > 0) {
            localHashMap.put("leaks", localStringBuilder2.toString());
          }
          localHashMap.put("SystemTotal", String.valueOf(DeviceInfoUtil.c()));
          localHashMap.put("SystemThresold", String.valueOf(DeviceInfoUtil.e()));
          localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory()));
          localHashMap.put("osVersion", Build.VERSION.RELEASE);
          localHashMap.put("resolution", DeviceInfoUtil.l());
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "MemoryReporter", true, 0L, 0L, localHashMap, null);
        }
        localSharedPreferences.edit().putLong("sp_item_memory_last_report_time", System.currentTimeMillis()).commit();
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("memory_reporter", 0);
    if (this.jdField_b_of_type_Boolean)
    {
      localSharedPreferences.edit().putString("sp_key_sharp_pss_" + this.jdField_c_of_type_Long, String.valueOf(this.jdField_a_of_type_Long)).commit();
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localSharedPreferences.edit().putString("sp_key_sharp_heap_" + this.jdField_c_of_type_Long, String.valueOf(this.jdField_b_of_type_Long)).commit();
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  public void a(MemoryReporter.IMemoryListener paramIMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramIMemoryListener);
      return;
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaUtilArrayList.add(paramString);
    SharedPreferences localSharedPreferences;
    if (this.jdField_a_of_type_Boolean)
    {
      localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("memory_reporter", 0);
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        break label125;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      localSharedPreferences.edit().putString("sp_key_leak_objs_" + this.jdField_c_of_type_Long + "_" + paramString, String.valueOf(this.jdField_a_of_type_JavaUtilHashMap.get(paramString))).commit();
      return;
      label125:
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
    }
  }
  
  public void b(MemoryReporter.IMemoryListener paramIMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramIMemoryListener);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\memory\MemoryReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */