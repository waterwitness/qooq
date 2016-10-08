import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.util.ArrayList;

public class tos
  implements View.OnDragListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public tos(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject1).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840637));
    Object localObject2 = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject2).setMargins((int)paramFloat1 - this.jdField_b_of_type_Int / 2, (int)paramFloat2 - this.jdField_b_of_type_Int / 2, 0, 0);
    PicInfo localPicInfo = (PicInfo)NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getTag();
    Drawable localDrawable = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).a();
    ((CustomImgView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((CustomImgView)localObject1).setImageDrawable(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
    localObject2 = new ScaleAnimation(1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1, (paramFloat1 - this.jdField_b_of_type_Int / 2) * this.jdField_a_of_type_Int / (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / this.jdField_a_of_type_Int, 1, (paramFloat2 - this.jdField_b_of_type_Int / 2) * this.jdField_a_of_type_Int / (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / this.jdField_a_of_type_Int);
    ((ScaleAnimation)localObject2).setDuration(200L);
    long l2 = this.jdField_a_of_type_Long + 500L - System.currentTimeMillis();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    ((ScaleAnimation)localObject2).setStartOffset(l1);
    ((ScaleAnimation)localObject2).setAnimationListener(new toy(this, localPicInfo, localDrawable, (CustomImgView)localObject1));
    ((CustomImgView)localObject1).startAnimation((Animation)localObject2);
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "dropSmallInBig...");
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    int[] arrayOfInt1 = new int[2];
    ((View)localObject1).getLocationInWindow(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.getLocationInWindow(arrayOfInt2);
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject2 = new ScaleAnimation(1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject2).setDuration(200L);
    Object localObject3 = new TranslateAnimation(0.0F, (arrayOfInt1[0] + this.jdField_b_of_type_Int / 2 - arrayOfInt2[0] - this.jdField_a_of_type_Int / 2) * -1, 0.0F, (arrayOfInt1[1] + this.jdField_b_of_type_Int / 2 - arrayOfInt2[1] - this.jdField_a_of_type_Int / 2) * -1);
    ((TranslateAnimation)localObject3).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.addAnimation((Animation)localObject3);
    localAnimationSet.setStartOffset(300L);
    localObject2 = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localObject3 = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(arrayOfInt1[0] - arrayOfInt2[0], arrayOfInt1[1] - arrayOfInt2[1], 0, 0);
    ((CustomImgView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, (CustomImgView)localObject2, (PicInfo)((View)localObject1).getTag(), null);
    localAnimationSet.setAnimationListener(new tou(this, (View)localObject1, (CustomImgView)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.remove(((View)localObject1).getTag());
    ((CustomImgView)localObject2).startAnimation(localAnimationSet);
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "smallBecomeBig...");
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    Object localObject2 = new int[2];
    ((View)localObject1).getLocationInWindow((int[])localObject2);
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.getLocationInWindow(arrayOfInt);
    localObject1 = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, this.jdField_b_of_type_Int / this.jdField_a_of_type_Int, 1.0F, this.jdField_b_of_type_Int / this.jdField_a_of_type_Int, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localObject2 = new TranslateAnimation(0.0F, localObject2[0] + this.jdField_b_of_type_Int / 2 - arrayOfInt[0] - this.jdField_a_of_type_Int / 2, 0.0F, localObject2[1] + this.jdField_b_of_type_Int / 2 - arrayOfInt[1] - this.jdField_a_of_type_Int / 2);
    ((TranslateAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation(localScaleAnimation);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setStartOffset(300L);
    localObject2 = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag(), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.a());
    ((CustomImgView)localObject2).setVisibility(4);
    ((AnimationSet)localObject1).setAnimationListener(new tow(this, (PicInfo)paramView.getTag(), (CustomImgView)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.startAnimation((Animation)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, paramInt);
    if (QLog.isColorLevel())
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "bigBecomeSmall...");
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = BaseApplicationImpl.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), 0);
    if (((SharedPreferences)localObject).getBoolean("NearbyVideoHeadDialog", false)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView != null) && ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag() instanceof PicInfo)) && (!TextUtils.isEmpty(((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag()).d))) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((SharedPreferences)localObject).edit().putBoolean("NearbyVideoHeadDialog", true).commit();
        localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131372702), 2131367262, 2131372704, new tpa(this), new tpb(this, paramInt));
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.postDelayed(new tpc(this, (QQCustomDialog)localObject), 1000L);
        return;
      }
    }
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    default: 
    case 1: 
    case 5: 
    case 2: 
    case 6: 
    case 3: 
      do
      {
        do
        {
          do
          {
            int i;
            int j;
            CustomImgView localCustomImgView;
            do
            {
              do
              {
                do
                {
                  return true;
                  QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
                  return true;
                  paramDragEvent = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
                  i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramView);
                  j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramDragEvent);
                  if ((i == -1) && (j != -1) && (!this.jdField_a_of_type_Boolean))
                  {
                    a(paramDragEvent, j);
                    this.jdField_a_of_type_Boolean = true;
                    this.jdField_a_of_type_Long = System.currentTimeMillis();
                    b(j);
                    return true;
                  }
                } while ((i == -1) || (j != -1));
                try
                {
                  a(i);
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramDragEvent, i);
                  NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
                  b(i);
                  return true;
                }
                catch (Exception paramView) {}
              } while (!QLog.isColorLevel());
              QLog.d("Q.nearby_people_card.", 2, "small pic getting big exception" + paramView.getMessage());
              return true;
              localCustomImgView = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
              i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramView);
              j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(localCustomImgView);
            } while ((i == -1) || (j == -1) || (((i <= j) || (paramDragEvent.getX() <= this.jdField_b_of_type_Int / 2)) && ((i >= j) || (paramDragEvent.getX() >= this.jdField_b_of_type_Int / 2))));
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(localCustomImgView);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, i);
              NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
              return true;
            }
            catch (Exception paramView) {}
          } while (!QLog.isColorLevel());
          QLog.d("Q.nearby_people_card.", 2, "drag between small pics exception" + paramView.getMessage());
          return true;
        } while (paramView != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView);
        this.jdField_a_of_type_Boolean = false;
        return true;
      } while (paramView != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView);
      a(paramDragEvent.getX(), paramDragEvent.getY());
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.post(new tot(this));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */