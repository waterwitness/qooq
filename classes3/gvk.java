import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class gvk
  implements QavInOutAnimation.QavOutAnimationListener
{
  public gvk(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion)
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
    MultiVideoCtrlLayerUI4Discussion.a(this.a);
    this.a.i(true);
    if (this.a.a.e)
    {
      this.a.a.a(this.a.a.E, this.a.a.a, 0, new int[0]);
      ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
      if (((this.a.e != 90) && (this.a.e != 270)) || (this.a.a.a().a() == -1) || (((VideoViewInfo)this.a.a.a().c.get(0)).a != 1)) {
        break label219;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.p = false;
      return;
      this.a.a.a(this.a.d, this.a.b, 0, new int[0]);
      break;
      label219:
      if (((this.a.e == 90) || (this.a.e == 270)) && (this.a.a.a().a() != -1) && (((VideoViewInfo)this.a.a.a().c.get(0)).a == 2)) {
        ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */