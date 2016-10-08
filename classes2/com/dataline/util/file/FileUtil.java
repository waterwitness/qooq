package com.dataline.util.file;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil
{
  public FileUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 30
    //   3: invokestatic 34	com/dataline/util/file/FileUtil:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: invokestatic 39	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   11: ifeq +5 -> 16
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 45	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc 46
    //   22: invokestatic 52	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic 57	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   31: pop
    //   32: aload_0
    //   33: ifnull +48 -> 81
    //   36: aload_0
    //   37: invokevirtual 62	android/graphics/Bitmap:recycle	()V
    //   40: aload_1
    //   41: areturn
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 65	java/io/FileNotFoundException:printStackTrace	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 67	java/lang/OutOfMemoryError:printStackTrace	()V
    //   65: aload_1
    //   66: areturn
    //   67: astore_0
    //   68: goto -7 -> 61
    //   71: astore_0
    //   72: goto -20 -> 52
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -35 -> 43
    //   81: aload_1
    //   82: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    //   6	76	1	str	String
    // Exception table:
    //   from	to	target	type
    //   7	14	42	java/io/FileNotFoundException
    //   16	32	42	java/io/FileNotFoundException
    //   36	40	42	java/io/FileNotFoundException
    //   0	7	49	java/io/IOException
    //   0	7	58	java/lang/OutOfMemoryError
    //   7	14	67	java/lang/OutOfMemoryError
    //   16	32	67	java/lang/OutOfMemoryError
    //   36	40	67	java/lang/OutOfMemoryError
    //   7	14	71	java/io/IOException
    //   16	32	71	java/io/IOException
    //   36	40	71	java/io/IOException
    //   0	7	75	java/io/FileNotFoundException
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Context localContext2 = null;
    Context localContext1 = null;
    Bitmap localBitmap = MediaStoreUtil.a(paramString, 150, 150);
    if (localBitmap == null) {
      return null;
    }
    try
    {
      paramContext = c(paramContext, paramString);
      localContext1 = paramContext;
      localContext2 = paramContext;
      com.tencent.mobileqq.filemanager.util.FileUtil.a(localBitmap, paramContext);
      localContext1 = paramContext;
      localContext2 = paramContext;
      MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return localContext1;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localContext2;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    Bitmap localBitmap = MediaStoreUtil.b(paramString1, 157, 157);
    if (localBitmap == null) {}
    while (paramString2 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (!paramString2.isEmpty()) {
          continue;
        }
        paramContext = c(paramContext, paramString1);
        com.tencent.mobileqq.filemanager.util.FileUtil.a(localBitmap, paramContext);
        localBitmap.recycle();
        MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString1));
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        paramContext = null;
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        paramContext = null;
        continue;
      }
      return paramContext;
      paramContext = paramString2;
    }
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    paramFile.delete();
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: invokevirtual 107	java/io/File:isFile	()Z
    //   13: ifeq +87 -> 100
    //   16: aload_1
    //   17: invokevirtual 110	java/io/File:exists	()Z
    //   20: ifeq +8 -> 28
    //   23: aload_1
    //   24: invokevirtual 103	java/io/File:delete	()Z
    //   27: pop
    //   28: new 112	java/io/FileOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_2
    //   37: new 116	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: ldc 118
    //   48: newarray <illegal type>
    //   50: astore 4
    //   52: aload_3
    //   53: aload 4
    //   55: invokevirtual 122	java/io/FileInputStream:read	([B)I
    //   58: istore 7
    //   60: iload 7
    //   62: iconst_m1
    //   63: if_icmpeq +133 -> 196
    //   66: aload_2
    //   67: aload 4
    //   69: iconst_0
    //   70: iload 7
    //   72: invokevirtual 126	java/io/FileOutputStream:write	([BII)V
    //   75: aload_2
    //   76: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   79: goto -27 -> 52
    //   82: astore 4
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 133	java/io/FileInputStream:close	()V
    //   100: aload_0
    //   101: invokevirtual 94	java/io/File:isDirectory	()Z
    //   104: ifeq +139 -> 243
    //   107: aload_0
    //   108: invokevirtual 98	java/io/File:listFiles	()[Ljava/io/File;
    //   111: astore_0
    //   112: aload_1
    //   113: invokevirtual 136	java/io/File:mkdir	()Z
    //   116: pop
    //   117: iload 6
    //   119: aload_0
    //   120: arraylength
    //   121: if_icmpge +122 -> 243
    //   124: aload_0
    //   125: iload 6
    //   127: aaload
    //   128: invokevirtual 140	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   131: new 91	java/io/File
    //   134: dup
    //   135: new 142	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   142: aload_1
    //   143: invokevirtual 140	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   146: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: getstatic 151	java/io/File:separator	Ljava/lang/String;
    //   152: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: iload 6
    //   158: aaload
    //   159: invokevirtual 158	java/io/File:getName	()Ljava/lang/String;
    //   162: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: invokestatic 166	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   174: pop
    //   175: iload 6
    //   177: iconst_1
    //   178: iadd
    //   179: istore 6
    //   181: goto -64 -> 117
    //   184: astore 4
    //   186: sipush 4096
    //   189: newarray <illegal type>
    //   191: astore 4
    //   193: goto -141 -> 52
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   204: aload_3
    //   205: ifnull -105 -> 100
    //   208: aload_3
    //   209: invokevirtual 133	java/io/FileInputStream:close	()V
    //   212: goto -112 -> 100
    //   215: astore_2
    //   216: goto -116 -> 100
    //   219: astore_0
    //   220: aconst_null
    //   221: astore_2
    //   222: aload 4
    //   224: astore_1
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 133	java/io/FileInputStream:close	()V
    //   241: aload_0
    //   242: athrow
    //   243: iconst_1
    //   244: ireturn
    //   245: astore_2
    //   246: goto -42 -> 204
    //   249: astore_2
    //   250: goto -158 -> 92
    //   253: astore_2
    //   254: goto -154 -> 100
    //   257: astore_2
    //   258: goto -25 -> 233
    //   261: astore_1
    //   262: goto -21 -> 241
    //   265: astore_0
    //   266: aload 4
    //   268: astore_1
    //   269: goto -44 -> 225
    //   272: astore_0
    //   273: aload_3
    //   274: astore_1
    //   275: goto -50 -> 225
    //   278: astore_2
    //   279: aconst_null
    //   280: astore_2
    //   281: aload 5
    //   283: astore_3
    //   284: goto -200 -> 84
    //   287: astore_3
    //   288: aload 5
    //   290: astore_3
    //   291: goto -207 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramFile1	File
    //   0	294	1	paramFile2	File
    //   36	165	2	localFileOutputStream	java.io.FileOutputStream
    //   215	1	2	localIOException1	IOException
    //   221	9	2	localObject1	Object
    //   245	1	2	localIOException2	IOException
    //   249	1	2	localIOException3	IOException
    //   253	1	2	localIOException4	IOException
    //   257	1	2	localIOException5	IOException
    //   278	1	2	localIOException6	IOException
    //   280	1	2	localObject2	Object
    //   45	239	3	localObject3	Object
    //   287	1	3	localIOException7	IOException
    //   290	1	3	localObject4	Object
    //   1	67	4	arrayOfByte1	byte[]
    //   82	1	4	localIOException8	IOException
    //   184	1	4	localOutOfMemoryError	OutOfMemoryError
    //   191	76	4	arrayOfByte2	byte[]
    //   4	285	5	localObject5	Object
    //   7	173	6	i	int
    //   58	13	7	j	int
    // Exception table:
    //   from	to	target	type
    //   46	52	82	java/io/IOException
    //   52	60	82	java/io/IOException
    //   66	79	82	java/io/IOException
    //   186	193	82	java/io/IOException
    //   46	52	184	java/lang/OutOfMemoryError
    //   208	212	215	java/io/IOException
    //   16	28	219	finally
    //   28	37	219	finally
    //   200	204	245	java/io/IOException
    //   88	92	249	java/io/IOException
    //   96	100	253	java/io/IOException
    //   229	233	257	java/io/IOException
    //   237	241	261	java/io/IOException
    //   37	46	265	finally
    //   46	52	272	finally
    //   52	60	272	finally
    //   66	79	272	finally
    //   186	193	272	finally
    //   16	28	278	java/io/IOException
    //   28	37	278	java/io/IOException
    //   37	46	287	java/io/IOException
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Bitmap localBitmap;
    if (FileManagerUtil.a(paramString) == 0) {
      localBitmap = MediaStoreUtil.a(paramString, 150, 150);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        return null;
        if (FileManagerUtil.a(paramString) == 2) {
          localBitmap = MediaStoreUtil.c(paramString, 150, 150);
        }
      }
      else
      {
        try
        {
          paramContext = c(paramContext, paramString);
          localBitmap = null;
        }
        catch (FileNotFoundException paramString)
        {
          for (;;)
          {
            try
            {
              com.tencent.mobileqq.filemanager.util.FileUtil.a(localBitmap, paramContext);
              localBitmap.recycle();
              MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
              return paramContext;
            }
            catch (IOException paramString)
            {
              continue;
            }
            catch (FileNotFoundException paramString)
            {
              continue;
            }
            paramString = paramString;
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (OutOfMemoryError paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
      }
    }
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + FileManagerUtil.a(paramString1) + "." + paramString2 + ".JPG";
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    if (a(paramFile1, paramFile2))
    {
      a(paramFile1);
      return true;
    }
    return false;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + FileManagerUtil.a(paramString) + ".JPG";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\file\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */