import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lgc
  implements DialogInterface.OnClickListener
{
  lgc(lgb paramlgb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.a.a != null) && (this.a.a.a.isShowing()) && (this.a.a.a.getWindow() != null)) {
      this.a.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */