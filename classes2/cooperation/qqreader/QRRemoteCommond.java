package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QRRemoteCommond
  extends RemoteCommand
{
  public static final int a = 1;
  public static final String a = "QRRemoteCommond";
  public static final int b = 2;
  public static final String b = "qqreader_plugin_cmd";
  public static final int c = 3;
  public static final String c = "path";
  public static final int d = 4;
  public static final String d = "pathList";
  public static final int e = 5;
  public static final String e = "redTouchInfo";
  public static final int f = 6;
  public static final String f = "redTouchInfoList";
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  
  public QRRemoteCommond()
  {
    super("qqreader_plugin_cmd");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = null;
    Object localObject2 = new Bundle();
    Object localObject1 = (PublicAccountDataManager)a().getManager(55);
    switch (paramBundle.getInt("CommondType"))
    {
    default: 
      return null;
    case 1: 
      if (paramBundle == null) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("uin"); localObject1 != null; paramBundle = null)
    {
      if (((PublicAccountDataManager)localObject1).b(paramBundle) != null) {
        ((Bundle)localObject2).putBoolean("get_publicaccountinfo", true);
      }
      for (;;)
      {
        return (Bundle)localObject2;
        ((Bundle)localObject2).putBoolean("get_publicaccountinfo", false);
      }
      ((Bundle)localObject2).putInt("qq_vip_level", QRUtility.a(a(), null));
      return (Bundle)localObject2;
      if (a() == null) {
        break;
      }
      paramBundle = paramBundle.getString("publicaccount_uin");
      ((Bundle)localObject2).putBoolean("publicaccount_is_follow", PublicAccountUtil.a(a(), paramBundle));
      return (Bundle)localObject2;
      if (a() == null) {
        break;
      }
      localObject1 = paramBundle.getString("publicaccount_uin");
      Object localObject3 = (PublicAccountDataManager)a().getManager(55);
      paramBundle = paramOnInvokeFinishLinstener;
      if (localObject3 != null) {
        paramBundle = ((PublicAccountDataManager)localObject3).b((String)localObject1);
      }
      if (paramBundle != null)
      {
        ((Bundle)localObject2).putBoolean("isFollow", true);
        ((Bundle)localObject2).putString("paName", paramBundle.name);
      }
      for (;;)
      {
        return (Bundle)localObject2;
        ((Bundle)localObject2).putBoolean("isFollow", false);
      }
      int i1 = paramBundle.getInt("sharetype");
      paramOnInvokeFinishLinstener = paramBundle.getString("url");
      localObject3 = (Bitmap)paramBundle.getParcelable("cover");
      Object localObject5 = paramBundle.getString("title");
      localObject1 = paramBundle.getString("detail");
      Object localObject4 = paramBundle.getString("imgUrl");
      switch (i1)
      {
      default: 
      case 1: 
      case 2: 
        for (;;)
        {
          return (Bundle)localObject2;
          paramBundle = new Bundle();
          paramBundle.putString("title", (String)localObject5);
          paramBundle.putString("desc", (String)localObject1);
          paramBundle.putString("detail_url", paramOnInvokeFinishLinstener);
          paramOnInvokeFinishLinstener = new ArrayList(1);
          paramOnInvokeFinishLinstener.add(localObject4);
          paramBundle.putStringArrayList("image_url", paramOnInvokeFinishLinstener);
          QZoneShareManager.a(a(), a().getApplication().getApplicationContext(), paramBundle, null);
          continue;
          localObject4 = WXShareHelper.a();
          l1 = System.currentTimeMillis();
          if (TextUtils.isEmpty(paramBundle.getString("detail"))) {
            localObject1 = paramOnInvokeFinishLinstener;
          }
          ((WXShareHelper)localObject4).d(String.valueOf(l1), (String)localObject5, (Bitmap)localObject3, (String)localObject1, paramOnInvokeFinishLinstener);
        }
      }
      localObject4 = WXShareHelper.a();
      long l1 = System.currentTimeMillis();
      localObject5 = new StringBuilder().append((String)localObject5).append(":");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (paramBundle = paramOnInvokeFinishLinstener;; paramBundle = (Bundle)localObject1)
      {
        localObject5 = paramBundle;
        paramBundle = (Bundle)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramBundle = paramOnInvokeFinishLinstener;
        }
        ((WXShareHelper)localObject4).c(String.valueOf(l1), (String)localObject5, (Bitmap)localObject3, paramBundle, paramOnInvokeFinishLinstener);
        break;
      }
      if ((WXShareHelper.a().a()) && (WXShareHelper.a().b())) {
        ((Bundle)localObject2).putBoolean("is_wx_supported", true);
      }
      for (;;)
      {
        return (Bundle)localObject2;
        ((Bundle)localObject2).putBoolean("is_wx_supported", false);
      }
      paramBundle = paramBundle.getString("url");
      paramBundle = new Intent(a().getApplication().getApplicationContext(), QQBrowserActivity.class).putExtra("url", paramBundle);
      paramBundle.putExtra("uin", a().a());
      paramBundle.putExtra("vkey", a().d());
      paramBundle.setFlags(268435456);
      a().getApplication().getApplicationContext().startActivity(paramBundle);
      break;
      paramOnInvokeFinishLinstener = a();
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.a(Conversation.class);
        if (paramOnInvokeFinishLinstener == null) {
          break;
        }
        localObject1 = paramOnInvokeFinishLinstener.obtainMessage(1134027);
        localObject2 = paramBundle.getString("bookName");
        l1 = paramBundle.getLong("bookId");
        paramBundle = (String)localObject2 + "@#" + l1;
        if (QLog.isColorLevel()) {
          QLog.e("QRRemoteCommond", 2, "bookInfo : " + paramBundle);
        }
        ((Message)localObject1).obj = paramBundle;
        paramOnInvokeFinishLinstener.sendMessage((Message)localObject1);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QRRemoteCommond", 2, "showReaderBar app = null");
      break;
      paramOnInvokeFinishLinstener = a();
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = (RedTouchManager)paramOnInvokeFinishLinstener.getManager(35);
        if (paramOnInvokeFinishLinstener != null)
        {
          paramBundle = paramOnInvokeFinishLinstener.a(paramBundle.getString("path"));
          if (paramBundle != null) {
            ((Bundle)localObject2).putParcelable("redTouchInfo", RedTouchUtils.a(paramBundle));
          }
        }
      }
      for (;;)
      {
        return (Bundle)localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("QRRemoteCommond", 2, "getRedTouch app = null");
        }
      }
      paramOnInvokeFinishLinstener = a();
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = (RedTouchManager)paramOnInvokeFinishLinstener.getManager(35);
        if (paramOnInvokeFinishLinstener == null) {
          break;
        }
        paramBundle = paramBundle.getString("path");
        paramOnInvokeFinishLinstener.b(paramBundle);
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("service_type", 2);
          ((JSONObject)localObject1).put("act_id", 1002);
          paramOnInvokeFinishLinstener.b(paramOnInvokeFinishLinstener.a(paramBundle), ((JSONObject)localObject1).toString());
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QRRemoteCommond", 2, "clickRedTouch app = null");
      break;
      paramOnInvokeFinishLinstener = a();
      if (paramOnInvokeFinishLinstener == null) {
        break;
      }
      paramOnInvokeFinishLinstener = (RedTouchManager)paramOnInvokeFinishLinstener.getManager(35);
      localObject1 = paramBundle.getStringArrayList("pathList");
      if ((paramOnInvokeFinishLinstener == null) || (localObject1 == null)) {
        break;
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = paramOnInvokeFinishLinstener.a((String)((Iterator)localObject1).next());
        if (localObject2 != null) {
          paramBundle.add(RedTouchUtils.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
        }
      }
      paramOnInvokeFinishLinstener = new Bundle();
      paramOnInvokeFinishLinstener.putParcelableArrayList("redTouchInfoList", paramBundle);
      return paramOnInvokeFinishLinstener;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRRemoteCommond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */