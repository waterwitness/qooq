package com.tencent.mobileqq.data;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QZonePhotoWall
  extends Entity
{
  public String attachInfo;
  @notColumn
  public int curListSize;
  public int hasMore;
  public int totalPic;
  @unique
  public String uin;
  public byte[] vPhotoIds;
  public byte[] vPhotoTimes;
  public byte[] vPhotoUrls;
  
  public QZonePhotoWall()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void packPhotoWallData(String paramString, ArrayList paramArrayList)
  {
    Object localObject1 = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = unpackPhotoWallData();; paramString = (String)localObject1)
    {
      paramString.addAll(paramArrayList);
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      paramArrayList = new ArrayList();
      Object localObject3 = paramString.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        PhotoWall localPhotoWall = (PhotoWall)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(localPhotoWall.photoId);
        ((ArrayList)localObject1).add(Long.valueOf(localPhotoWall.ctime));
        paramArrayList.add(localPhotoWall.photoUrls);
      }
      localObject3 = Parcel.obtain();
      ((Parcel)localObject3).setDataPosition(0);
      ((Parcel)localObject3).writeList((List)localObject2);
      this.vPhotoIds = ((Parcel)localObject3).marshall();
      ((Parcel)localObject3).recycle();
      localObject2 = Parcel.obtain();
      ((Parcel)localObject2).setDataPosition(0);
      ((Parcel)localObject2).writeList((List)localObject1);
      this.vPhotoTimes = ((Parcel)localObject2).marshall();
      ((Parcel)localObject2).recycle();
      localObject1 = Parcel.obtain();
      ((Parcel)localObject1).setDataPosition(0);
      ((Parcel)localObject1).writeList(paramArrayList);
      this.vPhotoUrls = ((Parcel)localObject1).marshall();
      ((Parcel)localObject1).recycle();
      this.curListSize = paramString.size();
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("QZonePhotoWall totalPic:").append(this.totalPic);
    localStringBuilder.append(" hasMore:").append(this.hasMore);
    localStringBuilder.append(" photoWallSize:").append(this.curListSize);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public ArrayList unpackPhotoWallData()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 32	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 33	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 104	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoIds	[B
    //   19: ifnull +470 -> 489
    //   22: invokestatic 90	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 104	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoIds	[B
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 104	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoIds	[B
    //   36: arraylength
    //   37: invokevirtual 150	android/os/Parcel:unmarshall	([BII)V
    //   40: aload_2
    //   41: iconst_0
    //   42: invokevirtual 94	android/os/Parcel:setDataPosition	(I)V
    //   45: aload_2
    //   46: aload_0
    //   47: invokevirtual 156	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: invokevirtual 162	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   53: invokevirtual 166	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 107	android/os/Parcel:recycle	()V
    //   61: aload_0
    //   62: getfield 109	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoTimes	[B
    //   65: ifnull +419 -> 484
    //   68: invokestatic 90	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   71: astore_3
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 109	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoTimes	[B
    //   77: iconst_0
    //   78: aload_0
    //   79: getfield 109	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoTimes	[B
    //   82: arraylength
    //   83: invokevirtual 150	android/os/Parcel:unmarshall	([BII)V
    //   86: aload_3
    //   87: iconst_0
    //   88: invokevirtual 94	android/os/Parcel:setDataPosition	(I)V
    //   91: aload_3
    //   92: aload_0
    //   93: invokevirtual 156	java/lang/Object:getClass	()Ljava/lang/Class;
    //   96: invokevirtual 162	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   99: invokevirtual 166	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 107	android/os/Parcel:recycle	()V
    //   107: aload_0
    //   108: getfield 111	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoUrls	[B
    //   111: ifnull +368 -> 479
    //   114: aload 5
    //   116: astore_3
    //   117: aload 6
    //   119: astore 4
    //   121: invokestatic 90	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   124: astore 8
    //   126: aload 5
    //   128: astore_3
    //   129: aload 6
    //   131: astore 4
    //   133: aload 8
    //   135: aload_0
    //   136: getfield 111	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoUrls	[B
    //   139: iconst_0
    //   140: aload_0
    //   141: getfield 111	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoUrls	[B
    //   144: arraylength
    //   145: invokevirtual 150	android/os/Parcel:unmarshall	([BII)V
    //   148: aload 5
    //   150: astore_3
    //   151: aload 6
    //   153: astore 4
    //   155: aload 8
    //   157: iconst_0
    //   158: invokevirtual 94	android/os/Parcel:setDataPosition	(I)V
    //   161: aload 5
    //   163: astore_3
    //   164: aload 6
    //   166: astore 4
    //   168: aload 8
    //   170: aload_0
    //   171: invokevirtual 156	java/lang/Object:getClass	()Ljava/lang/Class;
    //   174: invokevirtual 162	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   177: invokevirtual 166	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   180: astore 5
    //   182: aload 5
    //   184: astore_3
    //   185: aload 5
    //   187: astore 4
    //   189: aload 8
    //   191: invokevirtual 107	android/os/Parcel:recycle	()V
    //   194: aload 5
    //   196: astore_3
    //   197: aload_1
    //   198: ifnull +262 -> 460
    //   201: aload_2
    //   202: ifnull +258 -> 460
    //   205: aload_3
    //   206: ifnull +254 -> 460
    //   209: iconst_0
    //   210: istore 9
    //   212: iload 9
    //   214: aload_1
    //   215: invokevirtual 115	java/util/ArrayList:size	()I
    //   218: if_icmpge +242 -> 460
    //   221: new 63	NS_MOBILE_MAIN_PAGE/PhotoWall
    //   224: dup
    //   225: invokespecial 167	NS_MOBILE_MAIN_PAGE/PhotoWall:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: aload_2
    //   233: iload 9
    //   235: invokevirtual 171	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   238: checkcast 76	java/lang/Long
    //   241: invokevirtual 175	java/lang/Long:longValue	()J
    //   244: putfield 74	NS_MOBILE_MAIN_PAGE/PhotoWall:ctime	J
    //   247: aload 4
    //   249: aload_1
    //   250: iload 9
    //   252: invokevirtual 171	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   255: checkcast 177	java/lang/String
    //   258: putfield 66	NS_MOBILE_MAIN_PAGE/PhotoWall:photoId	Ljava/lang/String;
    //   261: aload 4
    //   263: aload_3
    //   264: iload 9
    //   266: invokevirtual 171	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   269: checkcast 179	java/util/Map
    //   272: putfield 84	NS_MOBILE_MAIN_PAGE/PhotoWall:photoUrls	Ljava/util/Map;
    //   275: aload 7
    //   277: aload 4
    //   279: invokevirtual 70	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: iload 9
    //   285: iconst_1
    //   286: iadd
    //   287: istore 9
    //   289: goto -77 -> 212
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +13 -> 311
    //   301: ldc -70
    //   303: iconst_2
    //   304: aload_2
    //   305: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   308: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: goto -250 -> 61
    //   314: astore_2
    //   315: aconst_null
    //   316: astore_1
    //   317: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +13 -> 333
    //   323: ldc -70
    //   325: iconst_2
    //   326: aload_2
    //   327: invokevirtual 192	java/lang/Error:toString	()Ljava/lang/String;
    //   330: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: goto -272 -> 61
    //   336: astore_3
    //   337: aconst_null
    //   338: astore_2
    //   339: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +13 -> 355
    //   345: ldc -70
    //   347: iconst_2
    //   348: aload_3
    //   349: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   352: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -248 -> 107
    //   358: astore_3
    //   359: aconst_null
    //   360: astore_2
    //   361: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +13 -> 377
    //   367: ldc -70
    //   369: iconst_2
    //   370: aload_3
    //   371: invokevirtual 192	java/lang/Error:toString	()Ljava/lang/String;
    //   374: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: goto -270 -> 107
    //   380: astore 4
    //   382: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +14 -> 399
    //   388: ldc -70
    //   390: iconst_2
    //   391: aload 4
    //   393: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   396: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: goto -202 -> 197
    //   402: astore_3
    //   403: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +13 -> 419
    //   409: ldc -70
    //   411: iconst_2
    //   412: aload_3
    //   413: invokevirtual 192	java/lang/Error:toString	()Ljava/lang/String;
    //   416: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 4
    //   421: astore_3
    //   422: goto -225 -> 197
    //   425: astore_1
    //   426: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +31 -> 460
    //   432: ldc -62
    //   434: iconst_2
    //   435: new 121	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   442: ldc -59
    //   444: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_1
    //   448: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   451: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload 7
    //   462: areturn
    //   463: astore_3
    //   464: goto -103 -> 361
    //   467: astore_3
    //   468: goto -129 -> 339
    //   471: astore_2
    //   472: goto -155 -> 317
    //   475: astore_2
    //   476: goto -181 -> 295
    //   479: aconst_null
    //   480: astore_3
    //   481: goto -284 -> 197
    //   484: aconst_null
    //   485: astore_2
    //   486: goto -379 -> 107
    //   489: aconst_null
    //   490: astore_1
    //   491: goto -430 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	QZonePhotoWall
    //   56	261	1	localArrayList1	ArrayList
    //   425	23	1	localException1	Exception
    //   490	1	1	localObject1	Object
    //   25	208	2	localObject2	Object
    //   292	13	2	localException2	Exception
    //   314	13	2	localError1	Error
    //   338	23	2	localObject3	Object
    //   471	1	2	localError2	Error
    //   475	1	2	localException3	Exception
    //   485	1	2	localObject4	Object
    //   71	193	3	localObject5	Object
    //   336	13	3	localException4	Exception
    //   358	13	3	localError3	Error
    //   402	11	3	localError4	Error
    //   421	1	3	localObject6	Object
    //   463	1	3	localError5	Error
    //   467	1	3	localException5	Exception
    //   480	1	3	localObject7	Object
    //   119	159	4	localObject8	Object
    //   380	40	4	localException6	Exception
    //   4	191	5	localArrayList2	ArrayList
    //   1	164	6	localObject9	Object
    //   13	448	7	localArrayList3	ArrayList
    //   124	66	8	localParcel	Parcel
    //   210	78	9	i	int
    // Exception table:
    //   from	to	target	type
    //   22	57	292	java/lang/Exception
    //   22	57	314	java/lang/Error
    //   68	103	336	java/lang/Exception
    //   68	103	358	java/lang/Error
    //   121	126	380	java/lang/Exception
    //   133	148	380	java/lang/Exception
    //   155	161	380	java/lang/Exception
    //   168	182	380	java/lang/Exception
    //   189	194	380	java/lang/Exception
    //   121	126	402	java/lang/Error
    //   133	148	402	java/lang/Error
    //   155	161	402	java/lang/Error
    //   168	182	402	java/lang/Error
    //   189	194	402	java/lang/Error
    //   212	283	425	java/lang/Exception
    //   103	107	463	java/lang/Error
    //   103	107	467	java/lang/Exception
    //   57	61	471	java/lang/Error
    //   57	61	475	java/lang/Exception
  }
  
  public void updateQzonePhotoWall(String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (parammobile_sub_get_photo_wall_rsp == null) {}
    do
    {
      return;
      this.totalPic = parammobile_sub_get_photo_wall_rsp.total_pic;
      this.hasMore = parammobile_sub_get_photo_wall_rsp.iHasMore;
      packPhotoWallData(paramString, parammobile_sub_get_photo_wall_rsp.vecUrls);
      this.attachInfo = parammobile_sub_get_photo_wall_rsp.attachInfo;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qzonephotowall", 2, "updateQzonePhotoWall " + toString());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\QZonePhotoWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */