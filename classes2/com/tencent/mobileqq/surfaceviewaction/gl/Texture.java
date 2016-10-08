package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import uxy;
import uxz;

public class Texture
{
  public static final String a;
  private static LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private SpriteGLView jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
  boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = Texture.class.getName();
  }
  
  public Texture(Context paramContext, SpriteGLView paramSpriteGLView, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_b_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_ArrayOfByte = a(paramString);
      return;
    }
    catch (IOException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramContext));
    }
  }
  
  public Texture(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = true;
    paramSpriteGLView.a(new uxy(this));
  }
  
  private byte[] a(String paramString)
  {
    paramString = new File(paramString);
    long l = paramString.length();
    if (l > 2147483647L) {
      return null;
    }
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    byte[] arrayOfByte = new byte[(int)l];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = localFileInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
      if (j < 0) {
        break;
      }
      i += j;
    }
    if (i != arrayOfByte.length)
    {
      localFileInputStream.close();
      new IOException("Could not completely read file " + paramString.getName());
    }
    localFileInputStream.close();
    return arrayOfByte;
  }
  
  public static void d()
  {
    int[] arrayOfInt = new int[jdField_a_of_type_JavaUtilLinkedList.size()];
    int i = 0;
    while (!jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      arrayOfInt[i] = ((Integer)jdField_a_of_type_JavaUtilLinkedList.remove(0)).intValue();
      i += 1;
    }
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localOptions = new BitmapFactory.Options();
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeByteArray(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length, localOptions);
        int i = (int)(System.currentTimeMillis() - l);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "new Texture: decode time = " + i);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.a(new uxz(this));
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        BitmapFactory.Options localOptions;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Texture: cannot decode (" + this.jdField_b_of_type_JavaLangString + "): " + QLog.getStackTraceString(localOutOfMemoryError));
        continue;
      }
      this.jdField_a_of_type_ArrayOfByte = null;
      return;
      localOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    jdField_a_of_type_JavaUtilLinkedList.add(Integer.valueOf(this.jdField_a_of_type_Int));
    GLES20.glBindTexture(3553, this.jdField_a_of_type_Int);
    GLUtils.texImage2D(3553, 0, this.jdField_a_of_type_AndroidGraphicsBitmap, 0);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9728.0F);
    GLES20.glBindTexture(3553, 0);
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      GLES20.glFlush();
      this.jdField_a_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\gl\Texture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */