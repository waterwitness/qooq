import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.FollowPublicAccountObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class mxb
  extends TroopBindPubAccountProtocol.FollowPublicAccountObserver
{
  public mxb(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        new structmsg.StructMsg().mergeFrom(paramBundle);
        TroopRequestActivity.a(this.a, 1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.TroopRequestActivity", 2, "structMsg merge error");
        }
        this.a.i();
        QQToast.a(this.a, this.a.getString(2131364752), 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    this.a.i();
    QQToast.a(this.a, this.a.getString(2131364752), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */