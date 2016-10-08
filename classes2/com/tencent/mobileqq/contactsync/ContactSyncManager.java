package com.tencent.mobileqq.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.AggregationExceptions;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import rbc;
import rbd;
import rbe;
import rbf;
import rbg;
import rbk;

public class ContactSyncManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 500;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.Manager";
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static final int jdField_b_of_type_Int = 1;
  private static String jdField_b_of_type_JavaLangString;
  private static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = "contactsync";
  private static final String e = "pref_remove_account_prefix";
  private Account jdField_a_of_type_AndroidAccountsAccount;
  private AccountManager jdField_a_of_type_AndroidAccountsAccountManager;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new rbf(this, ThreadManager.b());
  public QQAppInterface a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new rbc(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new rbe(this);
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private volatile boolean jdField_c_of_type_Boolean;
  private final String jdField_d_of_type_JavaLangString = "pref_sync_contact";
  private volatile boolean jdField_d_of_type_Boolean;
  private String f = "com.android.contacts";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = Constants.jdField_d_of_type_JavaLangString;
  }
  
  public ContactSyncManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "ContactSyncManager onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAccountsAccountManager = AccountManager.get(paramQQAppInterface.a());
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("contactsync", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_sync_contact", true);
    for (;;)
    {
      try
      {
        b();
        boolean bool = d();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "ContactSyncManager oncreate | support = " + bool);
        }
        if (!bool) {
          continue;
        }
        paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ContactSync.Manager", 2, "initSyncAccount e = ", localThrowable);
        continue;
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_remove_account_prefix" + paramQQAppInterface.a(), false);
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (Build.MANUFACTURER.contains("OPPO")) {
      str = paramString.replace("'", "").replace("%", "").replace("_", "-").replace("/", "").replace("[", "").replace("]", "").replace("&", "");
    }
    return str;
  }
  
  /* Error */
  private List a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_1
    //   11: new 229	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 230	java/util/ArrayList:<init>	()V
    //   18: astore 4
    //   20: aload_1
    //   21: aload_0
    //   22: invokespecial 232	com/tencent/mobileqq/contactsync/ContactSyncManager:c	()Ljava/lang/String;
    //   25: invokestatic 237	rbk:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   28: getstatic 240	rbk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +158 -> 197
    //   42: aload_2
    //   43: astore_1
    //   44: aload 4
    //   46: aload_2
    //   47: invokeinterface 252 1 0
    //   52: invokevirtual 256	java/util/ArrayList:ensureCapacity	(I)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: invokeinterface 259 1 0
    //   63: ifeq +134 -> 197
    //   66: aload_2
    //   67: astore_1
    //   68: new 261	com/tencent/mobileqq/contactsync/RawContact
    //   71: dup
    //   72: invokespecial 262	com/tencent/mobileqq/contactsync/RawContact:<init>	()V
    //   75: astore_3
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: aload_2
    //   80: iconst_0
    //   81: invokeinterface 266 2 0
    //   86: putfield 268	com/tencent/mobileqq/contactsync/RawContact:jdField_a_of_type_Long	J
    //   89: aload_2
    //   90: astore_1
    //   91: aload_3
    //   92: aload_2
    //   93: iconst_1
    //   94: invokeinterface 272 2 0
    //   99: putfield 274	com/tencent/mobileqq/contactsync/RawContact:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: aload_2
    //   103: astore_1
    //   104: aload_3
    //   105: aload_2
    //   106: iconst_2
    //   107: invokeinterface 278 2 0
    //   112: putfield 280	com/tencent/mobileqq/contactsync/RawContact:jdField_a_of_type_Int	I
    //   115: aload_2
    //   116: astore_1
    //   117: aload 4
    //   119: aload_3
    //   120: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: goto -69 -> 55
    //   127: astore_3
    //   128: aload_2
    //   129: astore_1
    //   130: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +15 -> 148
    //   136: aload_2
    //   137: astore_1
    //   138: ldc 15
    //   140: iconst_2
    //   141: ldc_w 286
    //   144: aload_3
    //   145: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_2
    //   149: ifnull +9 -> 158
    //   152: aload_2
    //   153: invokeinterface 289 1 0
    //   158: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +33 -> 194
    //   164: ldc 15
    //   166: iconst_2
    //   167: new 145	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 291
    //   177: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 4
    //   182: invokevirtual 294	java/util/ArrayList:size	()I
    //   185: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload 4
    //   196: areturn
    //   197: aload_2
    //   198: ifnull -40 -> 158
    //   201: aload_2
    //   202: invokeinterface 289 1 0
    //   207: goto -49 -> 158
    //   210: astore_1
    //   211: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq -56 -> 158
    //   217: ldc 15
    //   219: iconst_2
    //   220: ldc_w 299
    //   223: aload_1
    //   224: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: goto -69 -> 158
    //   230: astore_1
    //   231: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -76 -> 158
    //   237: ldc 15
    //   239: iconst_2
    //   240: ldc_w 299
    //   243: aload_1
    //   244: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: goto -89 -> 158
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: ifnull +9 -> 263
    //   257: aload_1
    //   258: invokeinterface 289 1 0
    //   263: aload_2
    //   264: athrow
    //   265: astore_1
    //   266: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -6 -> 263
    //   272: ldc 15
    //   274: iconst_2
    //   275: ldc_w 299
    //   278: aload_1
    //   279: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -19 -> 263
    //   285: astore_2
    //   286: goto -33 -> 253
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_2
    //   292: goto -164 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	ContactSyncManager
    //   10	128	1	localObject1	Object
    //   210	14	1	localThrowable1	Throwable
    //   230	14	1	localThrowable2	Throwable
    //   252	6	1	localObject2	Object
    //   265	14	1	localThrowable3	Throwable
    //   37	165	2	localCursor	android.database.Cursor
    //   250	14	2	localObject3	Object
    //   285	1	2	localObject4	Object
    //   291	1	2	localObject5	Object
    //   75	45	3	localRawContact	RawContact
    //   127	18	3	localException1	Exception
    //   289	1	3	localException2	Exception
    //   18	177	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   44	55	127	java/lang/Exception
    //   57	66	127	java/lang/Exception
    //   68	76	127	java/lang/Exception
    //   78	89	127	java/lang/Exception
    //   91	102	127	java/lang/Exception
    //   104	115	127	java/lang/Exception
    //   117	124	127	java/lang/Exception
    //   201	207	210	java/lang/Throwable
    //   152	158	230	java/lang/Throwable
    //   20	38	250	finally
    //   257	263	265	java/lang/Throwable
    //   44	55	285	finally
    //   57	66	285	finally
    //   68	76	285	finally
    //   78	89	285	finally
    //   91	102	285	finally
    //   104	115	285	finally
    //   117	124	285	finally
    //   130	136	285	finally
    //   138	148	285	finally
    //   20	38	289	java/lang/Exception
  }
  
  private Map a()
  {
    List localList = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c();
    if (localList != null)
    {
      HashMap localHashMap = new HashMap(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (!TextUtils.isEmpty(localPhoneContact.uin)) {
          localHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "getQQContacts | allList.size = " + localList.size() + " | map.size=" + localHashMap.size());
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  /* Error */
  private Set a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: new 51	java/util/HashSet
    //   14: dup
    //   15: invokespecial 54	java/util/HashSet:<init>	()V
    //   18: astore_1
    //   19: aload_2
    //   20: getstatic 360	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   23: iconst_1
    //   24: anewarray 194	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc_w 362
    //   32: aastore
    //   33: ldc_w 364
    //   36: iconst_1
    //   37: anewarray 194	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc_w 366
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +254 -> 306
    //   55: aload_2
    //   56: astore_3
    //   57: new 51	java/util/HashSet
    //   60: dup
    //   61: aload_2
    //   62: invokeinterface 252 1 0
    //   67: invokespecial 367	java/util/HashSet:<init>	(I)V
    //   70: astore 4
    //   72: aload_2
    //   73: astore_3
    //   74: aload_2
    //   75: invokeinterface 259 1 0
    //   80: ifeq +107 -> 187
    //   83: aload_2
    //   84: astore_3
    //   85: aload 4
    //   87: aload_2
    //   88: iconst_0
    //   89: invokeinterface 266 2 0
    //   94: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: invokeinterface 376 2 0
    //   102: pop
    //   103: goto -31 -> 72
    //   106: astore_3
    //   107: aload 4
    //   109: astore_1
    //   110: aload_3
    //   111: astore 4
    //   113: aload_2
    //   114: astore_3
    //   115: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +16 -> 134
    //   121: aload_2
    //   122: astore_3
    //   123: ldc 15
    //   125: iconst_2
    //   126: ldc_w 378
    //   129: aload 4
    //   131: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_1
    //   135: astore_3
    //   136: aload_2
    //   137: ifnull +11 -> 148
    //   140: aload_2
    //   141: invokeinterface 289 1 0
    //   146: aload_1
    //   147: astore_3
    //   148: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +34 -> 185
    //   154: ldc 15
    //   156: iconst_2
    //   157: new 145	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 380
    //   167: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_3
    //   171: invokeinterface 381 1 0
    //   176: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_3
    //   186: areturn
    //   187: aload 4
    //   189: astore_1
    //   190: aload_1
    //   191: astore_3
    //   192: aload_2
    //   193: ifnull -45 -> 148
    //   196: aload_2
    //   197: invokeinterface 289 1 0
    //   202: aload_1
    //   203: astore_3
    //   204: goto -56 -> 148
    //   207: astore_2
    //   208: aload_1
    //   209: astore_3
    //   210: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -65 -> 148
    //   216: ldc 15
    //   218: iconst_2
    //   219: ldc_w 383
    //   222: aload_2
    //   223: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: astore_3
    //   228: goto -80 -> 148
    //   231: astore_2
    //   232: aload_1
    //   233: astore_3
    //   234: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq -89 -> 148
    //   240: ldc 15
    //   242: iconst_2
    //   243: ldc_w 383
    //   246: aload_2
    //   247: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   250: aload_1
    //   251: astore_3
    //   252: goto -104 -> 148
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_3
    //   258: aload_3
    //   259: ifnull +9 -> 268
    //   262: aload_3
    //   263: invokeinterface 289 1 0
    //   268: aload_1
    //   269: athrow
    //   270: astore_2
    //   271: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -6 -> 268
    //   277: ldc 15
    //   279: iconst_2
    //   280: ldc_w 383
    //   283: aload_2
    //   284: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: goto -19 -> 268
    //   290: astore_1
    //   291: goto -33 -> 258
    //   294: astore 4
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -185 -> 113
    //   301: astore 4
    //   303: goto -190 -> 113
    //   306: goto -116 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	ContactSyncManager
    //   18	233	1	localObject1	Object
    //   255	14	1	localObject2	Object
    //   290	1	1	localObject3	Object
    //   10	187	2	localObject4	Object
    //   207	16	2	localThrowable1	Throwable
    //   231	16	2	localThrowable2	Throwable
    //   270	14	2	localThrowable3	Throwable
    //   297	1	2	localObject5	Object
    //   56	29	3	localObject6	Object
    //   106	5	3	localException1	Exception
    //   114	149	3	localObject7	Object
    //   70	118	4	localObject8	Object
    //   294	1	4	localException2	Exception
    //   301	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   74	83	106	java/lang/Exception
    //   85	103	106	java/lang/Exception
    //   196	202	207	java/lang/Throwable
    //   140	146	231	java/lang/Throwable
    //   19	51	255	finally
    //   262	268	270	java/lang/Throwable
    //   57	72	290	finally
    //   74	83	290	finally
    //   85	103	290	finally
    //   115	121	290	finally
    //   123	134	290	finally
    //   19	51	294	java/lang/Exception
    //   57	72	301	java/lang/Exception
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | current authority = " + this.f);
    }
    if (this.f.equals("com.android.contacts"))
    {
      Object localObject = d();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | find substitute authority = " + (String)localObject);
        }
        this.f = ((String)localObject);
        localObject = this.jdField_a_of_type_AndroidAccountsAccount;
        if (localObject != null) {
          ContentResolver.setSyncAutomatically((Account)localObject, this.f, true);
        }
        b();
      }
    }
  }
  
  private void a(long paramLong, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", jdField_b_of_type_JavaLangString).build(), "_id = ?", new String[] { paramLong + "" });
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteRawContact | leave");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Account paramAccount)
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "markAccountDeleteByUser | accountSetIDel = " + jdField_a_of_type_JavaUtilSet + " | name = " + paramAccount.name + " | contain = " + jdField_a_of_type_JavaUtilSet.contains(paramAccount.name));
      }
      if (jdField_a_of_type_JavaUtilSet.remove(paramAccount.name)) {
        return;
      }
      paramQQAppInterface.a().getSharedPreferences("contactsync", 0).edit().putBoolean("pref_remove_account_prefix" + paramAccount.name, true).commit();
      ??? = (ContactSyncManager)paramQQAppInterface.getManager(40);
      if (??? != null)
      {
        if ((!TextUtils.isEmpty(paramQQAppInterface.a())) && (e(paramAccount.name).equals(paramQQAppInterface.a()))) {
          ((ContactSyncManager)???).jdField_b_of_type_Boolean = true;
        }
        ((ContactSyncManager)???).jdField_a_of_type_AndroidAccountsAccount = null;
        ((ContactSyncManager)???).jdField_d_of_type_Boolean = false;
        return;
      }
    }
  }
  
  private void a(List paramList, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id1", Long.valueOf(paramLong1));
    localContentValues.put("raw_contact_id2", Long.valueOf(paramLong2));
    localContentValues.put("type", Integer.valueOf(1));
    paramList.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI).withValues(localContentValues).withYieldAllowed(true).build());
  }
  
  private void a(List paramList, PhoneContact paramPhoneContact)
  {
    paramList = ContactOperation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, c(), paramPhoneContact.mobileNo, paramPhoneContact.nationCode, paramPhoneContact.mobileCode, paramPhoneContact.ability, paramPhoneContact.contactID);
    paramList.b(paramPhoneContact.name);
    paramList.d(paramPhoneContact.mobileNo);
  }
  
  /* Error */
  private void a(List paramList, PhoneContact paramPhoneContact, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: aload_1
    //   5: lload_3
    //   6: invokestatic 542	com/tencent/mobileqq/contactsync/ContactOperation:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;J)Lcom/tencent/mobileqq/contactsync/ContactOperation;
    //   9: astore 6
    //   11: aload_0
    //   12: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: invokevirtual 546	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   18: invokevirtual 549	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore_1
    //   22: aload_1
    //   23: getstatic 553	rbi:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   26: getstatic 554	rbi:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   29: ldc_w 556
    //   32: iconst_1
    //   33: anewarray 194	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: lload_3
    //   39: invokestatic 559	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +114 -> 165
    //   54: aload 5
    //   56: astore_1
    //   57: aload 5
    //   59: invokeinterface 259 1 0
    //   64: ifeq +101 -> 165
    //   67: aload 5
    //   69: astore_1
    //   70: aload 5
    //   72: iconst_1
    //   73: invokeinterface 272 2 0
    //   78: ldc_w 561
    //   81: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -30 -> 54
    //   87: aload 5
    //   89: astore_1
    //   90: aload 5
    //   92: iconst_2
    //   93: invokeinterface 272 2 0
    //   98: astore 7
    //   100: aload 5
    //   102: astore_1
    //   103: aload 7
    //   105: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +18 -> 126
    //   111: aload 5
    //   113: astore_1
    //   114: aload 7
    //   116: aload_2
    //   117: getfield 533	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   120: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +42 -> 165
    //   126: aload 5
    //   128: astore_1
    //   129: aload 5
    //   131: iconst_0
    //   132: invokeinterface 266 2 0
    //   137: lstore_3
    //   138: aload 5
    //   140: astore_1
    //   141: getstatic 553	rbi:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   144: lload_3
    //   145: invokestatic 567	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   148: astore 7
    //   150: aload 5
    //   152: astore_1
    //   153: aload 6
    //   155: aload_2
    //   156: getfield 533	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   159: aload 7
    //   161: invokevirtual 570	com/tencent/mobileqq/contactsync/ContactOperation:a	(Ljava/lang/String;Landroid/net/Uri;)Lcom/tencent/mobileqq/contactsync/ContactOperation;
    //   164: pop
    //   165: aload 5
    //   167: ifnull +10 -> 177
    //   170: aload 5
    //   172: invokeinterface 289 1 0
    //   177: return
    //   178: astore_1
    //   179: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -5 -> 177
    //   185: ldc 15
    //   187: iconst_2
    //   188: ldc_w 572
    //   191: aload_1
    //   192: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: return
    //   196: astore_2
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: astore_1
    //   203: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +16 -> 222
    //   209: aload 5
    //   211: astore_1
    //   212: ldc 15
    //   214: iconst_2
    //   215: ldc_w 574
    //   218: aload_2
    //   219: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 5
    //   224: ifnull -47 -> 177
    //   227: aload 5
    //   229: invokeinterface 289 1 0
    //   234: return
    //   235: astore_1
    //   236: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -62 -> 177
    //   242: ldc 15
    //   244: iconst_2
    //   245: ldc_w 572
    //   248: aload_1
    //   249: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: return
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: aload_1
    //   261: invokeinterface 289 1 0
    //   266: aload_2
    //   267: athrow
    //   268: astore_1
    //   269: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -6 -> 266
    //   275: ldc 15
    //   277: iconst_2
    //   278: ldc_w 572
    //   281: aload_1
    //   282: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -19 -> 266
    //   288: astore_2
    //   289: goto -33 -> 256
    //   292: astore_2
    //   293: goto -93 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	ContactSyncManager
    //   0	296	1	paramList	List
    //   0	296	2	paramPhoneContact	PhoneContact
    //   0	296	3	paramLong	long
    //   47	181	5	localCursor	android.database.Cursor
    //   9	145	6	localContactOperation	ContactOperation
    //   98	62	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   170	177	178	java/lang/Throwable
    //   22	49	196	java/lang/Exception
    //   227	234	235	java/lang/Throwable
    //   22	49	253	finally
    //   260	266	268	java/lang/Throwable
    //   57	67	288	finally
    //   70	87	288	finally
    //   90	100	288	finally
    //   103	111	288	finally
    //   114	126	288	finally
    //   129	138	288	finally
    //   141	150	288	finally
    //   153	165	288	finally
    //   203	209	288	finally
    //   212	222	288	finally
    //   57	67	292	java/lang/Exception
    //   70	87	292	java/lang/Exception
    //   90	100	292	java/lang/Exception
    //   103	111	292	java/lang/Exception
    //   114	126	292	java/lang/Exception
    //   129	138	292	java/lang/Exception
    //   141	150	292	java/lang/Exception
    //   153	165	292	java/lang/Exception
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "applyBatch | enter");
    }
    boolean bool = true;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().applyBatch(this.f, paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "applyBatch | result = " + bool + " | leave");
      }
      return bool;
    }
    catch (RemoteException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | RemoteException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | OperationApplicationException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (IllegalArgumentException paramArrayList)
    {
      for (;;)
      {
        String str = Log.getStackTraceString(paramArrayList);
        if ((!TextUtils.isEmpty(str)) && (str.contains("Unknown authority"))) {
          a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | IllegalArgumentException: ", paramArrayList);
        }
        bool = false;
      }
    }
  }
  
  private boolean a(Map paramMap)
  {
    for (;;)
    {
      boolean bool;
      Object localObject3;
      ArrayList localArrayList;
      Object localObject2;
      Object localObject1;
      int i;
      RawContact localRawContact;
      String str;
      try
      {
        if (h())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = enter");
          }
          bool = false;
          return bool;
        }
        localObject3 = a();
        localArrayList = new ArrayList();
        localObject2 = new HashSet(paramMap.size());
        localObject1 = new HashSet();
        localObject3 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label329;
        }
        localRawContact = (RawContact)((Iterator)localObject3).next();
        if (h())
        {
          if (!QLog.isColorLevel()) {
            break label1106;
          }
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for1");
          break label1106;
        }
        str = localRawContact.jdField_a_of_type_JavaLangString;
        if ((TextUtils.isEmpty(str)) || (!paramMap.containsKey(localRawContact.jdField_a_of_type_JavaLangString)))
        {
          a(localRawContact.jdField_a_of_type_Long, localArrayList);
          i += 1;
          continue;
        }
        if ((TextUtils.isEmpty(str)) || (!paramMap.containsKey(str))) {
          continue;
        }
        if (((Set)localObject2).contains(Integer.valueOf(localRawContact.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ContactSync.Manager", 2, "doSyncContacts | error: duplicate contact id");
          }
          a(localRawContact.jdField_a_of_type_Long, localArrayList);
          paramMap.remove(str);
          continue;
        }
        ((Set)localObject2).add(Integer.valueOf(localRawContact.jdField_a_of_type_Int));
      }
      finally {}
      if (((PhoneContact)paramMap.get(str)).contactID != localRawContact.jdField_a_of_type_Int)
      {
        ((Set)localObject1).add(localRawContact.jdField_a_of_type_JavaLangString);
        a(localArrayList, (PhoneContact)paramMap.get(str), localRawContact.jdField_a_of_type_Long);
        continue;
        label329:
        paramMap = paramMap.values();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | delete count = " + i + " | reaggregate count = " + ((Set)localObject1).size() + " | will insert count = " + paramMap.size());
        }
        if ((localArrayList.size() > 0) && (!h()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply update ops | size = " + localArrayList.size());
          }
          a(localArrayList);
          localArrayList.clear();
        }
        paramMap = paramMap.iterator();
        label664:
        while (paramMap.hasNext())
        {
          localObject3 = (PhoneContact)paramMap.next();
          if (h())
          {
            if (!QLog.isColorLevel()) {
              break label1112;
            }
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for2");
            break label1112;
          }
          if (!((Set)localObject2).contains(Integer.valueOf(((PhoneContact)localObject3).contactID)))
          {
            a(localArrayList, (PhoneContact)localObject3);
            ((Set)localObject2).add(Integer.valueOf(((PhoneContact)localObject3).contactID));
            ((Set)localObject1).add(((PhoneContact)localObject3).mobileNo);
          }
          for (;;)
          {
            if (localArrayList.size() <= 500) {
              break label664;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size());
            }
            a(localArrayList);
            localArrayList.clear();
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | contact " + ((PhoneContact)localObject3).contactID + " has two match phonenum");
            }
          }
        }
        if ((localArrayList.size() > 0) && (!h()))
        {
          bool = a(localArrayList);
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size() + " | result = " + bool);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | aggregateMap.size = " + ((Set)localObject1).size());
        }
        if (((Set)localObject1).size() == 0)
        {
          bool = true;
        }
        else
        {
          localArrayList.clear();
          localArrayList.ensureCapacity(((Set)localObject1).size());
          localObject2 = a();
          paramMap = b();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RawContact)((Iterator)localObject2).next();
            if ((((Set)localObject1).contains(((RawContact)localObject3).jdField_a_of_type_JavaLangString)) && (paramMap.containsKey(((RawContact)localObject3).jdField_a_of_type_JavaLangString)))
            {
              a(localArrayList, ((RawContact)localObject3).jdField_a_of_type_Long, ((Long)paramMap.get(((RawContact)localObject3).jdField_a_of_type_JavaLangString)).longValue());
              ((Set)localObject1).remove(((RawContact)localObject3).jdField_a_of_type_JavaLangString);
            }
            if (localArrayList.size() > 500)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply aggregate batch | size = " + localArrayList.size());
              }
              a(localArrayList);
              localArrayList.clear();
            }
          }
          if (QLog.isColorLevel())
          {
            paramMap = ((Set)localObject1).iterator();
            while (paramMap.hasNext())
            {
              localObject1 = (String)paramMap.next();
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | remain source ID = " + c((String)localObject1));
            }
          }
          if ((localArrayList.size() > 0) && (!h()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply aggregate batch | size = " + localArrayList.size());
            }
            a(localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | leave");
          }
          bool = true;
          continue;
          label1106:
          bool = false;
          continue;
          label1112:
          bool = false;
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid uin";
    }
    return paramString.substring(0, 3);
  }
  
  /* Error */
  private Map b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: new 310	java/util/HashMap
    //   14: dup
    //   15: invokespecial 353	java/util/HashMap:<init>	()V
    //   18: astore_1
    //   19: aload_2
    //   20: getstatic 701	rbj:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   23: getstatic 702	rbj:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +216 -> 250
    //   37: aload_2
    //   38: astore_3
    //   39: new 310	java/util/HashMap
    //   42: dup
    //   43: aload_2
    //   44: invokeinterface 252 1 0
    //   49: invokespecial 315	java/util/HashMap:<init>	(I)V
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload_2
    //   57: invokeinterface 259 1 0
    //   62: ifeq +78 -> 140
    //   65: aload_2
    //   66: astore_3
    //   67: aload 4
    //   69: aload_2
    //   70: iconst_0
    //   71: invokeinterface 272 2 0
    //   76: invokestatic 706	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   79: aload_2
    //   80: iconst_3
    //   81: invokeinterface 266 2 0
    //   86: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 707	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: goto -39 -> 54
    //   96: astore_3
    //   97: aload 4
    //   99: astore_1
    //   100: aload_3
    //   101: astore 4
    //   103: aload_2
    //   104: astore_3
    //   105: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +16 -> 124
    //   111: aload_2
    //   112: astore_3
    //   113: ldc 15
    //   115: iconst_2
    //   116: ldc_w 709
    //   119: aload 4
    //   121: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: astore_3
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokeinterface 289 1 0
    //   136: aload_1
    //   137: astore_3
    //   138: aload_3
    //   139: areturn
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: astore_3
    //   145: aload_2
    //   146: ifnull -8 -> 138
    //   149: aload_2
    //   150: invokeinterface 289 1 0
    //   155: aload_1
    //   156: areturn
    //   157: astore_2
    //   158: aload_1
    //   159: astore_3
    //   160: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq -25 -> 138
    //   166: ldc 15
    //   168: iconst_2
    //   169: ldc_w 711
    //   172: aload_2
    //   173: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: areturn
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -46 -> 138
    //   187: ldc 15
    //   189: iconst_2
    //   190: ldc_w 711
    //   193: aload_2
    //   194: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_1
    //   198: areturn
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_3
    //   203: ifnull +9 -> 212
    //   206: aload_3
    //   207: invokeinterface 289 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -6 -> 212
    //   221: ldc 15
    //   223: iconst_2
    //   224: ldc_w 711
    //   227: aload_2
    //   228: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: goto -19 -> 212
    //   234: astore_1
    //   235: goto -33 -> 202
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_2
    //   242: goto -139 -> 103
    //   245: astore 4
    //   247: goto -144 -> 103
    //   250: goto -107 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	ContactSyncManager
    //   18	180	1	localObject1	Object
    //   199	14	1	localObject2	Object
    //   234	1	1	localObject3	Object
    //   10	140	2	localObject4	Object
    //   157	16	2	localThrowable1	Throwable
    //   178	16	2	localThrowable2	Throwable
    //   214	14	2	localThrowable3	Throwable
    //   241	1	2	localObject5	Object
    //   38	29	3	localObject6	Object
    //   96	5	3	localException1	Exception
    //   104	103	3	localObject7	Object
    //   52	89	4	localObject8	Object
    //   238	1	4	localException2	Exception
    //   245	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   56	65	96	java/lang/Exception
    //   67	93	96	java/lang/Exception
    //   149	155	157	java/lang/Throwable
    //   130	136	178	java/lang/Throwable
    //   19	33	199	finally
    //   206	212	214	java/lang/Throwable
    //   39	54	234	finally
    //   56	65	234	finally
    //   67	93	234	finally
    //   105	111	234	finally
    //   113	124	234	finally
    //   19	33	238	java/lang/Exception
    //   39	54	245	java/lang/Exception
  }
  
  private void b()
  {
    Account[] arrayOfAccount = this.jdField_a_of_type_AndroidAccountsAccountManager.getAccountsByType("com.tencent.mobileqq.account");
    if (arrayOfAccount.length > 0)
    {
      this.jdField_a_of_type_AndroidAccountsAccount = arrayOfAccount[0];
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "initSyncAccount | syncAccount = " + this.jdField_a_of_type_AndroidAccountsAccount);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new rbg(this, arrayOfAccount));
    }
  }
  
  private String c()
  {
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    if (localAccount != null) {
      return localAccount.name;
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid phone num";
    }
    return paramString.substring(paramString.length() - 3);
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 738 1 0
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 395	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_AndroidAccountsAccount	Landroid/accounts/Account;
    //   14: aload_0
    //   15: getfield 123	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_AndroidAccountsAccountManager	Landroid/accounts/AccountManager;
    //   18: ldc_w 713
    //   21: invokevirtual 717	android/accounts/AccountManager:getAccountsByType	(Ljava/lang/String;)[Landroid/accounts/Account;
    //   24: astore_2
    //   25: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +30 -> 58
    //   31: ldc 15
    //   33: iconst_2
    //   34: new 145	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 740
    //   44: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: arraylength
    //   49: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_2
    //   59: arraylength
    //   60: istore 5
    //   62: iconst_0
    //   63: istore 4
    //   65: iload 4
    //   67: iload 5
    //   69: if_icmpge +126 -> 195
    //   72: aload_2
    //   73: iload 4
    //   75: aaload
    //   76: astore_3
    //   77: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +35 -> 115
    //   83: ldc 15
    //   85: iconst_2
    //   86: new 145	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 742
    //   96: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_3
    //   100: getfield 444	android/accounts/Account:name	Ljava/lang/String;
    //   103: invokestatic 744	com/tencent/mobileqq/contactsync/ContactSyncManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: getstatic 56	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   118: astore_1
    //   119: aload_1
    //   120: monitorenter
    //   121: getstatic 56	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   124: aload_3
    //   125: getfield 444	android/accounts/Account:name	Ljava/lang/String;
    //   128: invokeinterface 376 2 0
    //   133: pop
    //   134: aload_1
    //   135: monitorexit
    //   136: aload_0
    //   137: getfield 123	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_AndroidAccountsAccountManager	Landroid/accounts/AccountManager;
    //   140: aload_3
    //   141: new 746	rbh
    //   144: dup
    //   145: aload_0
    //   146: invokespecial 747	rbh:<init>	(Lcom/tencent/mobileqq/contactsync/ContactSyncManager;)V
    //   149: aconst_null
    //   150: invokevirtual 751	android/accounts/AccountManager:removeAccount	(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   153: pop
    //   154: iload 4
    //   156: iconst_1
    //   157: iadd
    //   158: istore 4
    //   160: goto -95 -> 65
    //   163: astore_2
    //   164: aload_1
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: astore_1
    //   169: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +13 -> 185
    //   175: ldc 15
    //   177: iconst_2
    //   178: ldc_w 753
    //   181: aload_1
    //   182: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_0
    //   186: getfield 73	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   189: invokeinterface 756 1 0
    //   194: return
    //   195: aload_0
    //   196: getfield 73	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   199: invokeinterface 756 1 0
    //   204: return
    //   205: astore_1
    //   206: aload_0
    //   207: getfield 73	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   210: invokeinterface 756 1 0
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	ContactSyncManager
    //   168	14	1	localThrowable	Throwable
    //   205	11	1	localObject1	Object
    //   24	49	2	arrayOfAccount	Account[]
    //   163	4	2	localObject2	Object
    //   76	65	3	localAccount	Account
    //   63	96	4	i	int
    //   60	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   121	136	163	finally
    //   164	166	163	finally
    //   9	58	168	java/lang/Throwable
    //   58	62	168	java/lang/Throwable
    //   77	115	168	java/lang/Throwable
    //   115	121	168	java/lang/Throwable
    //   136	154	168	java/lang/Throwable
    //   166	168	168	java/lang/Throwable
    //   9	58	205	finally
    //   58	62	205	finally
    //   77	115	205	finally
    //   115	121	205	finally
    //   136	154	205	finally
    //   166	168	205	finally
    //   169	185	205	finally
  }
  
  private String d()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageManager().getInstalledPackages(8).iterator();
    while (localIterator.hasNext())
    {
      ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)localIterator.next()).providers;
      if (arrayOfProviderInfo != null)
      {
        int j = arrayOfProviderInfo.length;
        int i = 0;
        while (i < j)
        {
          ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
          if ((localProviderInfo.authority.contains("contacts")) && (!localProviderInfo.authority.equals("com.android.contacts"))) {
            return localProviderInfo.authority;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() > 4))
    {
      localObject = new StringBuilder();
      int j = paramString.length() - 4;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append("*");
        i += 1;
      }
      ((StringBuilder)localObject).append(paramString.substring(j));
      localObject = ((StringBuilder)localObject).toString();
    }
    do
    {
      return (String)localObject;
      localObject = paramString;
    } while (paramString != null);
    return "";
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("pref_remove_account_prefix" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private static String e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("(");
      int j = paramString.lastIndexOf(")");
      if ((i != -1) && (j != -1)) {
        return paramString.substring(i + 1, j);
      }
    }
    return null;
  }
  
  private boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldAddAccount | is device support = " + d() + " | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean + " | hasIRemovedByUser = " + this.jdField_b_of_type_Boolean);
    }
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      Object localObject = a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldAddAccount | syncUin = " + b((String)localObject) + " | currentUin = " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        return false;
      }
      localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("coundlAddAccount | pcm = ").append(localObject).append(" | bindState = ");
        if (localObject == null) {
          break label310;
        }
      }
      label310:
      for (int i = ((PhoneContactManager)localObject).d();; i = 64536)
      {
        QLog.d("ContactSync.Manager", 2, i);
        if ((localObject == null) || (!((PhoneContactManager)localObject).b())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "couldAddAccount | bind state = " + ((PhoneContactManager)localObject).d());
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldSyncContact | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean);
    }
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject = a();
        PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("couldSyncContact | bind state = ");
          if (localPhoneContactManager == null) {
            break label295;
          }
          i = 6;
          QLog.d("ContactSync.Manager", 2, i + " | account.name = " + b((String)localObject));
        }
        bool1 = bool2;
        if (localPhoneContactManager != null)
        {
          bool1 = bool2;
          if (localPhoneContactManager.b())
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))
            {
              localObject = this.jdField_a_of_type_AndroidAccountsAccount;
              if (localObject == null) {
                break label309;
              }
              bool2 = ContentResolver.getSyncAutomatically((Account)localObject, this.f);
              if (ContentResolver.getIsSyncable((Account)localObject, this.f) <= 0) {
                break label303;
              }
              bool1 = true;
              label228:
              bool3 = ContentResolver.getMasterSyncAutomatically();
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldSyncContact | isSystemSyncAutomatic = " + bool2 + " | isSystemSyncable = " + bool1 + " | isMasterSyncAutomatic = " + bool3);
      }
      bool1 = bool2;
      return bool1;
      label295:
      i = -100000;
      break;
      label303:
      bool1 = false;
      break label228;
      label309:
      bool1 = false;
      bool2 = false;
    }
  }
  
  private boolean h()
  {
    boolean bool2 = true;
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    boolean bool1;
    StringBuilder localStringBuilder;
    if ((localAccount == null) || (Thread.interrupted()))
    {
      bool1 = true;
      if ((bool1) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder().append("shouldStopSync | account = ");
        if (localAccount != null) {
          break label82;
        }
      }
    }
    for (;;)
    {
      QLog.d("ContactSync.Manager", 2, bool2 + " | interrupted = " + Thread.interrupted());
      return bool1;
      bool1 = false;
      break;
      label82:
      bool2 = false;
    }
  }
  
  private boolean i()
  {
    boolean bool = f();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "addSyncAccount | could add account = " + bool);
    }
    if (!bool) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Account localAccount = new Account(a(String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() })), "com.tencent.mobileqq.account");
        if (!this.jdField_a_of_type_AndroidAccountsAccountManager.addAccountExplicitly(localAccount, null, null)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly success");
        }
        this.jdField_a_of_type_AndroidAccountsAccount = localAccount;
        ContentResolver.setIsSyncable(this.jdField_a_of_type_AndroidAccountsAccount, this.f, 1);
        ContentResolver.setSyncAutomatically(localAccount, this.f, true);
        b();
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | e = ", localThrowable);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly fail");
      }
    }
  }
  
  /* Error */
  public SimplePhoneContact a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 4
    //   12: aload 4
    //   14: aload_1
    //   15: iconst_1
    //   16: anewarray 194	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 884
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +625 -> 658
    //   36: aload_1
    //   37: astore_2
    //   38: aload_1
    //   39: invokeinterface 259 1 0
    //   44: ifeq +614 -> 658
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: iconst_0
    //   51: invokeinterface 266 2 0
    //   56: lstore 6
    //   58: aload_1
    //   59: ifnull +596 -> 655
    //   62: aload_1
    //   63: invokeinterface 289 1 0
    //   68: lload 6
    //   70: ldc2_w 885
    //   73: lcmp
    //   74: ifne +126 -> 200
    //   77: aconst_null
    //   78: areturn
    //   79: astore_2
    //   80: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +13 -> 96
    //   86: ldc 15
    //   88: iconst_2
    //   89: ldc_w 888
    //   92: aload_2
    //   93: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: goto -28 -> 68
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: astore_2
    //   104: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +15 -> 122
    //   110: aload_1
    //   111: astore_2
    //   112: ldc 15
    //   114: iconst_2
    //   115: ldc_w 890
    //   118: aload_3
    //   119: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload_1
    //   123: ifnull +524 -> 647
    //   126: aload_1
    //   127: invokeinterface 289 1 0
    //   132: ldc2_w 885
    //   135: lstore 6
    //   137: goto -69 -> 68
    //   140: astore_2
    //   141: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +13 -> 157
    //   147: ldc 15
    //   149: iconst_2
    //   150: ldc_w 888
    //   153: aload_2
    //   154: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: ldc2_w 885
    //   160: lstore 6
    //   162: goto -94 -> 68
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 289 1 0
    //   178: aload_1
    //   179: athrow
    //   180: astore_2
    //   181: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -6 -> 178
    //   187: ldc 15
    //   189: iconst_2
    //   190: ldc_w 888
    //   193: aload_2
    //   194: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: goto -19 -> 178
    //   200: new 892	com/tencent/mobileqq/contactsync/SimplePhoneContact
    //   203: dup
    //   204: invokespecial 893	com/tencent/mobileqq/contactsync/SimplePhoneContact:<init>	()V
    //   207: astore 5
    //   209: aload 4
    //   211: getstatic 553	rbi:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   214: getstatic 554	rbi:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   217: ldc_w 556
    //   220: iconst_1
    //   221: anewarray 194	java/lang/String
    //   224: dup
    //   225: iconst_0
    //   226: lload 6
    //   228: invokestatic 559	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   231: aastore
    //   232: aconst_null
    //   233: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   236: astore_2
    //   237: aload_2
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull +46 -> 286
    //   243: aload_1
    //   244: astore_2
    //   245: aload_1
    //   246: invokeinterface 259 1 0
    //   251: ifeq +35 -> 286
    //   254: aload_1
    //   255: astore_2
    //   256: aload_1
    //   257: iconst_1
    //   258: invokeinterface 272 2 0
    //   263: ldc_w 561
    //   266: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   269: ifeq -26 -> 243
    //   272: aload_1
    //   273: astore_2
    //   274: aload 5
    //   276: aload_1
    //   277: iconst_2
    //   278: invokeinterface 272 2 0
    //   283: putfield 894	com/tencent/mobileqq/contactsync/SimplePhoneContact:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   286: aload_1
    //   287: astore_2
    //   288: aload_1
    //   289: ifnull +353 -> 642
    //   292: aload_1
    //   293: invokeinterface 289 1 0
    //   298: aload 4
    //   300: getstatic 360	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   303: getstatic 896	rbk:b	[Ljava/lang/String;
    //   306: ldc_w 898
    //   309: iconst_1
    //   310: anewarray 194	java/lang/String
    //   313: dup
    //   314: iconst_0
    //   315: lload 6
    //   317: invokestatic 559	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   320: aastore
    //   321: aconst_null
    //   322: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull +56 -> 383
    //   330: aload_2
    //   331: astore_1
    //   332: aload_2
    //   333: invokeinterface 259 1 0
    //   338: ifeq +45 -> 383
    //   341: aload_2
    //   342: astore_1
    //   343: aload 5
    //   345: aload_2
    //   346: iconst_0
    //   347: invokeinterface 272 2 0
    //   352: putfield 899	com/tencent/mobileqq/contactsync/SimplePhoneContact:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: aload_2
    //   356: astore_1
    //   357: aload 5
    //   359: aload_2
    //   360: iconst_1
    //   361: invokeinterface 272 2 0
    //   366: putfield 901	com/tencent/mobileqq/contactsync/SimplePhoneContact:c	Ljava/lang/String;
    //   369: aload_2
    //   370: astore_1
    //   371: aload 5
    //   373: aload_2
    //   374: iconst_2
    //   375: invokeinterface 278 2 0
    //   380: putfield 902	com/tencent/mobileqq/contactsync/SimplePhoneContact:jdField_a_of_type_Int	I
    //   383: aload_2
    //   384: ifnull +9 -> 393
    //   387: aload_2
    //   388: invokeinterface 289 1 0
    //   393: aload 5
    //   395: areturn
    //   396: astore_2
    //   397: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +13 -> 413
    //   403: ldc 15
    //   405: iconst_2
    //   406: ldc_w 904
    //   409: aload_2
    //   410: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -115 -> 298
    //   416: astore_3
    //   417: aload_1
    //   418: astore_2
    //   419: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +15 -> 437
    //   425: aload_1
    //   426: astore_2
    //   427: ldc 15
    //   429: iconst_2
    //   430: ldc_w 890
    //   433: aload_3
    //   434: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: aload_1
    //   438: astore_2
    //   439: aload_1
    //   440: ifnull +202 -> 642
    //   443: aload_1
    //   444: invokeinterface 289 1 0
    //   449: goto -151 -> 298
    //   452: astore_2
    //   453: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +13 -> 469
    //   459: ldc 15
    //   461: iconst_2
    //   462: ldc_w 904
    //   465: aload_2
    //   466: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   469: goto -171 -> 298
    //   472: astore_3
    //   473: aload_1
    //   474: astore_2
    //   475: aload_3
    //   476: astore_1
    //   477: aload_2
    //   478: ifnull +9 -> 487
    //   481: aload_2
    //   482: invokeinterface 289 1 0
    //   487: aload_1
    //   488: athrow
    //   489: astore_2
    //   490: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq -6 -> 487
    //   496: ldc 15
    //   498: iconst_2
    //   499: ldc_w 904
    //   502: aload_2
    //   503: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   506: goto -19 -> 487
    //   509: astore_1
    //   510: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq -120 -> 393
    //   516: ldc 15
    //   518: iconst_2
    //   519: ldc_w 906
    //   522: aload_1
    //   523: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   526: goto -133 -> 393
    //   529: astore_3
    //   530: aload_1
    //   531: astore_2
    //   532: aload_2
    //   533: astore_1
    //   534: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +15 -> 552
    //   540: aload_2
    //   541: astore_1
    //   542: ldc 15
    //   544: iconst_2
    //   545: ldc_w 890
    //   548: aload_3
    //   549: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   552: aload_2
    //   553: ifnull -160 -> 393
    //   556: aload_2
    //   557: invokeinterface 289 1 0
    //   562: goto -169 -> 393
    //   565: astore_1
    //   566: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq -176 -> 393
    //   572: ldc 15
    //   574: iconst_2
    //   575: ldc_w 906
    //   578: aload_1
    //   579: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   582: goto -189 -> 393
    //   585: astore_2
    //   586: aload_1
    //   587: ifnull +9 -> 596
    //   590: aload_1
    //   591: invokeinterface 289 1 0
    //   596: aload_2
    //   597: athrow
    //   598: astore_1
    //   599: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq -6 -> 596
    //   605: ldc 15
    //   607: iconst_2
    //   608: ldc_w 906
    //   611: aload_1
    //   612: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   615: goto -19 -> 596
    //   618: astore_2
    //   619: goto -33 -> 586
    //   622: astore_3
    //   623: goto -91 -> 532
    //   626: astore_1
    //   627: goto -150 -> 477
    //   630: astore_3
    //   631: goto -214 -> 417
    //   634: astore_1
    //   635: goto -467 -> 168
    //   638: astore_3
    //   639: goto -537 -> 102
    //   642: aload_2
    //   643: astore_1
    //   644: goto -346 -> 298
    //   647: ldc2_w 885
    //   650: lstore 6
    //   652: goto -584 -> 68
    //   655: goto -587 -> 68
    //   658: ldc2_w 885
    //   661: lstore 6
    //   663: goto -605 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	ContactSyncManager
    //   0	666	1	paramUri	Uri
    //   37	12	2	localUri1	Uri
    //   79	14	2	localThrowable1	Throwable
    //   103	9	2	localUri2	Uri
    //   140	14	2	localThrowable2	Throwable
    //   167	6	2	localObject1	Object
    //   180	14	2	localThrowable3	Throwable
    //   236	152	2	localObject2	Object
    //   396	14	2	localThrowable4	Throwable
    //   418	21	2	localUri3	Uri
    //   452	14	2	localThrowable5	Throwable
    //   474	8	2	localUri4	Uri
    //   489	14	2	localThrowable6	Throwable
    //   531	26	2	localUri5	Uri
    //   585	12	2	localObject3	Object
    //   618	25	2	localObject4	Object
    //   99	20	3	localException1	Exception
    //   416	18	3	localException2	Exception
    //   472	4	3	localObject5	Object
    //   529	20	3	localException3	Exception
    //   622	1	3	localException4	Exception
    //   630	1	3	localException5	Exception
    //   638	1	3	localException6	Exception
    //   10	289	4	localContentResolver	ContentResolver
    //   207	187	5	localSimplePhoneContact	SimplePhoneContact
    //   56	606	6	l	long
    // Exception table:
    //   from	to	target	type
    //   62	68	79	java/lang/Throwable
    //   12	32	99	java/lang/Exception
    //   126	132	140	java/lang/Throwable
    //   12	32	165	finally
    //   172	178	180	java/lang/Throwable
    //   292	298	396	java/lang/Throwable
    //   209	237	416	java/lang/Exception
    //   443	449	452	java/lang/Throwable
    //   209	237	472	finally
    //   481	487	489	java/lang/Throwable
    //   387	393	509	java/lang/Throwable
    //   298	326	529	java/lang/Exception
    //   556	562	565	java/lang/Throwable
    //   298	326	585	finally
    //   590	596	598	java/lang/Throwable
    //   332	341	618	finally
    //   343	355	618	finally
    //   357	369	618	finally
    //   371	383	618	finally
    //   534	540	618	finally
    //   542	552	618	finally
    //   332	341	622	java/lang/Exception
    //   343	355	622	java/lang/Exception
    //   357	369	622	java/lang/Exception
    //   371	383	622	java/lang/Exception
    //   245	254	626	finally
    //   256	272	626	finally
    //   274	286	626	finally
    //   419	425	626	finally
    //   427	437	626	finally
    //   245	254	630	java/lang/Exception
    //   256	272	630	java/lang/Exception
    //   274	286	630	java/lang/Exception
    //   38	47	634	finally
    //   49	58	634	finally
    //   104	110	634	finally
    //   112	122	634	finally
    //   38	47	638	java/lang/Exception
    //   49	58	638	java/lang/Exception
  }
  
  public String a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      return e(str);
    }
    return null;
  }
  
  /* Error */
  public String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 194	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 909
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 259 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 272 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 289 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 911
    //   82: aload_1
    //   83: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 15
    //   103: iconst_2
    //   104: ldc_w 913
    //   107: aload_3
    //   108: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 289 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 911
    //   136: aload_1
    //   137: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 289 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 15
    //   166: iconst_2
    //   167: ldc_w 911
    //   170: aload_2
    //   171: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	Exception
    //   181	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String a(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    int i;
    int j;
    if ((paramGetOnlineInfoResp.iTermType == 65793L) || (paramGetOnlineInfoResp.iTermType == 67586L))
    {
      i = 1;
      j = (int)paramGetOnlineInfoResp.dwStatus;
      if ((20 != j) && (21 != j) && (40 != j) && (41 != j)) {
        break label90;
      }
    }
    for (;;)
    {
      i = ContactUtils.a(j, (int)paramGetOnlineInfoResp.iTermType);
      if ((i == 0) || (i == 6)) {
        break label97;
      }
      return paramGetOnlineInfoResp.strTermDesc;
      i = 0;
      break;
      label90:
      if (i == 0) {}
    }
    label97:
    return null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteSyncContact | mobileNo = " + c(paramString));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(rbk.a(c()), "sourceid=?", new String[] { paramString });
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "setSyncContactAllowed | allow = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("pref_sync_contact", paramBoolean).commit();
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    if (this.c)
    {
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncAllContacts | isSyncing = " + this.c);
    }
    if ((this.c) || (!g())) {
      return false;
    }
    this.c = true;
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    boolean bool = a(a());
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_d_of_type_Boolean = false;
    }
    this.c = false;
    return bool;
  }
  
  /* Error */
  public String b(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 194	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 964
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 259 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 272 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 289 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 966
    //   82: aload_1
    //   83: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 15
    //   103: iconst_2
    //   104: ldc_w 968
    //   107: aload_3
    //   108: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 289 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 966
    //   136: aload_1
    //   137: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 289 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 15
    //   166: iconst_2
    //   167: ldc_w 966
    //   170: aload_2
    //   171: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	Exception
    //   181	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String b(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    String str1 = "";
    String str2 = "";
    int i;
    switch (paramGetOnlineInfoResp.eNetworkType)
    {
    default: 
      i = 0;
      paramGetOnlineInfoResp = str2;
    }
    while (i != 0)
    {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getResources().getString(2131371191), new Object[] { str1, paramGetOnlineInfoResp });
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371198);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371201);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371198);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371202);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371198);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371203);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371200);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131371204);
      i = 1;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncBindContactList");
    }
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (!this.c) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new rbd(this));
    }
    for (;;)
    {
      return true;
      BaseApplicationImpl.a.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    boolean bool = true;
    String str = Build.MANUFACTURER;
    if (str.toLowerCase().contains("samsung")) {
      return e();
    }
    if (!str.toLowerCase().contains("oppo")) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean e()
  {
    if (Build.VERSION.SDK_INT < 22) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().acquireContentProviderClient("com.android.contacts");
      return true;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\contactsync\ContactSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */