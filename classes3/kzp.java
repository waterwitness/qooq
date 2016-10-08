import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.FollowPublicAccountObserver;
import com.tencent.mobileqq.widget.QQToast;

class kzp
  extends TroopBindPubAccountProtocol.FollowPublicAccountObserver
{
  kzp(kzo paramkzo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.a.a.o();
    if (paramBoolean)
    {
      QQToast.a(this.a.a.a, 2131364751, 0).b(this.a.a.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.a.a, 2131364752, 0).b(this.a.a.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */