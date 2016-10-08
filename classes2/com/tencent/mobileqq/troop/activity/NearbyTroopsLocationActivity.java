package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class NearbyTroopsLocationActivity
  extends NearbyTroopsActivity
{
  public NearbyTroopsLocationActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent(paramContext, NearbyTroopsLocationActivity.class);
    }
    int i;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a().a();
      if (paramQQAppInterface == null) {
        break label110;
      }
      i = 0;
      if (i >= paramQQAppInterface.size()) {
        break label110;
      }
      paramIntent = (ResourcePluginInfo)paramQQAppInterface.get(i);
      if (paramIntent.uiResId != 886L) {
        break label101;
      }
    }
    label101:
    label110:
    for (paramQQAppInterface = paramIntent.strResName;; paramQQAppInterface = null)
    {
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localIntent.putExtra("config_res_plugin_item_name", paramQQAppInterface);
      }
      paramContext.startActivity(localIntent);
      return;
      i += 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyTroopsLocationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */