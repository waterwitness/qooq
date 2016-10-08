import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

class ntm
  implements Runnable
{
  ntm(ntl paramntl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.dismiss();
    this.a.a.a.removeAllViews();
    this.a.a.c = false;
    this.a.a.c(2131370096);
    ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
    this.a.a.show();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */