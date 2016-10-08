import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class kzo
  implements DialogInterface.OnClickListener
{
  kzo(kzn paramkzn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.a(this.a.a) == 0)
    {
      QQToast.a(this.a.a, 2131364197, 0).b(this.a.a.getTitleBarHeight());
      return;
    }
    TroopBindPubAccountProtocol.a(this.a.a.app, this.a.a.a.associatePubAccount, new kzp(this), null);
    this.a.a.n();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */