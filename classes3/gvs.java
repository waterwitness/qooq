import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gvs
  implements Runnable
{
  gvs(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "AutoCheckVideoRunnable");
    }
    if (this.a.a != null) {
      this.a.a.a().aj = true;
    }
    this.a.V();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */