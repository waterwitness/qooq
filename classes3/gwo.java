import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gwo
  implements Runnable
{
  public String a;
  
  public gwo(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */