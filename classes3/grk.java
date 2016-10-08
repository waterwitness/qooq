import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class grk
  implements Runnable
{
  public grk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "2s has past, startTimer now!");
    }
    this.a.ad();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */