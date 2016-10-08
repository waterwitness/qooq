import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class itt
  extends AnimatorListenerAdapter
{
  public itt(StoryDownloadView paramStoryDownloadView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean) {
      new Handler().postDelayed(new itu(this), 1200L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */