package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import oqf;
import oqg;
import oqh;
import oqi;
import oqj;
import oqk;
import oql;

public class AlbumListAdapter
  extends BaseAdapter
{
  static final ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  static final String jdField_a_of_type_JavaLangString = "AlbumListAdapter";
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  static final String jdField_b_of_type_JavaLangString = "_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png')) GROUP BY (1";
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final int jdField_c_of_type_Int = 210;
  static final String jdField_c_of_type_JavaLangString = "_size>0 and (mime_type='image/jpeg' or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png')) GROUP BY (1";
  static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  static final String jdField_d_of_type_JavaLangString = "date_modified DESC";
  static final String[] jdField_d_of_type_ArrayOfJavaLangString;
  static final String e = "_id DESC";
  static final String f = "_id DESC";
  static final String g = "_size>0 and mime_type='video/mp4') GROUP BY (1";
  static final String h = "date_modified DESC";
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public Activity a;
  Resources jdField_a_of_type_AndroidContentResResources;
  Drawable.ConstantState jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public MediaFileFilter a;
  public List a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      c = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      d = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public AlbumListAdapter(Activity paramActivity, MediaFileFilter paramMediaFileFilter)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = paramActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = paramMediaFileFilter;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838201).getConstantState();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493030);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    ThreadManager.a().post(new oqf(this));
  }
  
  static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, jdField_b_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  LocalMediaInfo a(Cursor paramCursor, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    int i = paramCursor.getColumnIndexOrThrow("_data");
    int j = paramCursor.getColumnIndexOrThrow("_id");
    int k = paramCursor.getColumnIndexOrThrow("date_modified");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int[] arrayOfInt = new int[2];
    for (;;)
    {
      String str;
      long l;
      if (paramCursor.moveToNext())
      {
        str = paramCursor.getString(i);
        l = paramCursor.getLong(j);
        if ((str == null) || (str.length() <= 0)) {
          continue;
        }
        File localFile = new File(str);
        if ((!localFile.exists()) || (!localFile.isFile())) {
          break label203;
        }
        if (paramInt <= 0) {
          break label177;
        }
        a(str, localOptions, arrayOfInt);
        if ((arrayOfInt[0] >= paramInt) || (arrayOfInt[1] >= paramInt))
        {
          localLocalMediaInfo.jdField_a_of_type_Long = l;
          localLocalMediaInfo.jdField_a_of_type_JavaLangString = str;
          localLocalMediaInfo.d = paramCursor.getLong(k);
        }
      }
      return localLocalMediaInfo;
      label177:
      localLocalMediaInfo.jdField_a_of_type_Long = l;
      localLocalMediaInfo.jdField_a_of_type_JavaLangString = str;
      localLocalMediaInfo.d = paramCursor.getLong(k);
      return localLocalMediaInfo;
      label203:
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListAdapter", 2, "image does not exist,imagePath is:" + str);
      }
    }
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 288	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 292	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 294
    //   16: putfield 296	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   19: aload 4
    //   21: ldc_w 298
    //   24: putfield 301	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   27: aload 4
    //   29: iconst_0
    //   30: putfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   33: getstatic 307	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_2
    //   42: getstatic 90	com/tencent/mobileqq/activity/photo/AlbumListAdapter:c	[Ljava/lang/String;
    //   45: ldc_w 309
    //   48: aconst_null
    //   49: ldc 24
    //   51: invokevirtual 199	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: getstatic 314	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	Landroid/util/SparseArray;
    //   60: iconst_2
    //   61: invokevirtual 317	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   64: checkcast 311	com/tencent/mobileqq/activity/photo/MediaFileFilter
    //   67: astore 5
    //   69: aload 5
    //   71: ifnull +14 -> 85
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: aload_2
    //   78: iconst_m1
    //   79: aload 5
    //   81: invokevirtual 320	com/tencent/mobileqq/activity/photo/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   84: astore_3
    //   85: aload_2
    //   86: astore_1
    //   87: invokestatic 326	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   90: invokestatic 331	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   93: iconst_0
    //   94: iconst_m1
    //   95: invokevirtual 334	com/tencent/mobileqq/activity/photo/MediaScanner:a	(ZI)Ljava/util/ArrayList;
    //   98: astore 5
    //   100: aload_3
    //   101: ifnull +50 -> 151
    //   104: aload_2
    //   105: astore_1
    //   106: aload_3
    //   107: invokeinterface 337 1 0
    //   112: ifne +39 -> 151
    //   115: aload_2
    //   116: astore_1
    //   117: aload 4
    //   119: aload 4
    //   121: getfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   124: aload_3
    //   125: invokeinterface 340 1 0
    //   130: iadd
    //   131: putfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   134: aload_2
    //   135: astore_1
    //   136: aload 4
    //   138: aload_3
    //   139: iconst_0
    //   140: invokeinterface 286 2 0
    //   145: checkcast 214	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   148: putfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   151: aload 5
    //   153: ifnull +181 -> 334
    //   156: aload_2
    //   157: astore_1
    //   158: aload 5
    //   160: invokevirtual 345	java/util/ArrayList:isEmpty	()Z
    //   163: ifne +171 -> 334
    //   166: aload_2
    //   167: astore_1
    //   168: aload 4
    //   170: aload 4
    //   172: getfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   175: aload 5
    //   177: invokevirtual 346	java/util/ArrayList:size	()I
    //   180: iadd
    //   181: putfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   184: aload_2
    //   185: astore_1
    //   186: aload 5
    //   188: iconst_0
    //   189: invokevirtual 347	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   192: checkcast 349	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   195: astore_3
    //   196: aload_2
    //   197: astore_1
    //   198: aload 4
    //   200: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   203: ifnull +21 -> 224
    //   206: aload_2
    //   207: astore_1
    //   208: aload 4
    //   210: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   213: getfield 259	com/tencent/mobileqq/activity/photo/LocalMediaInfo:d	J
    //   216: aload_3
    //   217: getfield 351	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_b_of_type_Long	J
    //   220: lcmp
    //   221: ifge +113 -> 334
    //   224: aload_2
    //   225: astore_1
    //   226: aload 4
    //   228: new 214	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   231: dup
    //   232: invokespecial 215	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   235: putfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   238: aload_2
    //   239: astore_1
    //   240: aload 4
    //   242: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   245: aload_3
    //   246: getfield 352	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Int	I
    //   249: i2l
    //   250: putfield 255	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_Long	J
    //   253: aload_2
    //   254: astore_1
    //   255: aload 4
    //   257: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   260: aload_3
    //   261: getfield 354	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_Long	J
    //   264: putfield 356	com/tencent/mobileqq/activity/photo/LocalMediaInfo:e	J
    //   267: aload_2
    //   268: astore_1
    //   269: aload 4
    //   271: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   274: aload_3
    //   275: getfield 357	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Long	J
    //   278: putfield 358	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_Long	J
    //   281: aload_2
    //   282: astore_1
    //   283: aload 4
    //   285: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   288: aload_3
    //   289: getfield 360	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   292: putfield 257	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   295: aload_2
    //   296: astore_1
    //   297: aload 4
    //   299: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   302: aload_3
    //   303: getfield 351	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_b_of_type_Long	J
    //   306: putfield 259	com/tencent/mobileqq/activity/photo/LocalMediaInfo:d	J
    //   309: aload_2
    //   310: astore_1
    //   311: aload 4
    //   313: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   316: aload_3
    //   317: getfield 362	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   320: putfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   323: aload_2
    //   324: astore_1
    //   325: aload 4
    //   327: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   330: iconst_0
    //   331: putfield 366	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_Boolean	Z
    //   334: aload_2
    //   335: ifnull +9 -> 344
    //   338: aload_2
    //   339: invokeinterface 369 1 0
    //   344: aload 4
    //   346: areturn
    //   347: astore_3
    //   348: aconst_null
    //   349: astore_2
    //   350: aload_2
    //   351: astore_1
    //   352: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +16 -> 371
    //   358: aload_2
    //   359: astore_1
    //   360: ldc 9
    //   362: iconst_2
    //   363: aload_3
    //   364: invokevirtual 372	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   367: aload_3
    //   368: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: aload_2
    //   372: ifnull -28 -> 344
    //   375: aload_2
    //   376: invokeinterface 369 1 0
    //   381: aload 4
    //   383: areturn
    //   384: astore_2
    //   385: aconst_null
    //   386: astore_1
    //   387: aload_1
    //   388: ifnull +9 -> 397
    //   391: aload_1
    //   392: invokeinterface 369 1 0
    //   397: aload_2
    //   398: athrow
    //   399: astore_2
    //   400: goto -13 -> 387
    //   403: astore_3
    //   404: goto -54 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	AlbumListAdapter
    //   0	407	1	paramContext	Context
    //   36	340	2	localObject1	Object
    //   384	14	2	localObject2	Object
    //   399	1	2	localObject3	Object
    //   1	316	3	localObject4	Object
    //   347	21	3	localException1	Exception
    //   403	1	3	localException2	Exception
    //   9	373	4	localQQAlbumInfo	QQAlbumInfo
    //   67	120	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	55	347	java/lang/Exception
    //   33	55	384	finally
    //   57	69	399	finally
    //   76	85	399	finally
    //   87	100	399	finally
    //   106	115	399	finally
    //   117	134	399	finally
    //   136	151	399	finally
    //   158	166	399	finally
    //   168	184	399	finally
    //   186	196	399	finally
    //   198	206	399	finally
    //   208	224	399	finally
    //   226	238	399	finally
    //   240	253	399	finally
    //   255	267	399	finally
    //   269	281	399	finally
    //   283	295	399	finally
    //   297	309	399	finally
    //   311	323	399	finally
    //   325	334	399	finally
    //   352	358	399	finally
    //   360	371	399	finally
    //   57	69	403	java/lang/Exception
    //   76	85	403	java/lang/Exception
    //   87	100	403	java/lang/Exception
    //   106	115	403	java/lang/Exception
    //   117	134	403	java/lang/Exception
    //   136	151	403	java/lang/Exception
    //   158	166	403	java/lang/Exception
    //   168	184	403	java/lang/Exception
    //   186	196	403	java/lang/Exception
    //   198	206	403	java/lang/Exception
    //   208	224	403	java/lang/Exception
    //   226	238	403	java/lang/Exception
    //   240	253	403	java/lang/Exception
    //   255	267	403	java/lang/Exception
    //   269	281	403	java/lang/Exception
    //   283	295	403	java/lang/Exception
    //   297	309	403	java/lang/Exception
    //   311	323	403	java/lang/Exception
    //   325	334	403	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = "最近照片";
    List localList = AlbumUtil.a(paramContext, -1, paramInt2, paramMediaFileFilter);
    if ((localList != null) && (localList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)localList.get(0));
      localQQAlbumInfo.mMediaFileCount = localList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = AlbumUtil.b(paramContext, 0, paramInt2, paramMediaFileFilter);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) {
      paramInt1 = localQQAlbumInfo.mMediaFileCount;
    }
    for (localQQAlbumInfo.mMediaFileCount = (paramContext.size() + paramInt1);; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  /* Error */
  public List a(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +66 -> 67
    //   4: getstatic 165	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 4
    //   9: ldc 13
    //   11: astore 5
    //   13: aload_3
    //   14: instanceof 390
    //   17: ifeq +7 -> 24
    //   20: ldc 18
    //   22: astore 5
    //   24: aload_1
    //   25: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload 4
    //   30: getstatic 73	com/tencent/mobileqq/activity/photo/AlbumListAdapter:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: aload 5
    //   35: aconst_null
    //   36: ldc 21
    //   38: invokevirtual 199	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull +54 -> 97
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: astore 4
    //   51: aload_3
    //   52: ifnull +12 -> 64
    //   55: aload_3
    //   56: invokeinterface 369 1 0
    //   61: aload_1
    //   62: astore 4
    //   64: aload 4
    //   66: areturn
    //   67: getstatic 165	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   70: invokevirtual 171	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   73: astore 4
    //   75: aload 4
    //   77: ldc -83
    //   79: iload_2
    //   80: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: invokevirtual 183	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   86: pop
    //   87: aload 4
    //   89: invokevirtual 187	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   92: astore 4
    //   94: goto -85 -> 9
    //   97: aload_3
    //   98: astore 4
    //   100: new 392	java/util/LinkedList
    //   103: dup
    //   104: invokespecial 393	java/util/LinkedList:<init>	()V
    //   107: astore_1
    //   108: aload_3
    //   109: astore 4
    //   111: aload_3
    //   112: ldc 57
    //   114: invokeinterface 396 2 0
    //   119: istore_2
    //   120: aload_3
    //   121: astore 4
    //   123: aload_3
    //   124: ldc 59
    //   126: invokeinterface 396 2 0
    //   131: istore 9
    //   133: aload_3
    //   134: astore 4
    //   136: aload_3
    //   137: ldc 65
    //   139: invokeinterface 396 2 0
    //   144: istore 10
    //   146: aload_3
    //   147: astore 4
    //   149: aload_3
    //   150: ldc 63
    //   152: invokeinterface 396 2 0
    //   157: istore 11
    //   159: aload_3
    //   160: astore 4
    //   162: aload_3
    //   163: ldc 80
    //   165: invokeinterface 396 2 0
    //   170: istore 12
    //   172: aload_3
    //   173: astore 4
    //   175: aload_3
    //   176: ldc 67
    //   178: invokeinterface 396 2 0
    //   183: istore 13
    //   185: aload_3
    //   186: astore 4
    //   188: aload_3
    //   189: ldc 69
    //   191: invokeinterface 396 2 0
    //   196: istore 14
    //   198: aload_3
    //   199: astore 4
    //   201: aload_3
    //   202: ldc_w 398
    //   205: invokeinterface 396 2 0
    //   210: istore 15
    //   212: aload_3
    //   213: astore 4
    //   215: aload_3
    //   216: invokeinterface 228 1 0
    //   221: ifeq +296 -> 517
    //   224: aload_3
    //   225: astore 4
    //   227: aload_3
    //   228: iload_2
    //   229: invokeinterface 231 2 0
    //   234: astore 7
    //   236: aload_3
    //   237: astore 4
    //   239: aload_3
    //   240: iload 9
    //   242: invokeinterface 231 2 0
    //   247: astore 8
    //   249: aload_3
    //   250: astore 4
    //   252: aload 7
    //   254: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifne -45 -> 212
    //   260: aload_3
    //   261: astore 4
    //   263: aload 8
    //   265: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifne -56 -> 212
    //   271: aload_3
    //   272: astore 4
    //   274: aload_3
    //   275: iload 10
    //   277: invokeinterface 231 2 0
    //   282: astore 5
    //   284: aload_3
    //   285: astore 4
    //   287: aload_3
    //   288: iload 11
    //   290: invokeinterface 235 2 0
    //   295: lstore 16
    //   297: aload_3
    //   298: astore 4
    //   300: new 288	com/tencent/mobileqq/data/QQAlbumInfo
    //   303: dup
    //   304: invokespecial 292	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   307: astore 6
    //   309: aload_3
    //   310: astore 4
    //   312: aload 6
    //   314: aload 8
    //   316: putfield 301	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   319: aload_3
    //   320: astore 4
    //   322: aload 6
    //   324: aload 7
    //   326: putfield 296	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   329: aload_3
    //   330: astore 4
    //   332: aload 6
    //   334: lload 16
    //   336: putfield 406	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   339: aload_3
    //   340: astore 4
    //   342: aload 6
    //   344: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   347: astore 7
    //   349: aload_3
    //   350: astore 4
    //   352: aload 7
    //   354: aload 5
    //   356: putfield 257	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: aload_3
    //   360: astore 4
    //   362: aload 7
    //   364: aload_3
    //   365: iload 12
    //   367: invokeinterface 235 2 0
    //   372: putfield 255	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_Long	J
    //   375: aload_3
    //   376: astore 4
    //   378: aload 7
    //   380: lload 16
    //   382: putfield 259	com/tencent/mobileqq/activity/photo/LocalMediaInfo:d	J
    //   385: aload_3
    //   386: astore 4
    //   388: aload 7
    //   390: aload_3
    //   391: iload 13
    //   393: invokeinterface 409 2 0
    //   398: putfield 410	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_Int	I
    //   401: aload_3
    //   402: astore 4
    //   404: aload 7
    //   406: aload_3
    //   407: iload 14
    //   409: invokeinterface 231 2 0
    //   414: putfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   417: aload_3
    //   418: astore 4
    //   420: ldc_w 412
    //   423: aload 7
    //   425: getfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   428: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   431: ifeq +14 -> 445
    //   434: aload_3
    //   435: astore 4
    //   437: aload 7
    //   439: ldc_w 418
    //   442: putfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   445: aload_3
    //   446: astore 4
    //   448: aload 6
    //   450: aload_3
    //   451: iload 15
    //   453: invokeinterface 409 2 0
    //   458: putfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   461: aload_3
    //   462: astore 4
    //   464: aload_1
    //   465: aload 6
    //   467: invokeinterface 421 2 0
    //   472: pop
    //   473: goto -261 -> 212
    //   476: astore 5
    //   478: aload_3
    //   479: astore 4
    //   481: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +18 -> 502
    //   487: aload_3
    //   488: astore 4
    //   490: ldc_w 423
    //   493: iconst_2
    //   494: ldc_w 425
    //   497: aload 5
    //   499: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   502: aload_1
    //   503: astore 4
    //   505: aload_3
    //   506: ifnull -442 -> 64
    //   509: aload_3
    //   510: invokeinterface 369 1 0
    //   515: aload_1
    //   516: areturn
    //   517: aload_1
    //   518: astore 4
    //   520: aload_3
    //   521: ifnull -457 -> 64
    //   524: aload_3
    //   525: invokeinterface 369 1 0
    //   530: aload_1
    //   531: areturn
    //   532: astore_1
    //   533: aconst_null
    //   534: astore 4
    //   536: aload 4
    //   538: ifnull +10 -> 548
    //   541: aload 4
    //   543: invokeinterface 369 1 0
    //   548: aload_1
    //   549: athrow
    //   550: astore_1
    //   551: goto -15 -> 536
    //   554: astore 5
    //   556: aconst_null
    //   557: astore_3
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -82 -> 478
    //   563: astore 5
    //   565: aconst_null
    //   566: astore_1
    //   567: goto -89 -> 478
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	AlbumListAdapter
    //   0	570	1	paramContext	Context
    //   0	570	2	paramInt	int
    //   0	570	3	paramMediaFileFilter	MediaFileFilter
    //   7	535	4	localObject1	Object
    //   11	344	5	str1	String
    //   476	22	5	localException1	Exception
    //   554	1	5	localException2	Exception
    //   563	1	5	localException3	Exception
    //   307	159	6	localQQAlbumInfo	QQAlbumInfo
    //   234	204	7	localObject2	Object
    //   247	68	8	str2	String
    //   131	110	9	i	int
    //   144	132	10	j	int
    //   157	132	11	k	int
    //   170	196	12	m	int
    //   183	209	13	n	int
    //   196	212	14	i1	int
    //   210	242	15	i2	int
    //   295	86	16	l	long
    // Exception table:
    //   from	to	target	type
    //   111	120	476	java/lang/Exception
    //   123	133	476	java/lang/Exception
    //   136	146	476	java/lang/Exception
    //   149	159	476	java/lang/Exception
    //   162	172	476	java/lang/Exception
    //   175	185	476	java/lang/Exception
    //   188	198	476	java/lang/Exception
    //   201	212	476	java/lang/Exception
    //   215	224	476	java/lang/Exception
    //   227	236	476	java/lang/Exception
    //   239	249	476	java/lang/Exception
    //   252	260	476	java/lang/Exception
    //   263	271	476	java/lang/Exception
    //   274	284	476	java/lang/Exception
    //   287	297	476	java/lang/Exception
    //   300	309	476	java/lang/Exception
    //   312	319	476	java/lang/Exception
    //   322	329	476	java/lang/Exception
    //   332	339	476	java/lang/Exception
    //   342	349	476	java/lang/Exception
    //   352	359	476	java/lang/Exception
    //   362	375	476	java/lang/Exception
    //   378	385	476	java/lang/Exception
    //   388	401	476	java/lang/Exception
    //   404	417	476	java/lang/Exception
    //   420	434	476	java/lang/Exception
    //   437	445	476	java/lang/Exception
    //   448	461	476	java/lang/Exception
    //   464	473	476	java/lang/Exception
    //   4	9	532	finally
    //   13	20	532	finally
    //   24	42	532	finally
    //   67	94	532	finally
    //   100	108	550	finally
    //   111	120	550	finally
    //   123	133	550	finally
    //   136	146	550	finally
    //   149	159	550	finally
    //   162	172	550	finally
    //   175	185	550	finally
    //   188	198	550	finally
    //   201	212	550	finally
    //   215	224	550	finally
    //   227	236	550	finally
    //   239	249	550	finally
    //   252	260	550	finally
    //   263	271	550	finally
    //   274	284	550	finally
    //   287	297	550	finally
    //   300	309	550	finally
    //   312	319	550	finally
    //   322	329	550	finally
    //   332	339	550	finally
    //   342	349	550	finally
    //   352	359	550	finally
    //   362	375	550	finally
    //   378	385	550	finally
    //   388	401	550	finally
    //   404	417	550	finally
    //   420	434	550	finally
    //   437	445	550	finally
    //   448	461	550	finally
    //   464	473	550	finally
    //   481	487	550	finally
    //   490	502	550	finally
    //   4	9	554	java/lang/Exception
    //   13	20	554	java/lang/Exception
    //   24	42	554	java/lang/Exception
    //   67	94	554	java/lang/Exception
    //   100	108	563	java/lang/Exception
  }
  
  List a(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label297;
            }
            str1 = paramCursor.getString(i2);
            if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.a(str1))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AlbumListAdapter", 2, "Filter mime type:" + str1);
            }
          }
          str2 = paramCursor.getString(m);
        } while ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()));
        long l = paramCursor.getLong(n);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.jdField_a_of_type_Long = paramCursor.getLong(k);
        localLocalMediaInfo.jdField_a_of_type_JavaLangString = str2;
        localLocalMediaInfo.jdField_b_of_type_JavaLangString = str1;
        localLocalMediaInfo.d = l;
        localLocalMediaInfo.e = paramCursor.getLong(i1);
        localLocalMediaInfo.jdField_b_of_type_Long = paramCursor.getLong(i3);
        localArrayList.add(localLocalMediaInfo);
        j = i + 1;
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    label297:
    return localArrayList;
  }
  
  List a(List paramList1, List paramList2, int paramInt)
  {
    int j = 0;
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int i;
    do
    {
      for (;;)
      {
        LogTag.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label471;
        }
        int k = ((List)localObject).size();
        i = 0;
        while (i < k)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if ((paramList1 != null) || (paramList2 == null)) {
          break;
        }
        localObject = paramList2;
      }
      if (paramList1 == null) {
        break;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label242:
    label471:
    label550:
    label559:
    label565:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo._id.equals(((QQAlbumInfo)localObject)._id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label565;
        }
        localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate) {
            paramList1.add(i, localObject);
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label559;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label242;
          if (paramInt == -1)
          {
            paramList1 = c(this.jdField_a_of_type_AndroidAppActivity, 210, 100, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
            ((List)localObject).add(0, paramList1);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.b()))
            {
              paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              paramList1 = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
              if (paramList1 == null) {
                break label550;
              }
              paramInt = paramList1.getCount();
              paramList1.close();
            }
          }
          for (;;)
          {
            if (paramInt > 0) {
              this.jdField_a_of_type_Boolean = true;
            }
            for (;;)
            {
              if (this.jdField_a_of_type_Boolean)
              {
                paramList1 = new QQAlbumInfo();
                paramList1._id = "$VideoAlbumId";
                paramList1.name = "本地视频";
                paramList1.mCoverInfo = new LocalMediaInfo();
                ((List)localObject).add(1, paramList1);
              }
              LogTag.a("PEAK", "compact.queryRecentBucket");
              return (List)localObject;
              paramList1 = new QQAlbumInfo();
              paramList1._id = "$RecentAlbumId";
              paramList1.name = "最近照片";
              paramList1.mCoverInfo = new LocalMediaInfo();
              break;
              paramList1 = MediaScanner.a(BaseApplicationImpl.getContext());
              paramInt = j;
              if (paramList1 != null) {
                paramInt = paramList1.a();
              }
              if (paramInt > 0) {
                this.jdField_a_of_type_Boolean = true;
              }
            }
            paramInt = 0;
          }
        }
        break;
      }
    }
  }
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    int k = 1;
    int n = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    List localList;
    int i;
    if ((localObject != null) && (((MediaFileFilter)localObject).a()))
    {
      LogTag.a();
      localList = a(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt))
      {
        i = 1;
        LogTag.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      int j;
      if ((localObject != null) && (((MediaFileFilter)localObject).b()))
      {
        LogTag.a();
        localObject = b(this.jdField_a_of_type_AndroidAppActivity, paramInt, (MediaFileFilter)localObject);
        j = i;
        if (paramInt != -1)
        {
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((List)localObject).size() == paramInt) {
              j = 1;
            }
          }
        }
        LogTag.a("PEAK", "queryVideoBuckets");
      }
      for (;;)
      {
        LogTag.a();
        localList = a(localList, (List)localObject, paramInt);
        if (localList != null) {
          for (i = 0;; i = m + i)
          {
            m = i;
            if (k >= localList.size()) {
              break;
            }
            m = ((QQAlbumInfo)localList.get(k)).mMediaFileCount;
            k += 1;
          }
        }
        int m = 0;
        localObject = new StringBuilder().append("compact(");
        if (localList == null) {}
        for (i = n;; i = localList.size() - 1)
        {
          LogTag.a("PEAK", i + "," + m + ")");
          b(localList);
          if (paramInt != -1)
          {
            if (j == 0) {
              break;
            }
            ThreadManager.a().post(new oqk(this));
          }
          return;
        }
        ThreadManager.a().post(new oql(this));
        return;
        localObject = null;
        j = i;
      }
      i = 0;
      break;
      localList = null;
      i = 0;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a(Cursor paramCursor, List paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {}
    int i1;
    int i2;
    int i4;
    int j;
    BitmapFactory.Options localOptions;
    int[] arrayOfInt;
    int k;
    label101:
    Object localObject2;
    String str;
    Object localObject1;
    do
    {
      return;
      break label101;
      break label101;
      int n;
      int i3;
      while (!paramCursor.moveToNext())
      {
        n = paramCursor.getColumnIndexOrThrow("_data");
        i1 = paramCursor.getColumnIndexOrThrow("orientation");
        i2 = paramCursor.getColumnIndexOrThrow("date_modified");
        i3 = paramCursor.getColumnIndexOrThrow("mime_type");
        i4 = paramCursor.getColumnIndexOrThrow("_size");
        j = 0;
        if (paramBoolean) {
          j = paramCursor.getColumnIndexOrThrow("width");
        }
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        arrayOfInt = new int[2];
        k = 0;
      }
      localObject2 = paramCursor.getString(i3);
      str = paramCursor.getString(n);
      localObject1 = localObject2;
      if (paramMediaFileFilter == null) {
        break;
      }
      localObject1 = localObject2;
      if (!paramMediaFileFilter.a((String)localObject2)) {
        break;
      }
    } while (!"*/*".equals(localObject2));
    label193:
    long l;
    if ((str.indexOf(".jpg") != -1) || (str.indexOf(".jpeg") != -1))
    {
      localObject1 = "image/jpeg";
      if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
        break label450;
      }
      l = paramCursor.getLong(i2);
      int m = 0;
      i = m;
      if (paramBoolean)
      {
        i = m;
        if (paramCursor.getInt(j) == 0) {
          i = 1;
        }
      }
      if ((paramInt1 <= 0) || ((paramBoolean) && (i == 0))) {
        break label452;
      }
      a(str, localOptions, arrayOfInt);
      if (arrayOfInt[0] < paramInt1)
      {
        i = k;
        if (arrayOfInt[1] < paramInt1) {}
      }
      else
      {
        localObject2 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = str;
        ((LocalMediaInfo)localObject2).d = l;
        ((LocalMediaInfo)localObject2).jdField_a_of_type_Int = paramCursor.getInt(i1);
        ((LocalMediaInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
        ((LocalMediaInfo)localObject2).jdField_b_of_type_Long = paramCursor.getLong(i4);
        paramList.add(localObject2);
      }
    }
    for (int i = k + 1;; i = k + 1)
    {
      k = i;
      if (paramInt2 <= 0) {
        break;
      }
      k = i;
      if (i < paramInt2) {
        break;
      }
      return;
      if (str.indexOf(".gif") != -1)
      {
        localObject1 = "image/gif";
        break label193;
      }
      if (str.indexOf(".bmp") != -1)
      {
        localObject1 = "image/bmp";
        break label193;
      }
      if (str.indexOf(".png") == -1) {
        break;
      }
      localObject1 = "image/png";
      break label193;
      label450:
      break label101;
      label452:
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = str;
      ((LocalMediaInfo)localObject2).d = l;
      ((LocalMediaInfo)localObject2).jdField_a_of_type_Int = paramCursor.getInt(i1);
      ((LocalMediaInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      ((LocalMediaInfo)localObject2).jdField_b_of_type_Long = paramCursor.getLong(i4);
      paramList.add(localObject2);
    }
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long > 0L))
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "qzone_album";
        paramQQAlbumInfo.name = "空间相册";
        paramQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
      notifyDataSetChanged();
      return;
      if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0))._id.equals("$RecentAlbumId")) {
        this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo);
      } else {
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
    }
  }
  
  void a(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    HashMap localHashMap = new HashMap();
    Integer localInteger = (Integer)localHashMap.get(paramString);
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
        localHashMap.put(paramString, Integer.valueOf(paramOptions.outWidth << 16 & 0xFFFF0000 | paramOptions.outHeight & 0xFFFF));
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
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
    ThreadManager.a(new oqg(this), 2, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 604	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 606
    //   17: invokespecial 607	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 288	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 292	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 378
    //   35: putfield 296	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   38: aload 8
    //   40: ldc_w 380
    //   43: putfield 301	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   46: iload_3
    //   47: ifle +141 -> 188
    //   50: getstatic 307	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 171	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 5
    //   58: aload 5
    //   60: ldc -83
    //   62: iload_3
    //   63: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   66: invokevirtual 183	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   69: pop
    //   70: aload 5
    //   72: invokevirtual 187	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   75: astore 5
    //   77: aload_1
    //   78: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   81: aload 5
    //   83: getstatic 90	com/tencent/mobileqq/activity/photo/AlbumListAdapter:c	[Ljava/lang/String;
    //   86: ldc_w 309
    //   89: aconst_null
    //   90: ldc 24
    //   92: invokevirtual 199	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore_1
    //   96: aload 4
    //   98: ifnull +16 -> 114
    //   101: aload_1
    //   102: astore 5
    //   104: aload_0
    //   105: aload_1
    //   106: iload_3
    //   107: aload 4
    //   109: invokevirtual 320	com/tencent/mobileqq/activity/photo/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   112: astore 6
    //   114: aload 6
    //   116: ifnull +59 -> 175
    //   119: aload_1
    //   120: astore 5
    //   122: aload 6
    //   124: invokeinterface 337 1 0
    //   129: ifne +46 -> 175
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: invokeinterface 340 1 0
    //   142: istore_2
    //   143: aload_1
    //   144: astore 5
    //   146: aload 8
    //   148: iload_2
    //   149: putfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   152: iload_2
    //   153: ifle +22 -> 175
    //   156: aload_1
    //   157: astore 5
    //   159: aload 8
    //   161: aload 6
    //   163: iconst_0
    //   164: invokeinterface 286 2 0
    //   169: checkcast 214	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   172: putfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   175: aload_1
    //   176: ifnull +9 -> 185
    //   179: aload_1
    //   180: invokeinterface 369 1 0
    //   185: aload 8
    //   187: areturn
    //   188: getstatic 307	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   191: astore 5
    //   193: goto -116 -> 77
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore 5
    //   203: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +19 -> 225
    //   209: aload_1
    //   210: astore 5
    //   212: ldc 9
    //   214: iconst_2
    //   215: aload 4
    //   217: invokevirtual 372	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: aload 4
    //   222: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: ifnull -41 -> 185
    //   229: aload_1
    //   230: invokeinterface 369 1 0
    //   235: aload 8
    //   237: areturn
    //   238: astore_1
    //   239: aload 7
    //   241: astore 4
    //   243: aload 4
    //   245: ifnull +10 -> 255
    //   248: aload 4
    //   250: invokeinterface 369 1 0
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: aload 5
    //   260: astore 4
    //   262: goto -19 -> 243
    //   265: astore 4
    //   267: goto -67 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	AlbumListAdapter
    //   0	270	1	paramContext	Context
    //   0	270	2	paramInt1	int
    //   0	270	3	paramInt2	int
    //   0	270	4	paramMediaFileFilter	MediaFileFilter
    //   56	203	5	localObject1	Object
    //   4	158	6	localList	List
    //   1	239	7	localObject2	Object
    //   28	208	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   50	77	196	java/lang/Exception
    //   77	96	196	java/lang/Exception
    //   188	193	196	java/lang/Exception
    //   50	77	238	finally
    //   77	96	238	finally
    //   188	193	238	finally
    //   104	114	257	finally
    //   122	132	257	finally
    //   135	143	257	finally
    //   146	152	257	finally
    //   159	175	257	finally
    //   203	209	257	finally
    //   212	225	257	finally
    //   104	114	265	java/lang/Exception
    //   122	132	265	java/lang/Exception
    //   135	143	265	java/lang/Exception
    //   146	152	265	java/lang/Exception
    //   159	175	265	java/lang/Exception
  }
  
  /* Error */
  public List b(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +49 -> 50
    //   4: getstatic 307	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 92	com/tencent/mobileqq/activity/photo/AlbumListAdapter:d	[Ljava/lang/String;
    //   16: ldc 28
    //   18: aconst_null
    //   19: ldc 21
    //   21: invokevirtual 199	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +50 -> 76
    //   29: aconst_null
    //   30: astore_1
    //   31: aload_1
    //   32: astore 4
    //   34: aload_3
    //   35: ifnull +12 -> 47
    //   38: aload_3
    //   39: invokeinterface 369 1 0
    //   44: aload_1
    //   45: astore 4
    //   47: aload 4
    //   49: areturn
    //   50: getstatic 307	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 171	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore_3
    //   57: aload_3
    //   58: ldc -83
    //   60: iload_2
    //   61: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   64: invokevirtual 183	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   67: pop
    //   68: aload_3
    //   69: invokevirtual 187	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   72: astore_3
    //   73: goto -65 -> 8
    //   76: aload_3
    //   77: astore 4
    //   79: new 392	java/util/LinkedList
    //   82: dup
    //   83: invokespecial 393	java/util/LinkedList:<init>	()V
    //   86: astore_1
    //   87: aload_3
    //   88: astore 4
    //   90: aload_3
    //   91: ldc 57
    //   93: invokeinterface 396 2 0
    //   98: istore_2
    //   99: aload_3
    //   100: astore 4
    //   102: aload_3
    //   103: ldc 80
    //   105: invokeinterface 396 2 0
    //   110: istore 8
    //   112: aload_3
    //   113: astore 4
    //   115: aload_3
    //   116: ldc 59
    //   118: invokeinterface 396 2 0
    //   123: istore 9
    //   125: aload_3
    //   126: astore 4
    //   128: aload_3
    //   129: ldc 65
    //   131: invokeinterface 396 2 0
    //   136: istore 10
    //   138: aload_3
    //   139: astore 4
    //   141: aload_3
    //   142: ldc 63
    //   144: invokeinterface 396 2 0
    //   149: istore 11
    //   151: aload_3
    //   152: astore 4
    //   154: aload_3
    //   155: ldc 69
    //   157: invokeinterface 396 2 0
    //   162: istore 12
    //   164: aload_3
    //   165: astore 4
    //   167: aload_3
    //   168: ldc_w 398
    //   171: invokeinterface 396 2 0
    //   176: istore 13
    //   178: aload_3
    //   179: astore 4
    //   181: aload_3
    //   182: invokeinterface 228 1 0
    //   187: ifeq +245 -> 432
    //   190: aload_3
    //   191: astore 4
    //   193: aload_3
    //   194: iload_2
    //   195: invokeinterface 231 2 0
    //   200: astore 6
    //   202: aload_3
    //   203: astore 4
    //   205: aload_3
    //   206: iload 9
    //   208: invokeinterface 231 2 0
    //   213: astore 7
    //   215: aload_3
    //   216: astore 4
    //   218: aload 6
    //   220: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifne -45 -> 178
    //   226: aload_3
    //   227: astore 4
    //   229: aload 7
    //   231: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne -56 -> 178
    //   237: aload_3
    //   238: astore 4
    //   240: aload_3
    //   241: iload 11
    //   243: invokeinterface 235 2 0
    //   248: lstore 14
    //   250: aload_3
    //   251: astore 4
    //   253: new 288	com/tencent/mobileqq/data/QQAlbumInfo
    //   256: dup
    //   257: invokespecial 292	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   260: astore 5
    //   262: aload_3
    //   263: astore 4
    //   265: aload 5
    //   267: aload 7
    //   269: putfield 301	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   272: aload_3
    //   273: astore 4
    //   275: aload 5
    //   277: aload 6
    //   279: putfield 296	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   282: aload_3
    //   283: astore 4
    //   285: aload 5
    //   287: lload 14
    //   289: putfield 406	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: getfield 344	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   300: astore 6
    //   302: aload_3
    //   303: astore 4
    //   305: aload 6
    //   307: aload_3
    //   308: iload 10
    //   310: invokeinterface 231 2 0
    //   315: putfield 257	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   318: aload_3
    //   319: astore 4
    //   321: aload 6
    //   323: aload_3
    //   324: iload 8
    //   326: invokeinterface 235 2 0
    //   331: putfield 255	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_Long	J
    //   334: aload_3
    //   335: astore 4
    //   337: aload 6
    //   339: lload 14
    //   341: putfield 259	com/tencent/mobileqq/activity/photo/LocalMediaInfo:d	J
    //   344: aload_3
    //   345: astore 4
    //   347: aload 6
    //   349: aload_3
    //   350: iload 12
    //   352: invokeinterface 231 2 0
    //   357: putfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   360: aload_3
    //   361: astore 4
    //   363: aload 5
    //   365: aload_3
    //   366: iload 13
    //   368: invokeinterface 409 2 0
    //   373: putfield 304	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   376: aload_3
    //   377: astore 4
    //   379: aload_1
    //   380: aload 5
    //   382: invokeinterface 421 2 0
    //   387: pop
    //   388: goto -210 -> 178
    //   391: astore 5
    //   393: aload_3
    //   394: astore 4
    //   396: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +18 -> 417
    //   402: aload_3
    //   403: astore 4
    //   405: ldc_w 423
    //   408: iconst_2
    //   409: ldc_w 609
    //   412: aload 5
    //   414: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   417: aload_1
    //   418: astore 4
    //   420: aload_3
    //   421: ifnull -374 -> 47
    //   424: aload_3
    //   425: invokeinterface 369 1 0
    //   430: aload_1
    //   431: areturn
    //   432: aload_1
    //   433: astore 4
    //   435: aload_3
    //   436: ifnull -389 -> 47
    //   439: aload_3
    //   440: invokeinterface 369 1 0
    //   445: aload_1
    //   446: areturn
    //   447: astore_1
    //   448: aconst_null
    //   449: astore 4
    //   451: aload 4
    //   453: ifnull +10 -> 463
    //   456: aload 4
    //   458: invokeinterface 369 1 0
    //   463: aload_1
    //   464: athrow
    //   465: astore_1
    //   466: goto -15 -> 451
    //   469: astore 5
    //   471: aconst_null
    //   472: astore_3
    //   473: aconst_null
    //   474: astore_1
    //   475: goto -82 -> 393
    //   478: astore 5
    //   480: aconst_null
    //   481: astore_1
    //   482: goto -89 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	AlbumListAdapter
    //   0	485	1	paramContext	Context
    //   0	485	2	paramInt	int
    //   0	485	3	paramMediaFileFilter	MediaFileFilter
    //   32	425	4	localObject1	Object
    //   260	121	5	localQQAlbumInfo	QQAlbumInfo
    //   391	22	5	localException1	Exception
    //   469	1	5	localException2	Exception
    //   478	1	5	localException3	Exception
    //   200	148	6	localObject2	Object
    //   213	55	7	str	String
    //   110	215	8	i	int
    //   123	84	9	j	int
    //   136	173	10	k	int
    //   149	93	11	m	int
    //   162	189	12	n	int
    //   176	191	13	i1	int
    //   248	92	14	l	long
    // Exception table:
    //   from	to	target	type
    //   90	99	391	java/lang/Exception
    //   102	112	391	java/lang/Exception
    //   115	125	391	java/lang/Exception
    //   128	138	391	java/lang/Exception
    //   141	151	391	java/lang/Exception
    //   154	164	391	java/lang/Exception
    //   167	178	391	java/lang/Exception
    //   181	190	391	java/lang/Exception
    //   193	202	391	java/lang/Exception
    //   205	215	391	java/lang/Exception
    //   218	226	391	java/lang/Exception
    //   229	237	391	java/lang/Exception
    //   240	250	391	java/lang/Exception
    //   253	262	391	java/lang/Exception
    //   265	272	391	java/lang/Exception
    //   275	282	391	java/lang/Exception
    //   285	292	391	java/lang/Exception
    //   295	302	391	java/lang/Exception
    //   305	318	391	java/lang/Exception
    //   321	334	391	java/lang/Exception
    //   337	344	391	java/lang/Exception
    //   347	360	391	java/lang/Exception
    //   363	376	391	java/lang/Exception
    //   379	388	391	java/lang/Exception
    //   4	8	447	finally
    //   8	25	447	finally
    //   50	73	447	finally
    //   79	87	465	finally
    //   90	99	465	finally
    //   102	112	465	finally
    //   115	125	465	finally
    //   128	138	465	finally
    //   141	151	465	finally
    //   154	164	465	finally
    //   167	178	465	finally
    //   181	190	465	finally
    //   193	202	465	finally
    //   205	215	465	finally
    //   218	226	465	finally
    //   229	237	465	finally
    //   240	250	465	finally
    //   253	262	465	finally
    //   265	272	465	finally
    //   275	282	465	finally
    //   285	292	465	finally
    //   295	302	465	finally
    //   305	318	465	finally
    //   321	334	465	finally
    //   337	344	465	finally
    //   347	360	465	finally
    //   363	376	465	finally
    //   379	388	465	finally
    //   396	402	465	finally
    //   405	417	465	finally
    //   4	8	469	java/lang/Exception
    //   8	25	469	java/lang/Exception
    //   50	73	469	java/lang/Exception
    //   79	87	478	java/lang/Exception
  }
  
  public void b(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new oqi(this, paramQQAlbumInfo));
  }
  
  void b(List paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new oqh(this, paramList));
  }
  
  public QQAlbumInfo c(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    if (paramMediaFileFilter == null) {
      return null;
    }
    if (paramMediaFileFilter.a()) {
      return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
    }
    return b(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < 2) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i))._id.equals("$VideoAlbumId")) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label132;
          }
          if (paramQQAlbumInfo.mMediaFileCount <= 0) {
            break label118;
          }
          this.jdField_a_of_type_JavaUtilList.set(i, paramQQAlbumInfo);
          break;
        }
        i += 1;
      }
      label118:
      this.jdField_a_of_type_JavaUtilList.remove(i);
      continue;
      label132:
      if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      }
    }
  }
  
  public void d(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      c(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new oqj(this, paramQQAlbumInfo));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.a(((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    TextView localTextView;
    QQAlbumInfo localQQAlbumInfo;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130904082, null);
      localTextView = (TextView)localView;
      localQQAlbumInfo = a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      localTextView.setText(paramView);
      paramViewGroup = localTextView.getCompoundDrawables()[0];
      if (localQQAlbumInfo._id.equals("qzone_album")) {
        break label405;
      }
      if (getItemViewType(paramInt) != 1) {
        break label372;
      }
      if (!localQQAlbumInfo.mCoverInfo.jdField_b_of_type_Boolean) {
        break label357;
      }
      paramView = AlbumUtil.a(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label194:
      Object localObject = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.g = 200;
      ((LocalMediaInfo)localObject).f = 200;
      if ((paramViewGroup == null) || (!URLDrawable.class.isInstance(paramViewGroup))) {
        break label468;
      }
      localObject = (URLDrawable)paramViewGroup;
      paramViewGroup = (ViewGroup)localObject;
      if (!paramView.equals(((URLDrawable)localObject).getURL())) {
        ((URLDrawable)localObject).cancelDownload(true);
      }
    }
    label357:
    label372:
    label384:
    label405:
    label468:
    for (paramViewGroup = null;; paramViewGroup = null)
    {
      if (paramViewGroup == null) {
        if (!VersionUtils.d()) {
          break label384;
        }
      }
      for (paramView = URLDrawableHelper.a(paramView, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);; paramView = URLDrawableHelper.a(paramView, paramViewGroup, paramViewGroup))
      {
        paramView.setTag(localQQAlbumInfo.mCoverInfo);
        paramView.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidContentResResources);
        paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
        localTextView.setCompoundDrawables(paramView, null, paramViewGroup, null);
        return localView;
        localTextView = (TextView)paramView;
        localView = paramView;
        break;
        paramView = AlbumUtil.a(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label194;
        paramView = AlbumUtil.a(localQQAlbumInfo.mCoverInfo);
        break label194;
        paramViewGroup = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839694);
      }
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841955);
      paramView.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidContentResResources);
      paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
      localTextView.setCompoundDrawables(paramView, null, paramViewGroup, null);
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return AlbumUtil.d.size();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\AlbumListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */