import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.util.Singleton;

public final class szm
  extends Singleton
{
  public szm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected TimerTaskManager a(Void paramVoid)
  {
    return new TimerTaskManager();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */