package com.tencent.biz.pubaccount.subscript;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import ieb;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class SubscriptPicManager
  implements URLDrawable.URLDrawableListener
{
  private static final String jdField_a_of_type_JavaLangString = SubscriptPicManager.class.getSimpleName();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, SubscriptPicManager.ImageHostListener paramImageHostListener)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = URLDrawableHelper.a((String)paramObject, paramInt1, paramInt2);
        if (paramObject != null) {
          break label75;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, ((IllegalArgumentException)paramObject).toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = URLDrawableHelper.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label75:
        if (((URLDrawable)paramObject).getStatus() != 1)
        {
          paramImageView.setTag(2131296523, ((URLDrawable)paramObject).getURL());
          ieb localieb = new ieb(this, null);
          localieb.a = new WeakReference(paramImageView);
          localieb.b = new WeakReference(paramImageHostListener);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramObject, localieb);
          ((URLDrawable)paramObject).setURLDrawableListener(this);
        }
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable((Drawable)paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, SubscriptPicManager.ImageHostListener paramImageHostListener, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = URLDrawableHelper.a((String)paramObject);
        if (paramObject != null) {
          break label69;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, ((IllegalArgumentException)paramObject).toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = URLDrawableHelper.a((URL)paramObject);
        continue;
        label69:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (((URLDrawable)paramObject).getStatus() != 1)
        {
          paramImageView.setTag(2131296523, ((URLDrawable)paramObject).getURL());
          paramImageView.setTag(2131296524, Boolean.TRUE);
          paramImageView.setTag(2131296525, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131296526, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131296527, Integer.valueOf(paramInt3));
          ieb localieb = new ieb(this, null);
          localieb.a = new WeakReference(paramImageView);
          localieb.b = new WeakReference(paramImageHostListener);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramObject, localieb);
          ((URLDrawable)paramObject).setURLDrawableListener(this);
        }
        ((URLDrawable)paramObject).setTag(URLDrawableDecodeHandler.a(paramInt1, paramInt2, (int)(paramInt3 * DeviceInfoUtil.a())));
        ((URLDrawable)paramObject).setDecodeHandler(URLDrawableDecodeHandler.e);
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable((Drawable)paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (paramURLDrawable == null)) {}
    Object localObject;
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (ieb)this.jdField_a_of_type_JavaUtilHashMap.get(paramURLDrawable);
        } while (localObject == null);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramURLDrawable);
        localImageView = (ImageView)((ieb)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131296523))));
      localObject = (SubscriptPicManager.ImageHostListener)((ieb)localObject).b.get();
    } while ((localObject != null) && (!((SubscriptPicManager.ImageHostListener)localObject).a(localImageView)));
    if ((localImageView.getTag(2131296524) != null) && (((Boolean)localImageView.getTag(2131296524)).booleanValue()))
    {
      paramURLDrawable.setTag(URLDrawableDecodeHandler.a(((Integer)localImageView.getTag(2131296525)).intValue(), ((Integer)localImageView.getTag(2131296526)).intValue(), (int)(((Integer)localImageView.getTag(2131296527)).intValue() * DeviceInfoUtil.a())));
      paramURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.e);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131296523, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptPicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */