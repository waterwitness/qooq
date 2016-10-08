import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class uii
  implements IActionListener
{
  public uii(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      ActionInfo localActionInfo = EditActivity.a(this.a).a(EditActivity.a(this.a).actionId);
      if (localActionInfo != null)
      {
        EditActivity.a(this.a).actionText = localActionInfo.d;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */