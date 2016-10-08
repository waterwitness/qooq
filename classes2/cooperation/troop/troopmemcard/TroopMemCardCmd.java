package cooperation.troop.troopmemcard;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager.ConfigType;

public class TroopMemCardCmd
  extends RemoteCommand
{
  public static final int a = 1001;
  public static final String a = "troop.troopmemcard.get_app_interface_data";
  public static final int b = 1002;
  public static final String b = "req_sub_cmd";
  public static final int c = 1003;
  public static final int d = 1004;
  public static final int e = 1005;
  public static final int f = 1006;
  public static final int g = 1007;
  public static final int h = 1008;
  public static final int i = 1009;
  public static final int j = 1010;
  QQAppInterface a;
  
  public TroopMemCardCmd(QQAppInterface paramQQAppInterface)
  {
    super("troop.troopmemcard.get_app_interface_data");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  public Bundle a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = paramBundle.getString("troopUin");
    String str2 = paramBundle.getString("memUin");
    paramBundle = this.a.a().a(paramOnInvokeFinishLinstener, 1, 100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chatmsg:");
    if (!TextUtils.isEmpty(str2)) {}
    for (int k = 10;; k = 20)
    {
      Iterator localIterator = paramBundle.iterator();
      int m = 0;
      MessageRecord localMessageRecord;
      do
      {
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          if (m <= k) {}
        }
        else
        {
          paramBundle = "";
        }
        try
        {
          paramOnInvokeFinishLinstener = URLEncoder.encode(localStringBuilder.toString(), "UTF-8");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          for (;;)
          {
            String str1;
            paramOnInvokeFinishLinstener.printStackTrace();
          }
        }
        paramOnInvokeFinishLinstener = new Bundle();
        paramOnInvokeFinishLinstener.putString("msgtoupload", paramBundle);
        return paramOnInvokeFinishLinstener;
      } while ((localMessageRecord == null) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(localMessageRecord.senderuin, str2))));
      if ((localMessageRecord instanceof MessageForPic)) {
        paramOnInvokeFinishLinstener = ((MessageForPic)localMessageRecord).uuid;
      }
      for (str1 = "2";; str1 = "1")
      {
        paramBundle = paramOnInvokeFinishLinstener;
        try
        {
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("\"", "\\\"");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("'", "\\'");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("|", "\\|");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(":", "\\:");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(";", "\\;");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("[", "\\[");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("]", "\\]");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("=", "\\=");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          for (;;)
          {
            paramOnInvokeFinishLinstener.printStackTrace();
          }
        }
        localStringBuilder.append("[");
        localStringBuilder.append("uin=" + localMessageRecord.senderuin);
        localStringBuilder.append(";");
        localStringBuilder.append("content=" + paramBundle);
        localStringBuilder.append(";");
        localStringBuilder.append("type=" + str1);
        localStringBuilder.append("]");
        m += 1;
        break;
        if (((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) || (localMessageRecord.msgtype != 64536)) {
          break;
        }
        paramOnInvokeFinishLinstener = localMessageRecord.msg;
      }
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {
      return null;
    }
    for (;;)
    {
      Bundle localBundle;
      try
      {
        k = paramBundle.getInt("req_sub_cmd");
        localBundle = new Bundle();
        switch (k)
        {
        case 1001: 
          if (paramOnInvokeFinishLinstener == null) {
            return paramBundle;
          }
          paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        int k;
        Object localObject;
        String str1;
        byte b1;
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemCardCmd", 2, "invoke Exception hanppend! ExceptionClass = + " + paramBundle.getClass().getName() + "msg = " + paramBundle.getMessage());
        ReportController.b(this.a, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
        return null;
      }
      paramBundle = a(paramBundle, paramOnInvokeFinishLinstener);
      continue;
      paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
      ((TroopManager)this.a.getManager(51)).b(paramBundle);
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("troopUin");
      localBundle.putSerializable("troopInfo", ((TroopManager)this.a.getManager(51)).a(paramBundle));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      paramBundle = paramBundle.getString("memUin");
      localBundle.putSerializable("card", ((TroopManager)this.a.getManager(51)).a((String)localObject, paramBundle));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      str1 = paramBundle.getString("memUin");
      paramBundle = (HWTroopMemberCard)paramBundle.getSerializable("card");
      ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, paramBundle);
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      str1 = paramBundle.getString("memUin");
      b1 = paramBundle.getByte("flag");
      localBundle.putBoolean("result", ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, b1));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      str1 = paramBundle.getString("memUin");
      str2 = paramBundle.getString("uniqueTitle");
      k = paramBundle.getInt("uniqueTitleExpire");
      ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, str2, k);
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("troopCode");
      localObject = (TroopManager)this.a.getManager(51);
      this.a.a().a(paramBundle, 1);
      ((TroopManager)localObject).a(paramBundle);
      DBUtils.a().a(this.a, paramBundle, this.a.a(), this.a.a());
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("key");
      paramBundle = (ServerConfigManager.ConfigType)paramBundle.getSerializable("type");
      localBundle.putString("result", this.a.a(paramBundle, (String)localObject));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      paramBundle = paramBundle.getStringArrayList("memberUins");
      ((TroopManager)this.a.getManager(51)).b((String)localObject, (String)paramBundle.get(0));
      paramBundle = localBundle;
      continue;
      paramBundle = localBundle;
    }
    return paramBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop\troopmemcard\TroopMemCardCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */