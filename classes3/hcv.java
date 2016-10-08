import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.view.View;
import com.tencent.av.widget.stageview.MemberEffect;
import com.tencent.av.widget.stageview.StageMemberView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hcv
  extends View
{
  public hcv(StageMemberView paramStageMemberView, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f;
    if (StageMemberView.a(this.a) != null)
    {
      f = -StageMemberView.a(this.a).getFontMetrics().ascent;
      if (this.a.a == null) {
        break label76;
      }
      StageMemberView.a(this.a).setColor(this.a.a.a);
    }
    for (;;)
    {
      paramCanvas.drawText(StageMemberView.a(this.a), 0.0F, f, StageMemberView.a(this.a));
      return;
      label76:
      StageMemberView.a(this.a).setColor(-1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */