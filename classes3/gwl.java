import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gwl
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public gwl(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, int paramInt, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "RefreshStatusTipsRunnale , type = " + this.jdField_a_of_type_Int + " , flag = " + this.jdField_a_of_type_Boolean);
    }
    int i = this.jdField_a_of_type_Int;
    if ((i == 49) || (i == 56) || (i == 51) || (i == 57) || (i == 58) || (i == 59)) {
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a != null) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.a(i, this.jdField_a_of_type_Boolean);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */