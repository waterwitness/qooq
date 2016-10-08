import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class lxq
  extends CardObserver
{
  public lxq(NotifyPCActiveActivity paramNotifyPCActiveActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a.app.a(), paramString2, null, "qqsetting_pcactive_key", true);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */