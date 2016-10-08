package cooperation.comic;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PluginPreloadStrategy$PreloadServerParam
{
  public static final int a = -1;
  public static final String a = "preload_switch";
  public static final String b = "preload";
  public static final String c = "preload_data";
  public static final String d = "mem_limit";
  public static final String e = "ext1";
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public String f;
  
  public PluginPreloadStrategy$PreloadServerParam(int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("ppp_profile", 4);
    this.jdField_b_of_type_Int = localSharedPreferences.getInt(paramInt + "preload_switch" + paramString, -1);
    this.a = localSharedPreferences.getBoolean(paramInt + "preload" + paramString, false);
    this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean(paramInt + "preload_data" + paramString, false);
    this.c = localSharedPreferences.getInt(paramInt + "mem_limit" + paramString, 256);
    this.f = localSharedPreferences.getString(paramInt + "ext1" + paramString, "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginPreloadStrategy$PreloadServerParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */