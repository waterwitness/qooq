import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class jbs
  implements QRCodeEncodeCallback
{
  jbs(jbr paramjbr, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onReceive qrcode url: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Jbr.a.b) || (this.jdField_a_of_type_Jbr.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Jbr.a.g();
      return;
    }
    this.jdField_a_of_type_Jbr.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.jdField_a_of_type_Jbr.a.a = paramString;
      this.jdField_a_of_type_Jbr.a.f();
      return;
    }
    this.jdField_a_of_type_Jbr.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */