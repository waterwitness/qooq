import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class har
  implements Runnable
{
  har(haq paramhaq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a != null)
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a.a(new Object[] { Integer.valueOf(120), Integer.valueOf(1) });
      if (QLog.isColorLevel()) {
        QLog.e("VideoLayerUI", 2, "[childLock] trigger animation");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\har.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */