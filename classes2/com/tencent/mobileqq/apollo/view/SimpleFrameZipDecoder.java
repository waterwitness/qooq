package com.tencent.mobileqq.apollo.view;

import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import ptr;

public class SimpleFrameZipDecoder
  implements Handler.Callback
{
  public static final String a = "SimpleFrameZipDecoder";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  private static final int g = 255;
  public int a;
  private long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected SimpleFrameZipDecoder.IDownloadable a;
  protected SimpleFrameZipDecoder.onFrameDecodeListener a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public String b;
  private boolean b;
  private String c;
  private int f;
  private int h;
  
  public SimpleFrameZipDecoder(SimpleFrameZipDecoder.IDownloadable paramIDownloadable, SimpleFrameZipDecoder.onFrameDecodeListener paramonFrameDecodeListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$IDownloadable = paramIDownloadable;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$onFrameDecodeListener = paramonFrameDecodeListener;
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    int i = 0;
    if (paramBoolean) {}
    try
    {
      a(paramFile, paramString);
      this.jdField_a_of_type_ArrayOfJavaLangString = new File(paramString).list();
      this.jdField_a_of_type_Int = 3;
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0)) {
        while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = (paramString + this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          i += 1;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        b();
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
        {
          this.h = 0;
          this.jdField_b_of_type_Boolean = true;
          new ptr(this, 0).execute(new Integer[] { Integer.valueOf(this.h) });
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
      return;
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.e("SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 3)
    {
      b();
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
      {
        this.h = 0;
        this.jdField_b_of_type_Boolean = true;
        new ptr(this, 0).execute(new Integer[] { Integer.valueOf(this.h) });
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.f = paramInt;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramString2.equals(this.c))
      {
        this.c = paramString2;
        this.jdField_a_of_type_Int = 0;
        b();
        this.jdField_a_of_type_ArrayOfJavaLangString = null;
      }
    } while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0));
    paramString2 = b(this.c);
    this.jdField_b_of_type_JavaLangString = paramString2;
    Object localObject = new File(paramString2);
    ((File)localObject).mkdirs();
    localObject = ((File)localObject).list();
    File localFile = new File(this.c);
    if ((localObject != null) && (localObject.length > 0))
    {
      a(false, localFile, paramString2);
      return;
    }
    if (localFile.exists())
    {
      a(true, localFile, paramString2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$IDownloadable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$IDownloadable.a(this, paramString1, this.c, paramString2);
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    long l2;
    if ((this.jdField_b_of_type_Boolean) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      long l1 = System.currentTimeMillis();
      l2 = l1 - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      if (l2 <= this.f) {
        break label77;
      }
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(255, this.h, 0).sendToTarget();
    }
    for (;;)
    {
      this.h = (paramInt + 1);
      return;
      label77:
      paramBitmap = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(255, this.h, 0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramBitmap, this.f - l2);
    }
  }
  
  protected void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      ZipUtils.a(paramFile, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleFrameZipDecoder", 2, "onDownloadFinish，result:" + paramBoolean + " url:" + paramString1 + " zipFile:" + paramString2 + " folder:" + paramString3);
    }
    if ((this.c != null) && (!this.c.equals(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "onDownloadFinish，zipFile unEqual mLocalZipPath:" + this.c);
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  protected String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.substring(0, paramString.lastIndexOf(".zip"));
      return paramString + File.separator;
    }
    return "";
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
    } while (!this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$onFrameDecodeListener == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$onFrameDecodeListener.a(paramMessage.arg1, this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > this.h)) {
      new ptr(this, this.h).execute(new Integer[] { Integer.valueOf(this.h) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      break;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$onFrameDecodeListener.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\SimpleFrameZipDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */