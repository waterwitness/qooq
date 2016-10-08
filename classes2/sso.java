import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyManager.AsyncRequestCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;

public class sso
  implements GamePartyManager.AsyncRequestCallback
{
  public sso(GamePartyManager paramGamePartyManager, long paramLong1, SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, long paramLong2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: new 38	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 40	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc 42
    //   10: invokevirtual 46	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   13: ldc 48
    //   15: invokevirtual 52	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 58	org/json/JSONArray:length	()I
    //   23: ifle +461 -> 484
    //   26: aload_1
    //   27: iconst_0
    //   28: invokevirtual 61	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   31: astore_1
    //   32: aload_1
    //   33: ldc 63
    //   35: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   38: istore_3
    //   39: iload_3
    //   40: istore 4
    //   42: iload_3
    //   43: ifgt +8 -> 51
    //   46: getstatic 72	com/tencent/mobileqq/gameparty/GamePartyManager:b	I
    //   49: istore 4
    //   51: aload_1
    //   52: ldc 74
    //   54: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   57: istore_3
    //   58: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +51 -> 112
    //   64: invokestatic 83	com/tencent/mobileqq/gameparty/GamePartyManager:a	()Ljava/lang/String;
    //   67: iconst_2
    //   68: new 85	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   75: ldc 88
    //   77: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 18	sso:jdField_a_of_type_Long	J
    //   84: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: ldc 97
    //   89: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 4
    //   94: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc 102
    //   99: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_3
    //   103: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_0
    //   113: getfield 18	sso:jdField_a_of_type_Long	J
    //   116: iload 4
    //   118: i2l
    //   119: lcmp
    //   120: ifge +302 -> 422
    //   123: aload_1
    //   124: ldc 111
    //   126: invokevirtual 46	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   129: astore_1
    //   130: aload_0
    //   131: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   134: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   137: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   140: aload_1
    //   141: ldc 119
    //   143: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: istore 5
    //   151: iload_3
    //   152: ifle +270 -> 422
    //   155: iload_3
    //   156: iconst_5
    //   157: if_icmpge +265 -> 422
    //   160: new 131	android/content/Intent
    //   163: dup
    //   164: aload_0
    //   165: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   168: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   171: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   174: invokevirtual 140	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   177: ldc -114
    //   179: invokespecial 145	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   182: astore_1
    //   183: aload_1
    //   184: ldc -110
    //   186: invokevirtual 150	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   189: pop
    //   190: aload_1
    //   191: ldc -104
    //   193: aload_0
    //   194: getfield 20	sso:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage	Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage;
    //   197: getfield 158	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   200: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   203: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   206: pop
    //   207: aload_1
    //   208: ldc -87
    //   210: aload_0
    //   211: getfield 20	sso:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage	Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage;
    //   214: getfield 172	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage:str_summary	Lcom/tencent/mobileqq/pb/PBStringField;
    //   217: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   220: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   223: pop
    //   224: aload_1
    //   225: ldc -82
    //   227: aload_0
    //   228: getfield 20	sso:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage	Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage;
    //   231: getfield 177	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage:str_picUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   234: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   237: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   240: pop
    //   241: aload_1
    //   242: ldc -77
    //   244: aload_0
    //   245: getfield 20	sso:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage	Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage;
    //   248: getfield 182	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage:str_appid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   251: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   254: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   257: pop
    //   258: aload_1
    //   259: ldc -72
    //   261: aload_0
    //   262: getfield 20	sso:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage	Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage;
    //   265: getfield 187	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage:str_packageName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   268: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   271: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   274: pop
    //   275: aload_1
    //   276: ldc -67
    //   278: aload_0
    //   279: getfield 20	sso:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage	Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage;
    //   282: getfield 192	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$GameTeam_StartGameMessage:str_gamedata	Lcom/tencent/mobileqq/pb/PBStringField;
    //   285: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   288: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   291: pop
    //   292: aload_1
    //   293: ldc 111
    //   295: iload 5
    //   297: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   300: pop
    //   301: aload_1
    //   302: ldc -59
    //   304: aload_0
    //   305: getfield 22	sso:b	J
    //   308: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   311: pop
    //   312: aload_0
    //   313: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   316: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   319: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   322: aload_1
    //   323: invokevirtual 204	com/tencent/qphone/base/util/BaseApplication:startActivity	(Landroid/content/Intent;)V
    //   326: aload_0
    //   327: getfield 24	sso:jdField_a_of_type_Boolean	Z
    //   330: ifeq +31 -> 361
    //   333: invokestatic 209	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   336: aload_0
    //   337: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   340: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   343: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   346: ldc -45
    //   348: ldc -45
    //   350: ldc -43
    //   352: ldc -41
    //   354: ldc -39
    //   356: iconst_0
    //   357: invokevirtual 220	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   360: return
    //   361: invokestatic 209	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   364: aload_0
    //   365: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   368: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   371: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   374: ldc -45
    //   376: ldc -45
    //   378: ldc -43
    //   380: ldc -34
    //   382: ldc -39
    //   384: iconst_0
    //   385: invokevirtual 220	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   388: return
    //   389: astore_1
    //   390: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +29 -> 422
    //   396: invokestatic 83	com/tencent/mobileqq/gameparty/GamePartyManager:a	()Ljava/lang/String;
    //   399: iconst_2
    //   400: new 85	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   407: ldc -32
    //   409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload_0
    //   423: getfield 24	sso:jdField_a_of_type_Boolean	Z
    //   426: ifeq +31 -> 457
    //   429: invokestatic 209	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   432: aload_0
    //   433: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   436: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   439: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   442: ldc -45
    //   444: ldc -45
    //   446: ldc -43
    //   448: ldc -41
    //   450: ldc -27
    //   452: iconst_0
    //   453: invokevirtual 220	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   456: return
    //   457: invokestatic 209	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   460: aload_0
    //   461: getfield 16	sso:jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager	Lcom/tencent/mobileqq/gameparty/GamePartyManager;
    //   464: invokestatic 114	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Lcom/tencent/mobileqq/gameparty/GamePartyManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   467: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   470: ldc -45
    //   472: ldc -45
    //   474: ldc -43
    //   476: ldc -34
    //   478: ldc -27
    //   480: iconst_0
    //   481: invokevirtual 220	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   484: return
    //   485: astore_2
    //   486: iconst_0
    //   487: istore_3
    //   488: goto -449 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	sso
    //   0	491	1	paramString	String
    //   485	1	2	localJSONException	org.json.JSONException
    //   38	450	3	i	int
    //   40	77	4	j	int
    //   149	147	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	32	389	org/json/JSONException
    //   46	51	389	org/json/JSONException
    //   51	112	389	org/json/JSONException
    //   112	151	389	org/json/JSONException
    //   160	360	389	org/json/JSONException
    //   361	388	389	org/json/JSONException
    //   32	39	485	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */