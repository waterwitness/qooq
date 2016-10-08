import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class gok
  implements Runnable
{
  gok(goi paramgoi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "AutoCheckVideoRunnable");
    }
    if (this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
    }
    this.a.a.o();
    if ((this.a.a.c == 1) && (this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.a());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */