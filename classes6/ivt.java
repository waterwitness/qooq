import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.NewStoryPoiSearchViewPart;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.InputMethodUtil;

public class ivt
  implements Runnable
{
  public ivt(NewStoryPoiSearchViewPart paramNewStoryPoiSearchViewPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.requestFocus();
    InputMethodUtil.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */