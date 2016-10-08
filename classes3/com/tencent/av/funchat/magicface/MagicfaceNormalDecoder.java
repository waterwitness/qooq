package com.tencent.av.funchat.magicface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class MagicfaceNormalDecoder
  extends MagicfaceBaseDecoder
{
  private static final int a = 921600;
  private static final String b = "MagicfaceNormalDecoder";
  
  public MagicfaceNormalDecoder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b("==init==");
  }
  
  private Bitmap a(String paramString, Bitmap paramBitmap)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if (localOptions.outWidth * localOptions.outHeight == 0) {
      return null;
    }
    int i = localOptions.outWidth * localOptions.outHeight;
    if (Build.VERSION.SDK_INT >= 15) {
      localOptions.inBitmap = paramBitmap;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 1;
      while (i > 921600)
      {
        localOptions.inSampleSize *= 2;
        i /= 4;
      }
      if (paramBitmap != null) {
        paramBitmap.recycle();
      }
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      c("getBitmap|decodeFile failed.");
    }
    return null;
  }
  
  protected ArrayList a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals("")))
    {
      c("preLoadFrames|video path is empty");
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData == null)
    {
      c("preLoadFrames|magicfaceData is empty");
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_Int);
    String str = "";
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_Int)
    {
      Bitmap localBitmap = a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_JavaLangString + i + ".png", null);
      if (localBitmap != null) {
        localArrayList.add(localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        str = str + this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_JavaLangString + i + ".png, ";
      }
    }
    if (!str.equals("")) {
      c("preLoadFrames|the follow files load failed:" + str);
    }
    long l2 = System.currentTimeMillis();
    b("preLoadFrames|time cost =" + (l2 - l1));
    return localArrayList;
  }
  
  void b(String paramString)
  {
    QLog.i("MagicfaceNormalDecoder", 2, paramString);
  }
  
  void c(String paramString)
  {
    QLog.e("MagicfaceNormalDecoder", 1, paramString);
  }
  
  public void e()
  {
    long l2 = 0L;
    long l1 = 0L;
    long l4 = 1000 / this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_b_of_type_Int;
    long l3 = 0L;
    int j = this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_Int * this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.c;
    Bitmap localBitmap = null;
    int i = 0;
    for (;;)
    {
      if ((i >= j) || (!this.jdField_a_of_type_Boolean))
      {
        b(String.format("maigcfaceDecoder| readCost=%s(ms), renderCost=%s(ms)", new Object[] { Long.valueOf(l2 / j), Long.valueOf(l1 / j) }));
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        return;
      }
      int k = i % this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_JavaLangString + k + ".png";
      long l5 = System.currentTimeMillis();
      localBitmap = a(str, localBitmap);
      long l6 = System.currentTimeMillis();
      l3 = System.currentTimeMillis() - l3;
      if (l3 < l4) {}
      try
      {
        Thread.sleep(l4 - l3);
        if ((k == this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.d) && (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null))
        {
          this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a(this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_b_of_type_Boolean);
          l3 = System.currentTimeMillis();
          if (localBitmap != null) {
            break label293;
          }
          i += 1;
          l2 += l6 - l5;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          continue;
          if ((k == this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.e) && (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null))
          {
            this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener.c();
            continue;
            label293:
            if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener != null)
            {
              long l7 = System.currentTimeMillis();
              this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener.a(localBitmap, this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_Boolean, false, false, this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData.jdField_a_of_type_AndroidGraphicsRect);
              l1 = System.currentTimeMillis() - l7 + l1;
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    b("==release==");
    super.f();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceNormalDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */