import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.AddFriendScannerActivity;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jal
  implements QRCodeEncodeCallback
{
  public jal(AddFriendScannerActivity paramAddFriendScannerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "onReceive qrcode url: " + paramBoolean);
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.f();
      return;
    }
    ScannerUtils.a(this.a.jdField_a_of_type_AndroidContentSharedPreferences, this.a.jdField_a_of_type_JavaLangString, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramString;
      this.a.e();
      return;
    }
    this.a.f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */