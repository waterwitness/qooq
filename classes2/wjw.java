import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.webview.ui.WebViewTitlerBar;

public class wjw
  implements ValueAnimation.AnimationUpdateListener
{
  public wjw(WebViewTitlerBar paramWebViewTitlerBar, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!WebViewTitlerBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.a.getBackground().mutate().setAlpha(paramInteger.intValue());
      WebViewTitlerBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar, paramInteger.intValue());
    } while (WebViewTitlerBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar) != this.jdField_a_of_type_Int);
    WebViewTitlerBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */