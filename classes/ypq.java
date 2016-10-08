import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;

public final class ypq
  implements INetEventHandler
{
  public ypq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    QLog.i(NetworkState.c(), 1, "--onNetChangeEvent isNetEffective:" + paramBoolean);
    NetworkState.a(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ypq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */