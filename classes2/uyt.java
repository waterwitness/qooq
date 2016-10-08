import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class uyt
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  public uyt(ShareAppLogActivity paramShareAppLogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    ShareAppLogActivity.a(this.a);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230).setTitle("警告").setMessage(ShareAppLogActivity.a(this.a).a(paramInt));
    localQQCustomDialog.setPositiveButton("继续", new uyu(this));
    localQQCustomDialog.setNegativeButton("取消", new uyv(this));
    localQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    try
    {
      ShareAppLogActivity.a(this.a, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QQToast.a(this.a.getApplicationContext(), "发送失败!", 0).a();
      return;
    }
    finally
    {
      ShareAppLogActivity.a(this.a);
    }
  }
  
  public void b(int paramInt)
  {
    ShareAppLogActivity.a(this.a);
    QQToast.a(this.a.getApplicationContext(), ShareAppLogActivity.a(this.a).a(paramInt), 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */