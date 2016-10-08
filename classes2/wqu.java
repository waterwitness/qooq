import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardContainer;
import com.tencent.qphone.base.util.QLog;

public class wqu
  extends URLDrawableDownListener.Adapter
{
  public wqu(CardContainer paramCardContainer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadSuccessed, view: " + paramView);
    }
    ((AnyScaleTypeImageView)paramView).setImageDrawable(paramURLDrawable);
    this.a.a.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */