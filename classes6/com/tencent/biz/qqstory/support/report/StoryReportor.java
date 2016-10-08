package com.tencent.biz.qqstory.support.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryReportor
{
  public static final String A = "search";
  public static final String B = "mini_data";
  public static final String C = "story_play";
  public static final String D = "download_video";
  public static final String E = "dc00898";
  public static final String F = "publish_story";
  public static final String G = "story_net";
  public static final int a = 0;
  public static final String a = "899";
  public static final String b = "grp_story";
  public static final String c = "video_shoot";
  public static final String d = "video_edit";
  public static final String e = "person_data";
  public static final String f = "dynamic";
  public static final String g = "dynamic_more";
  public static final String h = "story_tab";
  public static final String i = "browse_friend_settings";
  public static final String j = "friend_story_settings";
  public static final String k = "set_notsee";
  public static final String l = "set_notletsee";
  public static final String m = "list_settings";
  public static final String n = "person_data_set";
  public static final String o = "play_page";
  public static final String p = "play_page_title";
  public static final String q = "play_page_video";
  public static final String r = "play_page_share";
  public static final String s = "play_page_web";
  public static final String t = "new_guide";
  public static final String u = "now_live";
  public static final String v = "recommend";
  public static final String w = "hall";
  public static final String x = "data_card";
  public static final String y = "share_uin";
  public static final String z = "share_uin_obj";
  
  public StoryReportor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static String a(Context paramContext)
  {
    int i1 = 4;
    int i2 = NetworkUtil.a(paramContext);
    if (i2 == 1) {}
    for (;;)
    {
      return "" + i1;
      if (i2 == 2) {
        i1 = 1;
      } else if (i2 == 3) {
        i1 = 2;
      } else if (i2 == 4) {
        i1 = 3;
      } else {
        i1 = 5;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("author_id", paramString1);
      localJSONObject.put("author_type", a(paramInt3));
      localJSONObject.put("video_type", paramInt4);
      localJSONObject.put("video_time", paramLong1);
      localJSONObject.put("play_time", paramLong2);
      localJSONObject.put("load_time", paramInt5);
      a("play_video", "video_all_js", paramInt1, paramInt2, new String[] { localJSONObject.toString(), paramString3, "", paramString2 });
      a("play_video", "video_property", paramInt1, paramInt2, new String[] { paramString1, "" + a(paramInt3), "" + paramInt4, paramString2 });
      a("play_video", "video_time", paramInt1, paramInt2, new String[] { "" + paramLong1, "" + paramLong2, "" + paramInt5, paramString2 });
      return;
    }
    catch (JSONException paramString1) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForStructing paramMessageForStructing, String paramString)
  {
    if (paramMessageForStructing == null) {}
    do
    {
      do
      {
        AbsStructMsg localAbsStructMsg;
        do
        {
          return;
          localAbsStructMsg = paramMessageForStructing.structingMsg;
        } while ((localAbsStructMsg == null) || (TextUtils.isEmpty(localAbsStructMsg.mMsg_A_ActionData)));
        paramContext = JumpParser.a(paramQQAppInterface, paramContext, localAbsStructMsg.mMsg_A_ActionData);
      } while (paramContext == null);
      paramQQAppInterface = paramContext.a("usertype");
      paramContext = paramContext.a("unionid");
    } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(paramContext)));
    try
    {
      i1 = Integer.parseInt(paramQQAppInterface);
      a("share_uin_obj", paramString, TroopUtils.b(paramMessageForStructing.istroop), i1, new String[] { paramContext });
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ReportController.b(null, "dc00899", "grp_story", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ReportController.b(null, "dc00899", "grp_story_engineer", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\report\StoryReportor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */