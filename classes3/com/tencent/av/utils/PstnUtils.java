package com.tencent.av.utils;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.smallscreen.PstnSmallScreenService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneContactFaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x626.Oidb_0x626.OpenIDInfoRsp;

public class PstnUtils
{
  public static final int a = -1;
  public static final String a = "pstn_session_info";
  public static final int b = 0;
  private static final String b = "PstnUtils";
  public static final int c = 1;
  public static final int d = 2;
  
  public PstnUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    String str = paramString.replace("-", "").replace(" ", "");
    if (str.length() <= 6) {
      return 5;
    }
    if (str.length() > 16) {
      return 4;
    }
    paramString = str;
    if (paramBoolean) {
      if ((!str.startsWith("00")) && (!str.startsWith("+")))
      {
        paramString = str;
        if (!str.startsWith("86")) {}
      }
      else
      {
        if (!str.startsWith("0086")) {
          break label117;
        }
        paramString = str.substring(4);
      }
    }
    while ((paramString.startsWith("400")) || (paramString.startsWith("800")))
    {
      return 2;
      label117:
      if (str.startsWith("+86")) {
        paramString = str.substring(3);
      } else if (str.startsWith("86")) {
        paramString = str.substring(2);
      } else {
        return 1;
      }
    }
    if ((!paramString.startsWith("0")) && (paramString.length() <= 9)) {
      return 3;
    }
    if ((paramString.length() == 11) || (paramString.length() == 12)) {
      return 0;
    }
    return 6;
  }
  
  public static long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString))
    {
      l1 = l2;
      if (paramString.startsWith("+")) {}
    }
    try
    {
      l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (Exception paramString)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("PstnUtils", 2, "phoneStringToLong " + paramString);
    }
    return 0L;
  }
  
  private static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = ((PhoneContactManager)paramQQAppInterface.getManager(10)).b(paramString);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ContactUtils.d(((PhoneContact)localObject2).name);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ContactUtils.d(paramString);
    }
    paramString = new PhoneContactFaceDrawable(paramQQAppInterface.a(), (String)localObject2);
    int i = paramString.getIntrinsicWidth();
    int j = paramString.getIntrinsicHeight();
    if (paramString.getOpacity() != -1) {}
    for (paramQQAppInterface = Bitmap.Config.ARGB_8888;; paramQQAppInterface = Bitmap.Config.RGB_565)
    {
      paramQQAppInterface = Bitmap.createBitmap(i, j, paramQQAppInterface);
      localObject1 = new Canvas(paramQQAppInterface);
      paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      paramString.draw((Canvas)localObject1);
      return paramQQAppInterface;
    }
  }
  
  public static PstnSessionInfo a(QQAppInterface paramQQAppInterface, PstnSessionInfo paramPstnSessionInfo, String paramString, int paramInt)
  {
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    PhoneContact localPhoneContact;
    if ((paramInt == 1006) || (paramInt == 9502) || (paramInt == 56938))
    {
      paramPstnSessionInfo.b = paramString;
      localPhoneContact = paramQQAppInterface.c(paramString);
      if (localPhoneContact != null) {
        if (localPhoneContact.uin.equals("0"))
        {
          paramPstnSessionInfo.jdField_a_of_type_JavaLangString = paramString;
          paramPstnSessionInfo.b = localPhoneContact.unifiedCode;
        }
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramPstnSessionInfo.c = (paramQQAppInterface.nationCode + paramQQAppInterface.mobileNo);
      }
      paramPstnSessionInfo.jdField_a_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "PstnSessionInfo|mPeerUin=" + paramPstnSessionInfo.jdField_a_of_type_JavaLangString + ", mPeerPhoneNum=" + paramPstnSessionInfo.b + ", mSelfPhoneNum=" + paramPstnSessionInfo.c);
      }
      return paramPstnSessionInfo;
      paramPstnSessionInfo.jdField_a_of_type_JavaLangString = localPhoneContact.uin;
      break;
      paramPstnSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      continue;
      if (paramInt == 26)
      {
        paramPstnSessionInfo.b = paramString;
        paramPstnSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      }
      else
      {
        paramPstnSessionInfo.jdField_a_of_type_JavaLangString = paramString;
        paramString = paramQQAppInterface.a(paramString);
        if (paramString != null) {
          paramPstnSessionInfo.b = paramString.unifiedCode;
        }
      }
    }
  }
  
  public static AVPhoneUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 0;
    String str;
    if ((paramString.startsWith("00")) || (paramString.startsWith("+")) || (paramString.startsWith("86"))) {
      if (paramString.startsWith("0086"))
      {
        paramString = paramString.substring(4);
        str = "0086";
        i = 1;
      }
    }
    for (;;)
    {
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.accountType = 3;
      localAVPhoneUserInfo.account = 0L;
      localAVPhoneUserInfo.telInfo.nation = str;
      localAVPhoneUserInfo.telInfo.mobile = paramString;
      localAVPhoneUserInfo.telInfo.nationState = i;
      return localAVPhoneUserInfo;
      if (paramString.startsWith("+86"))
      {
        paramString = paramString.substring(3);
        str = "+86";
        i = 1;
      }
      else if (paramString.startsWith("86"))
      {
        paramString = paramString.substring(2);
        str = "+86";
        i = 1;
      }
      else
      {
        return null;
        str = "+86";
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    if (paramInt == 1) {
      return String.format(paramQQAppInterface.getApplication().getResources().getString(2131372515), new Object[] { Integer.valueOf(localPstnManager.g()) });
    }
    if (paramInt == 2) {
      return String.format(paramQQAppInterface.getApplication().getResources().getString(2131372515), new Object[] { Integer.valueOf(localPstnManager.h()) });
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> uin = " + paramString + " ,uinType = " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramString == null)) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(37);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface = paramQQAppInterface.a(paramString, paramInt);
      if (paramQQAppInterface == null) {
        break;
      }
      paramString = paramQQAppInterface.pstnInfo;
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> value = " + paramString);
    return paramString;
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber is null");
      }
      str = null;
    }
    int j;
    do
    {
      return str;
      j = paramString.length();
      if ((j > paramInt) && (paramInt != 0) && (j != 0)) {
        break;
      }
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumber --> size <= count. phoneNumber = " + paramString + " ,count = " + paramInt);
    return paramString;
    paramString = new StringBuffer(paramString);
    if (j % 2 == 0)
    {
      k = paramInt / 2;
      i = j / 2;
      while (i < j / 2 + k)
      {
        paramString.setCharAt(i, '*');
        i += 1;
      }
      paramInt = j / 2 - (paramInt - k);
      while (paramInt < j / 2)
      {
        paramString.setCharAt(paramInt, '*');
        paramInt += 1;
      }
    }
    paramString.setCharAt(j / 2, '*');
    int k = (paramInt - 1) / 2;
    int i = j / 2 + 1;
    while (i < j / 2 + 1 + k)
    {
      paramString.setCharAt(i, '*');
      i += 1;
    }
    paramInt = j / 2 - (paramInt - 1 - k);
    while (paramInt < j / 2)
    {
      paramString.setCharAt(paramInt, '*');
      paramInt += 1;
    }
    return paramString.toString();
  }
  
  public static String a(ArrayList paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.get(i);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject1.put("a", localAVPhoneUserInfo.account);
        localJSONObject1.put("at", localAVPhoneUserInfo.accountType);
        localJSONObject2.put("m", localAVPhoneUserInfo.telInfo.mobile);
        localJSONObject2.put("n", localAVPhoneUserInfo.telInfo.nation);
        localJSONObject2.put("p", localAVPhoneUserInfo.telInfo.prefix);
        localJSONObject2.put("ns", localAVPhoneUserInfo.telInfo.nationState);
        localJSONObject1.put("ti", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ArrayList localArrayList = new ArrayList();
        paramString = localArrayList;
        if (i < localJSONArray.length())
        {
          paramString = localJSONArray.getJSONObject(i);
          JSONObject localJSONObject = paramString.optJSONObject("ti");
          AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramString.optLong("a", 0L);
          localAVPhoneUserInfo.accountType = paramString.optInt("at", -1);
          localAVPhoneUserInfo.telInfo.mobile = localJSONObject.optString("m", "");
          localAVPhoneUserInfo.telInfo.nation = localJSONObject.optString("n", "");
          localAVPhoneUserInfo.telInfo.prefix = localJSONObject.optString("p", "");
          localAVPhoneUserInfo.telInfo.nationState = localJSONObject.optInt("ns", 0);
          if (-1 == localAVPhoneUserInfo.accountType) {
            break label179;
          }
          localArrayList.add(localAVPhoneUserInfo);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      return paramString;
      label179:
      i += 1;
    }
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = a((String)paramArrayList.get(i));
      if (localAVPhoneUserInfo != null)
      {
        localAVPhoneUserInfo.accountType = 3;
        localArrayList.add(localAVPhoneUserInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Oidb_0x626.OpenIDInfoRsp)paramList.next();
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = ((Oidb_0x626.OpenIDInfoRsp)localObject).uint64_tinyid.get();
      localAVPhoneUserInfo.accountType = ((Oidb_0x626.OpenIDInfoRsp)localObject).uint32_acounttype.get();
      localObject = ((Oidb_0x626.OpenIDInfoRsp)localObject).bytes_openid.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("-");
        if ((localObject != null) && (localObject.length >= 2))
        {
          localAVPhoneUserInfo.telInfo.nation = localObject[0];
          localAVPhoneUserInfo.telInfo.mobile = localObject[1];
          if (!TextUtils.isEmpty(localAVPhoneUserInfo.telInfo.nation)) {
            localAVPhoneUserInfo.telInfo.nationState = 1;
          }
          localArrayList.add(localAVPhoneUserInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = a(paramQQAppInterface, paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === pstnInfo : " + (String)localObject1);
    }
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
      return null;
    }
    Object localObject2 = a((String)localObject1);
    if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
      return null;
    }
    localObject1 = (DiscussionManager)paramQQAppInterface.getManager(52);
    if (localObject1 == null) {
      return null;
    }
    paramString = ((DiscussionManager)localObject1).a(paramString);
    localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    AVPhoneUserInfo localAVPhoneUserInfo;
    while (((Iterator)localObject2).hasNext())
    {
      localAVPhoneUserInfo = (AVPhoneUserInfo)((Iterator)localObject2).next();
      paramQQAppInterface = localAVPhoneUserInfo.telInfo.mobile;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
      {
        paramQQAppInterface = ((PhoneContactManager)localObject1).b(paramQQAppInterface);
        if (paramQQAppInterface == null) {
          break label262;
        }
      }
    }
    label262:
    for (paramQQAppInterface = paramQQAppInterface.uin;; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() == 0))
      {
        localArrayList.add(localAVPhoneUserInfo);
        break;
      }
      if (paramString.containsKey(paramQQAppInterface)) {
        break;
      }
      localArrayList.add(localAVPhoneUserInfo);
      break;
      if (QLog.isColorLevel()) {
        QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === list : " + localArrayList.toString());
      }
      return localArrayList;
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramQQAppInterface, paramString, paramInt1);
    QLog.i("PstnUtils", 2, " ==== getRealAVPhoneBitmap === pstnInfo : " + (String)localObject);
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = a((String)localObject);
    if ((localArrayList1 == null) || (localArrayList1.size() == 0)) {
      return null;
    }
    localObject = (DiscussionManager)paramQQAppInterface.getManager(52);
    if (localObject == null) {
      return null;
    }
    Map localMap = ((DiscussionManager)localObject).a(paramString);
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
    ArrayList localArrayList2 = new ArrayList();
    paramInt2 = Math.min(paramInt2, localArrayList1.size());
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      localObject = (AVPhoneUserInfo)localArrayList1.get(paramInt1);
      String str = ((AVPhoneUserInfo)localObject).telInfo.mobile;
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        PhoneContact localPhoneContact = localPhoneContactManager.b(str);
        paramString = null;
        if (localPhoneContact != null) {
          paramString = localPhoneContact.uin;
        }
        if ((paramString == null) || (paramString.length() == 0))
        {
          localArrayList2.add(a(paramQQAppInterface, str));
        }
        else if (!localMap.containsKey(paramString))
        {
          localObject = paramQQAppInterface.a(11, ((AVPhoneUserInfo)localObject).telInfo.nation + str, (byte)3, true, 0);
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = a(paramQQAppInterface, str);
          }
          localArrayList2.add(paramString);
        }
      }
    }
    return localArrayList2;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnUtils", 2, "WL_DEBUG stopPstnSmallScreenService");
    }
    paramContext.stopService(new Intent(paramContext, PstnSmallScreenService.class));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramContext, paramInt1, paramInt2, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = "http://pubacc.mobile.qq.com/yunying/lightalk_pay/qq/index.html?_wv=1025&type=";
    if (paramBoolean) {
      localObject1 = "http://pubacc.mobile.qq.com/yunying/lightalk_pay/qq/goods.html?_wv=1027&type=";
    }
    Object localObject2;
    if (paramInt1 != 1)
    {
      localObject2 = localObject1;
      if (paramInt1 != 2) {}
    }
    else
    {
      localObject2 = (String)localObject1 + paramInt1;
    }
    localObject1 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    paramContext.startActivity((Intent)localObject1);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof QQAppInterface)))
    {
      localObject1 = (PstnManager)paramQQAppInterface.getManager(142);
      if ((localObject1 != null) && (((PstnManager)localObject1).c())) {
        ((PstnManager)localObject1).c(false);
      }
      SharedPreUtils.c(paramContext, paramQQAppInterface.a(), true);
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063EF", "0X80063EF", paramInt2, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isBindContact", 2, "contact manager is null.");
      }
      return false;
    }
    if (!paramQQAppInterface.d())
    {
      if (QLog.isColorLevel()) {
        QLog.i("isBindContact", 2, "not has read contact permission.");
      }
      return false;
    }
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().isStopFindMatch))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isBindContact", 2, "self bind info isStopFindMatch.");
      }
      return false;
    }
    if (paramQQAppInterface.d() < 6)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isBindContact", 2, "state:" + paramQQAppInterface.d());
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    paramQQAppInterface = localPstnManager.a(paramQQAppInterface.a());
    if (paramQQAppInterface != null) {
      if (paramInt == 1)
      {
        if ((localPstnManager.b() == 1) && (paramQQAppInterface.pstn_c2c_try_status == 0)) {
          return true;
        }
        if (paramQQAppInterface.pstn_c2c_call_time > 0) {
          return true;
        }
      }
      else if (paramInt == 2)
      {
        if ((localPstnManager.c() == 1) && (paramQQAppInterface.pstn_multi_try_status == 0)) {
          return true;
        }
        if (paramQQAppInterface.pstn_multi_call_time > 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "contact manager is null.");
      }
      return false;
    }
    if (!paramQQAppInterface.d())
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "not has read contact permission.");
      }
      paramContext.startActivity(new Intent(paramContext, GuideBindPhoneActivity.class));
      return true;
    }
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().isStopFindMatch))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "self bind info isStopFindMatch.");
      }
      paramQQAppInterface = new Intent(paramContext, PhoneLaunchActivity.class);
      paramQQAppInterface.putExtra("needAlert", true);
      paramQQAppInterface.putExtra("fromStopAndMatch", true);
      paramQQAppInterface.putExtra("returnAndFinish", true);
      paramQQAppInterface.putExtra("leftViewText", "返回");
      paramContext.startActivity(paramQQAppInterface);
      return true;
    }
    if (paramQQAppInterface.d() < 6)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "state:" + paramQQAppInterface.d());
      }
      paramQQAppInterface = new Intent(paramContext, PhoneFrameActivity.class);
      paramQQAppInterface.putExtra("key_req_type", 4);
      paramQQAppInterface.putExtra("kSrouce", 6);
      paramContext.startActivity(paramQQAppInterface);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "contact manager is null.");
      }
      return false;
    }
    if ((paramBoolean) && (!paramQQAppInterface.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "not has read contact permission.");
      }
      paramBaseActivity.startActivityForResult(new Intent(paramBaseActivity, GuideBindPhoneActivity.class), paramInt);
      return true;
    }
    if ((paramBoolean) && (paramQQAppInterface.a() != null) && (paramQQAppInterface.a().isStopFindMatch))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "self bind info isStopFindMatch.");
      }
      paramQQAppInterface = new Intent(paramBaseActivity, PhoneLaunchActivity.class);
      paramQQAppInterface.putExtra("needAlert", true);
      paramQQAppInterface.putExtra("fromStopAndMatch", true);
      paramQQAppInterface.putExtra("returnAndFinish", true);
      paramQQAppInterface.putExtra("leftViewText", "返回");
      paramBaseActivity.startActivityForResult(paramQQAppInterface, paramInt);
      return true;
    }
    if (((!paramBoolean) && (paramQQAppInterface.d() < 3)) || ((paramBoolean) && (paramQQAppInterface.d() < 6)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "state:" + paramQQAppInterface.d());
      }
      paramQQAppInterface = new Intent(paramBaseActivity, PhoneFrameActivity.class);
      paramQQAppInterface.putExtra("key_req_type", 4);
      paramQQAppInterface.putExtra("kSrouce", 6);
      paramBaseActivity.startActivityForResult(paramQQAppInterface, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
    Object localObject2 = localDiscussionManager.a(paramString);
    Object localObject1 = a(paramQQAppInterface, paramString, 3000);
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
    boolean bool1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = b((String)localObject1);
      if ((localObject2 == null) || (((Map)localObject2).keySet() == null)) {
        break label194;
      }
      localObject2 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((localObject1 != null) && (str != null) && (!((ArrayList)localObject1).contains(localPhoneContactManager.b(str))) && (!str.equals(paramQQAppInterface.a()))) {
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      paramString = localDiscussionManager.a(paramString);
      boolean bool2 = bool1;
      if (paramString != null)
      {
        if ((!bool1) && (paramString.isUIControlFlag_Hidden_RecentUser()))
        {
          paramString.removeUIControlFlag_Hidden_RecentUser();
          localDiscussionManager.a(paramString);
        }
        bool2 = paramString.isUIControlFlag_Hidden_RecentUser();
      }
      return bool2;
      bool1 = false;
      continue;
      label194:
      bool1 = true;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject2 = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject2).a(paramQQAppInterface.a());
    if (paramInt == 1) {
      if ((localObject1 != null) && (((PstnCardInfo)localObject1).pstn_ever_c2c_vip == 1))
      {
        localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131372491);
        localObject2 = ((PstnManager)localObject2).a("key_pstn_tried_c2c_recharge_title");
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          str = paramQQAppInterface.getApplication().getResources().getString(2131372497);
          localObject1 = ((PstnManager)localObject2).a("key_pstn_untried_c2c_recharge_title");
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        return str;
        if ((localObject1 == null) || (((PstnCardInfo)localObject1).pstn_ever_multi_vip != 1)) {
          break;
        }
        str = paramQQAppInterface.getApplication().getResources().getString(2131372494);
        localObject1 = ((PstnManager)localObject2).a("key_pstn_tried_multi_recharge_title");
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return str;
      str = paramQQAppInterface.getApplication().getResources().getString(2131372500);
      localObject1 = ((PstnManager)localObject2).a("key_pstn_untried_multi_recharge_title");
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return str;
  }
  
  public static String b(ArrayList paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("NO", str);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ArrayList localArrayList = new ArrayList();
        i = 0;
        paramString = localArrayList;
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getJSONObject(i);
          JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("ti");
          paramString = new AVPhoneUserInfo();
          paramString.accountType = ((JSONObject)localObject).optInt("at", -1);
          localObject = localJSONObject.optString("m", "");
          if (-1 == paramString.accountType) {
            break label107;
          }
          localArrayList.add(localObject);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      return paramString;
      label107:
      i += 1;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    paramQQAppInterface = localPstnManager.a(paramQQAppInterface.a());
    if (paramQQAppInterface != null) {
      if (paramInt == 1)
      {
        if ((localPstnManager.b() == 1) && (paramQQAppInterface.pstn_c2c_call_time > 0) && (paramQQAppInterface.pstn_c2c_call_time <= localPstnManager.g())) {
          return true;
        }
      }
      else if ((paramInt == 2) && (localPstnManager.c() == 1) && (paramQQAppInterface.pstn_multi_call_time > 0) && (paramQQAppInterface.pstn_multi_call_time <= localPstnManager.h())) {
        return true;
      }
    }
    return false;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject2 = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject2).a(paramQQAppInterface.a());
    if (paramInt == 1) {
      if ((localObject1 != null) && (((PstnCardInfo)localObject1).pstn_ever_c2c_vip == 1))
      {
        localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131372492);
        localObject2 = ((PstnManager)localObject2).a("key_pstn_tried_c2c_recharge_content");
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          str = paramQQAppInterface.getApplication().getResources().getString(2131372498);
          localObject1 = ((PstnManager)localObject2).a("key_pstn_untried_c2c_recharge_content");
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        return str;
        if ((localObject1 == null) || (((PstnCardInfo)localObject1).pstn_ever_multi_vip != 1)) {
          break;
        }
        str = paramQQAppInterface.getApplication().getResources().getString(2131372495);
        localObject1 = ((PstnManager)localObject2).a("key_pstn_tried_multi_recharge_content");
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return str;
      str = paramQQAppInterface.getApplication().getResources().getString(2131372501);
      localObject1 = ((PstnManager)localObject2).a("key_pstn_untried_multi_recharge_content");
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return str;
  }
  
  public static ArrayList c(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        new String();
        localArrayList.add(paramString.optString("NO", ""));
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
  }
  
  public static String d(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject2 = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject2).a(paramQQAppInterface.a());
    if (paramInt == 1) {
      if ((localObject1 != null) && (((PstnCardInfo)localObject1).pstn_ever_c2c_vip == 1))
      {
        localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131372493);
        localObject2 = ((PstnManager)localObject2).a("key_pstn_tried_c2c_recharge_confirm_text");
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          str = paramQQAppInterface.getApplication().getResources().getString(2131372499);
          localObject1 = ((PstnManager)localObject2).a("key_pstn_untried_c2c_recharge_confirm_text");
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        return str;
        if ((localObject1 == null) || (((PstnCardInfo)localObject1).pstn_ever_multi_vip != 1)) {
          break;
        }
        str = paramQQAppInterface.getApplication().getResources().getString(2131372496);
        localObject1 = ((PstnManager)localObject2).a("key_pstn_tried_multi_recharge_confirm_text");
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return str;
      str = paramQQAppInterface.getApplication().getResources().getString(2131372502);
      localObject1 = ((PstnManager)localObject2).a("key_pstn_untried_multi_recharge_confirm_text");
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\PstnUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */