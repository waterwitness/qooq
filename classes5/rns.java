import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class rns
  implements Runnable
{
  rns(rnq paramrnq, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Rnq.a.a(this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Rnq.a.a.a();
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish  process Over");
      return;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Rnq.a.b(this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */