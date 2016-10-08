import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gwy
  implements Runnable
{
  public gwy(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "RemoveTipsRunnale Run");
    }
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */