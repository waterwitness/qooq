package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VideoFileUtil
{
  private static final String PIC_POSTFIX_JPEG = ".jpg";
  private static final String PIC_POSTFIX_PNG = ".png";
  private static final String PIC_POSTFIX_WEBP = ".webp";
  private static final String TAG = VideoFileUtil.class.getSimpleName();
  
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramContext = paramContext.getAssets();
    try
    {
      InputStream localInputStream1 = paramContext.open(paramString);
      IOUtils.closeQuietly(localInputStream1);
      return paramString;
    }
    catch (IOException localIOException1)
    {
      localIOException1 = localIOException1;
      IOUtils.closeQuietly(null);
      if (paramString.lastIndexOf(".") != -1) {
        paramString = paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp";
      }
    }
    finally
    {
      try
      {
        paramContext = paramContext.open(paramString);
        IOUtils.closeQuietly(paramContext);
        return paramString;
      }
      catch (IOException paramContext)
      {
        paramContext = paramContext;
        IOUtils.closeQuietly(null);
        return null;
      }
      finally
      {
        paramContext = finally;
        IOUtils.closeQuietly(null);
        throw paramContext;
      }
      paramContext = finally;
      IOUtils.closeQuietly(null);
      throw paramContext;
    }
    String str1 = paramString + ".jpg";
    try
    {
      localInputStream2 = paramContext.open(str1);
      IOUtils.closeQuietly(localInputStream2);
      return str1;
    }
    catch (IOException localIOException2)
    {
      localIOException2 = localIOException2;
      IOUtils.closeQuietly(null);
      str2 = paramString + ".webp";
    }
    finally
    {
      try
      {
        String str2;
        InputStream localInputStream2 = paramContext.open(str2);
        IOUtils.closeQuietly(localInputStream2);
        return str2;
      }
      catch (IOException localIOException3)
      {
        localIOException3 = localIOException3;
        IOUtils.closeQuietly(null);
        paramString = paramString + ".png";
      }
      finally
      {
        try
        {
          paramContext = paramContext.open(paramString);
          IOUtils.closeQuietly(paramContext);
          return paramString;
        }
        catch (IOException paramContext)
        {
          paramContext = paramContext;
          IOUtils.closeQuietly(null);
          return null;
        }
        finally
        {
          paramContext = finally;
          IOUtils.closeQuietly(null);
          throw paramContext;
        }
        paramContext = finally;
        IOUtils.closeQuietly(null);
        throw paramContext;
      }
      paramContext = finally;
      IOUtils.closeQuietly(null);
      throw paramContext;
    }
  }
  
  public static String checkPhoto(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (new File(paramString).exists());
        str1 = paramString;
      } while (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") != -1);
      str1 = paramString + ".jpg";
      if (new File(str1).exists()) {
        return str1;
      }
      str2 = paramString + ".png";
      str1 = paramString;
    } while (!new File(str2).exists());
    return str2;
  }
  
  public static void deleteFiles(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1).listFiles(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          if (TextUtils.isEmpty(this.val$suffix)) {
            return true;
          }
          return paramAnonymousString.endsWith(this.val$suffix);
        }
      });
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramString1[i].delete();
        i += 1;
      }
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.contains("assets")) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static String load(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new 126	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual 133	java/io/File:length	()J
    //   20: l2i
    //   21: newarray <illegal type>
    //   23: astore_0
    //   24: aload_1
    //   25: aload_0
    //   26: invokevirtual 139	java/io/InputStream:read	([B)I
    //   29: pop
    //   30: new 63	java/lang/String
    //   33: dup
    //   34: aload_0
    //   35: ldc -115
    //   37: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_0
    //   41: aload_1
    //   42: invokestatic 59	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: aload_3
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 59	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_1
    //   57: aload 4
    //   59: astore_0
    //   60: aload_0
    //   61: astore_2
    //   62: getstatic 27	com/tencent/ttpic/util/VideoFileUtil:TAG	Ljava/lang/String;
    //   65: aload_1
    //   66: invokevirtual 145	java/lang/Exception:toString	()Ljava/lang/String;
    //   69: invokestatic 151	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: aload_0
    //   74: invokestatic 59	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   77: goto -23 -> 54
    //   80: astore_0
    //   81: aload_2
    //   82: invokestatic 59	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: aload_1
    //   89: astore_2
    //   90: goto -9 -> 81
    //   93: astore_2
    //   94: aload_1
    //   95: astore_0
    //   96: aload_2
    //   97: astore_1
    //   98: goto -38 -> 60
    //   101: astore_0
    //   102: aload_1
    //   103: astore_0
    //   104: goto -54 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   15	27	1	localFileInputStream	java.io.FileInputStream
    //   56	39	1	localException1	Exception
    //   97	6	1	localException2	Exception
    //   4	86	2	localObject1	Object
    //   93	4	2	localException3	Exception
    //   6	43	3	localObject2	Object
    //   1	57	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	47	java/io/FileNotFoundException
    //   7	16	56	java/lang/Exception
    //   7	16	80	finally
    //   62	73	80	finally
    //   16	41	87	finally
    //   16	41	93	java/lang/Exception
    //   16	41	101	java/io/FileNotFoundException
  }
  
  public static String load(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (paramString1.startsWith("assets://")) {
      return loadAssetsString(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString1) + File.separator + paramString2);
    }
    return load(new File(paramString1 + File.separator + paramString2));
  }
  
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramContext = new BufferedReader(new InputStreamReader(paramContext.getAssets().open(paramString), "UTF-8"));
      for (;;)
      {
        paramString = paramContext.readLine();
        if (paramString == null) {
          break;
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramContext)
    {
      paramContext = paramContext;
      paramContext.printStackTrace();
      return localStringBuilder.toString();
      paramContext.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static void loadImageView(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (paramString == null)) {}
    do
    {
      return;
      if (paramString.startsWith("assets://")) {
        try
        {
          paramImageView.setImageDrawable(Drawable.createFromStream(VideoGlobalContext.getContext().getAssets().open(VideoUtil.getRealPath(paramString)), null));
          return;
        }
        catch (IOException paramImageView)
        {
          return;
        }
      }
      paramString = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), Integer.MAX_VALUE, Integer.MAX_VALUE);
    } while (!VideoBitmapUtil.isLegal(paramString));
    paramImageView.setImageBitmap(paramString);
  }
  
  public static String loadResourceString(String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(VideoFileUtil.class.getResourceAsStream(paramString), "UTF-8"));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramString)
    {
      paramString = paramString;
      paramString.printStackTrace();
      return localStringBuilder.toString();
      paramString.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */