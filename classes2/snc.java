import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class snc
  extends DatingObserver
{
  public snc(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.a.a(100511);
      return;
    }
    this.a.a(100517);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */