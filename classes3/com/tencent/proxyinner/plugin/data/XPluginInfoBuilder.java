package com.tencent.proxyinner.plugin.data;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;

public class XPluginInfoBuilder
{
  public static Intent setInitParam(String paramString, Intent paramIntent, InitParam paramInitParam)
  {
    Intent localIntent = paramIntent;
    if ((paramIntent == null) || (paramIntent == null)) {
      localIntent = new Intent();
    }
    try
    {
      localIntent.putExtra("sourceVersion", paramInitParam.mSourceVersion);
      localIntent.putExtra("sourceChannelId", paramInitParam.mChannelId);
      localIntent.putExtra("", paramInitParam.mSourceId);
      localIntent.putExtra("hosttype", String.valueOf(paramInitParam.mChannelType));
      localIntent.putExtra("pluginid", paramString);
      return localIntent;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return localIntent;
  }
  
  public static Intent setLauncherParam(Intent paramIntent, RunPluginParams paramRunPluginParams)
  {
    Intent localIntent = paramIntent;
    if ((paramIntent == null) || (paramIntent == null)) {
      localIntent = new Intent();
    }
    localIntent.putExtra("vastype", paramRunPluginParams.mVasType);
    localIntent.putExtra("authtype", paramRunPluginParams.mAuthType);
    localIntent.putExtra("appid", paramRunPluginParams.mAppid);
    localIntent.putExtra("fromid", paramRunPluginParams.mFromId);
    localIntent.putExtra("roomid", paramRunPluginParams.mRoomId);
    localIntent.putExtra("authkey", paramRunPluginParams.mAuthKey);
    localIntent.putExtra("authid", paramRunPluginParams.mAuthId);
    localIntent.putExtra("vasname", paramRunPluginParams.mVasName);
    localIntent.putExtra("nickname", paramRunPluginParams.mNickName);
    localIntent.putExtra("roomname", paramRunPluginParams.mRoomName);
    localIntent.putExtra("age", paramRunPluginParams.mAge);
    localIntent.putExtra("gender", paramRunPluginParams.mGender);
    localIntent.putExtra("birthyear", paramRunPluginParams.mBirthYear);
    localIntent.putExtra("birthmonth", paramRunPluginParams.mBirthMonth);
    localIntent.putExtra("birthday", paramRunPluginParams.mBirthDay);
    localIntent.putExtra("addrCountry", paramRunPluginParams.mAddr_country);
    localIntent.putExtra("addrProv", paramRunPluginParams.mAddr_province);
    localIntent.putExtra("addrCity", paramRunPluginParams.mAddr_city);
    localIntent.putExtra("hometownCountry", paramRunPluginParams.mHometown_country);
    localIntent.putExtra("hometownProv", paramRunPluginParams.mHometown_province);
    localIntent.putExtra("hometownCity", paramRunPluginParams.mHometown_city);
    localIntent.putExtra("launchername", paramRunPluginParams.mLauncherName);
    localIntent.putExtra("needconfirmnetwork", paramRunPluginParams.mNeedConfirmNetworkBeforeDownload);
    localIntent.putExtra("proxy_version", 3L);
    if (!TextUtils.isEmpty(paramRunPluginParams.vasSchema)) {
      localIntent.putExtra("vasschema", paramRunPluginParams.vasSchema);
    }
    if ((paramRunPluginParams.intent != null) && (paramRunPluginParams.intent.getExtras() != null)) {
      localIntent.putExtras(paramRunPluginParams.intent);
    }
    return localIntent;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\data\XPluginInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */