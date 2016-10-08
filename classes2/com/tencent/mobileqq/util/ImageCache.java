package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import vym;

public class ImageCache
{
  private static final int jdField_a_of_type_Int = 5;
  private static final String jdField_a_of_type_JavaLangString = "ImageCache";
  private CustomLruCache jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public ImageCache(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramInt = Math.max(paramInt, 5);
    if (QLog.isColorLevel()) {
      QLog.d("ImageCache", 2, "Memory cache size = " + paramInt + "MB");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache = new vym(this, paramInt * 1024 * 1024);
  }
  
  public Drawable a(String paramString)
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null)
    {
      localObject1 = (Drawable)this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.remove(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((Drawable)localObject1).getConstantState().newDrawable();
        this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.put(paramString, localObject1);
        return (Drawable)localObject1;
      }
    }
    for (;;)
    {
      Object localObject2 = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localObject2 != null)
      {
        localObject2 = (Drawable)((WeakReference)localObject2).get();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        return (Drawable)localObject2;
      }
      return (Drawable)localObject1;
      localObject1 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.evictAll();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.remove(paramString);
    }
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.get(paramString) == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.put(paramString, paramDrawable);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new WeakReference(paramDrawable));
    }
  }
  
  public Drawable b(String paramString)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\ImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */