import android.view.View;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixt
  implements Runnable
{
  public ixt(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DoodleLayout.a(this.a, true);
    DoodleLayout.a(this.a, new View[] { DoodleLayout.a(this.a) });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */