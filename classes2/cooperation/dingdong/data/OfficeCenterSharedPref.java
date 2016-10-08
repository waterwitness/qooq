package cooperation.dingdong.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class OfficeCenterSharedPref
{
  private static volatile OfficeCenterSharedPref jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref;
  private static final String jdField_a_of_type_JavaLangString = "OfficeCenterAppName";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  private OfficeCenterSharedPref()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("OfficeCenterAppName", 4);
  }
  
  public static OfficeCenterSharedPref a()
  {
    if (jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref == null) {}
    try
    {
      if (jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref == null) {
        jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref = new OfficeCenterSharedPref();
      }
      return jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref;
    }
    finally {}
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, paramInt);
  }
  
  public long a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, paramLong);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, paramInt).commit();
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
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, paramLong).commit();
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
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).commit();
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
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\data\OfficeCenterSharedPref.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */