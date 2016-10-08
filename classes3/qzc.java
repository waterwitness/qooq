import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class qzc
  implements ConditionSearchManager.IConfigListener
{
  public qzc(ConditionSearchFriendActivity paramConditionSearchFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetConfig | mDialogType = " + this.a.n + ", isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((this.a.n == 1) || (this.a.n == 2))
    {
      if (paramBoolean) {
        break label110;
      }
      this.a.a();
      QQToast.a(this.a, 2131371451, 0).b(this.a.getTitleBarHeight());
    }
    label110:
    while (paramInt != 2) {
      return;
    }
    this.a.a();
    this.a.a(this.a.n);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */