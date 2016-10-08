package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgPool;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import vrl;
import vrm;
import vrn;

public class TroopRewardMgr
  implements Manager
{
  public static final int a = 1080;
  public static final String a = ".troop.troop_reward";
  public static final int b = 1920;
  public static final String b = "https://pay.qun.qq.com/cgi-bin/group_pay/reward/pay_reward";
  public static int c = 1080;
  public static final String c = "http://pay.qun.qq.com/cgi-bin/group_pay/reward/create_reward";
  public static int d = 1920;
  public static final String d = "http://pay.qun.qq.com/cgi-bin/group_pay/reward/front_pay_cb";
  public static final String e = "http://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=";
  public static final String f = "http://qun.qq.com/qunpay/reward/detail.html?_wv=16778255&_bid=2313";
  public static final String g = "http://qun.qq.com/qunpay/reward/read_terms.html?_wv=1039&platform=14";
  public static final String h = "http://qun.qq.com/qunpay/reward/history.html?_wv=1039&_bid=2313";
  public static final String i = "http://jubao.qq.com/uniform_impeach/impeach_entry?_wv=1";
  private static final String j = "http://pay.qun.qq.com/cgi-bin/group_pay/reward/";
  private static final String k = "https://pay.qun.qq.com/cgi-bin/group_pay/reward/";
  QQAppInterface a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopRewardMgr(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private MessageForTroopReward a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    MessageForTroopReward localMessageForTroopReward = new MessageForTroopReward();
    localMessageForTroopReward.selfuin = this.a.a();
    localMessageForTroopReward.frienduin = paramString1;
    localMessageForTroopReward.senderuin = this.a.a();
    localMessageForTroopReward.msgUid = MessageUtils.a(paramInt1);
    localMessageForTroopReward.msg = MsgUtils.a(null);
    localMessageForTroopReward.msgtype = 63488;
    localMessageForTroopReward.isread = true;
    localMessageForTroopReward.issend = 1;
    localMessageForTroopReward.istroop = 1;
    localMessageForTroopReward.time = MessageCache.a();
    localMessageForTroopReward.rewardCreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localMessageForTroopReward.rewardMoney = paramInt2;
    localMessageForTroopReward.rewardContent = paramString2;
    localMessageForTroopReward.rewardType = paramInt3;
    localMessageForTroopReward.mediaPath = paramString3;
    localMessageForTroopReward.rewardStatus = 10000;
    localMessageForTroopReward.rewardSeq = localMessageForTroopReward.uniseq;
    localMessageForTroopReward.prewrite();
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "buildTroopRewardMgr success");
    }
    return localMessageForTroopReward;
  }
  
  private String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "PayReward parsePublishableJson jsonObject is null");
      }
      return null;
    }
    int m = -1;
    if (paramJSONObject.has("ec")) {
      m = paramJSONObject.optInt("ec");
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "PayReward parsePublishableJson errorCode is " + m);
    }
    if (m == 0) {
      return paramJSONObject.optString("token_id");
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramString, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = "http://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=" + paramString;
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("url", paramQQAppInterface);
    if (paramBoolean) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "openNewReward:" + paramQQAppInterface);
    }
  }
  
  private boolean a(JSONObject paramJSONObject, MessageForTroopReward paramMessageForTroopReward)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "CreateReward parsePublishableJson jsonObject is null");
      }
      return false;
    }
    int m = -1;
    if (paramJSONObject.has("ec")) {
      m = paramJSONObject.optInt("ec");
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "CreateReward parsePublishableJson errorCode is " + m);
    }
    if (m == 0)
    {
      paramMessageForTroopReward.rewardId = paramJSONObject.optString("reward_id");
      paramMessageForTroopReward.resq = new TroopBarShortVideoUploadUtil.ApplyUploadRsp();
      paramMessageForTroopReward.resq.a = paramJSONObject.optString("serverip");
      paramMessageForTroopReward.resq.b = paramJSONObject.optString("serverport");
      paramMessageForTroopReward.resq.c = paramJSONObject.optString("checkkey");
      paramMessageForTroopReward.resq.e = paramJSONObject.optString("uin");
      paramMessageForTroopReward.resq.f = paramJSONObject.optString("vid");
      paramMessageForTroopReward.resq.g = paramJSONObject.optString("fid");
      m = paramJSONObject.optInt("obj_timeout");
      paramMessageForTroopReward.vid = paramMessageForTroopReward.resq.f;
      paramMessageForTroopReward.expiredTimeStamp = (m + (int)(System.currentTimeMillis() / 1000L));
      return true;
    }
    return false;
  }
  
  public MessageForTroopReward a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (this.a.a(1) == null) {
      return null;
    }
    Object localObject1 = a(paramString1, 1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof MessageForTroopReward)) || (!paramString2.equals(((MessageForTroopReward)localObject2).rewardId)));
    }
    for (localObject1 = (MessageForTroopReward)localObject2;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        paramString1 = this.a.a().a(paramString1, 1, new int[] { 63488 }).iterator();
        while (paramString1.hasNext())
        {
          localObject2 = (MessageRecord)paramString1.next();
          if ((localObject2 instanceof MessageForTroopReward))
          {
            localObject2 = (MessageForTroopReward)localObject2;
            ((MessageForTroopReward)localObject2).parse();
            if (paramString2.equals(((MessageForTroopReward)localObject2).rewardId)) {
              return (MessageForTroopReward)localObject2;
            }
          }
        }
      }
      return (MessageForTroopReward)localObject1;
    }
  }
  
  protected String a(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  public String a(String paramString, long paramLong)
  {
    if (this.a.a(1) == null) {
      return null;
    }
    paramString = a(paramString, 1);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if (((localMessageRecord instanceof MessageForTroopReward)) && (paramLong == ((MessageForTroopReward)localMessageRecord).rewardSeq)) {
          return ((MessageForTroopReward)localMessageRecord).rewardId;
        }
      }
    }
    return null;
  }
  
  protected List a(String paramString, int paramInt)
  {
    synchronized (MsgPool.a(this.a.getAccount()).a(paramString, paramInt))
    {
      paramString = (List)MsgPool.a(this.a.getAccount()).a().get(a(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1.rewardNum = paramInt1;
      paramString1.rewardStatus = paramInt2;
      a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "update Msg success,rewardId:" + paramString1.rewardId);
      }
    }
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if (paramMessageForTroopReward != null)
    {
      paramMessageForTroopReward.prewrite();
      this.a.a().a(paramMessageForTroopReward.frienduin, 1, paramMessageForTroopReward.uniseq, paramMessageForTroopReward.msgData);
    }
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward, TroopRewardMgr.OnCreateRewardListener paramOnCreateRewardListener)
  {
    String str = this.a.f();
    Object localObject = (TicketManager)this.a.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("gc", paramMessageForTroopReward.frienduin);
      localBundle.putString("client", "1");
      localBundle.putString("reward_type", String.valueOf(paramMessageForTroopReward.rewardType));
      localBundle.putString("reward_money", String.valueOf(paramMessageForTroopReward.rewardMoney));
      localBundle.putString("reward_text", paramMessageForTroopReward.rewardContent);
      localBundle.putString("seq", String.valueOf(paramMessageForTroopReward.rewardSeq));
      if (paramMessageForTroopReward.rewardType == 1)
      {
        localBundle.putString("clear_pic_url", paramMessageForTroopReward.rewardUrl);
        localBundle.putString("blur_pic_url", paramMessageForTroopReward.blurUrl);
      }
      for (;;)
      {
        localBundle.putString("bkn", String.valueOf(TroopUtils.b((String)localObject)));
        localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
        localBundle.putString("Referer", "http://pay.qun.qq.com/");
        localBundle.putString("Host", "pay.qun.qq.com");
        localHashMap.put("BUNDLE", localBundle);
        localHashMap.put("CONTEXT", this.a.a().getApplicationContext());
        new HttpWebCgiAsyncTask2("http://pay.qun.qq.com/cgi-bin/group_pay/reward/create_reward", "POST", new vrn(this, paramMessageForTroopReward, paramOnCreateRewardListener), 1000, null).a(localHashMap);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_reward", 2, "createReward:http://pay.qun.qq.com/cgi-bin/group_pay/reward/create_reward");
        }
        return;
        if (paramMessageForTroopReward.rewardType == 2)
        {
          localBundle.putString("size", String.valueOf(paramMessageForTroopReward.videoSize));
          localBundle.putString("video_duration", String.valueOf(paramMessageForTroopReward.videoDuration));
          localBundle.putString("sha", paramMessageForTroopReward.sha);
          localBundle.putString("md5", paramMessageForTroopReward.md5);
          localBundle.putString("platform", "android");
          localBundle.putString("title", paramMessageForTroopReward.title);
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_reward", 2, "insertAIOMsg troop uin empty");
      }
      return;
    }
    paramString1 = a(paramString1, Math.abs(new Random().nextInt()), paramInt1, paramString2, paramString3, paramInt2);
    this.a.a().a(paramString1, this.a.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = (TicketManager)this.a.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramString2);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("result", paramString1);
      localBundle.putString("client", "1");
      localBundle.putString("bkn", String.valueOf(TroopUtils.b((String)localObject)));
      localBundle.putString("Cookie", "uin=" + paramString2 + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "http://pay.qun.qq.com/");
      localBundle.putString("Host", "pay.qun.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.a.a().getApplicationContext());
      new HttpWebCgiAsyncTask2("http://pay.qun.qq.com/cgi-bin/group_pay/reward/front_pay_cb", "POST", new vrm(this), 1000, null).a(localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "payCallback:http://pay.qun.qq.com/cgi-bin/group_pay/reward/front_pay_cb");
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, TroopRewardMgr.OnPayRewardListener paramOnPayRewardListener)
  {
    String str = this.a.f();
    Object localObject = (TicketManager)this.a.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("gc", paramString1);
      localBundle.putString("client", "1");
      localBundle.putString("reward_id", paramString2);
      localBundle.putString("bkn", String.valueOf(TroopUtils.b((String)localObject)));
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "http://pay.qun.qq.com/");
      localBundle.putString("Host", "pay.qun.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.a.a().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://pay.qun.qq.com/cgi-bin/group_pay/reward/pay_reward", "POST", new vrl(this, paramString2, paramString1, paramOnPayRewardListener), 1000, null).a(localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "payReward:https://pay.qun.qq.com/cgi-bin/group_pay/reward/pay_reward");
      }
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopRewardMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */