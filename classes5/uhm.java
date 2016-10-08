import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText.RichStatusEditListener;
import com.tencent.mobileqq.widget.ClickableImageSpan;

public class uhm
  implements RichStatusEditText.RichStatusEditListener
{
  public uhm(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ClickableImageSpan paramClickableImageSpan)
  {
    if (EditActivity.a(this.a) == paramClickableImageSpan)
    {
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).a(null);
      }
      EditActivity.a(this.a, null);
    }
  }
  
  public boolean a(ClickableImageSpan paramClickableImageSpan)
  {
    return paramClickableImageSpan != EditActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */