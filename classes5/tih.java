import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class tih
  extends ShieldListObserver
{
  public tih(NearbyProxy paramNearbyProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, List paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(NearbyProxy.a, 2, "onAddShieldList from nearby");
      }
      NearbyProxy.a(this.a, 4115, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
  
  protected void b(boolean paramBoolean, List paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(NearbyProxy.a, 2, "onDeleteShieldList from nearby");
      }
      NearbyProxy.a(this.a, 4116, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */