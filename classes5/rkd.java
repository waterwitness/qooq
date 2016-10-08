import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class rkd
  implements Runnable
{
  rkd(rkc paramrkc, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 5)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      if (this.jdField_a_of_type_Rkc.a.b.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
      {
        this.jdField_a_of_type_Rkc.a.b.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
        return;
      }
      this.jdField_a_of_type_Rkc.a.c = false;
      this.jdField_a_of_type_Rkc.a.e = false;
      this.jdField_a_of_type_Rkc.a.d = false;
    } while ((this.jdField_a_of_type_Rkc.a.getVisibility() != 0) || (this.jdField_a_of_type_Rkc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "Emoticon pkg downloaded in panel, refresh");
    }
    int i = 0;
    label148:
    if (i < this.jdField_a_of_type_Rkc.a.jdField_a_of_type_JavaUtilList.size())
    {
      EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)this.jdField_a_of_type_Rkc.a.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Rkc.a.b(i);
      EmoticonMainPanel.a(this.jdField_a_of_type_Rkc.a, false);
      return;
      i += 1;
      break label148;
      if (this.jdField_a_of_type_Int == 11000)
      {
        QQToast.a(this.jdField_a_of_type_Rkc.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Rkc.a.jdField_a_of_type_AndroidContentContext.getString(2131370488), 1).b(this.jdField_a_of_type_Rkc.a.m);
        return;
      }
      if (this.jdField_a_of_type_Int != 11001) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_Rkc.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Rkc.a.jdField_a_of_type_AndroidContentContext.getString(2131370487), 1).b(this.jdField_a_of_type_Rkc.a.m);
      return;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */