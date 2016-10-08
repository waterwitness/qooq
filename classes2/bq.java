import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class bq
  implements DialogInterface.OnClickListener
{
  public bq(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */