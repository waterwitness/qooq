import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gwn
  implements Runnable
{
  public gwn(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.f();
      this.a.X();
      if (this.a.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */