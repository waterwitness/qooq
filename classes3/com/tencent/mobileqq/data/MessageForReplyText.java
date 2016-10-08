package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.GroupPostElemInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;

public class MessageForReplyText
  extends ChatMessage
{
  public String action;
  public TroopTopicMgr.GroupPostElemInfo mGroupPostElemInfo;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public int msgVia;
  public CharSequence sb;
  
  public MessageForReplyText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void reportReplyMsg(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, ChatMessage paramChatMessage)
  {
    int i;
    Object localObject;
    if (paramChatMessage != null)
    {
      i = 0;
      switch (paramChatMessage.msgtype)
      {
      default: 
        localObject = "";
      }
    }
    for (;;)
    {
      String str = i + "";
      if (AnonymousChatHelper.a(paramChatMessage))
      {
        paramChatMessage = "1";
        label118:
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_replyMsg", "", paramString1, paramString2, 0, 0, paramString3, str, paramChatMessage, (String)localObject);
        return;
        i = 0;
        localObject = "";
        continue;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label295;
        }
        localObject = (MessageForStructing)paramChatMessage;
        if (((MessageForStructing)localObject).structingMsg == null) {
          break label288;
        }
      }
      label288:
      for (localObject = ((MessageForStructing)localObject).structingMsg.mMsgServiceID + "";; localObject = "")
      {
        i = 10;
        break;
        i = 5;
        localObject = "";
        break;
        i = 2;
        localObject = "";
        break;
        i = 3;
        localObject = "";
        break;
        i = 4;
        localObject = "";
        break;
        i = 7;
        localObject = "";
        break;
        paramChatMessage = "0";
        break label118;
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_replyMsg", "", paramString1, paramString2, 0, 0, paramString3, "", "", "");
        return;
      }
      label295:
      localObject = "";
      i = 10;
    }
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: new 85	com/tencent/mobileqq/text/QQText
    //   9: dup
    //   10: aload_2
    //   11: bipush 13
    //   13: bipush 32
    //   15: aload_0
    //   16: invokespecial 88	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;IILcom/tencent/mobileqq/data/MessageRecord;)V
    //   19: putfield 90	com/tencent/mobileqq/data/MessageForReplyText:sb	Ljava/lang/CharSequence;
    //   22: aload_0
    //   23: ldc 92
    //   25: invokevirtual 96	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +145 -> 178
    //   36: aload_1
    //   37: invokestatic 108	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   40: istore 4
    //   42: iload 4
    //   44: ifeq +313 -> 357
    //   47: getstatic 114	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   50: instanceof 116
    //   53: ifne +12 -> 65
    //   56: getstatic 114	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   59: instanceof 118
    //   62: ifeq +295 -> 357
    //   65: iconst_0
    //   66: istore 4
    //   68: aload_0
    //   69: ldc 120
    //   71: invokevirtual 96	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +17 -> 96
    //   82: aload_0
    //   83: aload_1
    //   84: invokestatic 125	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   87: invokestatic 130	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   90: checkcast 132	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo
    //   93: putfield 134	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   96: aload_0
    //   97: ldc -120
    //   99: invokevirtual 96	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_1
    //   103: aload_1
    //   104: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +60 -> 167
    //   110: aload_0
    //   111: aload_1
    //   112: invokestatic 125	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   115: invokestatic 130	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   118: checkcast 138	com/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo
    //   121: putfield 140	com/tencent/mobileqq/data/MessageForReplyText:mGroupPostElemInfo	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo;
    //   124: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +40 -> 167
    //   130: new 34	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   137: ldc -108
    //   139: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: astore_3
    //   143: aload_0
    //   144: getfield 140	com/tencent/mobileqq/data/MessageForReplyText:mGroupPostElemInfo	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo;
    //   147: ifnonnull +75 -> 222
    //   150: ldc -106
    //   152: astore_1
    //   153: ldc -104
    //   155: iconst_2
    //   156: aload_3
    //   157: aload_1
    //   158: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iload 4
    //   169: ifne +102 -> 271
    //   172: return
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   178: iconst_1
    //   179: istore 4
    //   181: goto -139 -> 42
    //   184: astore_1
    //   185: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -92 -> 96
    //   191: ldc -104
    //   193: iconst_2
    //   194: new 34	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   201: ldc -95
    //   203: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   210: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: goto -123 -> 96
    //   222: aload_0
    //   223: getfield 140	com/tencent/mobileqq/data/MessageForReplyText:mGroupPostElemInfo	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo;
    //   226: invokevirtual 165	com/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo:toString	()Ljava/lang/String;
    //   229: astore_1
    //   230: goto -77 -> 153
    //   233: astore_1
    //   234: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq -70 -> 167
    //   240: ldc -104
    //   242: iconst_2
    //   243: new 34	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   250: ldc -95
    //   252: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: goto -101 -> 167
    //   271: aload_0
    //   272: ldc -89
    //   274: invokevirtual 96	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_1
    //   279: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifne -110 -> 172
    //   285: aload_0
    //   286: ldc -87
    //   288: invokevirtual 96	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore_3
    //   292: aload_3
    //   293: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifne +55 -> 351
    //   299: aload_3
    //   300: ldc 54
    //   302: invokevirtual 174	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   305: ifeq +46 -> 351
    //   308: iconst_1
    //   309: istore 4
    //   311: iload 4
    //   313: ifne +10 -> 323
    //   316: aload_0
    //   317: ldc -80
    //   319: aload_2
    //   320: invokevirtual 180	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: new 182	java/util/concurrent/CopyOnWriteArrayList
    //   326: dup
    //   327: invokespecial 183	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   330: astore_2
    //   331: aload_2
    //   332: aload_0
    //   333: invokeinterface 189 2 0
    //   338: pop
    //   339: aload_0
    //   340: aload_2
    //   341: iload 4
    //   343: aload_1
    //   344: invokestatic 125	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   347: invokestatic 194	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/util/List;Z[B)V
    //   350: return
    //   351: iconst_0
    //   352: istore 4
    //   354: goto -43 -> 311
    //   357: goto -289 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	MessageForReplyText
    //   28	130	1	str1	String
    //   173	2	1	localException1	Exception
    //   184	23	1	localException2	Exception
    //   229	1	1	str2	String
    //   233	23	1	localException3	Exception
    //   277	67	1	str3	String
    //   4	337	2	localObject1	Object
    //   142	158	3	localObject2	Object
    //   40	313	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   36	42	173	java/lang/Exception
    //   68	96	184	java/lang/Exception
    //   96	150	233	java/lang/Exception
    //   153	167	233	java/lang/Exception
    //   222	230	233	java/lang/Exception
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.w(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
    try
    {
      saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.a(MessagePkgUtils.a(this.mSourceMsgInfo)));
      saveExtInfoToExtStr("sens_msg_source_msg_troop_topic_info", HexUtil.a(MessagePkgUtils.a(this.mGroupPostElemInfo)));
      this.extLong |= 0x1;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.", 2, "prewrite MessageForReplyText exception:" + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForReplyText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */