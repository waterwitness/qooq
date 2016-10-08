import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback.Stub;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qpn
  extends IArRemoteCallback.Stub
{
  public qpn(RemoteArConfigManager paramRemoteArConfigManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadSuccess ");
    }
    this.a.a.sendMessage(this.a.a.obtainMessage(3));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadError|error= " + paramInt);
    }
    this.a.a.sendMessage(this.a.a.obtainMessage(5, Integer.valueOf(paramInt)));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (paramLong2 != 0L)
    {
      long l = 100L * paramLong1 / paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadProcess percent= " + l);
      }
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = ((int)paramLong1);
      localMessage.arg2 = ((int)paramLong2);
      this.a.a.sendMessage(localMessage);
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onConfigChanged!");
    }
    if (paramArConfigInfo != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArConfigInfo;
      this.a.a.sendMessage(localMessage);
    }
    if (paramArEffectConfig != null)
    {
      paramArConfigInfo = Message.obtain();
      paramArConfigInfo.what = 2;
      paramArConfigInfo.obj = paramArEffectConfig;
      this.a.a.sendMessage(paramArConfigInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */