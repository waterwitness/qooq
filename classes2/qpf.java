import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qpf
  implements IArConfigListener
{
  public qpf(ArConfigService paramArConfigService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a();
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
    ArConfigUtils.a(this.a.a.a(), true, 0);
  }
  
  public void a(int paramInt)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramInt);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
    ArConfigUtils.a(this.a.a.a(), false, paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramLong1, paramLong2);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramArConfigInfo, null);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramArConfigInfo)
    {
      paramArConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(null, paramArEffectConfig);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramArEffectConfig)
    {
      paramArEffectConfig.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */