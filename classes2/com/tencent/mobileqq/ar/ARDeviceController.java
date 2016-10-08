package com.tencent.mobileqq.ar;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.hiar.sdk.core.NativeInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import qol;

public class ARDeviceController
{
  public static final int a = 1;
  private static ARDeviceController jdField_a_of_type_ComTencentMobileqqArARDeviceController = new ARDeviceController();
  private static final String jdField_a_of_type_JavaLangString = "gpu_renderer";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "ar_incompatible_reason";
  private static final int jdField_c_of_type_Int = 870881;
  private static final String jdField_c_of_type_JavaLangString = "ar_adjust_track_quality";
  private static final int jdField_d_of_type_Int = 870882;
  private static final String jdField_d_of_type_JavaLangString = "ar_adjust_render_quality";
  private static final int jdField_e_of_type_Int = 870883;
  private static final String jdField_e_of_type_JavaLangString = "ar_load_so_crash_time";
  private static final int jdField_f_of_type_Int = 870884;
  private static final String jdField_f_of_type_JavaLangString = "ar_load_so_crash_version";
  private static final int jdField_g_of_type_Int = 870885;
  private static final String jdField_g_of_type_JavaLangString = "ar_native_so_crash_version";
  private static final int jdField_h_of_type_Int = 870886;
  private static final int jdField_i_of_type_Int = 870887;
  private static final int j = 870888;
  private static final int k = 5;
  private static final int l = 1;
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString = a(Build.MODEL);
  private boolean jdField_h_of_type_Boolean;
  private String jdField_i_of_type_JavaLangString;
  private int m = 5;
  private int n = 1;
  private int o;
  private int p;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ARDeviceController()
  {
    this.b = true;
    this.c = true;
    this.e = true;
    this.f = true;
    Object localObject1 = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0);
    this.i = ((SharedPreferences)localObject1).getString("gpu_renderer", null);
    if (!TextUtils.isEmpty(this.i)) {
      this.i = a(this.i);
    }
    this.o = ((SharedPreferences)localObject1).getInt("ar_incompatible_reason", 0);
    this.p = ((SharedPreferences)localObject1).getInt("ar_load_so_crash_time", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("ar_load_so_crash_version", "");
    if (!AppSetting.d().equals(localObject2))
    {
      localObject2 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject2).putInt("ar_load_so_crash_time", 0);
      SharedPreUtils.a((SharedPreferences.Editor)localObject2);
      this.p = 0;
    }
    int i1 = ((SharedPreferences)localObject1).getInt("ar_native_so_crash_version", 0);
    if (((SharedPreferences)localObject1).getInt("ar_native_so_version", 0) != i1)
    {
      ((SharedPreferences)localObject1).edit().putInt("ar_load_so_crash_time", 0).commit();
      this.p = 0;
    }
    try
    {
      localObject1 = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getDeviceConfigurationInfo();
      if (localObject1 == null) {
        break label246;
      }
      if (((ConfigurationInfo)localObject1).reqGlEsVersion < 131072) {
        break label289;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      try
      {
        if ((!"000000000000000".equalsIgnoreCase(((TelephonyManager)BaseApplicationImpl.a().getSystemService("phone")).getDeviceId())) || (!Build.FINGERPRINT.startsWith("generic"))) {
          break label303;
        }
        for (boolean bool = true;; bool = false)
        {
          this.g = bool;
          return;
          bool = false;
          break;
          localException = localException;
          localException.printStackTrace();
          break label246;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    this.jdField_h_of_type_Boolean = bool;
  }
  
  public static ARDeviceController a()
  {
    return jdField_a_of_type_ComTencentMobileqqArARDeviceController;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramString.length())
    {
      char c1 = paramString.charAt(i1);
      if (((c1 >= '0') && (c1 <= '9')) || ((c1 >= 'a') && (c1 <= 'z'))) {
        localStringBuilder.append(c1);
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0);
    int i1;
    int i3;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null)
    {
      this.m = -1;
      this.n = -1;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.a.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (a((String)localIterator.next()).equals(this.jdField_h_of_type_JavaLangString))
          {
            this.m = 5;
            this.n = 1;
            i1 = 1;
            int i2 = i1;
            if (i1 == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_c_of_type_JavaUtilArrayList.iterator();
              do
              {
                i3 = i1;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!a((String)localIterator.next()).equals(this.jdField_h_of_type_JavaLangString));
              this.jdField_a_of_type_Boolean = true;
              i3 = 1;
              i2 = i3;
              if (i3 == 0)
              {
                this.jdField_a_of_type_Boolean = false;
                i2 = i3;
              }
            }
            i3 = i2;
            ArDefaultSetting localArDefaultSetting;
            if (i2 == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_e_of_type_JavaUtilArrayList.iterator();
              do
              {
                i3 = i2;
                if (!localIterator.hasNext()) {
                  break;
                }
                localArDefaultSetting = (ArDefaultSetting)localIterator.next();
              } while ((localArDefaultSetting.jdField_c_of_type_Int != 0) || (!a(localArDefaultSetting.a).equals(this.jdField_h_of_type_JavaLangString)));
              this.m = localArDefaultSetting.jdField_e_of_type_Int;
              this.n = localArDefaultSetting.d;
              i3 = 1;
            }
            i1 = i3;
            if (i3 == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_b_of_type_JavaUtilArrayList.iterator();
              do
              {
                i1 = i3;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!a((String)localIterator.next()).equals(this.i));
              this.m = 5;
              this.n = 1;
              i1 = 1;
            }
            i3 = i1;
            if (i1 == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.d.iterator();
              do
              {
                i2 = i1;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!a((String)localIterator.next()).equals(this.i));
              this.jdField_a_of_type_Boolean = true;
              i2 = 1;
              i3 = i2;
              if (i2 == 0)
              {
                this.jdField_a_of_type_Boolean = false;
                i3 = i2;
              }
            }
            if (i3 == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_e_of_type_JavaUtilArrayList.iterator();
              while (localIterator.hasNext())
              {
                localArDefaultSetting = (ArDefaultSetting)localIterator.next();
                if ((localArDefaultSetting.jdField_c_of_type_Int == 1) && (a(localArDefaultSetting.a).equals(this.i)))
                {
                  this.m = localArDefaultSetting.jdField_e_of_type_Int;
                  this.n = localArDefaultSetting.d;
                  i1 = 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (this.m >= 1) && (this.m <= 5) && (this.n >= 0) && (this.n <= 1))
      {
        this.b = false;
        this.c = false;
        this.d = true;
        return;
      }
      this.m = localSharedPreferences.getInt("ar_adjust_track_quality", -1);
      if ((this.m >= 1) && (this.m <= 5))
      {
        this.b = false;
        this.n = localSharedPreferences.getInt("ar_adjust_render_quality", -1);
        if ((this.n < 0) || (this.n > 1)) {
          break label615;
        }
      }
      for (this.c = false;; this.c = true)
      {
        this.d = true;
        return;
        this.b = true;
        this.m = 5;
        break;
        label615:
        this.n = 1;
      }
      i1 = i3;
      continue;
      i1 = 0;
      break;
      i1 = 0;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if ((this.e) || (this.o != paramInt))
    {
      this.e = false;
      ThreadManager.a(new qol(this, paramInt, paramBoolean), 5, null, true);
    }
    this.o = paramInt;
  }
  
  private void b()
  {
    if (!this.d) {
      throw new IllegalStateException("ARDeviceController is not inited. arEffectConfig=" + this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig + ", gpu=" + this.i);
    }
  }
  
  public int a()
  {
    b();
    return this.m;
  }
  
  public int a(int paramInt)
  {
    b();
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.h;
    case 2: 
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_e_of_type_Int;
    case 3: 
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.f;
    case 4: 
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.g;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.h;
  }
  
  public String a()
  {
    return this.i;
  }
  
  public void a(int paramInt)
  {
    b();
    this.m = paramInt;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putInt("ar_adjust_track_quality", paramInt);
    SharedPreUtils.a(localEditor);
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = paramArEffectConfig;
    if (!TextUtils.isEmpty(this.i)) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(this.i)) {}
    do
    {
      return;
      this.i = a(paramString);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).edit();
      localEditor.putString("gpu_renderer", paramString);
      SharedPreUtils.a(localEditor);
      a(paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null);
    a();
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    for (;;)
    {
      int i2;
      try
      {
        if (this.p >= 3)
        {
          a(false, 870888);
          return bool2;
        }
        if (!this.f) {
          break label281;
        }
        this.f = false;
        this.p += 1;
        Object localObject1 = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        localEditor.putInt("ar_load_so_crash_time", this.p);
        localEditor.putString("ar_load_so_crash_version", AppSetting.d());
        localEditor.putInt("ar_native_so_crash_version", ((SharedPreferences)localObject1).getInt("ar_native_so_version", 0));
        SharedPreUtils.a(localEditor);
        i2 = 1;
        if (this.jdField_a_of_type_Boolean)
        {
          i1 = 870882;
          a(bool1, i1);
          bool2 = bool1;
          if (i2 == 0) {
            continue;
          }
          localObject1 = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).edit();
          ((SharedPreferences.Editor)localObject1).putInt("ar_load_so_crash_time", 0);
          SharedPreUtils.a((SharedPreferences.Editor)localObject1);
          this.p = 0;
          bool2 = bool1;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 14) {
          break label203;
        }
      }
      finally {}
      int i1 = 870881;
      continue;
      label203:
      if (!this.jdField_h_of_type_Boolean)
      {
        i1 = 870883;
      }
      else if (this.g)
      {
        i1 = 870887;
      }
      else if (VcSystemInfo.f() < 3)
      {
        i1 = 870884;
      }
      else if ((NativeInterface.loadNativeLibrary()) && (ARNativeBridge.loadNativeLibrary()))
      {
        bool2 = OlympicUtil.a();
        if (!bool2)
        {
          i1 = 870886;
        }
        else
        {
          bool1 = true;
          i1 = 0;
          continue;
          label281:
          i2 = 0;
        }
      }
      else
      {
        i1 = 870885;
      }
    }
  }
  
  public int b()
  {
    b();
    return this.n;
  }
  
  public int b(int paramInt)
  {
    b();
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_b_of_type_Int;
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.jdField_c_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    b();
    this.n = paramInt;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putInt("ar_adjust_render_quality", paramInt);
    SharedPreUtils.a(localEditor);
  }
  
  public boolean b()
  {
    boolean bool = false;
    int i1;
    if (this.p >= 3) {
      i1 = 870888;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARDeviceController", 2, "enable= " + bool + ",errorCode= " + i1);
      }
      return bool;
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = 870882;
      }
      else if (Build.VERSION.SDK_INT < 14)
      {
        i1 = 870881;
      }
      else if (!this.jdField_h_of_type_Boolean)
      {
        i1 = 870883;
      }
      else if (this.g)
      {
        i1 = 870887;
      }
      else if (VcSystemInfo.f() < 3)
      {
        i1 = 870884;
      }
      else if (!OlympicUtil.a())
      {
        i1 = 870886;
      }
      else
      {
        i1 = 0;
        bool = true;
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (this.i != null);
  }
  
  public boolean d()
  {
    b();
    return this.b;
  }
  
  public boolean e()
  {
    b();
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARDeviceController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */