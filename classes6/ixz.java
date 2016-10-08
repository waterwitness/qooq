import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixz
  implements TextLayer.LayerListener
{
  private ixz(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.setViewActive(DoodleLayout.f(this.a), true);
    this.a.setViewActive(DoodleLayout.g(this.a), false);
    this.a.setViewActive(DoodleLayout.e(this.a), false);
    DoodleLayout.a(this.a);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      DoodleLayout.a(this.a).a(DoodleLayout.a(this.a).a());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */