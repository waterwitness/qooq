package com.tencent.mobileqq.precover;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PrecoverControl
{
  public static final int a = 6;
  public static final int b = 0;
  public static final int c = 3;
  public static final int d = 1000;
  public static final int e = 3600;
  public static final int f = 1;
  public static final int g = 5;
  public String a;
  public boolean a;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  
  public PrecoverControl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.h = 0;
    this.i = 3;
    this.j = 1000;
    this.k = 3600;
    this.l = 1;
    this.m = 5;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int n;
    try
    {
      n = Integer.parseInt(paramString);
      if (n < 0) {
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      return paramInt;
    }
    return n;
  }
  
  public static PrecoverControl a()
  {
    PrecoverControl localPrecoverControl3 = new PrecoverControl();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localPrecoverControl3.jdField_a_of_type_JavaLangString = str;
    localPrecoverControl3.jdField_a_of_type_Boolean = true;
    PrecoverControl localPrecoverControl1 = localPrecoverControl3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localPrecoverControl1 = localPrecoverControl3;
        if (arrayOfString.length >= 6)
        {
          localPrecoverControl3.jdField_a_of_type_Boolean = false;
          localPrecoverControl3.h = a(arrayOfString[0], 0);
          localPrecoverControl3.i = a(arrayOfString[1], 3);
          localPrecoverControl3.j = a(arrayOfString[2], 1000);
          localPrecoverControl3.k = a(arrayOfString[3], 3600);
          localPrecoverControl3.l = a(arrayOfString[4], 1);
          localPrecoverControl3.m = a(arrayOfString[5], 5);
          if ((localPrecoverControl3.h != 0) && (localPrecoverControl3.h != 1) && (localPrecoverControl3.h != 2)) {
            localPrecoverControl3.h = 0;
          }
          localPrecoverControl1 = localPrecoverControl3;
          if (localPrecoverControl3.l != 0)
          {
            localPrecoverControl1 = localPrecoverControl3;
            if (localPrecoverControl3.l != 1)
            {
              localPrecoverControl3.l = 1;
              localPrecoverControl1 = localPrecoverControl3;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("PrecoverControl", 1, "create Exception:" + localException.toString());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        PrecoverControl localPrecoverControl2 = new PrecoverControl();
        localPrecoverControl2.jdField_a_of_type_JavaLangString = str;
        localPrecoverControl2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localPrecoverControl1);
    }
    return localPrecoverControl1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.h).append(", itemRetry=").append(this.i).append(", totalRetry=").append(this.j).append(", lbsExpire=").append(this.k).append(", open=").append(this.l);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */