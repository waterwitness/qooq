package com.tencent.common.app;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StoryAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.runtime.NowRunTime;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.buscard.BuscardHelper;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.groupvideo.GroupVideoHelper;
import cooperation.huangye.HYHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkHelper;
import cooperation.qqdataline.DatalineHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qqhotspot.QQHotSpotAcitivtyHelper;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.secmsg.SecMsgHelper;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.thirdpay.ThirdPayManager;
import cooperation.troop.TroopPluginHelper;
import cooperation.weiyun.WeiyunHelper;
import mqq.app.AppRuntime;

public class AppInterfaceFactory
{
  static final String[] a = { ":tool", ":peak" };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    Object localObject2 = null;
    String str = paramBaseApplicationImpl.getPackageName();
    Object localObject1;
    if (str.equals(paramString)) {
      localObject1 = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    do
    {
      do
      {
        return (AppRuntime)localObject1;
        localObject1 = localObject2;
      } while (paramString.equals(str + ":msf"));
      localObject1 = localObject2;
    } while (paramString.equals(str + ":notifypush"));
    if (paramString.equals(str + ":video")) {
      return new VideoAppInterface(paramBaseApplicationImpl, "video");
    }
    if (paramString.equals(str + ":qzone")) {
      return QZoneHelper.a(paramBaseApplicationImpl, "qzone");
    }
    if (paramString.equals(str + ":qzonevideo")) {
      return QZoneHelper.b(paramBaseApplicationImpl, "qzonevideo");
    }
    if (paramString.equals(str + ":qzonelive")) {
      return QZoneHelper.b(paramBaseApplicationImpl);
    }
    if (paramString.equals(str + ":web")) {
      return new BrowserAppInterface(paramBaseApplicationImpl, "web");
    }
    if (paramString.equals(str + ":openSdk")) {
      return new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
    }
    if (paramString.equals(str + ":photoedit"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":zebra")) {
      return new PluginRuntime();
    }
    if (paramString.equals(str + ":demoji"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":map")) {
      return new QQMapActivity.MapRuntime();
    }
    if (paramString.equals(str + ":weiyun"))
    {
      paramBaseApplicationImpl = WeiyunHelper.a(paramBaseApplicationImpl);
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":secmsg"))
    {
      paramBaseApplicationImpl = SecMsgHelper.a(paramBaseApplicationImpl);
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qwallet"))
    {
      paramBaseApplicationImpl = QWalletHelper.a(paramBaseApplicationImpl, "qwallet");
      ReportController.a((PluginRuntime)paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qqfav")) {
      return QfavHelper.a(paramBaseApplicationImpl);
    }
    if (paramString.equals(str + ":qlink")) {
      return QlinkHelper.a(paramBaseApplicationImpl, "qlink");
    }
    if (paramString.equals(str + ":cardpay"))
    {
      paramString = new PluginRuntime();
      ReportController.a(paramString);
      paramBaseApplicationImpl = ThirdPayManager.a(paramBaseApplicationImpl, "cardpay");
      if (paramBaseApplicationImpl != null) {
        break label1381;
      }
      paramBaseApplicationImpl = paramString;
    }
    label1381:
    for (;;)
    {
      return paramBaseApplicationImpl;
      if (paramString.equals(str + ":qqwifi"))
      {
        paramBaseApplicationImpl = QQWiFiHelper.a(paramBaseApplicationImpl, "qqwifi");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":qqwifiditu"))
      {
        paramBaseApplicationImpl = QQWiFiHelper.b(paramBaseApplicationImpl, "qqwifiditu");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":dataline")) {
        return DatalineHelper.a(paramBaseApplicationImpl, "dataline");
      }
      if (paramString.equals(str + ":huangye")) {
        return HYHelper.a(paramBaseApplicationImpl, "huangye");
      }
      if (paramString.equals(str + ":smartdevice")) {
        return SmartDevicePluginLoader.a(paramBaseApplicationImpl, "smartdevice");
      }
      if (paramString.equals(str + ":buscard"))
      {
        paramBaseApplicationImpl = BuscardHelper.a(paramBaseApplicationImpl, "buscard");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":readinjoy"))
      {
        paramBaseApplicationImpl = ReadInJoyHelper.a(paramBaseApplicationImpl, "readinjoy");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":dingdong")) {
        return DingdongPluginHelper.a(paramBaseApplicationImpl, "dingdong");
      }
      if (paramString.equals(str + ":qqhotspot"))
      {
        paramBaseApplicationImpl = QQHotSpotAcitivtyHelper.a(paramBaseApplicationImpl, "qqhotspot");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":troopmemcard"))
      {
        paramBaseApplicationImpl = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_member_card_plugin.apk");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":troopmanage"))
      {
        paramBaseApplicationImpl = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_manage_plugin.apk");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":pluginbridge"))
      {
        paramBaseApplicationImpl = BridgeHelper.a(paramBaseApplicationImpl, "pluginbridge");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":groupvideo")) {
        return GroupVideoHelper.a(paramBaseApplicationImpl, "groupvideo");
      }
      if (paramString.equals(str + ":tool"))
      {
        paramBaseApplicationImpl = new ToolAppRuntime();
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":story")) {
        return new StoryAppInterface(paramBaseApplicationImpl, "story");
      }
      if (paramString.equals(str + ":peak"))
      {
        paramBaseApplicationImpl = new ToolRuntimePeak();
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":now")) {
        return new NowRunTime(paramBaseApplicationImpl, "now");
      }
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
  }
  
  public static boolean a()
  {
    return a(BaseApplicationImpl.processName);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j = a.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ((paramString != null) && (paramString.endsWith(a[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\AppInterfaceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */