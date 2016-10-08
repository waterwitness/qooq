import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class prc
  implements Runnable
{
  public prc(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a(), "角色: " + this.a + " 装扮不足7件", 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */