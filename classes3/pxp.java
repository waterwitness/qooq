import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;

public class pxp
  implements DrawerFrame.IDrawerCallbacks
{
  public pxp(FrameHelperActivity paramFrameHelperActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartMoving:: side = " + paramInt + " getActivity = " + this.a.getActivity() + " mDrawerBg= " + this.a.jdField_a_of_type_AndroidViewViewGroup);
    }
    if (this.a.getActivity() == null) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_AndroidViewViewGroup != null) {
        FrameHelperActivity.a(this.a, false);
      }
      DrawerFrame.IDrawerCallbacks[] arrayOfIDrawerCallbacks = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
      int j = arrayOfIDrawerCallbacks.length;
      while (i < j)
      {
        DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = arrayOfIDrawerCallbacks[i];
        if (localIDrawerCallbacks != null) {
          localIDrawerCallbacks.a(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerMoving:: side = " + paramInt + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {}
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 11)
      {
        float f = 1.0F - paramFloat;
        if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setAlpha(f);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setAlpha(f);
        }
      }
      DrawerFrame.IDrawerCallbacks[] arrayOfIDrawerCallbacks = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
      int j = arrayOfIDrawerCallbacks.length;
      int i = 0;
      while (i < j)
      {
        DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = arrayOfIDrawerCallbacks[i];
        if (localIDrawerCallbacks != null) {
          localIDrawerCallbacks.a(paramInt, paramFloat);
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerOpened:: side = " + paramInt1 + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {}
    for (;;)
    {
      return;
      this.a.a(paramInt2, true, FrameHelperActivity.a(this.a));
      if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null)) {
        FrameHelperActivity.a(this.a).a();
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
        }
      }
      DrawerFrame.IDrawerCallbacks[] arrayOfIDrawerCallbacks = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
      int j = arrayOfIDrawerCallbacks.length;
      int i = 0;
      while (i < j)
      {
        DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = arrayOfIDrawerCallbacks[i];
        if (localIDrawerCallbacks != null) {
          localIDrawerCallbacks.a(paramInt1, paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartToggle:: side = " + paramInt + " open:" + paramBoolean + " getActivity = " + this.a.getActivity());
    }
    DrawerFrame.IDrawerCallbacks[] arrayOfIDrawerCallbacks = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    int j = arrayOfIDrawerCallbacks.length;
    int i = 0;
    while (i < j)
    {
      DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = arrayOfIDrawerCallbacks[i];
      if (localIDrawerCallbacks != null) {
        localIDrawerCallbacks.a(paramInt, paramBoolean);
      }
      i += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerClosed:: side = " + paramInt1 + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {}
    for (;;)
    {
      return;
      this.a.a(paramInt2, false, FrameHelperActivity.a(this.a));
      if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null)) {
        FrameHelperActivity.a(this.a).b();
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
        }
      }
      ImageView localImageView;
      if (this.a.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localObject = (ImageView)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302402);
        localImageView = (ImageView)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301086);
        ((ImageView)localObject).setImageResource(0);
        localImageView.setImageResource(0);
      }
      Object localObject = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localImageView = localObject[i];
        if (localImageView != null) {
          localImageView.b(paramInt1, paramInt2);
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */