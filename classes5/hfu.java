import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hfu
  extends MessageObserver
{
  public hfu(TroopRedTouchHandler paramTroopRedTouchHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (105 == paramInt) {
      this.a.a(105, true, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */