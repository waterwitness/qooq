import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class hhj
  implements ActionSheet.OnDismissListener
{
  public hhj(FileChooserHelper paramFileChooserHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */