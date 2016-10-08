package com.tencent.biz.eqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.huangye.C2BUtils;
import hht;
import hhu;
import hhv;
import hhw;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class CrmUtils
{
  public static final int a = -1;
  public static final long a = 256L;
  public static final String a = "http://ptlogin2.qq.com/qidian_client?pt_clientver=5428&pt_src=1&clientuin=%s&clientkey=%s&keyindex=19&jump=30&kfuin=%s&kfext=%s&buildver=1.0.0.0&inter=1&_wv=1027";
  public static final Pattern a;
  public static final boolean a;
  public static final int b = 0;
  public static final String b = "http://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027";
  public static final int c = -1;
  public static final String c = "QQ语音";
  public static final int d = -2;
  public static final String d = "seq";
  public static final int e = -3;
  static final String e = "CrmUtils";
  public static final int f = -4;
  static final String f = "IVR_TS_CrmUtils";
  public static final int g = -5;
  public static final int h = -16;
  public static final int i = -17;
  public static final int j = -24;
  public static final int k = -26;
  public static final int l = -27;
  public static final int m = -28;
  public static final int n = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("QQ语音");
    jdField_a_of_type_Boolean = a();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i2 = 0;
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    int i1 = i2;
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).c(paramString);
      if (localObject != null) {
        break label66;
      }
      paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
      if (paramQQAppInterface == null) {
        break label81;
      }
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.certifiedGrade <= 0)) {
        break label81;
      }
      i1 = 2130838906;
    }
    for (;;)
    {
      return i1;
      label66:
      i1 = i2;
      if (((PublicAccountInfo)localObject).certifiedGrade > 0L)
      {
        return 2130838906;
        label81:
        i1 = 0;
      }
    }
  }
  
  public static Intent a(Context paramContext, String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent(paramContext, EqqAccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("need_finish", paramBoolean1);
    localIntent.putExtra("uintype", 1024);
    localIntent.addFlags(536870912);
    if (paramInt != -1) {
      localIntent.putExtra("source", paramInt);
    }
    if (paramBoolean2) {
      paramContext.startActivity(localIntent);
    }
    return localIntent;
  }
  
  public static InputStream a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject != null) {
          paramQQAppInterface = ((PublicAccountInfo)localObject).name;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          paramQQAppInterface = paramQQAppInterface.getManager(68);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
            if (paramQQAppInterface != null) {}
            for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = "")
            {
              return paramQQAppInterface;
              if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
              }
            }
          }
          paramQQAppInterface = str;
        } while (!QLog.isColorLevel());
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        return "";
        paramQQAppInterface = str;
      } while (!QLog.isColorLevel());
      QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
      return "";
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("CrmUtils", 2, "We can't get name, because uin is null");
    return "";
  }
  
  private static void a(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    b(paramInt, paramQQProgressDialog);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!jdField_a_of_type_Boolean) {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
    }
    do
    {
      return;
      if ((VcSystemInfo.e()) && (VcSystemInfo.f()))
      {
        ActionSheet localActionSheet = ActionSheet.a(paramContext);
        localActionSheet.c(2131368096);
        localActionSheet.d(2131367262);
        localActionSheet.a(new hhw(localActionSheet, paramQQAppInterface, paramContext, paramSessionInfo));
        localActionSheet.show();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CrmUtils", 2, String.format("We needn't show video action sheet, because Sharp Audio is not supported", new Object[0]));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, PublicAccountInfo paramPublicAccountInfo, EqqDetail paramEqqDetail, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio3(), ts=" + System.currentTimeMillis());
    }
    boolean bool;
    int i1;
    if (paramPublicAccountInfo != null)
    {
      bool = paramPublicAccountInfo.hasIvrAbility();
      i1 = 1;
    }
    for (;;)
    {
      if (bool)
      {
        if (i1 != 0) {
          break label318;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("IVR_TS_CrmUtils", 4, ">>>begin follow, ts=" + System.currentTimeMillis());
        }
        paramPublicAccountInfo = null;
        if ((paramContext instanceof Activity)) {
          paramPublicAccountInfo = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131492908));
        }
        if (paramPublicAccountInfo != null) {
          paramPublicAccountInfo.setCanceledOnTouchOutside(true);
        }
        NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
        localNewIntent.putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.uin.set((int)Long.parseLong(paramEqqDetail.uin));
        localFollowRequest.account_type.set(2);
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        localNewIntent.setObserver(new hhv(paramContext, paramQQAppInterface, paramPublicAccountInfo, paramEqqDetail, paramSessionInfo, paramString));
        paramQQAppInterface.startServlet(localNewIntent);
      }
      try
      {
        if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
          a(2131364484, paramPublicAccountInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, "follow exit");
        }
        do
        {
          return;
          if (paramEqqDetail != null)
          {
            bool = paramEqqDetail.hasIvrAbility();
            if (paramEqqDetail.followType != 0)
            {
              i1 = 1;
              break;
            }
            i1 = 0;
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("CrmUtils", 2, "Both PublicAccountInfo and EqqDetail is NULL!");
        return;
        label318:
        c(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    QQProgressDialog localQQProgressDialog = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio2(), ts=" + System.currentTimeMillis());
    }
    if ((paramSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString.equals("800095554")))
    {
      paramSessionInfo = new Bundle();
      paramSessionInfo.putString("businessName", "");
      paramSessionInfo.putString("uin", "2015243621");
      paramSessionInfo.putString("from_where", "old_yuantong");
      C2BUtils.a(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    for (;;)
    {
      return;
      Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject == null)
        {
          localObject = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
          if (localObject != null)
          {
            localObject = ((EqqDetailDataManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
            if (localObject == null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("IVR_TS_CrmUtils", 4, ">>>begin getDetail, ts=" + System.currentTimeMillis());
              }
              if ((paramContext instanceof Activity)) {
                localQQProgressDialog = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131492908));
              }
              if (localQQProgressDialog != null) {
                localQQProgressDialog.setCanceledOnTouchOutside(true);
              }
              if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, "sendDetailInfoRequest");
              }
              localObject = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
              ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
              localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
              localGetEqqDetailInfoRequest.version.set(2);
              localGetEqqDetailInfoRequest.seqno.set(0);
            }
          }
        }
      }
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new hhu(paramContext, paramQQAppInterface, localQQProgressDialog, paramSessionInfo, paramString));
        paramQQAppInterface.startServlet((NewIntent)localObject);
        try
        {
          if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing())) {
            continue;
          }
          a(2131364484, localQQProgressDialog);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
        a(paramQQAppInterface, paramContext, paramSessionInfo, null, (EqqDetail)localObject, paramString);
        return;
        a(paramContext, 2131364487);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
        return;
        a(paramQQAppInterface, paramContext, paramSessionInfo, (PublicAccountInfo)localObject, null, paramString);
        return;
        a(paramContext, 2131364487);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, BusinessObserver paramBusinessObserver)
  {
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (!a(paramQQAppInterface, paramString, paramInt))
    {
      paramContext = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
      paramContext.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(2);
      localGetEqqDetailInfoRequest.seqno.set(0);
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramString));
      paramContext.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      paramContext.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!jdField_a_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1024;
    localSessionInfo.d = paramString2;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    a(paramQQAppInterface, paramContext, localSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio1(), ts=" + System.currentTimeMillis());
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1024;
    localSessionInfo.d = paramString1;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString2;
    a(paramQQAppInterface, paramContext, localSessionInfo, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    ThreadManager.a().post(new hht(paramQQAppInterface, paramEqqDetail));
  }
  
  public static boolean a()
  {
    boolean bool = true;
    new VcSystemInfo();
    VcSystemInfo.a();
    int i1 = VcSystemInfo.f();
    long l1 = VcSystemInfo.c();
    int i2 = Build.VERSION.SDK_INT;
    if ((i1 < 3) || (l1 / 1000L < 800L) || (i2 < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "User don't support sharp!");
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "app is null or uin is empty");
      }
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if (paramInt == 1024)
    {
      Manager localManager = paramQQAppInterface.getManager(55);
      if (localManager != null)
      {
        if (((PublicAccountDataManager)localManager).c(paramString) != null) {}
        for (bool1 = true;; bool1 = true)
        {
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CrmUtils", 2, String.format("Check %s isContainUinInfo end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool1) }));
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(68);
          if (paramQQAppInterface == null) {
            break label190;
          }
          if (((EqqDetailDataManager)paramQQAppInterface).a(paramString) == null) {
            break label159;
          }
        }
        label159:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      label190:
      if (QLog.isColorLevel())
      {
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
          }
        }
      }
    }
  }
  
  public static boolean a(EqqDetail paramEqqDetail)
  {
    return (paramEqqDetail != null) && (paramEqqDetail.followType == 1);
  }
  
  public static boolean a(PublicAccountInfo paramPublicAccountInfo)
  {
    return (paramPublicAccountInfo != null) && (paramPublicAccountInfo.extendType == 2);
  }
  
  public static boolean a(String paramString)
  {
    if (!BmqqSegmentUtil.a(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        if ((l1 >= 2852000000L) && (l1 <= 2852199999L)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (NumberFormatException paramString) {}
    }
    return false;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramQQAppInterface.getManager(55);
      str = paramString;
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject == null) {
          break label52;
        }
        str = paramString;
        if (((PublicAccountInfo)localObject).extendType == 2) {
          str = ((PublicAccountInfo)localObject).name;
        }
      }
    }
    label52:
    do
    {
      do
      {
        return str;
        paramQQAppInterface = paramQQAppInterface.getManager(68);
        str = paramString;
      } while (paramQQAppInterface == null);
      paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
      str = paramString;
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.name;
  }
  
  private static void b(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    if (paramQQProgressDialog != null)
    {
      paramQQProgressDialog.b(paramInt);
      paramQQProgressDialog.show();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    if (localObject == null) {}
    for (localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = ((TicketManager)localObject).getStweb(paramQQAppInterface.a()))
    {
      new QQToastNotifier(paramContext).a(2131370024, paramContext.getResources().getDimensionPixelSize(2131492908), 0, 1);
      return;
    }
    paramString1 = String.format("http://ptlogin2.qq.com/qidian_client?pt_clientver=5428&pt_src=1&clientuin=%s&clientkey=%s&keyindex=19&jump=30&kfuin=%s&kfext=%s&buildver=1.0.0.0&inter=1&_wv=1027", new Object[] { paramQQAppInterface.a(), localObject, paramString1, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "enterLightTalk() url = " + paramString1);
    }
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("uin", paramQQAppInterface.a());
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("hide_more_button", true);
    paramContext.startActivity(paramString2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache");
    }
    EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
    if (localEqqDetailDataManager != null) {
      localEqqDetailDataManager.a(paramEqqDetail);
    }
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache exit");
    }
  }
  
  private static void b(QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).c(paramString);
      if ((localObject != null) && (((PublicAccountInfo)localObject).extendType == 2)) {
        return true;
      }
    }
    paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
    return (paramQQAppInterface != null) && (paramQQAppInterface.a(paramString) != null);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>hasIvrAbility(), ts=" + l1);
    }
    boolean bool2;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "app is null or uin is empty");
      }
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if (paramInt == 1024)
    {
      Object localObject = paramQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject != null) {}
        for (bool1 = ((PublicAccountInfo)localObject).hasIvrAbility();; bool1 = paramQQAppInterface.hasIvrAbility())
        {
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("Check %s hasIvrAbility end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool1) }));
          }
          long l2 = System.currentTimeMillis();
          bool2 = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("IVR_TS_CrmUtils", 4, "<<<hasIvrAbility(), ts=" + l2);
          QLog.d("IVR_TS_CrmUtils", 4, String.format("hasIvrAbility(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(68);
          if (paramQQAppInterface == null) {
            break label303;
          }
          paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
          if (paramQQAppInterface == null) {
            break label272;
          }
        }
        label272:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      label303:
      if (QLog.isColorLevel())
      {
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
          }
        }
      }
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>startVideo(), ts=" + System.currentTimeMillis());
    }
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    if ((paramQQAppInterface.d()) && (str != null) && (str.equals(paramQQAppInterface.a().f()))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004628", "0X8004628", 0, 0, "", "", "", "");
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1008) {
        paramSessionInfo.jdField_a_of_type_Int = 1024;
      }
      PlusPanelUtils.a(paramQQAppInterface, paramContext, paramSessionInfo, true, paramString, null);
      return;
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!BmqqSegmentUtil.a(paramString)) {
      return false;
    }
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString);
    boolean bool;
    if ((localFriends == null) || (-1 == localFriends.cSpecialFlag))
    {
      ((ContactFacade)paramQQAppInterface.getManager(53)).a().b(paramString);
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (1 == localFriends.cSpecialFlag) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return true;
          }
        }
        else
        {
          paramQQAppInterface = paramQQAppInterface.getManager(68);
          if ((paramQQAppInterface != null) && (((EqqDetailDataManager)paramQQAppInterface).a(paramString) != null)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\eqq\CrmUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */