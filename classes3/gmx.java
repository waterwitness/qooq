import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class gmx
  extends IAVServiceForQQ.Stub
{
  IAVServiceCallback jdField_a_of_type_ComTencentAvServiceIAVServiceCallback;
  
  private gmx(AVServiceForQQ paramAVServiceForQQ)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceCallback = null;
  }
  
  public int a(long paramLong, int paramInt)
  {
    Object localObject;
    label72:
    int i;
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if ((localObject == null) || (!((VideoController)localObject).e) || (((VideoController)localObject).a().F != paramInt) || (((VideoController)localObject).a().e != paramLong)) {
        break label117;
      }
      localObject = ((VideoController)localObject).b().iterator();
      paramInt = 0;
      i = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break label120;
      }
      if (((VideoController.GAudioFriends)((Iterator)localObject).next()).c != 1) {
        break label123;
      }
      paramInt += 1;
    }
    label117:
    label120:
    label123:
    for (;;)
    {
      break label72;
      localObject = VideoController.a();
      break;
      i = 0;
      return i;
    }
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_JavaLangString, 2, "processQCallPush in AVServiceForQQ");
    }
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(); localVideoController != null; localVideoController = VideoController.a()) {
      return localVideoController.a(paramArrayOfByte);
    }
    return null;
  }
  
  public void a(MeetingInfo paramMeetingInfo)
  {
    if (paramMeetingInfo != null) {
      QQGAudioCtrl.getGAudioCtrlInstance().sendMeetingMessage(paramMeetingInfo);
    }
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceCallback = paramIAVServiceCallback;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.B(paramString);
      }
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.a(paramString, paramBitmap);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return;
    }
    if (paramBoolean)
    {
      if (paramNotification != null) {}
      for (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_AndroidAppNotification = paramNotification;; this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_AndroidAppNotification = new Notification())
      {
        this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.startForeground(2130839263, this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_AndroidAppNotification);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.stopForeground(true);
    this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_AndroidAppNotification = null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.b(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.c(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.e(paramArrayOfByte);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */