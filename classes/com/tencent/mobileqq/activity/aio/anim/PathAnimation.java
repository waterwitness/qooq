package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import nfb;

public class PathAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  public ArrayList a;
  private nfb a;
  
  public PathAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView, AnimationPath.Values paramValues)
  {
    if (!paramValues.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      int i = paramView.getLeft();
      int j = paramView.getWidth() / 2;
      int k = paramView.getTop();
      int m = paramView.getHeight() / 2;
      paramView.offsetTopAndBottom(paramValues.jdField_d_of_type_Int - (k + m));
      paramView.offsetLeftAndRight(paramValues.jdField_c_of_type_Int - (i + j));
    } while (!VersionUtils.e());
    paramView.setAlpha(paramValues.f);
    paramView.setRotation(paramValues.jdField_a_of_type_Float);
    paramView.setScaleX(paramValues.jdField_d_of_type_Float);
    paramView.setScaleY(paramValues.e);
    paramView.setRotationX(paramValues.jdField_b_of_type_Float);
    paramView.setRotationY(paramValues.jdField_c_of_type_Float);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    try
    {
      Drawable[] arrayOfDrawable;
      long l1;
      AnimationPath localAnimationPath;
      int i;
      label81:
      View localView;
      int j;
      label159:
      AnimationPath.Values localValues;
      if ((paramVarArgs[0] instanceof Drawable[]))
      {
        arrayOfDrawable = (Drawable[])paramVarArgs[0];
        int k = ((Integer)paramVarArgs[1]).intValue();
        l1 = ((Long)paramVarArgs[2]).longValue();
        localAnimationPath = (AnimationPath)AIOAnimationConatiner.a.loadClass((String)paramVarArgs[3]).newInstance();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(k);
        long l2 = AnimationUtils.currentAnimationTimeMillis();
        i = 0;
        if (i >= k) {
          break label307;
        }
        localView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        Drawable localDrawable = arrayOfDrawable[((int)(Math.random() * arrayOfDrawable.length))];
        localView.setBackgroundDrawable(localDrawable);
        localView.layout(-localDrawable.getIntrinsicWidth(), -localDrawable.getIntrinsicHeight(), 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(localView);
        if (i != 0) {
          break label274;
        }
        j = 0;
        localValues = new AnimationPath.Values();
        localValues.jdField_a_of_type_Long = (j + l2);
        localValues.jdField_a_of_type_AndroidViewView = localView;
        if (i != 0) {
          break label287;
        }
        paramVarArgs = localAnimationPath;
        label193:
        localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath = paramVarArgs;
        if (!VersionUtils.e()) {
          break label297;
        }
        localView.setLayerType(2, null);
        localView.setPivotX(localDrawable.getIntrinsicWidth() / 2);
        localView.setPivotY(localDrawable.getIntrinsicHeight() / 2);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localValues);
        i += 1;
        break label81;
        arrayOfDrawable = new Drawable[] { (Drawable)paramVarArgs[0] };
        break;
        label274:
        j = (int)(Math.random() * l1);
        break label159;
        label287:
        paramVarArgs = localAnimationPath.a();
        break label193;
        label297:
        localView.setTag(localValues);
      }
      label307:
      if (this.jdField_a_of_type_Nfb == null)
      {
        this.jdField_a_of_type_Nfb = new nfb(this, null);
        this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_Nfb, 16L);
      }
      return true;
    }
    catch (Exception paramVarArgs) {}
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Nfb != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_Nfb);
      this.jdField_a_of_type_Nfb = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\PathAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */