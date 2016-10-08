package com.tencent.mobileqq.config;

import EncounterSvc.AlumnusConfigInfo;
import EncounterSvc.NeighborAd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;
import com.tencent.mobileqq.nearpeople.EncounterHolder.EncounterHolderOpt;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.struct.AdGroup;
import com.tencent.mobileqq.struct.NearbyPushBanner;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;
import rai;
import raj;
import rak;
import ral;
import ram;
import ran;

public class NearbyDataManager
  implements Handler.Callback, View.OnClickListener, URLDrawable.URLDrawableListener, Manager
{
  public static byte a = 0;
  public static final int a = 3000;
  public static final String a = "NearbyNiche";
  public static byte b = 0;
  public static final int b = 2;
  public static final String b = "NearbyDataManager";
  public static final int c = 3;
  static final String c = "RESPCONDITION=AUTO&SUBJECT=mqq&DESC=&RESPDESC=&RESPCONTENTTYPES=PLUGIN&RESPDEST=mqqapi://nearby_entry/find_school_mate_guide?src_type%3Dinternal%26version%3D1%26from_type%3D0%26from%3D10003%26sourceid%3d2&RESPCONTENTS=";
  public static final int d = 0;
  public static final String d = "NearbyBannerPic";
  private static final int f = 20;
  private static final String g = "nearby_banner_sp";
  private static final String h = "nearby_banner";
  private static final String j = "|";
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private NearPeopleFilterActivity.NearPeopleFilters jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
  public PicAndAdConf a;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
  public LinkedList a;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  public boolean a;
  private PicAndAdConf jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf;
  private LinkedList jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int e;
  public String e;
  public String f;
  private String i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Byte = 30;
  }
  
  public NearbyDataManager(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramNearbyAppInterface.a().getSharedPreferences("nearby_banner_sp" + paramNearbyAppInterface.a(), 0);
    this.i = (paramNearbyAppInterface.a().getFilesDir().getAbsolutePath() + "/" + paramNearbyAppInterface.a());
    this.jdField_e_of_type_JavaLangString = (paramNearbyAppInterface.a().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic");
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
  }
  
  public static byte a(Activity paramActivity)
  {
    if (jdField_a_of_type_Byte > 0) {
      return jdField_a_of_type_Byte;
    }
    jdField_a_of_type_Byte = (byte)(paramActivity.getResources().getDisplayMetrics().widthPixels / paramActivity.getResources().getDimensionPixelSize(2131493541) - 1);
    return jdField_a_of_type_Byte;
  }
  
  public static int a(NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    if (paramNearPeopleFilters != null) {}
    switch (paramNearPeopleFilters.i)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  public static long a(AppInterface paramAppInterface, Activity paramActivity, NearbyHandler paramNearbyHandler, boolean paramBoolean, NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = a(paramNearPeopleFilters);
    byte b3 = (byte)paramNearPeopleFilters.m;
    byte b4 = (byte)paramNearPeopleFilters.l;
    int k = 480;
    byte b1;
    byte b2;
    if (paramNearPeopleFilters.j == 3)
    {
      k = 480;
      b1 = 0;
      b2 = 0;
      if (paramNearPeopleFilters.k != 0) {
        break label260;
      }
      b1 = 0;
      b2 = 0;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("NearbyFragment", 4, "NearbyActivity doRefreshList=" + paramNearPeopleFilters.i);
      }
      String str = a(paramActivity, paramInt1, paramInt2);
      return paramNearbyHandler.a(m, paramBoolean, null, null, 0, b3, b4, k, b1, b2, paramNearPeopleFilters.n, ConditionSearchManager.a(paramNearPeopleFilters.d[0]), ConditionSearchManager.a(paramNearPeopleFilters.d[1]), ConditionSearchManager.a(paramNearPeopleFilters.d[2]), null, DatingFilters.a(paramActivity, paramAppInterface.a()), str, 63L, a(paramActivity), true, paramAppInterface.getAccount(), paramInt3, 0L);
      if (paramNearPeopleFilters.j == 0)
      {
        k = 30;
        break;
      }
      if (paramNearPeopleFilters.j == 1)
      {
        k = 60;
        break;
      }
      if (paramNearPeopleFilters.j == 2)
      {
        k = 240;
        break;
      }
      DatingUtil.b("doRefreshList time is unknown", new Object[] { Integer.valueOf(paramNearPeopleFilters.j) });
      break;
      label260:
      if (paramNearPeopleFilters.k == 1)
      {
        b1 = 18;
        b2 = 22;
      }
      else if (paramNearPeopleFilters.k == 2)
      {
        b1 = 23;
        b2 = 26;
      }
      else if (paramNearPeopleFilters.k == 3)
      {
        b1 = 27;
        b2 = 35;
      }
      else if (paramNearPeopleFilters.k == 4)
      {
        b1 = 36;
        b2 = Byte.MAX_VALUE;
      }
      else
      {
        DatingUtil.b("doRefreshList agetype is unknown", new Object[] { Integer.valueOf(paramNearPeopleFilters.k) });
      }
    }
  }
  
  public static String a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("dtype", 1);
        paramActivity = (TelephonyManager)paramActivity.getSystemService("phone");
        localJSONObject.put("muid", MD5.toMD5(paramActivity.getDeviceId()));
        paramActivity = paramActivity.getSubscriberId();
        if (!TextUtils.isEmpty(paramActivity))
        {
          if (paramActivity.startsWith("46000")) {
            break label245;
          }
          if (paramActivity.startsWith("46002"))
          {
            break label245;
            localJSONObject.put("carrier", k);
            localJSONObject.put("conn", HttpUtil.a());
            localJSONObject.put("posw", 216);
            localJSONObject.put("posh", 150);
            localJSONObject.put("lat", paramInt1);
            localJSONObject.put("lng", paramInt2);
            localJSONObject.put("c_os", "android");
            localJSONObject.put("c_osver", Build.VERSION.RELEASE);
            return localJSONObject.toString();
          }
          if (paramActivity.startsWith("46001"))
          {
            k = 2;
            continue;
          }
          boolean bool = paramActivity.startsWith("46003");
          if (bool)
          {
            k = 3;
            continue;
          }
        }
        k = 0;
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyFragment", 2, "get ad exera fail, " + paramActivity);
        }
        return "";
      }
      continue;
      label245:
      int k = 1;
    }
  }
  
  private void a(int paramInt)
  {
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "key_config_ver", Integer.valueOf(paramInt));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.runOnUiThread(new ram(this, paramBoolean1, paramBoolean2));
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l <= paramLong1) || (l >= paramLong2));
    return true;
  }
  
  /* Error */
  private boolean a(String paramString, PicAndAdConf paramPicAndAdConf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: iconst_0
    //   6: istore 5
    //   8: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +29 -> 40
    //   14: ldc 24
    //   16: iconst_2
    //   17: new 103	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 382
    //   27: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: iconst_1
    //   41: istore 6
    //   43: new 128	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 385	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 388	java/io/File:exists	()Z
    //   56: ifeq +152 -> 208
    //   59: aload_1
    //   60: invokevirtual 391	java/io/File:canRead	()Z
    //   63: ifeq +145 -> 208
    //   66: aload_1
    //   67: invokevirtual 394	java/io/File:length	()J
    //   70: lconst_0
    //   71: lcmp
    //   72: ifle +136 -> 208
    //   75: new 396	java/io/FileInputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 399	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: astore_1
    //   84: new 401	java/io/DataInputStream
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 404	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore_3
    //   93: aload_2
    //   94: aload_3
    //   95: invokevirtual 409	com/tencent/mobileqq/config/struct/PicAndAdConf:a	(Ljava/io/DataInputStream;)V
    //   98: aload_2
    //   99: invokevirtual 411	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()Z
    //   102: ifeq +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 413	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()V
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 416	java/io/FileInputStream:close	()V
    //   117: iload 6
    //   119: istore 5
    //   121: aload_3
    //   122: ifnull +11 -> 133
    //   125: aload_3
    //   126: invokevirtual 417	java/io/DataInputStream:close	()V
    //   129: iload 6
    //   131: istore 5
    //   133: iload 5
    //   135: ireturn
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_2
    //   139: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +13 -> 155
    //   145: ldc 20
    //   147: iconst_2
    //   148: ldc_w 419
    //   151: aload_1
    //   152: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 416	java/io/FileInputStream:close	()V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 417	java/io/DataInputStream:close	()V
    //   171: iconst_0
    //   172: istore 5
    //   174: goto -41 -> 133
    //   177: astore_1
    //   178: iconst_0
    //   179: istore 5
    //   181: goto -48 -> 133
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_2
    //   187: aload 4
    //   189: astore_3
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 416	java/io/FileInputStream:close	()V
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 417	java/io/DataInputStream:close	()V
    //   206: aload_1
    //   207: athrow
    //   208: aload_0
    //   209: iconst_0
    //   210: invokespecial 424	com/tencent/mobileqq/config/NearbyDataManager:a	(I)V
    //   213: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq -83 -> 133
    //   219: ldc 20
    //   221: iconst_2
    //   222: new 103	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 426
    //   232: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_1
    //   236: invokevirtual 388	java/io/File:exists	()Z
    //   239: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   242: ldc_w 431
    //   245: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 391	java/io/File:canRead	()Z
    //   252: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   255: ldc_w 433
    //   258: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: goto -157 -> 117
    //   277: astore_1
    //   278: iload 6
    //   280: istore 5
    //   282: goto -149 -> 133
    //   285: astore_1
    //   286: goto -123 -> 163
    //   289: astore_3
    //   290: goto -92 -> 198
    //   293: astore_2
    //   294: goto -88 -> 206
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_2
    //   301: aload_1
    //   302: astore_3
    //   303: aload 4
    //   305: astore_1
    //   306: goto -116 -> 190
    //   309: astore_2
    //   310: aload_1
    //   311: astore 4
    //   313: aload_2
    //   314: astore_1
    //   315: aload_3
    //   316: astore_2
    //   317: aload 4
    //   319: astore_3
    //   320: goto -130 -> 190
    //   323: astore_1
    //   324: goto -134 -> 190
    //   327: astore 4
    //   329: aconst_null
    //   330: astore_2
    //   331: aload_1
    //   332: astore_3
    //   333: aload 4
    //   335: astore_1
    //   336: goto -197 -> 139
    //   339: astore_2
    //   340: aload_1
    //   341: astore 4
    //   343: aload_2
    //   344: astore_1
    //   345: aload_3
    //   346: astore_2
    //   347: aload 4
    //   349: astore_3
    //   350: goto -211 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	NearbyDataManager
    //   0	353	1	paramString	String
    //   0	353	2	paramPicAndAdConf	PicAndAdConf
    //   4	191	3	localObject1	Object
    //   289	1	3	localException1	Exception
    //   302	48	3	str1	String
    //   1	187	4	localObject2	Object
    //   297	7	4	localObject3	Object
    //   311	7	4	str2	String
    //   327	7	4	localException2	Exception
    //   341	7	4	str3	String
    //   6	275	5	bool1	boolean
    //   41	238	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   75	84	136	java/lang/Exception
    //   167	171	177	java/lang/Exception
    //   75	84	184	finally
    //   113	117	273	java/lang/Exception
    //   125	129	277	java/lang/Exception
    //   159	163	285	java/lang/Exception
    //   194	198	289	java/lang/Exception
    //   202	206	293	java/lang/Exception
    //   84	93	297	finally
    //   93	109	309	finally
    //   139	155	323	finally
    //   84	93	327	java/lang/Exception
    //   93	109	339	java/lang/Exception
  }
  
  private List b(List paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localLinkedList;
    }
    int m = paramList.size();
    int k = 0;
    if (k < m)
    {
      NeighborAd localNeighborAd = (NeighborAd)paramList.get(k);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("parseServerAd");
        ((StringBuilder)localObject).append("|").append(k).append("|sourceType:").append(localNeighborAd.ad_source).append("|pos:").append(localNeighborAd.ad_postion).append("|item:").append(localNeighborAd.ad_item);
        QLog.d("NearbyNiche", 2, ((StringBuilder)localObject).toString());
      }
      if (localNeighborAd.ad_postion <= 0) {}
      for (;;)
      {
        k += 1;
        break;
        localObject = new AdData();
        ((AdData)localObject).position = localNeighborAd.ad_postion;
        ((AdData)localObject).ad_source = localNeighborAd.ad_source;
        if (((AdData)localObject).parseJson(localNeighborAd.ad_item)) {
          localLinkedList.add(localObject);
        }
      }
    }
    return localLinkedList;
  }
  
  private void b(BaseActivity paramBaseActivity)
  {
    Object localObject1;
    boolean bool2;
    int k;
    int m;
    Object localObject2;
    label346:
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyDataManager", 2, "doParseBannerListToShow,use nearby pushbanner");
      }
      if ((this.jdField_b_of_type_JavaUtilList.size() == 1) && (((NearbyPushBanner)this.jdField_b_of_type_JavaUtilList.get(0)).m.equals(this.f))) {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyDataManager", 2, "doParseBannerListToShow,find schoolmate pushbanner is showing");
        }
      }
      do
      {
        do
        {
          return;
          localObject1 = new NearbyPushBanner(999888L, "1|999999999", (short)15);
          bool2 = ((NearbyPushBanner)localObject1).a("RESPCONDITION=AUTO&SUBJECT=mqq&DESC=&RESPDESC=&RESPCONTENTTYPES=PLUGIN&RESPDEST=mqqapi://nearby_entry/find_school_mate_guide?src_type%3Dinternal%26version%3D1%26from_type%3D0%26from%3D10003%26sourceid%3d2&RESPCONTENTS=");
          if (bool2) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NearbyDataManager", 2, "doParseBannerListToShow,loadParms failed");
        return;
        ((NearbyPushBanner)localObject1).m = this.f;
        ((NearbyPushBanner)localObject1).n = "找校友活动，快来寻找你的校友吧！连按两次来打开";
        if (TextUtils.isEmpty(((NearbyPushBanner)localObject1).j)) {
          break;
        }
        ((NearbyPushBanner)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsJumpAction = JumpParser.a(null, paramBaseActivity, ((NearbyPushBanner)localObject1).j);
        if (((NearbyPushBanner)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsJumpAction != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NearbyNiche", 2, "doParseBannerListToShow | jumpAction invalid, dest = " + ((NearbyPushBanner)localObject1).j);
      return;
      k = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth();
      m = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNiche", 2, "doParseBannerListToShow | width =" + k + ",height =" + m);
      }
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getOpacity() != -1) {}
      for (paramBaseActivity = Bitmap.Config.ARGB_8888;; paramBaseActivity = Bitmap.Config.RGB_565)
      {
        paramBaseActivity = Bitmap.createBitmap(k, m, paramBaseActivity);
        localObject2 = new Canvas(paramBaseActivity);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(0, 0, k, m);
        this.jdField_a_of_type_ComTencentImageURLDrawable.draw((Canvas)localObject2);
        if (paramBaseActivity != null) {
          break label346;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("NearbyNiche", 2, "doParseBannerListToShow | bitmap is null");
        return;
      }
      ((NearbyPushBanner)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = paramBaseActivity;
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.add(localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNiche", 2, "parseBannerList | orgin banner count = ");
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0)
      {
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      a(bool1, false);
      return;
      bool1 = false;
      break;
      label577:
      NearbyPushBanner localNearbyPushBanner;
      if (this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf == null)
      {
        localObject1 = new PicAndAdConf((short)21, (byte)2);
        bool2 = a(this.i + "/" + "nearby_banner", (PicAndAdConf)localObject1);
        bool1 = bool2;
        if (bool2)
        {
          this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf = ((PicAndAdConf)localObject1);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyDataManager", 2, "doParseBannerListToShow,use global pushbanner");
            bool1 = bool2;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyNiche", 2, "doParseBannerListToShow global pushbanner| parse config = " + bool1);
        }
        localObject1 = new ArrayList();
        if (!bool1) {
          break label1181;
        }
        m = this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.b();
        localObject2 = a();
        k = 0;
        if (k >= m) {
          break label1083;
        }
        localNearbyPushBanner = new NearbyPushBanner(this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k), this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.b(k), this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k));
        bool1 = localNearbyPushBanner.a(this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.d(k));
        localNearbyPushBanner.m = this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.c(k);
        if ((localNearbyPushBanner.c == null) || (!localNearbyPushBanner.c.contains("|"))) {
          break label828;
        }
        long l1 = Long.parseLong(localNearbyPushBanner.c.substring(0, localNearbyPushBanner.c.indexOf("|")));
        long l2 = Long.parseLong(localNearbyPushBanner.c.substring(localNearbyPushBanner.c.indexOf("|") + 1));
        if (a(l1, l2)) {
          break label828;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyNiche", 2, "doParseBannerListToShow | banner is outdate, cid = " + this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k) + ", endTime = " + TimeFormatterUtils.c(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), l2) + ", startTime = " + TimeFormatterUtils.c(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), l1));
        }
      }
      for (;;)
      {
        k += 1;
        break label577;
        bool1 = true;
        break;
        label828:
        if (((Set)localObject2).contains(this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k) + this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.c(k)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyNiche", 2, "doParseBannerListToShow | banner has deleted, cid = " + this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k));
          }
        }
        else
        {
          if (!TextUtils.isEmpty(localNearbyPushBanner.j))
          {
            localNearbyPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction = JumpParser.a(null, paramBaseActivity, localNearbyPushBanner.j);
            if (localNearbyPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("NearbyNiche", 2, "doParseBannerListToShow | jumpAction invalid, cid = " + this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k) + " dest = " + localNearbyPushBanner.j);
              continue;
            }
          }
          Bitmap localBitmap = this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k);
          if (localBitmap == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("NearbyNiche", 2, "doParseBannerListToShow | bitmap is null, cid = " + this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k));
            }
          }
          else
          {
            localNearbyPushBanner.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
            ((List)localObject1).add(localNearbyPushBanner);
          }
        }
      }
      label1083:
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNiche", 2, "parseBannerList | orgin banner count = " + m + " | fit count = " + ((List)localObject1).size());
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0) {}
      for (bool2 = true;; bool2 = false)
      {
        this.jdField_b_of_type_Boolean = bool2;
        break;
      }
      label1181:
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void e()
  {
    int k = this.jdField_b_of_type_JavaUtilLinkedList.size();
    if (k == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Nearby", 2, "addImageAdAgain()");
    }
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_JavaUtilList);
    k -= 1;
    if (k >= 0)
    {
      ??? = (AdData)this.jdField_b_of_type_JavaUtilLinkedList.get(k);
      if (((AdData)???).position > localLinkedList.size()) {}
      for (;;)
      {
        k -= 1;
        break;
        if (((AdData)???).typeUI == 2)
        {
          localObject3 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(((AdData)???).position);
          if (localObject3 != null)
          {
            if (((URLDrawable)localObject3).getStatus() == 1) {
              break label136;
            }
            ((URLDrawable)localObject3).setURLDrawableListener(this);
            ((URLDrawable)localObject3).restartDownload();
          }
        }
      }
      label136:
      Object localObject3 = localLinkedList.get(((AdData)???).position);
      if ((localObject3 instanceof AdGroup)) {
        ((AdGroup)localObject3).add((AdData)???);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(k);
        break;
        localObject3 = new AdGroup();
        ((AdGroup)localObject3).listAD.add(???);
        localLinkedList.add(((AdData)???).position, localObject3);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localLinkedList);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.runOnUiThread(new ral(this, localLinkedList));
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public View a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramView);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298830).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298832).setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List a(List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      return paramList;
    }
  }
  
  public List a(boolean paramBoolean, List arg2, List paramList2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("integrateNearbyList() isFirst=").append(paramBoolean).append(" people=");
      if (??? == null) {
        break label146;
      }
      k = ???.size();
      localObject = ((StringBuilder)localObject).append(k).append(" ad=");
      if (paramList2 == null) {
        break label152;
      }
    }
    label146:
    label152:
    for (int k = paramList2.size();; k = 0)
    {
      QLog.d("Nearby", 2, k);
      localObject = new ArrayList(10);
      if (??? == null) {
        break label158;
      }
      k = 0;
      while ((k < 10) && (k < ???.size()))
      {
        ((ArrayList)localObject).add(???.get(k));
        k += 1;
      }
      k = 0;
      break;
    }
    label158:
    Object localObject = b(paramList2);
    Collections.sort((List)localObject, new ran(this));
    k = 0;
    int i2 = -1;
    int i1 = 0;
    int n;
    int m;
    if (k < ((List)localObject).size())
    {
      int i3 = ((AdData)((List)localObject).get(k)).position;
      n = i2;
      m = i1;
      if (i2 != i3)
      {
        m = i1 + 1;
        n = i3;
      }
      i1 = i3 + m - 1;
      if (i1 >= 0) {
        break label600;
      }
      i1 = 0;
    }
    label564:
    label600:
    for (;;)
    {
      ((AdData)((List)localObject).get(k)).position = i1;
      k += 1;
      i2 = n;
      i1 = m;
      break;
      Iterator localIterator;
      if (paramBoolean)
      {
        this.jdField_b_of_type_JavaUtilLinkedList.clear();
        paramList2 = new LinkedList();
        paramList2.addAll(???);
        ((List)localObject).addAll(this.jdField_b_of_type_JavaUtilLinkedList);
        this.jdField_b_of_type_JavaUtilLinkedList.clear();
        localIterator = ((List)localObject).iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label564;
        }
        AdData localAdData = (AdData)localIterator.next();
        k = localAdData.position;
        if (k > paramList2.size())
        {
          this.jdField_b_of_type_JavaUtilLinkedList.add(localAdData);
          continue;
          paramList2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
          break;
        }
        if (localAdData.typeUI == 2)
        {
          localObject = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
          ??? = (List)localObject;
          if (localObject == null)
          {
            ??? = URLDrawable.getDrawable(localAdData.img_url);
            ???.setURLDrawableListener(this);
            ???.startDownload();
            this.jdField_a_of_type_AndroidUtilSparseArray.put(k, ???);
          }
          if (???.getStatus() != 1)
          {
            ???.restartDownload();
            this.jdField_b_of_type_JavaUtilLinkedList.add(localAdData);
            continue;
          }
        }
        ??? = paramList2.get(k - 1);
        if ((??? instanceof AdGroup))
        {
          ((AdGroup)???).add(localAdData);
        }
        else
        {
          ??? = new AdGroup();
          ???.listAD.add(localAdData);
          paramList2.add(k - 1, ???);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList2);
        return paramList2;
      }
    }
  }
  
  public Set a()
  {
    return new HashSet(Arrays.asList(((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "key_expired_banner", "")).split("\\|")));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ADView localADView = (ADView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298831);
      if (localADView != null) {
        localADView.g();
      }
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(AlumnusConfigInfo paramAlumnusConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner");
    }
    if (paramAlumnusConfigInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner,config is null");
      }
    }
    do
    {
      return;
      if (paramAlumnusConfigInfo.alumnus_entrance_open != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner,config is close");
    return;
    for (;;)
    {
      try
      {
        Object localObject1 = new String(paramAlumnusConfigInfo.alumnus_pic_url, "UTF-8");
        paramAlumnusConfigInfo = new String(paramAlumnusConfigInfo.alumnus_pic_md5, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner, newPicUrl = " + (String)localObject1 + ",newPicMd5 = " + paramAlumnusConfigInfo);
        }
        if ((localObject1 == null) || (paramAlumnusConfigInfo == null)) {
          break;
        }
        localObject1 = NearbyImgDownloader.a((String)localObject1);
        Object localObject2 = ((URL)localObject1).toString();
        if (AbsDownloader.a((String)localObject2))
        {
          localObject2 = AbsDownloader.a((String)localObject2);
          String str = MD5.getFileMD5((File)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner has cache, cache md5 = " + str + ",newPicMd5 = " + paramAlumnusConfigInfo);
          }
          if ((!str.equalsIgnoreCase(paramAlumnusConfigInfo)) && (localObject2 != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner has cache, md5 not match");
            }
            FileUtils.d(((File)localObject2).getAbsolutePath());
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.a();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth * 2 / 15);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner,options.mRequestWidth = " + ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth + ",options.mRequestHeight = " + ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight);
          }
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          this.jdField_a_of_type_ComTencentImageURLDrawable.setTargetDensity(160);
          if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
            break label437;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner drawable already successed");
          }
          this.jdField_a_of_type_Boolean = true;
          this.f = paramAlumnusConfigInfo;
          NearbyRNAppManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 24, 1);
          return;
        }
      }
      catch (UnsupportedEncodingException paramAlumnusConfigInfo)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner UnsupportedEncodingException", paramAlumnusConfigInfo);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner new pic");
        continue;
      }
      catch (MalformedURLException paramAlumnusConfigInfo) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner MalformedURLException", paramAlumnusConfigInfo);
      return;
      label437:
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new rai(this, paramAlumnusConfigInfo));
    }
  }
  
  public void a(NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = paramNearPeopleFilters;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    b(paramBaseActivity);
  }
  
  public void a(NearbyDataManager.INearbyBannerListener paramINearbyBannerListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramINearbyBannerListener);
  }
  
  public void a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_e_of_type_Int = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception paramString)
    {
      this.jdField_e_of_type_Int = 0;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    ThreadManager.a(new rak(this, paramArrayList), null, false);
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      paramList.clear();
      paramList.addAll(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    int k = 0;
    ArrayList localArrayList;
    if (paramList == null)
    {
      localObject = "null";
      NearbyUtils.a("Q.nearby", "writeNearbyListData", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      if (paramList == null) {
        break label133;
      }
      localArrayList = new ArrayList(paramList.size());
      label54:
      localObject = localArrayList;
      if (k >= paramList.size()) {
        break label135;
      }
      localObject = paramList.get(k);
      if (!(localObject instanceof EncounterHolder.EncounterHolderOpt)) {
        break label121;
      }
      localArrayList.add(((EncounterHolder.EncounterHolderOpt)localObject).a);
    }
    for (;;)
    {
      k += 1;
      break label54;
      localObject = Integer.valueOf(paramList.size());
      break;
      label121:
      localArrayList.add(localObject);
    }
    label133:
    Object localObject = null;
    label135:
    ThreadManager.a(new raj(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() + "v5.3.nb", (List)localObject, System.currentTimeMillis(), paramBoolean), 2, null, true);
    NearPeopleFilterActivity.NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters, "nearpeople_filters_result");
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_a_of_type_Boolean)) {
      NearPeopleFilterActivity.NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
    }
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "history_valid", Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      return;
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (Math.abs(this.jdField_a_of_type_Long - NetConnInfoCenter.getServerTime()) < 60L) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_Long = 0L;
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean a(View paramView)
  {
    if ((paramView == null) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return false;
    }
    ADView localADView = (ADView)paramView.findViewById(2131298831);
    localADView.g();
    int m = this.jdField_b_of_type_JavaUtilList.size();
    int k = 0;
    while (k < m)
    {
      NearbyPushBanner localNearbyPushBanner = (NearbyPushBanner)this.jdField_b_of_type_JavaUtilList.get(k);
      FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(paramView.getContext()).inflate(2130903501, null);
      ImageView localImageView1 = (ImageView)localFrameLayout.findViewById(2131298833);
      ImageView localImageView2 = (ImageView)localFrameLayout.findViewById(2131298834);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView1.getLayoutParams();
      DisplayMetrics localDisplayMetrics = paramView.getContext().getResources().getDisplayMetrics();
      Bitmap localBitmap = localNearbyPushBanner.jdField_a_of_type_AndroidGraphicsBitmap;
      int n = localBitmap.getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / localBitmap.getWidth();
      localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, n));
      localImageView1.setLayoutParams(localLayoutParams);
      localImageView1.setImageBitmap(localBitmap);
      localImageView2.setTag(localNearbyPushBanner);
      localImageView2.setOnClickListener(this);
      localFrameLayout.setTag(localNearbyPushBanner);
      localADView.a(localFrameLayout, k);
      k += 1;
    }
    return true;
  }
  
  public int b()
  {
    return ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "key_config_ver", Integer.valueOf(0))).intValue();
  }
  
  public void b()
  {
    if (a(this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298830).setVisibility(0);
      ((ADView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298831)).h();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8004C1A", "0X8004C1A", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298830).setVisibility(8);
  }
  
  public void b(NearbyDataManager.INearbyBannerListener paramINearbyBannerListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramINearbyBannerListener);
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "key_expired_banner", paramString);
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        int k = 0;
        while (k < this.jdField_b_of_type_JavaUtilList.size())
        {
          localArrayList1.add(((NearbyPushBanner)this.jdField_b_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaLangString);
          localArrayList2.add(((NearbyPushBanner)this.jdField_b_of_type_JavaUtilList.get(k)).m);
          k += 1;
        }
      }
      Message localMessage;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNiche", 2, "removeAllBanners encounter exception", localException);
      }
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.clear();
      }
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      localMessage.obj = new Object[] { localArrayList1, localArrayList2 };
      localMessage.sendToTarget();
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    for (;;)
    {
      return false;
      if (!a())
      {
        e();
        return false;
        localObject1 = (Object[])paramMessage.obj;
        paramMessage = (ArrayList)localObject1[0];
        localObject1 = (ArrayList)localObject1[1];
        try
        {
          if (!QLog.isColorLevel()) {
            break label162;
          }
          localObject2 = new StringBuilder("removeAllBanners | ");
          localObject3 = paramMessage.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((StringBuilder)localObject2).append((String)((Iterator)localObject3).next()).append(",");
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception paramMessage) {}
      }
    }
    QLog.d("NearbyNiche", 2, "removeAllBanners' runnable", paramMessage);
    return false;
    QLog.d("NearbyNiche", 2, ((StringBuilder)localObject2).toString());
    label162:
    Object localObject2 = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "key_expired_banner", "");
    Object localObject3 = ((String)localObject2).split("\\|");
    StringBuilder localStringBuilder = new StringBuilder();
    int k;
    if (localObject3.length > 20)
    {
      k = localObject3.length - 20;
      while (k < localObject3.length)
      {
        localStringBuilder.append(localObject3[k]).append("|");
        k += 1;
      }
    }
    localStringBuilder.append((String)localObject2);
    for (;;)
    {
      if (k < paramMessage.size())
      {
        localStringBuilder.append((String)paramMessage.get(k)).append((String)((List)localObject1).get(k)).append("|");
        k += 1;
      }
      else
      {
        b(localStringBuilder.toString());
        return false;
        k = 0;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298833: 
    default: 
      return;
    case 2131298832: 
      c();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramView = (ADView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298831);
        if (paramView != null) {
          paramView.g();
        }
        this.jdField_a_of_type_AndroidViewView.findViewById(2131298830).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8004C1C", "0X8004C1C", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = false;
      a(false, true);
      return;
    }
    paramView = (NearbyPushBanner)paramView.getTag();
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.j)) && (paramView.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction != null))
    {
      Intent localIntent = new Intent(paramView.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a, JumpActivity.class);
      localIntent.setData(Uri.parse(paramView.j));
      localIntent.putExtra("from", "from_nearby_pb");
      paramView.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 4, "doClick|url:" + paramView.j);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8004C1B", "0X8004C1B", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    a();
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 3000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\NearbyDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */