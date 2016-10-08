package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.PaFlashLightView;
import com.tencent.mobileqq.widget.PaParticleView;
import java.lang.ref.WeakReference;

public class PaWeatherItemFactory
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  Drawable b;
  Drawable c;
  
  public PaWeatherItemFactory(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839514);
    this.c = paramContext.getResources().getDrawable(2131427379);
    this.b = paramContext.getResources().getDrawable(2130839519);
  }
  
  private void a(String paramString, FrameLayout paramFrameLayout, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject1 == null);
    URLImageView localURLImageView = new URLImageView((Context)localObject1);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    try
    {
      localURLImageView.setImageDrawable(URLDrawableHelper.a(paramString, this.c, this.c));
      Object localObject2 = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 48;
      ((FrameLayout.LayoutParams)localObject2).setMargins(0, paramInt2, 0, 0);
      localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramFrameLayout.addView(localURLImageView);
      localObject2 = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
      ((TranslateAnimation)localObject2).setDuration(paramInt1);
      ((TranslateAnimation)localObject2).setRepeatCount(-1);
      ((TranslateAnimation)localObject2).setRepeatMode(1);
      localURLImageView.startAnimation((Animation)localObject2);
      localObject1 = new URLImageView((Context)localObject1);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    catch (Exception localException)
    {
      try
      {
        ((URLImageView)localObject1).setImageDrawable(URLDrawableHelper.a(paramString, this.c, this.c));
        paramString = new FrameLayout.LayoutParams(-1, -2);
        paramString.gravity = 48;
        paramString.setMargins(0, paramInt2, 0, 0);
        ((URLImageView)localObject1).setLayoutParams(paramString);
        paramFrameLayout.addView((View)localObject1);
        paramString = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        paramString.setDuration(paramInt1);
        paramString.setRepeatCount(-1);
        paramString.setRepeatMode(1);
        ((URLImageView)localObject1).startAnimation(paramString);
        return;
        localException = localException;
        localException.printStackTrace();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, FrameLayout paramFrameLayout, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Context localContext;
    String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  } while (localContext == null);
                  arrayOfString = a(paramString);
                } while ((arrayOfString == null) || (arrayOfString.length <= 1));
                if (paramBoolean2) {}
                for (;;)
                {
                  try
                  {
                    localObject = URLDrawableHelper.a(arrayOfString[0] + arrayOfString[1] + "#10", paramInt2, paramInt3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false, 0.0F);
                    paramString = (String)localObject;
                    try
                    {
                      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(paramInt2, paramInt3, (int)(10.0F * DeviceInfoUtil.a())));
                      paramString = (String)localObject;
                      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.c);
                      if (localObject == null) {
                        continue;
                      }
                      paramFrameLayout.setBackgroundDrawable((Drawable)localObject);
                      if (!paramBoolean1) {
                        break;
                      }
                      switch (paramInt1)
                      {
                      default: 
                        return;
                      }
                    }
                    catch (Exception localException1) {}
                    if (arrayOfString.length < 2) {
                      break;
                    }
                    localObject = new URLImageView(localContext);
                    paramString = new FrameLayout.LayoutParams(-1, -1);
                    paramString.gravity = 48;
                    paramString.setMargins(0, 0, 0, 0);
                    ((URLImageView)localObject).setLayoutParams(paramString);
                    paramFrameLayout.addView((View)localObject);
                    paramString = null;
                  }
                  catch (Exception localException2)
                  {
                    Object localObject;
                    String str;
                    paramString = null;
                    continue;
                  }
                  try
                  {
                    paramFrameLayout = URLDrawableHelper.a(arrayOfString[0] + arrayOfString[2], this.c, this.c);
                    paramString = paramFrameLayout;
                    paramFrameLayout.setTag(URLDrawableDecodeHandler.a(40, 40, (int)(2.0F * DeviceInfoUtil.a())));
                    paramString = paramFrameLayout;
                    paramFrameLayout.setDecodeHandler(URLDrawableDecodeHandler.d);
                    paramString = paramFrameLayout;
                  }
                  catch (Exception paramFrameLayout)
                  {
                    paramFrameLayout.printStackTrace();
                    continue;
                  }
                  if (paramString != null)
                  {
                    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
                    ((URLImageView)localObject).setImageDrawable(paramString);
                  }
                  paramString = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 2, 1.0F, 2, 0.0F);
                  paramString.setDuration(6000L);
                  paramString.setRepeatCount(-1);
                  paramString.setRepeatMode(2);
                  ((URLImageView)localObject).startAnimation(paramString);
                  return;
                  localObject = URLDrawableHelper.a(arrayOfString[0] + arrayOfString[1] + "#9", paramInt2, paramInt3, this.b, this.b, false, 0.0F);
                  paramString = (String)localObject;
                  ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(paramInt2, paramInt3, (int)(9.0F * DeviceInfoUtil.a())));
                  paramString = (String)localObject;
                  ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
                  continue;
                  localException1.printStackTrace();
                  str = paramString;
                  continue;
                  if (paramBoolean2) {
                    paramFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                  } else {
                    paramFrameLayout.setBackgroundDrawable(this.b);
                  }
                }
              } while (arrayOfString.length < 4);
              a(arrayOfString[0] + arrayOfString[2], paramFrameLayout, 8000, (int)(-paramInt3 * 0.18D));
              a(arrayOfString[0] + arrayOfString[3], paramFrameLayout, 16000, (int)(-paramInt3 * 0.18D));
              return;
            } while (arrayOfString.length < 4);
            a(arrayOfString[0] + arrayOfString[2], paramFrameLayout, 10000, (int)(-paramInt3 * 0.04D));
            a(arrayOfString[0] + arrayOfString[3], paramFrameLayout, 16000, (int)(paramInt3 * 0.03D));
            return;
          } while (arrayOfString.length < 5);
          paramString = new PaParticleView(localContext, 3, 400, -3, 100, 100);
          paramString.c = paramInt2;
          paramString.d = paramInt3;
          paramString.a(0.3F, 0.2F, 50, 20, 0, 2130839517);
          paramFrameLayout.addView(paramString);
          paramString = new PaFlashLightView(localContext, paramInt2, paramInt3, arrayOfString[0] + arrayOfString[2], arrayOfString[0] + arrayOfString[3], arrayOfString[0] + arrayOfString[4]);
          paramFrameLayout.addView(paramString);
          paramString.a(true, 2);
          paramFrameLayout.setTag(paramString);
          return;
          paramString = new PaParticleView(localContext, 3, 1000, -1, 80, 100);
          paramString.c = paramInt2;
          paramString.d = paramInt3;
          paramString.a(0.3F, 0.25F, 20, 3, 0, 2130839520);
          paramFrameLayout.addView(paramString);
          return;
        } while (arrayOfString.length < 4);
        a(arrayOfString[0] + arrayOfString[2], paramFrameLayout, 5000, (int)(paramInt3 * 0.28D));
        a(arrayOfString[0] + arrayOfString[3], paramFrameLayout, 13000, (int)(paramInt3 * 0.28D));
        return;
      } while (arrayOfString.length < 4);
      a(arrayOfString[0] + arrayOfString[2], paramFrameLayout, 6000, (int)(paramInt3 * 0.03D));
      a(arrayOfString[0] + arrayOfString[3], paramFrameLayout, 12000, (int)(paramInt3 * 0.04D));
      return;
    } while (arrayOfString.length < 4);
    a(arrayOfString[0] + arrayOfString[2], paramFrameLayout, 4000, (int)(-paramInt3 * 0.04D));
    a(arrayOfString[0] + arrayOfString[3], paramFrameLayout, 8000, (int)(paramInt3 * 0.03D));
    paramString = new PaParticleView(localContext, 1, 50, -1, 300, 100);
    paramString.c = paramInt2;
    paramString.d = paramInt3;
    paramString.a(0.5F, 0.0F, -5, 1, paramInt3 / 2, 2130839515);
    paramFrameLayout.addView(paramString);
  }
  
  public String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split("\\|");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\PaWeatherItemFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */