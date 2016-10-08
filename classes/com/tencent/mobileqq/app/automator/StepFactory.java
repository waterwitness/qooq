package com.tencent.mobileqq.app.automator;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.ActivityDAUReport;
import com.tencent.mobileqq.app.automator.step.AfterSyncMsg;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.automator.step.CheckAuthCode;
import com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo;
import com.tencent.mobileqq.app.automator.step.CheckHotSpotNode;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.app.automator.step.CheckUpgrade;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep;
import com.tencent.mobileqq.app.automator.step.GetCheckUpdate;
import com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.app.automator.step.GetDiscussionInfo;
import com.tencent.mobileqq.app.automator.step.GetDonateFriends;
import com.tencent.mobileqq.app.automator.step.GetEmosmList;
import com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile;
import com.tencent.mobileqq.app.automator.step.GetFunCallData;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;
import com.tencent.mobileqq.app.automator.step.GetNearbyRecommender;
import com.tencent.mobileqq.app.automator.step.GetNumRedStep;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck;
import com.tencent.mobileqq.app.automator.step.GetRecommendEmotionStep;
import com.tencent.mobileqq.app.automator.step.GetRedpointStep;
import com.tencent.mobileqq.app.automator.step.GetSecMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetSecMsgNewSeq;
import com.tencent.mobileqq.app.automator.step.GetSelfInfo;
import com.tencent.mobileqq.app.automator.step.GetSelfPendantId;
import com.tencent.mobileqq.app.automator.step.GetSig;
import com.tencent.mobileqq.app.automator.step.GetSplashConfig;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg;
import com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep;
import com.tencent.mobileqq.app.automator.step.GetWebViewAuthorize;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.app.automator.step.MigrateDataToRecentCall;
import com.tencent.mobileqq.app.automator.step.MonitorSocketDownload;
import com.tencent.mobileqq.app.automator.step.PPCLoginAuth;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import com.tencent.mobileqq.app.automator.step.QQUpdateVersion;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.ReportQQWifiInfo;
import com.tencent.mobileqq.app.automator.step.SecDetectInit;
import com.tencent.mobileqq.app.automator.step.SendThemeAuth;
import com.tencent.mobileqq.app.automator.step.SetLogOn;
import com.tencent.mobileqq.app.automator.step.SignatureScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityUpdate;
import com.tencent.mobileqq.app.automator.step.StartSmartDevice;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateIcon;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.app.automator.step.VideoConfigUpdate;
import com.tencent.mobileqq.app.automator.step.VipCheckGift;
import com.tencent.mobileqq.app.automator.step.VipRequestMessageRoamPassword;
import com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum;
import com.tencent.mobileqq.app.automator.step.getLocalRedtouchStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vashealth.StepServiceAsync;

public class StepFactory
{
  public static final int A = 28;
  public static final int B = 29;
  public static final int C = 30;
  public static final int D = 31;
  public static final int E = 32;
  public static final int F = 33;
  public static final int G = 34;
  public static final int H = 35;
  public static final int I = 36;
  public static final int J = 37;
  public static final int K = 38;
  public static final int L = 39;
  public static final int M = 40;
  public static final int N = 41;
  public static final int O = 42;
  public static final int P = 43;
  public static final int Q = 44;
  public static final int R = 45;
  public static final int S = 46;
  public static final int T = 47;
  public static final int U = 48;
  public static final int V = 49;
  public static final int W = 50;
  public static final int X = 51;
  public static final int Y = 52;
  public static final int Z = 53;
  public static final int a = 2;
  public static final String a = "[";
  public static final int[] a;
  public static final String[] a;
  public static final int aA = 79;
  public static final int aB = 80;
  public static final int aC = 81;
  public static final int aD = 82;
  public static final int aE = 83;
  public static final int aF = 84;
  public static final int aG = 85;
  public static final int aH = 86;
  public static final int aI = 87;
  public static final int aJ = 88;
  public static final int aK = 89;
  public static final int aL = 90;
  public static final int aM = 91;
  public static final int aN = 92;
  private static final int aO = 1;
  public static final int aa = 54;
  public static final int ab = 55;
  public static final int ac = 56;
  public static final int ad = 57;
  public static final int ae = 58;
  public static final int af = 59;
  public static final int ag = 60;
  public static final int ah = 61;
  public static final int ai = 62;
  public static final int aj = 63;
  public static final int ak = 64;
  public static final int al = 65;
  public static final int am = 66;
  public static final int an = 67;
  public static final int ao = 68;
  public static final int ap = 69;
  public static final int aq = 70;
  public static final int ar = 71;
  public static final int as = 72;
  public static final int at = 73;
  public static final int au = 74;
  public static final int av = 75;
  public static final int aw = 76;
  public static final int ax = 76;
  public static final int ay = 77;
  public static final int az = 78;
  public static final int b = 3;
  public static final String b = "]";
  public static final int c = 4;
  public static final String c = "{";
  public static final int d = 5;
  public static final String d = "}";
  public static final int e = 6;
  public static final String e = "{15,18,21,55,57,24}";
  public static final int f = 7;
  public static final String f = "{[13,16],19,21,55,57,86,23,43,33,58,40,89}";
  public static final int g = 8;
  public static final String g = "{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}";
  public static final int h = 9;
  public static final String h = "{[11,12,14],17,20,21,22}";
  public static final int i = 10;
  public static final String i = "{{4,3,5,6},41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54}";
  public static final int j = 11;
  private static final String j = "{}";
  public static final int k = 12;
  private static final String k = "{91}";
  public static final int l = 13;
  private static final String l = "{53,61,36,49,63,65,59,73,72,80,87,31}";
  public static final int m = 14;
  private static final String m = "{}";
  public static final int n = 15;
  private static final String n = "{4,3,5,6}";
  public static final int o = 16;
  private static final String o = "[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83]";
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 24;
  public static final int x = 25;
  public static final int y = 26;
  public static final int z = 27;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 12, 24, 168 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "{}", "{91}", "{53,61,36,49,63,65,59,73,72,80,87,31}", "{}" };
  }
  
  public static int a(LinearGroup paramLinearGroup, boolean paramBoolean)
  {
    if ("{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(paramLinearGroup.b)) {
      if (paramLinearGroup.j <= 4) {}
    }
    while (paramBoolean)
    {
      return 1;
      return 0;
    }
    return 0;
  }
  
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("createStepGroup: " + str);
    }
    int i1 = -1;
    if (str.startsWith("{"))
    {
      paramString = new LinearGroup();
      paramString.c = str;
    }
    for (;;)
    {
      paramString.a = paramAutomator;
      paramString.h = i1;
      if (i1 < 0) {
        break;
      }
      paramString.b = paramString.getClass().getSimpleName();
      return paramString;
      if (str.startsWith("["))
      {
        paramString = new ParallGroup();
        paramString.c = str;
      }
      else
      {
        i1 = Integer.parseInt(str);
        switch (i1)
        {
        case 46: 
        default: 
          paramString = new AsyncStep();
          break;
        case 2: 
          paramString = new ActiveAccount();
          break;
        case 3: 
        case 7: 
        case 8: 
          paramString = new UpdateFriend();
          break;
        case 4: 
        case 9: 
          paramString = new UpdateTroop();
          break;
        case 5: 
          paramString = new UpdateDiscuss();
          break;
        case 6: 
        case 10: 
          paramString = new CheckPublicAccount();
          break;
        case 12: 
        case 13: 
          paramString = new RegisterPush();
          break;
        case 17: 
        case 18: 
        case 19: 
          paramString = new RegisterProxy();
          break;
        case 20: 
          paramString = new GetGeneralSettings();
          break;
        case 21: 
          paramString = new GetTroopAssisMsg();
          break;
        case 14: 
        case 15: 
        case 16: 
          paramString = new InitBeforeSyncMsg();
          break;
        case 11: 
          paramString = new GetSubAccount();
          break;
        case 22: 
        case 23: 
        case 24: 
          paramString = new AfterSyncMsg();
          break;
        case 25: 
          paramString = new MigrateDataToRecentCall();
          break;
        case 26: 
          paramString = new GetEmoticonWhenNoFile();
          break;
        case 27: 
          paramString = new GetSelfPendantId();
          break;
        case 28: 
          paramString = new StartSecurityScan();
          break;
        case 29: 
          paramString = new GetEmosmList();
          break;
        case 30: 
          paramString = new GetSelfInfo();
          break;
        case 31: 
          paramString = new EcShopFirstRunMsgConfigs();
          break;
        case 32: 
          paramString = new GetSecMsgConfigs();
          break;
        case 33: 
          paramString = new GetSecMsgNewSeq();
          break;
        case 34: 
          paramString = new CheckFriendsLastLoginInfo();
          break;
        case 35: 
          paramString = new GetSig();
          break;
        case 36: 
          paramString = new StartSecurityUpdate();
          break;
        case 37: 
          paramString = new GetWebViewAuthorize();
          break;
        case 38: 
          paramString = new GetDiscussionInfo();
          break;
        case 39: 
          paramString = new SetLogOn();
          break;
        case 40: 
          paramString = new GetQZoneFeedCount();
          break;
        case 41: 
          paramString = new GetConfig();
          break;
        case 42: 
        case 43: 
          paramString = new GetCheckUpdate();
          break;
        case 44: 
          paramString = new GetSplashConfig();
          break;
        case 69: 
          paramString = new GetFunCallData();
          break;
        case 45: 
          paramString = new SendThemeAuth();
          break;
        case 47: 
          paramString = new GetTbsSwitchInfo();
          break;
        case 48: 
          paramString = new CheckUpgrade();
          break;
        case 88: 
          paramString = new CheckAuthCode();
          break;
        case 49: 
          paramString = new CleanCache();
          break;
        case 50: 
          paramString = new CheckMsgCount();
          break;
        case 72: 
          paramString = new TimerCheckMsgCount();
          break;
        case 52: 
          paramString = new GetClubContentUpdateStatus();
          break;
        case 53: 
          paramString = new VideoConfigUpdate();
          break;
        case 54: 
          paramString = new TimerChecker();
          break;
        case 92: 
          paramString = new AutomatorFinish();
          break;
        case 51: 
          paramString = new SignatureScan();
          break;
        case 55: 
        case 56: 
          paramString = new GetJoinedHotChatListStep();
          break;
        case 57: 
          paramString = new GetJoinedHotChatListMessageStep();
          break;
        case 58: 
          paramString = new GetTroopRedPointInfoStep();
          break;
        case 62: 
          paramString = new UpdateIcon();
          break;
        case 59: 
          paramString = new ReportQQWifiInfo();
          break;
        case 60: 
          paramString = new VipCheckGift();
          break;
        case 61: 
          paramString = new VipRequestMessageRoamPassword();
          break;
        case 63: 
          paramString = new ReportDevice();
          break;
        case 64: 
          paramString = new StartSmartDevice();
          break;
        case 65: 
          paramString = new WeiyunCheckAlbum();
          break;
        case 66: 
          paramString = new ChatBackgroundAuth();
          break;
        case 67: 
          paramString = new GetRecommendEmotionStep();
          break;
        case 70: 
          paramString = new PPCLoginAuth();
          break;
        case 68: 
          paramString = new GetNumRedStep();
          break;
        case 71: 
          paramString = new QQUpdateVersion();
          break;
        case 73: 
          paramString = new MonitorSocketDownload();
          break;
        case 74: 
          paramString = new GetQZoneFeeds();
          break;
        case 75: 
          paramString = new GetBigEmoticonStep();
          break;
        case 76: 
          paramString = new GetNearbyRecommender();
          break;
        case 77: 
          paramString = new StepServiceAsync();
          break;
        case 78: 
          paramString = new GetQZonePhotoGuideCheck();
          break;
        case 79: 
          paramString = new SecDetectInit();
          break;
        case 80: 
          paramString = new ActivityDAUReport();
          break;
        case 81: 
          paramString = new CheckHotSpotNode();
          break;
        case 82: 
          paramString = new LoginWelcomeRequest();
          break;
        case 83: 
          paramString = new QQComicStep();
          break;
        case 84: 
          paramString = new GetDonateFriends();
          break;
        case 85: 
        case 86: 
          paramString = new GetRedpointStep();
          break;
        case 87: 
          paramString = new ReadInJoyDAUReport();
          break;
        case 89: 
          paramString = new getLocalRedtouchStep();
          break;
        case 90: 
          paramString = new GetCommonUsedSystemEmojiStep();
          break;
        case 91: 
          paramString = new DailyReport();
        }
      }
    }
    paramString.b = str;
    return paramString;
  }
  
  public static boolean a(LinearGroup paramLinearGroup)
  {
    if ("{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(paramLinearGroup.b)) {
      if (paramLinearGroup.j < 3) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!"{[13,16],19,21,55,57,86,23,43,33,58,40,89}".equals(paramLinearGroup.b)) {
          break;
        }
      } while (paramLinearGroup.j >= 1);
      return false;
    } while (("{15,18,21,55,57,24}".equals(paramLinearGroup.b)) || (!"{[11,12,14],17,20,21,22}".equals(paramLinearGroup.b)) || (paramLinearGroup.j >= 2));
    return false;
  }
  
  public static boolean b(LinearGroup paramLinearGroup)
  {
    return (!"{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(paramLinearGroup.b)) || (paramLinearGroup.j > 5);
  }
  
  public static boolean c(LinearGroup paramLinearGroup)
  {
    if ("{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(paramLinearGroup.b)) {
      if (paramLinearGroup.j <= 4) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (!"{[13,16],19,21,55,57,86,23,43,33,58,40,89}".equals(paramLinearGroup.b)) {
            break;
          }
        } while (paramLinearGroup.j > 2);
        return false;
        if (!"{15,18,21,55,57,24}".equals(paramLinearGroup.b)) {
          break;
        }
      } while (paramLinearGroup.j > 2);
      return false;
    } while ((!"{[11,12,14],17,20,21,22}".equals(paramLinearGroup.b)) || (paramLinearGroup.j > 2));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\StepFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */