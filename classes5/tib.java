import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.qphone.base.util.QLog;

public class tib
  implements ConditionSearchManager.IConfigListener
{
  public tib(NearbyProxy paramNearbyProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "onGetConfig, resultCode:" + paramInt + ",isSuccess:" + paramBoolean);
    }
    NearbyProxy.a(this.a, 4133, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */