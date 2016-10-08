package com.tencent.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.util.FileEncryptUtils;
import com.tencent.util.IOUtils;
import com.tencent.util.LogUtil;
import com.tencent.view.raw.FilterRawGet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterDefault
{
  public static boolean ENABLE_DEBUG = false;
  public static boolean ENABLE_PROFILE = true;
  public static boolean ENABLE＿ASSERT;
  public static int currentShareIndex = -1;
  private static FilterRawGet maim_Raw = new FilterRawGet();
  public static Context main_Context;
  
  static
  {
    ENABLE＿ASSERT = false;
  }
  
  public static Bitmap decodeBitmap(int paramInt)
  {
    Object localObject2 = main_Context.getResources().openRawResource(paramInt);
    Object localObject1 = FileEncryptUtils.decryptFile((InputStream)localObject2);
    IOUtils.closeQuietly((InputStream)localObject2);
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      return (Bitmap)localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public static Bitmap decodeBitmap(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      InputStream localInputStream = getInputStreamByName(paramString);
      if (localInputStream == null)
      {
        localObject1 = localObject2;
        LogUtil.e("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LogUtil.e("FilterDefault", "decodeBitmap  getStream", paramString);
        paramString = (String)localObject1;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
      try
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject1);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        LogUtil.e("FilterDefault", "decodeByteArray", paramString);
      }
    }
    if (paramString == null) {
      return null;
    }
    return null;
  }
  
  public static Bitmap decodeBitmap(String paramString, Bitmap.Config paramConfig)
  {
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      InputStream localInputStream = getInputStreamByName(paramString);
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    if (paramString == null) {
      return null;
    }
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inPreferredConfig = paramConfig;
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject1);
  }
  
  public static Bitmap decodeBitmap(String paramString, Bitmap.Config paramConfig, int paramInt1, int paramInt2)
  {
    Paint localPaint = null;
    localObject = localPaint;
    try
    {
      InputStream localInputStream = getInputStreamByName(paramString);
      localObject = localPaint;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
    if (paramString == null) {
      return null;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = paramConfig;
    paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject);
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramConfig);
    localPaint = new Paint(6);
    ((Canvas)localObject).drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
    paramString.recycle();
    return paramConfig;
  }
  
  public static int decodeBitmap2Texture(String paramString)
  {
    int i = 0;
    paramString = decodeBitmap(paramString);
    if (paramString != null)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLUtils.texImage2D(3553, 0, paramString, 0);
      paramString.recycle();
      i = arrayOfInt[0];
    }
    return i;
  }
  
  public static Bitmap decodeBitmapOutside(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null)
      {
        localObject1 = localObject2;
        LogUtil.e("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localFileInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localFileInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LogUtil.e("FilterDefault", "decodeBitmap  getStream", paramString);
        paramString = (String)localObject1;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
      try
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject1);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        LogUtil.e("FilterDefault", "decodeByteArray", paramString);
      }
    }
    if (paramString == null) {
      return null;
    }
    return null;
  }
  
  public static InputStream getInputStreamByName(String paramString)
  {
    if (ENABLE＿ASSERT)
    {
      AssetManager localAssetManager = main_Context.getAssets();
      try
      {
        paramString = localAssetManager.open(paramString);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString = paramString;
        return null;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    return maim_Raw.getInpuStream(paramString);
  }
  
  public static void initResource()
  {
    IOUtils.closeQuietly(getInputStreamByName("pro.png"));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\view\FilterDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */