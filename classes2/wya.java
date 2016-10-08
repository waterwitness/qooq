import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianManager;

public class wya
  implements Runnable
{
  public wya(QidianManager paramQidianManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QidianManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */