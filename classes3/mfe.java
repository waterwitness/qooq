import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class mfe
  implements IStatusListener
{
  public mfe(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, RichStatus paramRichStatus, String paramString)
  {
    if (this.a.b)
    {
      if (paramInt != 100) {
        this.a.a(2131369491);
      }
      this.a.x();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */