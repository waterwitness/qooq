import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HuangyeHandler;
import java.util.TimerTask;

public final class ycw
  extends TimerTask
{
  public ycw(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HuangyeHandler.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */