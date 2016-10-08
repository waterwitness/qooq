import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public final class smy
  implements Runnable
{
  public smy(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MineFragment.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */