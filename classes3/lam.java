import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x5be.Oidb_0x5be.AppInfo;

public class lam
  implements View.OnClickListener
{
  public lam(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    Oidb_0x5be.AppInfo localAppInfo;
    int i;
    long l;
    if ((localObject instanceof Oidb_0x5be.AppInfo))
    {
      localAppInfo = (Oidb_0x5be.AppInfo)localObject;
      i = localAppInfo.uint32_open_type.get();
      l = localAppInfo.uint64_appid.get();
      switch (i)
      {
      default: 
        if (l == 1101236949L) {
          ReportController.b(this.a.app, "P_CliOper", "Grp_bulletin", "", "Grp_data", "Clk_grpbulletin", 0, 0, this.a.a.troopUin, "", "", "");
        }
        break;
      }
    }
    for (;;)
    {
      if (this.a.a != null)
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_data_appEntry", 0, 0, this.a.a.troopUin, "", "", "" + l);
        if (localAppInfo.int32_unread_num.get() != 0) {
          ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_data_appEntry_new", 0, 0, this.a.a.troopUin, "", "", "" + l);
        }
      }
      if (localAppInfo.int32_unread_num.get() != 0)
      {
        localAppInfo.int32_unread_num.set(0);
        ((TextView)paramView.findViewById(2131300631)).setVisibility(8);
      }
      return;
      localObject = new Intent(this.a, QQBrowserActivity.class);
      String str = localAppInfo.bytes_url.get().toStringUtf8();
      ((Intent)localObject).putExtra("url", ChatSettingForTroop.a(this.a, str, localAppInfo.uint64_appid.get()));
      ((Intent)localObject).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.startActivity((Intent)localObject);
      break;
      if (!this.a.a.isMember)
      {
        QQToast.a(this.a, 2131364732, 1).b(this.a.getTitleBarHeight());
        break;
      }
      this.a.a(localAppInfo.int32_unread_num.get());
      break;
      if (!this.a.a.isMember)
      {
        QQToast.a(this.a, 2131364732, 1).b(this.a.getTitleBarHeight());
        break;
      }
      ChatSettingForTroop.c(this.a, localAppInfo.int32_unread_num.get());
      break;
      if (l == 1105015724L)
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_talk", "", "grp_data", "Clk_talk", 0, 0, this.a.a.troopUin, "", "", "");
      }
      else
      {
        if (l == 1105324038L)
        {
          if (this.a.a.bOwner) {
            localObject = "1";
          }
          for (;;)
          {
            ReportController.b(this.a.app, "dc00899", "Grp_calendar", "", "set", "exp_clk", 0, 0, this.a.a.troopUin, "", (String)localObject, "");
            break;
            if (this.a.a.bAdmin) {
              localObject = "2";
            } else {
              localObject = "3";
            }
          }
        }
        if ((i == 2) || (i != 3)) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */