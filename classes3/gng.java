import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QavWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallCardHandler.OnGetQCallCardListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class gng
  implements QCallCardHandler.OnGetQCallCardListener
{
  public gng(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onGetQCallNickName");
    }
    if (this.a.a == null) {
      this.a.a = ((QQAppInterface)this.a.a());
    }
    new QavWrapper(this.a.a.a().getApplicationContext()).a(new gnh(this, paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */