package com.tencent.mobileqq.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import pyj;
import pyk;
import pyl;
import pym;
import pyn;
import pyo;
import pyp;

public class HotChatHelper
{
  public static final int a = 1;
  static final String a = "hotchat_flash_pic";
  public static final int b = 2;
  public static final String b = "http://play.mobile.qq.com/play/mqqplay/hotchat/hotchat_share.html?_wv=1027&adtag=android&hotnamecode=";
  public static final int c = 3;
  public static final String c = "http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
  public static final String d = "邀请加入QQ热聊：";
  public static final String e = "tag_no_more_msg";
  
  public HotChatHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener)
  {
    paramActivity = new Dialog(paramActivity, 2131558973);
    paramActivity.setContentView(2130904195);
    Button localButton1 = (Button)paramActivity.findViewById(2131301788);
    Button localButton2 = (Button)paramActivity.findViewById(2131301790);
    localButton1.setOnClickListener(new pyj(paramActivity));
    paramActivity.setCanceledOnTouchOutside(true);
    localButton2.setOnClickListener(paramOnClickListener);
    paramActivity.show();
    return paramActivity;
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramString = new File(paramString);
          if (paramString.exists())
          {
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            BitmapManager.a(paramString.getAbsolutePath(), localOptions);
            int i = localOptions.outWidth;
            if (i > 150) {
              localOptions.inSampleSize = (i / 150);
            }
            localOptions.inJustDecodeBounds = false;
            paramString = BitmapManager.a(paramString.getAbsolutePath(), localOptions);
            return paramString;
          }
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("HotChatHelper", 2, "makeShareBitmap", paramString);
            return null;
          }
        }
        catch (Throwable paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("HotChatHelper", 2, "makeShareBitmap", paramString);
    return null;
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    int i = paramActivity.getRequestedOrientation();
    paramActivity.setRequestedOrientation(1);
    paramQQAppInterface = DialogUtil.a(paramActivity, 0, 2130903714, paramActivity.getString(2131371503), null, paramActivity.getString(2131371910), paramActivity.getString(2131371909), new pyk(paramActivity, paramQQAppInterface), new pyl(paramQQAppInterface));
    paramQQAppInterface.setOnDismissListener(new pym(paramActivity, i));
    paramQQAppInterface.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
    paramQQAppInterface.setMessageCount(paramActivity.getString(2131371504));
    paramQQAppInterface.setPreviewImage(paramActivity.getResources().getDrawable(2130839462), true, 1);
    paramQQAppInterface.show();
    return paramQQAppInterface;
  }
  
  public static QQCustomDialog a(HotChatInfo paramHotChatInfo, DialogInterface.OnClickListener paramOnClickListener)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((paramHotChatInfo == null) || (localBaseActivity == null)) {
      return null;
    }
    int i = localBaseActivity.getRequestedOrientation();
    localBaseActivity.setRequestedOrientation(1);
    paramHotChatInfo = DialogUtil.a(localBaseActivity, 230, localBaseActivity.getString(2131371506), localBaseActivity.getString(2131371505), 2131367262, 2131367774, paramOnClickListener, new pyn());
    paramOnClickListener = (TextView)paramHotChatInfo.findViewById(2131296852);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    paramOnClickListener.setLayoutParams(localLayoutParams);
    paramHotChatInfo.setOnDismissListener(new pyo(localBaseActivity, i));
    paramHotChatInfo.show();
    return paramHotChatInfo;
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null) {}
    try
    {
      int i = paramString.indexOf("hotnamecode=");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramString.substring(i + 12);
      }
      return (String)localObject1;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return "http://play.mobile.qq.com/play/mqqplay/hotchat/hotchat_share.html?_wv=1027&adtag=android&hotnamecode=" + paramString + "&newly_created=" + paramInt;
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramInt, paramQQAppInterface, paramBaseActivity, paramString1, paramString2, paramString3, paramString4, "邀请加入QQ热聊：" + paramString1, "立即加入，一起热聊！", null, null);
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (HotChatUtil.a(paramQQAppInterface, paramString2, true))
    {
      paramString5 = paramString3 + "&is_ptt=1";
      paramString3 = paramString5;
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("PttShow", new Object[] { "sharePttHotChat", paramString5 });
        paramString3 = paramString5;
      }
    }
    for (;;)
    {
      paramString5 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        paramString5.add(ActionSheetAdapter.a(i));
        i += 1;
      }
      ActionSheetAdapter localActionSheetAdapter = new ActionSheetAdapter(paramBaseActivity);
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramBaseActivity, null);
      GridView localGridView = (GridView)View.inflate(paramBaseActivity, 2130905086, null);
      localGridView.setBackgroundResource(2130837530);
      localGridView.setAdapter(localActionSheetAdapter);
      localGridView.setOnItemClickListener(new pyp(localActionSheet, paramInt, paramQQAppInterface, paramBaseActivity, paramString1, paramString2, paramString6, paramString3, paramString4, paramString7, paramString8));
      localActionSheet.a(localGridView);
      localActionSheet.d(2131367262);
      localActionSheetAdapter.a(paramString5);
      localActionSheet.show();
      return;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    paramString1 = String.format(paramBaseActivity.getString(2131371509), new Object[] { paramString1, paramString2 });
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)paramBaseActivity.getSystemService("clipboard")).setText(paramString1);
    }
    for (;;)
    {
      QQToast.a(paramBaseActivity, 2, "复制成功", 0).b(paramBaseActivity.getTitleBarHeight());
      return;
      ((android.content.ClipboardManager)paramBaseActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", paramString1));
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    paramBaseActivity = null;
    if (!TextUtils.isEmpty(paramString6)) {
      paramBaseActivity = a(paramString6);
    }
    paramString1 = paramBaseActivity;
    if (paramBaseActivity == null) {
      paramString1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130840831);
    }
    WXShareHelper.a().b(String.valueOf(l), paramString2, paramString1, paramString3, paramString5);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 69;; i = 65)
    {
      paramString4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(i).a(paramString2).a("web", paramString4, paramString5, null, null).a("邀请加入热聊", null).a();
      paramString5 = StructMsgElementFactory.a(2);
      paramString1 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString1 = "http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
      }
      paramString5.a(paramString1, paramString2, paramString3, 0);
      paramString4.addItem(paramString5);
      paramString1 = new Intent();
      paramString1.putExtra("forward_type", -3);
      paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
      ForwardBaseOption.a(paramBaseActivity, paramString1, 3);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {}
    do
    {
      return;
      if (paramHotChatInfo.state == 1)
      {
        a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.a().getString(2131371502), true);
        return;
      }
      a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.a().getString(2131371486), true);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(paramHotChatInfo.troopUin, 1);
      if (localRecentUser != null) {
        localRecentUserProxy.b(localRecentUser);
      }
    } while (paramHotChatInfo.state != 0);
    paramHotChatInfo.state = 4;
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.a(paramHotChatInfo);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo, String paramString, boolean paramBoolean)
  {
    AddMessageHelper.a(paramQQAppInterface, paramHotChatInfo.troopUin, paramString, 1, paramBoolean, false);
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("hotchat_flash_pic", "true");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == 63536) {
      paramMessageRecord.saveExtInfoToExtStr("hotchat_flash_pic", paramBoolean + "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.hotchat", 4, "setFlashPicFlag,troopUin:" + paramMessageRecord.frienduin + ",isReaded:" + paramBoolean + ",msgType:" + paramMessageRecord.msgtype);
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null) {
      if (paramMessageRecord.msgtype != 63536)
      {
        bool1 = bool2;
        if (paramMessageRecord.msgtype != 63530) {}
      }
      else
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("hotchat_flash_pic"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "convert2FlashPicAlumb url=" + paramString);
    }
    return paramString + "_fp";
  }
  
  private static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseActivity.getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = "http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
    }
    localArrayList.add(str);
    paramString5 = new Bundle();
    paramString5.putString("title", paramString1);
    paramString5.putString("desc", paramString3);
    paramString5.putLong("req_share_id", 0L);
    paramString5.putString("detail_url", paramString4);
    paramString5.putString("url", paramString4);
    paramString5.putStringArrayList("image_url", localArrayList);
    paramString1 = paramString2;
    if (paramString2.startsWith("邀请加入QQ热聊：")) {
      paramString1 = paramString2 + "。立即加入，一起热聊！";
    }
    paramString5.putString("troop_wording", paramString1);
    paramString5.putString("bizname", "JoinTroopLink");
    QZoneShareManager.a(localQQAppInterface, paramBaseActivity, paramString5, null);
  }
  
  public static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    paramBaseActivity = null;
    if (!TextUtils.isEmpty(paramString6)) {
      paramBaseActivity = a(paramString6);
    }
    paramString1 = paramBaseActivity;
    if (paramBaseActivity == null) {
      paramString1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130840831);
    }
    if (paramString2.startsWith("邀请加入QQ热聊：")) {}
    for (paramBaseActivity = paramString2 + "。立即加入，一起热聊！";; paramBaseActivity = paramString2)
    {
      WXShareHelper.a().a(String.valueOf(l), paramBaseActivity, paramString1, paramString3, paramString5);
      return;
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("hotchat_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotChatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */