import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar.ViewHolder;
import java.util.HashMap;

public class wjt
{
  public int a;
  public String a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  
  public wjt(WebViewBottomBar paramWebViewBottomBar, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 0;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar, paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Int == 1)
      {
        if ((!this.jdField_a_of_type_Boolean) && (WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).containsKey(Integer.valueOf(paramInt)))) {
          WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).remove(Integer.valueOf(paramInt));
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          ((WebViewBottomBar.ViewHolder)localObject).b.setVisibility(8);
        }
        localObject = ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView;
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = i;; paramInt = 4)
        {
          ((ImageView)localObject).setVisibility(paramInt);
          return;
        }
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        if (paramInt <= 0)
        {
          if (WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).containsKey(Integer.valueOf(paramInt))) {
            WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).remove(Integer.valueOf(paramInt));
          }
          ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        paramInt = Integer.parseInt(this.jdField_a_of_type_JavaLangString);
        if (paramInt <= 0)
        {
          if (WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).containsKey(Integer.valueOf(WebViewBottomBar.ViewHolder.a((WebViewBottomBar.ViewHolder)localObject)))) {
            WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).remove(Integer.valueOf(WebViewBottomBar.ViewHolder.a((WebViewBottomBar.ViewHolder)localObject)));
          }
          ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ((WebViewBottomBar.ViewHolder)localObject).b.setVisibility(8);
        ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    if (!this.jdField_a_of_type_Boolean)
    {
      ((WebViewBottomBar.ViewHolder)localObject).b.setVisibility(8);
      return;
    }
    ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    ((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((WebViewBottomBar.ViewHolder)localObject).b.setText(this.jdField_a_of_type_JavaLangString);
    ((WebViewBottomBar.ViewHolder)localObject).b.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */