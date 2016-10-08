import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixu
  implements EditTextDialog.EditTextDialogEventListener
{
  private ixu(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    DoodleLayout.a(this.a).c();
  }
  
  public void a(int paramInt)
  {
    DoodleLayout.a(this.a).a(paramInt);
  }
  
  public void a(boolean paramBoolean, TextInfo paramTextInfo)
  {
    if (paramBoolean)
    {
      DoodleLayout.d(this.a).setImageResource(2130841365);
      DoodleLayout.a(this.a).a(true);
      DoodleLayout.b(this.a, 1);
      return;
    }
    if (paramTextInfo.c != -1) {}
    for (this.a.b = true;; this.a.b = false)
    {
      DoodleLayout.a(this.a).a(paramTextInfo);
      DoodleLayout.a(this.a).a(false);
      this.a.setViewActive(DoodleLayout.f(this.a), true);
      this.a.setViewActive(DoodleLayout.g(this.a), true);
      this.a.setViewActive(DoodleLayout.e(this.a), true);
      DoodleLayout.d(this.a).setImageResource(2130841378);
      DoodleLayout.b(this.a, 0);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (DoodleLayout.a(this.a) != null) {
      DoodleLayout.a(this.a).a(3, paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */