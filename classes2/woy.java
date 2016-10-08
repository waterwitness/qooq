import android.content.res.Resources;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.DrawableContainer;
import com.tencent.mobileqq.widget.DrawableContainer.ContainerState;
import com.tencent.mobileqq.widget.XfermodeDrawable;

public class woy
  extends DrawableContainer.ContainerState
{
  public Xfermode a;
  
  public woy(Drawable paramDrawable, DrawableContainer paramDrawableContainer, Xfermode paramXfermode)
  {
    super(paramDrawable, paramDrawableContainer);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramXfermode;
  }
  
  woy(woy paramwoy, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramwoy, paramDrawableContainer, paramResources);
    this.a = paramwoy.a;
  }
  
  public Drawable newDrawable()
  {
    return new XfermodeDrawable(this, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */