package cooperation.groupvideo;

import android.os.RemoteException;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.gvideo.IGVServiceForQQ;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ybx;

public class GroupVideoWrapper
{
  public static final String a = "GroupVideoRemoteManager";
  public IGVServiceForQQ a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public GroupVideoWrapper.OnGVideoReadyListener a;
  ybx jdField_a_of_type_Ybx;
  
  public GroupVideoWrapper(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ = null;
    this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener = null;
    this.jdField_a_of_type_Ybx = new ybx(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public IGVServiceForQQ a()
  {
    return this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ;
  }
  
  public void a()
  {
    GroupVideoHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Ybx);
    this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ = null;
    this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener = null;
  }
  
  public void a(MeetingInfo paramMeetingInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a(paramMeetingInfo);
        return;
      }
      catch (RemoteException paramMeetingInfo) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramMeetingInfo);
  }
  
  public void a(GroupVideoWrapper.OnGVideoReadyListener paramOnGVideoReadyListener)
  {
    this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener = paramOnGVideoReadyListener;
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      GroupVideoHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, GVideoProxyService.class, this.jdField_a_of_type_Ybx, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\groupvideo\GroupVideoWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */