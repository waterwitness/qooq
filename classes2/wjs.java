import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar.BottomItem;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar.ViewHolder;
import java.util.HashMap;
import java.util.List;

public class wjs
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  
  public wjs(WebViewBottomBar paramWebViewBottomBar, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public WebViewBottomBar.BottomItem a(int paramInt)
  {
    return (WebViewBottomBar.BottomItem)WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).get(paramInt);
  }
  
  public int getCount()
  {
    return WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).size();
  }
  
  public long getItemId(int paramInt)
  {
    return a(paramInt).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130905101, paramViewGroup, false);
      paramViewGroup = new WebViewBottomBar.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar, paramView);
      paramView.setTag(paramViewGroup);
      WebViewBottomBar.ViewHolder.a(paramViewGroup, a(paramInt).jdField_a_of_type_Int);
      if (!WebViewBottomBar.b(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).contains(paramViewGroup)) {
        WebViewBottomBar.b(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).add(paramViewGroup);
      }
      paramViewGroup.a(a(paramInt).b);
      if (WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).size() > paramInt)
      {
        paramViewGroup.a(a(paramInt).jdField_a_of_type_JavaLangString);
        if (WebViewBottomBar.b(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar) != 0) {
          paramViewGroup.b(WebViewBottomBar.b(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar));
        }
      }
      if (WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar) != getItemId(paramInt)) {
        break label216;
      }
    }
    label216:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.a(bool);
      wjt localwjt = (wjt)WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).get(Integer.valueOf(WebViewBottomBar.ViewHolder.a(paramViewGroup)));
      if (localwjt != null) {
        localwjt.a(WebViewBottomBar.ViewHolder.a(paramViewGroup));
      }
      return paramView;
      paramViewGroup = (WebViewBottomBar.ViewHolder)paramView.getTag();
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */