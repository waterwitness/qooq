package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

public class TroopBusinessUtil
{
  public static final String a = "troop_msg_has";
  public static final String b = "troop_msg_flag";
  public static final String c = "troop_msg_head_url";
  public static final String d = "troop_msg_head_click_url";
  public static final String e = "troop_msg_nickname";
  public static final String f = "troop_msg_nick_color";
  public static final String g = "troop_msg_rank_name";
  public static final String h = "troop_msg_rank_color";
  public static final String i = "troop_msg_rank_bg_color";
  public static final String j = TroopBusinessUtil.class.getName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static TroopBusinessUtil.TroopBusinessMessage a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has")))
      {
        localObject1 = new TroopBusinessUtil.TroopBusinessMessage();
        ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
        ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
        ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
        ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
        ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      }
    }
    try
    {
      ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
      ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_c_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
      ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      return (TroopBusinessUtil.TroopBusinessMessage)localObject1;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e(j, 2, "the color string cannot parse to int. " + paramMessageRecord.getMessage());
    }
    return (TroopBusinessUtil.TroopBusinessMessage)localObject1;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    try
    {
      if (TextUtils.isEmpty(paramTroopBusinessMessage.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (paramTroopBusinessMessage.jdField_b_of_type_JavaLangString.startsWith("http"))
      {
        paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramAppInterface.putExtra("url", paramTroopBusinessMessage.jdField_b_of_type_JavaLangString);
        PublicAccountUtil.a(paramAppInterface, paramTroopBusinessMessage.jdField_b_of_type_JavaLangString);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      if (!paramTroopBusinessMessage.jdField_b_of_type_JavaLangString.startsWith("mqqapi")) {
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        JumpParser.a((QQAppInterface)paramAppInterface, paramContext, paramTroopBusinessMessage.jdField_b_of_type_JavaLangString).b();
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramTroopBusinessMessage.jdField_b_of_type_JavaLangString)));
  }
  
  public static void a(MessageRecord paramMessageRecord, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    if ((paramTroopBusinessMessage == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(paramTroopBusinessMessage.jdField_a_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", paramTroopBusinessMessage.jdField_a_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", paramTroopBusinessMessage.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", paramTroopBusinessMessage.jdField_c_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(paramTroopBusinessMessage.jdField_b_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", paramTroopBusinessMessage.jdField_d_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(paramTroopBusinessMessage.jdField_c_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(paramTroopBusinessMessage.jdField_d_of_type_Int));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopBusinessUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */