import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nex
  extends View
{
  public nex(ComboAnimation3 paramComboAnimation3, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable[] arrayOfDrawable = this.a.a;
    int j = arrayOfDrawable.length;
    int i = 0;
    while (i < j)
    {
      arrayOfDrawable[i].draw(paramCanvas);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    paramInt3 = paramInt4 - paramInt2;
    Drawable[] arrayOfDrawable = this.a.a;
    paramInt4 = arrayOfDrawable.length;
    paramInt2 = 0;
    while (paramInt1 < paramInt4)
    {
      Drawable localDrawable = arrayOfDrawable[paramInt1];
      localDrawable.setBounds(paramInt2, paramInt3 - localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth() + paramInt2, paramInt3);
      paramInt2 += localDrawable.getIntrinsicWidth();
      paramInt1 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */