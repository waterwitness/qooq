import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class lvx
  implements ConditionSearchManager.IConfigListener
{
  public lvx(NearPeopleFilterActivity paramNearPeopleFilterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.c();
    if (!paramBoolean) {
      QQToast.a(BaseApplication.getContext(), 2131371451, 0).b(this.a.getTitleBarHeight());
    }
    while (paramInt != 2) {
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */