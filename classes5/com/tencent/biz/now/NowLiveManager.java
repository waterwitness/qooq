package com.tencent.biz.now;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hkf;
import hkg;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class NowLiveManager
  extends Observable
  implements Manager
{
  public static final int a = 1001;
  public static final String a = "NowLiveManager";
  public static final int b = 1003;
  public static final String b = "cover_location";
  public static final int c = 879;
  public static final String c = "http://now.qq.com/cgi-bin/now/web/room/get_live_room_url";
  public static final int d = 3050;
  public static final String d = "http://now.qq.com/cgi-bin/now/web/room/check_live_stat";
  public static final int e = 8855;
  public static final String e = "http://now.qq.com/cgi-bin/now/web/room/get_live_msg_url";
  public static final String f = "now_msg_sp";
  public static final String g = "now_tab_sp";
  public static final String h = "now_show_key";
  public static final String i = "now_index_key";
  public static final String j = "now_name_key";
  public static final String k = "now_is_first_run_key";
  public char a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected HttpWebCgiAsyncTask.Callback a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  Map jdField_a_of_type_JavaUtilMap;
  public boolean a;
  public boolean b;
  public boolean c;
  public int f;
  public int g;
  public String l;
  
  public NowLiveManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.f = -1;
    this.g = -100;
    this.l = "";
    this.c = true;
    this.jdField_a_of_type_Char = '0';
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new hkf(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.a(), 0);
    a();
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.msgtype == 63525) && ((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 76);
  }
  
  private void b()
  {
    Integer[] arrayOfInteger = new Integer[7];
    arrayOfInteger[0] = Integer.valueOf(1);
    arrayOfInteger[3] = Integer.valueOf(0);
    arrayOfInteger[4] = Integer.valueOf(0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(arrayOfInteger);
  }
  
  public hkg a(String paramString, long paramLong)
  {
    hkg localhkg2 = (hkg)this.jdField_a_of_type_JavaUtilHashMap.get(paramString + paramLong);
    hkg localhkg1 = localhkg2;
    if (localhkg2 == null)
    {
      localhkg1 = new hkg(this);
      localhkg1.jdField_a_of_type_JavaLangString = paramString;
      localhkg1.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilHashMap.put(localhkg1.a(), localhkg1);
    }
    return localhkg1;
  }
  
  public void a()
  {
    boolean bool = false;
    this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getBoolean("now_is_first_run_key", true);
    this.g = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getInt("now_index_key", 3);
    this.l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getString("now_name_key", "");
    if (this.f != -1) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "00000");
      if (str != null) {
        this.jdField_a_of_type_Char = str.charAt(2);
      }
      if (QLog.isColorLevel()) {
        QLog.w("initNowTabShowValue", 4, "initNowTabShowValue : " + str);
      }
      if ((str != null) && (str.length() <= "00000".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("NowLiveManager", 2, "isNowTabShow fullVal is null");
    return;
    Object localObject = str;
    if (str.length() < "00000".length()) {
      localObject = str + "00000".substring(str.length());
    }
    localObject = ((String)localObject).toCharArray();
    char c1 = localObject[2];
    int m;
    if (localObject[0] == '1') {
      if ((localObject[3] == '0') || (c1 == '0') || (c1 == '1'))
      {
        m = 0;
        this.f = m;
        if (QLog.isColorLevel()) {
          QLog.i("NowLiveManager", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ",isNowTabShow mIsNowTabShow=" + this.f + " plan=" + c1);
        }
        if (this.f != 0) {
          break label455;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        LebaShowListManager.d |= 0x2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m) {
          b();
        }
      }
      MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m, this.g);
      return;
      m = 1;
      break;
      if ((localObject[1] == '0') || (c1 == '0') || (c1 == '1')) {}
      for (m = 0;; m = 1)
      {
        this.f = m;
        break;
      }
      label455:
      bool = true;
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageForStructing.frienduin))
    {
      long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForStructing.frienduin)).longValue();
      if (paramMessageForStructing.time > l1)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time" + paramMessageForStructing.frienduin, paramMessageForStructing.time).commit();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("uid" + paramMessageForStructing.frienduin, paramMessageForStructing.msgUid).commit();
      return;
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time" + paramMessageForStructing.frienduin, paramMessageForStructing.time).commit();
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("room_id", paramString2);
    localBundle.putLong("time", paramLong);
    localBundle.putString("friendUin", paramString1);
    paramString1 = a(paramString1, paramLong);
    if ((paramString1.jdField_a_of_type_Int == 1) || (paramString1.jdField_a_of_type_Int == 2))
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    if (paramString1.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    paramString1 = new Bundle();
    paramString1.putString("is_sub_room", "0");
    paramString1.putString("playtype", "4");
    paramString1.putString("platform", "3");
    paramString1.putString("room_id", paramString2);
    paramString2 = new HashMap();
    paramString2.put("BUNDLE", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    paramString2.put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://now.qq.com/cgi-bin/now/web/room/get_live_room_url", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1001, localBundle, true).execute(new HashMap[] { paramString2 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveManager", 2, "getLiveState: roomId = " + paramString2 + " vid = " + paramString3 + " shMsgSeq = " + paramLong);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("room_id", paramString2);
    localBundle.putLong("time", paramLong);
    localBundle.putString("vid", paramString3);
    localBundle.putString("friendUin", paramString1);
    localBundle.putBoolean("needReqUrl", paramBoolean);
    paramString1 = a(paramString1, paramLong);
    if ((paramString1.jdField_a_of_type_Int == 1) || (paramString1.jdField_a_of_type_Int == 2))
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1003), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    paramString1 = new Bundle();
    paramString1.putString("room_id", paramString2);
    paramString1.putString("vid", paramString3);
    paramString2 = new HashMap();
    paramString2.put("BUNDLE", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    paramString2.put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://now.qq.com/cgi-bin/now/web/room/check_live_stat", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1003, localBundle, true).execute(new HashMap[] { paramString2 });
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "00000");
    if (QLog.isColorLevel()) {
      QLog.w("writeNowTabStateVal", 2, "writeNowTabStateVal fullVal=" + (String)localObject2 + " vals:" + Arrays.toString(paramArrayOfInteger) + "     mNowTabShowState=" + this.f);
    }
    if ((localObject2 == null) || (((String)localObject2).length() > "00000".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 5))
    {
      if (QLog.isColorLevel()) {
        QLog.e("NowLiveManager", 2, "writeNowTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "00000".length()) {
      localObject1 = (String)localObject2 + "00000".substring(((String)localObject2).length());
    }
    localObject1 = new StringBuilder((String)localObject1);
    int m = 0;
    label240:
    if (m < paramArrayOfInteger.length)
    {
      localObject2 = paramArrayOfInteger[m];
      if (localObject2 == null) {}
      for (;;)
      {
        m += 1;
        break label240;
        if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("NowLiveManager", 2, "writeNowTabStateVal wrong index,," + localObject2);
          return;
        }
        ((StringBuilder)localObject1).setCharAt(m, (char)(((Integer)localObject2).intValue() + 48));
      }
    }
    char c1 = ((StringBuilder)localObject1).charAt(2);
    if ('1' == ((StringBuilder)localObject1).charAt(0))
    {
      if ((((StringBuilder)localObject1).charAt(3) == '0') || (c1 == '0') || (c1 == '1'))
      {
        m = 0;
        label382:
        this.f = m;
        if (this.f != 0) {
          break label733;
        }
      }
      label733:
      for (bool = false;; bool = true)
      {
        this.jdField_a_of_type_Boolean = bool;
        LebaShowListManager.d |= 0x2;
        if (QLog.isColorLevel()) {
          QLog.w("writeNowTabStateVal", 2, "userChange mNowTabShowState=" + this.f + " result:" + localObject1 + "  plan=" + c1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("NowLiveManager", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ",writeNowTabStateVal vals=" + Arrays.toString(paramArrayOfInteger) + ",mIsNowTabShow=" + this.f + ",isNowTabShow=" + this.jdField_a_of_type_Boolean);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).edit().putString("now_show_key" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), ((StringBuilder)localObject1).toString());
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = new Integer[7];
          localObject1[0] = Integer.valueOf(1);
          localObject1[3] = Integer.valueOf(0);
          localObject1[4] = Integer.valueOf(0);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Integer[])localObject1, false);
        }
        localObject1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_calltab_show_key", "0111100");
        if ((!paramBoolean) || (paramArrayOfInteger[0] == null) || (1 != paramArrayOfInteger[0].intValue()) || (((String)localObject1).charAt(0) != '0')) {
          break;
        }
        paramArrayOfInteger = new Integer[7];
        paramArrayOfInteger[0] = Integer.valueOf(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramArrayOfInteger, false);
        return;
        m = 1;
        break label382;
      }
    }
    if ((((StringBuilder)localObject1).charAt(1) == '0') || (c1 == '0') || (c1 == '1'))
    {
      m = 0;
      label765:
      this.f = m;
      if (this.f != 0) {
        break label868;
      }
    }
    label868:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        LebaShowListManager.d |= 0x2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("writeNowTabStateVal", 2, "userNoChange mNowTabShowState=" + this.f + " result:" + localObject1 + "  plan=" + c1);
      break;
      m = 1;
      break label765;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return paramLong >= ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
    }
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("time" + paramString, 0L);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l1));
    if (paramLong >= l1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\now\NowLiveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */