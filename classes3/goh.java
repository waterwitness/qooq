import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class goh
  implements Runnable
{
  public goh(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "2s has past, startTimer now!");
    }
    this.a.u();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\goh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */