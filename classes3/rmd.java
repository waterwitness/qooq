import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmd
  implements View.OnClickListener
{
  public rmd(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.getPreferences().edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
    paramView = new AlphaAnimation(1.0F, 0.0F);
    paramView.setDuration(500L);
    paramView.setAnimationListener(new rme(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */