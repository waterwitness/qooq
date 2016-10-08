import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeSwitchManager;

public class uzr
  implements Runnable
{
  public uzr(ThemeSwitchManager paramThemeSwitchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.jdField_a_of_type_AndroidWidgetImageView.getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.a.jdField_a_of_type_AndroidWidgetImageView);
      localViewGroup.clearDisappearingChildren();
    }
    this.a.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.a.c = false;
    this.a.jdField_a_of_type_AndroidWidgetImageView = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */