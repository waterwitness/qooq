package com.tencent.mobileqq.profile;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileShoppingPhotoInfo
  extends Entity
{
  public static final int FOLLOW_TYPE_CANCEL_CARE = 3;
  public static final int FOLLOW_TYPE_NORMAL_CARE = 1;
  public static final int FOLLOW_TYPE_NOT_CARE = 2;
  public static final String TAG = "ProfileShoppingPhotoInfo";
  private static Object mLock = new Object();
  public static LRULinkedHashMap photoWinCache;
  public int accountFlag;
  public String bindShoppingNo;
  public int certifiedGrade;
  public int followType;
  public byte[] picByteData;
  public int seqNo;
  public String shopName;
  @unique
  public String uin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    photoWinCache = new LRULinkedHashMap(20);
  }
  
  public static byte[] converPhoto2RawData(List paramList)
  {
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ShoppingPhotoItemInfo localShoppingPhotoItemInfo = (ShoppingPhotoItemInfo)paramList.next();
      if (localShoppingPhotoItemInfo != null) {
        ((List)localObject).add(localShoppingPhotoItemInfo.a());
      }
    }
    paramList = Parcel.obtain();
    paramList.setDataPosition(0);
    paramList.writeList((List)localObject);
    localObject = paramList.marshall();
    paramList.recycle();
    return (byte[])localObject;
  }
  
  public static ProfileShoppingPhotoInfo getPhotoInfo(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo begins");
    }
    for (;;)
    {
      synchronized (mLock)
      {
        localProfileShoppingPhotoInfo = (ProfileShoppingPhotoInfo)photoWinCache.get(paramString);
        if (localProfileShoppingPhotoInfo != null)
        {
          paramQQAppInterface = localProfileShoppingPhotoInfo;
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo ends, in cache." + localProfileShoppingPhotoInfo.getPrintInfo());
            paramQQAppInterface = localProfileShoppingPhotoInfo;
          }
          return paramQQAppInterface;
        }
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = (ProfileShoppingPhotoInfo)paramQQAppInterface.a(ProfileShoppingPhotoInfo.class, paramString);
      paramQQAppInterface.a();
      paramQQAppInterface = mLock;
      if ((localProfileShoppingPhotoInfo != null) && (paramString != null)) {}
      try
      {
        photoWinCache.put(paramString, localProfileShoppingPhotoInfo);
        paramQQAppInterface = localProfileShoppingPhotoInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramQQAppInterface = "";
        if (localProfileShoppingPhotoInfo != null) {
          paramQQAppInterface = localProfileShoppingPhotoInfo.getPrintInfo();
        }
        QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo ends, read from db." + paramQQAppInterface);
        return localProfileShoppingPhotoInfo;
      }
      finally {}
    }
  }
  
  public static List parseShoppingPhotoJson(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("config_arr");
        if ((paramString != null) && (paramString.length() != 0))
        {
          int k = paramString.length();
          int i = 0;
          while (i < k)
          {
            Object localObject = paramString.getJSONObject(i);
            if (1 == ((JSONObject)localObject).getInt("type"))
            {
              localObject = ((JSONObject)localObject).getJSONArray("config");
              if ((localObject != null) && (((JSONArray)localObject).length() > 0))
              {
                int m = ((JSONArray)localObject).length();
                int j = 0;
                while (j < m)
                {
                  ShoppingPhotoItemInfo localShoppingPhotoItemInfo = new ShoppingPhotoItemInfo();
                  localShoppingPhotoItemInfo.b = ((JSONArray)localObject).getJSONObject(j).getString("url");
                  localShoppingPhotoItemInfo.a = ((JSONArray)localObject).getJSONObject(j).getJSONArray("pic_url").getString(0);
                  localArrayList.add(localShoppingPhotoItemInfo);
                  j += 1;
                }
              }
            }
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception paramString) {}
    }
    QLog.w("ProfileShoppingPhotoInfo", 2, "parse json err:" + paramString.getMessage());
    return localArrayList;
  }
  
  public static void savePhotoInfo2DB(ProfileShoppingPhotoInfo paramProfileShoppingPhotoInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingPhotoInfo", 2, "func savePhotoInfo2DB begins, photoInfo:" + paramProfileShoppingPhotoInfo);
    }
    if (paramProfileShoppingPhotoInfo == null) {
      return;
    }
    Object localObject = mLock;
    if (paramProfileShoppingPhotoInfo != null) {}
    for (;;)
    {
      try
      {
        if (paramProfileShoppingPhotoInfo.uin != null) {
          photoWinCache.put(paramProfileShoppingPhotoInfo.uin, paramProfileShoppingPhotoInfo);
        }
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        if (paramProfileShoppingPhotoInfo.getStatus() == 1000)
        {
          paramQQAppInterface.a(paramProfileShoppingPhotoInfo);
          paramQQAppInterface.a();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileShoppingPhotoInfo", 2, "func savePhotoInfo2DB ends." + paramProfileShoppingPhotoInfo.getPrintInfo());
          return;
        }
      }
      finally {}
      paramQQAppInterface.a(paramProfileShoppingPhotoInfo);
    }
  }
  
  /* Error */
  public List getPhotoFromRawData()
  {
    // Byte code:
    //   0: new 57	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 58	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 250	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   12: ifnonnull +5 -> 17
    //   15: aload_2
    //   16: areturn
    //   17: invokestatic 90	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 250	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 250	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   31: arraylength
    //   32: invokevirtual 254	android/os/Parcel:unmarshall	([BII)V
    //   35: aload_1
    //   36: iconst_0
    //   37: invokevirtual 93	android/os/Parcel:setDataPosition	(I)V
    //   40: aload_1
    //   41: aload_0
    //   42: invokevirtual 258	java/lang/Object:getClass	()Ljava/lang/Class;
    //   45: invokevirtual 264	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   48: invokevirtual 268	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +16 -> 69
    //   56: aload_3
    //   57: invokeinterface 271 1 0
    //   62: istore 6
    //   64: iload 6
    //   66: ifne +9 -> 75
    //   69: aload_1
    //   70: invokevirtual 104	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: areturn
    //   75: aload_3
    //   76: invokeinterface 64 1 0
    //   81: astore_3
    //   82: aload_3
    //   83: invokeinterface 70 1 0
    //   88: ifeq +84 -> 172
    //   91: aload_3
    //   92: invokeinterface 74 1 0
    //   97: checkcast 273	java/lang/String
    //   100: astore 4
    //   102: new 76	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo
    //   105: dup
    //   106: invokespecial 202	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo:<init>	()V
    //   109: astore 5
    //   111: aload 5
    //   113: aload 4
    //   115: invokevirtual 275	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo:a	(Ljava/lang/String;)V
    //   118: aload_2
    //   119: aload 5
    //   121: invokeinterface 84 2 0
    //   126: pop
    //   127: goto -45 -> 82
    //   130: astore_3
    //   131: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +32 -> 166
    //   137: ldc 15
    //   139: iconst_2
    //   140: new 123	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 277
    //   150: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 226	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 104	android/os/Parcel:recycle	()V
    //   170: aload_2
    //   171: areturn
    //   172: aload_1
    //   173: invokevirtual 104	android/os/Parcel:recycle	()V
    //   176: goto -6 -> 170
    //   179: astore_2
    //   180: aload_1
    //   181: invokevirtual 104	android/os/Parcel:recycle	()V
    //   184: aload_2
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	ProfileShoppingPhotoInfo
    //   20	161	1	localParcel	Parcel
    //   7	164	2	localArrayList	ArrayList
    //   179	6	2	localObject1	Object
    //   51	41	3	localObject2	Object
    //   130	24	3	localException	Exception
    //   100	14	4	str	String
    //   109	11	5	localShoppingPhotoItemInfo	ShoppingPhotoItemInfo
    //   62	3	6	i	int
    // Exception table:
    //   from	to	target	type
    //   21	52	130	java/lang/Exception
    //   56	64	130	java/lang/Exception
    //   75	82	130	java/lang/Exception
    //   82	127	130	java/lang/Exception
    //   21	52	179	finally
    //   56	64	179	finally
    //   75	82	179	finally
    //   82	127	179	finally
    //   131	166	179	finally
  }
  
  public String getPrintInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/n Info->[uin]:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",[seqNo]:");
    localStringBuilder.append(this.seqNo);
    localStringBuilder.append(",[followType]:");
    localStringBuilder.append(this.followType);
    localStringBuilder.append(",[accountFlag]:");
    localStringBuilder.append(this.accountFlag);
    localStringBuilder.append(",[shopName]:");
    localStringBuilder.append(this.shopName);
    localStringBuilder.append(",[bindShoppingNo]:");
    localStringBuilder.append(this.bindShoppingNo);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ProfileShoppingPhotoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */