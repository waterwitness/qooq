import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

class gqu
  implements DialogInterface.OnClickListener
{
  gqu(gqt paramgqt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(CallbackWaitingActivityExt.a(this.a.a.a).a().getPackageName());
    paramDialogInterface.setAction("tencent.av.v2q.CancelCallBack");
    paramDialogInterface.putExtra("fromPhone", this.a.a.a.f);
    paramDialogInterface.putExtra("toPhone", this.a.a.a.e);
    paramDialogInterface.putExtra("fromUin", this.a.a.a.h);
    paramDialogInterface.putExtra("uinType", this.a.a.a.b);
    paramDialogInterface.putExtra("toUin", this.a.a.a.h);
    paramDialogInterface.putExtra("callBackId", this.a.a.a.d);
    CallbackWaitingActivityExt.a(this.a.a.a).a().sendBroadcast(paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */