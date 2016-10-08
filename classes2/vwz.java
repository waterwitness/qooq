import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class vwz
  implements BusinessObserver
{
  public vwz(UnifiedDebugReporter paramUnifiedDebugReporter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("extra_data");
      if (paramBundle == null) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        RemoteDebugReportMsg.RemoteLogRsp localRemoteLogRsp = new RemoteDebugReportMsg.RemoteLogRsp();
        localRemoteLogRsp.mergeFrom(paramBundle);
        if (localRemoteLogRsp.i32_ret.has())
        {
          paramInt = localRemoteLogRsp.i32_ret.get();
          if (QLog.isColorLevel()) {
            QLog.d(UnifiedDebugReporter.a(), 2, "onReceive: retCode=" + paramInt);
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(UnifiedDebugReporter.a(), 2, "onReceive: exception=" + paramBundle.getMessage());
        return;
      }
    }
    QLog.e(UnifiedDebugReporter.a(), 2, "onReceive: isSuccess=" + paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */