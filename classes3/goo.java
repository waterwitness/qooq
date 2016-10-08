import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class goo
  implements Runnable
{
  public String a;
  
  public goo(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\goo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */