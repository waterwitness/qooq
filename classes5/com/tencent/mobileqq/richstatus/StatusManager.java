package com.tencent.mobileqq.richstatus;

import PersonalState.UserProfile;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import protocol.KQQConfig.GetResourceReqInfo;
import ujm;
import ujn;
import ujo;
import ujr;

public class StatusManager
  implements BitmapDecoder.IBitmapListener, Manager
{
  public static final int a = -3;
  private static final long jdField_a_of_type_Long = 104L;
  public static final String a = "Q.richstatus.";
  private static volatile WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public static final boolean a = false;
  private static Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[2];
  public static final int b = -2;
  private static final long jdField_b_of_type_Long = 180000L;
  public static final String b = "Q.richstatus.img";
  public static final int c = -1;
  private static final long jdField_c_of_type_Long = 240000L;
  public static final String c = "Q.richstatus.xml";
  public static final int d = 100;
  private static final long jdField_d_of_type_Long = 60000L;
  public static final String d = "Q.richstatus.shuo";
  public static final int e = 101;
  private static final long jdField_e_of_type_Long = 43200000L;
  public static final String e = "Q.richstatus.set";
  public static final int f = 102;
  private static final long f = 300000L;
  public static final String f = "Q.richstatus.mate";
  public static final int g = 200;
  public static final String g = "Q.richstatus.status";
  public static final int h = 201;
  public static final String h = "rich_status.tmp";
  public static final int i = 300;
  public static final String i = "$N";
  public static final int j = 301;
  public static final String j = "$A";
  public static final int k = -1;
  public static final String k = "rich_status";
  public static final int l = 0;
  public static final String l = "k_version";
  public static final int m = 0;
  public static final String m = "key_params_qq";
  public static final int n = 1;
  private static final String n = "rich_status.xml";
  private static final int jdField_o_of_type_Int = 2;
  private static final String jdField_o_of_type_JavaLangString = "_";
  private static final int jdField_p_of_type_Int = 3;
  private static final String jdField_p_of_type_JavaLangString = "_s_";
  private static final String jdField_q_of_type_JavaLangString = "$U";
  private static final String jdField_r_of_type_JavaLangString = "$D";
  private static final String jdField_s_of_type_JavaLangString = "$T";
  private static final int jdField_t_of_type_Int = 14;
  private static final String jdField_t_of_type_JavaLangString = "$I";
  private static final String u = "k_update_time";
  private static final String v = "k_icon";
  private static final String w = "k_sync_ss";
  private static final String x = "k_ss_time";
  private volatile AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  private volatile SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BitmapDecoder jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private AsyncTask jdField_b_of_type_AndroidOsAsyncTask;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private LinkedList jdField_b_of_type_JavaUtilLinkedList;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private LinkedList jdField_c_of_type_JavaUtilLinkedList;
  private LinkedList jdField_d_of_type_JavaUtilLinkedList;
  private LinkedList jdField_e_of_type_JavaUtilLinkedList;
  private long g;
  private long h;
  private long i;
  private long j;
  private int jdField_q_of_type_Int;
  private int jdField_r_of_type_Int;
  private int jdField_s_of_type_Int;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private StatusManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.i = a().getLong("k_update_time", 0L);
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      return 100;
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new ujm(this).execute(new Void[0]);
    return 100;
  }
  
  /* Error */
  private android.content.Intent a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: iload_3
    //   5: invokevirtual 210	com/tencent/mobileqq/richstatus/StatusManager:a	(I)Lcom/tencent/mobileqq/richstatus/ActionInfo;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnonnull +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload 7
    //   19: getfield 214	com/tencent/mobileqq/richstatus/ActionInfo:jdField_j_of_type_Int	I
    //   22: tableswitch	default:+22->44, 4:+24->46, 5:+74->96
    //   44: aconst_null
    //   45: areturn
    //   46: aload 7
    //   48: getfield 216	com/tencent/mobileqq/richstatus/ActionInfo:f	Ljava/lang/String;
    //   51: ifnull -36 -> 15
    //   54: new 218	android/content/Intent
    //   57: dup
    //   58: aload_1
    //   59: ldc -36
    //   61: invokespecial 223	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   64: astore_1
    //   65: aload_1
    //   66: ldc 76
    //   68: aload_0
    //   69: aload 7
    //   71: getfield 216	com/tencent/mobileqq/richstatus/ActionInfo:f	Ljava/lang/String;
    //   74: iload_3
    //   75: iload 4
    //   77: aload 5
    //   79: invokevirtual 226	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 230	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   85: pop
    //   86: aload_1
    //   87: ldc -24
    //   89: aload_2
    //   90: invokevirtual 230	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_1
    //   95: areturn
    //   96: aload 7
    //   98: aload 7
    //   100: getfield 234	com/tencent/mobileqq/richstatus/ActionInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   103: ldc -20
    //   105: ldc -18
    //   107: invokevirtual 244	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   110: putfield 234	com/tencent/mobileqq/richstatus/ActionInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   113: new 218	android/content/Intent
    //   116: dup
    //   117: aload_1
    //   118: aload 7
    //   120: getfield 234	com/tencent/mobileqq/richstatus/ActionInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   123: invokestatic 250	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   126: invokespecial 223	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   129: astore_1
    //   130: aload 7
    //   132: getfield 252	com/tencent/mobileqq/richstatus/ActionInfo:k	Ljava/lang/String;
    //   135: ifnull +24 -> 159
    //   138: aload_1
    //   139: ldc 76
    //   141: aload_0
    //   142: aload 7
    //   144: getfield 252	com/tencent/mobileqq/richstatus/ActionInfo:k	Ljava/lang/String;
    //   147: iload_3
    //   148: iload 4
    //   150: aload 5
    //   152: invokevirtual 226	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 230	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   158: pop
    //   159: aload_1
    //   160: areturn
    //   161: astore_2
    //   162: aload 6
    //   164: astore_1
    //   165: aload_2
    //   166: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   169: aload_1
    //   170: areturn
    //   171: astore_2
    //   172: goto -7 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	StatusManager
    //   0	175	1	paramBaseActivity	BaseActivity
    //   0	175	2	paramString1	String
    //   0	175	3	paramInt1	int
    //   0	175	4	paramInt2	int
    //   0	175	5	paramString2	String
    //   1	162	6	localObject	Object
    //   8	135	7	localActionInfo	ActionInfo
    // Exception table:
    //   from	to	target	type
    //   96	130	161	java/lang/Exception
    //   130	159	171	java/lang/Exception
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("rich_status", 0);
  }
  
  public static StatusManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (StatusManager localStatusManager1 = (StatusManager)jdField_a_of_type_JavaLangRefWeakReference.get();; localStatusManager1 = null)
    {
      StatusManager localStatusManager2;
      if (localStatusManager1 == null)
      {
        localStatusManager2 = new StatusManager(paramQQAppInterface);
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localStatusManager2);
      }
      for (;;)
      {
        localStatusManager2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        return localStatusManager2;
        localStatusManager1.jdField_a_of_type_JavaUtilHashSet.clear();
        localStatusManager1.h = 0L;
        localStatusManager1.g = 0L;
        localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        if (localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
        {
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
        }
        if (localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver != null)
        {
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = null;
        }
        localStatusManager2 = localStatusManager1;
        if (localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder != null)
        {
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a();
          localStatusManager2 = localStatusManager1;
        }
      }
    }
  }
  
  private boolean a(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    int i1 = 0;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons(" + paramSparseArray1 + ", " + paramSparseArray2 + ")");
    }
    File localFile = BitmapDecoder.a();
    boolean bool1;
    if (localFile == null)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir is null");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir does not exist!");
            }
            return true;
          }
          if (localFile.canWrite()) {
            break;
          }
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir can not write!");
        return false;
        if (paramSparseArray1 != null) {
          break;
        }
        paramSparseArray1 = localFile.listFiles();
        i2 = paramSparseArray1.length;
        if (i1 < i2)
        {
          paramSparseArray2 = paramSparseArray1[i1];
          if (paramSparseArray2 == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
          }
        }
        bool2 = localFile.canWrite();
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
      return bool2;
      ArrayList localArrayList = new ArrayList();
      int i2 = paramSparseArray2.size();
      i1 = 0;
      while (i1 < i2)
      {
        ActionInfo localActionInfo1 = (ActionInfo)paramSparseArray2.valueAt(i1);
        ActionInfo localActionInfo2 = (ActionInfo)paramSparseArray1.get(localActionInfo1.i);
        if ((localActionInfo2 != null) && (localActionInfo2.jdField_a_of_type_JavaLangString != null) && (!localActionInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localActionInfo1.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localActionInfo2.i + "_s_" + 201);
        }
        if ((localActionInfo2 != null) && (localActionInfo2.b != null) && (!localActionInfo2.b.equalsIgnoreCase(localActionInfo1.b))) {
          localArrayList.add(localActionInfo2.i + "_s_" + 200);
        }
        i1 += 1;
      }
      paramSparseArray1 = localArrayList.iterator();
      while (paramSparseArray1.hasNext())
      {
        paramSparseArray2 = new File(localFile, (String)paramSparseArray1.next());
        if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
      }
      bool2 = localFile.canWrite();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
    return bool2;
  }
  
  private Object[] a(InputStream paramInputStream)
  {
    int i2 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "parseXmlFile(" + paramInputStream + ")");
    }
    Object[] arrayOfObject = new Object[2];
    if (paramInputStream == null) {
      return arrayOfObject;
    }
    Object localObject2 = new StatusXmlHandler();
    for (;;)
    {
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, (DefaultHandler)localObject2);
        SparseArray localSparseArray = ((StatusXmlHandler)localObject2).a();
        localObject2 = ((StatusXmlHandler)localObject2).a();
        if (localSparseArray.size() > 1) {
          arrayOfObject[0] = localSparseArray;
        }
        if (((ArrayList)localObject2).size() > 0) {
          arrayOfObject[1] = localObject2;
        }
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        localParserConfigurationException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (SAXException localSAXException)
      {
        localSAXException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw ((Throwable)localObject1);
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          continue;
        }
        int i1 = -1;
        continue;
      }
      try
      {
        paramInputStream.close();
        if (QLog.isColorLevel())
        {
          paramInputStream = new StringBuilder().append("parseXmlFile return, action num: ");
          if (arrayOfObject[0] != null)
          {
            i1 = ((SparseArray)arrayOfObject[0]).size();
            paramInputStream = paramInputStream.append(i1).append(" tag num: ");
            i1 = i2;
            if (arrayOfObject[1] != null) {
              i1 = ((ArrayList)arrayOfObject[1]).size();
            }
            QLog.d("Q.richstatus.xml", 2, i1);
          }
        }
        else
        {
          return arrayOfObject;
        }
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private int b()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Remote:" + l1 + ", " + this.h + ", " + "rich_status_android");
    }
    if (Math.abs(l1 - this.h) > 240000L)
    {
      ConfigHandler localConfigHandler = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
      if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver == null) {
        c();
      }
      localConfigHandler.a(null, new GetResourceReqInfo[] { localConfigHandler.e() });
      this.h = l1;
    }
    return 100;
  }
  
  private int b(boolean paramBoolean)
  {
    int i1 = 101;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      i1 = 102;
    }
    long l1;
    do
    {
      return i1;
      l1 = System.currentTimeMillis();
      if (Math.abs(this.i - l1) <= 43200000L) {
        break;
      }
    } while (!paramBoolean);
    if (Math.abs(this.j - l1) > 300000L)
    {
      this.j = l1;
      return 101;
    }
    return 100;
  }
  
  private SharedPreferences b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("rich_status" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
  }
  
  private void b(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    b().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l1).commit();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new ujn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  private boolean c()
  {
    int i1 = b(true);
    if (i1 != 100)
    {
      a(i1);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new ujo(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 102) {
      return a();
    }
    if (paramInt == 101) {
      return b();
    }
    return -1;
  }
  
  public int a(int paramInt, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("list is null!");
    }
    paramArrayList.clear();
    Object localObject = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {}
    for (localObject = ((ActionInfo)localObject).jdField_a_of_type_JavaUtilArrayList;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramArrayList.add((ActionInfo)((Iterator)localObject).next());
        }
      }
      return b(false);
    }
  }
  
  public int a(RichStatus paramRichStatus, int paramInt)
  {
    if (paramRichStatus == null) {}
    for (;;)
    {
      return 100;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.set", 2, "changeStatus " + paramRichStatus.actionId + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if (paramRichStatus.isEmpty()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramRichStatus = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), StatusServlet.class);
          paramRichStatus.putExtra("k_cmd", 8);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRichStatus);
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null)
      {
        d();
        return 100;
        byte[] arrayOfByte = paramRichStatus.encode();
        NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), StatusServlet.class);
        localNewIntent.putExtra("k_cmd", 9);
        localNewIntent.putExtra("k_tpl_id", paramRichStatus.tplId);
        localNewIntent.putExtra("k_sign_len", arrayOfByte.length);
        localNewIntent.putExtra("k_sign_data", arrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
  
  public int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("array list is null");
    }
    paramArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      paramArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    return b(false);
  }
  
  public int a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "setSyncShuoShuo " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
      d();
    }
    StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    return 100;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "getStatusMates " + paramBoolean + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    }
    if (paramBoolean)
    {
      this.q = paramInt1;
      this.r = paramInt2;
      this.s = paramInt3;
      this.jdField_b_of_type_JavaUtilArrayList = null;
      if ((this.jdField_c_of_type_JavaUtilArrayList == null) && (this.jdField_b_of_type_AndroidOsAsyncTask == null))
      {
        this.jdField_b_of_type_AndroidOsAsyncTask = new ujr(this);
        this.jdField_b_of_type_AndroidOsAsyncTask.execute(new Void[0]);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
      d();
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (;;)
    {
      StatusServlet.a(localQQAppInterface, paramBoolean, paramInt1, paramInt2, paramInt3, paramString, arrayOfByte);
      return 100;
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  public long a()
  {
    return a().getLong("k_version", 0L);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    localObject7 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder = new BitmapDecoder("StatusIcon_", this);
    }
    localObject3 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    Object localObject5 = paramInt1 + "_s_" + paramInt2;
    Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
    Object localObject1;
    if (localObject3 != null) {
      if (paramInt2 == 201)
      {
        localObject1 = ((ActionInfo)localObject3).jdField_a_of_type_JavaLangString;
        localObject6 = ((BitmapDecoder)localObject6).a((String)localObject5, null, (String)localObject1);
        if ((localObject3 == null) && (c()) && (localObject6 == null)) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject5);
        }
        if (paramInt2 != 201) {
          break label256;
        }
      }
    }
    try
    {
      if (BaseApplicationImpl.a != null)
      {
        localObject5 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultBig");
        localObject1 = localObject5;
        localObject3 = localObject7;
        if (localObject5 == null) {
          localObject1 = localObject5;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        label208:
        label256:
        localObject2 = null;
        localObject3 = localObject7;
      }
    }
    try
    {
      localObject5 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130842866);
      localObject1 = localObject5;
      BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localObject5, (byte)0);
      localObject3 = localObject7;
      localObject1 = localObject5;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject4 = localObject7;
      break label208;
      localObject2 = null;
      break label208;
      localObject2 = null;
      localObject4 = localObject7;
      break label208;
    }
    if (localObject6 != null) {
      localObject1 = localObject6;
    }
    while (paramInt2 == 201)
    {
      return (Bitmap)localObject1;
      localObject1 = ((ActionInfo)localObject3).b;
      break;
      localObject1 = null;
      break;
      localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130842866);
      localObject3 = localObject7;
      break label208;
      if (paramInt2 != 200) {
        break label381;
      }
      if (BaseApplicationImpl.a != null)
      {
        localObject3 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultSmall");
        if (localObject3 != null) {
          break label376;
        }
        localObject3 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130842868);
        BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localObject3, (byte)0);
        localObject1 = null;
        break label208;
      }
      localObject3 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130842868);
      localObject1 = null;
      break label208;
    }
    return (Bitmap)localObject3;
  }
  
  public ActionInfo a(int paramInt)
  {
    ActionInfo localActionInfo = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localActionInfo == null) {
      c();
    }
    return localActionInfo;
  }
  
  public RichStatus a()
  {
    return a(true);
  }
  
  public RichStatus a(boolean paramBoolean)
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      return (RichStatus)localObject2;
    }
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject1 != null)
    {
      localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean);
      if (localObject1 == null) {}
    }
    for (localObject1 = ((ExtensionInfo)localObject1).getRichStatus();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return new RichStatus(null);
    }
  }
  
  public String a()
  {
    Object localObject = a();
    if (((RichStatus)localObject).actionId == 14)
    {
      localObject = a(((RichStatus)localObject).actionId);
      if (localObject != null) {
        return ((ActionInfo)localObject).c;
      }
      return "听音乐";
    }
    StringBuilder localStringBuilder = new StringBuilder().append(((RichStatus)localObject).actionText);
    if (TextUtils.isEmpty(((RichStatus)localObject).dataText)) {}
    for (localObject = "";; localObject = ((RichStatus)localObject).dataText) {
      return (String)localObject;
    }
  }
  
  public String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return paramString1.replace("$I", Integer.toString(paramInt1)).replace("$U", Integer.toString(paramInt2)).replace("$A", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).replace("$N", paramString2);
  }
  
  /* Error */
  public ArrayList a()
  {
    // Byte code:
    //   0: new 147	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 148	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 152	com/tencent/mobileqq/richstatus/StatusManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: bipush 50
    //   14: invokevirtual 687	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   17: checkcast 689	com/tencent/mobileqq/app/FriendsManager
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +250 -> 274
    //   27: invokestatic 478	java/lang/System:currentTimeMillis	()J
    //   30: ldc2_w 723
    //   33: ldiv
    //   34: lstore 10
    //   36: aload_0
    //   37: getfield 623	com/tencent/mobileqq/richstatus/StatusManager:r	I
    //   40: istore 9
    //   42: aload_0
    //   43: getfield 625	com/tencent/mobileqq/richstatus/StatusManager:s	I
    //   46: i2l
    //   47: lstore 12
    //   49: aload_0
    //   50: getfield 152	com/tencent/mobileqq/richstatus/StatusManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 512	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnonnull +520 -> 578
    //   61: ldc_w 717
    //   64: astore_1
    //   65: aload 5
    //   67: invokevirtual 726	com/tencent/mobileqq/app/FriendsManager:c	()Ljava/util/ArrayList;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +202 -> 274
    //   75: aload_2
    //   76: invokeinterface 729 1 0
    //   81: ifle +193 -> 274
    //   84: aload_2
    //   85: invokeinterface 730 1 0
    //   90: astore_2
    //   91: aload_2
    //   92: invokeinterface 409 1 0
    //   97: ifeq +177 -> 274
    //   100: aload_2
    //   101: invokeinterface 412 1 0
    //   106: checkcast 732	com/tencent/mobileqq/persistence/Entity
    //   109: checkcast 734	com/tencent/mobileqq/data/Friends
    //   112: astore 4
    //   114: aload 5
    //   116: aload 4
    //   118: getfield 737	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   121: invokevirtual 740	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   124: astore 6
    //   126: aload 6
    //   128: ifnull -37 -> 91
    //   131: aload_1
    //   132: aload 4
    //   134: getfield 737	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   137: invokevirtual 743	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne -49 -> 91
    //   143: lload 10
    //   145: aload 6
    //   147: getfield 746	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   150: lsub
    //   151: ldc2_w 747
    //   154: lcmp
    //   155: ifge -64 -> 91
    //   158: aload 6
    //   160: invokevirtual 697	com/tencent/mobileqq/data/ExtensionInfo:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   163: astore 7
    //   165: iload 9
    //   167: aload 7
    //   169: getfield 571	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   172: if_icmpne -81 -> 91
    //   175: lload 12
    //   177: aload 7
    //   179: getfield 751	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   182: i2l
    //   183: lcmp
    //   184: ifeq +10 -> 194
    //   187: iload 9
    //   189: bipush 14
    //   191: if_icmpne -100 -> 91
    //   194: new 753	PersonalState/UserProfile
    //   197: dup
    //   198: invokespecial 754	PersonalState/UserProfile:<init>	()V
    //   201: astore 8
    //   203: aload 8
    //   205: aload 4
    //   207: getfield 737	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   210: invokestatic 760	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: putfield 763	PersonalState/UserProfile:lEctID	J
    //   216: aload 8
    //   218: aload 4
    //   220: invokestatic 768	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/Friends;)Ljava/lang/String;
    //   223: putfield 771	PersonalState/UserProfile:strNick	Ljava/lang/String;
    //   226: aload 8
    //   228: aload 4
    //   230: getfield 775	com/tencent/mobileqq/data/Friends:status	B
    //   233: i2l
    //   234: putfield 778	PersonalState/UserProfile:nStatus	J
    //   237: aload 8
    //   239: aload 4
    //   241: getfield 782	com/tencent/mobileqq/data/Friends:faceid	S
    //   244: putfield 785	PersonalState/UserProfile:wFace	S
    //   247: aload 8
    //   249: aload 7
    //   251: putfield 788	PersonalState/UserProfile:rs	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   254: aload 8
    //   256: aload 6
    //   258: getfield 746	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   261: putfield 789	PersonalState/UserProfile:richTime	J
    //   264: aload_3
    //   265: aload 8
    //   267: invokevirtual 398	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   270: pop
    //   271: goto -180 -> 91
    //   274: aload_3
    //   275: invokevirtual 460	java/util/ArrayList:size	()I
    //   278: ifle +159 -> 437
    //   281: aload_0
    //   282: getfield 152	com/tencent/mobileqq/richstatus/StatusManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   285: invokevirtual 792	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   288: invokevirtual 798	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   291: astore 4
    //   293: aconst_null
    //   294: astore_1
    //   295: aload 4
    //   297: invokevirtual 803	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   300: astore_2
    //   301: aload_2
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 806	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   307: aload_3
    //   308: invokevirtual 404	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   311: astore_2
    //   312: aload_2
    //   313: invokeinterface 409 1 0
    //   318: ifeq +217 -> 535
    //   321: aload_2
    //   322: invokeinterface 412 1 0
    //   327: checkcast 753	PersonalState/UserProfile
    //   330: astore 6
    //   332: aload 5
    //   334: aload 6
    //   336: getfield 763	PersonalState/UserProfile:lEctID	J
    //   339: invokestatic 809	java/lang/Long:toString	(J)Ljava/lang/String;
    //   342: invokevirtual 812	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   345: astore 7
    //   347: aload 7
    //   349: ifnull +177 -> 526
    //   352: aload 6
    //   354: aload 7
    //   356: getfield 817	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   359: i2l
    //   360: putfield 820	PersonalState/UserProfile:nPicNum	J
    //   363: aload 6
    //   365: aload 7
    //   367: getfield 823	com/tencent/mobileqq/data/Card:age	B
    //   370: putfield 826	PersonalState/UserProfile:bAge	B
    //   373: aload 7
    //   375: getfield 829	com/tencent/mobileqq/data/Card:shGender	S
    //   378: ifne +96 -> 474
    //   381: aload 6
    //   383: iconst_0
    //   384: putfield 832	PersonalState/UserProfile:bSex	B
    //   387: goto -75 -> 312
    //   390: astore_2
    //   391: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +13 -> 407
    //   397: ldc 17
    //   399: iconst_2
    //   400: aload_2
    //   401: invokevirtual 835	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   404: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload_1
    //   408: ifnull +7 -> 415
    //   411: aload_1
    //   412: invokevirtual 837	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   415: aload 4
    //   417: ifnull +8 -> 425
    //   420: aload 4
    //   422: invokevirtual 838	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   425: aload_3
    //   426: new 840	ujs
    //   429: dup
    //   430: aload_0
    //   431: invokespecial 841	ujs:<init>	(Lcom/tencent/mobileqq/richstatus/StatusManager;)V
    //   434: invokestatic 847	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   437: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +32 -> 472
    //   443: ldc 51
    //   445: iconst_2
    //   446: new 327	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 849
    //   456: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_3
    //   460: invokevirtual 460	java/util/ArrayList:size	()I
    //   463: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload_3
    //   473: areturn
    //   474: aload 7
    //   476: getfield 829	com/tencent/mobileqq/data/Card:shGender	S
    //   479: iconst_1
    //   480: if_icmpne +37 -> 517
    //   483: aload 6
    //   485: iconst_1
    //   486: putfield 832	PersonalState/UserProfile:bSex	B
    //   489: goto -177 -> 312
    //   492: astore_3
    //   493: aload_1
    //   494: astore_2
    //   495: aload_3
    //   496: astore_1
    //   497: aload_2
    //   498: ifnull +7 -> 505
    //   501: aload_2
    //   502: invokevirtual 837	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   505: aload 4
    //   507: ifnull +8 -> 515
    //   510: aload 4
    //   512: invokevirtual 838	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   515: aload_1
    //   516: athrow
    //   517: aload 6
    //   519: iconst_2
    //   520: putfield 832	PersonalState/UserProfile:bSex	B
    //   523: goto -211 -> 312
    //   526: aload 6
    //   528: iconst_2
    //   529: putfield 832	PersonalState/UserProfile:bSex	B
    //   532: goto -220 -> 312
    //   535: aload_1
    //   536: invokevirtual 850	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   539: aload_1
    //   540: ifnull +7 -> 547
    //   543: aload_1
    //   544: invokevirtual 837	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   547: aload 4
    //   549: ifnull -124 -> 425
    //   552: aload 4
    //   554: invokevirtual 838	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   557: goto -132 -> 425
    //   560: astore_1
    //   561: aconst_null
    //   562: astore_2
    //   563: goto -66 -> 497
    //   566: astore_3
    //   567: aload_1
    //   568: astore_2
    //   569: aload_3
    //   570: astore_1
    //   571: goto -74 -> 497
    //   574: astore_2
    //   575: goto -184 -> 391
    //   578: goto -513 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	StatusManager
    //   56	488	1	localObject1	Object
    //   560	8	1	localObject2	Object
    //   570	1	1	localObject3	Object
    //   70	252	2	localObject4	Object
    //   390	11	2	localException1	Exception
    //   494	75	2	localObject5	Object
    //   574	1	2	localException2	Exception
    //   7	466	3	localArrayList	ArrayList
    //   492	4	3	localObject6	Object
    //   566	4	3	localObject7	Object
    //   112	441	4	localObject8	Object
    //   20	313	5	localFriendsManager	FriendsManager
    //   124	403	6	localObject9	Object
    //   163	312	7	localObject10	Object
    //   201	65	8	localUserProfile	UserProfile
    //   40	152	9	i1	int
    //   34	110	10	l1	long
    //   47	129	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   303	312	390	java/lang/Exception
    //   312	347	390	java/lang/Exception
    //   352	387	390	java/lang/Exception
    //   474	489	390	java/lang/Exception
    //   517	523	390	java/lang/Exception
    //   526	532	390	java/lang/Exception
    //   535	539	390	java/lang/Exception
    //   303	312	492	finally
    //   312	347	492	finally
    //   352	387	492	finally
    //   474	489	492	finally
    //   517	523	492	finally
    //   526	532	492	finally
    //   535	539	492	finally
    //   295	301	560	finally
    //   391	407	566	finally
    //   295	301	574	java/lang/Exception
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i2 = paramArrayList.size();
    Object localObject;
    if ((localHashMap != null) && (localHashMap.size() > 0) && (i2 > 0))
    {
      i1 = i2 - 1;
      while (i1 > -1)
      {
        localObject = (UserProfile)paramArrayList.get(i1);
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject).lEctID));
        if (localUserProfile != null)
        {
          localUserProfile.bAge = ((UserProfile)localObject).bAge;
          localUserProfile.bSex = ((UserProfile)localObject).bSex;
          localUserProfile.strDesc = ((UserProfile)localObject).strDesc;
          paramArrayList.remove(i1);
        }
        i1 -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("filterFriends ").append(i2).append(" - ");
      if (localHashMap == null) {
        break label184;
      }
    }
    label184:
    for (int i1 = localHashMap.size();; i1 = -1)
    {
      QLog.d("Q.richstatus.mate", 2, i1 + "=" + paramArrayList.size());
      return paramArrayList;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1)
    {
      localArrayList.addAll(paramArrayList1);
      localObject1 = paramArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject1 = paramArrayList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      if (((UserProfile)localObject2).bSex == paramInt)
      {
        localArrayList.add(localObject2);
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject2 = Long.valueOf(0L);
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject1 = Long.valueOf(l1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.richstatus.xml", 2, localException.toString());
          localObject1 = localObject2;
          continue;
          localException.bAge = ((UserProfile)localObject2).bAge;
          localException.bSex = ((UserProfile)localObject2).bSex;
          localException.strDesc = ((UserProfile)localObject2).strDesc;
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      if (!QLog.isColorLevel()) {
        break label384;
      }
      QLog.d("Q.richstatus.mate", 2, "mergeFriendsStrangers " + paramArrayList1.size() + " " + paramArrayList2.size() + " " + paramInt + "=" + localArrayList.size());
    }
    localHashMap.put(localObject1, new UserProfile());
    localObject1 = paramArrayList2.iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label306;
      }
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject2).lEctID));
      if (localUserProfile != null) {
        break;
      }
      localArrayList.add(localObject2);
    }
    label306:
    label384:
    return localArrayList;
  }
  
  public void a()
  {
    StatusServlet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    label79:
    label116:
    label217:
    label243:
    label269:
    label293:
    label295:
    do
    {
      for (;;)
      {
        return;
        if ((paramObject instanceof IIconListener))
        {
          if (this.jdField_a_of_type_JavaUtilLinkedList == null)
          {
            this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
            this.jdField_a_of_type_JavaUtilLinkedList.add((IIconListener)paramObject);
          }
        }
        else
        {
          if ((paramObject instanceof IActionListener))
          {
            if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
              break label217;
            }
            this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
            this.jdField_b_of_type_JavaUtilLinkedList.add((IActionListener)paramObject);
          }
          if ((paramObject instanceof IImageListener))
          {
            if (this.jdField_c_of_type_JavaUtilLinkedList != null) {
              break label243;
            }
            this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
            this.jdField_c_of_type_JavaUtilLinkedList.add((IImageListener)paramObject);
          }
          if ((paramObject instanceof IStatusListener))
          {
            if (this.d != null) {
              break label269;
            }
            this.d = new LinkedList();
            this.d.add((IStatusListener)paramObject);
          }
        }
        for (;;)
        {
          if (!(paramObject instanceof ISameStatusListener)) {
            break label293;
          }
          if (this.e != null) {
            break label295;
          }
          this.e = new LinkedList();
          this.e.add((ISameStatusListener)paramObject);
          return;
          if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.add((IIconListener)paramObject);
          break;
          if (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject)) {
            break label79;
          }
          this.jdField_b_of_type_JavaUtilLinkedList.add((IActionListener)paramObject);
          break label79;
          if (this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject)) {
            break label116;
          }
          this.jdField_c_of_type_JavaUtilLinkedList.add((IImageListener)paramObject);
          break label116;
          if (!this.d.contains(paramObject)) {
            this.d.add((IStatusListener)paramObject);
          }
        }
      }
    } while (this.e.contains(paramObject));
    this.e.add((ISameStatusListener)paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "sp_hot_status", paramString).commit();
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    if ((paramString2 == null) && (paramBitmap != null)) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString1);
    }
    paramString1 = paramString1.split("_");
    int i1;
    if (paramString1.length == 3)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        paramInt = Integer.parseInt(paramString1[0]);
        i1 = Integer.parseInt(paramString1[2]);
        paramString1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (paramString1.hasNext()) {
          ((IIconListener)paramString1.next()).a(paramInt, i1, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.jdField_c_of_type_JavaUtilLinkedList != null))
    {
      i1 = Integer.parseInt(paramString1[0]);
      int i2 = Integer.parseInt(paramString1[1]);
      paramString1 = this.jdField_c_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((IImageListener)paramString1.next()).a(i1, i2, paramBitmap, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)) && ((this.jdField_c_of_type_JavaUtilLinkedList == null) || (this.jdField_c_of_type_JavaUtilLinkedList.size() == 0)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    label50:
    String str;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localObject1 = str.split("_");
        localObject2 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null) {
          if (localObject1.length == 3) {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((ActionInfo)localObject2).jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(str, null, (String)localObject1);
        if (localObject2 == null) {
          break label50;
        }
        a(str, (String)localObject1, (Bitmap)localObject2, 1);
        break label50;
        localObject1 = ((ActionInfo)localObject2).b;
        continue;
        if ((localObject1.length != 2) || (TextUtils.isEmpty(((ActionInfo)localObject2).g))) {
          break label224;
        }
        localObject1 = ((ActionInfo)localObject2).g.replace("$U", localObject1[1]);
        continue;
      }
      localIterator.remove();
      break label50;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      return;
      label224:
      localObject1 = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null;
  }
  
  public boolean a(long paramLong)
  {
    long l2 = a().getLong("k_version", 104L);
    long l1 = l2;
    if (l2 < 104L) {
      l1 = 104L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "StatusManager.isNewVersion(): localVersion " + l1 + " serverVersion " + paramLong + ", builtInVersion " + 104L);
    }
    return paramLong > l1;
  }
  
  public boolean a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return false;
      paramString1 = a(paramBaseActivity, paramString1, paramInt1, paramInt2, paramString2);
    } while (paramString1 == null);
    paramBaseActivity.startActivity(paramString1);
    return true;
  }
  
  public boolean a(File paramFile, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "saveActions(" + paramFile + ", " + paramLong + ")");
    }
    for (;;)
    {
      try
      {
        Object localObject1 = a(new FileInputStream(paramFile));
        ??? = (SparseArray)localObject1[0];
        ArrayList localArrayList = (ArrayList)localObject1[1];
        if ((??? != null) && (((SparseArray)???).size() > 0) && (localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
            if (localAsyncTask != null) {
              localAsyncTask.cancel(true);
            }
            this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)???);
            if ((localArrayList == null) || (localArrayList.size() <= 0)) {}
          }
        }
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (FileNotFoundException paramFile)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          this.i = System.currentTimeMillis();
          ??? = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getFilesDir(), "rich_status.xml");
          if ((paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)))
          {
            paramFile = a().edit();
            paramFile.putLong("k_version", paramLong).putLong("k_update_time", this.i).commit();
            if (a((SparseArray)localObject1, this.jdField_a_of_type_AndroidUtilSparseArray)) {
              paramFile.putLong("k_icon", paramLong).commit();
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "saveActions return with " + bool);
            }
            return bool;
            paramFile = finally;
            throw paramFile;
            paramFile = paramFile;
            paramFile.printStackTrace();
            bool = false;
          }
        }
      }
      QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
    }
  }
  
  public Object[] a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder = new BitmapDecoder("StatusIcon_", this);
    }
    Object localObject3 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    String str2 = paramInt1 + "_" + paramInt2;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(str2);
    String str1;
    if (localObject1 == null)
    {
      if ((localObject3 == null) && (c())) {
        this.jdField_a_of_type_JavaUtilHashSet.add(str2);
      }
      if ((localObject3 != null) && (((ActionInfo)localObject3).g != null))
      {
        localObject1 = ((ActionInfo)localObject3).g.replace("$U", Integer.toString(paramInt2)).replace("$D", Integer.toString(paramInt2 % 100)).replace("$T", Integer.toString(paramInt2 % 1000));
        str1 = paramInt1 + "_s_" + 201;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(str1);
        BitmapDecoder localBitmapDecoder = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
        if (localObject3 != null)
        {
          label201:
          localBitmapDecoder.a(str2, (String)localObject2, (String)localObject1);
          if (localObject3 != null) {
            break label324;
          }
          if (BaseApplicationImpl.a == null) {
            break label297;
          }
          localObject1 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultBig");
          if (localObject1 != null) {
            break label319;
          }
          localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130842866);
          BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localObject1, (byte)0);
          paramInt1 = 0;
        }
      }
    }
    for (;;)
    {
      jdField_a_of_type_ArrayOfJavaLangObject[0] = localObject1;
      jdField_a_of_type_ArrayOfJavaLangObject[1] = Integer.valueOf(paramInt1);
      return jdField_a_of_type_ArrayOfJavaLangObject;
      localObject2 = str1;
      break label201;
      label297:
      localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130842866);
      paramInt1 = 0;
      continue;
      label319:
      paramInt1 = 0;
      continue;
      label324:
      localObject1 = localObject3;
      paramInt1 = 0;
      continue;
      localObject1 = null;
      break;
      paramInt1 = 1;
    }
  }
  
  public Bitmap b(int paramInt1, int paramInt2)
  {
    return (Bitmap)a(paramInt1, paramInt2)[0];
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "clearSameFriends");
    }
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    if (this.jdField_b_of_type_AndroidOsAsyncTask != null)
    {
      this.jdField_b_of_type_AndroidOsAsyncTask.cancel(true);
      this.jdField_b_of_type_AndroidOsAsyncTask = null;
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (((paramObject instanceof IIconListener)) && (this.jdField_a_of_type_JavaUtilLinkedList != null)) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof IActionListener)) && (this.jdField_b_of_type_JavaUtilLinkedList != null)) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof IImageListener)) && (this.jdField_c_of_type_JavaUtilLinkedList != null)) {
        this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof IStatusListener)) && (this.d != null)) {
        this.d.remove(paramObject);
      }
    } while ((!(paramObject instanceof ISameStatusListener)) || (this.e == null));
    this.e.remove(paramObject);
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = b();
    boolean bool = localSharedPreferences.getBoolean("k_sync_ss", false);
    long l1 = System.currentTimeMillis();
    if ((Math.abs(l1 - this.g) > 180000L) && (Math.abs(l1 - localSharedPreferences.getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
        d();
      }
      this.g = l1;
      StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo " + bool);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\StatusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */