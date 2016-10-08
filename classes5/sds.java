import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;

class sds
  implements DialogInterface.OnClickListener
{
  sds(sdp paramsdp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.a().a("0X8004857", 1);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */