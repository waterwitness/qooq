import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView.LayoutParams;

public class sru
  implements Animator.AnimatorListener
{
  public sru(FNDefaultItemBuilder paramFNDefaultItemBuilder, FNDefaultItemData paramFNDefaultItemData, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */