import com.tencent.av.gaudio.AVObserver;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class krv
  extends AVObserver
{
  public krv(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    this.a.i();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (Call.a(this.a) != null) {
      Call.a(this.a).a(paramBoolean, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */