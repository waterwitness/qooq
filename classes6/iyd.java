import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.SimpleAnimatorListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyd
  extends AnimatorFactory.SimpleAnimatorListener
{
  public iyd(ElasticImageView paramElasticImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    SLog.b("ElasticImageView", "updateAnimator:" + this.a.d);
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */