import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

class gqj
  implements DialogInterface.OnClickListener
{
  gqj(gqi paramgqi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(CallbackWaitingActivity.a(this.a.a).a().getPackageName());
    paramDialogInterface.setAction("tencent.av.v2q.CancelCallBack");
    paramDialogInterface.putExtra("fromPhone", this.a.a.d);
    paramDialogInterface.putExtra("toPhone", this.a.a.c);
    paramDialogInterface.putExtra("fromUin", this.a.a.f);
    paramDialogInterface.putExtra("uinType", this.a.a.jdField_b_of_type_Int);
    paramDialogInterface.putExtra("toUin", this.a.a.f);
    paramDialogInterface.putExtra("callBackId", this.a.a.jdField_b_of_type_JavaLangString);
    CallbackWaitingActivity.a(this.a.a).a().sendBroadcast(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */