import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class koy
  implements Runnable
{
  public koy(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "hor anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
    }
    int i;
    if (this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout != null)
    {
      i = 0;
      while (i < this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout.length)
      {
        if (this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i] != null) {
          this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i].setVisibility(8);
        }
        i += 1;
      }
    }
    if (this.a.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      i = 0;
      while (i < this.a.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.a.jdField_a_of_type_ArrayOfAndroidViewView[i] != null) {
          this.a.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\koy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */