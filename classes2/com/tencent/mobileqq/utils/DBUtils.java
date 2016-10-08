package com.tencent.mobileqq.utils;

import GeneralSettings.Setting;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import waf;
import wag;

public class DBUtils
{
  public static final String a = "troop_photo_new";
  public static final String b = "troop_photo_message";
  public static final String c = "troop_file_new";
  public static final String d = "troop_notification_new";
  public static final String e = "group_activity_new_message";
  private static final String f = "DBUtils";
  private static final String g = "troop_news_notify";
  
  private DBUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("troop_news_notify", i).getInt(paramString1 + paramString2 + paramString3, 0);
    }
  }
  
  public static DBUtils a()
  {
    return wag.a;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("troop_news_notify", i).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + paramString2 + paramString3, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("subaccount_sp", 0).getInt("subaccount_sp_version", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountVersion() ver=" + i);
    }
    return i;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label22;
      }
      i = j;
    }
    label22:
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return i;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
        i = j;
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      j = localSharedPreferences.getInt(paramString, 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, paramString + ":" + j);
    return j;
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramString == null) {
      return 0;
    }
    paramString = "message.group.policy_pc." + paramString;
    return ((RoamSettingManager)paramQQAppInterface.getManager(39)).a(paramString, 0);
  }
  
  public TroopMemberCardInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString1 = (TroopMemberCardInfo)paramQQAppInterface.a(TroopMemberCardInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  public TroopMemberInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString1 = (TroopMemberInfo)paramQQAppInterface.a(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  /* Error */
  public ArrayList a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_3
    //   5: ifnull +10 -> 15
    //   8: aload_3
    //   9: invokevirtual 174	java/util/ArrayList:size	()I
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 171	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 175	java/util/ArrayList:<init>	()V
    //   24: astore 6
    //   26: aload_1
    //   27: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   30: invokevirtual 153	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 178	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore 5
    //   42: aload 5
    //   44: invokevirtual 181	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   47: iconst_0
    //   48: istore 8
    //   50: iload 8
    //   52: aload_3
    //   53: invokevirtual 174	java/util/ArrayList:size	()I
    //   56: if_icmpge +249 -> 305
    //   59: aload_3
    //   60: iload 8
    //   62: invokevirtual 185	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 187	friendlist/stUinInfo
    //   68: astore 7
    //   70: aload 4
    //   72: ldc -101
    //   74: iconst_2
    //   75: anewarray 120	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 7
    //   86: getfield 191	friendlist/stUinInfo:dwuin	J
    //   89: invokestatic 195	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   92: aastore
    //   93: invokevirtual 160	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   96: checkcast 155	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +164 -> 265
    //   104: iconst_1
    //   105: istore 9
    //   107: aload_1
    //   108: aload 7
    //   110: getfield 191	friendlist/stUinInfo:dwuin	J
    //   113: invokestatic 195	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   116: putfield 198	com/tencent/mobileqq/data/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   119: aload_1
    //   120: aload_2
    //   121: putfield 201	com/tencent/mobileqq/data/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   124: aload 7
    //   126: getfield 204	friendlist/stUinInfo:dwFlag	J
    //   129: lconst_1
    //   130: land
    //   131: lconst_0
    //   132: lcmp
    //   133: ifeq +12 -> 145
    //   136: aload_1
    //   137: aload 7
    //   139: getfield 207	friendlist/stUinInfo:sName	Ljava/lang/String;
    //   142: putfield 210	com/tencent/mobileqq/data/TroopMemberCardInfo:name	Ljava/lang/String;
    //   145: aload 7
    //   147: getfield 204	friendlist/stUinInfo:dwFlag	J
    //   150: ldc2_w 211
    //   153: land
    //   154: lconst_0
    //   155: lcmp
    //   156: ifeq +12 -> 168
    //   159: aload_1
    //   160: aload 7
    //   162: getfield 216	friendlist/stUinInfo:cGender	B
    //   165: putfield 219	com/tencent/mobileqq/data/TroopMemberCardInfo:sex	B
    //   168: aload 7
    //   170: getfield 204	friendlist/stUinInfo:dwFlag	J
    //   173: ldc2_w 220
    //   176: land
    //   177: lconst_0
    //   178: lcmp
    //   179: ifeq +12 -> 191
    //   182: aload_1
    //   183: aload 7
    //   185: getfield 224	friendlist/stUinInfo:sPhone	Ljava/lang/String;
    //   188: putfield 227	com/tencent/mobileqq/data/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   191: aload 7
    //   193: getfield 204	friendlist/stUinInfo:dwFlag	J
    //   196: ldc2_w 228
    //   199: land
    //   200: lconst_0
    //   201: lcmp
    //   202: ifeq +12 -> 214
    //   205: aload_1
    //   206: aload 7
    //   208: getfield 232	friendlist/stUinInfo:sEmail	Ljava/lang/String;
    //   211: putfield 235	com/tencent/mobileqq/data/TroopMemberCardInfo:email	Ljava/lang/String;
    //   214: aload 7
    //   216: getfield 204	friendlist/stUinInfo:dwFlag	J
    //   219: ldc2_w 236
    //   222: land
    //   223: lconst_0
    //   224: lcmp
    //   225: ifeq +12 -> 237
    //   228: aload_1
    //   229: aload 7
    //   231: getfield 240	friendlist/stUinInfo:sRemark	Ljava/lang/String;
    //   234: putfield 243	com/tencent/mobileqq/data/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   237: iload 9
    //   239: ifeq +40 -> 279
    //   242: aload 4
    //   244: aload_1
    //   245: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   248: pop
    //   249: aload 6
    //   251: aload_1
    //   252: invokevirtual 250	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: iload 8
    //   258: iconst_1
    //   259: iadd
    //   260: istore 8
    //   262: goto -212 -> 50
    //   265: new 155	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   268: dup
    //   269: invokespecial 251	com/tencent/mobileqq/data/TroopMemberCardInfo:<init>	()V
    //   272: astore_1
    //   273: iconst_0
    //   274: istore 9
    //   276: goto -169 -> 107
    //   279: aload 4
    //   281: aload_1
    //   282: invokevirtual 254	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   285: goto -36 -> 249
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   293: aload 5
    //   295: invokevirtual 256	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   298: aload 4
    //   300: invokevirtual 162	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   303: aconst_null
    //   304: areturn
    //   305: aload 5
    //   307: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   310: aload 5
    //   312: invokevirtual 256	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   315: aload 4
    //   317: invokevirtual 162	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   320: aload 6
    //   322: areturn
    //   323: astore_1
    //   324: aload 5
    //   326: invokevirtual 256	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   329: aload 4
    //   331: invokevirtual 162	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	DBUtils
    //   0	336	1	paramQQAppInterface	QQAppInterface
    //   0	336	2	paramString	String
    //   0	336	3	paramArrayList	ArrayList
    //   33	297	4	localEntityManager	EntityManager
    //   40	285	5	localEntityTransaction	EntityTransaction
    //   24	297	6	localArrayList	ArrayList
    //   68	162	7	localstUinInfo	friendlist.stUinInfo
    //   48	213	8	i	int
    //   105	170	9	j	int
    // Exception table:
    //   from	to	target	type
    //   42	47	288	java/lang/Exception
    //   50	100	288	java/lang/Exception
    //   107	145	288	java/lang/Exception
    //   145	168	288	java/lang/Exception
    //   168	191	288	java/lang/Exception
    //   191	214	288	java/lang/Exception
    //   214	237	288	java/lang/Exception
    //   242	249	288	java/lang/Exception
    //   249	256	288	java/lang/Exception
    //   265	273	288	java/lang/Exception
    //   279	285	288	java/lang/Exception
    //   305	310	288	java/lang/Exception
    //   42	47	323	finally
    //   50	100	323	finally
    //   107	145	323	finally
    //   145	168	323	finally
    //   168	191	323	finally
    //   191	214	323	finally
    //   214	237	323	finally
    //   242	249	323	finally
    //   249	256	323	finally
    //   265	273	323	finally
    //   279	285	323	finally
    //   289	293	323	finally
    //   305	310	323	finally
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (localArrayList.size() == 0)) {
      return localArrayList;
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i);
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((String)localObject).split("\\.");
        if ((localObject != null) && (localObject.length != 0)) {
          localArrayList.add(localObject[(localObject.length - 1)]);
        }
      }
    }
    return localArrayList;
  }
  
  public Map a(List paramList, int paramInt, QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localHashMap;
    }
    if (paramQQAppInterface == null) {
      return localHashMap;
    }
    paramQQAppInterface = (RoamSettingManager)paramQQAppInterface.getManager(39);
    int i = 0;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        i += 1;
        break;
        StringBuilder localStringBuilder = new StringBuilder(40);
        localStringBuilder.append("message.group.policy.");
        localStringBuilder.append(str);
        localHashMap.put(str, Integer.valueOf(paramQQAppInterface.a(localStringBuilder.toString(), paramInt)));
      }
    }
    return localHashMap;
  }
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "saveGeneralSettingRevision=" + paramInt);
    }
    ((RoamSettingManager)paramQQAppInterface.getManager(39)).a(paramInt);
  }
  
  public void a(Context paramContext)
  {
    int i = ApkUtils.a(paramContext);
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putInt("subaccount_sp_version", i).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setSubAccountVersion() ver=" + i);
    }
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Context paramContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (paramString2 == null) {
      return;
    }
    paramString2 = paramContext.getSharedPreferences(paramString2, 0).edit();
    paramString1 = "message.group.policy." + paramString1;
    paramString2.remove(paramString1);
    paramString2.commit();
    ((RoamSettingManager)paramQQAppInterface.getManager(39)).a(paramString1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      paramInt += 1;
      localSharedPreferences.edit().putInt(paramString, paramInt).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "set " + paramString + "=" + paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      paramString = paramString + "bindQQAgain";
      localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "setShownAgainBindDialog() " + paramString + ":" + paramBoolean);
  }
  
  public void a(ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    long l = 0L;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      QLog.d("RoamSetting", 2, "saveGeneralSettings setting start size = " + paramArrayList.size());
    }
    RoamSettingManager localRoamSettingManager = (RoamSettingManager)paramQQAppInterface.getManager(39);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.a(), 0);
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str;
    label175:
    int j;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        paramQQAppInterface = (Setting)paramArrayList.get(i);
        str = paramQQAppInterface.Path;
        paramQQAppInterface = paramQQAppInterface.Value;
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "saveGeneralSettings path =" + str + "; value = " + paramQQAppInterface);
        }
        if (str == null)
        {
          paramQQAppInterface = (QQAppInterface)localObject;
          i += 1;
          localObject = paramQQAppInterface;
        }
        else
        {
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0) && (!paramQQAppInterface.equalsIgnoreCase(""))) {
            break label516;
          }
          j = RoamSettingController.a(str);
          if (j == 1) {
            paramQQAppInterface = String.valueOf(1);
          }
        }
      }
    }
    label225:
    label516:
    for (;;)
    {
      RoamSetting localRoamSetting = localRoamSettingManager.a(str, paramQQAppInterface);
      if (localRoamSetting != null) {
        localArrayList.add(localRoamSetting);
      }
      if (("message.ring.switch".equals(str)) || ("message.vibrate.switch".equals(str)) || ("message.ring.care".equals(str)))
      {
        if (localObject == null) {
          localObject = localSharedPreferences.edit();
        }
        for (;;)
        {
          try
          {
            ((SharedPreferences.Editor)localObject).putString(str, paramQQAppInterface);
            paramQQAppInterface = (QQAppInterface)localObject;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            paramQQAppInterface = (QQAppInterface)localObject;
          }
          break label175;
          if (j == 2)
          {
            paramQQAppInterface = String.valueOf(0);
            break label225;
          }
          if (j == 3)
          {
            paramQQAppInterface = String.valueOf(0);
            break label225;
          }
          if (j == 4)
          {
            paramQQAppInterface = "";
            break label225;
          }
          if (j == 5)
          {
            paramQQAppInterface = "";
            break label225;
          }
          if (j == 6)
          {
            paramQQAppInterface = String.valueOf(1);
            break label225;
          }
          if (j == 7)
          {
            paramQQAppInterface = String.valueOf(0);
            break label225;
          }
          paramQQAppInterface = "0";
          break label225;
          if (Looper.getMainLooper().getThread() == Thread.currentThread())
          {
            ThreadManager.a(new waf(this, localRoamSettingManager, localArrayList), 5, null, false);
            if (localObject == null) {}
          }
          try
          {
            ((SharedPreferences.Editor)localObject).commit();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("DBUtils", 2, "GeneralSettings zsw saveGeneralSettings setting end, consume time =" + (System.currentTimeMillis() - l));
            return;
            localRoamSettingManager.a(localArrayList);
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              paramArrayList.printStackTrace();
            }
          }
        }
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      break label175;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().putBoolean("hasShowBindDialog", paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setHasShowBindDialog:" + paramBoolean);
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localSharedPreferences.getBoolean("hasShowBindDialog", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "hasShowBindDialog:" + bool2);
    return bool2;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    do
    {
      return bool2;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
      paramContext = paramContext.getSharedPreferences("subaccount_sp", 0);
      paramString = paramString + "subaccount_show_in_recentlist_first";
      if (localSharedPreferences.getBoolean(paramString, false))
      {
        localSharedPreferences.edit().remove(paramString).commit();
        paramContext.edit().putBoolean(paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() update showedBefore:=true");
        }
      }
      if (localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false))
      {
        bool2 = localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false);
        localSharedPreferences.edit().remove("subaccount_is_top_in_recentlist").commit();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() remove isTopRU=" + bool2);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() isTop=" + bool1);
    return bool1;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramTroopMemberCardInfo.getStatus() == 1000)
    {
      paramQQAppInterface.b(paramTroopMemberCardInfo);
      if (paramTroopMemberCardInfo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramTroopMemberCardInfo.getStatus() != 1001) && (paramTroopMemberCardInfo.getStatus() != 1002)) {
      return bool;
    }
    return paramQQAppInterface.a(paramTroopMemberCardInfo);
  }
  
  public boolean a(String paramString)
  {
    if (((paramString == null) || (paramString.length() < 5)) && (QLog.isColorLevel())) {
      QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() return.FALSE: mainUin=" + paramString);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramString = paramString + "bindQQAgain";
      bool2 = localSharedPreferences.getBoolean(paramString, false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() " + paramString + ":" + bool2);
    return bool2;
  }
  
  public Object[] a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = null;
    arrayOfObject[1] = Boolean.valueOf(false);
    if (paramArrayList == null) {
      return arrayOfObject;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    ArrayList localArrayList = new ArrayList();
    arrayOfObject[0] = localArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayList.size()) {
          break label676;
        }
        localstTroopRemarkInfo = (stTroopRemarkInfo)paramArrayList.get(i);
        localObject1 = (TroopMemberCardInfo)localEntityManager.a(TroopMemberCardInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
        if (localObject1 == null) {
          continue;
        }
        j = 1;
        ((TroopMemberCardInfo)localObject1).email = localstTroopRemarkInfo.sEmail;
        ((TroopMemberCardInfo)localObject1).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
        ((TroopMemberCardInfo)localObject1).memo = localstTroopRemarkInfo.sMemo;
        ((TroopMemberCardInfo)localObject1).name = localstTroopRemarkInfo.sName;
        ((TroopMemberCardInfo)localObject1).nick = localstTroopRemarkInfo.strNick;
        ((TroopMemberCardInfo)localObject1).sex = localstTroopRemarkInfo.cGender;
        ((TroopMemberCardInfo)localObject1).tel = localstTroopRemarkInfo.sPhone;
        ((TroopMemberCardInfo)localObject1).troopuin = paramString;
        ((TroopMemberCardInfo)localObject1).level = localstTroopRemarkInfo.strRank;
        ((TroopMemberCardInfo)localObject1).job = localstTroopRemarkInfo.bytes_job;
        ((TroopMemberCardInfo)localObject1).charm = ((int)localstTroopRemarkInfo.GlamourLevel);
        ((TroopMemberCardInfo)localObject1).torchFlag = ((int)localstTroopRemarkInfo.TorchbearerFlag);
        if (localstTroopRemarkInfo.TorchbearerFlag != 0L) {
          ((OlympicManager)paramQQAppInterface.getManager(166)).a().a(((TroopMemberCardInfo)localObject1).memberuin, true, System.currentTimeMillis());
        }
        if (j == 0) {
          continue;
        }
        localEntityManager.a((Entity)localObject1);
        localArrayList.add(localObject1);
        localObject1 = (TroopMemberInfo)localEntityManager.a(TroopMemberInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
        if (localObject1 == null) {
          continue;
        }
        j = 1;
      }
      catch (Exception paramQQAppInterface)
      {
        stTroopRemarkInfo localstTroopRemarkInfo;
        Object localObject2;
        Iterator localIterator;
        Integer localInteger;
        arrayOfObject[1] = Boolean.valueOf(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("handlerGetTroopMemberCardInfoList()", 2, paramQQAppInterface.toString());
        localEntityTransaction.b();
        localEntityManager.a();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handlerGetTroopMemberCardInfoList", 2, "insertTroopMemberCardList bRet = " + arrayOfObject[1]);
        return arrayOfObject;
        Object localObject1 = new TroopMemberInfo();
        int j = 0;
        continue;
        localEntityManager.a((Entity)localObject1);
      }
      finally
      {
        localEntityTransaction.b();
        localEntityManager.a();
      }
      ((TroopMemberInfo)localObject1).troopnick = localstTroopRemarkInfo.sName;
      ((TroopMemberInfo)localObject1).friendnick = localstTroopRemarkInfo.strNick;
      ((TroopMemberInfo)localObject1).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
      ((TroopMemberInfo)localObject1).sex = localstTroopRemarkInfo.cGender;
      ((TroopMemberInfo)localObject1).troopuin = paramString;
      ((TroopMemberInfo)localObject1).mGlamourLevel = ((int)localstTroopRemarkInfo.GlamourLevel);
      if ((localstTroopRemarkInfo.strRank != null) && (localstTroopRemarkInfo.strRank.length() > 0))
      {
        localObject2 = (TroopManager)paramQQAppInterface.getManager(51);
        if (localObject2 != null)
        {
          localObject2 = ((TroopManager)localObject2).a(paramString);
          if (localObject2 != null)
          {
            localObject2 = ((TroopInfo)localObject2).getTroopLevelMap();
            if (localObject2 != null)
            {
              localIterator = ((HashMap)localObject2).keySet().iterator();
              if (localIterator.hasNext())
              {
                localInteger = (Integer)localIterator.next();
                if (!localstTroopRemarkInfo.strRank.equals(((HashMap)localObject2).get(localInteger))) {
                  continue;
                }
                ((TroopMemberInfo)localObject1).level = localInteger.intValue();
              }
            }
          }
        }
      }
      if (j != 0)
      {
        localEntityManager.a((Entity)localObject1);
        break label702;
        localObject1 = new TroopMemberCardInfo();
        j = 0;
        continue;
        localEntityManager.a((Entity)localObject1);
        continue;
      }
      else
      {
        label676:
        arrayOfObject[1] = Boolean.valueOf(true);
        localEntityTransaction.c();
        localEntityTransaction.b();
        localEntityManager.a();
        continue;
      }
      label702:
      i += 1;
    }
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    return paramContext.getSharedPreferences("subaccount_sp", 0).getBoolean(paramString, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\DBUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */