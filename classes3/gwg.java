import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class gwg
  implements Runnable
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  
  public gwg(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new gwh(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "onInviteUserNotice-->Can not get AVActivity");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */