package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BoxCardUtils
{
  private static final String jdField_a_of_type_JavaLangString = "BoxCardUtils";
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private static WeakReference b;
  
  public BoxCardUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(View paramView, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    if (paramBoolean) {}
    for (Object localObject = a; (localObject != null) && (((WeakReference)localObject).get() != null); localObject = b)
    {
      paramView.setBackgroundDrawable(new BitmapDrawable(paramView.getResources(), (Bitmap)((WeakReference)localObject).get()));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
        paramDrawable.draw(localCanvas);
        if (paramBoolean)
        {
          a = new WeakReference(localObject);
          paramView.setBackgroundDrawable(new BitmapDrawable(paramView.getResources(), (Bitmap)localObject));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BoxCardUtils", 2, localThrowable.getMessage());
        }
        paramView.setBackgroundDrawable(paramDrawable);
        return;
      }
      b = new WeakReference(localThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\BoxCardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */