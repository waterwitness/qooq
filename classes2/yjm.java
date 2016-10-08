import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public final class yjm
  implements Runnable
{
  public yjm(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PreloadProcHitPluginSession localPreloadProcHitPluginSession = new PreloadProcHitPluginSession(this.a, "com.tencent.mobileqq:tool", "qwallet_plugin.apk");
    Intent localIntent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qwallet_plugin.apk";
    localPluginParams.d = "Wallet";
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = localPreloadProcHitPluginSession;
    localPluginParams.e = "com.qwallet.receiver.QWallPreloadReceiver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(BaseApplicationImpl.getContext(), localPluginParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */