package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JumpParser
{
  public static final String A = "mqqtribe://";
  public static final String B = "mqqapi://wallet/open";
  public static final String C = "mqqapi://im/chat";
  public static final String D = "mqqapi://wallet/open?src_type=web&viewtype=0&version=1";
  public static final String E = "mqqmdpass://wallet/modify_pass";
  public static final String F = "mqqapi://qqdataline/openqqdataline";
  public static final String G = "mqqverifycode://";
  public static final String H = "mqqapi://qlink/openqlink";
  public static final String I = "mqqconnect://";
  public static final String J = "http://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard";
  public static final String K = "mqq://shop/";
  public static final String L = "mqq://shop/apollo_store";
  public static final String M = "mqqvoipivr://";
  public static final String N = "mqqapi://dating/";
  public static final String O = "mqqdevlock://";
  public static final String P = "mqqapi://qqcomic/";
  public static final String Q = "mqqapi://asyncmsg/showdetail?";
  public static final String R = "mqqapi://schedule/showDetail?";
  public static final String S = "mqqapi://qqc2b/callc2bphone";
  public static final String T = "qqfav://operation/";
  public static final String U = "mqqapi://assistant_setting/ASSISTANT_SETTING";
  public static final String V = "mqqzone";
  private static final String W = "JumpAction";
  private static final int a = 0;
  public static final String a = "http://clientui.3g.qq.com/mqqapi/";
  private static final int b = 1;
  public static final String b = "mqqapi://";
  private static final int c = 0;
  public static final String c = "mqqmdpass://";
  private static final int d = 1;
  public static final String d = "http://clientui.3g.qq.com/mqq/";
  public static final String e = "mqq://";
  public static final String f = "qapp://";
  public static final String g = "http://qm.qq.com/cgi-bin/";
  public static final String h = "mqqopensdkapi://bizAgent/";
  public static final String i = "mqqflyticket://";
  public static final String j = "mqqwpa://";
  public static final String k = "wtloginmqq://";
  public static final String l = "qqwifi://";
  public static final String m = "apollo://";
  public static final String n = "mqqapi://card/show_pslcard";
  public static final String o = "mqqapi://readingcenter";
  public static final String p = " mqqapi://qqreader";
  public static final String q = "mqqapi://od";
  public static final String r = "mqqapi://0odAddFriend";
  public static final String s = "mqqconferenceflyticket://";
  public static final String t = "mqqapi://qstory/opencontent";
  public static final String u = "mqqapi://qstory/opendiscovery";
  public static final String v = "mqqapi://qstory/open";
  public static final String w = "mqqapi://qzone/groupalbum";
  public static final String x = "mqqapi://apollo/";
  public static final String y = "mqqapi://qzone/to_publish_queue";
  public static final String z = "mqqapi://qzone/to_friend_feeds";
  
  public JumpParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Jump input=" + paramString);
    }
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("mqqzone"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = paramString;
      paramQQAppInterface.ft = "qzone";
      paramQQAppInterface.fu = "qzone_schema";
      return paramQQAppInterface;
    }
    if (paramString.startsWith("qqfav://operation/"))
    {
      str1 = Uri.parse(paramString).getLastPathSegment();
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = paramString;
      paramQQAppInterface.ft = "com.qqfav";
      paramQQAppInterface.fu = str1;
      return paramQQAppInterface;
    }
    if (paramString.startsWith("mqq://shop/apollo_store"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = paramString;
      paramQQAppInterface.ft = "shop";
      paramQQAppInterface.fu = "apollo_store";
      return paramQQAppInterface;
    }
    if (paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = paramString;
      paramQQAppInterface.ft = "assistant_setting";
      paramQQAppInterface.fu = "ASSISTANT_SETTING";
      return paramQQAppInterface;
    }
    String str1 = paramString;
    if (paramString.contains("videochat"))
    {
      str1 = paramString;
      if (paramString.contains("uinType=21")) {
        str1 = URLDecoder.decode(paramString);
      }
    }
    if (str1.startsWith("mqqapi://qzone/to_publish_queue"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "qzone";
      paramQQAppInterface.fu = "to_publish_queue";
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://qzone/to_friend_feeds"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "qzone";
      paramQQAppInterface.fu = "to_friend_feeds";
      return paramQQAppInterface;
    }
    if (str1.startsWith("qapp://"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "qapp";
      paramQQAppInterface.fu = Uri.parse(str1).getHost();
      return paramQQAppInterface;
    }
    int i1;
    if (str1.startsWith("mqqapi://wallet/open"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "wallet";
      paramQQAppInterface.fu = "open";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqmdpass://wallet/modify_pass"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "wallet";
      paramQQAppInterface.fu = "modify_pass";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://asyncmsg/showdetail?"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "asyncmsg";
      paramQQAppInterface.fu = "open_async_detail";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://schedule/showDetail?"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "schedule";
      paramQQAppInterface.fu = "showDetail";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("qqwifi://"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "qqwifi";
      paramQQAppInterface.fu = "outweb_start";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://od"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "od";
      paramQQAppInterface.fu = "openroom";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://0odAddFriend"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "odAddFriend";
      paramQQAppInterface.fu = "addFriend";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://qstory/opencontent"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.fs = str1;
      paramQQAppInterface.ft = "qstory";
      paramQQAppInterface.fu = "opencontent";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    String str2;
    if (str1.startsWith("mqqapi://qzone/groupalbum"))
    {
      paramString = str1.split("\\?");
      if (paramString.length != 2) {
        return null;
      }
      localObject2 = paramString[0];
      str2 = paramString[1];
      paramString = "";
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      if (((String)localObject2).startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = ((String)localObject2).substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break;
        }
        return null;
        if (((String)localObject2).startsWith("http://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = ((String)localObject2).substring("http://qm.qq.com/cgi-bin/".length());
        }
        else if (((String)localObject2).startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = ((String)localObject2).substring("http://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (((String)localObject2).startsWith("mqqapi://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqapi://".length());
        }
        else if (((String)localObject2).startsWith("mqq://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqq://".length());
        }
        else if (((String)localObject2).startsWith("http://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = ((String)localObject2).substring("http://clientui.3g.qq.com/mqq/".length());
        }
        else if (((String)localObject2).startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqflyticket://".length());
        }
        else if (((String)localObject2).startsWith("mqqwpa://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqwpa://".length());
        }
        else if (((String)localObject2).startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("wtloginmqq://".length());
        }
        else if (((String)localObject2).startsWith("mqqtribe://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqtribe://".length());
        }
        else if (((String)localObject2).startsWith("mqqvoipivr://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqvoipivr://".length());
        }
        else if (((String)localObject2).startsWith("qapp://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("qapp://".length());
        }
        else
        {
          paramQQAppInterface = paramString;
          if (((String)localObject2).startsWith("mqqconferenceflyticket://")) {
            paramQQAppInterface = ((String)localObject2).substring("mqqconferenceflyticket://".length());
          }
        }
      }
      paramContext.fs = str1;
      paramContext.ft = paramQQAppInterface[0];
      paramContext.fu = paramQQAppInterface[1];
      paramQQAppInterface = str2.split("&");
      i1 = 0;
      for (;;)
      {
        if (i1 < paramQQAppInterface.length)
        {
          paramString = paramQQAppInterface[i1].split("=");
          if (paramString.length == 2) {}
          try
          {
            paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
            paramContext.a(paramString[0], paramString[1]);
            i1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException);
              }
            }
          }
        }
      }
      return paramContext;
    }
    boolean bool1 = localException.startsWith("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity");
    boolean bool2 = localException.startsWith("mqqapi://readingcenter");
    boolean bool5 = localException.startsWith(" mqqapi://qqreader");
    boolean bool3 = localException.startsWith("wtloginmqq://");
    boolean bool4 = localException.startsWith("mqqwpa://");
    boolean bool6 = localException.startsWith("mqqvoipivr://");
    boolean bool7 = localException.startsWith("mqqtribe://");
    boolean bool8 = localException.startsWith("mqqverifycode://");
    boolean bool9 = localException.startsWith("mqqdevlock://");
    int i2;
    label1944:
    boolean bool10;
    boolean bool11;
    if ((localException.startsWith("mqqapi://im/chat")) && (localException.contains("chat_type=crm")) && (localException.contains("kfnick=")))
    {
      i1 = 1;
      if ((!localException.startsWith("mqqapi://card/show_pslcard")) || (!localException.contains("card_type=troopmember"))) {
        break label2069;
      }
      i2 = 1;
      bool10 = localException.startsWith("mqqapi://qqcomic/");
      bool11 = a(localException);
      boolean bool12 = localException.startsWith("mqqconferenceflyticket://");
      if ((localException.startsWith("mqqopensdkapi://bizAgent/")) || (bool2) || (bool3) || (bool4) || (bool7) || (bool6) || (bool1) || (i2 != 0) || (bool11) || (bool10)) {
        break label2075;
      }
      i2 = 1;
      label2023:
      paramString = localException;
      if (i2 == 0) {
        break label2087;
      }
      if ((bool2) || (i1 != 0) || (bool12)) {
        break label2081;
      }
    }
    label2069:
    label2075:
    label2081:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = a(localException, bool1);
      paramString = (String)localObject1;
      if (localObject1 != null) {
        break label2087;
      }
      return null;
      i1 = 0;
      break;
      i2 = 0;
      break label1944;
      i2 = 0;
      break label2023;
    }
    label2087:
    if ((bool5) || (bool2) || (bool3) || (bool4) || (bool7) || (bool8) || (bool6) || (bool9) || (bool11) || (bool10)) {}
    for (Object localObject1 = a(paramString, "?"); localObject1.length != 2; localObject1 = paramString.split("\\?")) {
      return null;
    }
    Object localObject2 = localObject1[0];
    localObject1 = localObject1[1];
    if ((i2 != 0) && (!((String)localObject2).startsWith("mqqconferenceflyticket://"))) {
      if ((!bool2) && (i1 == 0))
      {
        bool1 = true;
        localObject1 = a((String)localObject1, bool1);
      }
    }
    for (;;)
    {
      str2 = "";
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      if (((String)localObject2).startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = ((String)localObject2).substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break label2605;
        }
        return null;
        bool1 = false;
        break;
        if (((String)localObject2).startsWith("http://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = ((String)localObject2).substring("http://qm.qq.com/cgi-bin/".length());
        }
        else if (((String)localObject2).startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = ((String)localObject2).substring("http://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (((String)localObject2).startsWith("mqqapi://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqapi://".length());
        }
        else if (((String)localObject2).startsWith("mqq://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqq://".length());
        }
        else if (((String)localObject2).startsWith("http://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = ((String)localObject2).substring("http://clientui.3g.qq.com/mqq/".length());
        }
        else if (((String)localObject2).startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqflyticket://".length());
        }
        else if (((String)localObject2).startsWith("mqqwpa://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqwpa://".length());
        }
        else if (((String)localObject2).startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("wtloginmqq://".length());
        }
        else if (((String)localObject2).startsWith("mqqtribe://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqtribe://".length());
        }
        else if (((String)localObject2).startsWith("mqqverifycode://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqverifycode://".length());
        }
        else if (((String)localObject2).startsWith("mqqvoipivr://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqvoipivr://".length());
        }
        else if (((String)localObject2).startsWith("mqqconnect://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqconnect://".length());
        }
        else if (((String)localObject2).startsWith("mqqdevlock://"))
        {
          paramQQAppInterface = ((String)localObject2).substring("mqqdevlock://".length());
        }
        else
        {
          paramQQAppInterface = str2;
          if (((String)localObject2).startsWith("mqqconferenceflyticket://")) {
            paramQQAppInterface = ((String)localObject2).substring("mqqconferenceflyticket://".length());
          }
        }
      }
      label2605:
      paramContext.fs = paramString;
      paramContext.ft = paramQQAppInterface[0];
      paramContext.fu = paramQQAppInterface[1];
      if (bool3)
      {
        paramQQAppInterface = ((String)localObject1).split("&");
        i1 = 0;
        if (i1 < paramQQAppInterface.length)
        {
          paramString = paramQQAppInterface[i1];
          if (!bool2) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = a(paramString, bool1);
            i2 = paramString.indexOf('=');
            if (i2 > 0) {
              paramContext.a(paramString.substring(0, i2), paramString.substring(i2 + 1, paramString.length()));
            }
            i1 += 1;
            break;
          }
        }
        return paramContext;
      }
      paramQQAppInterface = ((String)localObject1).split("&");
      i1 = 0;
      if (i1 < paramQQAppInterface.length)
      {
        paramString = a(paramQQAppInterface[i1], "=");
        if (paramString.length == 2)
        {
          if (!bool4) {
            break label2783;
          }
          paramContext.a(paramString[0], a(paramString[1], false));
        }
        for (;;)
        {
          i1 += 1;
          break;
          label2783:
          paramContext.a(paramString[0], paramString[1]);
        }
      }
      return paramContext;
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      String str2 = URLDecoder.decode(paramString);
      str1 = str2;
      if (paramBoolean)
      {
        localObject1 = str2;
        str1 = str2.replaceAll(" ", "+");
      }
    }
    catch (Exception localException)
    {
      do
      {
        String str1;
        Object localObject2 = localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("JumpAction", 2, "JumpParser parser Exception =" + paramString);
    }
    return str1;
    return (String)localObject1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = a(paramString, false);
    } while (!Pattern.compile("gamecenter\\s*=\\s*1").matcher(paramString).find());
    return true;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    int i1 = paramString1.indexOf(paramString2);
    if (i1 == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i1), paramString1.substring(i1 + paramString2.length(), paramString1.length()) };
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\JumpParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */