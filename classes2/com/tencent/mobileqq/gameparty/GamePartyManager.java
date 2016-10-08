package com.tencent.mobileqq.gameparty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent.Callback;
import com.tencent.mobileqq.ark.DispatchTask;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Vector;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import ssm;
import ssn;
import sso;
import ssp;
import ssq;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_TurnOverMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_UpdateTeamMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.InviteSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class GamePartyManager
  implements ArkAppCenterCheckEvent.Callback, Manager
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a = "com.tencent.qqopen.teamup";
  public static int b = 0;
  public static final String b = "android.intent.action.gameparty.notify";
  public static final int c = 0;
  public static final String c = "android.intent.action.gameparty.refresh";
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  private static final String f;
  public static final int g = 4;
  private static final String g = "GamePartyManger";
  public static final int h = 5;
  private static final String h = "gamePartyInfo";
  public static final int i = 6;
  private static final String i = "uinType";
  public static final int j = 7;
  private static final String j = "toUin";
  public static final int k = 8;
  private static final String k = "teamId";
  public static final int l = 9;
  private static final String l = "currentMember";
  private static final String m = "maxMember";
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected Handler a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GamePartyNotifyCenter jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter;
  public Vector a;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String d;
  public String e;
  public int m;
  public int n;
  private String n;
  public int o;
  public int p;
  private int q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    f = GamePartyManager.class.getSimpleName();
    jdField_b_of_type_Int = 3600;
  }
  
  public GamePartyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new ssm(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.q = -1;
    this.m = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.o = jdField_b_of_type_Int;
    this.jdField_b_of_type_Long = 0L;
    this.e = "";
    this.p = 0;
    Object localObject = paramQQAppInterface.a();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplication)localObject).getSharedPreferences("GamePartyManger", i1);
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gamePartyInfo" + paramQQAppInterface.a(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        this.d = new JSONObject((String)localObject).getString("teamId");
        a("http://openmobile.qq.com/gameteam/get_team_context?uin=" + paramQQAppInterface.a(), new ssn(this));
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter = ((GamePartyNotifyCenter)a());
        ArkAppCenterCheckEvent.a("com.tencent.qqopen.teamup", this);
        return;
        i1 = 0;
      }
      catch (JSONException paramQQAppInterface)
      {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  private void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage, boolean paramBoolean)
  {
    int i4 = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    String str3 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str4 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    String str1 = paramGameTeam_TurnOverMessage.str_teamId.get();
    int i1 = paramGameTeam_TurnOverMessage.uint32_currentCount.get();
    int i2 = paramGameTeam_TurnOverMessage.uint32_totalCount.get();
    long l1 = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
    String str2 = paramGameTeam_TurnOverMessage.str_leaderUin.get();
    int i3 = paramGameTeam_TurnOverMessage.uin32_leaderStatus.get();
    Object localObject = null;
    if (paramGameTeam_TurnOverMessage.InviteSourceList.has()) {
      localObject = paramGameTeam_TurnOverMessage.InviteSourceList.get();
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(str4);
    boolean bool1;
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.d)) && (this.d.equals(str1)))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_TurnOver_BlueBar, self = " + bool2 + ", expired = " + paramBoolean + ", inParty = " + this.jdField_a_of_type_Boolean + ", inSameParty = " + bool1);
      }
      if (!paramBoolean) {
        break label235;
      }
      if (bool1) {
        b();
      }
    }
    label235:
    label399:
    label466:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    bool1 = false;
                    break;
                    switch (paramGameTeam_TurnOverMessage.actionType.get())
                    {
                    default: 
                      return;
                    case 1: 
                      if (bool2)
                      {
                        this.q = b(i4);
                        this.jdField_n_of_type_JavaLangString = str3;
                        this.d = str1;
                        this.m = i1;
                        this.jdField_n_of_type_Int = i2;
                        this.jdField_a_of_type_Long = l1;
                        this.e = str2;
                        this.p = i3;
                        a();
                        return;
                      }
                      break;
                    }
                  } while (!bool1);
                  this.m = i1;
                  this.jdField_n_of_type_Int = i2;
                  this.p = i3;
                  this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
                  this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
                  return;
                  if (!bool2) {
                    break label399;
                  }
                } while (!bool1);
                b();
                return;
              } while (!bool1);
              this.m = i1;
              this.jdField_n_of_type_Int = i2;
              this.p = i3;
              this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
              this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
              return;
            } while (!bool1);
            b();
            return;
            if (!bool2) {
              break label466;
            }
          } while (!bool1);
          b();
          return;
        } while (!bool1);
        this.m = i1;
        this.jdField_n_of_type_Int = i2;
        this.p = i3;
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
        return;
      } while (!bool2);
      this.q = b(i4);
      this.jdField_n_of_type_JavaLangString = str3;
      this.jdField_a_of_type_JavaUtilVector.clear();
      if (localObject == null)
      {
        this.jdField_a_of_type_JavaUtilVector.add(new GamePartyManager.Session(this, this.q, this.jdField_n_of_type_JavaLangString));
        this.d = str1;
        this.m = i1;
        this.jdField_n_of_type_Int = i2;
        this.jdField_a_of_type_Long = l1;
        this.e = str2;
        this.p = i3;
        a();
        return;
      }
      paramGameTeam_TurnOverMessage = ((List)localObject).iterator();
      while (paramGameTeam_TurnOverMessage.hasNext())
      {
        localObject = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
        if ((((SubMsgType0xaa.InviteSource)localObject).type.has()) && (((SubMsgType0xaa.InviteSource)localObject).src.has()))
        {
          i4 = ((SubMsgType0xaa.InviteSource)localObject).type.get();
          localObject = ((SubMsgType0xaa.InviteSource)localObject).src.get();
          if ((i4 >= 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localObject = new GamePartyManager.Session(this, b(i4), (String)localObject);
            this.jdField_a_of_type_JavaUtilVector.add(localObject);
          }
        }
      }
    } while ((!bool2) || (!bool1));
    this.jdField_a_of_type_JavaUtilVector.clear();
    if (localObject == null) {
      this.jdField_a_of_type_JavaUtilVector.add(new GamePartyManager.Session(this, b(i4), str3));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
      return;
      paramGameTeam_TurnOverMessage = ((List)localObject).iterator();
      while (paramGameTeam_TurnOverMessage.hasNext())
      {
        localObject = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
        if ((((SubMsgType0xaa.InviteSource)localObject).type.has()) && (((SubMsgType0xaa.InviteSource)localObject).src.has()))
        {
          i1 = ((SubMsgType0xaa.InviteSource)localObject).type.get();
          localObject = ((SubMsgType0xaa.InviteSource)localObject).src.get();
          if ((i1 >= 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localObject = new GamePartyManager.Session(this, b(i1), (String)localObject);
            this.jdField_a_of_type_JavaUtilVector.add(localObject);
          }
        }
      }
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 3000;
  }
  
  private void b(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    int i1 = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    Object localObject2 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str1 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    int i2 = paramGameTeam_TurnOverMessage.actionType.get();
    String str2 = paramGameTeam_TurnOverMessage.str_teamId.get();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(str1);
    long l1 = NetConnInfoCenter.getServerTime();
    int i3 = b(i1);
    if (bool) {
      paramGameTeam_TurnOverMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372535);
    }
    for (;;)
    {
      switch (i2)
      {
      case 5: 
      default: 
        return;
        switch (i3)
        {
        default: 
          paramGameTeam_TurnOverMessage = str1;
          break;
        case 0: 
          paramGameTeam_TurnOverMessage = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (String)localObject2, 0, 0);
          break;
        case 1: 
          paramGameTeam_TurnOverMessage = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (String)localObject2, 1, 0);
          break;
        case 3000: 
          paramGameTeam_TurnOverMessage = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (String)localObject2, 2, 0);
        }
        break;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372531);
    for (;;)
    {
      String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372536);
      paramGameTeam_TurnOverMessage = paramGameTeam_TurnOverMessage + (String)localObject1 + str3;
      localObject1 = (MessageForGrayTips)MessageRecordFactory.a(63487);
      ((MessageForGrayTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (String)localObject2, str1, paramGameTeam_TurnOverMessage, l1, 63487, i3, 0L);
      str1 = String.format("http://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str2, Integer.valueOf(i1), localObject2 });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 1);
      ((Bundle)localObject2).putString("key_action_DATA", str1);
      ((Bundle)localObject2).putString("key_a_action_DATA", str1);
      ((MessageForGrayTips)localObject1).addHightlightItem(paramGameTeam_TurnOverMessage.indexOf(str3), paramGameTeam_TurnOverMessage.length(), (Bundle)localObject2);
      ((MessageForGrayTips)localObject1).isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "", "2000", "2011", "0", false);
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372532);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372533);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372534);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.q = -1;
    this.jdField_n_of_type_JavaLangString = "";
    this.d = "";
    this.m = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.e = "";
    this.p = 0;
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  public Object a(int paramInt, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = Boolean.valueOf(false);
          paramObject = (MessageForArkApp)paramObject;
          localObject1 = localObject2;
        } while (paramObject == null);
        localObject1 = localObject2;
      } while (((MessageForArkApp)paramObject).ark_app_message == null);
      try
      {
        paramObject = new JSONObject(((MessageForArkApp)paramObject).ark_app_message.metaList).getJSONObject("teamup").getJSONObject("invitation");
        paramInt = ((JSONObject)paramObject).optInt("forward");
        paramObject = ((JSONObject)paramObject).optString("leader");
        switch (paramInt)
        {
        case 0: 
          return Boolean.valueOf(false);
        }
      }
      catch (JSONException paramObject)
      {
        ((JSONException)paramObject).printStackTrace();
        return localObject2;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramObject)) {
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
      return Boolean.valueOf(true);
      localObject3 = (Bundle)paramObject;
      localObject1 = localObject2;
    } while (localObject3 == null);
    paramInt = ((Bundle)localObject3).getInt("uintype");
    paramObject = ((Bundle)localObject3).getString("uin");
    localObject2 = ((Bundle)localObject3).getString("forward_ark_app_name");
    String str1 = ((Bundle)localObject3).getString("forward_ark_app_view");
    String str2 = ((Bundle)localObject3).getString("forward_ark_app_desc");
    String str3 = ((Bundle)localObject3).getString("forward_ark_app_ver");
    String str4 = ((Bundle)localObject3).getString("forward_ark_app_prompt");
    localObject1 = ((Bundle)localObject3).getString("forward_ark_app_meta");
    localObject2 = new ArkAppMessage(str4, (String)localObject2, str2, str1, str3, (String)localObject1, ((Bundle)localObject3).getString("forward_ark_app_config"), ((Bundle)localObject3).getString("forward_ark_app_compat"));
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      localObject3 = ((JSONObject)localObject1).getJSONObject("teamup").getJSONObject("misc");
      ((JSONObject)localObject3).put("forwardUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((JSONObject)localObject3).put("forwardDstType", a(paramInt));
      ((JSONObject)localObject3).put("forwardDstUin", paramObject);
      ((ArkAppMessage)localObject2).metaList = ((JSONObject)localObject1).toString();
      return localObject2;
    }
    catch (JSONException paramObject)
    {
      ((JSONException)paramObject).printStackTrace();
      return localObject2;
    }
    return localObject2;
  }
  
  public Observable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter = new GamePartyNotifyCenter();
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    long l2 = this.o;
    long l3 = NetConnInfoCenter.getServerTime();
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = l3;
    }
    long l1 = l2;
    if (l3 > this.jdField_a_of_type_Long) {
      l1 = l2 - (l3 - this.jdField_a_of_type_Long);
    }
    if (l1 > 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(1));
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1 * 1000L + 30000L);
    }
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt1, int paramInt2)
  {
    if (paramSessionInfo != null)
    {
      this.q = paramSessionInfo.jdField_a_of_type_Int;
      this.jdField_n_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    if (paramString != null) {
      this.d = paramString;
    }
    if (paramInt1 >= 0) {
      this.m = paramInt1;
    }
    if (paramInt2 >= 0) {
      this.jdField_n_of_type_Int = paramInt2;
    }
  }
  
  public void a(String paramString, GamePartyManager.AsyncRequestCallback paramAsyncRequestCallback)
  {
    ThreadManager.a(new ssq(this, paramString, paramAsyncRequestCallback), 5, null, false);
  }
  
  protected void a(SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, boolean paramBoolean)
  {
    if ((!paramGameTeam_StartGameMessage.str_appid.has()) || (!paramGameTeam_StartGameMessage.str_packageName.has()) || (!paramGameTeam_StartGameMessage.str_gamedata.has()) || (!paramGameTeam_StartGameMessage.str_title.has()) || (!paramGameTeam_StartGameMessage.str_summary.has()) || (!paramGameTeam_StartGameMessage.str_picUrl.has()) || (!paramGameTeam_StartGameMessage.uint64_buildTeamTime.has()) || (!paramGameTeam_StartGameMessage.uint64_createMsgTime.has()) || (!paramGameTeam_StartGameMessage.uint32_platformType.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_StartGame, parse param failed");
      }
      return;
    }
    Object localObject = paramGameTeam_StartGameMessage.str_gamedata.get().split("_");
    long l2;
    long l1;
    if (localObject.length > 3)
    {
      localObject = localObject[3];
      l2 = paramGameTeam_StartGameMessage.uint64_buildTeamTime.get();
      l1 = NetConnInfoCenter.getServerTime();
      if (l1 <= l2) {
        break label318;
      }
    }
    label318:
    for (l1 -= l2;; l1 = l2 - l1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_StartGame, createTime = " + l2);
      }
      if ((paramGameTeam_StartGameMessage.uint32_platformType.get() & 0x2) != 2) {
        break;
      }
      localObject = "[\"" + (String)localObject + "\"]";
      try
      {
        String str = URLEncoder.encode((String)localObject, "utf-8");
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      a("http://openmobile.qq.com/gameteam/get_team_info?uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "&team_list=" + (String)localObject, new sso(this, l1, paramGameTeam_StartGameMessage, l2, paramBoolean));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(f, 2, "handlePushMsg_StartGame, parse gamedata failed");
      return;
    }
  }
  
  protected void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    if ((!paramGameTeam_TurnOverMessage.uint32_sessionType.has()) || (!paramGameTeam_TurnOverMessage.actionType.has()) || (!paramGameTeam_TurnOverMessage.str_sourceUin.has()) || (!paramGameTeam_TurnOverMessage.str_actionUin.has()) || (!paramGameTeam_TurnOverMessage.str_teamId.has()) || (!paramGameTeam_TurnOverMessage.uint32_currentCount.has()) || (!paramGameTeam_TurnOverMessage.uint32_totalCount.has()) || (!paramGameTeam_TurnOverMessage.uint64_buildTeamTime.has()) || (!paramGameTeam_TurnOverMessage.uint64_createMsgTime.has()) || (!paramGameTeam_TurnOverMessage.str_leaderUin.has()) || (!paramGameTeam_TurnOverMessage.uin32_leaderStatus.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_TurnOver, parse param failed");
      }
      return;
    }
    long l1 = paramGameTeam_TurnOverMessage.uint64_createMsgTime.get();
    try
    {
      if (l1 < this.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "handlePushMsg_TurnOver, msgTime before updateTime, drop it");
        }
        return;
      }
    }
    finally {}
    this.jdField_b_of_type_Long = l1;
    long l2 = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
    l1 = NetConnInfoCenter.getServerTime();
    if (l1 > l2) {}
    for (l1 -= l2;; l1 = l2 - l1)
    {
      if (paramGameTeam_TurnOverMessage.uint32_expire.has())
      {
        this.o = paramGameTeam_TurnOverMessage.uint32_expire.get();
        if (this.o <= 0) {
          this.o = jdField_b_of_type_Int;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_TurnOver, createTime = " + l2 + ", expire = " + this.o + ", deltaTime = " + l1);
      }
      if (l1 >= this.o) {
        break;
      }
      a(paramGameTeam_TurnOverMessage, false);
      b(paramGameTeam_TurnOverMessage);
      return;
    }
    a(paramGameTeam_TurnOverMessage, true);
  }
  
  protected void a(SubMsgType0xaa.GameTeam_UpdateTeamMessage paramGameTeam_UpdateTeamMessage)
  {
    if ((!paramGameTeam_UpdateTeamMessage.str_teamId.has()) || (!paramGameTeam_UpdateTeamMessage.uint32_status.has()) || (!paramGameTeam_UpdateTeamMessage.uint32_current_count.has()) || (!paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.has()) || (!paramGameTeam_UpdateTeamMessage.uint64_createMsgTime.has()) || (!paramGameTeam_UpdateTeamMessage.str_leaderUin.has()) || (!paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.has())) {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_UpdateTeam, parse param failed");
      }
    }
    for (;;)
    {
      return;
      long l1 = paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.get();
      String str = paramGameTeam_UpdateTeamMessage.str_teamId.get();
      int i1 = paramGameTeam_UpdateTeamMessage.uint32_status.get();
      int i2 = paramGameTeam_UpdateTeamMessage.uint32_current_count.get();
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "handlePushMsg_UpdateTeam, teamId = " + str + ", status = " + i1 + ", member = " + i2 + ", createTime = " + l1);
      }
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("team_id", str);
        ((JSONObject)localObject).put("status", i1);
        ((JSONObject)localObject).put("member_count", i2);
        localObject = ((JSONObject)localObject).toString();
        DispatchTask.a().a(new ssp(this, (String)localObject));
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.gameparty.notify");
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((Intent)localObject).putExtra("teamId", str);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject);
        i2 = paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.get();
        if ((!this.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.d)) || (!this.d.equals(str))) {
          continue;
        }
        if (i1 >= 5)
        {
          b();
          return;
        }
        if ((i1 <= 0) || (this.p == i2)) {
          continue;
        }
        this.p = i2;
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(SubMsgType0xaa.MsgBody paramMsgBody, boolean paramBoolean)
  {
    if (!paramMsgBody.cmd.has()) {}
    label10:
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            break label10;
            break label10;
            do
            {
              return;
            } while ((paramMsgBody.cmd.get() != 1) || (!paramMsgBody.msg_gameTeamMsg.has()));
            paramMsgBody = (SubMsgType0xaa.GameTeam_MsgBody)paramMsgBody.msg_gameTeamMsg.get();
          } while (!paramMsgBody.uint32_GameTeamCmd.has());
          i1 = paramMsgBody.uint32_GameTeamCmd.get();
          if (i1 != 2000) {
            break;
          }
        } while (!paramMsgBody.msg_turnOverMessage.has());
        a((SubMsgType0xaa.GameTeam_TurnOverMessage)paramMsgBody.msg_turnOverMessage.get());
        return;
        if (i1 != 2001) {
          break;
        }
      } while (!paramMsgBody.msg_startGameMessage.has());
      a((SubMsgType0xaa.GameTeam_StartGameMessage)paramMsgBody.msg_startGameMessage.get(), paramBoolean);
      return;
    } while ((i1 != 2002) || (paramBoolean) || (!paramMsgBody.msg_updateTeamMessage.has()));
    a((SubMsgType0xaa.GameTeam_UpdateTeamMessage)paramMsgBody.msg_updateTeamMessage.get());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.e))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
        GamePartyManager.Session localSession;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localSession = (GamePartyManager.Session)localIterator.next();
        } while ((paramInt != localSession.jdField_a_of_type_Int) || (!paramString.equals(localSession.jdField_a_of_type_JavaLangString)));
        return true;
      }
      if ((paramInt == this.q) && (paramString.equals(this.jdField_n_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(3));
    }
    c();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void onDestroy()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Boolean) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("teamId", this.d);
        localEditor.putString("gamePartyInfo" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localJSONObject.toString());
        localEditor.commit();
        ArkAppCenterCheckEvent.a("com.tencent.qqopen.teamup");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      localEditor.putString("gamePartyInfo" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\gameparty\GamePartyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */