package com.tencent.mobileqq.activity.leba;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LebaShowListManager
{
  public static final int a = 1;
  private static volatile LebaShowListManager jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final int b = 2;
  public static final int c = 4;
  public static volatile int d;
  public HashMap a;
  protected List a;
  public boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private LebaShowListManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    d = 0;
  }
  
  public static Bitmap a(File paramFile)
  {
    Bitmap localBitmap = null;
    Object localObject = localBitmap;
    if (paramFile != null)
    {
      localObject = localBitmap;
      if (BaseApplicationImpl.a != null)
      {
        String str = "LebaIcon://" + paramFile.getAbsolutePath();
        localBitmap = (Bitmap)BaseApplicationImpl.a.get(str);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          localObject = localBitmap;
          if (paramFile.exists())
          {
            paramFile = LebaUtil.a(paramFile);
            localObject = paramFile;
            if (paramFile != null)
            {
              BaseApplicationImpl.a.put(str, paramFile);
              localObject = paramFile;
            }
          }
        }
      }
    }
    return (Bitmap)localObject;
  }
  
  public static LebaShowListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager = new LebaShowListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
    }
  }
  
  public LebaViewItem a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == paramLong) {
        return localLebaViewItem;
      }
    }
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 886L) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 905L) && (((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 1058L) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 3042L)) || ((PublicAccountConfigUtil.g) && (PublicAccountConfigUtil.f) && (((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 1061L) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 3043L)) || ((PublicAccountConfigUtil.g) && (PublicAccountConfigUtil.f) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType != 1)))))) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
  
  /* Error */
  public List a(android.content.Context paramContext, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 158	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +54 -> 57
    //   6: ldc -96
    //   8: iconst_4
    //   9: new 50	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   16: ldc -94
    //   18: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 164	com/tencent/mobileqq/activity/leba/LebaShowListManager:jdField_a_of_type_Boolean	Z
    //   25: invokevirtual 167	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc -87
    //   30: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc -87
    //   39: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc -82
    //   48: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 37	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 38	java/util/ArrayList:<init>	()V
    //   64: astore_3
    //   65: new 37	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 38	java/util/ArrayList:<init>	()V
    //   72: astore 4
    //   74: aload_2
    //   75: invokevirtual 181	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/util/List;
    //   78: astore 5
    //   80: aload 5
    //   82: ifnull +620 -> 702
    //   85: new 37	java/util/ArrayList
    //   88: dup
    //   89: aload 5
    //   91: invokespecial 184	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   94: astore 6
    //   96: new 37	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 38	java/util/ArrayList:<init>	()V
    //   103: astore 5
    //   105: aload 6
    //   107: invokeinterface 100 1 0
    //   112: astore 6
    //   114: aload 6
    //   116: invokeinterface 105 1 0
    //   121: ifeq +536 -> 657
    //   124: aload 6
    //   126: invokeinterface 109 1 0
    //   131: checkcast 116	com/tencent/mobileqq/data/ResourcePluginInfo
    //   134: astore 8
    //   136: aload 8
    //   138: ifnull -24 -> 114
    //   141: aload 8
    //   143: getfield 187	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   146: ifeq -32 -> 114
    //   149: new 111	com/tencent/mobileqq/config/struct/LebaViewItem
    //   152: dup
    //   153: invokespecial 188	com/tencent/mobileqq/config/struct/LebaViewItem:<init>	()V
    //   156: astore 7
    //   158: aload 8
    //   160: getfield 144	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   163: iconst_1
    //   164: if_icmpeq +378 -> 542
    //   167: aload_1
    //   168: aload 8
    //   170: getfield 192	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   173: aload 8
    //   175: getfield 195	com/tencent/mobileqq/data/ResourcePluginInfo:strResURL	Ljava/lang/String;
    //   178: invokestatic 198	com/tencent/mobileqq/app/LebaUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   181: astore 9
    //   183: aload 9
    //   185: invokestatic 199	com/tencent/mobileqq/activity/leba/LebaShowListManager:a	(Ljava/io/File;)Landroid/graphics/Bitmap;
    //   188: astore 10
    //   190: aload 10
    //   192: ifnull +305 -> 497
    //   195: aload 7
    //   197: aload 10
    //   199: putfield 202	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   202: aload 9
    //   204: invokevirtual 78	java/io/File:exists	()Z
    //   207: ifeq +8 -> 215
    //   210: aload 10
    //   212: ifnonnull +104 -> 316
    //   215: aload 9
    //   217: invokevirtual 78	java/io/File:exists	()Z
    //   220: ifeq +28 -> 248
    //   223: aload 10
    //   225: ifnonnull +23 -> 248
    //   228: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +11 -> 242
    //   234: ldc -49
    //   236: iconst_2
    //   237: ldc -47
    //   239: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 9
    //   244: invokevirtual 214	java/io/File:delete	()Z
    //   247: pop
    //   248: new 32	java/util/HashMap
    //   251: dup
    //   252: invokespecial 33	java/util/HashMap:<init>	()V
    //   255: astore 10
    //   257: aload 10
    //   259: ldc -40
    //   261: aload 8
    //   263: getfield 192	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   266: invokeinterface 219 3 0
    //   271: pop
    //   272: aload 10
    //   274: ldc -35
    //   276: new 223	java/net/URL
    //   279: dup
    //   280: aload 8
    //   282: getfield 195	com/tencent/mobileqq/data/ResourcePluginInfo:strResURL	Ljava/lang/String;
    //   285: invokespecial 226	java/net/URL:<init>	(Ljava/lang/String;)V
    //   288: invokeinterface 219 3 0
    //   293: pop
    //   294: aload 10
    //   296: ldc -28
    //   298: aload 9
    //   300: invokeinterface 219 3 0
    //   305: pop
    //   306: aload 4
    //   308: aload 10
    //   310: invokeinterface 148 2 0
    //   315: pop
    //   316: aload 7
    //   318: aload 8
    //   320: putfield 114	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   323: aload 8
    //   325: getfield 144	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   328: iconst_1
    //   329: if_icmpeq +112 -> 441
    //   332: aload_2
    //   333: aload_1
    //   334: aload 8
    //   336: getfield 231	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   339: invokestatic 236	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   342: astore 9
    //   344: aload 9
    //   346: ifnull +95 -> 441
    //   349: ldc -18
    //   351: aload 9
    //   353: invokevirtual 242	com/tencent/mobileqq/utils/JumpAction:a	()Ljava/lang/String;
    //   356: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   359: ifeq +82 -> 441
    //   362: aload 9
    //   364: ldc -7
    //   366: invokevirtual 252	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore 8
    //   371: aload 9
    //   373: ldc -2
    //   375: invokevirtual 252	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)Ljava/lang/String;
    //   378: astore 10
    //   380: aload 8
    //   382: ifnull +20 -> 402
    //   385: aload 8
    //   387: ldc_w 256
    //   390: invokevirtual 260	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   393: ifne +9 -> 402
    //   396: invokestatic 264	cooperation/readinjoy/ReadInJoyHelper:a	()Z
    //   399: ifeq -285 -> 114
    //   402: aload 8
    //   404: ifnull +37 -> 441
    //   407: aload 10
    //   409: ifnull +32 -> 441
    //   412: aload_1
    //   413: invokevirtual 270	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   416: astore 9
    //   418: new 272	android/content/ComponentName
    //   421: dup
    //   422: aload 10
    //   424: aload 8
    //   426: invokespecial 275	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: astore 8
    //   431: aload 9
    //   433: aload 8
    //   435: bipush 32
    //   437: invokevirtual 281	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   440: pop
    //   441: aload 7
    //   443: invokestatic 284	com/tencent/mobileqq/app/LebaUtil:a	(Lcom/tencent/mobileqq/config/struct/LebaViewItem;)Z
    //   446: ifeq +172 -> 618
    //   449: aload_0
    //   450: getfield 35	com/tencent/mobileqq/activity/leba/LebaShowListManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   453: aload 7
    //   455: getfield 114	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   458: getfield 192	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   461: aload 7
    //   463: invokevirtual 285	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: goto -353 -> 114
    //   470: astore 7
    //   472: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -361 -> 114
    //   478: aload 7
    //   480: ifnull -366 -> 114
    //   483: ldc -96
    //   485: iconst_2
    //   486: aload 7
    //   488: invokevirtual 286	java/lang/Exception:toString	()Ljava/lang/String;
    //   491: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: goto -380 -> 114
    //   497: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +33 -> 533
    //   503: ldc -49
    //   505: iconst_2
    //   506: new 50	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 288
    //   516: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 8
    //   521: getfield 291	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   524: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload 7
    //   535: aconst_null
    //   536: putfield 202	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   539: goto -337 -> 202
    //   542: aload_1
    //   543: invokevirtual 295	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   546: aload 8
    //   548: getfield 195	com/tencent/mobileqq/data/ResourcePluginInfo:strResURL	Ljava/lang/String;
    //   551: ldc_w 297
    //   554: aload_1
    //   555: invokevirtual 300	android/content/Context:getPackageName	()Ljava/lang/String;
    //   558: invokevirtual 306	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   561: istore 11
    //   563: iload 11
    //   565: ifeq -249 -> 316
    //   568: aload_1
    //   569: invokevirtual 295	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   572: iload 11
    //   574: invokevirtual 310	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   577: astore 9
    //   579: aload 9
    //   581: ifnull -265 -> 316
    //   584: aload 9
    //   586: instanceof 312
    //   589: ifeq -273 -> 316
    //   592: aload 7
    //   594: aload 9
    //   596: checkcast 312	android/graphics/drawable/BitmapDrawable
    //   599: invokevirtual 316	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   602: putfield 202	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   605: goto -289 -> 316
    //   608: astore 7
    //   610: aload 7
    //   612: invokevirtual 319	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   615: goto -501 -> 114
    //   618: aload 7
    //   620: getfield 114	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   623: getfield 144	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   626: ifne +18 -> 644
    //   629: aload 7
    //   631: getfield 114	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   634: getfield 120	com/tencent/mobileqq/data/ResourcePluginInfo:uiResId	J
    //   637: ldc2_w 320
    //   640: lcmp
    //   641: ifeq -527 -> 114
    //   644: aload 5
    //   646: aload 7
    //   648: invokeinterface 148 2 0
    //   653: pop
    //   654: goto -540 -> 114
    //   657: aload 5
    //   659: new 323	com/tencent/mobileqq/app/LebaUtil$LebaItemComparator
    //   662: dup
    //   663: invokespecial 324	com/tencent/mobileqq/app/LebaUtil$LebaItemComparator:<init>	()V
    //   666: invokestatic 330	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   669: aload_2
    //   670: bipush 35
    //   672: invokevirtual 334	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   675: checkcast 336	com/tencent/mobileqq/redtouch/RedTouchManager
    //   678: astore_1
    //   679: aload_1
    //   680: ifnonnull +43 -> 723
    //   683: aconst_null
    //   684: astore_1
    //   685: aload_0
    //   686: aload_2
    //   687: aload 5
    //   689: aload_1
    //   690: invokevirtual 339	com/tencent/mobileqq/activity/leba/LebaShowListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;Ljava/util/List;)V
    //   693: aload_3
    //   694: aload_0
    //   695: aload_2
    //   696: invokevirtual 342	com/tencent/mobileqq/activity/leba/LebaShowListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   699: invokestatic 345	com/tencent/mobileqq/app/LebaUtil:a	(Ljava/util/List;Ljava/util/List;)V
    //   702: aload 4
    //   704: invokeinterface 349 1 0
    //   709: ifle +12 -> 721
    //   712: aload_2
    //   713: getfield 352	com/tencent/mobileqq/app/QQAppInterface:a	Lcom/tencent/mobileqq/app/LebaHelper;
    //   716: aload 4
    //   718: invokevirtual 357	com/tencent/mobileqq/app/LebaHelper:a	(Ljava/util/List;)V
    //   721: aload_3
    //   722: areturn
    //   723: aload_1
    //   724: invokevirtual 359	com/tencent/mobileqq/redtouch/RedTouchManager:b	()Ljava/util/List;
    //   727: astore_1
    //   728: goto -43 -> 685
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	731	0	this	LebaShowListManager
    //   0	731	1	paramContext	android.content.Context
    //   0	731	2	paramQQAppInterface	QQAppInterface
    //   64	658	3	localArrayList1	ArrayList
    //   72	645	4	localArrayList2	ArrayList
    //   78	610	5	localObject1	Object
    //   94	31	6	localObject2	Object
    //   156	306	7	localLebaViewItem	LebaViewItem
    //   470	123	7	localException	Exception
    //   608	39	7	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   134	413	8	localObject3	Object
    //   181	414	9	localObject4	Object
    //   188	235	10	localObject5	Object
    //   561	12	11	i	int
    // Exception table:
    //   from	to	target	type
    //   158	190	470	java/lang/Exception
    //   195	202	470	java/lang/Exception
    //   202	210	470	java/lang/Exception
    //   215	223	470	java/lang/Exception
    //   228	242	470	java/lang/Exception
    //   242	248	470	java/lang/Exception
    //   248	316	470	java/lang/Exception
    //   316	344	470	java/lang/Exception
    //   349	380	470	java/lang/Exception
    //   385	402	470	java/lang/Exception
    //   412	431	470	java/lang/Exception
    //   431	441	470	java/lang/Exception
    //   441	467	470	java/lang/Exception
    //   497	533	470	java/lang/Exception
    //   533	539	470	java/lang/Exception
    //   542	563	470	java/lang/Exception
    //   568	579	470	java/lang/Exception
    //   584	605	470	java/lang/Exception
    //   610	615	470	java/lang/Exception
    //   618	644	470	java/lang/Exception
    //   644	654	470	java/lang/Exception
    //   431	441	608	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public List a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + paramQQAppInterface.a(), "00000").charAt(2);
    for (;;)
    {
      LebaViewItem localLebaViewItem;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 905L)) {
          continue;
        }
        if (Leba.a(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId))
        {
          if ((!PublicAccountConfigUtil.f) || (!PublicAccountConfigUtil.g) || (localLebaViewItem.jdField_a_of_type_Byte != 0)) {
            continue;
          }
          localArrayList.add(localLebaViewItem);
        }
      }
      if (!Leba.b(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId)) {
        if (((i == 48) || (paramQQAppInterface.a().jdField_a_of_type_Boolean)) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 3050L))
        {
          paramQQAppInterface.a().b = false;
        }
        else
        {
          paramQQAppInterface.a().b = true;
          if ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 0L)) {
            localArrayList.add(localLebaViewItem);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      d = 0;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if (localLebaViewItem != null) {
          if (localLebaViewItem.jdField_a_of_type_Byte == 0)
          {
            if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) {
              ReportController.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
            }
          }
          else if ((localLebaViewItem.jdField_a_of_type_Byte == 1) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      int j;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label268;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localLebaViewItem.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 != Long.MIN_VALUE) {
            continue;
          }
          localLebaViewItem.jdField_a_of_type_Long = paramLong2;
          i = 1;
          j = i;
          if (paramQQAppInterface != null)
          {
            j = i;
            if (i != 1) {}
          }
        }
        try
        {
          paramQQAppInterface = (RedTouchManager)paramQQAppInterface.getManager(35);
          i = (int)paramLong1;
          if (paramLong3 != Long.MIN_VALUE) {
            break label229;
          }
          j = paramQQAppInterface.a(i, paramBoolean, paramLong2);
        }
        catch (Exception paramQQAppInterface)
        {
          i = -2;
          j = i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.lebatab.mgr", 2, paramQQAppInterface.toString());
          j = i;
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + j);
        }
        return;
        i = 1;
        continue;
        if (paramLong2 != localLebaViewItem.jdField_a_of_type_Long) {
          break label274;
        }
        localLebaViewItem.jdField_a_of_type_Long = paramLong3;
        i = 1;
      }
      label229:
      paramLong2 = paramLong3;
      continue;
      label268:
      int i = 1;
      continue;
      label274:
      i = Integer.MIN_VALUE;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList1 != null) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramList1 != null) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
        }
        a(paramList2);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (RedTouchHandler)paramQQAppInterface.a(31);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(1, true, null);
          }
        }
        return;
        label111:
        i = paramList1.size();
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator1.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
          continue;
        }
        long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b1 = 0;
          localLebaViewItem.jdField_a_of_type_Byte = b1;
          localLebaViewItem.jdField_a_of_type_Long = localAppSetting.modify_ts.get();
        }
      }
      byte b1 = 1;
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 905L)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 905L) && ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 0L))) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\leba\LebaShowListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */