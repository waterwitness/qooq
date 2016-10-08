package com.tencent.biz.pubaccount.util;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineUpdateStatus
  implements AsyncBack
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public String a;
  private ArrayList a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String f;
  private int g;
  private int h;
  
  public OfflineUpdateStatus(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(LoadedBack2 paramLoadedBack2)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramLoadedBack2)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLoadedBack2);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a(paramString, paramInt);
    }
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(LoadedBack2 paramLoadedBack2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramLoadedBack2);
  }
  
  public int c()
  {
    return this.h;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\OfflineUpdateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */