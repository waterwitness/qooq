import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class kty
  implements DialogInterface.OnClickListener
{
  public kty(ChatActivityUtils.StartVideoListener paramStartVideoListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramDialogInterface.dismiss();
    DataReport.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */