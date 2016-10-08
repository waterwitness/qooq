import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rkb
  implements Runnable
{
  public rkb(EmoticonMainPanel paramEmoticonMainPanel, EmoticonPackage paramEmoticonPackage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b.add(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e = false;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "refresh magic emoji.");
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */