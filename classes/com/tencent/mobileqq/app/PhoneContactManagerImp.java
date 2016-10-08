package com.tencent.mobileqq.app;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qbu;
import qbv;
import qbw;
import qbx;
import qby;
import qbz;
import qca;
import qcb;
import qcc;
import qcd;
import qce;
import qcf;
import qci;
import qcj;
import qck;
import qcl;
import qcm;
import qcn;
import qco;
import qcp;
import qcq;
import qcr;
import qcu;

public class PhoneContactManagerImp
  implements PhoneContactManager
{
  private static final char jdField_a_of_type_Char = '|';
  public static volatile long a = 0L;
  public static final String a = "key_contacts_switches";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b = 0;
  public static int d = 0;
  private static final String jdField_d_of_type_JavaLangString = "all_entrance_num";
  public static int e = 0;
  private static final String jdField_e_of_type_JavaLangString = "key_config_version";
  public static final int f = 0;
  private static final long jdField_f_of_type_Long = 120000L;
  private static final String jdField_f_of_type_JavaLangString = "sp_new_friend";
  public static boolean f = false;
  public static final int g = 1;
  private static final long jdField_g_of_type_Long = 180000L;
  private static final String jdField_g_of_type_JavaLangString = "key_bind_style";
  public static final int h = 2;
  private static final long jdField_h_of_type_Long = 86400000L;
  private static final String jdField_h_of_type_JavaLangString = "key_bind_wording";
  private static final String jdField_i_of_type_JavaLangString = "key_block_msg";
  private static final boolean jdField_i_of_type_Boolean = true;
  private static final String jdField_j_of_type_JavaLangString = "key_contact_last_login";
  private static final String jdField_k_of_type_JavaLangString = "key_req_last_login_time";
  private static final String jdField_l_of_type_JavaLangString = "key_login_info_timestamp";
  private static final boolean jdField_l_of_type_Boolean = false;
  private static final String m = "key_req_login_interval";
  private static final int y = 20;
  public volatile int a;
  public SharedPreferences a;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ContactBinded jdField_a_of_type_ComTencentMobileqqDataContactBinded;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new qcf(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new qcm(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qcr jdField_a_of_type_Qcr;
  private qcu jdField_a_of_type_Qcu;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public volatile long b;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private Runnable jdField_b_of_type_JavaLangRunnable = new qcq(this);
  private List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean b;
  public volatile int c;
  public volatile long c;
  private SharedPreferences jdField_c_of_type_AndroidContentSharedPreferences;
  private Runnable jdField_c_of_type_JavaLangRunnable = new qbv(this);
  private String jdField_c_of_type_JavaLangString;
  private List jdField_c_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean c;
  public volatile long d;
  private List jdField_d_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_d_of_type_Boolean;
  public long e;
  private List jdField_e_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean e;
  private volatile List jdField_f_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private List jdField_g_of_type_JavaUtilList;
  public boolean g;
  private List jdField_h_of_type_JavaUtilList;
  private boolean jdField_h_of_type_Boolean;
  private List jdField_i_of_type_JavaUtilList;
  private boolean jdField_j_of_type_Boolean;
  private volatile boolean jdField_k_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 120000L;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1", "display_name", "contact_id", "data2", "data3" };
    jdField_b_of_type_Int = 20;
    jdField_e_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("sp_new_friend", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    jdField_a_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval", jdField_a_of_type_Long);
    this.jdField_a_of_type_Int = a(a());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    ThreadManager.a(new qbu(this), 2, null, false);
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "getSelfBindState : " + a() + " " + paramRespondQueryQQBindingStat.mobileNo + " " + paramRespondQueryQQBindingStat.originBinder + " " + paramRespondQueryQQBindingStat.MobileUniqueNo + " " + paramRespondQueryQQBindingStat.lastUsedFlag + " " + paramRespondQueryQQBindingStat.isRecommend + " " + paramRespondQueryQQBindingStat.bindingTime + " " + this.jdField_h_of_type_Boolean);
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo)) {
        return 1;
      }
      if ((paramRespondQueryQQBindingStat.originBinder == 2L) || (paramRespondQueryQQBindingStat.originBinder == 3L)) {
        return 2;
      }
    } while (paramRespondQueryQQBindingStat.originBinder != 1L);
    if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
      paramRespondQueryQQBindingStat.MobileUniqueNo = null;
    }
    if ((TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) || (paramRespondQueryQQBindingStat.isStopFindMatch)) {
      return 4;
    }
    if (a().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 6;
    }
    return 3;
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    paramString = paramString.getBytes();
    int i1 = paramString.length;
    paramArrayOfByte = a(paramArrayOfByte);
    paramString = a(paramString);
    int n = 0;
    while (n < i1)
    {
      paramArrayOfByte[n] = ((byte)(paramString[n] ^ paramArrayOfByte[n]));
      n += 1;
    }
    i1 = paramArrayOfByte.length;
    n = i1 - 1;
    if (n >= 0) {
      if (paramArrayOfByte[n] == 0) {}
    }
    for (;;)
    {
      if (n != i1 - 1)
      {
        paramString = new byte[n + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, n + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(a(paramArrayOfByte));
        n -= 1;
        break;
      }
      n = 0;
    }
  }
  
  /* Error */
  private ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    // Byte code:
    //   0: new 363	java/util/HashMap
    //   3: dup
    //   4: invokespecial 364	java/util/HashMap:<init>	()V
    //   7: astore 8
    //   9: new 176	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 177	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   21: lstore 13
    //   23: aload_0
    //   24: getfield 181	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 372	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore_3
    //   34: aload_3
    //   35: getstatic 378	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   38: getstatic 100	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 384	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +244 -> 295
    //   54: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +36 -> 93
    //   60: ldc_w 386
    //   63: iconst_2
    //   64: new 196	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 388
    //   74: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokeinterface 394 1 0
    //   84: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_0
    //   96: getfield 255	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   99: invokevirtual 402	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   102: astore 5
    //   104: aload 5
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 406	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   111: aload 4
    //   113: invokeinterface 409 1 0
    //   118: pop
    //   119: aload 4
    //   121: invokeinterface 412 1 0
    //   126: ifne +669 -> 795
    //   129: aload 4
    //   131: aload 4
    //   133: ldc 90
    //   135: invokeinterface 416 2 0
    //   140: invokeinterface 419 2 0
    //   145: invokestatic 424	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 6
    //   150: aload 4
    //   152: aload 4
    //   154: ldc 92
    //   156: invokeinterface 416 2 0
    //   161: invokeinterface 419 2 0
    //   166: astore 5
    //   168: aload 5
    //   170: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +1001 -> 1174
    //   176: aload 6
    //   178: astore 5
    //   180: aload 4
    //   182: aload 4
    //   184: ldc 94
    //   186: invokeinterface 416 2 0
    //   191: invokeinterface 428 2 0
    //   196: istore 11
    //   198: aload 4
    //   200: aload 4
    //   202: ldc 96
    //   204: invokeinterface 416 2 0
    //   209: invokeinterface 428 2 0
    //   214: istore 12
    //   216: aload 4
    //   218: aload 4
    //   220: ldc 98
    //   222: invokeinterface 416 2 0
    //   227: invokeinterface 419 2 0
    //   232: astore 9
    //   234: aload 6
    //   236: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne +11 -> 250
    //   242: aload 5
    //   244: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +173 -> 420
    //   250: aload 4
    //   252: invokeinterface 431 1 0
    //   257: pop
    //   258: goto -139 -> 119
    //   261: astore 5
    //   263: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +14 -> 280
    //   269: ldc_w 386
    //   272: iconst_2
    //   273: ldc -36
    //   275: aload 5
    //   277: invokestatic 434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   288: aload 4
    //   290: invokeinterface 439 1 0
    //   295: aload_0
    //   296: iconst_0
    //   297: putfield 146	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_g_of_type_Boolean	Z
    //   300: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +35 -> 338
    //   306: ldc_w 386
    //   309: iconst_2
    //   310: new 196	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 441
    //   320: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   326: lload 13
    //   328: lsub
    //   329: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +33 -> 374
    //   344: ldc_w 386
    //   347: iconst_2
    //   348: new 196	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 443
    //   358: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_1
    //   362: invokevirtual 446	java/util/ArrayList:size	()I
    //   365: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +33 -> 410
    //   380: ldc_w 386
    //   383: iconst_2
    //   384: new 196	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 448
    //   394: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_2
    //   398: invokevirtual 446	java/util/ArrayList:size	()I
    //   401: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload 7
    //   412: areturn
    //   413: astore_3
    //   414: aconst_null
    //   415: astore 4
    //   417: goto -368 -> 49
    //   420: aload_0
    //   421: getfield 148	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   424: aload 6
    //   426: invokevirtual 452	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   429: checkcast 454	com/tencent/mobileqq/data/PhoneContact
    //   432: astore 10
    //   434: aload 10
    //   436: ifnonnull +173 -> 609
    //   439: new 454	com/tencent/mobileqq/data/PhoneContact
    //   442: dup
    //   443: invokespecial 455	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   446: astore 10
    //   448: aload 10
    //   450: aload 6
    //   452: putfield 456	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   455: aload 10
    //   457: aload 5
    //   459: putfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   462: aload 10
    //   464: iload 11
    //   466: putfield 462	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   469: aload 10
    //   471: iload 12
    //   473: putfield 465	com/tencent/mobileqq/data/PhoneContact:type	I
    //   476: aload 10
    //   478: aload 9
    //   480: putfield 468	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   483: aload 10
    //   485: lload 13
    //   487: putfield 471	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   490: aload 10
    //   492: aload 5
    //   494: iconst_1
    //   495: invokestatic 476	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   498: putfield 479	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   501: aload 10
    //   503: aload 5
    //   505: iconst_2
    //   506: invokestatic 476	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   509: putfield 482	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   512: aload 10
    //   514: aload 10
    //   516: getfield 482	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   519: invokestatic 484	com/tencent/mobileqq/app/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   522: putfield 487	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   525: aload_0
    //   526: getfield 148	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   529: aload 6
    //   531: aload 10
    //   533: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: aload 10
    //   539: aload 5
    //   541: aload 6
    //   543: invokestatic 493	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   546: putfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   549: aload_0
    //   550: getfield 154	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   553: aload 10
    //   555: getfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   558: aload 10
    //   560: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: aload 7
    //   566: aload 10
    //   568: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   571: pop
    //   572: aload_1
    //   573: new 501	SecurityAccountServer/AddressBookItem
    //   576: dup
    //   577: aload 6
    //   579: aload 5
    //   581: invokespecial 504	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   587: pop
    //   588: goto -338 -> 250
    //   591: astore_1
    //   592: aload_3
    //   593: ifnull +7 -> 600
    //   596: aload_3
    //   597: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   600: aload 4
    //   602: invokeinterface 439 1 0
    //   607: aload_1
    //   608: athrow
    //   609: aload 10
    //   611: iload 11
    //   613: putfield 462	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   616: aload 10
    //   618: lload 13
    //   620: putfield 471	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   623: aload 10
    //   625: getfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   628: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifeq +33 -> 664
    //   634: aload 10
    //   636: aload 10
    //   638: getfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   641: aload 6
    //   643: invokestatic 493	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   646: putfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   649: aload_0
    //   650: getfield 154	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   653: aload 10
    //   655: getfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   658: aload 10
    //   660: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   663: pop
    //   664: aload 10
    //   666: getfield 507	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   669: ifeq +99 -> 768
    //   672: aload 5
    //   674: aload 10
    //   676: getfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   679: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   682: ifne +75 -> 757
    //   685: aload 8
    //   687: aload 6
    //   689: aload 5
    //   691: invokevirtual 508	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   694: pop
    //   695: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   698: ifeq -448 -> 250
    //   701: ldc_w 386
    //   704: iconst_2
    //   705: new 196	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   712: ldc_w 510
    //   715: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload 10
    //   720: getfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   723: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc_w 512
    //   729: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload 5
    //   734: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: ldc_w 514
    //   740: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 6
    //   745: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: goto -504 -> 250
    //   757: aload 8
    //   759: aload 6
    //   761: invokevirtual 517	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   764: pop
    //   765: goto -515 -> 250
    //   768: aload_1
    //   769: new 501	SecurityAccountServer/AddressBookItem
    //   772: dup
    //   773: aload 6
    //   775: aload 5
    //   777: invokespecial 504	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   780: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   783: pop
    //   784: aload 7
    //   786: aload 10
    //   788: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   791: pop
    //   792: goto -542 -> 250
    //   795: aload 8
    //   797: invokevirtual 521	java/util/HashMap:keySet	()Ljava/util/Set;
    //   800: invokeinterface 527 1 0
    //   805: astore 5
    //   807: aload 5
    //   809: invokeinterface 532 1 0
    //   814: ifeq +176 -> 990
    //   817: aload 5
    //   819: invokeinterface 536 1 0
    //   824: checkcast 88	java/lang/String
    //   827: astore 6
    //   829: aload_0
    //   830: getfield 148	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   833: aload 6
    //   835: invokevirtual 452	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   838: checkcast 454	com/tencent/mobileqq/data/PhoneContact
    //   841: astore 9
    //   843: aload 9
    //   845: ifnull -38 -> 807
    //   848: aload 8
    //   850: aload 6
    //   852: invokevirtual 537	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   855: checkcast 88	java/lang/String
    //   858: astore 10
    //   860: aload_2
    //   861: new 501	SecurityAccountServer/AddressBookItem
    //   864: dup
    //   865: aload 6
    //   867: aload 9
    //   869: getfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   872: invokespecial 504	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   878: pop
    //   879: aload_1
    //   880: new 501	SecurityAccountServer/AddressBookItem
    //   883: dup
    //   884: aload 6
    //   886: aload 10
    //   888: invokespecial 504	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   891: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   894: pop
    //   895: aload 9
    //   897: aload 10
    //   899: putfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   902: aload 9
    //   904: aload 10
    //   906: iconst_1
    //   907: invokestatic 476	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   910: putfield 479	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   913: aload 9
    //   915: aload 10
    //   917: iconst_2
    //   918: invokestatic 476	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   921: putfield 482	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   924: aload 9
    //   926: aload 9
    //   928: getfield 482	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   931: invokestatic 484	com/tencent/mobileqq/app/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   934: putfield 487	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   937: aload_0
    //   938: getfield 154	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   941: aload 9
    //   943: getfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   946: aload 9
    //   948: invokevirtual 540	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   951: pop
    //   952: aload 9
    //   954: aload 10
    //   956: aload 6
    //   958: invokestatic 493	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   961: putfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   964: aload_0
    //   965: getfield 154	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   968: aload 9
    //   970: getfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   973: aload 9
    //   975: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   978: pop
    //   979: aload 7
    //   981: aload 9
    //   983: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   986: pop
    //   987: goto -180 -> 807
    //   990: new 176	java/util/ArrayList
    //   993: dup
    //   994: invokespecial 177	java/util/ArrayList:<init>	()V
    //   997: astore 5
    //   999: aload_0
    //   1000: getfield 148	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1003: invokevirtual 543	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   1006: invokeinterface 527 1 0
    //   1011: astore 6
    //   1013: aload 6
    //   1015: invokeinterface 532 1 0
    //   1020: ifeq +105 -> 1125
    //   1023: aload 6
    //   1025: invokeinterface 536 1 0
    //   1030: checkcast 545	java/util/Map$Entry
    //   1033: invokeinterface 548 1 0
    //   1038: checkcast 454	com/tencent/mobileqq/data/PhoneContact
    //   1041: astore 8
    //   1043: aload 8
    //   1045: getfield 471	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1048: lload 13
    //   1050: lcmp
    //   1051: ifeq -38 -> 1013
    //   1054: aload 8
    //   1056: getfield 551	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1059: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1062: ifne +16 -> 1078
    //   1065: aload_0
    //   1066: getfield 150	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1069: aload 8
    //   1071: getfield 551	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1074: invokevirtual 552	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1077: pop
    //   1078: aload 6
    //   1080: invokeinterface 554 1 0
    //   1085: aload_0
    //   1086: getfield 255	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1089: aload 8
    //   1091: invokevirtual 557	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1094: pop
    //   1095: aload_2
    //   1096: new 501	SecurityAccountServer/AddressBookItem
    //   1099: dup
    //   1100: aload 8
    //   1102: getfield 456	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1105: aload 8
    //   1107: getfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1110: invokespecial 504	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1116: pop
    //   1117: aload 5
    //   1119: invokevirtual 560	java/util/ArrayList:clear	()V
    //   1122: goto -109 -> 1013
    //   1125: aload_3
    //   1126: invokevirtual 562	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1129: aload_3
    //   1130: ifnull +7 -> 1137
    //   1133: aload_3
    //   1134: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1137: aload 4
    //   1139: invokeinterface 439 1 0
    //   1144: goto -849 -> 295
    //   1147: astore_3
    //   1148: goto -853 -> 295
    //   1151: astore_3
    //   1152: goto -857 -> 295
    //   1155: astore_2
    //   1156: goto -549 -> 607
    //   1159: astore_1
    //   1160: aconst_null
    //   1161: astore_3
    //   1162: goto -570 -> 592
    //   1165: astore_1
    //   1166: goto -574 -> 592
    //   1169: astore 5
    //   1171: goto -908 -> 263
    //   1174: goto -994 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1177	0	this	PhoneContactManagerImp
    //   0	1177	1	paramArrayList1	ArrayList
    //   0	1177	2	paramArrayList2	ArrayList
    //   33	252	3	localObject1	Object
    //   413	721	3	localThrowable	Throwable
    //   1147	1	3	localException1	Exception
    //   1151	1	3	localException2	Exception
    //   1161	1	3	localObject2	Object
    //   47	1091	4	localCursor	android.database.Cursor
    //   102	141	5	localObject3	Object
    //   261	515	5	localStaleDataException1	android.database.StaleDataException
    //   805	313	5	localObject4	Object
    //   1169	1	5	localStaleDataException2	android.database.StaleDataException
    //   148	931	6	localObject5	Object
    //   16	964	7	localArrayList	ArrayList
    //   7	1099	8	localObject6	Object
    //   232	750	9	localObject7	Object
    //   432	523	10	localObject8	Object
    //   196	416	11	n	int
    //   214	258	12	i1	int
    //   21	1028	13	l1	long
    // Exception table:
    //   from	to	target	type
    //   107	119	261	android/database/StaleDataException
    //   119	176	261	android/database/StaleDataException
    //   180	250	261	android/database/StaleDataException
    //   250	258	261	android/database/StaleDataException
    //   420	434	261	android/database/StaleDataException
    //   439	588	261	android/database/StaleDataException
    //   609	664	261	android/database/StaleDataException
    //   664	754	261	android/database/StaleDataException
    //   757	765	261	android/database/StaleDataException
    //   768	792	261	android/database/StaleDataException
    //   795	807	261	android/database/StaleDataException
    //   807	843	261	android/database/StaleDataException
    //   848	987	261	android/database/StaleDataException
    //   990	1013	261	android/database/StaleDataException
    //   1013	1078	261	android/database/StaleDataException
    //   1078	1122	261	android/database/StaleDataException
    //   1125	1129	261	android/database/StaleDataException
    //   34	49	413	java/lang/Throwable
    //   107	119	591	finally
    //   119	176	591	finally
    //   180	250	591	finally
    //   250	258	591	finally
    //   420	434	591	finally
    //   439	588	591	finally
    //   609	664	591	finally
    //   664	754	591	finally
    //   757	765	591	finally
    //   768	792	591	finally
    //   795	807	591	finally
    //   807	843	591	finally
    //   848	987	591	finally
    //   990	1013	591	finally
    //   1013	1078	591	finally
    //   1078	1122	591	finally
    //   1125	1129	591	finally
    //   1137	1144	1147	java/lang/Exception
    //   288	295	1151	java/lang/Exception
    //   600	607	1155	java/lang/Exception
    //   95	104	1159	finally
    //   263	280	1165	finally
    //   95	104	1169	android/database/StaleDataException
  }
  
  private void a(int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      this.jdField_e_of_type_JavaUtilList = null;
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_g_of_type_JavaUtilList = null;
      this.i = null;
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(1);
        localMqqHandler.sendEmptyMessageDelayed(1, 100L);
      }
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactsInnerFrame.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(3);
        localMqqHandler.sendEmptyMessageDelayed(3, 100L);
      }
    }
    this.jdField_f_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qcn(this, paramInt));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveContactListTimeStamp" + paramLong1 + ", " + paramLong2);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong1).putLong("queryRichInfoTimeStamp", paramLong2).commit();
  }
  
  private void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = a(paramRespondQueryQQBindingStat);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = i1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "syncBindState newState = " + i1 + " lastState=" + n + " curState=" + this.jdField_a_of_type_Int);
      }
      if (n != this.jdField_a_of_type_Int) {
        n();
      }
      return;
      if (this.jdField_a_of_type_Int != i1)
      {
        r();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_show_contact_banner", true).commit();
      }
      this.jdField_a_of_type_Int = i1;
      continue;
      if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L) {
        r();
      }
      this.jdField_a_of_type_Int = i1;
      continue;
      if (this.jdField_a_of_type_Int != 5)
      {
        if (this.jdField_a_of_type_Int != i1) {
          r();
        }
        this.jdField_a_of_type_Int = i1;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact", 2, "cur state is uploading");
      }
    }
  }
  
  private void a(ConcurrentHashMap paramConcurrentHashMap)
  {
    Object localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      PhoneContact localPhoneContact = (PhoneContact)((Map.Entry)localObject2).getValue();
      localObject2 = (PhoneContact)paramConcurrentHashMap.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (localPhoneContact != null))
      {
        ((PhoneContact)localObject2).uin = localPhoneContact.uin;
        ((PhoneContact)localObject2).nationCode = localPhoneContact.nationCode;
        ((PhoneContact)localObject2).mobileCode = localPhoneContact.mobileCode;
        ((PhoneContact)localObject2).bindingDate = localPhoneContact.bindingDate;
        ((PhoneContact)localObject2).nickName = localPhoneContact.nickName;
        ((PhoneContact)localObject2).isUploaded = localPhoneContact.isUploaded;
        ((PhoneContact)localObject2).originBinder = localPhoneContact.originBinder;
        ((PhoneContact)localObject2).ability = localPhoneContact.ability;
      }
    }
    localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    ((ConcurrentHashMap)localObject1).clear();
  }
  
  private void a(boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "notifyRecommendCountChanged|beAdded = " + paramBoolean + "|list.size = " + paramList.size());
    }
    int n = paramList.size();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qby(this, paramBoolean, n));
  }
  
  private boolean a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if ((paramString == null) || ((paramArrayList1 == null) && (paramArrayList2 == null)))
    {
      this.jdField_c_of_type_Boolean = false;
      return false;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 15);
    localNewIntent.putExtra("unique_phone_no", paramString);
    localNewIntent.putExtra("add_contact_list", paramArrayList1);
    localNewIntent.putExtra("del_contact_list", paramArrayList2);
    localNewIntent.putExtra("rename_contact_list", paramArrayList3);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("upload_package_no", 0);
    localNewIntent.putExtra("session_id", new byte[0]);
    localNewIntent.putExtra("is_resend", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    return true;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    int i2 = paramArrayOfByte.length - 1;
    while (i2 > i1 * 2)
    {
      int n = paramArrayOfByte[i1];
      paramArrayOfByte[i1] = paramArrayOfByte[(i2 - i1)];
      paramArrayOfByte[(i2 - i1)] = n;
      i1 += 1;
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  private ArrayList b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: invokespecial 760	com/tencent/mobileqq/app/PhoneContactManagerImp:m	()V
    //   10: aload_0
    //   11: getfield 181	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokevirtual 372	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   20: getstatic 378	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   23: getstatic 100	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 384	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_3
    //   33: new 176	java/util/ArrayList
    //   36: dup
    //   37: invokespecial 177	java/util/ArrayList:<init>	()V
    //   40: astore 8
    //   42: aload_3
    //   43: ifnull +692 -> 735
    //   46: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   49: lstore 13
    //   51: aload_3
    //   52: invokeinterface 394 1 0
    //   57: istore 11
    //   59: aload 8
    //   61: iload 11
    //   63: invokevirtual 763	java/util/ArrayList:ensureCapacity	(I)V
    //   66: new 125	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: iload 11
    //   72: invokespecial 765	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   75: astore 9
    //   77: aload 4
    //   79: astore_2
    //   80: aload 5
    //   82: astore_1
    //   83: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +37 -> 123
    //   89: aload 4
    //   91: astore_2
    //   92: aload 5
    //   94: astore_1
    //   95: ldc_w 386
    //   98: iconst_2
    //   99: new 196	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 767
    //   109: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 11
    //   114: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 4
    //   125: astore_2
    //   126: aload 5
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 255	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   133: invokevirtual 402	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   136: astore 4
    //   138: aload 4
    //   140: astore_2
    //   141: aload 4
    //   143: astore_1
    //   144: aload 4
    //   146: invokevirtual 406	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   149: aload 4
    //   151: astore_2
    //   152: aload 4
    //   154: astore_1
    //   155: aload_3
    //   156: invokeinterface 409 1 0
    //   161: pop
    //   162: aload 4
    //   164: astore_2
    //   165: aload 4
    //   167: astore_1
    //   168: aload_3
    //   169: invokeinterface 412 1 0
    //   174: ifne +527 -> 701
    //   177: aload 4
    //   179: astore_2
    //   180: aload 4
    //   182: astore_1
    //   183: aload_3
    //   184: aload_3
    //   185: ldc 90
    //   187: invokeinterface 416 2 0
    //   192: invokeinterface 419 2 0
    //   197: invokestatic 424	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 6
    //   202: aload 4
    //   204: astore_2
    //   205: aload 4
    //   207: astore_1
    //   208: aload_3
    //   209: aload_3
    //   210: ldc 92
    //   212: invokeinterface 416 2 0
    //   217: invokeinterface 419 2 0
    //   222: astore 7
    //   224: aload 7
    //   226: astore 5
    //   228: aload 4
    //   230: astore_2
    //   231: aload 4
    //   233: astore_1
    //   234: aload 7
    //   236: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifeq +7 -> 246
    //   242: aload 6
    //   244: astore 5
    //   246: aload 4
    //   248: astore_2
    //   249: aload 4
    //   251: astore_1
    //   252: aload_3
    //   253: aload_3
    //   254: ldc 94
    //   256: invokeinterface 416 2 0
    //   261: invokeinterface 428 2 0
    //   266: istore 11
    //   268: aload 4
    //   270: astore_2
    //   271: aload 4
    //   273: astore_1
    //   274: aload_3
    //   275: aload_3
    //   276: ldc 96
    //   278: invokeinterface 416 2 0
    //   283: invokeinterface 428 2 0
    //   288: istore 12
    //   290: aload 4
    //   292: astore_2
    //   293: aload 4
    //   295: astore_1
    //   296: aload_3
    //   297: aload_3
    //   298: ldc 98
    //   300: invokeinterface 416 2 0
    //   305: invokeinterface 419 2 0
    //   310: astore 7
    //   312: aload 4
    //   314: astore_2
    //   315: aload 4
    //   317: astore_1
    //   318: aload 6
    //   320: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifne +17 -> 340
    //   326: aload 4
    //   328: astore_2
    //   329: aload 4
    //   331: astore_1
    //   332: aload 5
    //   334: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifeq +128 -> 465
    //   340: aload 4
    //   342: astore_2
    //   343: aload 4
    //   345: astore_1
    //   346: aload_3
    //   347: invokeinterface 431 1 0
    //   352: pop
    //   353: goto -191 -> 162
    //   356: astore 4
    //   358: aload_2
    //   359: astore_1
    //   360: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +16 -> 379
    //   366: aload_2
    //   367: astore_1
    //   368: ldc_w 386
    //   371: iconst_2
    //   372: ldc -36
    //   374: aload 4
    //   376: invokestatic 434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: aload_2
    //   380: ifnull +7 -> 387
    //   383: aload_2
    //   384: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   387: aload_3
    //   388: invokeinterface 439 1 0
    //   393: aload_0
    //   394: aload 9
    //   396: invokespecial 769	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   399: aload_0
    //   400: getfield 148	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   403: invokevirtual 773	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   406: invokeinterface 776 1 0
    //   411: astore_1
    //   412: aload_1
    //   413: invokeinterface 532 1 0
    //   418: ifeq +317 -> 735
    //   421: aload_1
    //   422: invokeinterface 536 1 0
    //   427: checkcast 454	com/tencent/mobileqq/data/PhoneContact
    //   430: astore_2
    //   431: aload 8
    //   433: new 501	SecurityAccountServer/AddressBookItem
    //   436: dup
    //   437: aload_2
    //   438: getfield 456	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   441: aload_2
    //   442: getfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   445: invokespecial 504	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: invokevirtual 499	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   451: pop
    //   452: goto -40 -> 412
    //   455: astore_1
    //   456: aload_1
    //   457: invokevirtual 779	java/lang/Exception:printStackTrace	()V
    //   460: aconst_null
    //   461: astore_3
    //   462: goto -429 -> 33
    //   465: aload 4
    //   467: astore_2
    //   468: aload 4
    //   470: astore_1
    //   471: new 454	com/tencent/mobileqq/data/PhoneContact
    //   474: dup
    //   475: invokespecial 455	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   478: astore 10
    //   480: aload 4
    //   482: astore_2
    //   483: aload 4
    //   485: astore_1
    //   486: aload 10
    //   488: aload 6
    //   490: putfield 456	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   493: aload 4
    //   495: astore_2
    //   496: aload 4
    //   498: astore_1
    //   499: aload 10
    //   501: aload 5
    //   503: putfield 459	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   506: aload 4
    //   508: astore_2
    //   509: aload 4
    //   511: astore_1
    //   512: aload 10
    //   514: iload 11
    //   516: putfield 462	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   519: aload 4
    //   521: astore_2
    //   522: aload 4
    //   524: astore_1
    //   525: aload 10
    //   527: iload 12
    //   529: putfield 465	com/tencent/mobileqq/data/PhoneContact:type	I
    //   532: aload 4
    //   534: astore_2
    //   535: aload 4
    //   537: astore_1
    //   538: aload 10
    //   540: aload 7
    //   542: putfield 468	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   545: aload 4
    //   547: astore_2
    //   548: aload 4
    //   550: astore_1
    //   551: aload 10
    //   553: lload 13
    //   555: putfield 471	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   558: aload 4
    //   560: astore_2
    //   561: aload 4
    //   563: astore_1
    //   564: aload 10
    //   566: aload 5
    //   568: iconst_1
    //   569: invokestatic 476	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   572: putfield 479	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   575: aload 4
    //   577: astore_2
    //   578: aload 4
    //   580: astore_1
    //   581: aload 10
    //   583: aload 5
    //   585: iconst_2
    //   586: invokestatic 476	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   589: putfield 482	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   592: aload 4
    //   594: astore_2
    //   595: aload 4
    //   597: astore_1
    //   598: aload 10
    //   600: aload 10
    //   602: getfield 482	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   605: invokestatic 484	com/tencent/mobileqq/app/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   608: putfield 487	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   611: aload 4
    //   613: astore_2
    //   614: aload 4
    //   616: astore_1
    //   617: aload 10
    //   619: aload 5
    //   621: aload 6
    //   623: invokestatic 493	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   626: putfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   629: aload 4
    //   631: astore_2
    //   632: aload 4
    //   634: astore_1
    //   635: aload 9
    //   637: aload 6
    //   639: aload 10
    //   641: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: pop
    //   645: aload 4
    //   647: astore_2
    //   648: aload 4
    //   650: astore_1
    //   651: aload_0
    //   652: getfield 154	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   655: aload 10
    //   657: getfield 496	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   660: aload 10
    //   662: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   665: pop
    //   666: aload 4
    //   668: astore_2
    //   669: aload 4
    //   671: astore_1
    //   672: aload_0
    //   673: getfield 255	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   676: aload 10
    //   678: invokevirtual 782	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   681: goto -341 -> 340
    //   684: astore_2
    //   685: aload_1
    //   686: ifnull +7 -> 693
    //   689: aload_1
    //   690: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   693: aload_3
    //   694: invokeinterface 439 1 0
    //   699: aload_2
    //   700: athrow
    //   701: aload 4
    //   703: astore_2
    //   704: aload 4
    //   706: astore_1
    //   707: aload 4
    //   709: invokevirtual 562	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   712: aload 4
    //   714: ifnull +8 -> 722
    //   717: aload 4
    //   719: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   722: aload_3
    //   723: invokeinterface 439 1 0
    //   728: goto -335 -> 393
    //   731: astore_1
    //   732: goto -339 -> 393
    //   735: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +34 -> 772
    //   741: ldc_w 386
    //   744: iconst_2
    //   745: new 196	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 784
    //   755: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 8
    //   760: invokevirtual 446	java/util/ArrayList:size	()I
    //   763: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   766: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: aload_0
    //   773: iconst_1
    //   774: putfield 786	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   777: aload 8
    //   779: areturn
    //   780: astore_1
    //   781: goto -388 -> 393
    //   784: astore_1
    //   785: goto -86 -> 699
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	PhoneContactManagerImp
    //   82	340	1	localObject1	Object
    //   455	2	1	localException1	Exception
    //   470	237	1	localStaleDataException1	android.database.StaleDataException
    //   731	1	1	localException2	Exception
    //   780	1	1	localException3	Exception
    //   784	1	1	localException4	Exception
    //   79	590	2	localObject2	Object
    //   684	16	2	localObject3	Object
    //   703	1	2	localStaleDataException2	android.database.StaleDataException
    //   32	691	3	localCursor	android.database.Cursor
    //   4	340	4	localEntityTransaction	EntityTransaction
    //   356	362	4	localStaleDataException3	android.database.StaleDataException
    //   1	619	5	localObject4	Object
    //   200	438	6	str1	String
    //   222	319	7	str2	String
    //   40	738	8	localArrayList	ArrayList
    //   75	561	9	localConcurrentHashMap	ConcurrentHashMap
    //   478	199	10	localPhoneContact	PhoneContact
    //   57	458	11	n	int
    //   288	240	12	i1	int
    //   49	505	13	l1	long
    // Exception table:
    //   from	to	target	type
    //   83	89	356	android/database/StaleDataException
    //   95	123	356	android/database/StaleDataException
    //   129	138	356	android/database/StaleDataException
    //   144	149	356	android/database/StaleDataException
    //   155	162	356	android/database/StaleDataException
    //   168	177	356	android/database/StaleDataException
    //   183	202	356	android/database/StaleDataException
    //   208	224	356	android/database/StaleDataException
    //   234	242	356	android/database/StaleDataException
    //   252	268	356	android/database/StaleDataException
    //   274	290	356	android/database/StaleDataException
    //   296	312	356	android/database/StaleDataException
    //   318	326	356	android/database/StaleDataException
    //   332	340	356	android/database/StaleDataException
    //   346	353	356	android/database/StaleDataException
    //   471	480	356	android/database/StaleDataException
    //   486	493	356	android/database/StaleDataException
    //   499	506	356	android/database/StaleDataException
    //   512	519	356	android/database/StaleDataException
    //   525	532	356	android/database/StaleDataException
    //   538	545	356	android/database/StaleDataException
    //   551	558	356	android/database/StaleDataException
    //   564	575	356	android/database/StaleDataException
    //   581	592	356	android/database/StaleDataException
    //   598	611	356	android/database/StaleDataException
    //   617	629	356	android/database/StaleDataException
    //   635	645	356	android/database/StaleDataException
    //   651	666	356	android/database/StaleDataException
    //   672	681	356	android/database/StaleDataException
    //   707	712	356	android/database/StaleDataException
    //   10	33	455	java/lang/Exception
    //   83	89	684	finally
    //   95	123	684	finally
    //   129	138	684	finally
    //   144	149	684	finally
    //   155	162	684	finally
    //   168	177	684	finally
    //   183	202	684	finally
    //   208	224	684	finally
    //   234	242	684	finally
    //   252	268	684	finally
    //   274	290	684	finally
    //   296	312	684	finally
    //   318	326	684	finally
    //   332	340	684	finally
    //   346	353	684	finally
    //   360	366	684	finally
    //   368	379	684	finally
    //   471	480	684	finally
    //   486	493	684	finally
    //   499	506	684	finally
    //   512	519	684	finally
    //   525	532	684	finally
    //   538	545	684	finally
    //   551	558	684	finally
    //   564	575	684	finally
    //   581	592	684	finally
    //   598	611	684	finally
    //   617	629	684	finally
    //   635	645	684	finally
    //   651	666	684	finally
    //   672	681	684	finally
    //   707	712	684	finally
    //   722	728	731	java/lang/Exception
    //   387	393	780	java/lang/Exception
    //   693	699	784	java/lang/Exception
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qbx(this, paramInt));
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qbz(this, paramLong));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_contact_last_login", paramString).commit();
  }
  
  private void b(boolean paramBoolean)
  {
    List localList = b();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "pushRecommendUnreadCount: beAdded = " + paramBoolean + ", unreadCount = " + localList.size());
    }
    a(paramBoolean, localList);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
  }
  
  private void c(List paramList)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_contact_last_login", "");
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + paramList.size() * 13);
    localStringBuilder.append((String)localObject);
    localObject = new HashSet(this.jdField_a_of_type_JavaUtilSet.size() + paramList.size());
    ((Set)localObject).addAll(this.jdField_a_of_type_JavaUtilSet);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (((Set)localObject).add(str)) {
        localStringBuilder.append('|').append(str);
      }
    }
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "addContactsToLastLogin, " + localStringBuilder.toString());
    }
    b(localStringBuilder.toString());
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qcc(this, paramBoolean));
  }
  
  private String d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contact_bind_info_unique", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("null|null"))) {
      return (String)localObject1;
    }
    Object localObject2 = e();
    localObject1 = localObject2;
    if (((String)localObject2).equals("|")) {
      localObject1 = e();
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("|"))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "|" + ((Random)localObject1).nextLong();
    }
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putString("contact_bind_info_unique", (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    return (String)localObject2;
  }
  
  private void d(List arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact|listSize = ", Integer.valueOf(???.size()) });
    }
    if (???.size() >= jdField_b_of_type_Int) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = new ContactBinded();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.timestamp = MessageCache.a();
        this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.isReaded = false;
        a(this.jdField_a_of_type_ComTencentMobileqqDataContactBinded);
        return;
      }
    }
    EntityTransaction localEntityTransaction;
    for (;;)
    {
      PhoneContact localPhoneContact;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        localEntityTransaction.a();
        try
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(???.size());
          }
          ??? = ???.iterator();
          if (!???.hasNext()) {
            break;
          }
          localPhoneContact = (PhoneContact)???.next();
          localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)((Iterator)localObject3).next();
            if (!localContactMatch.mobileNo.equals(localPhoneContact.mobileNo)) {
              continue;
            }
            ((Iterator)localObject3).remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localContactMatch);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact remove uin=", localContactMatch.mobileNo });
            continue;
            ??? = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
      }
      Object localObject3 = new ContactMatch();
      ((ContactMatch)localObject3).mobileNo = localPhoneContact.mobileNo;
      ((ContactMatch)localObject3).unifiedCode = localPhoneContact.unifiedCode;
      ((ContactMatch)localObject3).name = localPhoneContact.name;
      ((ContactMatch)localObject3).timestamp = MessageCache.a();
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact new uin=", ((ContactMatch)localObject3).mobileNo });
      }
      a((Entity)localObject3);
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    localEntityTransaction.a();
    for (;;)
    {
      PhoneContact localPhoneContact;
      try
      {
        Enumeration localEnumeration = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.elements();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        localPhoneContact = (PhoneContact)localEnumeration.nextElement();
        if ((localPhoneContact.uin == null) || (localPhoneContact.uin.length() <= 0)) {
          continue;
        }
        if (paramBoolean)
        {
          localPhoneContact.bindingDate = 0L;
          localPhoneContact.isRecommend = 0;
          localPhoneContact.uin = "";
          localPhoneContact.originBinder = 0L;
          localPhoneContact.ability = 0;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          continue;
        }
        if (!localPhoneContact.uin.equals("0")) {
          continue;
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      localPhoneContact.netTypeIconId = 0;
      localPhoneContact.detalStatusFlag = 20;
      localPhoneContact.iTermType = 0;
      localPhoneContact.strTermDesc = "";
      localPhoneContact.eNetworkType = 0;
      localPhoneContact.abilityBits = 0L;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
  }
  
  private String e()
  {
    Object localObject = "";
    for (;;)
    {
      try
      {
        str1 = ((TelephonyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("phone")).getDeviceId();
        localObject = str1;
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        continue;
      }
      try
      {
        str1 = ((WifiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        return (String)localObject + "|" + str1;
      }
      catch (Exception localException1)
      {
        str2 = "";
      }
    }
  }
  
  private boolean f()
  {
    if (!"6.5.5".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  private List h()
  {
    ArrayList localArrayList = new ArrayList(8);
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if ("0".equals(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    return localArrayList;
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qck(this));
  }
  
  private void k()
  {
    String[] arrayOfString = StringUtil.a(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("key_contact_last_login", ""), '|');
    HashSet localHashSet = new HashSet(arrayOfString.length);
    int i1 = arrayOfString.length;
    int n = 0;
    while (n < i1)
    {
      String str = arrayOfString[n];
      if (!TextUtils.isEmpty(str)) {
        localHashSet.add(str);
      }
      n += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = localHashSet;
  }
  
  private void l()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new qcl(this, new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper()));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    a(0L, 0L);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qbw(this));
  }
  
  private void o()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Int >= 6) && (c() == 1))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = null;
          }
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          EntityTransaction localEntityTransaction1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          try
          {
            localEntityTransaction1.a();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ContactMatch().getTableName(), null, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ContactBinded().getTableName(), null, null);
            localEntityTransaction1.c();
            localEntityTransaction1.b();
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend with BannerShow");
            }
            return;
          }
          finally
          {
            localObject3 = finally;
            localEntityTransaction1.b();
            throw ((Throwable)localObject3);
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        EntityTransaction localEntityTransaction2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        ContactMatch localContactMatch;
        try
        {
          localEntityTransaction2.a();
          Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator1.hasNext())
          {
            localContactMatch = (ContactMatch)localIterator1.next();
            PhoneContact localPhoneContact = b(localContactMatch.mobileNo);
            if ((localPhoneContact == null) || ((localPhoneContact.uin != null) && (!localPhoneContact.uin.equals("0"))) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= jdField_b_of_type_Int))
            {
              localIterator1.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localContactMatch);
              if (QLog.isColorLevel()) {
                QLog.d("PhoneContact.Manager", 2, new Object[] { "removeIllegalRecommend remove = ", localContactMatch.mobileNo });
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label396;
          }
        }
        finally
        {
          localEntityTransaction2.b();
        }
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator2.hasNext())
        {
          localContactMatch = (ContactMatch)localIterator2.next();
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        label396:
        localEntityTransaction2.c();
        localEntityTransaction2.b();
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
  }
  
  /* Error */
  private void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 196	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 824	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc_w 1043
    //   22: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 119	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   29: invokevirtual 309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: ldc_w 1045
    //   37: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 113	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   44: invokevirtual 309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: ldc_w 1047
    //   52: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 121	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 1048
    //   66: ldiv
    //   67: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 386
    //   74: iconst_2
    //   75: aload_1
    //   76: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 119	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   86: ifne +14 -> 100
    //   89: aload_0
    //   90: getfield 113	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   93: istore 4
    //   95: iload 4
    //   97: ifeq +6 -> 103
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   106: aload_0
    //   107: getfield 121	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   110: lsub
    //   111: ldc2_w 27
    //   114: lcmp
    //   115: iflt -15 -> 100
    //   118: new 176	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 177	java/util/ArrayList:<init>	()V
    //   125: astore_1
    //   126: new 176	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 177	java/util/ArrayList:<init>	()V
    //   133: astore_2
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial 1051	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   140: astore_3
    //   141: aload_1
    //   142: invokevirtual 1053	java/util/ArrayList:isEmpty	()Z
    //   145: ifeq +10 -> 155
    //   148: aload_2
    //   149: invokevirtual 1053	java/util/ArrayList:isEmpty	()Z
    //   152: ifne -52 -> 100
    //   155: aload_0
    //   156: aload_0
    //   157: aload_0
    //   158: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   161: aload_1
    //   162: aload_2
    //   163: aload_3
    //   164: invokespecial 1055	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   167: putfield 119	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   170: aload_0
    //   171: iconst_1
    //   172: invokespecial 656	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(I)V
    //   175: goto -75 -> 100
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	PhoneContactManagerImp
    //   17	145	1	localObject1	Object
    //   178	4	1	localObject2	Object
    //   133	30	2	localArrayList1	ArrayList
    //   140	24	3	localArrayList2	ArrayList
    //   93	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	82	178	finally
    //   82	95	178	finally
    //   103	155	178	finally
    //   155	175	178	finally
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped", "6.5.5").commit();
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.jdField_d_of_type_Boolean = false;
    a(0L, 0L);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a(1);
    b(false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = null;
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
  
  public int a()
  {
    return b().size();
  }
  
  public int a(List paramList)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if (localRespondQueryQQBindingStat == null) {
      return jdField_e_of_type_Int;
    }
    if (this.jdField_a_of_type_Qcr != null) {
      this.jdField_a_of_type_Qcr.cancel(true);
    }
    this.jdField_a_of_type_Qcr = new qcr(this, null);
    this.jdField_a_of_type_Qcr.a(paramList);
    this.jdField_a_of_type_Qcr.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return jdField_d_of_type_Int;
  }
  
  public int a(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, long paramLong4, List paramList1, List paramList2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServer_v2, isSegmented = ").append(paramBoolean1);
      ((StringBuilder)localObject1).append(", packageNo = ").append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ").append(paramLong1);
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = paramList1;
      if (this.jdField_c_of_type_JavaUtilList != null) {
        break label127;
      }
      this.jdField_c_of_type_JavaUtilList = paramList2;
    }
    int n;
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean1)) {
        break label142;
      }
      n = 0;
      return n;
      this.jdField_b_of_type_JavaUtilList.addAll(paramList1);
      break;
      label127:
      this.jdField_c_of_type_JavaUtilList.addAll(paramList2);
    }
    label142:
    this.jdField_f_of_type_JavaUtilList = null;
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
    if (QLog.isColorLevel())
    {
      paramList1 = new StringBuilder(200);
      paramList1.append("saveContactFromServer, localTimeStamp:");
      paramList1.append(l1).append(", ").append(l2);
      paramList1.append(", remoteTimeStamp: ").append(paramLong2).append(", ").append(paramLong3);
      paramList2 = paramList1.append(", friendCount:");
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        n = this.jdField_b_of_type_JavaUtilList.size();
        paramList2.append(n);
        paramList2 = paramList1.append(", strangerCount:");
        if (this.jdField_c_of_type_JavaUtilList == null) {
          break label751;
        }
        n = this.jdField_c_of_type_JavaUtilList.size();
        label312:
        paramList2.append(n);
        paramList1.append(", queryInterval:").append(paramLong4);
        paramList1.append(", isListChanged:").append(paramBoolean2);
        QLog.d("PhoneContact.Manager", 2, paramList1.toString());
      }
    }
    else
    {
      if (((paramInt == 0) && (paramBoolean1)) || (!paramBoolean1)) {
        d(paramBoolean2);
      }
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
        break label817;
      }
      if (!paramBoolean2) {}
      paramList2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        paramList2.a();
        localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label807;
        }
        localObject3 = (MobileContactsFriendInfo)((Iterator)localObject2).next();
        paramList1 = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramList1 == null) {
          break label757;
        }
        paramList1.uin = ((MobileContactsFriendInfo)localObject3).QQ;
        paramList1.bindingDate = ((MobileContactsFriendInfo)localObject3).bindingDate;
        paramList1.isUploaded = true;
        paramList1.originBinder = ((MobileContactsFriendInfo)localObject3).originBinder;
        paramList1.ability = ((MobileContactsFriendInfo)localObject3).accountAbi;
        paramList1.unifiedCode = a(((MobileContactsFriendInfo)localObject3).MobileNoMask, paramList1.mobileNo);
        paramList1.mobileCode = paramList1.unifiedCode;
        paramList1.nationCode = "";
        if ((!TextUtils.isEmpty(paramList1.uin)) && (!paramList1.uin.equals("0")))
        {
          localObject3 = ((FriendsManager)localObject1).c(paramList1.uin);
          if (localObject3 != null) {
            paramList1.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList1.uin, paramList1);
          ((FriendsManager)localObject1).a(paramList1.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramList1.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList1.unifiedCode, paramList1);
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramList1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramList1 != null) {
          break label797;
        }
        paramList1 = "null";
        QLog.d("PhoneContact.Manager", 2, paramList1);
        continue;
        n = -1;
      }
      finally
      {
        paramList2.b();
      }
      break;
      label751:
      n = -1;
      break label312;
      label757:
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt);
        continue;
        label797:
        paramList1 = paramList1.toString();
      }
    }
    label807:
    paramList2.c();
    paramList2.b();
    label817:
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      paramList2 = new ArrayList(this.jdField_c_of_type_JavaUtilList.size());
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    boolean bool2;
    for (;;)
    {
      try
      {
        paramList1.a();
        localObject1 = this.jdField_c_of_type_JavaUtilList.iterator();
        paramBoolean1 = false;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MobileContactsNotFriendInfo)((Iterator)localObject1).next();
          localObject3 = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
          if (localObject3 != null)
          {
            boolean bool1 = paramBoolean1;
            if (paramBoolean2)
            {
              ((PhoneContact)localObject3).uin = "0";
              ((PhoneContact)localObject3).bindingDate = ((MobileContactsNotFriendInfo)localObject2).bindingDate;
              ((PhoneContact)localObject3).nickName = ((MobileContactsNotFriendInfo)localObject2).nickname;
              ((PhoneContact)localObject3).isUploaded = true;
              ((PhoneContact)localObject3).originBinder = ((MobileContactsNotFriendInfo)localObject2).originBinder;
              ((PhoneContact)localObject3).ability = ((MobileContactsNotFriendInfo)localObject2).accountAbi;
              ((PhoneContact)localObject3).unifiedCode = a(((MobileContactsNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
              ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
              ((PhoneContact)localObject3).nationCode = "";
              bool1 = paramBoolean1;
              if (((MobileContactsNotFriendInfo)localObject2).isNew)
              {
                bool1 = true;
                ((PhoneContact)localObject3).isNewRecommend = true;
                this.jdField_a_of_type_JavaUtilList.add(localObject3);
              }
            }
            if (((MobileContactsNotFriendInfo)localObject2).isUpdateSign) {
              ((PhoneContact)localObject3).setRichBuffer(((MobileContactsNotFriendInfo)localObject2).personalSign, ((MobileContactsNotFriendInfo)localObject2).richTime);
            }
            if (((PhoneContact)localObject3).detalStatusFlag != 20) {
              paramList2.add(((PhoneContact)localObject3).unifiedCode);
            }
            ((PhoneContact)localObject3).netTypeIconId = ((MobileContactsNotFriendInfo)localObject2).conType;
            ((PhoneContact)localObject3).detalStatusFlag = ((MobileContactsNotFriendInfo)localObject2).detalStatusFlag;
            ((PhoneContact)localObject3).iTermType = ((MobileContactsNotFriendInfo)localObject2).iTermType;
            ((PhoneContact)localObject3).strTermDesc = ((MobileContactsNotFriendInfo)localObject2).strTermDesc;
            ((PhoneContact)localObject3).eNetworkType = ((MobileContactsNotFriendInfo)localObject2).eNetworkType;
            ((PhoneContact)localObject3).abilityBits = ((MobileContactsNotFriendInfo)localObject2).uAbiFlag;
            if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
              this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject3).unifiedCode, localObject3);
            }
            ((PhoneContact)localObject3).isHiden = ((MobileContactsNotFriendInfo)localObject2).isHide;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject3);
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break label1498;
            }
            QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
            paramBoolean1 = bool1;
            break label1495;
          }
          bool2 = paramBoolean1;
          if (!QLog.isColorLevel()) {
            break label1498;
          }
          QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
          bool2 = paramBoolean1;
          break label1498;
        }
        c(paramList2);
        paramList1.c();
        paramList1.b();
        this.jdField_b_of_type_JavaUtilList = null;
        this.jdField_c_of_type_JavaUtilList = null;
        n = 6;
        if (paramBoolean2) {
          n = 7;
        }
        paramInt = n;
        if (paramBoolean1) {
          paramInt = n | 0x8;
        }
        if (paramLong1 == 4294967295L)
        {
          if (this.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            d(this.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.clear();
          }
          o();
          a(paramLong2, paramLong3);
          jdField_a_of_type_Long = Math.max(120000L, paramLong4);
          this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putLong("query_contact_list_min_interval", jdField_a_of_type_Long).commit();
        }
        b(paramBoolean1);
        n = paramInt;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PhoneContact.Manager", 2, "saveContactFromServer_v2 leave");
        return paramInt;
      }
      finally
      {
        paramList1.b();
      }
      paramBoolean1 = false;
    }
    for (;;)
    {
      label1495:
      break;
      label1498:
      paramBoolean1 = bool2;
    }
  }
  
  public long a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      return 1L;
    }
    return 10L;
  }
  
  public RespondQueryQQBindingStat a()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences == null) {}
    do
    {
      return null;
      localRespondQueryQQBindingStat.nationCode = localSharedPreferences.getString("contact_bind_info_nation", null);
    } while (localRespondQueryQQBindingStat.nationCode == null);
    localRespondQueryQQBindingStat.mobileNo = localSharedPreferences.getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = localSharedPreferences.getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = localSharedPreferences.getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = localSharedPreferences.getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = localSharedPreferences.getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = localSharedPreferences.getLong("contact_bind_info_flag", 0L);
    localRespondQueryQQBindingStat.type = localSharedPreferences.getInt("contact_bind_type", 0);
    localRespondQueryQQBindingStat.isStopFindMatch = localSharedPreferences.getBoolean("contact_bind_stop_find_match", false);
    return localRespondQueryQQBindingStat;
  }
  
  public PhoneContact a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {}
    try
    {
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = d();
      }
      return this.jdField_c_of_type_JavaLangString;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    EntityManager localEntityManager;
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break;
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    } while (localEntityManager == null);
    PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.a(PhoneNumInfo.class, paramString);
    if (localPhoneNumInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
    }
    localEntityManager.a();
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded != null) {
        localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqDataContactBinded);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList1.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)localIterator.next();
            QLog.d("PhoneContact.Manager", 2, "getRecommendContact|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
          }
        }
      }
    }
    return localArrayList2;
  }
  
  public List a()
  {
    return a(true, true);
  }
  
  public List a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = this.jdField_f_of_type_JavaUtilList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = h();
    }
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (PhoneContact)((Iterator)localObject1).next();
      if (((PhoneContact)localObject3).isHiden) {
        ((List)localObject2).add(localObject3);
      }
    }
    if (paramBoolean)
    {
      localObject3 = new qco(this);
      localObject1 = new ArrayList((Collection)localObject2);
      Collections.sort((List)localObject1, (Comparator)localObject3);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindHideNoneFriendList cost: " + (System.currentTimeMillis() - l1) + ", size = " + ((List)localObject1).size());
      }
      return (List)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public List a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = System.currentTimeMillis();
    Object localObject1 = this.jdField_f_of_type_JavaUtilList;
    if (localObject1 == null) {
      localObject1 = h();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      Object localObject2 = ((List)localObject1).iterator();
      int n = 0;
      if (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if ((localPhoneContact.highLightTimeStamp != 0L) && (Math.abs(System.currentTimeMillis() - localPhoneContact.highLightTimeStamp) > 180000L)) {
          localPhoneContact.highLightTimeStamp = 0L;
        }
        if (localPhoneContact.highLightTimeStamp == 0L) {
          break label262;
        }
        l1 = Math.min(l1, localPhoneContact.highLightTimeStamp);
        n = 1;
      }
      label262:
      for (;;)
      {
        break;
        ThreadManager.b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        if (n != 0) {
          ThreadManager.b().postDelayed(this.jdField_c_of_type_JavaLangRunnable, System.currentTimeMillis() - l1);
        }
        localObject2 = new qcp(this, paramBoolean2, paramBoolean1);
        localObject1 = new ArrayList((Collection)localObject1);
        try
        {
          Collections.sort((List)localObject1, (Comparator)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "getBindNonfriendContactList cost: " + (System.currentTimeMillis() - l2) + ", size = " + ((List)localObject1).size());
          }
          this.jdField_f_of_type_JavaUtilList = ((List)localObject1);
          return (List)localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PhoneContact.Manager", 2, "getBindNonfriendContactList", localException);
            }
          }
        }
      }
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int n = paramString.optInt("all_entrance_num");
          if (n > 0) {
            jdField_b_of_type_Int = n;
          }
          this.jdField_c_of_type_AndroidContentSharedPreferences.edit().putInt("all_entrance_num", jdField_b_of_type_Int).commit();
          this.jdField_c_of_type_AndroidContentSharedPreferences.edit().putInt("key_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateAllEntranceConfig|allEntranceNum = " + jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveBindConfig style:" + paramInt + " wording:" + paramString1 + " blockMsg:" + paramString2);
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putInt("key_bind_style", paramInt);
    localEditor.putString("key_bind_wording", paramString1);
    localEditor.putString("key_block_msg", paramString2);
    localEditor.commit();
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveUIBits: newBits = " + paramLong + " localUIBits = " + this.jdField_e_of_type_Long);
    }
    if (this.jdField_e_of_type_Long != paramLong)
    {
      this.jdField_e_of_type_Long = paramLong;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_contacts_switches", paramLong);
      b(paramLong);
    }
  }
  
  public void a(ContactMatch paramContactMatch)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramContactMatch);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramContactMatch);
      }
      return;
    }
  }
  
  public void a(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramIPhoneContactListener)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramIPhoneContactListener);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 0, false, false);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.jdField_a_of_type_ArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      paramString.eNetworkType = paramGetOnlineInfoResp.eNetworkType;
      paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
      paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      if (((paramGetOnlineInfoResp.iTermType == 67586L) || (paramGetOnlineInfoResp.iTermType == 66566L) || (paramGetOnlineInfoResp.iTermType == 72194L) || (paramGetOnlineInfoResp.iTermType == 65804L) || (paramGetOnlineInfoResp.iTermType == 72706L)) && (paramGetOnlineInfoResp.eNetworkType != 1)) {
        paramString.netTypeIconIdIphoneOrWphoneNoWifi = paramGetOnlineInfoResp.eIconType;
      }
      a(2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0, false, false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 35);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "hideContact mobile=" + paramString + "; hide=" + paramBoolean);
    }
    Object localObject = c(paramString);
    if (localObject != null)
    {
      localObject = new AddressBookItem(((PhoneContact)localObject).mobileNo, ((PhoneContact)localObject).name);
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 34);
      localNewIntent.putExtra("param_hiden_mobile", (Serializable)localObject);
      localNewIntent.putExtra("param_hiden_flag", paramBoolean);
      localNewIntent.putExtra("unique_phone_no", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateRenameList");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    EntityTransaction localEntityTransaction;
    label135:
    do
    {
      for (;;)
      {
        return;
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label135;
            }
            localPhoneContact = (PhoneContact)paramArrayList.next();
            if (localPhoneContact.getStatus() != 1000) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            PhoneContact localPhoneContact;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, paramArrayList.getMessage());
            }
            return;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.b();
          }
        }
      }
      localEntityTransaction.c();
    } while (localEntityTransaction == null);
    localEntityTransaction.b();
  }
  
  public void a(List paramList)
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(4);
      Message localMessage = localMqqHandler.obtainMessage(4);
      localMessage.obj = paramList;
      localMqqHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void a(List paramList, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, size = " + paramList.size() + ", stamp " + paramLong1 + ", interval = " + paramLong2);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_req_last_login_time", System.currentTimeMillis()).putLong("key_login_info_timestamp", paramLong1).putLong("key_req_login_interval", Math.max(43200000L, 1000L * paramLong2)).commit();
    HashSet localHashSet = new HashSet(paramList.size());
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 13);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(str.toUpperCase());
      if (localPhoneContact != null)
      {
        localHashSet.add(localPhoneContact.unifiedCode);
        localStringBuilder.append('|').append(localPhoneContact.unifiedCode);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, wtf pc null " + str.toUpperCase());
      }
    }
    b(localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilSet = localHashSet;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginInfo: " + localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = false;
    if (paramBoolean) {}
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        ((PhoneUnityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(101)).jdField_a_of_type_Boolean = true;
        long l1 = System.currentTimeMillis();
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(200);
          ((StringBuilder)localObject1).append("doQueryContactList, isQueryingContact ").append(this.jdField_b_of_type_Boolean);
          ((StringBuilder)localObject1).append(", isUpdatingContact ").append(this.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject1).append(", mCurrentBindState ").append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", beForce ").append(paramBoolean1);
          ((StringBuilder)localObject1).append(", isQueryAll ").append(paramBoolean2);
          ((StringBuilder)localObject1).append(", lastQueryTime ").append(this.jdField_b_of_type_Long / 1000L);
          ((StringBuilder)localObject1).append(", currentTime ").append(l1 / 1000L);
          QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
        }
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 5))
        {
          boolean bool = this.jdField_c_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        if ((paramBoolean1) || (Math.abs(l1 - this.jdField_b_of_type_Long) >= jdField_a_of_type_Long))
        {
          ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_b_of_type_Boolean = true;
          this.jdField_b_of_type_JavaUtilList = null;
          this.jdField_c_of_type_JavaUtilList = null;
          localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
          ((NewIntent)localObject1).putExtra("req_type", 30);
          ((NewIntent)localObject1).putExtra("next_flag", 0L);
          l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
          long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
          ((NewIntent)localObject1).putExtra("time_stamp", l1);
          ((NewIntent)localObject1).putExtra("richinfo_time_stamp", l2);
          ((NewIntent)localObject1).putExtra("session_id", new byte[0]);
          ((NewIntent)localObject1).putExtra("unique_phone_no", a());
          int n;
          if (paramBoolean2)
          {
            n = 1;
            ((NewIntent)localObject1).putExtra("force_query_list", n);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
          }
          else
          {
            n = 2;
          }
        }
      }
      finally {}
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public boolean a(RecommendedContactInfo paramRecommendedContactInfo)
  {
    if (!TextUtils.isEmpty(paramRecommendedContactInfo.contactsInfoEncrypt))
    {
      paramRecommendedContactInfo.contactsInfoEncrypt = paramRecommendedContactInfo.contactsInfoEncrypt.toUpperCase();
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramRecommendedContactInfo.contactsInfoEncrypt);
      if (localPhoneContact != null)
      {
        paramRecommendedContactInfo.unicode = a(paramRecommendedContactInfo.MobileNoMask, localPhoneContact.mobileNo);
        paramRecommendedContactInfo.name = localPhoneContact.name;
        if ((!TextUtils.isEmpty(paramRecommendedContactInfo.unicode)) && (!TextUtils.isEmpty(paramRecommendedContactInfo.name))) {
          return true;
        }
      }
      else
      {
        QLog.d("newerguide", 2, "test .. fillNewerGuideInfo no contact " + paramRecommendedContactInfo.contactsInfoEncrypt);
      }
    }
    return false;
  }
  
  public boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    if (this.jdField_a_of_type_Int != a(paramRespondQueryQQBindingStat)) {}
    for (boolean bool = true;; bool = false)
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = paramRespondQueryQQBindingStat;
      if (paramRespondQueryQQBindingStat == null) {
        localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
      }
      paramRespondQueryQQBindingStat = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", localRespondQueryQQBindingStat.mobileNo);
      paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", localRespondQueryQQBindingStat.nationCode);
      paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", localRespondQueryQQBindingStat.MobileUniqueNo);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", localRespondQueryQQBindingStat.isRecommend);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", localRespondQueryQQBindingStat.originBinder);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", localRespondQueryQQBindingStat.bindingTime);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", localRespondQueryQQBindingStat.lastUsedFlag);
      paramRespondQueryQQBindingStat.putInt("contact_bind_type", localRespondQueryQQBindingStat.type);
      paramRespondQueryQQBindingStat.putBoolean("contact_bind_stop_find_match", localRespondQueryQQBindingStat.isStopFindMatch);
      this.jdField_h_of_type_Boolean = localRespondQueryQQBindingStat.isPhoneSwitched;
      paramRespondQueryQQBindingStat.commit();
      a(localRespondQueryQQBindingStat);
      return bool;
    }
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("PhoneContact.Manager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public int b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.isReaded) {
            break label154;
          }
          n = 0;
          break label139;
          i1 = n;
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = n;
            if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              if (!localIterator.hasNext()) {
                break label165;
              }
              if (!((ContactMatch)localIterator.next()).isReaded) {
                break label159;
              }
              i1 = 0;
              break label146;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "getUnreadRecommendCount " + i1);
          }
          return i1;
        }
      }
      int n = 0;
      continue;
      label139:
      n += 0;
      continue;
      for (;;)
      {
        label146:
        n += i1;
        break;
        label154:
        n = 1;
        break label139;
        label159:
        i1 = 1;
      }
      label165:
      int i1 = n;
    }
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_bind_wording", null);
  }
  
  public String b(String paramString)
  {
    Object localObject = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localObject == null) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).a(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public List b()
  {
    List localList = this.jdField_f_of_type_JavaUtilList;
    if (localList == null) {
      localList = h();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend) {
          localArrayList.add(localPhoneContact);
        }
      }
      this.jdField_f_of_type_JavaUtilList = localList;
      return localArrayList;
    }
  }
  
  public void b()
  {
    a(true, true);
  }
  
  public void b(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramIPhoneContactListener);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    b(paramString1, paramString2, 0, false, false);
  }
  
  public void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "changeHidenStatus: mobile = " + paramString + ";hide=" + paramBoolean);
    }
    paramString = c(paramString);
    if ((paramString != null) && (paramString.isHiden != paramBoolean))
    {
      paramString.isHiden = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString);
    }
  }
  
  public void b(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
      }
      finally {}
      localEntityTransaction.b();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean b()
  {
    int n = d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + n);
    }
    return n >= 6;
  }
  
  public int c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (QLog.isColorLevel())
    {
      localStringBuffer.append("getBannerState bind state = ");
      localStringBuffer.append(d());
    }
    int n;
    if (d() == 6)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" isCacheInited=");
        localStringBuffer.append(this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_d_of_type_Boolean) {
        if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
          n = 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" ret=");
        localStringBuffer.append(n);
        QLog.d("PhoneContact.Manager", 2, localStringBuffer.toString());
      }
      return n;
      n = 2;
      continue;
      n = 0;
      continue;
      n = 2;
    }
  }
  
  public PhoneContact c(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "queryContactByCodeNumber codeNumber is null");
      }
    }
    do
    {
      return null;
      if (this.jdField_d_of_type_Boolean) {
        return (PhoneContact)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null);
    return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, "mobileCode=?", new String[] { paramString });
  }
  
  public String c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_block_msg", null);
  }
  
  public List c()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, localException.toString());
        }
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
  }
  
  public void c()
  {
    c(false);
  }
  
  public void c(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 33);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 5) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Int != 3) {
          break;
        }
        if (a() == null) {
          break label67;
        }
      } while (a().lastUsedFlag == 2L);
      return false;
      if (this.jdField_a_of_type_Int != 4) {
        break;
      }
      localRespondQueryQQBindingStat = a();
      if (localRespondQueryQQBindingStat == null) {
        break;
      }
    } while (!localRespondQueryQQBindingStat.isStopFindMatch);
    return false;
    label67:
    return false;
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.jdField_a_of_type_Int = a(a());
      return d();
    case 5: 
      return 5;
    case 6: 
      return 6;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public List d()
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    FriendsManager localFriendsManager;
    if (this.jdField_d_of_type_JavaUtilList == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      Collections.sort((List)localObject2, new qca(this));
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (((List)localObject2).size() > 0) {
        if (a() != null) {}
      }
    }
    label322:
    label367:
    label383:
    do
    {
      return (List)localObject1;
      String str = a().mobileNo;
      Iterator localIterator = ((List)localObject2).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = (PhoneContact)localIterator.next();
        if ((str == null) || (!str.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
        {
          PhoneContact localPhoneContact = (PhoneContact)((PhoneContact)localObject2).clone();
          if (TextUtils.isEmpty(localPhoneContact.uin))
          {
            if (localObject1 == null) {
              localObject1 = localPhoneContact;
            }
            for (;;)
            {
              break;
              if (localPhoneContact.contactID == ((PhoneContact)localObject1).contactID)
              {
                ((PhoneContact)localObject1).mobileNo = (((PhoneContact)localObject1).mobileNo + "|" + localPhoneContact.mobileNo);
                if (!QLog.isColorLevel()) {
                  break label367;
                }
                QLog.d("PhoneContact.Manager", 2, "getContactListForDisplay: conbine contact contact name is:" + ((PhoneContact)localObject1).name + "uin is :" + ((PhoneContact)localObject1).uin + "number is:" + ((PhoneContact)localObject1).mobileNo);
              }
              else
              {
                localArrayList2.add(localObject1);
                localObject1 = localPhoneContact;
              }
            }
          }
          if (localPhoneContact.uin.equals("0"))
          {
            localObject2 = null;
            if ((localObject2 == null) || (((Friends)localObject2).groupid < 0)) {
              break label383;
            }
            localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
            localPhoneContact.remark = ((Friends)localObject2).remark;
            localPhoneContact.faceUrl = Short.toString(((Friends)localObject2).faceid);
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localFriendsManager.c(localPhoneContact.uin);
            break label322;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new qcb(this);
      Collections.sort(localArrayList1, (Comparator)localObject1);
      Collections.sort(localArrayList2, (Comparator)localObject1);
      this.jdField_d_of_type_JavaUtilList = localArrayList1;
      this.jdField_e_of_type_JavaUtilList = localArrayList2;
      localObject2 = new ArrayList();
      ((List)localObject2).add(this.jdField_d_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_e_of_type_JavaUtilList);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("PhoneContact.Manager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l1));
    return (List)localObject2;
  }
  
  public void d()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      Object localObject2;
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (PhoneContact)((Iterator)???).next();
          ((PhoneContact)localObject2).pinyinFirst = PhoneContactHelper.b(((PhoneContact)localObject2).pinyinInitial);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject2).mobileNo, localObject2);
          if ((!TextUtils.isEmpty(((PhoneContact)localObject2).uin)) && (!((PhoneContact)localObject2).uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject2).uin, localObject2);
          }
          if (!TextUtils.isEmpty(((PhoneContact)localObject2).unifiedCode)) {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject2).unifiedCode, localObject2);
          }
          if (!TextUtils.isEmpty(((PhoneContact)localObject2).md5)) {
            this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject2).md5, localObject2);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "No contacts.");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactBinded.class, false, null, null, null, null, null, null);
        if (localObject2 == null) {
          break label417;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "initContactCache|ContactBindedlist.Size = " + ((ArrayList)localObject2).size());
        }
        if (((ArrayList)localObject2).size() > 1) {
          throw new IllegalStateException("wrong ContactBinded size with " + ((ArrayList)localObject2).size());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = ((ContactBinded)((ArrayList)localObject3).get(0));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactMatch.class, false, null, null, null, null, null, null));
      jdField_b_of_type_Int = this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("all_entrance_num", 20);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "initContactCache|NewFriendManager.sAllEntranceNum = " + jdField_b_of_type_Int);
      }
      k();
      this.jdField_d_of_type_Boolean = true;
      a(1);
      return;
      label417:
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "initContactCache|mContactBinded is null");
      }
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        paramString1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
        if (paramString1 == null) {
          break label107;
        }
        paramString1.uin = paramString2;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString1);
        if ((TextUtils.isEmpty(paramString1.uin)) || (paramString1.uin.equals("0"))) {
          break label113;
        }
        this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      finally
      {
        localEntityTransaction.b();
      }
      localEntityTransaction.c();
      localEntityTransaction.b();
      if (n != 0) {
        a(1);
      }
      return;
      label107:
      int n = 0;
      continue;
      label113:
      n = 1;
    }
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 181	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 372	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 378	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   15: iconst_1
    //   16: anewarray 88	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 90
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 384	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 394 1 0
    //   41: istore 4
    //   43: iload 4
    //   45: ifle +67 -> 112
    //   48: iconst_1
    //   49: istore 5
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_2
    //   56: invokeinterface 439 1 0
    //   61: iload 5
    //   63: ireturn
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 779	java/lang/Exception:printStackTrace	()V
    //   73: aload_2
    //   74: ifnull +36 -> 110
    //   77: aload_2
    //   78: invokeinterface 439 1 0
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_1
    //   86: aload_2
    //   87: ifnull +9 -> 96
    //   90: aload_2
    //   91: invokeinterface 439 1 0
    //   96: aload_1
    //   97: athrow
    //   98: astore_3
    //   99: aload_1
    //   100: astore_2
    //   101: aload_3
    //   102: astore_1
    //   103: goto -17 -> 86
    //   106: astore_3
    //   107: goto -40 -> 67
    //   110: iconst_0
    //   111: ireturn
    //   112: iconst_0
    //   113: istore 5
    //   115: goto -64 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	PhoneContactManagerImp
    //   30	39	1	localObject1	Object
    //   85	15	1	localObject2	Object
    //   102	1	1	localObject3	Object
    //   1	100	2	localObject4	Object
    //   64	6	3	localException1	Exception
    //   98	4	3	localObject5	Object
    //   106	1	3	localException2	Exception
    //   41	3	4	n	int
    //   49	65	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	31	64	java/lang/Exception
    //   2	31	85	finally
    //   35	43	98	finally
    //   69	73	98	finally
    //   35	43	106	java/lang/Exception
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List e()
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_g_of_type_JavaUtilList == null) || (this.jdField_g_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        Collections.sort(localArrayList, new qcd(this));
      }
      this.jdField_g_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_g_of_type_JavaUtilList;
  }
  
  public void e()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    b(false, false);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).b(localPhoneNumInfo);
        ((EntityManager)localObject).a();
      }
    }
  }
  
  public boolean e()
  {
    int n = d();
    return (n != 1) || (n == 2);
  }
  
  public int f()
  {
    return this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("key_config_version", 0);
  }
  
  public List f()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((this.jdField_h_of_type_JavaUtilList == null) || (this.jdField_h_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          localArrayList.add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((FriendsManager)localObject1).c(localPhoneContact.uin) != null)) {
          localArrayList.add(localPhoneContact);
        }
      }
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PhoneContact)((Iterator)localObject1).next();
          if (((PhoneContact)localObject2).pinyinFirst == null) {
            ((PhoneContact)localObject2).pinyinFirst = PhoneContactHelper.b(((PhoneContact)localObject2).pinyinInitial);
          }
        }
        Collections.sort(localArrayList, new qce(this));
      }
      this.jdField_h_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForPhoneSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_h_of_type_JavaUtilList;
  }
  
  public void f()
  {
    a(1);
  }
  
  public List g()
  {
    long l1 = System.currentTimeMillis();
    Object localObject2;
    ArrayList localArrayList;
    FriendsManager localFriendsManager;
    Object localObject1;
    label186:
    label229:
    label242:
    String str2;
    int i1;
    label310:
    int n;
    label331:
    int i2;
    label344:
    int i3;
    label365:
    Friends localFriends;
    label372:
    label386:
    int i4;
    if (this.i == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      Collections.sort((List)localObject2, new qci(this));
      localArrayList = new ArrayList();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (((List)localObject2).size() > 0)
      {
        if (a() == null) {
          return null;
        }
        String str1 = a().mobileNo;
        localObject1 = null;
        Iterator localIterator = ((List)localObject2).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (PhoneContact)localIterator.next();
            if ((str1 == null) || (!str1.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
            {
              localObject2 = (PhoneContact)((PhoneContact)localObject2).clone();
              if (localObject1 == null)
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(((PhoneContact)localObject2).uin))
                {
                  if (!((PhoneContact)localObject2).uin.equals("0")) {
                    break label229;
                  }
                  localObject1 = null;
                  if ((localObject1 == null) || (((Friends)localObject1).groupid < 0)) {
                    break label242;
                  }
                  ((PhoneContact)localObject2).nickName = ((Friends)localObject1).getFriendNick();
                  ((PhoneContact)localObject2).remark = ((Friends)localObject1).remark;
                  ((PhoneContact)localObject2).faceUrl = Short.toString(((Friends)localObject1).faceid);
                }
                for (localObject1 = localObject2;; localObject1 = localObject2)
                {
                  break;
                  localObject1 = localFriendsManager.c(((PhoneContact)localObject2).uin);
                  break label186;
                  ((PhoneContact)localObject2).uin = "0";
                }
              }
              if (((PhoneContact)localObject2).contactID == ((PhoneContact)localObject1).contactID)
              {
                str2 = ((PhoneContact)localObject1).mobileNo + "|" + ((PhoneContact)localObject2).mobileNo;
                if (!TextUtils.isEmpty(((PhoneContact)localObject1).uin))
                {
                  i1 = 1;
                  if ((i1 == 0) || (((PhoneContact)localObject1).uin.equals("0"))) {
                    break label468;
                  }
                  n = 1;
                  if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
                    break label474;
                  }
                  i2 = 1;
                  if ((i2 == 0) || (((PhoneContact)localObject2).uin.equals("0"))) {
                    break label480;
                  }
                  i3 = 1;
                  if (i3 != 0) {
                    break label486;
                  }
                  localFriends = null;
                  if ((localFriends == null) || (localFriends.groupid < 0)) {
                    break label499;
                  }
                  i3 = 1;
                  i4 = 2;
                  if (n == 0) {
                    break label505;
                  }
                  n = 0;
                  label397:
                  if (i3 == 0) {
                    break label520;
                  }
                  i1 = 0;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label405:
      if (n > i1)
      {
        localObject1 = localObject2;
        if (i2 != 0)
        {
          if (i3 == 0) {
            break label531;
          }
          ((PhoneContact)localObject2).nickName = localFriends.getFriendNick();
          ((PhoneContact)localObject2).remark = localFriends.remark;
          ((PhoneContact)localObject2).faceUrl = Short.toString(localFriends.faceid);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        ((PhoneContact)localObject1).mobileNo = str2;
        break;
        i1 = 0;
        break label310;
        label468:
        n = 0;
        break label331;
        label474:
        i2 = 0;
        break label344;
        label480:
        i3 = 0;
        break label365;
        label486:
        localFriends = localFriendsManager.c(((PhoneContact)localObject2).uin);
        break label372;
        label499:
        i3 = 0;
        break label386;
        label505:
        n = i4;
        if (i1 == 0) {
          break label397;
        }
        n = 1;
        break label397;
        label520:
        if (i2 == 0) {
          break label721;
        }
        i1 = 1;
        break label405;
        label531:
        ((PhoneContact)localObject2).uin = "0";
        localObject1 = localObject2;
        continue;
        localArrayList.add(localObject1);
        localObject1 = localObject2;
        if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
          break;
        }
        if (((PhoneContact)localObject2).uin.equals("0")) {}
        for (localObject1 = null;; localObject1 = localFriendsManager.c(((PhoneContact)localObject2).uin))
        {
          if ((localObject1 == null) || (((Friends)localObject1).groupid < 0)) {
            break label633;
          }
          ((PhoneContact)localObject2).nickName = ((Friends)localObject1).getFriendNick();
          ((PhoneContact)localObject2).remark = ((Friends)localObject1).remark;
          ((PhoneContact)localObject2).faceUrl = Short.toString(((Friends)localObject1).faceid);
          localObject1 = localObject2;
          break;
        }
        label633:
        ((PhoneContact)localObject2).uin = "0";
        localObject1 = localObject2;
        break;
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        Collections.sort(localArrayList, new qcj(this));
        this.i = localArrayList;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - l1));
        }
        return this.i;
      }
      label721:
      i1 = 2;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 132	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 255	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 402	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 406	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   19: aload_0
    //   20: getfield 874	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   23: ifnull +20 -> 43
    //   26: aload_0
    //   27: getfield 874	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 887	com/tencent/mobileqq/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 874	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   39: invokevirtual 889	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   42: pop
    //   43: aload_0
    //   44: getfield 891	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   47: ifnull +82 -> 129
    //   50: aload_0
    //   51: getfield 891	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: invokevirtual 446	java/util/ArrayList:size	()I
    //   57: ifle +72 -> 129
    //   60: aload_0
    //   61: getfield 891	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   64: invokevirtual 893	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   67: astore_3
    //   68: aload_3
    //   69: invokeinterface 532 1 0
    //   74: ifeq +55 -> 129
    //   77: aload_3
    //   78: invokeinterface 536 1 0
    //   83: checkcast 895	com/tencent/mobileqq/data/ContactMatch
    //   86: astore 4
    //   88: aload 4
    //   90: iconst_1
    //   91: putfield 1501	com/tencent/mobileqq/data/ContactMatch:isReaded	Z
    //   94: aload_0
    //   95: aload 4
    //   97: invokevirtual 889	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   100: pop
    //   101: goto -33 -> 68
    //   104: astore_3
    //   105: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +14 -> 122
    //   111: ldc_w 386
    //   114: iconst_2
    //   115: ldc_w 1648
    //   118: aload_3
    //   119: invokestatic 434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload_2
    //   123: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   126: aload_1
    //   127: monitorexit
    //   128: return
    //   129: aload_2
    //   130: invokevirtual 562	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   133: aload_2
    //   134: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   137: goto -11 -> 126
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: astore_3
    //   146: aload_2
    //   147: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   150: aload_3
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	PhoneContactManagerImp
    //   4	138	1	localObject1	Object
    //   14	120	2	localEntityTransaction	EntityTransaction
    //   140	7	2	localObject2	Object
    //   67	11	3	localIterator	Iterator
    //   104	15	3	localException	Exception
    //   145	6	3	localObject3	Object
    //   86	10	4	localContactMatch	ContactMatch
    // Exception table:
    //   from	to	target	type
    //   15	43	104	java/lang/Exception
    //   43	68	104	java/lang/Exception
    //   68	101	104	java/lang/Exception
    //   129	133	104	java/lang/Exception
    //   7	15	140	finally
    //   122	126	140	finally
    //   126	128	140	finally
    //   133	137	140	finally
    //   141	143	140	finally
    //   146	152	140	finally
    //   15	43	145	finally
    //   43	68	145	finally
    //   68	101	145	finally
    //   105	122	145	finally
    //   129	133	145	finally
  }
  
  /* Error */
  public void i()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +71 -> 78
    //   10: new 196	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 824	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 1650
    //   24: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 123	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   32: iconst_5
    //   33: if_icmpne +5 -> 38
    //   36: iconst_1
    //   37: istore_3
    //   38: aload_2
    //   39: iload_3
    //   40: invokevirtual 309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: ldc_w 1047
    //   48: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   54: aload_0
    //   55: getfield 117	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Long	J
    //   58: lsub
    //   59: ldc2_w 1048
    //   62: ldiv
    //   63: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc_w 386
    //   70: iconst_2
    //   71: aload_1
    //   72: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 123	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   82: iconst_5
    //   83: if_icmpeq +12 -> 95
    //   86: aload_0
    //   87: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   90: astore_1
    //   91: aload_1
    //   92: ifnonnull +6 -> 98
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   101: aload_0
    //   102: getfield 117	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Long	J
    //   105: lsub
    //   106: ldc2_w 27
    //   109: lcmp
    //   110: iflt -15 -> 95
    //   113: aload_0
    //   114: iconst_5
    //   115: putfield 123	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   118: aload_0
    //   119: invokespecial 641	com/tencent/mobileqq/app/PhoneContactManagerImp:n	()V
    //   122: aload_0
    //   123: getfield 570	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Qcu	Lqcu;
    //   126: ifnonnull +23 -> 149
    //   129: aload_0
    //   130: new 1652	qcu
    //   133: dup
    //   134: aload_0
    //   135: aconst_null
    //   136: invokespecial 1653	qcu:<init>	(Lcom/tencent/mobileqq/app/PhoneContactManagerImp;Lqbu;)V
    //   139: putfield 570	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Qcu	Lqcu;
    //   142: aload_0
    //   143: getfield 570	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Qcu	Lqcu;
    //   146: invokevirtual 1654	qcu:a	()V
    //   149: aload_0
    //   150: invokespecial 1656	com/tencent/mobileqq/app/PhoneContactManagerImp:b	()Ljava/util/ArrayList;
    //   153: astore_2
    //   154: aload_2
    //   155: astore_1
    //   156: aload_2
    //   157: ifnonnull +12 -> 169
    //   160: new 176	java/util/ArrayList
    //   163: dup
    //   164: iconst_0
    //   165: invokespecial 892	java/util/ArrayList:<init>	(I)V
    //   168: astore_1
    //   169: new 709	mqq/app/NewIntent
    //   172: dup
    //   173: aload_0
    //   174: getfield 181	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   177: invokevirtual 713	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   180: ldc_w 715
    //   183: invokespecial 718	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   186: astore_2
    //   187: aload_2
    //   188: ldc_w 720
    //   191: bipush 31
    //   193: invokevirtual 724	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   196: pop
    //   197: aload_2
    //   198: ldc_w 726
    //   201: aload_0
    //   202: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   205: invokevirtual 729	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   208: pop
    //   209: aload_2
    //   210: ldc_w 740
    //   213: lconst_0
    //   214: invokevirtual 743	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   217: pop
    //   218: aload_2
    //   219: ldc_w 745
    //   222: iconst_0
    //   223: invokevirtual 724	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   226: pop
    //   227: aload_2
    //   228: ldc_w 1658
    //   231: aload_1
    //   232: invokevirtual 734	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   235: pop
    //   236: aload_2
    //   237: ldc -38
    //   239: iconst_0
    //   240: newarray <illegal type>
    //   242: invokevirtual 748	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   245: pop
    //   246: aload_2
    //   247: ldc_w 750
    //   250: iconst_0
    //   251: invokevirtual 753	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   254: pop
    //   255: aload_0
    //   256: getfield 181	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: aload_2
    //   260: invokevirtual 757	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   263: goto -168 -> 95
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	PhoneContactManagerImp
    //   19	213	1	localObject1	Object
    //   266	4	1	localObject2	Object
    //   27	233	2	localObject3	Object
    //   1	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	28	266	finally
    //   28	36	266	finally
    //   38	78	266	finally
    //   78	91	266	finally
    //   98	149	266	finally
    //   149	154	266	finally
    //   160	169	266	finally
    //   169	263	266	finally
  }
  
  public void onDestroy()
  {
    this.jdField_e_of_type_JavaUtilList = null;
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_g_of_type_JavaUtilList = null;
    this.i = null;
    ThreadManager.b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\PhoneContactManagerImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */