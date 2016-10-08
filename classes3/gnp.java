import android.os.RemoteException;
import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gnp
  extends LBSObserver
{
  private List a;
  
  public gnp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback != null) {
      this.a.add(paramIQQServiceLocationCallback);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)localIterator.next();
      try
      {
        localIQQServiceLocationCallback.a(paramBoolean, paramLBSInfo);
      }
      catch (RemoteException localRemoteException) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
      }
    }
    this.a.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */