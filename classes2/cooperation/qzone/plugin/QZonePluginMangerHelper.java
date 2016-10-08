package cooperation.qzone.plugin;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import ynu;
import ynx;
import yoj;

public class QZonePluginMangerHelper
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new yoj();
  private static final String jdField_a_of_type_JavaLangString = "patch";
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public static ynx a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, QZonePluginMangerHelper.OnQzonePluginClientReadyListner paramOnQzonePluginClientReadyListner)
  {
    if ((jdField_a_of_type_Ynx != null) && (jdField_a_of_type_Ynx.b()))
    {
      if (paramOnQzonePluginClientReadyListner != null) {
        paramOnQzonePluginClientReadyListner.a(jdField_a_of_type_Ynx);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnQzonePluginClientReadyListner);
    ynu.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      jdField_a_of_type_JavaLangRefWeakReference.clear();
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePluginMangerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */