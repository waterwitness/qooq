import android.app.Activity;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class igj
  implements BusinessObserver
{
  public igj(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new igk(this, paramObject));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */