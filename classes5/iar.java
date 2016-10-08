import android.telephony.PhoneStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iar
  extends PhoneStateListener
{
  public iar(VideoVolumeControl paramVideoVolumeControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.a.b(true);
      return;
    }
    this.a.b(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */