import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class sye
  extends Client.onRemoteRespObserver
{
  public sye(UiApiPlugin paramUiApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    String str3;
    String str1;
    Object localObject2;
    Object localObject3;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == UiApiPlugin.a(this.a).key))
    {
      str3 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localObject2 = paramBundle.getBundle("response");
      localObject3 = paramBundle.getBundle("request");
      if (localObject3 != null) {
        break label88;
      }
      QLog.e(UiApiPlugin.a, 1, "reqBundle is null, cmd is : " + str3);
    }
    label88:
    label578:
    label685:
    label712:
    for (;;)
    {
      return;
      Object localObject1 = ((Bundle)localObject3).getString("uin");
      String str2 = ((Bundle)localObject3).getString("action");
      int[] arrayOfInt = new int[5];
      tmp113_111 = arrayOfInt;
      tmp113_111[0] = 1;
      tmp117_113 = tmp113_111;
      tmp117_113[1] = 41;
      tmp122_117 = tmp117_113;
      tmp122_117[2] = 75;
      tmp127_122 = tmp122_117;
      tmp127_122[3] = 21;
      tmp132_127 = tmp127_122;
      tmp132_127[4] = 58;
      tmp132_127;
      if (this.a.mRuntime == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mRuntime == null");
        }
      }
      else
      {
        Activity localActivity = this.a.mRuntime.a();
        if (("checkRelation".equals(str3)) && (localActivity != null) && (localObject1 != null))
        {
          paramBundle = null;
          int k;
          int i;
          if ("openSocialCard".equals(str2))
          {
            k = ((Bundle)localObject3).getInt("source");
            paramBundle = ((Bundle)localObject3).getString("sign");
            int j = ((Bundle)localObject3).getInt("nProfileEntryType");
            i = j;
            if (j == 0) {
              i = 999;
            }
            localObject3 = this.a.mRuntime.a();
            if ((((Bundle)localObject2).getBoolean("result", false)) && (localObject3 != null) && (!((AppInterface)localObject3).a().equals(localObject1)))
            {
              paramBundle = new Intent(localActivity, FriendProfileCardActivity.class);
              localObject1 = new ProfileActivity.AllInOne((String)localObject1, arrayOfInt[k]);
              ((ProfileActivity.AllInOne)localObject1).g = i;
              paramBundle.putExtra("AllInOne", (Parcelable)localObject1);
              localActivity.startActivity(paramBundle);
              paramBundle = "{\"result\": 0}";
            }
          }
          for (;;)
          {
            if ((TextUtils.isEmpty(str1)) || (paramBundle == null)) {
              break label712;
            }
            this.a.callJs(str1, new String[] { paramBundle });
            return;
            localObject1 = new ProfileActivity.AllInOne((String)localObject1, arrayOfInt[k]);
            if (!TextUtils.isEmpty(paramBundle)) {
              ((ProfileActivity.AllInOne)localObject1).b = ChatActivityUtils.a(paramBundle);
            }
            ((ProfileActivity.AllInOne)localObject1).g = i;
            paramBundle = new Intent(localActivity, NearbyPeopleProfileActivity.class);
            paramBundle.putExtra("param_mode", 3);
            paramBundle.putExtra("AllInOne", (Parcelable)localObject1);
            break;
            if ("openStrangerAIO".equals(str2)) {
              if (((Bundle)localObject2).getBoolean("result", false))
              {
                paramBundle = new Intent(localActivity, ChatActivity.class);
                paramBundle.putExtra("uin", (String)localObject1);
                paramBundle.putExtra("uintype", 0);
                localActivity.startActivity(paramBundle);
                paramBundle = "{\"result\": 0}";
              }
              else
              {
                i = ((Bundle)localObject3).getInt("sourceType");
                paramBundle = ((Bundle)localObject3).getString("sign");
                boolean bool = ((Bundle)localObject3).getBoolean("isGroup");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("uin", (String)localObject1);
                if ((bool) || (!TextUtils.isEmpty(paramBundle)))
                {
                  if (bool)
                  {
                    ((Intent)localObject2).putExtra("open_chatfragment", true);
                    ((Intent)localObject2).setClass(localActivity, SplashActivity.class);
                    i = 1;
                    if (((Bundle)localObject3).getInt("fromAIO") >= 1) {
                      ((Intent)localObject2).addFlags(67108864);
                    }
                    ((Intent)localObject2).putExtra("uintype", i);
                    if (i != 1001) {
                      break label685;
                    }
                    ((Intent)localObject2).putExtra("rich_accost_sig", ChatActivityUtils.a(paramBundle));
                  }
                  for (;;)
                  {
                    localActivity.startActivity((Intent)localObject2);
                    paramBundle = "{\"result\": 0}";
                    break;
                    ((Intent)localObject2).setClass(localActivity, ChatActivity.class);
                    i = new int[] { 0, 1001, 1010, 1, 1020 }[i];
                    break label578;
                    if (i == 1010) {
                      ((Intent)localObject2).putExtra("rich_date_sig", ChatActivityUtils.a(paramBundle));
                    }
                  }
                }
                paramBundle = "{\"result\": -2, \"message\":\"Can't send message to a stranger without sign!\"}";
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */