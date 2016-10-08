import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.control.ColorPicker.ColorSelectListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixq
  implements ColorPicker.ColorSelectListener
{
  public ixq(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != LineLayer.f) {}
    for (this.a.c = true;; this.a.c = false)
    {
      DoodleLayout.a(this.a).a(paramInt);
      DoodleLayout.a(this.a, DoodleLayout.a(this.a), paramInt);
      DoodleLayout.a(this.a).invalidate();
      if (DoodleLayout.a(this.a).b())
      {
        DoodleLayout.b(this.a).setImageResource(2130841457);
        DoodleLayout.a(this.a).d();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */