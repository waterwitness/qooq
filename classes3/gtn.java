import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gtn
  extends BroadcastReceiver
{
  public gtn(EffectToolbar paramEffectToolbar, VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    while ((!"tencent.video.q2v.config".equals(paramIntent.getAction())) || (!paramIntent.getBooleanExtra("ptv_extra_config_changed", false))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "双人挂件配置更新");
    }
    EffectToolbar.a(this.jdField_a_of_type_ComTencentAvUiEffectToolbar, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */