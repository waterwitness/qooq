package cooperation.secmsg;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;
import ysr;

public class SecMessagerService
  extends AppService
  implements ISecIPCConstants, SecSnapChatPicUploader.OnSnapChatUploadListener
{
  private static final String k = "SecMessagerService";
  public Messenger a;
  public SecSnapChatPicUploader a;
  private Messenger b;
  
  public SecMessagerService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new Messenger(new ysr(this));
  }
  
  private void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidOsMessenger != null) && (paramMessage != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramMessage);
      return;
    }
    catch (RemoteException paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  public void a(SecSnapChatPicUploader.PicUploadInfo paramPicUploadInfo)
  {
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_secmsg_id", paramPicUploadInfo.jdField_a_of_type_Long);
    localBundle.putString("key_secgroup_id", paramPicUploadInfo.jdField_b_of_type_JavaLangString);
    localBundle.putInt("key_secmsg_upload_state", paramPicUploadInfo.jdField_a_of_type_Int);
    localBundle.putInt("key_secmsg_upload_progress", paramPicUploadInfo.jdField_b_of_type_Int);
    if (paramPicUploadInfo.c != null) {
      localBundle.putString("key_secmsg_pic_original_url", paramPicUploadInfo.c);
    }
    if (paramPicUploadInfo.e != null) {
      localBundle.putString("key_secmsg_pic_small_url", paramPicUploadInfo.e);
    }
    if (paramPicUploadInfo.d != null) {
      localBundle.putString("key_secmsg_pic_compress_url", paramPicUploadInfo.d);
    }
    localMessage.what = 244;
    localMessage.setData(localBundle);
    a(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("SecMessagerService", 2, "info:" + paramPicUploadInfo);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.b.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("SecMessagerService", 2, "SecMessagerService onCreate");
    }
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader = new SecSnapChatPicUploader((QQAppInterface)this.app);
      this.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("SecMessagerService", 2, "mSnapChatPicUpLoader init");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SecMessagerService", 2, "mSnapChatPicUpLoader onDestroy");
    }
    this.app = null;
    this.jdField_a_of_type_AndroidOsMessenger = null;
    if (this.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader != null)
    {
      this.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader.a();
      this.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader = null;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\SecMessagerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */