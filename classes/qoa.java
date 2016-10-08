import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qoa
  extends SosoInterface.OnLocationListener
{
  public qoa(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onLocationFinish() lock.notifyAll()");
    }
    synchronized (SosoInterface.a)
    {
      SosoInterface.a.notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qoa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */