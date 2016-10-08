import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class gvu
  implements QavInOutAnimation.QavOutAnimationListener
{
  public gvu(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.p = true;
    this.a.ak();
  }
  
  public void b()
  {
    ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
    if (((this.a.e == 90) || (this.a.e == 270)) && (this.a.a.a().a() != -1) && (((VideoViewInfo)this.a.a.a().c.get(0)).a == 1))
    {
      ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.a);
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.a, true);
      if (!this.a.a.e) {
        break label300;
      }
      this.a.a.a(this.a.a.E, this.a.a.a, 0, new int[] { this.a.a.a().D });
    }
    for (;;)
    {
      this.a.p = false;
      return;
      if (((this.a.e != 90) && (this.a.e != 270)) || (this.a.a.a().a() == -1) || (((VideoViewInfo)this.a.a.a().c.get(0)).a != 2)) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
      break;
      label300:
      this.a.a.a(this.a.d, this.a.b, 0, new int[] { this.a.a.a().D });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */