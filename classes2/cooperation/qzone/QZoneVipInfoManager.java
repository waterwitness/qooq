package cooperation.qzone;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import yld;

public class QZoneVipInfoManager
{
  private static QZoneVipInfoManager jdField_a_of_type_CooperationQzoneQZoneVipInfoManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  public static final String b = "QZONE_VIP_INFO";
  private static final String c = "key_vip_info_pre";
  private int jdField_a_of_type_Int = -1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private boolean jdField_a_of_type_Boolean;
  private String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QZoneVipInfoManager.class.getSimpleName();
  }
  
  private QZoneVipInfoManager()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("QZONE_VIP_INFO", i);
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.registerOnSharedPreferenceChangeListener(new yld(this));
      }
      return;
    }
  }
  
  public static int a(int paramInt)
  {
    return a(paramInt, 0, 1);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 0, 1);
      }
    }
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt3 - paramInt2 + 1)
    {
    default: 
      paramInt3 = 0;
    }
    while (paramInt3 == 0)
    {
      return 0;
      paramInt3 = 1;
      continue;
      paramInt3 = 3;
      continue;
      paramInt3 = 7;
      continue;
      paramInt3 = 15;
    }
    return paramInt1 >> paramInt2 & paramInt3;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1 << paramInt4 + 1 & paramInt1 | paramInt2 << paramInt3 | (1 << paramInt3) - 1 & paramInt1;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 6, 6);
    }
  }
  
  public static QZoneVipInfoManager a()
  {
    if (jdField_a_of_type_CooperationQzoneQZoneVipInfoManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneQZoneVipInfoManager == null) {
        jdField_a_of_type_CooperationQzoneQZoneVipInfoManager = new QZoneVipInfoManager();
      }
      return jdField_a_of_type_CooperationQzoneQZoneVipInfoManager;
    }
  }
  
  private String a(String paramString)
  {
    return "key_vip_info_bitmap_pre" + paramString;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int >= 0) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(a(localAppRuntime.getAccount()), 0);
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(b(localAppRuntime.getAccount()), null);
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, 6, 6) != 0;
  }
  
  public static int b(int paramInt)
  {
    return a(paramInt, 2, 5);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = a(paramInt1, paramInt2, 2, 5);
      }
    }
    return i;
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 13, 13);
    }
  }
  
  private String b(String paramString)
  {
    return "key_vip_info_personalized_vip_pre" + paramString;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      if (localEditor != null)
      {
        this.jdField_a_of_type_Boolean = true;
        AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
        localEditor.putInt(a(localAppRuntime.getAccount()), this.jdField_a_of_type_Int);
        localEditor.putString(b(localAppRuntime.getAccount()), this.d);
        localEditor.commit();
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt, 13, 13) != 0;
  }
  
  public static int c(int paramInt)
  {
    return a(paramInt, 7, 8);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 7, 8);
      }
    }
    return i;
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 21, 21);
    }
  }
  
  public static boolean c(int paramInt)
  {
    return a(paramInt, 21, 21) != 0;
  }
  
  public static int d(int paramInt)
  {
    return a(paramInt, 9, 12);
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = a(paramInt1, paramInt2, 9, 12);
      }
    }
    return i;
  }
  
  public static int d(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 22, 22);
    }
  }
  
  public static boolean d(int paramInt)
  {
    return a(paramInt, 22, 22) != 0;
  }
  
  public static int e(int paramInt)
  {
    return a(paramInt, 14, 16);
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 6) {
        i = a(paramInt1, paramInt2, 14, 16);
      }
    }
    return i;
  }
  
  public static int e(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 23, 23);
    }
  }
  
  public static boolean e(int paramInt)
  {
    return a(paramInt, 23, 23) != 0;
  }
  
  public static int f(int paramInt)
  {
    return a(paramInt, 17, 20);
  }
  
  public static int f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = a(paramInt1, paramInt2, 17, 20);
      }
    }
    return i;
  }
  
  public int a()
  {
    a();
    return a(this.jdField_a_of_type_Int);
  }
  
  public String a()
  {
    a();
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info, String paramString)
  {
    boolean bool2 = true;
    a();
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int, paramInt1);
    this.jdField_a_of_type_Int = b(this.jdField_a_of_type_Int, paramInt2);
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt3 != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Int = a(paramInt1, bool1);
      if (paramstar_info != null)
      {
        this.jdField_a_of_type_Int = c(this.jdField_a_of_type_Int, paramstar_info.iStarStatus);
        this.jdField_a_of_type_Int = d(this.jdField_a_of_type_Int, paramstar_info.iStarLevel);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramstar_info.isAnnualVip == 0) {
          break label307;
        }
        bool1 = true;
        label106:
        this.jdField_a_of_type_Int = b(paramInt1, bool1);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramstar_info.isHighStarVip == 0) {
          break label313;
        }
        bool1 = true;
        label132:
        this.jdField_a_of_type_Int = e(paramInt1, bool1);
      }
      if (paramcombine_diamond_info != null)
      {
        this.jdField_a_of_type_Int = e(this.jdField_a_of_type_Int, paramcombine_diamond_info.iShowType);
        this.jdField_a_of_type_Int = f(this.jdField_a_of_type_Int, paramcombine_diamond_info.iVipLevel);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramcombine_diamond_info.isAnnualVip == 0) {
          break label319;
        }
        bool1 = true;
        label195:
        this.jdField_a_of_type_Int = c(paramInt1, bool1);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramcombine_diamond_info.isAnnualVipEver == 0) {
          break label325;
        }
      }
    }
    label307:
    label313:
    label319:
    label325:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Int = d(paramInt1, bool1);
      this.d = paramString;
      paramstar_info = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
      paramcombine_diamond_info = new Bundle();
      paramcombine_diamond_info.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.jdField_a_of_type_Int);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.d);
      paramstar_info.putExtras(paramcombine_diamond_info);
      BaseApplicationImpl.getContext().sendBroadcast(paramstar_info);
      b();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label106;
      bool1 = false;
      break label132;
      bool1 = false;
      break label195;
    }
  }
  
  public boolean a()
  {
    a();
    return a(this.jdField_a_of_type_Int);
  }
  
  public int b()
  {
    a();
    return b(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneVipInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */