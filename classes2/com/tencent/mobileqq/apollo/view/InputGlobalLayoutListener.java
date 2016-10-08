package com.tencent.mobileqq.apollo.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class InputGlobalLayoutListener
  implements View.OnLayoutChangeListener, Runnable
{
  public int a;
  private WeakReference a;
  
  public InputGlobalLayoutListener(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt2 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt2;
      paramView.post(this);
    }
  }
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.a == null)) {}
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)localBaseChatPie.a.getLayoutParams();
    } while (localLayoutParams == null);
    localLayoutParams.bottomMargin = (-this.jdField_a_of_type_Int);
    localBaseChatPie.a.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\InputGlobalLayoutListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */