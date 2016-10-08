package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class QLifeCommentActivity$ShopSelectReceiver
  extends BroadcastReceiver
{
  protected QLifeCommentActivity$ShopSelectReceiver(QLifeCommentActivity paramQLifeCommentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qlifeShopSelect"))) {
        break label43;
      }
    }
    label43:
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QLifeCommentActivity", 2, "onReceive:" + paramContext);
        }
        try
        {
          paramContext = new JSONObject(paramContext);
          paramIntent = paramContext.optString("selectTitle");
          String str1 = paramContext.optString("selectContent");
          String str2 = paramContext.optString("shopID");
          if (!TextUtils.isEmpty(paramIntent)) {
            this.a.c.setText(paramIntent);
          }
          if (!TextUtils.isEmpty(str1)) {
            this.a.d.setText(str1);
          }
          if (!TextUtils.isEmpty(str2))
          {
            this.a.A = str2;
            this.a.C = paramContext.optString("sp");
            this.a.D = paramContext.optString("idType");
            this.a.E = paramContext.optString("source");
            if (this.a.a != null) {
              this.a.a.a = true;
            }
            TroopBarUtils.a.clear();
            this.a.j = ("http://s.p.qq.com/cgi-bin/coupon_q/social/binary_upload.fcg?&sp=" + this.a.C + "&shopid=" + this.a.A);
            return;
          }
        }
        catch (JSONException paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QLifeCommentActivity", 2, "onReceive JSONException : " + paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\QLifeCommentActivity$ShopSelectReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */