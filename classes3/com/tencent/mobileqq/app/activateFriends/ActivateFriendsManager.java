package com.tencent.mobileqq.app.activateFriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qie;
import qif;
import qig;
import qih;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class ActivateFriendsManager
  implements Manager
{
  public static final int a = -1;
  private static final long jdField_a_of_type_Long = 120000L;
  public static final String a = "pref_act_frd";
  public static final int b = 1;
  private static final long jdField_b_of_type_Long = 60000L;
  private static final String jdField_b_of_type_JavaLangString = "ActivateFriends.Manager";
  private static final boolean jdField_b_of_type_Boolean = false;
  public static final int c = 2;
  private static final long jdField_c_of_type_Long = 1L;
  private static final String jdField_c_of_type_JavaLangString = "key_uin_sended_";
  private static final boolean jdField_c_of_type_Boolean = false;
  private static final String jdField_d_of_type_JavaLangString = "key_check_stamp";
  public static final int e = 0;
  private static final String jdField_e_of_type_JavaLangString = "key_last_birth_msg_stamp";
  public static final int f = 1;
  private static final String f = "key_check_interval";
  public static final int g = 2;
  private static final String g = "key_showin_contact";
  public static final int h = 3;
  private static final String h = "key_config_version";
  private static final String jdField_i_of_type_JavaLangString = "-";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  Set jdField_a_of_type_JavaUtilSet;
  public boolean a;
  private volatile Set jdField_b_of_type_JavaUtilSet;
  private volatile Set jdField_c_of_type_JavaUtilSet;
  public int d;
  private long jdField_d_of_type_Long;
  private long jdField_e_of_type_Long;
  private int jdField_i_of_type_Int;
  private int j;
  private int k;
  private int l;
  
  public ActivateFriendsManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = 1;
    this.j = 2;
    this.k = 3;
    this.jdField_d_of_type_Int = this.i;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaLangRunnable = new qie(this);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.l = Integer.MIN_VALUE;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("pref_act_frd" + paramQQAppInterface.a(), 0);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_stamp", 0L);
    this.e = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_interval", 120000L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_showin_contact", true);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(MessageCache.a() * 1000L);
    int m = ((Calendar)localObject).get(1);
    int n = ((Calendar)localObject).get(2);
    int i1 = ((Calendar)localObject).get(6);
    ((Calendar)localObject).add(6, 1);
    int i2 = ((Calendar)localObject).get(6);
    localObject = new GregorianCalendar();
    ((GregorianCalendar)localObject).set(5, paramInt3);
    ((GregorianCalendar)localObject).set(2, paramInt2 - 1);
    ((GregorianCalendar)localObject).set(1, paramInt1);
    paramInt3 = ((GregorianCalendar)localObject).get(6);
    if (m == paramInt1) {
      if (paramInt3 >= i1) {}
    }
    while (paramInt1 <= m)
    {
      return 0;
      if (paramInt3 == i1) {
        return 1;
      }
      if (paramInt3 == i2) {
        return 2;
      }
      return 3;
    }
    if ((paramInt1 == m + 1) && (n + 1 + 0 == 12) && (paramInt2 == 1))
    {
      if (i2 == paramInt3) {
        return 2;
      }
      return 3;
    }
    return 3;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      int m = localMsgBody.uint32_msg_type.get();
      return m;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "ParseMessageType catch error.", paramArrayOfByte);
      }
    }
    return 1;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      return BaseApplicationImpl.a.getString(2131371415, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    case 0: 
      return BaseApplicationImpl.a.getString(2131371412);
    case 1: 
      return BaseApplicationImpl.a.getString(2131371413);
    }
    return BaseApplicationImpl.a.getString(2131371414);
  }
  
  public static String a(Context paramContext)
  {
    int[] arrayOfInt = new int[10];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131371426;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131371427;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131371428;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131371429;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131371430;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131371431;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131371432;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131371433;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131371434;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131371435;
    tmp54_48;
    return paramContext.getString(arrayOfInt[new java.util.Random().nextInt(arrayOfInt.length)]);
  }
  
  public static String a(Context paramContext, SubMsgType0x76.MsgBody paramMsgBody)
  {
    String str2 = paramMsgBody.bytes_notify_wording.get().toStringUtf8();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramMsgBody.uint32_msg_type.get() != 1) {
        break label64;
      }
      str1 = String.format(paramContext.getString(2131371382), new Object[] { paramMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8() });
    }
    label64:
    do
    {
      return str1;
      str1 = str2;
    } while (paramMsgBody.uint32_msg_type.get() != 2);
    return paramContext.getString(2131371383);
  }
  
  private Set a(int paramInt)
  {
    if (paramInt == 1) {}
    Object localObject2;
    for (Object localObject1 = this.b;; localObject1 = this.c)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label177;
      }
      localObject2 = new HashSet(6);
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_uin_sended_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinSendedSet, str = " + (String)localObject1 + ", msgType = " + paramInt);
      }
      localObject1 = ((String)localObject1).split("-");
      int n = localObject1.length;
      int m = 0;
      while (m < n)
      {
        CharSequence localCharSequence = localObject1[m];
        if (!TextUtils.isEmpty(localCharSequence)) {
          ((Set)localObject2).add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        m += 1;
      }
    }
    if (paramInt == 1)
    {
      this.b = ((Set)localObject2);
      label177:
      return (Set)localObject2;
    }
    this.c = ((Set)localObject2);
    return (Set)localObject2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((ActivateFriendsManager)paramQQAppInterface.getManager(84)).jdField_a_of_type_Boolean;
  }
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (localIterator.hasNext()) {
        ((ActivateFriendsManager.ActivateFriendsListener)localIterator.next()).a();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_config_version", 0);
  }
  
  String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 3);
    return paramString.substring(paramString.length() - 3, paramString.length());
  }
  
  public void a()
  {
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "onReceivePushMessage  msgType = " + paramInt);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_sended_" + paramInt, "").commit();
    if (paramInt == 1) {
      this.b = new HashSet();
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007210", "0X8007211", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Boolean) {
          e();
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_birth_msg_stamp", MessageCache.a()).commit();
        ThreadManager.b().post(new qih(this));
      }
      return;
      this.c = new HashSet();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    for (boolean bool = true;; bool = false)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          if (paramString != null)
          {
            if (paramString.optInt("showInContact", 1) != 1) {
              continue;
            }
            this.jdField_a_of_type_Boolean = bool;
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_showin_contact", this.jdField_a_of_type_Boolean).commit();
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_config_version", paramInt).commit();
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ActivateFriends.Manager", 2, "updateConfig error " + paramString.getMessage());
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "updateConfig|" + this.jdField_a_of_type_Boolean);
      }
      return;
    }
  }
  
  public void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString)
  {
    int n = 0;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessages | uin = ");
      if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
        break label104;
      }
      localStringBuilder.append("null");
      localStringBuilder.append(" | time = ");
      if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0)) {
        break label150;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      ThreadManager.b().post(new qig(this, paramInt, paramArrayOfLong1, paramString, paramArrayOfLong2));
      return;
      label104:
      int i1 = paramArrayOfLong1.length;
      int m = 0;
      while (m < i1)
      {
        localStringBuilder.append(a(String.valueOf(paramArrayOfLong1[m]))).append(",");
        m += 1;
      }
      break;
      label150:
      i1 = paramArrayOfLong2.length;
      m = n;
      while (m < i1)
      {
        localStringBuilder.append(paramArrayOfLong2[m]).append(",");
        m += 1;
      }
    }
  }
  
  void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 120000L) {
      l1 = 120000L;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.e = l1;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_check_stamp", System.currentTimeMillis()).putLong("key_check_interval", l1).commit();
  }
  
  public void a(ActivateFriendsManager.ActivateFriendsListener paramActivateFriendsListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramActivateFriendsListener)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramActivateFriendsListener);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).e(paramBoolean1);
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367844) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean1).commit();
  }
  
  public void a(long[] paramArrayOfLong, int paramInt)
  {
    HashSet localHashSet = new HashSet(6);
    localHashSet.addAll(a(paramInt));
    int n = localHashSet.size();
    int i1 = paramArrayOfLong.length;
    int m = 0;
    while (m < i1)
    {
      localHashSet.add(Long.valueOf(paramArrayOfLong[m]));
      m += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Long)localIterator.next()).append("-");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_sended_" + paramInt, localStringBuilder.toString()).commit();
    if (paramInt == 1) {
      this.b = localHashSet;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "onSendTimingMsgSuc, send count = " + paramArrayOfLong.length + ", orginal count = " + n + ", new count = " + localHashSet.size());
      }
      return;
      this.c = localHashSet;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.l == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      this.l = paramInt;
      return bool;
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    return a(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).l();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367844) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      boolean bool = localMsgBody.bool_strong_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "shouldMsgTips | " + bool);
      }
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "IsMessageTipsInBackground catch error.", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public void b()
  {
    qif localqif = new qif(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.b().post(localqif);
      return;
    }
    localqif.run();
  }
  
  public void b(ActivateFriendsManager.ActivateFriendsListener paramActivateFriendsListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramActivateFriendsListener);
      return;
    }
  }
  
  public boolean b(byte[] arg1)
  {
    int m = a(???);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(m)))
        {
          bool = true;
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(m));
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void c()
  {
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_d_of_type_Int = this.j;
    ActivateFriendServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
  }
  
  public void onDestroy()
  {
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\activateFriends\ActivateFriendsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */