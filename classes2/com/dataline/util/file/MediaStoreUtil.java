package com.dataline.util.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class MediaStoreUtil
{
  public MediaStoreUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    paramInt1 = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    paramInt2 = j / paramInt2;
    if (paramInt1 < paramInt2)
    {
      if (paramInt1 > 0) {
        break label131;
      }
      paramInt1 = i;
    }
    label131:
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt1;
      try
      {
        localObject = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        return (Bitmap)localObject;
      }
      catch (Exception localException)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnail error imagePath is " + paramString);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnail error(OOM)! imagePath is " + paramString);
        return null;
      }
      paramInt1 = paramInt2;
      break;
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 110	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   8: astore_1
    //   9: ldc 104
    //   11: invokestatic 110	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: ldc 116
    //   16: iconst_0
    //   17: anewarray 106	java/lang/Class
    //   20: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   23: astore 4
    //   25: aload 4
    //   27: astore_3
    //   28: aload_1
    //   29: astore_2
    //   30: ldc 104
    //   32: invokestatic 110	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   35: ldc 122
    //   37: iconst_1
    //   38: anewarray 106	java/lang/Class
    //   41: dup
    //   42: iconst_0
    //   43: ldc 37
    //   45: aastore
    //   46: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   49: aload_1
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokevirtual 128	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload 4
    //   64: astore_3
    //   65: aload_1
    //   66: astore_2
    //   67: ldc 104
    //   69: invokestatic 110	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   72: ldc -126
    //   74: iconst_1
    //   75: anewarray 106	java/lang/Class
    //   78: dup
    //   79: iconst_0
    //   80: getstatic 136	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   83: aastore
    //   84: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   87: aload_1
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: bipush 9
    //   96: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokevirtual 128	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 37	java/lang/String
    //   106: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: sipush 1000
    //   112: idiv
    //   113: istore 6
    //   115: aload 4
    //   117: astore_3
    //   118: aload_1
    //   119: astore_2
    //   120: ldc -111
    //   122: iconst_3
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: iload 6
    //   130: sipush 3600
    //   133: idiv
    //   134: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload 6
    //   142: sipush 3600
    //   145: irem
    //   146: bipush 60
    //   148: idiv
    //   149: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: iload 6
    //   157: bipush 60
    //   159: irem
    //   160: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 151	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   167: astore_0
    //   168: aload 4
    //   170: ifnull +14 -> 184
    //   173: aload 4
    //   175: aload_1
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokevirtual 128	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload_0
    //   185: areturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   191: aload_0
    //   192: areturn
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload 5
    //   205: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   208: aload_0
    //   209: ifnull +13 -> 222
    //   212: aload_0
    //   213: aload_1
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokevirtual 128	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_3
    //   237: ifnull +13 -> 250
    //   240: aload_3
    //   241: aload_1
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokevirtual 128	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload_0
    //   251: athrow
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   257: goto -7 -> 250
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -27 -> 236
    //   266: astore_0
    //   267: aload_2
    //   268: astore_1
    //   269: goto -33 -> 236
    //   272: astore 5
    //   274: aconst_null
    //   275: astore_0
    //   276: goto -77 -> 199
    //   279: astore 5
    //   281: aload 4
    //   283: astore_0
    //   284: goto -85 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramString	String
    //   8	168	1	localObject1	Object
    //   186	2	1	localException1	Exception
    //   198	44	1	localObject2	Object
    //   252	2	1	localException2	Exception
    //   268	1	1	localObject3	Object
    //   29	239	2	localObject4	Object
    //   27	236	3	localObject5	Object
    //   23	259	4	localMethod	java.lang.reflect.Method
    //   193	11	5	localException3	Exception
    //   272	1	5	localException4	Exception
    //   279	1	5	localException5	Exception
    //   113	47	6	i	int
    // Exception table:
    //   from	to	target	type
    //   173	184	186	java/lang/Exception
    //   0	9	193	java/lang/Exception
    //   212	222	224	java/lang/Exception
    //   0	9	231	finally
    //   240	250	252	java/lang/Exception
    //   9	25	260	finally
    //   30	62	266	finally
    //   67	115	266	finally
    //   120	168	266	finally
    //   203	208	266	finally
    //   9	25	272	java/lang/Exception
    //   30	62	279	java/lang/Exception
    //   67	115	279	java/lang/Exception
    //   120	168	279	java/lang/Exception
  }
  
  /* Error */
  public static java.util.List a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 157	com/dataline/util/file/MediaStoreUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: invokeinterface 163 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifle +153 -> 172
    //   22: new 165	java/util/ArrayList
    //   25: dup
    //   26: iload_2
    //   27: invokespecial 168	java/util/ArrayList:<init>	(I)V
    //   30: astore_1
    //   31: aload_0
    //   32: ldc 43
    //   34: invokeinterface 171 2 0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 175 1 0
    //   46: ifeq +64 -> 110
    //   49: aload_0
    //   50: iload_2
    //   51: invokeinterface 179 2 0
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -18 -> 40
    //   61: aload_3
    //   62: invokestatic 184	com/dataline/util/file/ImageInfo:a	(Ljava/lang/String;)Lcom/dataline/util/file/ImageInfo;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -27 -> 40
    //   70: aload_1
    //   71: aload_3
    //   72: invokeinterface 190 2 0
    //   77: pop
    //   78: goto -38 -> 40
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_0
    //   86: astore_1
    //   87: aload 4
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   94: aload_0
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +11 -> 108
    //   100: aload_1
    //   101: invokeinterface 193 1 0
    //   106: aload_0
    //   107: astore_3
    //   108: aload_3
    //   109: areturn
    //   110: aload_1
    //   111: astore_3
    //   112: aload_0
    //   113: ifnull -5 -> 108
    //   116: aload_0
    //   117: invokeinterface 193 1 0
    //   122: aload_1
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +9 -> 137
    //   131: aload_0
    //   132: invokeinterface 193 1 0
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: goto -13 -> 127
    //   143: astore_3
    //   144: aload_1
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: goto -21 -> 127
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: astore_1
    //   157: goto -67 -> 90
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: aload_0
    //   165: astore_1
    //   166: aload 4
    //   168: astore_0
    //   169: goto -79 -> 90
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -64 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   0	177	1	paramString	String
    //   0	177	2	paramInt	int
    //   56	16	3	localObject1	Object
    //   81	10	3	localException1	Exception
    //   95	17	3	localObject2	Object
    //   143	4	3	localObject3	Object
    //   151	1	3	localException2	Exception
    //   160	1	3	localException3	Exception
    //   1	166	4	str	String
    // Exception table:
    //   from	to	target	type
    //   31	40	81	java/lang/Exception
    //   40	57	81	java/lang/Exception
    //   61	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   3	11	124	finally
    //   11	18	139	finally
    //   22	31	139	finally
    //   31	40	139	finally
    //   40	57	139	finally
    //   61	66	139	finally
    //   70	78	139	finally
    //   90	94	143	finally
    //   3	11	151	java/lang/Exception
    //   11	18	160	java/lang/Exception
    //   22	31	160	java/lang/Exception
  }
  
  public static void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (JpegExifReader.isCrashJpeg(paramString)) {
          return;
        }
        ExifInterface localExifInterface = new ExifInterface(paramString);
        switch (paramInt)
        {
        case 90: 
          paramString = Integer.toString(1);
          localExifInterface.setAttribute("Orientation", paramString);
          localExifInterface.saveAttributes();
          return;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = Integer.toString(6);
      continue;
      paramString = Integer.toString(3);
      continue;
      paramString = Integer.toString(8);
    }
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    int j = 1;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    int i = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    k /= paramInt2;
    if (i < k)
    {
      if (i > 0) {
        break label146;
      }
      i = j;
    }
    label146:
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        return ThumbnailUtils.extractThumbnail((Bitmap)localObject, paramInt1, paramInt2, 2);
      }
      catch (Exception localException)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnailForSize error imagePath is " + paramString);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnailForSize error(OOM)! imagePath is " + paramString);
        return null;
      }
      i = k;
      break;
    }
  }
  
  /* Error */
  public static java.util.List b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 233	com/dataline/util/file/MediaStoreUtil:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: invokeinterface 163 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifle +153 -> 172
    //   22: new 165	java/util/ArrayList
    //   25: dup
    //   26: iload_2
    //   27: invokespecial 168	java/util/ArrayList:<init>	(I)V
    //   30: astore_1
    //   31: aload_0
    //   32: ldc 43
    //   34: invokeinterface 171 2 0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 175 1 0
    //   46: ifeq +64 -> 110
    //   49: aload_0
    //   50: iload_2
    //   51: invokeinterface 179 2 0
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -18 -> 40
    //   61: aload_3
    //   62: invokestatic 184	com/dataline/util/file/ImageInfo:a	(Ljava/lang/String;)Lcom/dataline/util/file/ImageInfo;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -27 -> 40
    //   70: aload_1
    //   71: aload_3
    //   72: invokeinterface 190 2 0
    //   77: pop
    //   78: goto -38 -> 40
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_0
    //   86: astore_1
    //   87: aload 4
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   94: aload_0
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +11 -> 108
    //   100: aload_1
    //   101: invokeinterface 193 1 0
    //   106: aload_0
    //   107: astore_3
    //   108: aload_3
    //   109: areturn
    //   110: aload_1
    //   111: astore_3
    //   112: aload_0
    //   113: ifnull -5 -> 108
    //   116: aload_0
    //   117: invokeinterface 193 1 0
    //   122: aload_1
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +9 -> 137
    //   131: aload_0
    //   132: invokeinterface 193 1 0
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: goto -13 -> 127
    //   143: astore_3
    //   144: aload_1
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: goto -21 -> 127
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: astore_1
    //   157: goto -67 -> 90
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: aload_0
    //   165: astore_1
    //   166: aload 4
    //   168: astore_0
    //   169: goto -79 -> 90
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -64 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   0	177	1	paramString	String
    //   0	177	2	paramInt	int
    //   56	16	3	localObject1	Object
    //   81	10	3	localException1	Exception
    //   95	17	3	localObject2	Object
    //   143	4	3	localObject3	Object
    //   151	1	3	localException2	Exception
    //   160	1	3	localException3	Exception
    //   1	166	4	str	String
    // Exception table:
    //   from	to	target	type
    //   31	40	81	java/lang/Exception
    //   40	57	81	java/lang/Exception
    //   61	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   3	11	124	finally
    //   11	18	139	finally
    //   22	31	139	finally
    //   31	40	139	finally
    //   40	57	139	finally
    //   61	66	139	finally
    //   70	78	139	finally
    //   90	94	143	finally
    //   3	11	151	java/lang/Exception
    //   11	18	160	java/lang/Exception
    //   22	31	160	java/lang/Exception
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\file\MediaStoreUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */