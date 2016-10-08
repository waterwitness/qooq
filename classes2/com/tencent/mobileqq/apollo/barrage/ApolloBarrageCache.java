package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ApolloBarrageCache
  extends AbsBarrageCache
{
  public ApolloBarrageCache()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Barrage paramBarrage, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBarrage == null) || (TextUtils.isEmpty(paramBarrage.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramBarrage.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramBarrage = str1 + paramBarrage.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramBarrage, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(Barrage paramBarrage)
  {
    if ((paramBarrage == null) || (TextUtils.isEmpty(paramBarrage.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramBarrage.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramBarrage = str1 + paramBarrage.jdField_a_of_type_JavaLangCharSequence;
    paramBarrage = (WeakReference)this.a.get(paramBarrage);
    if (paramBarrage != null) {
      return (Bitmap)paramBarrage.get();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\barrage\ApolloBarrageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */