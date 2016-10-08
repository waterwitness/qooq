package cooperation.huangye;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class HYSharedPref
{
  private static volatile HYSharedPref jdField_a_of_type_CooperationHuangyeHYSharedPref;
  public static final String a = "FileConfigure";
  private static final String b = "HuangyeAppName";
  private static final String c = "huangye_configure.";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  private HYSharedPref()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("HuangyeAppName", 4);
  }
  
  public static HYSharedPref a()
  {
    if (jdField_a_of_type_CooperationHuangyeHYSharedPref == null) {}
    try
    {
      if (jdField_a_of_type_CooperationHuangyeHYSharedPref == null) {
        jdField_a_of_type_CooperationHuangyeHYSharedPref = new HYSharedPref();
      }
      return jdField_a_of_type_CooperationHuangyeHYSharedPref;
    }
    finally {}
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("huangye_configure." + paramString, paramInt);
  }
  
  public long a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("huangye_configure." + paramString, paramLong);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("huangye_configure." + paramString1, paramString2);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("huangye_configure." + paramString, paramInt).commit();
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("huangye_configure." + paramString, paramLong).commit();
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("huangye_configure." + paramString1, paramString2).commit();
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("huangye_configure." + paramString, paramBoolean);
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("huangye_configure." + paramString, paramBoolean).commit();
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYSharedPref.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */