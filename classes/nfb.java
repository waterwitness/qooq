import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AnimationPath;
import com.tencent.mobileqq.activity.aio.anim.AnimationPath.Values;
import com.tencent.mobileqq.activity.aio.anim.PathAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

public class nfb
  implements Runnable
{
  private nfb(PathAnimation paramPathAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l3 = AnimationUtils.currentAnimationTimeMillis();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l2 = -1L;
    if (localIterator.hasNext())
    {
      AnimationPath.Values localValues = (AnimationPath.Values)localIterator.next();
      long l1;
      if (l3 < localValues.jdField_a_of_type_Long)
      {
        l1 = localValues.jdField_a_of_type_Long - l3;
        label58:
        if (l1 < 0L) {
          break label182;
        }
        if (l2 >= 0L) {
          break label172;
        }
        label71:
        this.a.a(localValues.jdField_a_of_type_AndroidViewView, localValues);
      }
      for (;;)
      {
        l2 = l1;
        break;
        if (!localValues.b)
        {
          l1 = localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath.a(localValues, localValues.jdField_a_of_type_AndroidViewView.getWidth(), localValues.jdField_a_of_type_AndroidViewView.getHeight(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight());
          localValues.b = true;
          break label58;
        }
        l1 = localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath.a(l3 - localValues.jdField_a_of_type_Long, localValues);
        break label58;
        label172:
        l1 = Math.min(l2, l1);
        break label71;
        label182:
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(localValues.jdField_a_of_type_AndroidViewView);
        localIterator.remove();
        l1 = l2;
      }
    }
    if (l2 >= 0L)
    {
      this.a.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this, l2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      return;
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */