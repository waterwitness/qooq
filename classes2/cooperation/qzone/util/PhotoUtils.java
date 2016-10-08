package cooperation.qzone.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.provider.MediaStore.Images.Media;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class PhotoUtils
{
  public static final int a = 20480;
  private static PhotoUtils jdField_a_of_type_CooperationQzoneUtilPhotoUtils;
  private static final String jdField_a_of_type_JavaLangString = "PhotoUtils";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DISTINCT _data" };
  private static final int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = "LocalRecentPhotoCheckManager.new_photo_check_lasttime";
  private static final int jdField_c_of_type_Int = 4;
  private static final String jdField_c_of_type_JavaLangString = "date_modified DESC";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private long a()
  {
    return LocalMultiProcConfig.a("LocalRecentPhotoCheckManager.new_photo_check_lasttime", 0L);
  }
  
  private static Cursor a(Context paramContext, int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = QzoneConfig.a().a("PhotoUpload", "PhotoUploadPhotoChangeStrategy", 1);
    int i = QzoneConfig.a().a("PhotoUpload", "PhotoUploadPhotoMinSize", 300);
    long l = QzoneConfig.a().a("PhotoUpload", "PhotoUploadPhotoMaxSize", 20000) * 1024;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bucket_display_name");
    ((StringBuilder)localObject).append(" != 'Screenshots' ");
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("_size");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(i * 1024);
    if (paramInt == 1)
    {
      ((StringBuilder)localObject).append(" and ");
      ((StringBuilder)localObject).append("_size");
      ((StringBuilder)localObject).append("<=");
      ((StringBuilder)localObject).append(l);
    }
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(paramLong1 / 1000L);
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(" <= ");
    ((StringBuilder)localObject).append(paramLong2 / 1000L);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramContext = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, (String)localObject, null, "date_modified DESC LIMIT 0,50");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static ExifInterface a(String paramString)
  {
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramString))
      {
        paramString = new ExifInterface(paramString);
        return paramString;
      }
      return null;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static PhotoUtils a()
  {
    if (jdField_a_of_type_CooperationQzoneUtilPhotoUtils == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneUtilPhotoUtils == null) {
        jdField_a_of_type_CooperationQzoneUtilPhotoUtils = new PhotoUtils();
      }
      return jdField_a_of_type_CooperationQzoneUtilPhotoUtils;
    }
    finally {}
  }
  
  /* Error */
  public static ArrayList a(Context paramContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: lload_2
    //   3: lload 4
    //   5: invokestatic 141	cooperation/qzone/util/PhotoUtils:a	(Landroid/content/Context;IJJ)Landroid/database/Cursor;
    //   8: astore_0
    //   9: aload_0
    //   10: invokeinterface 147 1 0
    //   15: istore_1
    //   16: iload_1
    //   17: ifle +366 -> 383
    //   20: new 149	java/util/ArrayList
    //   23: dup
    //   24: iload_1
    //   25: invokespecial 152	java/util/ArrayList:<init>	(I)V
    //   28: astore 9
    //   30: aload_0
    //   31: ldc -102
    //   33: invokeinterface 158 2 0
    //   38: istore_1
    //   39: new 149	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 159	java/util/ArrayList:<init>	()V
    //   46: astore 8
    //   48: iload 7
    //   50: tableswitch	default:+339->389, 0:+179->229, 1:+189->239, 2:+199->249
    //   76: invokestatic 52	common/config/service/QzoneConfig:a	()Lcommon/config/service/QzoneConfig;
    //   79: ldc 54
    //   81: ldc 56
    //   83: iconst_1
    //   84: invokevirtual 59	common/config/service/QzoneConfig:a	(Ljava/lang/String;Ljava/lang/String;I)I
    //   87: istore 7
    //   89: aload_0
    //   90: invokeinterface 163 1 0
    //   95: ifeq +281 -> 376
    //   98: aload_0
    //   99: iload_1
    //   100: invokeinterface 167 2 0
    //   105: astore 10
    //   107: aload 10
    //   109: ifnull -20 -> 89
    //   112: aload 8
    //   114: aload 10
    //   116: invokeinterface 173 2 0
    //   121: ifne -32 -> 89
    //   124: new 175	java/io/File
    //   127: dup
    //   128: aload 10
    //   130: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 11
    //   135: aload 11
    //   137: ifnull -48 -> 89
    //   140: aload 11
    //   142: invokevirtual 179	java/io/File:exists	()Z
    //   145: ifeq -56 -> 89
    //   148: aload 11
    //   150: invokevirtual 182	java/io/File:isDirectory	()Z
    //   153: ifne -64 -> 89
    //   156: iload 7
    //   158: ifne +14 -> 172
    //   161: aload 10
    //   163: invokestatic 184	cooperation/qzone/util/PhotoUtils:a	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   166: invokestatic 187	cooperation/qzone/util/PhotoUtils:a	(Landroid/media/ExifInterface;)Z
    //   169: ifeq -80 -> 89
    //   172: aload 9
    //   174: aload 10
    //   176: invokevirtual 190	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 9
    //   182: invokevirtual 193	java/util/ArrayList:size	()I
    //   185: iload 6
    //   187: if_icmplt -98 -> 89
    //   190: invokestatic 198	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +183 -> 376
    //   196: ldc 11
    //   198: iconst_4
    //   199: ldc -56
    //   201: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 9
    //   206: astore 8
    //   208: aload 8
    //   210: astore 9
    //   212: aload_0
    //   213: ifnull +13 -> 226
    //   216: aload_0
    //   217: invokeinterface 207 1 0
    //   222: aload 8
    //   224: astore 9
    //   226: aload 9
    //   228: areturn
    //   229: ldc -47
    //   231: invokestatic 214	cooperation/qzone/util/RecentPhotoManger:a	(Ljava/lang/String;)Ljava/util/List;
    //   234: astore 8
    //   236: goto -160 -> 76
    //   239: ldc -40
    //   241: invokestatic 214	cooperation/qzone/util/RecentPhotoManger:a	(Ljava/lang/String;)Ljava/util/List;
    //   244: astore 8
    //   246: goto -170 -> 76
    //   249: ldc -38
    //   251: invokestatic 214	cooperation/qzone/util/RecentPhotoManger:a	(Ljava/lang/String;)Ljava/util/List;
    //   254: astore 8
    //   256: goto -180 -> 76
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   264: aload 8
    //   266: areturn
    //   267: astore 9
    //   269: aconst_null
    //   270: astore_0
    //   271: aconst_null
    //   272: astore 8
    //   274: aload 9
    //   276: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   279: aload_0
    //   280: astore 9
    //   282: aload 8
    //   284: ifnull -58 -> 226
    //   287: aload 8
    //   289: invokeinterface 207 1 0
    //   294: aload_0
    //   295: areturn
    //   296: astore 8
    //   298: aload 8
    //   300: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   303: aload_0
    //   304: areturn
    //   305: astore 8
    //   307: aconst_null
    //   308: astore_0
    //   309: aload_0
    //   310: ifnull +9 -> 319
    //   313: aload_0
    //   314: invokeinterface 207 1 0
    //   319: aload 8
    //   321: athrow
    //   322: astore_0
    //   323: aload_0
    //   324: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   327: goto -8 -> 319
    //   330: astore 8
    //   332: goto -23 -> 309
    //   335: astore 9
    //   337: aload 8
    //   339: astore_0
    //   340: aload 9
    //   342: astore 8
    //   344: goto -35 -> 309
    //   347: astore 9
    //   349: aconst_null
    //   350: astore 10
    //   352: aload_0
    //   353: astore 8
    //   355: aload 10
    //   357: astore_0
    //   358: goto -84 -> 274
    //   361: astore 10
    //   363: aload_0
    //   364: astore 8
    //   366: aload 9
    //   368: astore_0
    //   369: aload 10
    //   371: astore 9
    //   373: goto -99 -> 274
    //   376: aload 9
    //   378: astore 8
    //   380: goto -172 -> 208
    //   383: aconst_null
    //   384: astore 8
    //   386: goto -178 -> 208
    //   389: goto -313 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramContext	Context
    //   0	392	1	paramInt1	int
    //   0	392	2	paramLong1	long
    //   0	392	4	paramLong2	long
    //   0	392	6	paramInt2	int
    //   0	392	7	paramInt3	int
    //   46	242	8	localObject1	Object
    //   296	3	8	localException1	Exception
    //   305	15	8	localObject2	Object
    //   330	8	8	localObject3	Object
    //   342	43	8	localObject4	Object
    //   28	199	9	localObject5	Object
    //   267	8	9	localException2	Exception
    //   280	1	9	localContext	Context
    //   335	6	9	localObject6	Object
    //   347	20	9	localException3	Exception
    //   371	6	9	localObject7	Object
    //   105	251	10	str	String
    //   361	9	10	localException4	Exception
    //   133	16	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   216	222	259	java/lang/Exception
    //   0	9	267	java/lang/Exception
    //   287	294	296	java/lang/Exception
    //   0	9	305	finally
    //   313	319	322	java/lang/Exception
    //   9	16	330	finally
    //   20	30	330	finally
    //   30	48	330	finally
    //   76	89	330	finally
    //   89	107	330	finally
    //   112	135	330	finally
    //   140	156	330	finally
    //   161	172	330	finally
    //   172	204	330	finally
    //   229	236	330	finally
    //   239	246	330	finally
    //   249	256	330	finally
    //   274	279	335	finally
    //   9	16	347	java/lang/Exception
    //   20	30	347	java/lang/Exception
    //   30	48	361	java/lang/Exception
    //   76	89	361	java/lang/Exception
    //   89	107	361	java/lang/Exception
    //   112	135	361	java/lang/Exception
    //   140	156	361	java/lang/Exception
    //   161	172	361	java/lang/Exception
    //   172	204	361	java/lang/Exception
    //   229	236	361	java/lang/Exception
    //   239	246	361	java/lang/Exception
    //   249	256	361	java/lang/Exception
  }
  
  private static boolean a(ExifInterface paramExifInterface)
  {
    if (paramExifInterface == null) {}
    do
    {
      return false;
      paramExifInterface = paramExifInterface.getAttribute("DateTime");
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "FDateTime:" + paramExifInterface);
      }
    } while (paramExifInterface == null);
    return true;
  }
  
  public static boolean b()
  {
    long l1 = QzoneConfig.a().a("PhotoUpload", "PhotoUploadGuideScanTimeInterval", 1) * 60 * 60 * 1000;
    long l2 = LocalMultiProcConfig.a("key_photo_guide_last_check", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "KEY_PHOTO_GUIDE_LAST_CHECK get:" + l2);
    }
    if (l2 <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck");
      }
    }
    do
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck S-L:" + (System.currentTimeMillis() - l2));
      }
    } while ((System.currentTimeMillis() - l2 >= l1) || (System.currentTimeMillis() - l2 <= 0L));
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isOverLastCheck false");
    }
    return false;
  }
  
  public static boolean c()
  {
    long l = LocalMultiProcConfig.a("key_photo_guide_enter_qzone_date", 0L);
    if (l <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
      }
    }
    do
    {
      return false;
      l = System.currentTimeMillis() - l;
      if ((l <= 86400000L) && (l > 0L)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isCurrentDayInQzone");
    }
    return true;
  }
  
  public static boolean d()
  {
    int i = QzoneConfig.a().a("PhotoUpload", "secondary_album_photo_show_start_hour", 19);
    int j = QzoneConfig.a().a("PhotoUpload", "secondary_album_photo_show_end_hour", 22);
    int k = Calendar.getInstance().get(11);
    return (k >= i) && (k < j);
  }
  
  public boolean a()
  {
    if ((QzoneConfig.a().a("PhotoUpload", "GuideShowOpen", 7) & 0x4) == 0) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "showGuide == CLOSE");
      }
    }
    label178:
    ArrayList localArrayList;
    do
    {
      do
      {
        return false;
        int i = QzoneConfig.a().a("PhotoUpload", "ExposePhotoMinCount", 10);
        long l4 = QzoneConfig.a().a("PhotoUpload", "ExposePhotoTimeRange", 6) * 60 * 60 * 1000;
        long l3 = a();
        long l2 = System.currentTimeMillis();
        if (l3 != 0L)
        {
          l1 = l3;
          if (l2 >= l3) {}
        }
        else
        {
          l1 = l2;
        }
        if (l1 == l2) {}
        for (long l1 = l2 - l4;; l1 = Math.max(l1, l2 - l4))
        {
          if (l1 == l2 - l4) {
            break label178;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("PhotoUtils", 4, l4 + "秒以内");
          return false;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("PhotoUtils", 4, "filterTime:" + l1);
          QLog.d("PhotoUtils", 4, "nowTime:" + l2);
        }
        localArrayList = a(BaseApplication.getContext(), 20480, l1, l2, i, 0);
        if ((localArrayList != null) && (localArrayList.size() >= i))
        {
          LocalMultiProcConfig.a("key_photo_guide_first_photo", new File((String)localArrayList.get(localArrayList.size() - 1)).lastModified());
          return true;
        }
        if (localArrayList != null) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("PhotoUtils", 4, "no pics");
      return false;
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "pics count:" + localArrayList.size());
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\PhotoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */