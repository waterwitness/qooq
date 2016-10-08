import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.ReversedNinePatchDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class quo
  extends Drawable.ConstantState
{
  public final NinePatch a;
  
  public quo(NinePatch paramNinePatch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramNinePatch;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new ReversedNinePatchDrawable(null, this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ReversedNinePatchDrawable(paramResources, this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\quo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */