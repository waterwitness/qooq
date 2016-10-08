import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pix
  extends MessageObserver
{
  public pix(SendVideoActivity paramSendVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "messageObserver,  onUpdateMsgContent, isSuc:" + paramBoolean);
    }
    if ((SendVideoActivity.a() == null) || (!paramBoolean)) {
      this.a.setResult(-2);
    }
    for (;;)
    {
      this.a.finish();
      return;
      ((BlessManager)this.a.getAppInterface().getManager(137)).a(SendVideoActivity.a());
      this.a.setResult(-1, this.a.getIntent());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */