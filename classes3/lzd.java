import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lzd
  extends LBSObserver
{
  public lzd(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateGetSwitch| isSuc = " + paramBoolean1 + ", userType = " + paramInt + ", curSwitch = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramInt == 64)) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateSetShareStatus| isSuc = " + paramBoolean1 + ", beShare = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.a.a(2131370267, 1);
    }
    this.a.a(paramBoolean2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */