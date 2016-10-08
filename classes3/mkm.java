import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.SendingFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;

class mkm
  implements Runnable
{
  mkm(mkl parammkl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NetworkUtil.e(this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      return;
    }
    this.a.a.jdField_d_of_type_Boolean = true;
    SendMultiPictureHelper.a(this.a.a);
    this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    int i = 1;
    while (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.a.a.a((SendMultiPictureHelper.SendingFileInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i), this.a.a.jdField_c_of_type_Int, this.a.a.jdField_d_of_type_JavaLangString, this.a.a.jdField_c_of_type_JavaLangString);
      this.a.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.a.f, new Object[] { Integer.valueOf(this.a.a.jdField_a_of_type_Int + i), Integer.valueOf(this.a.a.b), Integer.valueOf(0) }));
      i += 1;
    }
    this.a.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */