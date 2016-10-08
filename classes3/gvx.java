import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gvx
  implements Runnable
{
  gvx(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "AutoCheckVideoRunnable");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
    }
    MultiVideoCtrlLayerUI4NewGroupChat.i(this.a);
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */