package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MsfRespHandleUtil
{
  public static final String tag = "MSF.D.RespHandleUtil";
  IAuthHandler authHandler;
  IMsfMsgHandler msfMsgHandler;
  INotifyHandler notifyHandler;
  IPushHandler pushHandler;
  IRegisterUinHandler registerUinHandler;
  IServerInfoHandler serverInfoHandler;
  IServerMsgPushHandler serverMsgPushHandler;
  
  public MsfRespHandleUtil(IMsfHandler[] paramArrayOfIMsfHandler)
  {
    if (paramArrayOfIMsfHandler != null)
    {
      int j = paramArrayOfIMsfHandler.length;
      int i = 0;
      if (i < j)
      {
        IMsfHandler localIMsfHandler = paramArrayOfIMsfHandler[i];
        if ((localIMsfHandler instanceof IAuthHandler)) {
          this.authHandler = ((IAuthHandler)localIMsfHandler);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localIMsfHandler instanceof IMsfMsgHandler)) {
            this.msfMsgHandler = ((IMsfMsgHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof INotifyHandler)) {
            this.notifyHandler = ((INotifyHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IServerInfoHandler)) {
            this.serverInfoHandler = ((IServerInfoHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IPushHandler)) {
            this.pushHandler = ((IPushHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IRegisterUinHandler)) {
            this.registerUinHandler = ((IRegisterUinHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IServerMsgPushHandler)) {
            this.serverMsgPushHandler = ((IServerMsgPushHandler)localIMsfHandler);
          }
        }
      }
    }
  }
  
  public boolean handlePushMsg(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1;
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onConnOpened)
        {
          com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 2;
          if (this.serverMsgPushHandler == null) {
            break label494;
          }
          this.serverMsgPushHandler.onConnOpened(paramFromServiceMsg);
          bool2 = true;
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvConfigPush)
          {
            bool1 = bool2;
            if (this.serverMsgPushHandler != null)
            {
              this.serverMsgPushHandler.onRecvServerConfigPush(paramFromServiceMsg);
              bool1 = true;
            }
            if (bool1) {
              break;
            }
            if (this.pushHandler == null) {
              continue;
            }
            this.pushHandler.onRecvCmdPush(paramFromServiceMsg);
            return true;
          }
        }
        else
        {
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onReceFirstResp)
          {
            com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 4;
            if (this.serverMsgPushHandler == null) {
              break label494;
            }
            this.serverMsgPushHandler.onReceFirstResp(paramFromServiceMsg);
            bool2 = true;
            continue;
          }
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onOepnConnAllFailed)
          {
            com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 3;
            if (this.serverMsgPushHandler == null) {
              break label494;
            }
            this.serverMsgPushHandler.onOpenConnAllFailed(paramFromServiceMsg);
            bool2 = true;
            continue;
          }
          if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onConnClosed) {
            break label494;
          }
          com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 1;
          if (this.serverMsgPushHandler == null) {
            break label494;
          }
          this.serverMsgPushHandler.onConnClose(paramFromServiceMsg);
          bool2 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvNotifyMsg)
        {
          bool1 = bool2;
          if (this.notifyHandler == null) {
            continue;
          }
          long l = ((Long)paramFromServiceMsg.getAttributes().get("notifyId")).longValue();
          this.notifyHandler.onRecvNotify(l, paramFromServiceMsg);
          bool1 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.registerPush)
        {
          bool1 = bool2;
          if (this.pushHandler == null) {
            continue;
          }
          this.pushHandler.onRegisterPushResp(null, paramFromServiceMsg);
          bool1 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onTicketChanged)
        {
          bool1 = bool2;
          if (this.pushHandler == null) {
            continue;
          }
          this.pushHandler.onTicketChanged();
          bool1 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onProxyIpChanged)
        {
          bool1 = bool2;
          if (this.pushHandler == null) {
            continue;
          }
          this.pushHandler.onProxyIpChanged(paramFromServiceMsg.getUin());
          bool1 = true;
          continue;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onOverloadPushNotify) {
          continue;
        }
        bool1 = bool2;
        if (this.pushHandler == null) {
          continue;
        }
        String str = (String)paramFromServiceMsg.getAttributes().get("msg");
        this.pushHandler.onOverloadPushNotify(str);
        bool1 = true;
        continue;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 18);
        }
        return false;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("MSF.D.RespHandleUtil", 1, "handle push msg error " + paramFromServiceMsg, paramFromServiceMsg);
        return true;
      }
      label494:
      boolean bool2 = false;
    }
    return bool1;
  }
  
  /* Error */
  public boolean handleRespMsg(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 218	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 7
    //   6: aload_2
    //   7: invokevirtual 221	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   10: istore 8
    //   12: aload_2
    //   13: invokevirtual 224	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   16: astore 5
    //   18: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +28 -> 49
    //   24: ldc 8
    //   26: iconst_2
    //   27: new 193	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   34: ldc -26
    //   36: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_2
    //   50: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   53: getstatic 236	com/tencent/mobileqq/msf/sdk/MsfCommand:loginAuth	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   56: if_acmpeq +13 -> 69
    //   59: aload_2
    //   60: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   63: getstatic 239	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_loginAuth	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   66: if_acmpne +55 -> 121
    //   69: aload_0
    //   70: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   73: ifnull +1611 -> 1684
    //   76: aload_0
    //   77: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   80: iload 7
    //   82: iload 8
    //   84: aload 5
    //   86: aload_1
    //   87: aload_2
    //   88: invokeinterface 243 6 0
    //   93: iconst_1
    //   94: istore 10
    //   96: iload 10
    //   98: ifne +1476 -> 1574
    //   101: aload_0
    //   102: getfield 35	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:msfMsgHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IMsfMsgHandler;
    //   105: ifnull +1648 -> 1753
    //   108: aload_0
    //   109: getfield 35	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:msfMsgHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IMsfMsgHandler;
    //   112: aload_1
    //   113: aload_2
    //   114: invokeinterface 246 3 0
    //   119: iconst_1
    //   120: ireturn
    //   121: aload_2
    //   122: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   125: getstatic 249	com/tencent/mobileqq/msf/sdk/MsfCommand:changeUinLogin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   128: if_acmpeq +13 -> 141
    //   131: aload_2
    //   132: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   135: getstatic 252	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_GetStViaSMSVerifyLogin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   138: if_acmpne +33 -> 171
    //   141: aload_0
    //   142: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   145: ifnull +1539 -> 1684
    //   148: aload_0
    //   149: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   152: iload 7
    //   154: iload 8
    //   156: aload 5
    //   158: aload_1
    //   159: aload_2
    //   160: invokeinterface 255 6 0
    //   165: iconst_1
    //   166: istore 10
    //   168: goto -72 -> 96
    //   171: aload_2
    //   172: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   175: getstatic 258	com/tencent/mobileqq/msf/sdk/MsfCommand:changeToken	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   178: if_acmpeq +13 -> 191
    //   181: aload_2
    //   182: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   185: getstatic 261	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_exchange	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   188: if_acmpne +140 -> 328
    //   191: aload_0
    //   192: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   195: ifnull +1489 -> 1684
    //   198: aconst_null
    //   199: astore 4
    //   201: aload_2
    //   202: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   205: istore 10
    //   207: aload 4
    //   209: astore_3
    //   210: iload 10
    //   212: ifeq +51 -> 263
    //   215: aload_2
    //   216: invokevirtual 188	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   219: astore_3
    //   220: new 266	com/qq/jce/wup/UniPacket
    //   223: dup
    //   224: iconst_1
    //   225: invokespecial 269	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   228: astore 6
    //   230: aload 6
    //   232: ldc_w 271
    //   235: invokevirtual 274	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   238: aload 6
    //   240: aload_3
    //   241: invokevirtual 278	com/qq/jce/wup/UniPacket:decode	([B)V
    //   244: aload 6
    //   246: ldc_w 280
    //   249: new 282	com/tencent/msf/service/protocol/security/RespondCustomSig
    //   252: dup
    //   253: invokespecial 283	com/tencent/msf/service/protocol/security/RespondCustomSig:<init>	()V
    //   256: invokevirtual 287	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 282	com/tencent/msf/service/protocol/security/RespondCustomSig
    //   262: astore_3
    //   263: aload_0
    //   264: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   267: iload 7
    //   269: iload 8
    //   271: aload 5
    //   273: aload_3
    //   274: aload_1
    //   275: aload_2
    //   276: invokeinterface 291 7 0
    //   281: iconst_1
    //   282: istore 10
    //   284: goto -188 -> 96
    //   287: astore_3
    //   288: aload_3
    //   289: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   292: aload 4
    //   294: astore_3
    //   295: goto -32 -> 263
    //   298: astore_1
    //   299: ldc 8
    //   301: iconst_1
    //   302: new 193	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 296
    //   312: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_1
    //   316: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: aload_1
    //   323: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   326: iconst_1
    //   327: ireturn
    //   328: aload_2
    //   329: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   332: getstatic 299	com/tencent/mobileqq/msf/sdk/MsfCommand:submitPuzzleVerifyCodeTicket	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   335: if_acmpne +33 -> 368
    //   338: aload_0
    //   339: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   342: ifnull +1342 -> 1684
    //   345: aload_0
    //   346: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   349: iload 7
    //   351: iload 8
    //   353: aload 5
    //   355: aload_1
    //   356: aload_2
    //   357: invokeinterface 243 6 0
    //   362: iconst_1
    //   363: istore 10
    //   365: goto -269 -> 96
    //   368: aload_2
    //   369: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   372: getstatic 302	com/tencent/mobileqq/msf/sdk/MsfCommand:submitVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   375: if_acmpne +33 -> 408
    //   378: aload_0
    //   379: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   382: ifnull +1302 -> 1684
    //   385: aload_0
    //   386: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   389: iload 7
    //   391: iload 8
    //   393: aload 5
    //   395: aload_1
    //   396: aload_2
    //   397: invokeinterface 243 6 0
    //   402: iconst_1
    //   403: istore 10
    //   405: goto -309 -> 96
    //   408: aload_2
    //   409: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   412: getstatic 305	com/tencent/mobileqq/msf/sdk/MsfCommand:refreVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   415: if_acmpne +33 -> 448
    //   418: aload_0
    //   419: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   422: ifnull +1262 -> 1684
    //   425: aload_0
    //   426: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   429: iload 7
    //   431: iload 8
    //   433: aload 5
    //   435: aload_1
    //   436: aload_2
    //   437: invokeinterface 243 6 0
    //   442: iconst_1
    //   443: istore 10
    //   445: goto -349 -> 96
    //   448: aload_2
    //   449: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   452: getstatic 308	com/tencent/mobileqq/msf/sdk/MsfCommand:delLoginedAccount	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   455: if_acmpne +33 -> 488
    //   458: aload_0
    //   459: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   462: ifnull +1222 -> 1684
    //   465: aload_0
    //   466: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   469: iload 7
    //   471: iload 8
    //   473: aload 5
    //   475: aload_1
    //   476: aload_2
    //   477: invokeinterface 311 6 0
    //   482: iconst_1
    //   483: istore 10
    //   485: goto -389 -> 96
    //   488: aload_2
    //   489: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   492: getstatic 314	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_name2uin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   495: if_acmpne +33 -> 528
    //   498: aload_0
    //   499: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   502: ifnull +1182 -> 1684
    //   505: aload_0
    //   506: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   509: iload 7
    //   511: iload 8
    //   513: aload 5
    //   515: aload_1
    //   516: aload_2
    //   517: invokeinterface 317 6 0
    //   522: iconst_1
    //   523: istore 10
    //   525: goto -429 -> 96
    //   528: aload_2
    //   529: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   532: getstatic 320	com/tencent/mobileqq/msf/sdk/MsfCommand:onRecvVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   535: if_acmpne +33 -> 568
    //   538: aload_0
    //   539: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   542: ifnull +1142 -> 1684
    //   545: aload_2
    //   546: invokestatic 326	com/tencent/mobileqq/msf/sdk/VerifyCodeInfo:getVerifyCodeInfo	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Lcom/tencent/mobileqq/msf/sdk/VerifyCodeInfo;
    //   549: astore_3
    //   550: aload_0
    //   551: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   554: aload_3
    //   555: aload_1
    //   556: aload_2
    //   557: invokeinterface 330 4 0
    //   562: iconst_1
    //   563: istore 10
    //   565: goto -469 -> 96
    //   568: aload_2
    //   569: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   572: getstatic 333	com/tencent/mobileqq/msf/sdk/MsfCommand:reportMsg	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   575: if_acmpne +33 -> 608
    //   578: aload_0
    //   579: getfield 43	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:serverInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IServerInfoHandler;
    //   582: ifnull +1102 -> 1684
    //   585: aload_0
    //   586: getfield 43	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:serverInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IServerInfoHandler;
    //   589: iload 7
    //   591: iload 8
    //   593: aload 5
    //   595: aload_1
    //   596: aload_2
    //   597: invokeinterface 336 6 0
    //   602: iconst_1
    //   603: istore 10
    //   605: goto -509 -> 96
    //   608: aload_2
    //   609: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   612: getstatic 339	com/tencent/mobileqq/msf/sdk/MsfCommand:getServerConfig	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   615: if_acmpne +96 -> 711
    //   618: aload_2
    //   619: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   622: istore 10
    //   624: iload 10
    //   626: ifeq +49 -> 675
    //   629: aload_2
    //   630: invokevirtual 114	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   633: ldc_w 341
    //   636: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   639: checkcast 343	java/lang/Integer
    //   642: invokevirtual 346	java/lang/Integer:intValue	()I
    //   645: istore 7
    //   647: aload_2
    //   648: invokevirtual 114	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   651: ldc_w 348
    //   654: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   657: checkcast 161	java/lang/String
    //   660: astore_3
    //   661: aload_1
    //   662: invokestatic 353	com/tencent/mobileqq/msf/service/g:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   665: iload 7
    //   667: aload_3
    //   668: aload_1
    //   669: invokevirtual 356	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   672: invokestatic 362	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:writeServerConfig	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   675: iconst_1
    //   676: istore 10
    //   678: goto -582 -> 96
    //   681: astore_3
    //   682: ldc 8
    //   684: iconst_1
    //   685: new 193	java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   692: ldc_w 364
    //   695: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: aload_3
    //   699: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: goto -33 -> 675
    //   711: aload_2
    //   712: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   715: getstatic 135	com/tencent/mobileqq/msf/sdk/MsfCommand:registerPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   718: if_acmpne +27 -> 745
    //   721: aload_0
    //   722: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   725: ifnull +959 -> 1684
    //   728: aload_0
    //   729: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   732: aload_1
    //   733: aload_2
    //   734: invokeinterface 139 3 0
    //   739: iconst_1
    //   740: istore 10
    //   742: goto -646 -> 96
    //   745: aload_2
    //   746: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   749: getstatic 370	com/tencent/mobileqq/msf/sdk/MsfCommand:unRegisterPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   752: if_acmpne +27 -> 779
    //   755: aload_0
    //   756: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   759: ifnull +925 -> 1684
    //   762: aload_0
    //   763: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   766: aload_1
    //   767: aload_2
    //   768: invokeinterface 373 3 0
    //   773: iconst_1
    //   774: istore 10
    //   776: goto -680 -> 96
    //   779: aload_2
    //   780: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   783: getstatic 376	com/tencent/mobileqq/msf/sdk/MsfCommand:registerCmdCallback	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   786: if_acmpne +27 -> 813
    //   789: aload_0
    //   790: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   793: ifnull +891 -> 1684
    //   796: aload_0
    //   797: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   800: aload_1
    //   801: aload_2
    //   802: invokeinterface 379 3 0
    //   807: iconst_1
    //   808: istore 10
    //   810: goto -714 -> 96
    //   813: aload_2
    //   814: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   817: getstatic 382	com/tencent/mobileqq/msf/sdk/MsfCommand:resetCmdCallback	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   820: if_acmpne +27 -> 847
    //   823: aload_0
    //   824: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   827: ifnull +857 -> 1684
    //   830: aload_0
    //   831: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   834: aload_1
    //   835: aload_2
    //   836: invokeinterface 385 3 0
    //   841: iconst_1
    //   842: istore 10
    //   844: goto -748 -> 96
    //   847: aload_2
    //   848: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   851: getstatic 388	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_queryMobile	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   854: if_acmpne +88 -> 942
    //   857: aload_0
    //   858: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   861: ifnull +823 -> 1684
    //   864: iconst_0
    //   865: newarray <illegal type>
    //   867: astore_3
    //   868: aload_2
    //   869: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   872: ifeq +875 -> 1747
    //   875: aload_2
    //   876: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   879: ldc_w 394
    //   882: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   885: checkcast 343	java/lang/Integer
    //   888: invokevirtual 346	java/lang/Integer:intValue	()I
    //   891: istore 7
    //   893: aload_2
    //   894: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   897: ldc_w 396
    //   900: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   903: checkcast 398	[B
    //   906: checkcast 398	[B
    //   909: astore 4
    //   911: aload 4
    //   913: astore_3
    //   914: aload_0
    //   915: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   918: iload 7
    //   920: aload_3
    //   921: aload_1
    //   922: aload_2
    //   923: invokeinterface 402 5 0
    //   928: iconst_1
    //   929: istore 10
    //   931: goto -835 -> 96
    //   934: aload 4
    //   936: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   939: goto -25 -> 914
    //   942: aload_2
    //   943: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   946: getstatic 405	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitMobile	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   949: if_acmpne +116 -> 1065
    //   952: aload_0
    //   953: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   956: ifnull +728 -> 1684
    //   959: iconst_0
    //   960: newarray <illegal type>
    //   962: astore 5
    //   964: iconst_0
    //   965: newarray <illegal type>
    //   967: astore 4
    //   969: aload_2
    //   970: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   973: ifeq +761 -> 1734
    //   976: aload_2
    //   977: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   980: ldc_w 394
    //   983: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   986: checkcast 343	java/lang/Integer
    //   989: invokevirtual 346	java/lang/Integer:intValue	()I
    //   992: istore 7
    //   994: aload_2
    //   995: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   998: ldc_w 396
    //   1001: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: checkcast 398	[B
    //   1007: checkcast 398	[B
    //   1010: astore_3
    //   1011: aload_2
    //   1012: ldc_w 407
    //   1015: iconst_0
    //   1016: newarray <illegal type>
    //   1018: invokevirtual 410	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1021: checkcast 398	[B
    //   1024: checkcast 398	[B
    //   1027: astore 4
    //   1029: aload_0
    //   1030: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1033: iload 7
    //   1035: aload_3
    //   1036: aload 4
    //   1038: aload_1
    //   1039: aload_2
    //   1040: invokeinterface 414 6 0
    //   1045: iconst_1
    //   1046: istore 10
    //   1048: goto -952 -> 96
    //   1051: aload_3
    //   1052: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   1055: aload 4
    //   1057: astore_3
    //   1058: aload 5
    //   1060: astore 4
    //   1062: goto -33 -> 1029
    //   1065: aload_2
    //   1066: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1069: getstatic 417	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_reSendSms	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1072: if_acmpne +130 -> 1202
    //   1075: aload_0
    //   1076: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1079: ifnull +605 -> 1684
    //   1082: iconst_0
    //   1083: newarray <illegal type>
    //   1085: astore 4
    //   1087: aload_2
    //   1088: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1091: ifeq +628 -> 1719
    //   1094: aload_2
    //   1095: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1098: ldc_w 394
    //   1101: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1104: checkcast 343	java/lang/Integer
    //   1107: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1110: istore 8
    //   1112: aload_2
    //   1113: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1116: ldc_w 396
    //   1119: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1122: checkcast 398	[B
    //   1125: checkcast 398	[B
    //   1128: astore_3
    //   1129: aload_2
    //   1130: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1133: ldc_w 419
    //   1136: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1139: checkcast 343	java/lang/Integer
    //   1142: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1145: istore 7
    //   1147: aload_2
    //   1148: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1151: ldc_w 421
    //   1154: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1157: checkcast 343	java/lang/Integer
    //   1160: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1163: istore 9
    //   1165: aload_0
    //   1166: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1169: iload 8
    //   1171: aload_3
    //   1172: iload 7
    //   1174: iload 9
    //   1176: aload_1
    //   1177: aload_2
    //   1178: invokeinterface 425 7 0
    //   1183: iconst_1
    //   1184: istore 10
    //   1186: goto -1090 -> 96
    //   1189: aload_3
    //   1190: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   1193: iconst_0
    //   1194: istore 9
    //   1196: aload 4
    //   1198: astore_3
    //   1199: goto -34 -> 1165
    //   1202: aload_2
    //   1203: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1206: getstatic 428	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitSmsCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1209: if_acmpne +64 -> 1273
    //   1212: aload_0
    //   1213: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1216: astore_3
    //   1217: aload_3
    //   1218: ifnull +466 -> 1684
    //   1221: aload_2
    //   1222: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1225: ifeq +555 -> 1780
    //   1228: aload_2
    //   1229: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1232: ldc_w 394
    //   1235: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1238: checkcast 343	java/lang/Integer
    //   1241: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1244: istore 7
    //   1246: aload_0
    //   1247: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1250: iload 7
    //   1252: aload_1
    //   1253: aload_2
    //   1254: invokeinterface 432 4 0
    //   1259: iconst_1
    //   1260: istore 10
    //   1262: goto -1166 -> 96
    //   1265: astore_3
    //   1266: aload_3
    //   1267: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   1270: goto +510 -> 1780
    //   1273: aload_2
    //   1274: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1277: getstatic 435	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitPass	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1280: if_acmpne +113 -> 1393
    //   1283: aload_0
    //   1284: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1287: ifnull +397 -> 1684
    //   1290: ldc_w 437
    //   1293: astore 4
    //   1295: iconst_0
    //   1296: newarray <illegal type>
    //   1298: astore 5
    //   1300: aload_2
    //   1301: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1304: ifeq +401 -> 1705
    //   1307: aload_2
    //   1308: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1311: ldc_w 394
    //   1314: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1317: checkcast 343	java/lang/Integer
    //   1320: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1323: istore 7
    //   1325: aload_2
    //   1326: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1329: ldc_w 439
    //   1332: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1335: checkcast 161	java/lang/String
    //   1338: astore_3
    //   1339: aload_2
    //   1340: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1343: ldc_w 441
    //   1346: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1349: checkcast 398	[B
    //   1352: checkcast 398	[B
    //   1355: astore 4
    //   1357: aload_0
    //   1358: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1361: iload 7
    //   1363: aload_3
    //   1364: aload 4
    //   1366: aload_1
    //   1367: aload_2
    //   1368: invokeinterface 445 6 0
    //   1373: iconst_1
    //   1374: istore 10
    //   1376: goto -1280 -> 96
    //   1379: aload_3
    //   1380: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   1383: aload 4
    //   1385: astore_3
    //   1386: aload 5
    //   1388: astore 4
    //   1390: goto -33 -> 1357
    //   1393: aload_2
    //   1394: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1397: getstatic 448	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_querySmsStat	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1400: if_acmpne +130 -> 1530
    //   1403: aload_0
    //   1404: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1407: ifnull +277 -> 1684
    //   1410: iconst_0
    //   1411: newarray <illegal type>
    //   1413: astore 4
    //   1415: aload_2
    //   1416: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1419: ifeq +271 -> 1690
    //   1422: aload_2
    //   1423: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1426: ldc_w 394
    //   1429: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1432: checkcast 343	java/lang/Integer
    //   1435: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1438: istore 8
    //   1440: aload_2
    //   1441: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1444: ldc_w 396
    //   1447: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1450: checkcast 398	[B
    //   1453: checkcast 398	[B
    //   1456: astore_3
    //   1457: aload_2
    //   1458: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1461: ldc_w 419
    //   1464: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1467: checkcast 343	java/lang/Integer
    //   1470: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1473: istore 7
    //   1475: aload_2
    //   1476: getfield 392	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1479: ldc_w 421
    //   1482: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1485: checkcast 343	java/lang/Integer
    //   1488: invokevirtual 346	java/lang/Integer:intValue	()I
    //   1491: istore 9
    //   1493: aload_0
    //   1494: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1497: iload 8
    //   1499: aload_3
    //   1500: iload 7
    //   1502: iload 9
    //   1504: aload_1
    //   1505: aload_2
    //   1506: invokeinterface 451 7 0
    //   1511: iconst_1
    //   1512: istore 10
    //   1514: goto -1418 -> 96
    //   1517: aload_3
    //   1518: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   1521: iconst_0
    //   1522: istore 9
    //   1524: aload 4
    //   1526: astore_3
    //   1527: goto -34 -> 1493
    //   1530: aload_2
    //   1531: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1534: getstatic 454	com/tencent/mobileqq/msf/sdk/MsfCommand:getKey	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1537: if_acmpne +147 -> 1684
    //   1540: aload_0
    //   1541: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   1544: astore_3
    //   1545: aload_3
    //   1546: ifnull +138 -> 1684
    //   1549: aload_0
    //   1550: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   1553: aload_1
    //   1554: aload_2
    //   1555: invokeinterface 457 3 0
    //   1560: iconst_1
    //   1561: istore 10
    //   1563: goto -1467 -> 96
    //   1566: astore_3
    //   1567: aload_3
    //   1568: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   1571: goto -11 -> 1560
    //   1574: iload 10
    //   1576: ireturn
    //   1577: astore_3
    //   1578: iconst_0
    //   1579: istore 7
    //   1581: goto -64 -> 1517
    //   1584: astore 4
    //   1586: iconst_0
    //   1587: istore 7
    //   1589: aload_3
    //   1590: astore 5
    //   1592: aload 4
    //   1594: astore_3
    //   1595: aload 5
    //   1597: astore 4
    //   1599: goto -82 -> 1517
    //   1602: astore 5
    //   1604: aload_3
    //   1605: astore 4
    //   1607: aload 5
    //   1609: astore_3
    //   1610: goto -93 -> 1517
    //   1613: astore_3
    //   1614: goto -235 -> 1379
    //   1617: astore 6
    //   1619: aload_3
    //   1620: astore 4
    //   1622: aload 6
    //   1624: astore_3
    //   1625: goto -246 -> 1379
    //   1628: astore_3
    //   1629: iconst_0
    //   1630: istore 7
    //   1632: goto -443 -> 1189
    //   1635: astore 4
    //   1637: iconst_0
    //   1638: istore 7
    //   1640: aload_3
    //   1641: astore 5
    //   1643: aload 4
    //   1645: astore_3
    //   1646: aload 5
    //   1648: astore 4
    //   1650: goto -461 -> 1189
    //   1653: astore 5
    //   1655: aload_3
    //   1656: astore 4
    //   1658: aload 5
    //   1660: astore_3
    //   1661: goto -472 -> 1189
    //   1664: astore_3
    //   1665: goto -614 -> 1051
    //   1668: astore 6
    //   1670: aload_3
    //   1671: astore 4
    //   1673: aload 6
    //   1675: astore_3
    //   1676: goto -625 -> 1051
    //   1679: astore 4
    //   1681: goto -747 -> 934
    //   1684: iconst_0
    //   1685: istore 10
    //   1687: goto -1591 -> 96
    //   1690: aload 4
    //   1692: astore_3
    //   1693: iconst_0
    //   1694: istore 7
    //   1696: iconst_0
    //   1697: istore 8
    //   1699: iconst_0
    //   1700: istore 9
    //   1702: goto -209 -> 1493
    //   1705: ldc_w 437
    //   1708: astore_3
    //   1709: aload 5
    //   1711: astore 4
    //   1713: iconst_0
    //   1714: istore 7
    //   1716: goto -359 -> 1357
    //   1719: aload 4
    //   1721: astore_3
    //   1722: iconst_0
    //   1723: istore 7
    //   1725: iconst_0
    //   1726: istore 8
    //   1728: iconst_0
    //   1729: istore 9
    //   1731: goto -566 -> 1165
    //   1734: aload 4
    //   1736: astore_3
    //   1737: aload 5
    //   1739: astore 4
    //   1741: iconst_0
    //   1742: istore 7
    //   1744: goto -715 -> 1029
    //   1747: iconst_0
    //   1748: istore 7
    //   1750: goto -836 -> 914
    //   1753: iconst_0
    //   1754: ireturn
    //   1755: astore 4
    //   1757: iconst_0
    //   1758: istore 7
    //   1760: goto -826 -> 934
    //   1763: astore_3
    //   1764: iconst_0
    //   1765: istore 7
    //   1767: goto -716 -> 1051
    //   1770: astore_3
    //   1771: iconst_0
    //   1772: istore 7
    //   1774: iconst_0
    //   1775: istore 8
    //   1777: goto -588 -> 1189
    //   1780: iconst_0
    //   1781: istore 7
    //   1783: goto -537 -> 1246
    //   1786: astore_3
    //   1787: iconst_0
    //   1788: istore 7
    //   1790: goto -411 -> 1379
    //   1793: astore_3
    //   1794: iconst_0
    //   1795: istore 7
    //   1797: iconst_0
    //   1798: istore 8
    //   1800: goto -283 -> 1517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1803	0	this	MsfRespHandleUtil
    //   0	1803	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	1803	2	paramFromServiceMsg	FromServiceMsg
    //   209	65	3	localObject1	Object
    //   287	2	3	localException1	Exception
    //   294	374	3	localObject2	Object
    //   681	18	3	localException2	Exception
    //   867	351	3	localObject3	Object
    //   1265	2	3	localException3	Exception
    //   1338	208	3	localObject4	Object
    //   1566	2	3	localException4	Exception
    //   1577	13	3	localException5	Exception
    //   1594	16	3	localException6	Exception
    //   1613	7	3	localException7	Exception
    //   1624	1	3	localObject5	Object
    //   1628	13	3	localException8	Exception
    //   1645	16	3	localException9	Exception
    //   1664	7	3	localException10	Exception
    //   1675	62	3	localObject6	Object
    //   1763	1	3	localException11	Exception
    //   1770	1	3	localException12	Exception
    //   1786	1	3	localException13	Exception
    //   1793	1	3	localException14	Exception
    //   199	1326	4	localObject7	Object
    //   1584	9	4	localException15	Exception
    //   1597	24	4	localObject8	Object
    //   1635	9	4	localException16	Exception
    //   1648	24	4	localObject9	Object
    //   1679	12	4	localException17	Exception
    //   1711	29	4	localException18	Exception
    //   1755	1	4	localException19	Exception
    //   16	1580	5	localObject10	Object
    //   1602	6	5	localException20	Exception
    //   1641	6	5	localObject11	Object
    //   1653	85	5	localException21	Exception
    //   228	17	6	localUniPacket	com.qq.jce.wup.UniPacket
    //   1617	6	6	localException22	Exception
    //   1668	6	6	localException23	Exception
    //   4	1792	7	i	int
    //   10	1789	8	j	int
    //   1163	567	9	k	int
    //   94	1592	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   215	263	287	java/lang/Exception
    //   0	49	298	java/lang/Exception
    //   49	69	298	java/lang/Exception
    //   69	93	298	java/lang/Exception
    //   101	119	298	java/lang/Exception
    //   121	141	298	java/lang/Exception
    //   141	165	298	java/lang/Exception
    //   171	191	298	java/lang/Exception
    //   191	198	298	java/lang/Exception
    //   201	207	298	java/lang/Exception
    //   263	281	298	java/lang/Exception
    //   288	292	298	java/lang/Exception
    //   328	362	298	java/lang/Exception
    //   368	402	298	java/lang/Exception
    //   408	442	298	java/lang/Exception
    //   448	482	298	java/lang/Exception
    //   488	522	298	java/lang/Exception
    //   528	562	298	java/lang/Exception
    //   568	602	298	java/lang/Exception
    //   608	624	298	java/lang/Exception
    //   682	708	298	java/lang/Exception
    //   711	739	298	java/lang/Exception
    //   745	773	298	java/lang/Exception
    //   779	807	298	java/lang/Exception
    //   813	841	298	java/lang/Exception
    //   847	868	298	java/lang/Exception
    //   914	928	298	java/lang/Exception
    //   934	939	298	java/lang/Exception
    //   942	969	298	java/lang/Exception
    //   1029	1045	298	java/lang/Exception
    //   1051	1055	298	java/lang/Exception
    //   1065	1087	298	java/lang/Exception
    //   1165	1183	298	java/lang/Exception
    //   1189	1193	298	java/lang/Exception
    //   1202	1217	298	java/lang/Exception
    //   1246	1259	298	java/lang/Exception
    //   1266	1270	298	java/lang/Exception
    //   1273	1290	298	java/lang/Exception
    //   1295	1300	298	java/lang/Exception
    //   1357	1373	298	java/lang/Exception
    //   1379	1383	298	java/lang/Exception
    //   1393	1415	298	java/lang/Exception
    //   1493	1511	298	java/lang/Exception
    //   1517	1521	298	java/lang/Exception
    //   1530	1545	298	java/lang/Exception
    //   1567	1571	298	java/lang/Exception
    //   629	675	681	java/lang/Exception
    //   1221	1246	1265	java/lang/Exception
    //   1549	1560	1566	java/lang/Exception
    //   1440	1457	1577	java/lang/Exception
    //   1457	1475	1584	java/lang/Exception
    //   1475	1493	1602	java/lang/Exception
    //   1325	1339	1613	java/lang/Exception
    //   1339	1357	1617	java/lang/Exception
    //   1112	1129	1628	java/lang/Exception
    //   1129	1147	1635	java/lang/Exception
    //   1147	1165	1653	java/lang/Exception
    //   994	1011	1664	java/lang/Exception
    //   1011	1029	1668	java/lang/Exception
    //   893	911	1679	java/lang/Exception
    //   868	893	1755	java/lang/Exception
    //   969	994	1763	java/lang/Exception
    //   1087	1112	1770	java/lang/Exception
    //   1300	1325	1786	java/lang/Exception
    //   1415	1440	1793	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\MsfRespHandleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */