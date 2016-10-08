package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;

public class TroopVideoManager
  implements Manager
{
  public static final int a = 0;
  public static final String a = "TroopVideoNotify";
  public static final int b = 1;
  public static final int c = 2;
  protected Handler a;
  QQAppInterface a;
  public HashMap a;
  
  public TroopVideoManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    b();
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 1) {
        ((StringBuilder)localObject).append(str).append(";");
      }
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1).toString();
      SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "TroopVideoNotify", (String)localObject);
      return;
    }
    SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "TroopVideoNotify", "");
  }
  
  public void a(long paramLong)
  {
    int j = 0;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramLong));
    if (localInteger != null) {}
    for (int i = localInteger.intValue();; i = 0)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramLong);
      if ((bool) && (i == 0)) {
        j = 1;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(paramLong), Integer.valueOf(j));
        if (j != i) {
          a();
        }
        return;
        if (bool) {
          j = i;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (a(paramString) == 1)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
      a();
    }
  }
  
  public void b()
  {
    Object localObject = SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "TroopVideoNotify");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject[i], Integer.valueOf(1));
          i += 1;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopVideoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */