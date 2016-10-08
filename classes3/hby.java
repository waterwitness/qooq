import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;
import mqq.util.WeakReference;

public class hby
  implements TraeAudioSession.ITraeAudioCallback
{
  public hby(TraeHelper paramTraeHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt;
    Context localContext = null;
    if (this.a.jdField_a_of_type_MqqUtilWeakReference != null) {
      localContext = (Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) || ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().z) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 4) && ((localContext == null) || (NetworkUtil.a(localContext)))) || (this.a.jdField_a_of_type_ComTencentAvVideoController.o()) || (this.a.jdField_a_of_type_ComTencentAvVideoController.n()) || (this.a.b)) {}
    for (boolean bool = true;; bool = false)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().H, true, bool);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return;
    }
    this.a.jdField_a_of_type_Int = paramInt2;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt2;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeviceListUpdate onConnectDeviceRes: " + paramString + ", bIsConnected:" + paramBoolean + ",err:" + paramInt);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().r = paramString;
      this.a.a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = paramArrayOfString;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().r = paramString1;
      this.a.a();
      if (paramArrayOfString != null)
      {
        paramInt = 0;
        while (paramInt < paramArrayOfString.length)
        {
          if (paramArrayOfString[paramInt].equals("DEVICE_WIREDHEADSET")) {
            DataReport.o(this.a.jdField_a_of_type_ComTencentAvVideoController);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "ConnectDeviceWhenServiceOn deviceName = " + this.a.c);
      }
      this.a.b(this.a.c);
    }
  }
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeviceListUpdate strConnectedDeviceName: " + paramString1 + ", strPrevConnectedDeviceName:" + paramString2);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().r = paramString1;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = paramArrayOfString;
    this.a.a();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
          DataReport.o(this.a.jdField_a_of_type_ComTencentAvVideoController);
        }
        i += 1;
      }
    }
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().w.equals("DEVICE_NONE"))
    {
      if (!paramString1.equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().w)) {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a().w);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().w = "DEVICE_NONE";
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    int i;
    do
    {
      return;
      i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().f;
    } while (((i == 1) || (i == 2)) && ((!this.a.jdField_a_of_type_ComTencentAvVideoController.b()) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (this.a.jdField_a_of_type_AndroidWidgetButton == null) || (paramBoolean == this.a.jdField_a_of_type_AndroidWidgetButton.isClickable())));
    this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(paramBoolean);
  }
  
  public void c(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null)
    {
      paramString = this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
      paramString.onCompletion(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */