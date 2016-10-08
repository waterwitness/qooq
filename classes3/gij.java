import com.tencent.av.VideoController;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavPanel.SlideAcceptListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gij
  implements QavPanel.SlideAcceptListener
{
  public gij(GaInviteLockActivity paramGaInviteLockActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!this.a.a.e) && (!this.a.a.n())) {
        break label72;
      }
      this.a.g();
    }
    while (this.a.e)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005548", "0X8005548", 0, 0, "", "", "", "");
      return;
      label72:
      this.a.b();
    }
    ReportController.b(null, "CliOper", "", "", "0X800420E", "0X800420E", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */