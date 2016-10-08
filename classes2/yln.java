import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper.StartActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.os.MqqHandler;

public final class yln
  implements QZoneHelper.StartActivity
{
  public yln(Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, int paramInt, Activity paramActivity, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivity.a(this.jdField_a_of_type_AndroidContentIntent);
    Class localClass = ylq.a(str);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("click_time", System.currentTimeMillis());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
    localPluginParams.d = "QZone";
    localPluginParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
    localPluginParams.e = str;
    localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidContentIntent;
    localPluginParams.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localPluginParams.c = 15000;
    localPluginParams.f = null;
    localPluginParams.jdField_a_of_type_Boolean = false;
    ThreadManager.c().post(new ylo(this, paramBoolean1, paramBoolean2, localPluginParams));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */