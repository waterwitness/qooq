package com.tencent.mobileqq.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.WebCgiWhiteListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReqBatch;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRspBatch;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import tut;
import tuu;

public class ProfileCardCheckUpdate
  implements CheckUpdateItemInterface
{
  public static final int a = 1000277;
  public static final String a = "ProfileCard.ProfileCardCheckUpdate";
  public static final String b = "cardTemplateVersion";
  private static final int c = 1;
  public static final String c = "cardTemplateServerVersion";
  private static final int d = 2;
  public static final String d = "cardTemplateServerUrl";
  private static final int e = 4;
  public static final String e = "profileFuncallVersion";
  private static final int f = 8;
  public static final String f = "specialcareVersion";
  private static final int g = 16;
  public static final String g = "specialcareCheckUpdateTime";
  public static final String h = "WebviewCGIWhitelistVersion";
  public static final String i = "WebviewCGIWhitelistCheckUpdateTime";
  private static final String j = "nextCheckUpdateTimeMillis";
  private static final String k = "nextCheckLabelUpdateTimeMillis";
  private static final String l = "profileLabelVersion";
  private static final String m = "nextCheckFuncallUpdateTimeMillis";
  public QQAppInterface a;
  int b;
  
  public ProfileCardCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 0;
    this.a = paramQQAppInterface;
  }
  
  private SummaryCardUpdate.SUpdateReq a(int paramInt, String paramString)
  {
    SummaryCardUpdate.SUpdateReq localSUpdateReq = new SummaryCardUpdate.SUpdateReq();
    localSUpdateReq.cmd.set(paramInt);
    localSUpdateReq.uin.set(this.a.getLongAccountUin());
    localSUpdateReq.version.set(paramString);
    localSUpdateReq.client_version.set("6.5.5");
    localSUpdateReq.platform.set(109);
    if (paramInt == 5) {
      localSUpdateReq.appname.set("fun_call");
    }
    return localSUpdateReq;
  }
  
  private List a(String paramString)
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigJsonData length is :" + paramString.length());
      }
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int i2 = paramString.length();
      int n = 0;
      while (n < i2)
      {
        Object localObject2 = paramString.optJSONObject(n);
        localObject1 = new ProfileLabelTypeInfo();
        ((ProfileLabelTypeInfo)localObject1).typeId = ((JSONObject)localObject2).optString("id");
        ((ProfileLabelTypeInfo)localObject1).typeName = ((JSONObject)localObject2).optString("name");
        ((ProfileLabelTypeInfo)localObject1).typeInfo = ((JSONObject)localObject2).optString("classinfo");
        localObject2 = ((JSONObject)localObject2).optJSONArray("taglist");
        int i3 = ((JSONArray)localObject2).length();
        int i1 = 0;
        while (i1 < i3)
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i1);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = ((ProfileLabelTypeInfo)localObject1).typeId;
          ((ProfileLabelTypeInfo)localObject1).labels.add(localProfileLabelInfo);
          i1 += 1;
        }
        localArrayList.add(localObject1);
        n += 1;
      }
      localObject1 = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "downloadLabelConfigJson the new typeList size =" + localArrayList.size());
        localObject1 = localArrayList;
      }
    }
    return (List)localObject1;
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigTempFile is exist :" + paramFile.exists());
    }
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramFile.exists())
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int n = localFileInputStream.read(arrayOfByte, 0, 4096);
        if (n == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, n);
      }
      localFileInputStream.close();
    }
    try
    {
      paramFile.renameTo(new File(ProfileCardUtil.a(this.a.getApplication())));
      paramFile = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
      if ((paramFile != null) && (paramFile.length() > 0)) {
        a(paramFile);
      }
      return;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramString);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      FileUtils.a(new File(BaseApplicationImpl.a().getFilesDir(), "labelList").getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
  }
  
  private boolean b()
  {
    return false;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    try
    {
      long l1 = BaseApplicationImpl.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getLong("specialcareCheckUpdateTime", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendSpecialCareUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label189;
        }
      }
      label189:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        if (l2 <= l1)
        {
          boolean bool3 = new File(BaseApplicationImpl.a().getApplicationContext().getFilesDir(), "http://i.gtimg.cn/club/moblie/special_sound/new_config.json").exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean d()
  {
    try
    {
      long l1 = this.a.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label146;
        }
      }
      label146:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool);
        if (l2 <= l1) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    try
    {
      long l1 = this.a.getPreferences().getLong("nextCheckLabelUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendCheckLabelUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label186;
        }
      }
      label186:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        localObject = new File(ProfileCardUtil.a(this.a.getApplication()));
        if (l2 <= l1)
        {
          boolean bool3 = ((File)localObject).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    try
    {
      Object localObject1 = this.a.getPreferences();
      long l1 = ((SharedPreferences)localObject1).getLong("WebviewCGIWhitelistCheckUpdateTime", 0L);
      localObject1 = ((SharedPreferences)localObject1).getString("whitelist_config_json_url", "");
      long l2 = System.currentTimeMillis();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject2 = new StringBuilder().append("isSendCheckWhiteListUpdate nextCheckUpdateTime=").append((String)localObject2).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label187;
        }
      }
      label187:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        if (l2 <= l1)
        {
          boolean bool3 = TextUtils.isEmpty((CharSequence)localObject1);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a()
  {
    Object localObject1;
    if (!a()) {
      localObject1 = null;
    }
    String str1;
    String str2;
    ReqItem localReqItem;
    int i1;
    do
    {
      return (ReqItem)localObject1;
      localObject1 = this.a.getPreferences();
      long l1 = System.currentTimeMillis();
      ((SharedPreferences)localObject1).edit().putLong("nextCheckUpdateTimeMillis", l1 + 3600000L).commit();
      str1 = ((SharedPreferences)localObject1).getString("cardTemplateVersion", "0");
      str2 = ((SharedPreferences)localObject1).getString("profileLabelVersion", "0");
      Object localObject2 = ((SharedPreferences)localObject1).getString("profileFuncallVersion", "0");
      String str3 = ((SharedPreferences)localObject1).getString("WebviewCGIWhitelistVersion", "0");
      localReqItem = new ReqItem();
      localReqItem.eServiceID = 122;
      localObject1 = new SummaryCardUpdate.SUpdateReqBatch();
      SummaryCardUpdate.SUpdateReq localSUpdateReq;
      if ((this.b & 0x1) != 0)
      {
        localSUpdateReq = a(3, str1);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.b & 0x2) != 0)
      {
        localSUpdateReq = a(4, str2);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.b & 0x4) != 0)
      {
        localSUpdateReq = a(5, (String)localObject2);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.b & 0x8) != 0)
      {
        localObject2 = a(5, (String)localObject2);
        ((SummaryCardUpdate.SUpdateReq)localObject2).appname.set("special_remind");
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add((MessageMicro)localObject2);
      }
      if ((this.b & 0x10) != 0)
      {
        localObject2 = a(6, str3);
        ((SummaryCardUpdate.SUpdateReq)localObject2).appname.set("white_list");
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add((MessageMicro)localObject2);
      }
      localObject1 = ((SummaryCardUpdate.SUpdateReqBatch)localObject1).toByteArray();
      int n = localObject1.length;
      i1 = n + 4;
      localObject2 = new byte[i1];
      System.arraycopy(EndianUtil.b(i1), 0, localObject2, 0, 4);
      System.arraycopy(localObject1, 0, localObject2, 4, n);
      localReqItem.vecParam = ((byte[])localObject2);
      localObject1 = localReqItem;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "getCheckUpdateItemData uin=" + this.a.getLongAccountUin() + ",cardVersion=" + str1 + "labelVersion=" + str2 + ",client_version=" + "6.5.5" + ",dataLen=" + i1);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int n = paramRespItem.cResult;
      Object localObject = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "handleCheckUpdateItemData result=" + n + ",dataLen=" + localObject.length);
      }
      if (n == 2) {
        for (;;)
        {
          try
          {
            if (localObject.length <= 4) {
              break;
            }
            n = (int)PkgTools.a((byte[])localObject, 0);
            paramRespItem = new byte[n - 4];
            PkgTools.a(paramRespItem, 0, (byte[])localObject, 4, n - 4);
            localObject = new SummaryCardUpdate.SUpdateRspBatch();
            ((SummaryCardUpdate.SUpdateRspBatch)localObject).mergeFrom(paramRespItem);
            if (((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.size() < 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRspBatch have no rsp");
              return;
            }
            paramRespItem = ((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.get().iterator();
            if (!paramRespItem.hasNext()) {
              break;
            }
            localObject = (SummaryCardUpdate.SUpdateRsp)paramRespItem.next();
            if (localObject == null) {
              continue;
            }
            n = ((SummaryCardUpdate.SUpdateRsp)localObject).cmd.get();
            if (n == 3)
            {
              e((SummaryCardUpdate.SUpdateRsp)localObject);
              continue;
            }
            if (n != 4) {
              break label242;
            }
          }
          catch (Exception paramRespItem)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate Exception msg=" + paramRespItem.getMessage());
            }
            paramRespItem.printStackTrace();
            return;
          }
          d((SummaryCardUpdate.SUpdateRsp)localObject);
          continue;
          label242:
          if (n == 5)
          {
            if ((((SummaryCardUpdate.SUpdateRsp)localObject).appname != null) && (((SummaryCardUpdate.SUpdateRsp)localObject).appname.get().equals("special_remind"))) {
              b((SummaryCardUpdate.SUpdateRsp)localObject);
            } else {
              a((SummaryCardUpdate.SUpdateRsp)localObject);
            }
          }
          else if (n == 6) {
            c((SummaryCardUpdate.SUpdateRsp)localObject);
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
    }
  }
  
  public void a(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int n = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int i1 = paramSUpdateRsp.interv.get();
    paramSUpdateRsp.buff.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleFunCallRsp data code=" + n + ",version=" + str1 + ",url=" + str2 + ",interval=" + i1);
    }
    if (n == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate code == 0" + i1);
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_FUN_CALL", 100, n, this.a.a(), 1000277, "[资料卡]趣味来电增量更新失败", true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.a(new tuu(this, paramString1, paramString2), 8, null, false);
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool3 = d();
    boolean bool4 = e();
    boolean bool5 = b();
    boolean bool6 = c();
    boolean bool2 = f();
    int i1 = this.b;
    if (bool3)
    {
      n = 1;
      this.b = (n | i1);
      i1 = this.b;
      if (!bool4) {
        break label163;
      }
      n = 2;
      label63:
      this.b = (n | i1);
      i1 = this.b;
      if (!bool5) {
        break label168;
      }
      n = 4;
      label82:
      this.b = (n | i1);
      i1 = this.b;
      if (!bool6) {
        break label173;
      }
      n = 8;
      label102:
      this.b = (n | i1);
      i1 = this.b;
      if (!bool2) {
        break label178;
      }
    }
    label163:
    label168:
    label173:
    label178:
    for (int n = 16;; n = 0)
    {
      this.b = (n | i1);
      if ((bool3) || (bool4) || (bool5) || (bool6) || (bool2)) {
        bool1 = true;
      }
      return bool1;
      n = 0;
      break;
      n = 0;
      break label63;
      n = 0;
      break label82;
      n = 0;
      break label102;
    }
  }
  
  public void b(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int n = paramSUpdateRsp.code.get();
    String str2 = paramSUpdateRsp.version.get();
    String str1 = paramSUpdateRsp.url.get();
    int i1 = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSpecialCareRsp data code=" + n + ",version=" + str2 + ",url=" + str1 + ",interval=" + i1);
    }
    if (n == 0)
    {
      paramSUpdateRsp = BaseApplicationImpl.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      str2 = paramSUpdateRsp.getString("specialcare_config", "");
      if (i1 >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = i1 * 1000;
        paramSUpdateRsp.edit().putLong("specialcareCheckUpdateTime", l1 + l2).commit();
      }
      if ((str1 != null) && (!str1.equals(str2)))
      {
        paramSUpdateRsp.edit().putString("specialcare_config", str1).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_one", true).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_two", true).commit();
        paramSUpdateRsp = new QvipSpecialSoundManager(BaseApplicationImpl.getContext(), this.a);
        if (paramSUpdateRsp != null) {
          ThreadManager.a(new tut(this, paramSUpdateRsp), 5, null, true);
        }
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_SPECIAL_REMIND", 100, n, this.a.a(), 1000277, "[资料卡]特别关心更新失败", true);
  }
  
  public void c(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int n = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int i1 = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleWhiteListRsp data code=" + n + ",version=" + str1 + ",url=" + str2 + ",interval=" + i1);
    }
    if (n == 0)
    {
      paramSUpdateRsp = this.a.getPreferences();
      if (i1 >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = i1 * 1000;
        paramSUpdateRsp.edit().putLong("WebviewCGIWhitelistCheckUpdateTime", l1 + l2).commit();
      }
      paramSUpdateRsp = paramSUpdateRsp.getString("whitelist_config_json_url", "");
      if ((!TextUtils.isEmpty(str2)) && ((TextUtils.isEmpty(paramSUpdateRsp)) || (!str2.equals(paramSUpdateRsp))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleWhiteListRsp start Download, oldUrl:" + paramSUpdateRsp);
        }
        new WebCgiWhiteListManager(BaseApplicationImpl.getContext(), this.a).a(str2, str1);
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_WHITE_LIST", 100, n, this.a.a(), 1000277, "[WebView]WebView页面CGI跳转白名单增量更新失败", true);
  }
  
  public void d(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int n = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int i1 = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryLabelRsp data code=" + n + ",version=" + str1 + ",url=" + str2 + ",interval=" + i1);
    }
    if (n == 0)
    {
      paramSUpdateRsp = this.a.getPreferences();
      if (i1 >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = i1 * 1000;
        paramSUpdateRsp.edit().putLong("nextCheckLabelUpdateTimeMillis", l1 + l2).commit();
      }
      if ((!paramSUpdateRsp.getString("profileLabelVersion", "0").equals(str1)) && (str2 != null)) {
        a(str2, str1);
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_SUMMARY_LABEL", 100, n, this.a.a(), 1000277, "[资料卡]资料卡标签增量更新失败", true);
  }
  
  public void e(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int n = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int i1 = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryUpdateRsp data code=" + n + ",version=" + str1 + ",url=" + str2 + ",interval=" + i1);
    }
    if (n == 0)
    {
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (i1 >= 0))
      {
        paramSUpdateRsp = this.a.getPreferences().edit();
        paramSUpdateRsp.putLong("nextCheckUpdateTimeMillis", System.currentTimeMillis() + i1 * 1000);
        paramSUpdateRsp.putString("cardTemplateServerUrl", str2);
        paramSUpdateRsp.putString("cardTemplateServerVersion", str1);
        paramSUpdateRsp.commit();
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_SUMMARY_UPDATE", 100, n, this.a.a(), 1000277, "[资料卡]资料卡增量更新失败", true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ProfileCardCheckUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */