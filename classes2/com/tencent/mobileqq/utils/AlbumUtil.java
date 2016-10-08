package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AlbumUtil
{
  public static final int a = 20;
  public static final long a = 60000L;
  public static String a;
  public static HashMap a;
  private static List jdField_a_of_type_JavaUtilList;
  private static Map jdField_a_of_type_JavaUtilMap;
  public static final int[] a;
  static String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final int b = -1;
  public static final long b = 293601280L;
  public static String b;
  public static HashMap b;
  private static String[] b;
  public static final int c = 0;
  public static long c = 0L;
  public static String c;
  public static HashMap c;
  public static final int d = 1;
  private static long d = 0L;
  public static final String d = "album_file";
  public static final HashMap d;
  private static final int e = 65535;
  public static final String e = "album_key_id";
  private static final int f = 65535;
  public static final String f = "album_key_name";
  private static final String g;
  private static final String h = "_id DESC";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    g = AlbumUtil.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_d_of_type_JavaUtilHashMap = new HashMap();
    jdField_d_of_type_JavaUtilHashMap.put("image", Integer.valueOf(0));
    jdField_d_of_type_JavaUtilHashMap.put("video", Integer.valueOf(1));
    jdField_d_of_type_JavaUtilHashMap.put("mobileqq", Integer.valueOf(2));
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3000, 1 };
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "_size", "width", "height" }; Build.VERSION.SDK_INT >= 16; jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "_size" })
    {
      jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" };
      return;
    }
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
  }
  
  /* Error */
  public static int a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 4
    //   9: aconst_null
    //   10: invokevirtual 140	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokeinterface 146 1 0
    //   22: ifeq +27 -> 49
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: iconst_0
    //   29: invokeinterface 150 2 0
    //   34: istore 5
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokeinterface 153 1 0
    //   46: iload 5
    //   48: ireturn
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokeinterface 153 1 0
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +14 -> 83
    //   72: aload_1
    //   73: astore_0
    //   74: ldc -96
    //   76: iconst_2
    //   77: ldc -94
    //   79: aload_2
    //   80: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_1
    //   84: ifnull -25 -> 59
    //   87: aload_1
    //   88: invokeinterface 153 1 0
    //   93: goto -34 -> 59
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +9 -> 109
    //   103: aload_0
    //   104: invokeinterface 153 1 0
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: goto -13 -> 99
    //   115: astore_2
    //   116: goto -52 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   0	119	1	paramUri	Uri
    //   0	119	2	paramArrayOfString1	String[]
    //   0	119	3	paramString	String
    //   0	119	4	paramArrayOfString2	String[]
    //   34	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   0	14	61	java/lang/Throwable
    //   0	14	96	finally
    //   16	25	111	finally
    //   27	36	111	finally
    //   66	72	111	finally
    //   74	83	111	finally
    //   16	25	115	java/lang/Throwable
    //   27	36	115	java/lang/Throwable
  }
  
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = MimeHelper.a(paramLocalMediaInfo.jdField_b_of_type_JavaLangString);
    if (paramLocalMediaInfo == null) {
      return 0;
    }
    return ((Integer)jdField_d_of_type_JavaUtilHashMap.get(paramLocalMediaInfo[0])).intValue();
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, jdField_a_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo)
  {
    return a(paramLocalMediaInfo, null);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumb");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public static URL a(String paramString)
  {
    Object localObject1 = new File(paramString);
    do
    {
      try
      {
        localObject1 = ((File)localObject1).toURL();
        String str;
        Object localObject2 = localObject1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          str = ((URL)localObject1).toString();
          localObject2 = new URL(str + "?thumb=true");
          return (URL)localObject2;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          continue;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SelectPhotoTrace", 2, "path is:" + paramString + ",path->url failed", localMalformedURLException1);
    return (URL)localObject1;
  }
  
  private static ArrayList a(Context paramContext, Cursor paramCursor, List paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean)
  {
    paramContext = new ArrayList();
    paramCursor = (ArrayList)a(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean);
    if (paramCursor != null) {
      paramContext.addAll(paramCursor);
    }
    paramCursor = MediaScanner.a(BaseApplicationImpl.getContext());
    if (paramCursor != null)
    {
      paramCursor = paramCursor.a(false, -1);
      if (paramCursor != null)
      {
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          paramList = (MediaScannerInfo)paramCursor.next();
          paramMediaFileFilter = new LocalMediaInfo();
          paramMediaFileFilter.jdField_a_of_type_Long = paramList.jdField_a_of_type_Int;
          paramMediaFileFilter.e = paramList.jdField_c_of_type_Long;
          paramMediaFileFilter.jdField_b_of_type_Long = paramList.jdField_a_of_type_Long;
          paramMediaFileFilter.jdField_a_of_type_JavaLangString = paramList.jdField_c_of_type_JavaLangString;
          paramMediaFileFilter.jdField_d_of_type_Long = paramList.jdField_b_of_type_Long;
          paramMediaFileFilter.jdField_b_of_type_JavaLangString = paramList.d;
          paramMediaFileFilter.jdField_b_of_type_Boolean = false;
          paramContext.add(paramMediaFileFilter);
        }
      }
    }
    Collections.sort(paramContext);
    return paramContext;
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 7
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_2
    //   9: ifgt +14 -> 23
    //   12: new 351	java/lang/IllegalArgumentException
    //   15: dup
    //   16: ldc_w 353
    //   19: invokespecial 354	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: new 272	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 273	java/util/ArrayList:<init>	()V
    //   30: astore 5
    //   32: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   35: bipush 16
    //   37: if_icmplt +233 -> 270
    //   40: iconst_1
    //   41: istore 9
    //   43: iload 9
    //   45: ifeq +99 -> 144
    //   48: aload_0
    //   49: ldc_w 356
    //   52: iconst_3
    //   53: anewarray 99	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: iconst_0
    //   59: invokestatic 201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload_1
    //   66: invokestatic 201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: iload_1
    //   73: invokestatic 201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   76: aastore
    //   77: iload_2
    //   78: invokestatic 358	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   81: astore_0
    //   82: aload_0
    //   83: aload 5
    //   85: iload_1
    //   86: iload_2
    //   87: iload 9
    //   89: aload_3
    //   90: invokestatic 361	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   93: aload_0
    //   94: ifnull +9 -> 103
    //   97: aload_0
    //   98: invokeinterface 153 1 0
    //   103: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +35 -> 141
    //   109: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   112: iconst_2
    //   113: new 230	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 363
    //   123: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   129: lload 7
    //   131: lsub
    //   132: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 5
    //   143: areturn
    //   144: getstatic 190	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   147: invokevirtual 196	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   150: astore 6
    //   152: aload 6
    //   154: ldc -58
    //   156: iload_2
    //   157: bipush 6
    //   159: imul
    //   160: invokestatic 201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   163: invokevirtual 207	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   166: pop
    //   167: aload 6
    //   169: invokevirtual 211	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   172: astore 6
    //   174: aload_0
    //   175: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   178: aload 6
    //   180: getstatic 119	com/tencent/mobileqq/utils/AlbumUtil:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   183: ldc_w 371
    //   186: aconst_null
    //   187: ldc 39
    //   189: invokevirtual 140	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   192: astore_0
    //   193: goto -111 -> 82
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_0
    //   199: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +15 -> 217
    //   205: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   208: iconst_2
    //   209: aload_3
    //   210: invokevirtual 372	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: aload_3
    //   214: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_0
    //   218: ifnull -115 -> 103
    //   221: aload_0
    //   222: invokeinterface 153 1 0
    //   227: goto -124 -> 103
    //   230: astore_0
    //   231: aload 4
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +9 -> 244
    //   238: aload_3
    //   239: invokeinterface 153 1 0
    //   244: aload_0
    //   245: athrow
    //   246: astore 4
    //   248: aload_0
    //   249: astore_3
    //   250: aload 4
    //   252: astore_0
    //   253: goto -19 -> 234
    //   256: astore 4
    //   258: aload_0
    //   259: astore_3
    //   260: aload 4
    //   262: astore_0
    //   263: goto -29 -> 234
    //   266: astore_3
    //   267: goto -68 -> 199
    //   270: iconst_0
    //   271: istore 9
    //   273: goto -230 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   0	276	1	paramInt1	int
    //   0	276	2	paramInt2	int
    //   0	276	3	paramMediaFileFilter	MediaFileFilter
    //   6	226	4	localObject1	Object
    //   246	5	4	localObject2	Object
    //   256	5	4	localObject3	Object
    //   30	112	5	localArrayList	ArrayList
    //   150	29	6	localObject4	Object
    //   3	127	7	l	long
    //   41	231	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   48	82	196	java/lang/Exception
    //   144	193	196	java/lang/Exception
    //   48	82	230	finally
    //   144	193	230	finally
    //   82	93	246	finally
    //   199	217	256	finally
    //   82	93	266	java/lang/Exception
  }
  
  /* Error */
  private static List a(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 272	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 273	java/util/ArrayList:<init>	()V
    //   13: astore 6
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 358	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 7
    //   34: aload_0
    //   35: aload 6
    //   37: iconst_m1
    //   38: iload_2
    //   39: iload 7
    //   41: aload_3
    //   42: invokestatic 361	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 153 1 0
    //   55: aload 6
    //   57: areturn
    //   58: iconst_0
    //   59: istore 7
    //   61: goto -27 -> 34
    //   64: astore_1
    //   65: aload 5
    //   67: astore_0
    //   68: aload_0
    //   69: astore 4
    //   71: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +18 -> 92
    //   77: aload_0
    //   78: astore 4
    //   80: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   83: iconst_2
    //   84: aload_1
    //   85: invokevirtual 372	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: aload_1
    //   89: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: ifnull -38 -> 55
    //   96: aload_0
    //   97: invokeinterface 153 1 0
    //   102: aload 6
    //   104: areturn
    //   105: astore_1
    //   106: aload 4
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +9 -> 119
    //   113: aload_0
    //   114: invokeinterface 153 1 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -13 -> 109
    //   125: astore_1
    //   126: goto -58 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString	String
    //   0	129	2	paramInt	int
    //   0	129	3	paramMediaFileFilter	MediaFileFilter
    //   1	106	4	localContext	Context
    //   4	62	5	localObject	Object
    //   13	90	6	localArrayList	ArrayList
    //   32	28	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	105	finally
    //   71	77	105	finally
    //   80	92	105	finally
    //   23	31	121	finally
    //   34	45	121	finally
    //   23	31	125	java/lang/Exception
    //   34	45	125	java/lang/Exception
  }
  
  public static List a(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1))) {
      paramContext = a(paramContext, -1, paramInt, paramMediaFileFilter);
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = a(paramContext, "bucket_id='" + paramString1 + "'", paramInt, paramMediaFileFilter);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d(g, 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  private static List a(Cursor paramCursor, List paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean)
  {
    if (paramCursor.getCount() <= 0)
    {
      paramCursor = null;
      return paramCursor;
    }
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    int n = paramCursor.getColumnIndexOrThrow("_id");
    int i1 = paramCursor.getColumnIndexOrThrow("_data");
    int i2 = paramCursor.getColumnIndexOrThrow("date_added");
    int i3 = paramCursor.getColumnIndexOrThrow("date_modified");
    int i4 = paramCursor.getColumnIndexOrThrow("duration");
    int i5 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i6 = paramCursor.getColumnIndexOrThrow("_size");
    int j = 0;
    int i = 0;
    if (paramBoolean)
    {
      j = paramCursor.getColumnIndexOrThrow("width");
      i = paramCursor.getColumnIndexOrThrow("height");
    }
    int k = 0;
    paramList = null;
    label135:
    String str;
    Object localObject3;
    Object localObject2;
    long l2;
    while (paramCursor.moveToNext())
    {
      str = paramCursor.getString(i1);
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        localObject3 = paramCursor.getString(i5);
        if ((paramMediaFileFilter != null) && (paramMediaFileFilter.a((String)localObject3)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = paramList;
            if (paramList == null) {
              localObject2 = new StringBuilder();
            }
            ((StringBuilder)localObject2).append("Filter mime type:").append((String)localObject3).append(", path is ").append(str).append("\n");
            paramList = (List)localObject2;
          }
        }
        else
        {
          long l1 = paramCursor.getLong(i2);
          l2 = paramCursor.getLong(i3);
          localObject2 = new LocalMediaInfo();
          ((LocalMediaInfo)localObject2).jdField_a_of_type_Long = paramCursor.getLong(n);
          ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((LocalMediaInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject3);
          ((LocalMediaInfo)localObject2).jdField_c_of_type_Long = l1;
          ((LocalMediaInfo)localObject2).jdField_d_of_type_Long = l2;
          ((LocalMediaInfo)localObject2).e = paramCursor.getLong(i4);
          ((LocalMediaInfo)localObject2).jdField_b_of_type_Long = paramCursor.getLong(i6);
          if (!paramBoolean) {
            break label464;
          }
          ((LocalMediaInfo)localObject2).i = paramCursor.getInt(j);
          ((LocalMediaInfo)localObject2).j = paramCursor.getInt(i);
        }
      }
    }
    for (;;)
    {
      ((List)localObject1).add(localObject2);
      int m = k + 1;
      if (jdField_d_of_type_Long < l2) {
        jdField_d_of_type_Long = l2;
      }
      k = m;
      if (paramInt <= 0) {
        break label135;
      }
      k = m;
      if (m < paramInt) {
        break label135;
      }
      paramCursor = (Cursor)localObject1;
      if (paramList == null) {
        break;
      }
      paramCursor = (Cursor)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(g, 2, paramList.toString());
      return (List)localObject1;
      label464:
      if (VersionUtils.d())
      {
        localObject3 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject3).setDataSource(str);
        str = ((MediaMetadataRetriever)localObject3).extractMetadata(18);
        localObject3 = ((MediaMetadataRetriever)localObject3).extractMetadata(19);
        try
        {
          ((LocalMediaInfo)localObject2).i = Integer.parseInt(str);
          ((LocalMediaInfo)localObject2).j = Integer.parseInt((String)localObject3);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          ((LocalMediaInfo)localObject2).i = 0;
          ((LocalMediaInfo)localObject2).j = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.i(g, 2, "Video size is not number format...");
        }
      }
    }
  }
  
  public static void a() {}
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968590, 2130968591);
  }
  
  public static void a(Activity paramActivity, Class paramClass, Intent paramIntent)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    a(paramActivity, true, false);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a(paramActivity);
        return;
      }
      b(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      c(paramActivity);
      return;
    }
    d(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", jdField_b_of_type_JavaLangString);
    paramContext.putString("album_key_name", jdField_c_of_type_JavaLangString);
    paramContext.commit();
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        jdField_a_of_type_JavaLangString = paramIntent;
        jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  private static void a(Cursor paramCursor, List paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    Object localObject1;
    int i2;
    int i3;
    int i4;
    int i6;
    int k;
    int j;
    BitmapFactory.Options localOptions;
    int[] arrayOfInt;
    int m;
    String str;
    Object localObject2;
    if (paramCursor.getCount() > 0)
    {
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      int i1 = paramCursor.getColumnIndexOrThrow("_data");
      i2 = paramCursor.getColumnIndexOrThrow("orientation");
      i3 = paramCursor.getColumnIndexOrThrow("date_added");
      i4 = paramCursor.getColumnIndexOrThrow("date_modified");
      int i5 = paramCursor.getColumnIndexOrThrow("mime_type");
      i6 = paramCursor.getColumnIndexOrThrow("_size");
      k = 0;
      j = 0;
      if (paramBoolean)
      {
        k = paramCursor.getColumnIndexOrThrow("width");
        j = paramCursor.getColumnIndexOrThrow("height");
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      arrayOfInt = new int[2];
      m = 0;
      for (;;)
      {
        if (paramCursor.moveToNext())
        {
          str = paramCursor.getString(i1);
          if (FileUtil.b(str))
          {
            localObject2 = paramCursor.getString(i5);
            paramList = (List)localObject2;
            if (paramMediaFileFilter != null)
            {
              paramList = (List)localObject2;
              if (paramMediaFileFilter.a((String)localObject2))
              {
                if (!"*/*".equals(localObject2)) {
                  continue;
                }
                if ((str.indexOf(".jpg") == -1) && (str.indexOf(".jpeg") == -1)) {
                  break label440;
                }
                paramList = "image/jpeg";
              }
            }
            label236:
            long l1 = paramCursor.getLong(i3);
            long l2 = paramCursor.getLong(i4);
            if (jdField_d_of_type_Long < l2) {
              jdField_d_of_type_Long = l2;
            }
            int n = 0;
            i = n;
            if (paramBoolean)
            {
              i = n;
              if (paramCursor.getInt(k) == 0) {
                i = 1;
              }
            }
            if ((paramInt1 <= 0) || ((paramBoolean) && (i == 0))) {
              break label545;
            }
            a(str, localOptions, arrayOfInt);
            if (arrayOfInt[0] < paramInt1)
            {
              i = m;
              if (arrayOfInt[1] < paramInt1) {
                break;
              }
            }
            else
            {
              localObject2 = new LocalMediaInfo();
              ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = str;
              ((LocalMediaInfo)localObject2).jdField_c_of_type_Long = l1;
              ((LocalMediaInfo)localObject2).jdField_d_of_type_Long = l2;
              ((LocalMediaInfo)localObject2).jdField_a_of_type_Int = paramCursor.getInt(i2);
              ((LocalMediaInfo)localObject2).jdField_b_of_type_JavaLangString = paramList;
              ((LocalMediaInfo)localObject2).jdField_b_of_type_Long = paramCursor.getLong(i6);
              ((List)localObject1).add(localObject2);
            }
          }
        }
      }
    }
    for (int i = m + 1;; i = m + 1)
    {
      m = i;
      if (paramInt2 <= 0) {
        break;
      }
      m = i;
      if (i < paramInt2) {
        break;
      }
      return;
      label440:
      if (str.indexOf(".gif") != -1)
      {
        paramList = "image/gif";
        break label236;
      }
      if (str.indexOf(".bmp") != -1)
      {
        paramList = "image/bmp";
        break label236;
      }
      if (str.indexOf(".png") != -1)
      {
        paramList = "image/png";
        break label236;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(g, 2, "Filter mime type:" + (String)localObject2 + ", path is " + str);
      break;
      label545:
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = str;
      ((LocalMediaInfo)localObject2).jdField_c_of_type_Long = paramCursor.getLong(i3);
      ((LocalMediaInfo)localObject2).jdField_d_of_type_Long = paramCursor.getLong(i4);
      ((LocalMediaInfo)localObject2).jdField_a_of_type_Int = paramCursor.getInt(i2);
      ((LocalMediaInfo)localObject2).jdField_b_of_type_JavaLangString = paramList;
      ((LocalMediaInfo)localObject2).jdField_b_of_type_Long = paramCursor.getLong(i6);
      if (paramBoolean)
      {
        ((LocalMediaInfo)localObject2).i = paramCursor.getInt(k);
        ((LocalMediaInfo)localObject2).j = paramCursor.getInt(j);
      }
      if ((((LocalMediaInfo)localObject2).i <= 0) || (((LocalMediaInfo)localObject2).j <= 0))
      {
        a(str, localOptions, arrayOfInt);
        ((LocalMediaInfo)localObject2).i = arrayOfInt[0];
        ((LocalMediaInfo)localObject2).j = arrayOfInt[1];
      }
      if (((((LocalMediaInfo)localObject2).i <= 0) || (((LocalMediaInfo)localObject2).j <= 0)) && (QLog.isColorLevel())) {
        QLog.i(g, 2, "no size " + str);
      }
      ((List)localObject1).add(localObject2);
    }
  }
  
  private static void a(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        SafeBitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = 0;
        continue;
      }
      try
      {
        m = paramOptions.outHeight;
        i = m;
        j = k;
        if (k <= 65535)
        {
          i = m;
          j = k;
          if (m > 65535) {}
        }
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = k;
        continue;
      }
      try
      {
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
        j = k;
        i = m;
      }
      catch (OutOfMemoryError paramString)
      {
        i = m;
        j = k;
        continue;
      }
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if ((paramMediaFileFilter != null) && (paramMediaFileFilter.a()) && (!a(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter).isEmpty())) {}
    while ((paramMediaFileFilter != null) && (paramMediaFileFilter.b()) && (!b(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter).isEmpty())) {
      return true;
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  /* Error */
  public static List b(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_2
    //   4: ifgt +14 -> 18
    //   7: new 351	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc_w 353
    //   14: invokespecial 354	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: new 272	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 273	java/util/ArrayList:<init>	()V
    //   25: astore 6
    //   27: getstatic 617	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   30: invokevirtual 196	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   33: astore 5
    //   35: aload 5
    //   37: ldc -58
    //   39: iload_2
    //   40: bipush 6
    //   42: imul
    //   43: invokestatic 201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   46: invokevirtual 207	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   49: pop
    //   50: aload 5
    //   52: invokevirtual 211	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   55: astore 5
    //   57: aload_0
    //   58: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   61: aload 5
    //   63: getstatic 123	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   66: ldc_w 371
    //   69: aconst_null
    //   70: ldc 39
    //   72: invokevirtual 140	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_0
    //   76: aload_0
    //   77: astore 4
    //   79: aload 4
    //   81: astore_0
    //   82: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   85: bipush 16
    //   87: if_icmplt +186 -> 273
    //   90: iconst_1
    //   91: istore 7
    //   93: aload 4
    //   95: astore_0
    //   96: aload 4
    //   98: aload 6
    //   100: iload_2
    //   101: aload_3
    //   102: iload 7
    //   104: invokestatic 276	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;Z)Ljava/util/List;
    //   107: pop
    //   108: aload 4
    //   110: ifnull +10 -> 120
    //   113: aload 4
    //   115: invokeinterface 153 1 0
    //   120: invokestatic 286	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokestatic 291	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +213 -> 341
    //   131: aload_0
    //   132: iconst_1
    //   133: bipush 100
    //   135: invokevirtual 294	com/tencent/mobileqq/activity/photo/MediaScanner:a	(ZI)Ljava/util/ArrayList;
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +201 -> 341
    //   143: aload_0
    //   144: invokevirtual 298	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   147: astore_0
    //   148: aload_0
    //   149: invokeinterface 303 1 0
    //   154: ifeq +187 -> 341
    //   157: aload_0
    //   158: invokeinterface 307 1 0
    //   163: checkcast 309	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   166: astore 4
    //   168: new 168	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   171: dup
    //   172: invokespecial 310	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   175: astore 5
    //   177: aload 5
    //   179: aload 4
    //   181: getfield 312	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Int	I
    //   184: i2l
    //   185: putfield 314	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_Long	J
    //   188: aload 5
    //   190: aload 4
    //   192: getfield 316	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_Long	J
    //   195: putfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:e	J
    //   198: aload 5
    //   200: aload 4
    //   202: getfield 319	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Long	J
    //   205: putfield 321	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_Long	J
    //   208: aload 5
    //   210: aload 4
    //   212: getfield 323	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   215: putfield 242	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: aload 5
    //   220: aload 4
    //   222: getfield 324	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_b_of_type_Long	J
    //   225: putfield 326	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_d_of_type_Long	J
    //   228: aload 5
    //   230: aload 4
    //   232: getfield 328	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   235: putfield 170	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   238: aload 5
    //   240: iconst_0
    //   241: putfield 330	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_Boolean	Z
    //   244: aload_3
    //   245: ifnull +15 -> 260
    //   248: aload_3
    //   249: aload 4
    //   251: getfield 328	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   254: invokevirtual 425	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	(Ljava/lang/String;)Z
    //   257: ifne -109 -> 148
    //   260: aload 6
    //   262: aload 5
    //   264: invokeinterface 443 2 0
    //   269: pop
    //   270: goto -122 -> 148
    //   273: iconst_0
    //   274: istore 7
    //   276: goto -183 -> 93
    //   279: astore 5
    //   281: aconst_null
    //   282: astore 4
    //   284: aload 4
    //   286: astore_0
    //   287: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +20 -> 310
    //   293: aload 4
    //   295: astore_0
    //   296: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   299: iconst_2
    //   300: aload 5
    //   302: invokevirtual 372	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: aload 5
    //   307: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload 4
    //   312: ifnull -192 -> 120
    //   315: aload 4
    //   317: invokeinterface 153 1 0
    //   322: goto -202 -> 120
    //   325: astore_0
    //   326: aload 4
    //   328: astore_3
    //   329: aload_3
    //   330: ifnull +9 -> 339
    //   333: aload_3
    //   334: invokeinterface 153 1 0
    //   339: aload_0
    //   340: athrow
    //   341: aload 6
    //   343: invokestatic 340	java/util/Collections:sort	(Ljava/util/List;)V
    //   346: new 272	java/util/ArrayList
    //   349: dup
    //   350: invokespecial 273	java/util/ArrayList:<init>	()V
    //   353: astore_0
    //   354: iload_2
    //   355: aload 6
    //   357: invokeinterface 394 1 0
    //   362: invokestatic 623	java/lang/Math:min	(II)I
    //   365: istore_2
    //   366: iconst_0
    //   367: istore_1
    //   368: iload_1
    //   369: iload_2
    //   370: if_icmpge +25 -> 395
    //   373: aload_0
    //   374: aload 6
    //   376: iload_1
    //   377: invokeinterface 626 2 0
    //   382: invokeinterface 443 2 0
    //   387: pop
    //   388: iload_1
    //   389: iconst_1
    //   390: iadd
    //   391: istore_1
    //   392: goto -24 -> 368
    //   395: aload_0
    //   396: areturn
    //   397: astore 4
    //   399: aload_0
    //   400: astore_3
    //   401: aload 4
    //   403: astore_0
    //   404: goto -75 -> 329
    //   407: astore 5
    //   409: goto -125 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	paramContext	Context
    //   0	412	1	paramInt1	int
    //   0	412	2	paramInt2	int
    //   0	412	3	paramMediaFileFilter	MediaFileFilter
    //   1	326	4	localObject1	Object
    //   397	5	4	localObject2	Object
    //   33	230	5	localObject3	Object
    //   279	27	5	localException1	Exception
    //   407	1	5	localException2	Exception
    //   25	350	6	localArrayList	ArrayList
    //   91	184	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   27	76	279	java/lang/Exception
    //   27	76	325	finally
    //   82	90	397	finally
    //   96	108	397	finally
    //   287	293	397	finally
    //   296	310	397	finally
    //   82	90	407	java/lang/Exception
    //   96	108	407	java/lang/Exception
  }
  
  /* Error */
  public static List b(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: ldc_w 376
    //   7: aload_1
    //   8: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +14 -> 25
    //   14: aload_0
    //   15: sipush 210
    //   18: iload_3
    //   19: aload 4
    //   21: invokestatic 628	com/tencent/mobileqq/utils/AlbumUtil:b	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   24: areturn
    //   25: new 272	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 273	java/util/ArrayList:<init>	()V
    //   32: astore 5
    //   34: new 230	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 383
    //   44: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 385
    //   54: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   65: getstatic 617	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   68: getstatic 123	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   71: aload_1
    //   72: aconst_null
    //   73: ldc 39
    //   75: invokevirtual 140	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   84: bipush 16
    //   86: if_icmplt +33 -> 119
    //   89: iconst_1
    //   90: istore 6
    //   92: aload_1
    //   93: astore_0
    //   94: aload_1
    //   95: aload 5
    //   97: iload_3
    //   98: aload 4
    //   100: iload 6
    //   102: invokestatic 276	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;Z)Ljava/util/List;
    //   105: pop
    //   106: aload_1
    //   107: ifnull +78 -> 185
    //   110: aload_1
    //   111: invokeinterface 153 1 0
    //   116: aload 5
    //   118: areturn
    //   119: iconst_0
    //   120: istore 6
    //   122: goto -30 -> 92
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: astore_0
    //   130: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +16 -> 149
    //   136: aload_1
    //   137: astore_0
    //   138: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   141: iconst_2
    //   142: ldc_w 630
    //   145: aload_2
    //   146: invokestatic 632	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_1
    //   150: ifnull +35 -> 185
    //   153: aload_1
    //   154: invokeinterface 153 1 0
    //   159: aload 5
    //   161: areturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_0
    //   170: invokeinterface 153 1 0
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: goto -13 -> 165
    //   181: astore_2
    //   182: goto -54 -> 128
    //   185: aload 5
    //   187: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramContext	Context
    //   0	188	1	paramString1	String
    //   0	188	2	paramString2	String
    //   0	188	3	paramInt	int
    //   0	188	4	paramMediaFileFilter	MediaFileFilter
    //   32	154	5	localArrayList	ArrayList
    //   90	31	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   61	79	125	java/lang/Exception
    //   61	79	162	finally
    //   81	89	177	finally
    //   94	106	177	finally
    //   130	136	177	finally
    //   138	149	177	finally
    //   81	89	181	java/lang/Exception
    //   94	106	181	java/lang/Exception
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaLangString = null;
    jdField_c_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
  }
  
  private static void b(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968587, 2130968588);
  }
  
  /* Error */
  public static List c(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: ldc_w 639
    //   3: aload_1
    //   4: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7: ifeq +125 -> 132
    //   10: aload_0
    //   11: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 617	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   17: getstatic 123	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   20: aconst_null
    //   21: aconst_null
    //   22: ldc 39
    //   24: invokevirtual 140	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 5
    //   29: aload 5
    //   31: astore 6
    //   33: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 16
    //   38: if_icmplt +45 -> 83
    //   41: iconst_1
    //   42: istore 15
    //   44: aload 5
    //   46: astore 6
    //   48: aload_0
    //   49: aload 5
    //   51: aconst_null
    //   52: iload_3
    //   53: aload 4
    //   55: iload 15
    //   57: invokestatic 641	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;Z)Ljava/util/ArrayList;
    //   60: astore 7
    //   62: aload 7
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: aload 5
    //   69: ifnull +12 -> 81
    //   72: aload 5
    //   74: invokeinterface 153 1 0
    //   79: aload_0
    //   80: astore_1
    //   81: aload_1
    //   82: areturn
    //   83: iconst_0
    //   84: istore 15
    //   86: goto -42 -> 44
    //   89: astore 7
    //   91: aconst_null
    //   92: astore 5
    //   94: aload 5
    //   96: astore 6
    //   98: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +19 -> 120
    //   104: aload 5
    //   106: astore 6
    //   108: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   111: iconst_2
    //   112: ldc_w 630
    //   115: aload 7
    //   117: invokestatic 632	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload 5
    //   122: ifnull +10 -> 132
    //   125: aload 5
    //   127: invokeinterface 153 1 0
    //   132: aload 4
    //   134: ifnull +490 -> 624
    //   137: aload 4
    //   139: invokevirtual 606	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	()Z
    //   142: ifeq +482 -> 624
    //   145: aload_0
    //   146: aload_1
    //   147: aload_2
    //   148: iload_3
    //   149: aload 4
    //   151: invokestatic 608	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   154: astore 5
    //   156: aload 4
    //   158: ifnull +461 -> 619
    //   161: aload 4
    //   163: invokevirtual 612	com/tencent/mobileqq/activity/photo/MediaFileFilter:b	()Z
    //   166: ifeq +453 -> 619
    //   169: aload_0
    //   170: aload_1
    //   171: aload_2
    //   172: iload_3
    //   173: aload 4
    //   175: invokestatic 614	com/tencent/mobileqq/utils/AlbumUtil:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   178: astore_0
    //   179: ldc_w 376
    //   182: aload_1
    //   183: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +64 -> 250
    //   189: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   192: lstore 13
    //   194: aload 5
    //   196: ifnull +8 -> 204
    //   199: aload 5
    //   201: invokestatic 340	java/util/Collections:sort	(Ljava/util/List;)V
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokestatic 340	java/util/Collections:sort	(Ljava/util/List;)V
    //   212: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +35 -> 250
    //   218: getstatic 55	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   221: iconst_2
    //   222: new 230	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 643
    //   232: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   238: lload 13
    //   240: lsub
    //   241: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   244: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_0
    //   251: ifnull +12 -> 263
    //   254: aload_0
    //   255: invokeinterface 610 1 0
    //   260: ifeq +24 -> 284
    //   263: aload 5
    //   265: areturn
    //   266: astore_0
    //   267: aconst_null
    //   268: astore 6
    //   270: aload 6
    //   272: ifnull +10 -> 282
    //   275: aload 6
    //   277: invokeinterface 153 1 0
    //   282: aload_0
    //   283: athrow
    //   284: aload_0
    //   285: astore_1
    //   286: aload 5
    //   288: ifnull -207 -> 81
    //   291: aload_0
    //   292: astore_1
    //   293: aload 5
    //   295: invokeinterface 610 1 0
    //   300: ifne -219 -> 81
    //   303: aload 5
    //   305: invokeinterface 394 1 0
    //   310: istore 8
    //   312: iconst_0
    //   313: istore 9
    //   315: iconst_0
    //   316: istore 10
    //   318: iload 10
    //   320: aload_0
    //   321: invokeinterface 394 1 0
    //   326: if_icmpge +266 -> 592
    //   329: aload_0
    //   330: iload 10
    //   332: invokeinterface 626 2 0
    //   337: checkcast 168	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   340: astore_1
    //   341: aload 5
    //   343: iload 8
    //   345: iconst_1
    //   346: isub
    //   347: invokeinterface 626 2 0
    //   352: checkcast 168	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   355: astore_2
    //   356: aload_1
    //   357: getfield 326	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_d_of_type_Long	J
    //   360: aload_2
    //   361: getfield 326	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_d_of_type_Long	J
    //   364: lcmp
    //   365: ifgt +95 -> 460
    //   368: iload_3
    //   369: iconst_m1
    //   370: if_icmpne +39 -> 409
    //   373: iload 10
    //   375: aload_0
    //   376: invokeinterface 394 1 0
    //   381: if_icmpge +211 -> 592
    //   384: aload 5
    //   386: aload_0
    //   387: iload 10
    //   389: invokeinterface 626 2 0
    //   394: invokeinterface 443 2 0
    //   399: pop
    //   400: iload 10
    //   402: iconst_1
    //   403: iadd
    //   404: istore 10
    //   406: goto -33 -> 373
    //   409: aload_0
    //   410: invokeinterface 394 1 0
    //   415: iload 10
    //   417: isub
    //   418: iload_3
    //   419: iload 8
    //   421: isub
    //   422: invokestatic 623	java/lang/Math:min	(II)I
    //   425: istore 8
    //   427: iconst_0
    //   428: istore_3
    //   429: iload_3
    //   430: iload 8
    //   432: if_icmpge +160 -> 592
    //   435: aload 5
    //   437: aload_0
    //   438: iload_3
    //   439: iload 10
    //   441: iadd
    //   442: invokeinterface 626 2 0
    //   447: invokeinterface 443 2 0
    //   452: pop
    //   453: iload_3
    //   454: iconst_1
    //   455: iadd
    //   456: istore_3
    //   457: goto -28 -> 429
    //   460: iload 9
    //   462: istore 11
    //   464: iload 11
    //   466: iload 8
    //   468: if_icmpge +136 -> 604
    //   471: aload 5
    //   473: iload 11
    //   475: invokeinterface 626 2 0
    //   480: checkcast 168	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   483: astore_2
    //   484: aload_1
    //   485: getfield 326	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_d_of_type_Long	J
    //   488: aload_2
    //   489: getfield 326	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_d_of_type_Long	J
    //   492: lcmp
    //   493: ifgt +12 -> 505
    //   496: iload 11
    //   498: iconst_1
    //   499: iadd
    //   500: istore 11
    //   502: goto -38 -> 464
    //   505: aload 5
    //   507: iload 11
    //   509: aload_1
    //   510: invokeinterface 646 3 0
    //   515: iload_3
    //   516: iconst_m1
    //   517: if_icmpeq +24 -> 541
    //   520: aload 5
    //   522: invokeinterface 394 1 0
    //   527: iload_3
    //   528: if_icmple +13 -> 541
    //   531: aload 5
    //   533: iload 8
    //   535: invokeinterface 649 2 0
    //   540: pop
    //   541: aload 5
    //   543: invokeinterface 394 1 0
    //   548: istore 12
    //   550: iload 8
    //   552: istore 9
    //   554: iload 8
    //   556: iload 12
    //   558: if_icmpeq +7 -> 565
    //   561: iload 12
    //   563: istore 9
    //   565: iload 11
    //   567: iconst_1
    //   568: iadd
    //   569: istore 8
    //   571: iload 10
    //   573: iconst_1
    //   574: iadd
    //   575: istore 10
    //   577: iload 9
    //   579: istore 11
    //   581: iload 8
    //   583: istore 9
    //   585: iload 11
    //   587: istore 8
    //   589: goto -271 -> 318
    //   592: aload 5
    //   594: areturn
    //   595: astore_0
    //   596: goto -326 -> 270
    //   599: astore 7
    //   601: goto -507 -> 94
    //   604: iload 8
    //   606: istore 11
    //   608: iload 9
    //   610: istore 8
    //   612: iload 11
    //   614: istore 9
    //   616: goto -45 -> 571
    //   619: aconst_null
    //   620: astore_0
    //   621: goto -442 -> 179
    //   624: aconst_null
    //   625: astore 5
    //   627: goto -471 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	paramContext	Context
    //   0	630	1	paramString1	String
    //   0	630	2	paramString2	String
    //   0	630	3	paramInt	int
    //   0	630	4	paramMediaFileFilter	MediaFileFilter
    //   27	599	5	localObject1	Object
    //   31	245	6	localObject2	Object
    //   60	3	7	localArrayList	ArrayList
    //   89	27	7	localException1	Exception
    //   599	1	7	localException2	Exception
    //   310	301	8	i	int
    //   313	302	9	j	int
    //   316	260	10	k	int
    //   462	151	11	m	int
    //   548	14	12	n	int
    //   192	47	13	l	long
    //   42	43	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	29	89	java/lang/Exception
    //   10	29	266	finally
    //   33	41	595	finally
    //   48	62	595	finally
    //   98	104	595	finally
    //   108	120	595	finally
    //   33	41	599	java/lang/Exception
    //   48	62	599	java/lang/Exception
  }
  
  public static void c()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  private static void c(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968585, 2130968586);
  }
  
  private static void d(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968583, 2130968584);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\AlbumUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */