import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jjt
  implements Runnable
{
  public jjt(XChooserActivity paramXChooserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */