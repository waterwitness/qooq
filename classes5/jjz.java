import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class jjz
  implements AsyncBack
{
  jjz(jjx paramjjx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "download progress:" + paramInt);
    }
    this.a.jdField_a_of_type_Jkc.jdField_a_of_type_Int = paramInt;
    this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "download finish, code:" + paramInt);
    }
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_Jkc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.b = this.a.b;
      UniformDownloadUtil.a(this.a.jdField_a_of_type_Jkc.b);
      return;
    }
    this.a.jdField_a_of_type_Jkc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(new jka(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */