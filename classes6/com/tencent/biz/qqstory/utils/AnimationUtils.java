package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class AnimationUtils
{
  public static final String a = "positionX";
  public static final String b = "positionY";
  public static final String c = "viewWidth";
  public static final String d = "viewHeight";
  public static final String e = "viewImageKey";
  public static final String f = "need_image_animation";
  
  public AnimationUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Intent a(Intent paramIntent, View paramView)
  {
    if ((paramIntent != null) && (paramView != null))
    {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[4];
      paramView.getLocationOnScreen(arrayOfInt1);
      arrayOfInt2[0] = arrayOfInt1[0];
      arrayOfInt2[1] = arrayOfInt1[1];
      arrayOfInt2[2] = paramView.getWidth();
      arrayOfInt2[3] = paramView.getHeight();
      paramIntent.putExtra("positionX", arrayOfInt2[0]);
      paramIntent.putExtra("positionY", arrayOfInt2[1]);
      paramIntent.putExtra("viewWidth", arrayOfInt2[2]);
      paramIntent.putExtra("viewHeight", arrayOfInt2[3]);
    }
    return paramIntent;
  }
  
  public static Intent a(Intent paramIntent, View paramView, String paramString)
  {
    if ((paramIntent != null) && (paramView != null))
    {
      Object localObject = new int[2];
      int[] arrayOfInt = new int[4];
      paramView.getLocationOnScreen((int[])localObject);
      arrayOfInt[0] = localObject[0];
      arrayOfInt[1] = localObject[1];
      arrayOfInt[2] = paramView.getWidth();
      arrayOfInt[3] = paramView.getHeight();
      paramIntent.putExtra("positionX", arrayOfInt[0]);
      paramIntent.putExtra("positionY", arrayOfInt[1]);
      paramIntent.putExtra("viewWidth", arrayOfInt[2]);
      paramIntent.putExtra("viewHeight", arrayOfInt[3]);
      localObject = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180);
      ((QQStoryManager)localObject).jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramView);
      if (!TextUtils.isEmpty(paramString))
      {
        paramView = BitmapUtils.a(paramView, arrayOfInt[2], arrayOfInt[3], 0, 0);
        if (paramView != null)
        {
          ((QQStoryManager)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new SoftReference(paramView));
          paramIntent.putExtra("viewImageKey", paramString);
        }
      }
    }
    return paramIntent;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, View paramView)
  {
    a(paramIntent, paramView, paramView.getClass().getSimpleName());
    paramIntent.putExtra("need_image_animation", true);
    paramActivity.startActivity(paramIntent);
    paramActivity.overridePendingTransition(2130968750, 0);
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, View paramView, int paramInt, String paramString)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramView == null)) {
      return false;
    }
    paramActivity.startActivityForResult(a(paramIntent, paramView, paramString), paramInt);
    paramActivity.overridePendingTransition(0, 0);
    return true;
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, View paramView, String paramString)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramView == null)) {
      return false;
    }
    paramActivity.startActivity(a(paramIntent, paramView, paramString));
    paramActivity.overridePendingTransition(0, 0);
    return true;
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, View paramView)
  {
    if ((paramIntent != null) && (paramView != null))
    {
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      paramIntent.putExtra("positionX", 0);
      paramIntent.putExtra("positionY", paramActivity.getResources().getDisplayMetrics().heightPixels - j);
      paramIntent.putExtra("viewWidth", i);
      paramIntent.putExtra("viewHeight", j);
      paramIntent.putExtra("need_image_animation", true);
    }
    paramActivity.startActivity(paramIntent);
    paramActivity.overridePendingTransition(2130968750, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\AnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */