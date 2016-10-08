package com.tencent.mobileqq.emosm;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DataFactory$EmojiPayReqData
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public DataFactory$EmojiPayReqData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
  }
  
  public DataFactory$EmojiPayReqData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramString11;
    this.l = paramString12;
  }
  
  public static EmojiPayReqData a(Bundle paramBundle)
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    if (paramBundle != null)
    {
      str1 = paramBundle.getString("callbackid");
      str2 = paramBundle.getString("appid");
      str3 = paramBundle.getString("userId");
      str4 = paramBundle.getString("userKey");
      str5 = paramBundle.getString("sessionId");
      str6 = paramBundle.getString("sessionType");
      str7 = paramBundle.getString("zoneId");
      str8 = paramBundle.getString("pf");
      str9 = paramBundle.getString("pfKey");
      str10 = paramBundle.getString("tokenUrl");
      str11 = paramBundle.getString("discountId");
      str12 = paramBundle.getString("other");
    }
    return new EmojiPayReqData(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackid", this.a);
    localBundle.putString("appid", this.b);
    localBundle.putString("userId", this.c);
    localBundle.putString("userKey", this.d);
    localBundle.putString("sessionId", this.e);
    localBundle.putString("sessionType", this.f);
    localBundle.putString("zoneId", this.g);
    localBundle.putString("pf", this.h);
    localBundle.putString("pfKey", this.i);
    localBundle.putString("tokenUrl", this.j);
    return localBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\DataFactory$EmojiPayReqData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */