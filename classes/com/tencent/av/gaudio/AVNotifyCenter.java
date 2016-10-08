package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ghr;
import ghs;
import ght;
import ghu;
import ghv;
import ghw;
import ghx;
import ghy;
import ghz;
import gia;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class AVNotifyCenter
  extends Observable
{
  protected static final String a = "AVNotifyCenter";
  static boolean jdField_d_of_type_Boolean = false;
  public static final int f = 10002;
  public static final int g = 10003;
  public static final int h = 10004;
  public static final int i = 10005;
  private static String i;
  public static final int j = 10006;
  private static String jdField_j_of_type_JavaLangString = "BeautyFeature";
  public static final int k = 10007;
  private static String k = "BeautyPopupGuide";
  public static final int l = 10008;
  private static String l = "BeautyValue";
  public static final int m = 10009;
  public static final int n = 10010;
  public static final int o = 10011;
  public static final int p = 10012;
  public static final int q = 10013;
  public static final int r = 10014;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  public Bitmap a;
  PstnSessionInfo jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
  public PhoneStatusMonitor a;
  public QQAppInterface a;
  ghu jdField_a_of_type_Ghu = new ghu(this);
  ghv jdField_a_of_type_Ghv = new ghv(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new ghs(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap a;
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  public long b;
  public ghu b;
  Runnable jdField_b_of_type_JavaLangRunnable;
  String jdField_b_of_type_JavaLangString = null;
  HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public Map c;
  public ConcurrentHashMap c;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = null;
  HashMap jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_d_of_type_JavaUtilMap = new HashMap();
  ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString = null;
  private Map jdField_e_of_type_JavaUtilMap = new HashMap();
  public boolean e;
  String jdField_f_of_type_JavaLangString = null;
  private Map jdField_f_of_type_JavaUtilMap = new HashMap();
  public boolean f;
  String g = null;
  public boolean g;
  String jdField_h_of_type_JavaLangString = null;
  boolean jdField_h_of_type_Boolean = false;
  public boolean i;
  private boolean jdField_j_of_type_Boolean;
  int s = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_i_of_type_JavaLangString = "QAVPreSetting";
  }
  
  public AVNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Ghu = this.jdField_a_of_type_Ghu;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_i_of_type_Boolean = true;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.a();
      this.jdField_a_of_type_MqqOsMqqHandler = new ghw(Looper.getMainLooper(), this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ghr(this));
      b();
    }
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences != null) {
      this.jdField_j_of_type_Boolean = localSharedPreferences.getBoolean("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ".mutex", true);
    }
  }
  
  public static void b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getApplicationContext().getSharedPreferences(jdField_i_of_type_JavaLangString, 4);
    paramString = l + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static int c(String paramString)
  {
    return BaseApplicationImpl.a().getApplicationContext().getSharedPreferences(jdField_i_of_type_JavaLangString, 4).getInt(l + paramString, -1);
  }
  
  public static boolean c()
  {
    return jdField_d_of_type_Boolean;
  }
  
  public static boolean e(String paramString)
  {
    paramString = BaseApplicationImpl.a().getSharedPreferences(jdField_i_of_type_JavaLangString, 0);
    String str = jdField_j_of_type_JavaLangString;
    int i2 = paramString.getInt(str, -1);
    int i1 = i2;
    if (i2 == -1) {
      if (!VcSystemInfo.g()) {
        break label67;
      }
    }
    label67:
    for (i1 = 1;; i1 = 0)
    {
      paramString.edit().putInt(str, i1).commit();
      return i1 >= 1;
    }
  }
  
  public static boolean f(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getApplicationContext().getSharedPreferences(jdField_i_of_type_JavaLangString, 4);
    paramString = k + paramString;
    boolean bool = localSharedPreferences.getBoolean(paramString, true);
    if (bool) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    return bool;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Ghu.jdField_c_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((ght)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int;
    }
    return 10004;
  }
  
  public int a(String paramString)
  {
    int i1 = 0;
    paramString = a(paramString, false);
    if (paramString != null) {
      i1 = paramString.jdField_a_of_type_Int;
    }
    return i1;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Ghu.jdField_a_of_type_Long;
  }
  
  public long a(int paramInt, long paramLong)
  {
    ghx localghx;
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
      {
        localghx = (ghx)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (localghx != null) {
          return localghx.jdField_a_of_type_Long;
        }
      }
    }
    else if ((paramInt == 1) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      localghx = (ghx)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localghx != null) {
        return localghx.jdField_a_of_type_Long;
      }
    }
    return 0L;
  }
  
  public long a(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        long l1 = ((ghy)this.jdField_d_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Long;
        return l1;
      }
      return 0L;
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public MeetingInfo a(int paramInt, String paramString)
  {
    if (paramInt == 2) {
      return (MeetingInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (paramInt == 1) {}
    return null;
  }
  
  public PstnSessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo;
  }
  
  public AVNotifyCenter.UserInfo a(int paramInt, long paramLong)
  {
    if ((paramInt == 2) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Vector localVector = ((ghx)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
      if ((localVector != null) && (localVector.size() > 0)) {
        return (AVNotifyCenter.UserInfo)localVector.get(0);
      }
    }
    return null;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong)
  {
    Object localObject1 = String.valueOf(paramLong) + String.valueOf(2);
    Object localObject2 = String.valueOf(paramLong) + String.valueOf(10);
    localObject1 = (AVNotifyCenter.VideoRoomInfo)this.jdField_d_of_type_JavaUtilMap.get(localObject1);
    localObject2 = (AVNotifyCenter.VideoRoomInfo)this.jdField_d_of_type_JavaUtilMap.get(localObject2);
    Object localObject3 = String.valueOf(paramLong) + String.valueOf(12);
    localObject3 = (AVNotifyCenter.VideoRoomInfo)this.jdField_d_of_type_JavaUtilMap.get(localObject3);
    int i1 = b(paramLong);
    if ((i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, paramLong))) {
      if (i1 != 12) {}
    }
    while ((localObject3 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject3).jdField_a_of_type_Int > 0))
    {
      return (AVNotifyCenter.VideoRoomInfo)localObject3;
      if (i1 == 2) {
        return (AVNotifyCenter.VideoRoomInfo)localObject1;
      }
      if (i1 != 10) {
        break;
      }
      return (AVNotifyCenter.VideoRoomInfo)localObject2;
    }
    if ((localObject1 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int > 0)) {
      return (AVNotifyCenter.VideoRoomInfo)localObject1;
    }
    if ((localObject2 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int > 0)) {
      return (AVNotifyCenter.VideoRoomInfo)localObject2;
    }
    return null;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong) + String.valueOf(paramInt);
    return (AVNotifyCenter.VideoRoomInfo)this.jdField_d_of_type_JavaUtilMap.get(str);
  }
  
  public AVNotifyCenter.VideoRoomInfo_tips a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong);
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = null;
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "getTipsRoomInfo: " + paramLong + "relationType:" + paramInt);
    }
    if (paramInt == 2) {
      localVideoRoomInfo_tips = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_e_of_type_JavaUtilMap.get(str);
    }
    for (;;)
    {
      if ((localVideoRoomInfo_tips == null) && (QLog.isColorLevel())) {
        QLog.d("AVNotifyCenter", 2, "getTipsRoomInfo: infos is null!");
      }
      return localVideoRoomInfo_tips;
      if (paramInt == 1) {
        localVideoRoomInfo_tips = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_f_of_type_JavaUtilMap.get(str);
      }
    }
  }
  
  /* Error */
  public ghu a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 152	com/tencent/av/gaudio/AVNotifyCenter:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   8: aload_1
    //   9: invokevirtual 334	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   12: ifeq +19 -> 31
    //   15: aload_0
    //   16: getfield 152	com/tencent/av/gaudio/AVNotifyCenter:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: aload_1
    //   20: invokevirtual 335	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 154	ghu
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: areturn
    //   31: iload_2
    //   32: ifeq -5 -> 27
    //   35: invokestatic 387	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +29 -> 67
    //   41: ldc 8
    //   43: iconst_2
    //   44: new 235	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 406
    //   54: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: new 154	ghu
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 157	ghu:<init>	(Lcom/tencent/av/gaudio/AVNotifyCenter;)V
    //   75: astore 4
    //   77: aload_0
    //   78: getfield 152	com/tencent/av/gaudio/AVNotifyCenter:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   81: aload_1
    //   82: aload 4
    //   84: invokevirtual 410	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload 4
    //   90: astore_3
    //   91: aload_0
    //   92: getfield 152	com/tencent/av/gaudio/AVNotifyCenter:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   95: invokevirtual 411	java/util/HashMap:size	()I
    //   98: iconst_1
    //   99: if_icmpne -72 -> 27
    //   102: aload_0
    //   103: aload 4
    //   105: putfield 161	com/tencent/av/gaudio/AVNotifyCenter:jdField_b_of_type_Ghu	Lghu;
    //   108: aload 4
    //   110: astore_3
    //   111: goto -84 -> 27
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	AVNotifyCenter
    //   0	119	1	paramString	String
    //   0	119	2	paramBoolean	boolean
    //   3	108	3	localObject	Object
    //   75	34	4	localghu	ghu
    // Exception table:
    //   from	to	target	type
    //   4	27	114	finally
    //   35	67	114	finally
    //   67	88	114	finally
    //   91	108	114	finally
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      String str1 = ((AVPhoneUserInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).telInfo.mobile;
      String str2 = c(str1);
      if (str2 != null) {
        return str2;
      }
      return PstnUtils.a(str1, 4);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ghz localghz = (ghz)localIterator.next();
        if (paramString.equals(localghz.jdField_a_of_type_JavaLangString)) {
          return localghz.jdField_b_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public HashMap a()
  {
    return this.jdField_b_of_type_JavaUtilHashMap;
  }
  
  public Vector a(long paramLong)
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Object localObject = (ghx)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((ghx)localObject).jdField_a_of_type_JavaUtilVector;
        if (localObject != null) {
          return (Vector)localObject;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "clearMultiRoomInfos");
    }
    this.jdField_b_of_type_Ghu.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Ghu.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Ghu.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->relationType==" + paramInt + " discussId" + paramLong);
    }
    Object localObject1;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramInt != 2) {
        break label185;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      if (!((ConcurrentHashMap)localObject1).containsKey(Long.valueOf(paramLong))) {
        break label285;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->containsKey");
      }
      localObject1 = (ghx)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
      localVector = ((ghx)localObject1).jdField_a_of_type_JavaUtilVector;
      if ((localVector == null) || (localVector.size() <= 0)) {
        break label206;
      }
      int i1 = localVector.size();
      paramInt = 0;
      label145:
      if (paramInt >= i1) {
        break label206;
      }
      if (l1 != ((AVNotifyCenter.UserInfo)localVector.elementAt(paramInt)).jdField_a_of_type_Long) {
        break label199;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->uin in uinlist");
      }
    }
    label185:
    label199:
    label206:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 1);
        localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        break;
        paramInt += 1;
        break label145;
      } while (localVector == null);
      localObject2 = new AVNotifyCenter.UserInfo(this);
      ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = l1;
      localVector.add(localObject2);
      ((ghx)localObject1).jdField_a_of_type_Long += 1L;
    } while (!QLog.isColorLevel());
    QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->infoRoomNum=" + ((ghx)localObject1).jdField_a_of_type_Long);
    return;
    label285:
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->insert new uinlist");
    }
    Vector localVector = new Vector();
    Object localObject2 = new AVNotifyCenter.UserInfo(this);
    ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = l1;
    localVector.add(localObject2);
    localObject2 = new ghx(this);
    ((ghx)localObject2).jdField_a_of_type_Long = 1L;
    ((ghx)localObject2).jdField_a_of_type_JavaUtilVector = localVector;
    ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject2);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "onSelfLeaveRoom() relationType==" + paramInt1 + " relationId" + paramLong + " avtype:" + paramInt2);
    }
    Object localObject;
    int i1;
    String str;
    long l1;
    Vector localVector;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramInt1 != 2) {
        break label223;
      }
      localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      i1 = 3000;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      l1 = Long.valueOf(str).longValue();
      label221:
      if (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong)))
      {
        ghx localghx = (ghx)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong));
        localVector = localghx.jdField_a_of_type_JavaUtilVector;
        localghx.jdField_a_of_type_Long -= 1L;
        if (QLog.isColorLevel()) {
          QLog.d("shanezhai", 2, "onSelfLeaveRoom");
        }
        if (localghx.jdField_a_of_type_Long != 0L) {
          break label278;
        }
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong));
        localObject = Long.toString(paramLong);
        if (paramInt1 != 2) {
          break label240;
        }
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, 14, false, (String)localObject, str, false, null, false, new Object[] { new Integer(paramInt2) });
      }
    }
    for (;;)
    {
      return;
      label223:
      if (paramInt1 == 1)
      {
        localObject = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        i1 = 1;
        break;
        label240:
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, 14, false, (String)localObject, str, false, null, false, paramInt2, new Object[] { new Integer(paramInt2) });
        return;
        label278:
        if ((localVector == null) || (localVector.size() <= 0)) {
          break label221;
        }
        paramInt2 = localVector.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (l1 == ((AVNotifyCenter.UserInfo)localVector.elementAt(paramInt1)).jdField_a_of_type_Long)
          {
            localVector.remove(paramInt1);
            return;
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    ghu localghu = a(String.valueOf(paramLong), false);
    if (localghu != null)
    {
      localghu.jdField_c_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label47;
      }
      if (!paramBoolean2) {
        break label40;
      }
      localghu.jdField_d_of_type_Boolean = false;
    }
    label40:
    label47:
    while (paramBoolean1)
    {
      return;
      localghu.jdField_d_of_type_Boolean = true;
      return;
    }
    localghu.jdField_d_of_type_Boolean = true;
  }
  
  public void a(int paramInt, long paramLong, long[] paramArrayOfLong)
  {
    int i2 = 0;
    if (paramInt == 2) {}
    Vector localVector;
    int i1;
    for (ConcurrentHashMap localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;; localConcurrentHashMap = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "setMultiRoomMember-->relationType=" + paramInt + " relationId=" + paramLong + " length=" + paramArrayOfLong.length);
      }
      if (localConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        localConcurrentHashMap.remove(Long.valueOf(paramLong));
      }
      localVector = new Vector();
      int i3 = paramArrayOfLong.length;
      i1 = 0;
      paramInt = i2;
      while (paramInt < i3)
      {
        AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
        localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
        localVector.add(localUserInfo);
        i1 += 1;
        paramInt += 1;
      }
      if (paramInt != 1) {
        return;
      }
    }
    paramArrayOfLong = new ghx(this);
    paramArrayOfLong.jdField_a_of_type_Long = i1;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
    localConcurrentHashMap.put(Long.valueOf(paramLong), paramArrayOfLong);
  }
  
  public void a(int paramInt, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    int i2 = 0;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setMultiRoomMember : relationType = " + paramInt + ", relationId " + paramLong1 + ", Num:" + paramLong2);
    }
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null)) {}
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = new Vector();
        i2 = paramArrayOfLong.length;
        paramInt = i1;
        while (paramInt < i2)
        {
          localObject2 = new AVNotifyCenter.UserInfo(this);
          ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = paramArrayOfLong[paramInt];
          ((Vector)localObject1).add(localObject2);
          paramInt += 1;
        }
        paramArrayOfLong = new ghx(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt != 1);
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    Object localObject1 = new ghx(this);
    ((ghx)localObject1).jdField_a_of_type_Long = paramLong2;
    ((ghx)localObject1).jdField_a_of_type_JavaUtilVector = null;
    if (paramArrayOfLong != null)
    {
      localObject2 = new Vector();
      paramInt = i2;
      while (paramInt < paramArrayOfLong.length)
      {
        AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
        localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
        ((Vector)localObject2).add(localUserInfo);
        paramInt += 1;
      }
      ((ghx)localObject1).jdField_a_of_type_JavaUtilVector = ((Vector)localObject2);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject1);
  }
  
  public void a(int paramInt, long paramLong1, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setMultiRoomMember : relationType = " + paramInt + ", relationId " + paramLong1 + ", Num:" + paramLong2);
    }
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null) && (paramArrayOfInt != null) && (paramArrayOfLong.length == paramArrayOfInt.length)) {}
    }
    do
    {
      do
      {
        return;
        Vector localVector = new Vector();
        int i1 = paramArrayOfLong.length;
        ArrayList localArrayList = new ArrayList();
        paramInt = 0;
        if (paramInt < i1)
        {
          AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
          localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localUserInfo.jdField_a_of_type_Boolean = bool;
            if ((localUserInfo.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localUserInfo.jdField_a_of_type_Long)))) {
              localArrayList.add(Long.valueOf(localUserInfo.jdField_a_of_type_Long));
            }
            localVector.add(localUserInfo);
            paramInt += 1;
            break;
          }
        }
        a(localArrayList);
        paramArrayOfLong = new ghx(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt != 1);
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    paramArrayOfLong = new ghx(this);
    paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = null;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
  }
  
  public void a(int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setChating discussId is:relationType = " + paramInt + ", relationId = " + paramLong + ", isChatting = " + paramBoolean);
    }
    Object localObject = String.valueOf(paramLong);
    if (!paramBoolean) {
      return;
    }
    localObject = a((String)localObject, true);
    ((ghu)localObject).jdField_a_of_type_Boolean = false;
    ((ghu)localObject).jdField_a_of_type_Long = paramLong.longValue();
    ((ghu)localObject).jdField_c_of_type_Int = paramInt;
    if (((ghu)localObject).jdField_c_of_type_Int == 1) {
      ((ghu)localObject).jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      ((ghu)localObject).jdField_d_of_type_Boolean = paramBoolean;
      return;
      if (((ghu)localObject).jdField_c_of_type_Int == 2) {
        ((ghu)localObject).jdField_b_of_type_Int = 3000;
      } else if (((ghu)localObject).jdField_c_of_type_Int == 3) {
        ((ghu)localObject).jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public void a(int paramInt1, Long paramLong, boolean paramBoolean, int paramInt2)
  {
    a(paramInt1, paramLong, paramBoolean);
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      setChanged();
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramString);
        l1 = l2;
      }
      catch (NumberFormatException paramString)
      {
        for (;;) {}
      }
      notifyObservers(new Object[] { Integer.valueOf(36), Integer.valueOf(2), Long.valueOf(l1), Integer.valueOf(0) });
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setChating uinType:" + paramInt + ", peerUin" + paramString1);
    }
    ghu localghu = a(paramString1, true);
    localghu.jdField_a_of_type_Boolean = true;
    localghu.jdField_b_of_type_Int = paramInt;
    localghu.jdField_a_of_type_JavaLangString = paramString1;
    localghu.jdField_b_of_type_JavaLangString = paramString2;
    localghu.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    Object localObject2 = (String)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "0;0";
    }
    if (paramInt2 > 0) {
      if (paramInt1 == 2)
      {
        localObject2 = a(paramLong, 10);
        paramInt1 = i1;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        if (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int > 0) {
          localObject1 = "1;" + (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int + paramInt2);
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_JavaUtilMap.put(String.valueOf(paramLong), localObject1);
        return;
        if (paramInt1 != 10) {
          break label164;
        }
        localObject2 = a(paramLong, 2);
        paramInt1 = i1;
        break;
        localObject1 = "0;0";
        continue;
        if (paramInt1 != 0)
        {
          localObject1 = "0;0";
          continue;
          localObject1 = "0;0";
        }
      }
      label164:
      paramInt1 = 0;
      localObject2 = null;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("setVideoRoomInfo", 2, "groupid:" + paramLong + " avtype : " + paramInt1 + "event:" + paramInt2 + "memberNum:" + paramInt3);
    }
    AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = new AVNotifyCenter.VideoRoomInfo(this);
    localVideoRoomInfo.jdField_a_of_type_Long = paramLong;
    localVideoRoomInfo.jdField_b_of_type_Int = paramInt1;
    localVideoRoomInfo.jdField_c_of_type_Int = paramInt2;
    localVideoRoomInfo.jdField_a_of_type_Int = paramInt3;
    String str = String.valueOf(paramLong) + String.valueOf(paramInt1);
    this.jdField_d_of_type_JavaUtilMap.put(str, localVideoRoomInfo);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setTipsRoomInfo relationId:" + paramLong + "relationType:" + paramInt1);
    }
    if (paramInt1 == 2)
    {
      if (this.jdField_e_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        this.jdField_e_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
      localVideoRoomInfo_tips.jdField_a_of_type_Long = paramLong;
      localVideoRoomInfo_tips.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_e_of_type_JavaUtilMap.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
    }
    while (paramInt1 != 1) {
      return;
    }
    if (this.jdField_f_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_f_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
    localVideoRoomInfo_tips.jdField_a_of_type_Long = paramLong;
    localVideoRoomInfo_tips.jdField_a_of_type_Boolean = paramBoolean;
    localVideoRoomInfo_tips.jdField_a_of_type_Int = paramInt2;
    this.jdField_f_of_type_JavaUtilMap.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box");
      localIntent.putExtra("groupId", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    String str1;
    SharedPreferences localSharedPreferences;
    String str2;
    do
    {
      return;
      str1 = String.valueOf(paramLong);
      HashSet localHashSet = new HashSet();
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      str2 = "ADD_FRIEND_DIALOG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject = localHashSet;
      if (localSharedPreferences.contains(str2)) {
        localObject = localSharedPreferences.getStringSet(str2, localHashSet);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "setAddFriendNotifyMaps-->uin=" + paramLong + " bNotify=" + paramBoolean + " srcId=" + paramInt + " size=" + ((Set)localObject).size() + " info=" + localObject.toString());
      }
    } while ((((Set)localObject).size() >= 3) || (((Set)localObject).contains(str1)));
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
    if (!paramBoolean)
    {
      ((Set)localObject).add(str1);
      localSharedPreferences.edit().putStringSet(str2, (Set)localObject).commit();
      return;
    }
    Object localObject = new ght();
    ((ght)localObject).jdField_a_of_type_Int = paramInt;
    ((ght)localObject).jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
  }
  
  public void a(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt);
      this.jdField_e_of_type_Int = paramResources.getHeight();
      this.jdField_d_of_type_Int = paramResources.getWidth();
      return;
    }
    catch (OutOfMemoryError paramResources)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AVNotifyCenter", 2, "adaptFamousChattingHeadSize --> OOM Exception");
      return;
    }
    catch (Exception paramResources)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AVNotifyCenter", 2, "Can not Get Bitmap From Resid");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "saveFamousPersonChattingConfigContent --> strContent is null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        paramQQAppInterface = new JSONObject(paramString);
        paramString = paramQQAppInterface.keys();
        if (paramString.hasNext())
        {
          String str = (String)paramString.next();
          if (str.equals("open_flag")) {
            if (paramQQAppInterface.getInt(str) != 1) {
              break label174;
            }
          }
          label174:
          for (boolean bool = true;; bool = false)
          {
            this.jdField_b_of_type_Boolean = bool;
            if (str.equals("title")) {
              this.jdField_e_of_type_JavaLangString = paramQQAppInterface.getString(str);
            }
            if (str.equals("url")) {
              this.jdField_f_of_type_JavaLangString = paramQQAppInterface.getString(str);
            }
            if (str.equals("desc_text")) {
              this.g = paramQQAppInterface.getString(str);
            }
            bool = str.equals("web_url");
            if (!bool) {
              break;
            }
            try
            {
              this.jdField_h_of_type_JavaLangString = URLDecoder.decode(paramQQAppInterface.getString(str), "UTF-8");
            }
            catch (Exception localException) {}
            break;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("AVNotifyCenter", 2, "Flag = " + this.jdField_b_of_type_Boolean + " , Title = " + this.jdField_e_of_type_JavaLangString + " , Url = " + this.jdField_f_of_type_JavaLangString);
          QLog.d("AVNotifyCenter", 2, "saveFamousPersonChattingConfigContent mFamousPersonChattingSecondLineText = " + this.g);
          QLog.d("AVNotifyCenter", 2, "saveFamousPersonChattingConfigContent mFamousPersonChattingWebUrl = " + this.jdField_h_of_type_JavaLangString);
        }
        if (this.jdField_f_of_type_JavaLangString != null)
        {
          this.jdField_a_of_type_Ghv.execute(new String[] { this.jdField_f_of_type_JavaLangString });
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_e_of_type_JavaLangString = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    SharedPreUtils.b(paramQQAppInterface.getApplication(), paramInt, paramQQAppInterface.getAccount());
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putString("group_video_push_cfg_txt." + paramQQAppInterface.getAccount(), paramString).commit();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("mav");
      if (paramString != null)
      {
        JSONObject localJSONObject = paramString.getJSONObject("relationType1");
        if (localJSONObject != null) {
          if (localJSONObject.getInt("mutex") != 0) {
            break label316;
          }
        }
      }
      for (;;)
      {
        this.jdField_j_of_type_Boolean = bool;
        localEditor.putBoolean("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".mutex", this.jdField_j_of_type_Boolean);
        paramString = paramString.getJSONObject("noiseCtrl");
        if (paramString != null)
        {
          paramInt = paramString.getInt("level");
          int i1 = paramString.getInt("sendDura");
          int i2 = paramString.getInt("validDura");
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".level", paramInt);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".sendDura", i1);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".validDura", i2);
        }
        localEditor.commit();
        return;
        label316:
        bool = true;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setSessionType peerUin:" + paramString + ", sessionType" + paramInt);
    }
    if (paramInt == 0) {
      c(paramString);
    }
    do
    {
      return;
      paramString = a(paramString, true);
    } while (paramString == null);
    paramString.jdField_a_of_type_Boolean = true;
    paramString.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      this.jdField_d_of_type_JavaUtilHashMap.put(paramString, new ghy(this, paramLong, paramInt));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ghz(this, paramString1, paramString2, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setDoubleVideoMeetingFlag-->isDoubleVideoMeeting = " + paramBoolean);
    }
    paramString = a(paramString, false);
    if (paramString != null) {
      paramString.e = paramBoolean;
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = a(String.valueOf(paramString), false);
    if (paramString != null)
    {
      paramString.jdField_c_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label39;
      }
      if (!paramBoolean2) {
        break label33;
      }
      paramString.jdField_d_of_type_Boolean = false;
    }
    label33:
    label39:
    while (paramBoolean1)
    {
      return;
      paramString.jdField_d_of_type_Boolean = true;
      return;
    }
    paramString.jdField_d_of_type_Boolean = true;
  }
  
  void a(ArrayList paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AVNotifyCenter", 2, "getOpenIdFromTinyId --> StartServlet Error");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(408), Boolean.valueOf(paramBoolean), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor != null) {
      return this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a();
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    boolean bool = false;
    ghu localghu = a(String.valueOf(paramLong), false);
    if (localghu != null) {
      bool = localghu.jdField_d_of_type_Boolean;
    }
    return bool;
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 2) {
      bool1 = a(paramInt1, paramLong);
    }
    ghu localghu;
    do
    {
      do
      {
        do
        {
          return bool1;
          paramInt1 = b(paramLong);
          bool1 = bool2;
        } while (paramInt1 < 0);
        localghu = a(String.valueOf(paramLong), false);
        bool1 = bool2;
      } while (localghu == null);
      bool1 = bool2;
    } while (paramInt2 != paramInt1);
    return localghu.jdField_d_of_type_Boolean;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (paramInt == 2) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    if (paramInt == 1) {}
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    String str = "ADD_FRIEND_DIALOG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject = localHashSet;
    if (localSharedPreferences.contains(str)) {
      localObject = localSharedPreferences.getStringSet(str, localHashSet);
    }
    if (((Set)localObject).size() >= 3) {
      return false;
    }
    if (((Set)localObject).contains(String.valueOf(paramLong))) {
      return false;
    }
    return this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong));
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_c_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.split(";")[0].equals("1")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b(long paramLong)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        int i1 = ((ghy)this.jdField_d_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Int;
        return i1;
      }
      return 0;
    }
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String b(long paramLong)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((ghy)this.jdField_d_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_Long == paramLong) {
          return str;
        }
      }
      return "";
    }
  }
  
  public String b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ghz localghz = (ghz)localIterator.next();
        if (paramString.equals(localghz.jdField_a_of_type_JavaLangString)) {
          return localghz.jdField_c_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setSessionType relaitonType:" + paramInt1 + ", relationId" + paramLong + ", sessionType" + paramInt2);
    }
    Object localObject = String.valueOf(paramLong);
    if (paramInt2 == 0) {
      c((String)localObject);
    }
    do
    {
      return;
      localObject = a((String)localObject, true);
    } while (localObject == null);
    ((ghu)localObject).jdField_a_of_type_Boolean = false;
    ((ghu)localObject).jdField_a_of_type_Int = paramInt2;
  }
  
  public void b(int paramInt, String paramString)
  {
    try
    {
      setChanged();
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramString);
        l1 = l2;
      }
      catch (NumberFormatException paramString)
      {
        for (;;) {}
      }
      notifyObservers(new Object[] { Integer.valueOf(37), Integer.valueOf(2), Long.valueOf(l1), Integer.valueOf(0) });
      return;
    }
    finally {}
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "removeTipsInfo: " + paramLong + "relationType:" + paramInt);
    }
    String str = String.valueOf(paramLong);
    if (paramInt == 2) {
      this.jdField_e_of_type_JavaUtilMap.remove(str);
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_f_of_type_JavaUtilMap.remove(str);
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
        long l1 = localAVPhoneUserInfo.account;
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l1))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localAVPhoneUserInfo);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "hasMultiVideo --> RelationType = " + paramInt + " ,RelationId = " + paramLong);
    }
    if (paramInt == 2) {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() != 0) {}
    }
    do
    {
      do
      {
        do
        {
          return false;
        } while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
        return true;
        if (paramInt != 1) {
          break;
        }
      } while ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) || (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))));
      return true;
    } while (!QLog.isColorLevel());
    QLog.e("AVNotifyCenter", 2, "hasMultiVideo --> RelationType is Wrong");
    return false;
  }
  
  public boolean b(long paramLong)
  {
    Boolean localBoolean = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    ghu localghu = a(paramString, false);
    boolean bool1;
    if (localghu != null) {
      bool1 = localghu.e;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> isDoubleVideoMeeting = " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> can not get data from uin --> peerUin = " + paramString);
        bool1 = bool2;
      }
    }
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  String c(String paramString)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localPhoneContactManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localPhoneContactManager.b(paramString);
    if ((paramString == null) || (paramString.name == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
      }
      return null;
    }
    return paramString.name;
  }
  
  public void c(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString)) {
        this.jdField_d_of_type_JavaUtilHashMap.remove(paramString);
      }
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "startOrStopGAudioTimer start: " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_Ghu.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_Long = 0L;
      }
      if (this.jdField_b_of_type_JavaLangRunnable == null) {
        this.jdField_b_of_type_JavaLangRunnable = new gia(this);
      }
    }
    while ((d()) || (this.jdField_b_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
      for (;;)
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
        }
        return;
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public boolean c(long paramLong)
  {
    boolean bool = true;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (i1 == 2) {}
    while (bool)
    {
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, 10);
      if ((localVideoRoomInfo == null) || (localVideoRoomInfo.jdField_a_of_type_Int <= 0)) {
        break;
      }
      return false;
      if (i1 == 0)
      {
        localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, 2);
        if ((localVideoRoomInfo != null) && (localVideoRoomInfo.jdField_a_of_type_Int > 0)) {}
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVNotifyCenter", 2, "removeChatSession sessionId : " + paramString);
        }
        if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "removeChatSession not exist sessionId : " + paramString);
          }
          bool = false;
          return bool;
        }
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
        if (this.jdField_c_of_type_JavaUtilHashMap.size() == 1)
        {
          Object localObject = this.jdField_c_of_type_JavaUtilHashMap.keySet();
          paramString = null;
          localObject = ((Set)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramString = (String)((Iterator)localObject).next();
            paramString = (ghu)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
            continue;
          }
          this.jdField_b_of_type_Ghu = paramString;
        }
        else if (this.jdField_c_of_type_JavaUtilHashMap.isEmpty())
        {
          this.jdField_b_of_type_Ghu = this.jdField_a_of_type_Ghu;
          this.jdField_b_of_type_Long = 0L;
          if ((this.jdField_b_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_MqqOsMqqHandler != null)) {
            this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          }
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String d()
  {
    return this.g;
  }
  
  public void d(String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(800), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setNetworkState: Begin");
    }
    if ((this.jdField_a_of_type_Boolean != paramBoolean) && (!paramBoolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setNetworkState: End=" + (SystemClock.elapsedRealtime() - l1));
    }
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Ghu.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Ghu.jdField_d_of_type_Boolean);
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      return this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString);
    }
  }
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String e()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setNotifyUpdateTime-->bNotify" + paramBoolean);
    }
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Ghu.jdField_c_of_type_Boolean;
  }
  
  public int f()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String f()
  {
    return this.jdField_b_of_type_Ghu.jdField_a_of_type_JavaLangString;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Ghu.jdField_b_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_b_of_type_Ghu.jdField_a_of_type_Int;
  }
  
  public String g()
  {
    return this.jdField_b_of_type_Ghu.jdField_b_of_type_JavaLangString;
  }
  
  public boolean g()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public int h()
  {
    int i2 = this.jdField_b_of_type_Ghu.jdField_b_of_type_Int;
    int i1 = i2;
    if (i2 == 21) {
      i1 = 1011;
    }
    return i1;
  }
  
  public String h()
  {
    return UITools.a(this.jdField_b_of_type_Long);
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int i()
  {
    return this.s;
  }
  
  public boolean i()
  {
    if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  public boolean j()
  {
    return this.jdField_h_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\av\gaudio\AVNotifyCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */