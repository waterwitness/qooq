import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.qphone.base.util.QLog;

public class tie
  extends NearbyProxyObserver
{
  public tie(NearbyProxy paramNearbyProxy, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("realHasUnreadMsg", new Object[] { "onNearbyProcStart" });
    }
    NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy, 4100, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */