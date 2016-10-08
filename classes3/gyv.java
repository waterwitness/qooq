import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class gyv
  implements DialogInterface.OnClickListener
{
  public gyv(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.t) {
      ReportController.b(null, "CliOper", "", "", this.a.z, this.a.z, 0, 0, "", "", this.a.A, "");
    }
    if ((this.a.G == 2) || (this.a.G == 1))
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
      long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
      if (paramInt != -1) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.remove(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */