package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class UIUtils
{
  public static final int a = 1;
  public static final CircleTransformation a;
  public static final RoundedTransformation a;
  public static final String a = "Q.qqstory.UIUtils";
  private static final AtomicInteger a;
  public static final int b = 0;
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 0;
  public static final int g = 0;
  public static final int h = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = -1;
    d = -1;
    e = -1;
    f = -1;
    jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation = new RoundedTransformation(20, 0);
    jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageCircleTransformation = new CircleTransformation();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    return paramFloat / a(paramContext) + 0.5F;
  }
  
  public static int a()
  {
    int k;
    int i;
    do
    {
      k = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      int j = k + 1;
      i = j;
      if (j > 16777215) {
        i = 1;
      }
    } while (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(k, i));
    return k;
  }
  
  public static int a(Context paramContext)
  {
    if (e > 0) {
      return e;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (e = localPoint.x;; e = paramContext.getDefaultDisplay().getWidth()) {
      return e;
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(a(paramContext) * paramFloat + 0.5F);
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView == null)
    {
      SLog.d("Q.qqstory.UIUtils", "setImage view is null");
      return;
    }
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      SLog.d("Q.qqstory.UIUtils", "setImage url is empty");
      return;
    }
    QQStoryContext.a().a().a(paramImageView, paramString, null);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject = null;
    switch (paramInt3)
    {
    }
    for (;;)
    {
      b(paramImageView, paramString, paramInt1, paramInt2, (Transformation)localObject);
      return;
      localObject = new RoundedTransformation(20, 0);
      continue;
      localObject = new CircleTransformation();
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    String str = paramString;
    if (paramString != null) {
      if (!paramString.startsWith("http://"))
      {
        str = paramString;
        if (!paramString.startsWith("https://")) {}
      }
      else
      {
        str = StoryListUtils.a(paramString);
      }
    }
    b(paramImageView, str, paramInt1, paramInt2, paramTransformation);
  }
  
  public static boolean a()
  {
    if (c != -1) {
      if (c != 1) {}
    }
    for (;;)
    {
      return true;
      return false;
      if (Build.VERSION.SDK_INT < 19)
      {
        c = 0;
        if (c != 1) {
          return false;
        }
      }
      else
      {
        String str = Build.MANUFACTURER.toUpperCase();
        if ((str.endsWith("BBK")) || (str.endsWith("VIVO"))) {}
        for (c = 0; c != 1; c = 1) {
          return false;
        }
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    if (f > 0) {
      return f;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (f = localPoint.y;; f = paramContext.getDefaultDisplay().getHeight()) {
      return f;
    }
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    float f1 = FontSettingManager.a() / 16.0F;
    return (int)(a(paramContext) / f1 * paramFloat + 0.5F);
  }
  
  public static void b(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    if (paramImageView == null) {
      return;
    }
    paramInt1 = a(paramImageView.getContext(), paramInt1);
    paramInt2 = a(paramImageView.getContext(), paramInt2);
    QQStoryContext.a().a().a(paramImageView, paramString, paramInt1, paramInt2, paramTransformation);
  }
  
  public static int c(Context paramContext)
  {
    if (d != -1) {
      return d;
    }
    try
    {
      i = ((Integer)Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null)).intValue();
      i = paramContext.getResources().getDimensionPixelSize(i);
      int j = i;
      if (i <= 0) {
        j = a(paramContext, 25.0F);
      }
      d = j;
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.UIUtils", "", localException);
        int i = -1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */