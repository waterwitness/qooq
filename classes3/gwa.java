import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gwa
  implements DialogInterface.OnClickListener
{
  public gwa(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.a().a() == -1) {
      this.a.S();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.a.a != null) {
        if (this.a.a()) {
          this.a.Q();
        } else if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUIBase", 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */