package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import wdi;

public class ShareMsgHelper
  implements AppConstants
{
  public static final int a = 1;
  public static final String a = "http://s.p.qq.com/pub/get_face?img_type=3&uin=";
  public static final int b = 2;
  QQAppInterface a;
  
  public ShareMsgHelper(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    String str = paramQQAppInterface.a();
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    paramString = MessageRecordFactory.a(paramQQAppInterface, str, paramString, str, paramInt, i, paramAbsStructMsg);
    paramQQAppInterface.a().b(paramString, paramQQAppInterface.a());
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, BitAppMsg paramBitAppMsg, BusinessObserver paramBusinessObserver) {}
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    a(paramQQAppInterface, paramString, null, paramInt, paramAbsStructMsg, paramBusinessObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramBusinessObserver = paramQQAppInterface.a();
        i = MobileQQService.c;
        MobileQQService.c = i + 1;
        long l = i;
        if (paramAbsStructMsg.mMsgServiceID == 80)
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          for (;;)
          {
            paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
            if (paramAbsStructMsg.mMsgServiceID != 41) {
              break;
            }
            paramQQAppInterface.a().b(paramString2, null);
            return;
          }
        }
        if (TextUtils.isEmpty(paramString2)) {
          paramString2 = paramBusinessObserver;
        }
        for (;;)
        {
          paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
          break;
        }
        if (paramAbsStructMsg.mMsgServiceID == 100)
        {
          paramAbsStructMsg.mMsgServiceID = 1;
          paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramBusinessObserver, paramInt, l, paramAbsStructMsg);
          paramQQAppInterface.a().a(paramString1, new wdi());
          return;
        }
        paramQQAppInterface.a().a(paramString2, null);
        return;
      } while (paramAbsStructMsg == null);
      if (paramAbsStructMsg.mMsgServiceID == 1)
      {
        paramString2 = paramQQAppInterface.a();
        i = MobileQQService.c;
        MobileQQService.c = i + 1;
        paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.a().a(paramString1, null);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 41);
    paramString2 = paramQQAppInterface.a();
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
    paramQQAppInterface.a().b(paramString1, null);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, Intent paramIntent, int paramInt3)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", paramIntent, paramInt3, null, -1L);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", null, -1, paramString18, -1L);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Intent paramIntent, int paramInt3, String paramString19, long paramLong)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.setClass(paramContext, ForwardRecentActivity.class);
    }
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString19);
    if (paramLong != -1L) {
      localIntent.putExtra("req_share_id", paramLong);
    }
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    if ((paramContext instanceof QQBrowserActivity))
    {
      localIntent.putExtra("strurt_msgid", ((QQBrowserActivity)paramContext).ax);
      localIntent.putExtra("emoInputType", 1);
      localIntent.putExtra("forward _key_nojump", true);
    }
    if (paramInt2 == 44) {
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString2 = paramString4;
    if (paramString4 != null)
    {
      paramString2 = paramString4;
      if (paramString4.length() > 45) {
        paramString2 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString2);
    paramString2 = paramString5;
    if (paramString5 != null)
    {
      paramString2 = paramString5;
      if (paramString5.length() > 60) {
        paramString2 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("forward_thumb", paramString18);
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    if ("struct_favorite".equals(paramString1))
    {
      localIntent.putExtra("k_favorites", false);
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString1 = StructMsgFactory.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt3);
      }
      for (;;)
      {
        return true;
        if ((1001 == paramInt1) && ((paramContext instanceof QQBrowserActivity)))
        {
          paramString1 = (QQBrowserActivity)paramContext;
          localIntent.putExtra("strurt_msgid", paramString1.ax);
          localIntent.putExtra("struct_uin", paramString1.aw);
          localIntent.putExtra("struct_url", paramString1.ab);
          localIntent.putExtra("from_web", true);
          if ((paramString1.ay != null) && (!"".equals(paramString1.ay))) {
            localIntent.putExtra("source_puin", paramString1.ay);
          }
        }
        paramContext.startActivity(localIntent);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("k_back", false);
    localIntent.setClass(paramContext, ForwardRecentActivity.class);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString18);
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 45) {
        paramString1 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString1);
    paramString1 = paramString5;
    if (paramString5 != null)
    {
      paramString1 = paramString5;
      if (paramString5.length() > 60) {
        paramString1 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("forward_thumb", "");
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    localIntent.putExtra("compatible_text", paramString19);
    localIntent.putExtra("flag", 2);
    if (paramBoolean) {
      localIntent.putExtra("icon_need_round", "1");
    }
    localIntent.putExtra("emoInputType", 2);
    paramString1 = StructMsgFactory.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, 1);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    paramString6 = new Intent();
    paramString6.setClass(paramContext, ForwardRecentActivity.class);
    paramString6.putExtra("pubUin", paramString1);
    paramString6.putExtra("forward_type", 1001);
    paramString6.putExtra("key_flag_from_plugin", true);
    paramString6.putExtra("category", paramContext.getString(2131364476));
    paramString6.putExtra("detail_url", paramString5);
    paramString6.putExtra("image_url_remote", paramString4);
    paramString6.putExtra("title", paramString2);
    paramString6.putExtra("desc", paramString3);
    paramString6.putExtra("struct_share_key_content_action", "plugin");
    paramString6.putExtra("pluginName", "public_account");
    paramString3 = "";
    paramString4 = "";
    switch (paramInt)
    {
    default: 
      paramString1 = paramString4;
    }
    for (;;)
    {
      paramString6.putExtra("struct_share_key_content_a_action_DATA", paramString3);
      paramString6.putExtra("struct_share_key_content_i_action_DATA", paramString1);
      paramString6.putExtra("struct_share_key_content_action_DATA", paramString3);
      paramString6.putExtra("req_share_id", -1);
      paramString6.putExtra("isFromShare", true);
      paramString6.putExtra("struct_share_key_source_action", " ");
      paramString6.putExtra("brief_key", String.format(paramContext.getString(2131364480), new Object[] { paramString2 }));
      if ((paramInt != 1) && (paramInt != 2)) {
        paramString6.putExtra("app_name", paramContext.getString(2131364477));
      }
      paramString6.putExtra("compatible_text", "分享名片");
      paramString1 = StructMsgFactory.a(paramString6.getExtras());
      if (paramString1 == null) {
        break;
      }
      paramString6.putExtra("stuctmsg_bytes", paramString1.getBytes());
      paramString6.putExtra("from_card", true);
      paramContext.startActivity(paramString6);
      return true;
      paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
      paramString1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramString1 + "&version=1";
      paramString6.putExtra("req_type", 1);
      continue;
      paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
      paramString1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1";
      paramString6.putExtra("req_type", 40);
      paramString6.putExtra("k_forward_title", paramContext.getString(2131372152));
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\ShareMsgHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */