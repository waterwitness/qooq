import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class roe
  implements FileWebView.TitilebarEventInterface
{
  public roe(FilePreviewActivity paramFilePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.e)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "3";
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e = System.currentTimeMillis();
    }
    this.a.runOnUiThread(new rof(this));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\roe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */