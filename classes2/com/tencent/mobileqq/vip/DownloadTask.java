package com.tencent.mobileqq.vip;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadTask
{
  static final int E = 5;
  public static final int a = 1;
  public static final byte b = 1;
  public static final int b = 2;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = -1;
  public static final int g = -2;
  public static final int h = -100;
  public static final int i = -101;
  public static final int j = -102;
  public static final int k = -103;
  public static final int l = -104;
  public static final int m = -105;
  public static final int n = -106;
  public static final int o = -107;
  public static final int p = -108;
  public static final int q = -109;
  public static final int r = -110;
  public static final int s = -111;
  public static final int t = -112;
  public static final int u = -113;
  public static final int v = -114;
  public static final int w = -115;
  public static final int x = 1;
  public static final int y = 2;
  public int A;
  public int B;
  public int C;
  public int D;
  public byte a;
  public float a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public DownloadTask.ReportInfo a;
  Object jdField_a_of_type_JavaLangObject;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  public Map a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public boolean a;
  public long b;
  public String b;
  private Map jdField_b_of_type_JavaUtilMap;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public boolean b;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public long e;
  public String e;
  public boolean e;
  public long f;
  public String f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  public int z;
  
  public DownloadTask(String paramString, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.z = 0;
    this.A = 3;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.c = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = true;
    this.g = true;
    this.jdField_f_of_type_JavaLangString = "Vip";
    this.m = true;
    this.n = true;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo = new DownloadTask.ReportInfo();
    this.o = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramFile);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.C = 1;
  }
  
  public DownloadTask(List paramList, Map paramMap, String paramString)
  {
    this.z = 0;
    this.A = 3;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.c = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = true;
    this.g = true;
    this.jdField_f_of_type_JavaLangString = "Vip";
    this.m = true;
    this.n = true;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo = new DownloadTask.ReportInfo();
    this.o = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (paramMap == null) {
        break label163;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap = paramMap;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.C = 2;
      return;
      paramList = new ArrayList();
      break;
      label163:
      paramMap = new HashMap();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public Bundle a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public DownloadListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  }
  
  public Map a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    float f1 = 100.0F;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.B = paramInt;
    if (this.jdField_b_of_type_Long <= 0L) {
      f1 = 30.0F;
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = ((f1 + paramInt * 100) / this.jdField_a_of_type_JavaUtilList.size());
      return;
      if (this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)
      {
        if (paramInt + 1 == this.jdField_a_of_type_JavaUtilList.size())
        {
          a(3);
          this.jdField_a_of_type_Float = 100.0F;
        }
      }
      else {
        f1 = 100.0F * (float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = paramDownloadListener;
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask,task.key=" + paramDownloadTask.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 5) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadTask);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask, taskList.size() >= DUPLICATE_LIMIT,size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          this.jdField_b_of_type_JavaUtilMap = new HashMap();
        }
        this.jdField_b_of_type_JavaUtilMap.put(paramString1, paramString2);
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean a(byte paramByte)
  {
    return ((byte)(this.jdField_a_of_type_Byte | 0x0) & paramByte) == paramByte;
  }
  
  public int b()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("id");
    }
    return i1;
  }
  
  public void b()
  {
    if (a() != null) {
      a().onProgress(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onProgress(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Long = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void c()
  {
    if (a() != null) {
      a().onCancel(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onCancel(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if (a() != null) {
      bool = a().onStart(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label130;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onStart(localDownloadTask);
          }
        }
      }
      return bool;
      bool = true;
      continue;
      label130:
      i1 -= 1;
    }
  }
  
  public void d()
  {
    if (a() != null) {
      a().onPause(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onPause(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public void e()
  {
    if (a() != null) {
      a().onDoneFile(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onDoneFile(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof DownloadTask)) && (((DownloadTask)paramObject).jdField_a_of_type_JavaUtilList.equals(this.jdField_a_of_type_JavaUtilList));
  }
  
  public void f()
  {
    if (a() != null) {
      a().onDone(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onDone(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public void g()
  {
    if (a() != null) {
      a().onNetWifi2Mobile();
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label117;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onNetWifi2Mobile();
          }
        }
      }
      return;
      label117:
      i1 -= 1;
    }
  }
  
  public void h()
  {
    if (a() != null) {
      a().onNetWifi2None();
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label117;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onNetWifi2None();
          }
        }
      }
      return;
      label117:
      i1 -= 1;
    }
  }
  
  public void i()
  {
    if (a() != null) {
      a().onNetMobile2None();
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.o))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label117;
            }
            localDownloadTask.a(a());
            localDownloadTask.z = this.z;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onNetMobile2None();
          }
        }
      }
      return;
      label117:
      i1 -= 1;
    }
  }
  
  public void j()
  {
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label72;
        }
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (localDownloadTask == null) {
            break label75;
          }
          localDownloadTask.a(null);
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
      label72:
      return;
      label75:
      i1 -= 1;
    }
  }
  
  public String toString()
  {
    return " key=" + this.jdField_a_of_type_JavaLangString + ",urlList size=" + this.jdField_a_of_type_JavaUtilList.size() + "|currentUrlIndex=" + this.B + "|errCode=" + this.z + "|status=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + "|readSize=" + this.jdField_b_of_type_Long + "|maxSize=" + this.jdField_a_of_type_Long + "|percent=" + this.jdField_a_of_type_Float;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vip\DownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */