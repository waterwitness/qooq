import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mfv
  extends DingdongPluginBizObserver
{
  public mfv(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 5)
    {
      QQSettingMe.a(this.a, true);
      this.a.z();
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 13);
      QQSettingMe.a(this.a, true);
    } while (!QQSettingMe.c(this.a));
    QQSettingMe.c(this.a);
    this.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */