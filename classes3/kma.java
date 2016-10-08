import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kma
  implements Runnable
{
  public kma(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "mRunOnShow 800");
    }
    this.a.i(3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */