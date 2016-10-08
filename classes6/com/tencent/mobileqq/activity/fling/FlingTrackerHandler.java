package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.OrientationUtil;
import java.lang.ref.WeakReference;
import oku;

public class FlingTrackerHandler
  extends FlingHandler
  implements TopLayout.OnDraggingListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ContentWrapView jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView;
  private TopLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public FlingTrackerHandler(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new oku(this);
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if ((paramInt1 & paramInt2) != 0)
    {
      if ((paramInt1 | paramInt2) != -1) {
        break label30;
      }
      m = j;
    }
    label30:
    int k;
    label42:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label42;
      n = m;
    }
  }
  
  private String a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null) {
      return ScreenCapture.getSnapPath(localActivity, a());
    }
    return null;
  }
  
  private void c()
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
      int j = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
      try
      {
        localObject1 = decodeSampledBitmapFromFile((String)localObject1, i, j);
        if (localObject1 == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError = localOutOfMemoryError;
        if (0 == 0) {
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        return;
      }
      finally
      {
        localObject2 = finally;
        if (0 != 0) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        }
        throw ((Throwable)localObject2);
      }
    }
  }
  
  protected void a()
  {
    if ((b()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent() != null);
  }
  
  protected void b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent().equals(localObject)))
      {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) && (this.jdField_a_of_type_AndroidViewView.getParent().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.removeView(this.jdField_a_of_type_AndroidViewView);
          ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidViewView);
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null))
        {
          localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
          if ((localObject instanceof BitmapDrawable))
          {
            localObject = ((BitmapDrawable)localObject).getBitmap();
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
              ((Bitmap)localObject).recycle();
            }
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void cancelDrag()
  {
    OrientationUtil.b((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
  
  public Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public void endDrag()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null)
    {
      OrientationUtil.b(localActivity);
      localActivity.onBackPressed();
      localActivity.overridePendingTransition(2130968623, 2130968623);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.onConfigChanged(paramConfiguration);
    }
  }
  
  public void startDrag()
  {
    OrientationUtil.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\fling\FlingTrackerHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */