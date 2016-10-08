import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gkk
  implements DialogInterface.OnClickListener
{
  public gkk(RandomController paramRandomController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.k == 2) {
      ReportController.b(null, "CliOper", "", "", "0X8005729", "0X8005729", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.c();
      return;
      if (this.a.k == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005727", "0X8005727", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */