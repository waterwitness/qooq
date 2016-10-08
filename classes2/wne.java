import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PhotoWallView;

public class wne
  implements View.OnClickListener
{
  public wne(PhotoWallView paramPhotoWallView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    String str = "http://ti.qq.com/photowall/index.html?_wv=1027";
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.a.jdField_a_of_type_JavaLangString)) {
      str = "http://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + this.a.jdField_a_of_type_JavaLangString;
    }
    paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("url", str);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.a.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      return;
    }
    this.a.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramView, 1022);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */