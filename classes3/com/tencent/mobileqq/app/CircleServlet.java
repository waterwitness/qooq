package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.cmd0x6ff.subcmd0x111.ContentItem;
import tencent.im.cs.cmd0x6ff.subcmd0x111.GeneralBuffer;
import tencent.im.cs.cmd0x6ff.subcmd0x111.RenMaiInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x111.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x111.SubCmd0x111RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CircleServlet
  extends MSFServlet
{
  public static final int a = 181;
  public static final String a = "OidbSvc.0x4f7_253";
  public static final int b = 182;
  public static final String b = "OidbSvc.0x4f8_253";
  public static final int c = 183;
  public static final String c = "HttpConn.0x6ff_501";
  public static final int d = 5;
  public static final String d = "param_req_type";
  private static int e = 0;
  public static final String e = "param_switch_value";
  public static final String f = "param_uin";
  public static final String g = "param_last_check_update_time";
  private static final String h = "CircleManager";
  private CircleManager a;
  
  public CircleServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a()
  {
    int i = e;
    e = i + 1;
    return i;
  }
  
  private CircleManager a()
  {
    if (this.a == null) {
      this.a = ((CircleManager)getAppRuntime().getManager(34));
    }
    return this.a;
  }
  
  private void a(Intent paramIntent, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "respGetCircle, error = " + paramInt);
      }
      notifyObserver(paramIntent, 183, false, localBundle, CircleObserver.class);
      return;
    }
    int j;
    Object localObject;
    try
    {
      j = paramArrayOfByte1.length;
      if ((paramArrayOfByte1[0] != 40) || (paramArrayOfByte1[(j - 1)] != 41))
      {
        localObject = "unexpected body data, len=" + j + ", data=";
        paramArrayOfByte2 = paramArrayOfByte1.toString();
        localObject = new StringBuilder().append((String)localObject);
        paramArrayOfByte1 = paramArrayOfByte2;
        if (paramArrayOfByte2.length() > 20) {
          paramArrayOfByte1 = paramArrayOfByte2.substring(0, 20);
        }
        throw new RuntimeException(paramArrayOfByte1);
      }
    }
    catch (Exception paramArrayOfByte2)
    {
      paramArrayOfByte1 = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$rspGetCircle | Exception:" + paramArrayOfByte2.getMessage());
      }
      paramInt = -10;
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$rspGetCircle | errorCode = " + paramInt);
      }
      notifyObserver(paramIntent, 183, true, localBundle, CircleObserver.class);
      if (paramArrayOfByte1 == null) {
        break;
      }
      a().b(paramArrayOfByte1);
      return;
      paramArrayOfByte1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1));
      paramArrayOfByte1.readByte();
      int k = paramArrayOfByte1.readInt();
      int i = paramArrayOfByte1.readInt();
      if ((k > j) || (i > j)) {
        throw new RuntimeException("unexpected length, headLen=" + k + ", bodyLen=" + i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "respGetCircel | headLen=" + k + " | bodyLen=" + i);
      }
      if (k > 0)
      {
        localObject = new byte[k];
        paramArrayOfByte1.read((byte[])localObject);
        im_msg_head.Head localHead = new im_msg_head.Head();
        localHead.mergeFrom((byte[])localObject);
        paramInt = ((im_msg_head.HttpConnHead)localHead.msg_httpconn_head.get()).uint32_error_code.get();
      }
      for (;;)
      {
        if ((i > 0) && (paramInt == 0))
        {
          localObject = new byte[i];
          paramArrayOfByte1.read((byte[])localObject);
          paramArrayOfByte1 = new Cryptor().decrypt((byte[])localObject, paramArrayOfByte2);
          paramArrayOfByte2 = new subcmd0x111.RspBody();
          paramArrayOfByte2.mergeFrom(paramArrayOfByte1);
          paramArrayOfByte1 = paramArrayOfByte2.msg_subcmd_0x111_rsp_body;
          if (paramArrayOfByte1 == null) {
            throw new RuntimeException("SubCmd0x111RspBody is null.....");
          }
          paramArrayOfByte2 = (subcmd0x111.ContentItem)paramArrayOfByte1.rpt_msg_contentItem.get(0);
          if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.uint32_filed.get() != 100)) {
            throw new RuntimeException("ContentItem = " + paramArrayOfByte2);
          }
        }
        for (paramArrayOfByte1 = new subcmd0x111.RenMaiInfo();; paramArrayOfByte1 = null)
        {
          try
          {
            paramArrayOfByte1.mergeFrom(((subcmd0x111.GeneralBuffer)paramArrayOfByte2.msg_general_buffer.get()).bytes_value.get().toByteArray());
            if (paramArrayOfByte1 == null) {
              throw new RuntimeException("RenMaiInfo is null ....");
            }
            a().a(paramArrayOfByte1);
          }
          catch (Exception paramArrayOfByte2) {}
          localBundle.putInt("result_code", paramInt);
        }
      }
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {
      localObject1 = new subcmd0x501.RspBody();
    }
    try
    {
      paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
      paramFromServiceMsg.get((byte[])localObject2);
      ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject2);
      localObject2 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
      paramFromServiceMsg = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).bytes_session_key.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.toByteArray().length <= 0)) {
        break label328;
      }
      paramFromServiceMsg = paramFromServiceMsg.toByteArray();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d("CircleManager", 2, paramFromServiceMsg.getMessage());
          continue;
          localObject2 = null;
          continue;
          localObject1 = null;
          continue;
          paramFromServiceMsg = null;
        }
      }
    }
    localObject1 = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).bytes_httpconn_sig_session.get();
    if ((localObject1 != null) && (((ByteStringMicro)localObject1).toByteArray().length > 0))
    {
      localObject1 = ((ByteStringMicro)localObject1).toByteArray();
      localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).rpt_msg_httpconn_addrs.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject2).next();
        } while (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).uint32_service_type.get() != 5);
        localObject3 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).rpt_msg_addrs.get();
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          localObject2 = new String[((List)localObject3).size()];
          i = 0;
          while (i < ((List)localObject3).size())
          {
            subcmd0x501.SubCmd0x501Rspbody.IpAddr localIpAddr = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject3).get(i);
            localObject2[i] = CircleManager.a(localIpAddr.uint32_ip.get(), localIpAddr.uint32_port.get());
            i += 1;
          }
          a().a(paramFromServiceMsg, (byte[])localObject1, (String[])localObject2);
          a(paramIntent, null, true);
          return;
        }
      }
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    int i = 1;
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1271);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(253);
    boolean bool = paramIntent.getBooleanExtra("param_switch_value", true);
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "$reqSetSwitch | set switch value = " + bool);
    }
    paramIntent = ByteBuffer.allocate(2);
    ByteBuffer localByteBuffer = paramIntent.put((byte)-3);
    if (bool) {
      i = 0;
    }
    localByteBuffer.put((byte)i);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.array()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.setSSOCommand("OidbSvc.0x4f7_253");
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  /* Error */
  private void a(Intent paramIntent, Packet paramPacket, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 29
    //   3: lconst_0
    //   4: invokevirtual 420	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   7: lstore 10
    //   9: aload_1
    //   10: ldc 32
    //   12: iconst_0
    //   13: invokevirtual 424	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   16: istore 9
    //   18: aload_0
    //   19: invokespecial 68	com/tencent/mobileqq/app/CircleServlet:a	()Lcom/tencent/mobileqq/app/CircleManager;
    //   22: invokevirtual 426	com/tencent/mobileqq/app/CircleManager:a	()[B
    //   25: astore 4
    //   27: aload 4
    //   29: ifnonnull +24 -> 53
    //   32: iload_3
    //   33: ifeq +12 -> 45
    //   36: aload_0
    //   37: aconst_null
    //   38: iconst_m1
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokespecial 428	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;I[B[B)V
    //   44: return
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 431	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;Lmqq/app/Packet;)Z
    //   51: pop
    //   52: return
    //   53: new 433	tencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody
    //   56: dup
    //   57: invokespecial 434	tencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody:<init>	()V
    //   60: astore 6
    //   62: aload 6
    //   64: getfield 437	tencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody:uint32_start_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   67: iload 9
    //   69: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   72: new 439	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 440	java/util/ArrayList:<init>	()V
    //   79: astore 5
    //   81: aload 5
    //   83: bipush 100
    //   85: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: invokeinterface 450 2 0
    //   93: pop
    //   94: aload 6
    //   96: getfield 454	tencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody:rpt_uint32_fieldlist	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   99: aload 5
    //   101: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   104: aload 6
    //   106: getfield 462	tencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody:rpt_uint64_uinlist	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   109: new 439	java/util/ArrayList
    //   112: dup
    //   113: invokespecial 440	java/util/ArrayList:<init>	()V
    //   116: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   119: new 464	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody
    //   122: dup
    //   123: invokespecial 465	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody:<init>	()V
    //   126: astore 5
    //   128: aload 5
    //   130: getfield 469	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody:msg_subcmd_0x111_req_body	Ltencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody;
    //   133: aload 6
    //   135: invokevirtual 472	tencent/im/cs/cmd0x6ff/subcmd0x111$SubCmd0x111ReqBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   138: new 464	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody
    //   141: dup
    //   142: invokespecial 465	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody:<init>	()V
    //   145: astore 6
    //   147: aload 6
    //   149: aload 5
    //   151: invokevirtual 473	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody:toByteArray	()[B
    //   154: invokevirtual 474	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   157: pop
    //   158: new 198	com/tencent/qphone/base/util/Cryptor
    //   161: dup
    //   162: invokespecial 199	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   165: aload 5
    //   167: invokevirtual 473	tencent/im/cs/cmd0x6ff/subcmd0x111$ReqBody:toByteArray	()[B
    //   170: aload 4
    //   172: invokevirtual 477	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   175: astore 5
    //   177: new 173	tencent/im/msg/im_msg_head$Head
    //   180: dup
    //   181: invokespecial 174	tencent/im/msg/im_msg_head$Head:<init>	()V
    //   184: astore 6
    //   186: aload 6
    //   188: getfield 480	tencent/im/msg/im_msg_head$Head:uint32_head_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   191: iconst_4
    //   192: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   195: new 482	tencent/im/msg/im_msg_head$LoginSig
    //   198: dup
    //   199: invokespecial 483	tencent/im/msg/im_msg_head$LoginSig:<init>	()V
    //   202: astore 7
    //   204: aload 7
    //   206: getfield 486	tencent/im/msg/im_msg_head$LoginSig:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   209: bipush 22
    //   211: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   214: aload_0
    //   215: invokespecial 68	com/tencent/mobileqq/app/CircleServlet:a	()Lcom/tencent/mobileqq/app/CircleManager;
    //   218: invokevirtual 488	com/tencent/mobileqq/app/CircleManager:b	()[B
    //   221: astore 8
    //   223: aload 8
    //   225: ifnull +247 -> 472
    //   228: aload 7
    //   230: getfield 491	tencent/im/msg/im_msg_head$LoginSig:bytes_sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: aload 8
    //   235: invokestatic 400	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 403	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   241: aload 6
    //   243: getfield 495	tencent/im/msg/im_msg_head$Head:msg_login_sig	Ltencent/im/msg/im_msg_head$LoginSig;
    //   246: aload 7
    //   248: invokevirtual 496	tencent/im/msg/im_msg_head$LoginSig:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   251: new 184	tencent/im/msg/im_msg_head$HttpConnHead
    //   254: dup
    //   255: invokespecial 497	tencent/im/msg/im_msg_head$HttpConnHead:<init>	()V
    //   258: astore 7
    //   260: aload 7
    //   262: getfield 501	tencent/im/msg/im_msg_head$HttpConnHead:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   265: lload 10
    //   267: invokevirtual 506	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   270: aload 7
    //   272: getfield 507	tencent/im/msg/im_msg_head$HttpConnHead:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   275: sipush 1791
    //   278: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   281: aload 7
    //   283: getfield 510	tencent/im/msg/im_msg_head$HttpConnHead:uint32_sub_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   286: sipush 273
    //   289: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   292: aload 7
    //   294: getfield 513	tencent/im/msg/im_msg_head$HttpConnHead:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokestatic 515	com/tencent/mobileqq/app/CircleServlet:a	()I
    //   300: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   303: aload 7
    //   305: getfield 518	tencent/im/msg/im_msg_head$HttpConnHead:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   308: sipush 4643
    //   311: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   314: aload 7
    //   316: getfield 521	tencent/im/msg/im_msg_head$HttpConnHead:uint32_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   319: iconst_1
    //   320: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   323: aload 7
    //   325: getfield 524	tencent/im/msg/im_msg_head$HttpConnHead:uint32_compress_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   328: iconst_0
    //   329: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   332: aload 7
    //   334: getfield 192	tencent/im/msg/im_msg_head$HttpConnHead:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   337: iconst_0
    //   338: invokevirtual 370	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   341: aload 6
    //   343: getfield 182	tencent/im/msg/im_msg_head$Head:msg_httpconn_head	Ltencent/im/msg/im_msg_head$HttpConnHead;
    //   346: aload 7
    //   348: invokevirtual 525	tencent/im/msg/im_msg_head$HttpConnHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   351: aload 6
    //   353: invokevirtual 526	tencent/im/msg/im_msg_head$Head:toByteArray	()[B
    //   356: astore 7
    //   358: new 528	java/io/ByteArrayOutputStream
    //   361: dup
    //   362: invokespecial 529	java/io/ByteArrayOutputStream:<init>	()V
    //   365: astore 6
    //   367: new 531	java/io/DataOutputStream
    //   370: dup
    //   371: aload 6
    //   373: invokespecial 534	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   376: astore 8
    //   378: aload 8
    //   380: bipush 40
    //   382: invokevirtual 537	java/io/DataOutputStream:write	(I)V
    //   385: aload 8
    //   387: aload 7
    //   389: arraylength
    //   390: invokevirtual 540	java/io/DataOutputStream:writeInt	(I)V
    //   393: aload 8
    //   395: aload 5
    //   397: arraylength
    //   398: invokevirtual 540	java/io/DataOutputStream:writeInt	(I)V
    //   401: aload 8
    //   403: aload 7
    //   405: invokevirtual 542	java/io/DataOutputStream:write	([B)V
    //   408: aload 8
    //   410: aload 5
    //   412: invokevirtual 542	java/io/DataOutputStream:write	([B)V
    //   415: aload 8
    //   417: bipush 41
    //   419: invokevirtual 537	java/io/DataOutputStream:write	(I)V
    //   422: aload 8
    //   424: invokevirtual 545	java/io/DataOutputStream:flush	()V
    //   427: aload_0
    //   428: invokespecial 68	com/tencent/mobileqq/app/CircleServlet:a	()Lcom/tencent/mobileqq/app/CircleManager;
    //   431: invokevirtual 547	com/tencent/mobileqq/app/CircleManager:a	()Ljava/lang/String;
    //   434: astore 5
    //   436: aload 5
    //   438: ifnull +11 -> 449
    //   441: aload 5
    //   443: invokevirtual 123	java/lang/String:length	()I
    //   446: ifne +86 -> 532
    //   449: iload_3
    //   450: ifeq +74 -> 524
    //   453: aload_0
    //   454: aconst_null
    //   455: iconst_m1
    //   456: aconst_null
    //   457: aconst_null
    //   458: invokespecial 428	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;I[B[B)V
    //   461: return
    //   462: astore 6
    //   464: aload 6
    //   466: invokevirtual 550	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   469: goto -311 -> 158
    //   472: iload_3
    //   473: ifeq +12 -> 485
    //   476: aload_0
    //   477: aconst_null
    //   478: iconst_m1
    //   479: aconst_null
    //   480: aconst_null
    //   481: invokespecial 428	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;I[B[B)V
    //   484: return
    //   485: aload_0
    //   486: aload_1
    //   487: aload_2
    //   488: invokespecial 431	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;Lmqq/app/Packet;)Z
    //   491: pop
    //   492: return
    //   493: astore 5
    //   495: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +14 -> 512
    //   501: ldc 35
    //   503: iconst_2
    //   504: aload 5
    //   506: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   509: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_0
    //   513: aload_1
    //   514: bipush -10
    //   516: aconst_null
    //   517: aconst_null
    //   518: invokespecial 428	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;I[B[B)V
    //   521: goto -94 -> 427
    //   524: aload_0
    //   525: aload_1
    //   526: aload_2
    //   527: invokespecial 431	com/tencent/mobileqq/app/CircleServlet:a	(Landroid/content/Intent;Lmqq/app/Packet;)Z
    //   530: pop
    //   531: return
    //   532: new 88	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   539: aload 5
    //   541: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 552
    //   547: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: astore_2
    //   554: aload 6
    //   556: invokevirtual 553	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   559: astore 5
    //   561: new 555	com/tencent/mobileqq/transfile/HttpNetReq
    //   564: dup
    //   565: invokespecial 556	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   568: astore 6
    //   570: aload 6
    //   572: aload 5
    //   574: putfield 559	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_ArrayOfByte	[B
    //   577: aload 6
    //   579: new 561	pvi
    //   582: dup
    //   583: aload_0
    //   584: aload_1
    //   585: aload 4
    //   587: invokespecial 564	pvi:<init>	(Lcom/tencent/mobileqq/app/CircleServlet;Landroid/content/Intent;[B)V
    //   590: putfield 567	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   593: aload 6
    //   595: aload_2
    //   596: putfield 569	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   599: aload 6
    //   601: iconst_1
    //   602: putfield 571	com/tencent/mobileqq/transfile/HttpNetReq:c	I
    //   605: aload 6
    //   607: ldc_w 572
    //   610: putfield 575	com/tencent/mobileqq/transfile/HttpNetReq:n	I
    //   613: aload 6
    //   615: getfield 578	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   618: ldc_w 580
    //   621: ldc_w 582
    //   624: invokevirtual 587	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   627: pop
    //   628: aload 6
    //   630: iconst_2
    //   631: putfield 590	com/tencent/mobileqq/transfile/HttpNetReq:k	I
    //   634: aload 6
    //   636: ldc2_w 591
    //   639: putfield 595	com/tencent/mobileqq/transfile/HttpNetReq:d	J
    //   642: aload_0
    //   643: invokevirtual 57	com/tencent/mobileqq/app/CircleServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   646: checkcast 597	com/tencent/mobileqq/app/QQAppInterface
    //   649: iconst_0
    //   650: invokevirtual 600	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/transfile/INetEngine;
    //   653: aload 6
    //   655: invokeinterface 605 2 0
    //   660: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	CircleServlet
    //   0	661	1	paramIntent	Intent
    //   0	661	2	paramPacket	Packet
    //   0	661	3	paramBoolean	boolean
    //   25	561	4	arrayOfByte1	byte[]
    //   79	363	5	localObject1	Object
    //   493	47	5	localException	Exception
    //   559	14	5	arrayOfByte2	byte[]
    //   60	312	6	localObject2	Object
    //   462	93	6	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   568	86	6	localHttpNetReq	com.tencent.mobileqq.transfile.HttpNetReq
    //   202	202	7	localObject3	Object
    //   221	202	8	localObject4	Object
    //   16	52	9	i	int
    //   7	259	10	l	long
    // Exception table:
    //   from	to	target	type
    //   147	158	462	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   367	427	493	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), CircleServlet.class);
    localNewIntent.putExtra("param_req_type", 182);
    localNewIntent.putExtra("param_uin", Long.parseLong(paramQQAppInterface.a()));
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), CircleServlet.class);
    localNewIntent.putExtra("param_req_type", 183);
    localNewIntent.putExtra("param_uin", Long.parseLong(paramQQAppInterface.a()));
    localNewIntent.putExtra("param_last_check_update_time", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), CircleServlet.class);
    localNewIntent.putExtra("param_req_type", 181);
    localNewIntent.putExtra("param_switch_value", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private boolean a(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "req get ip list");
    }
    long l = paramIntent.getLongExtra("param_uin", 0L);
    if (l == 0L) {
      return false;
    }
    paramIntent = new subcmd0x501.SubCmd0x501ReqBody();
    paramIntent.uint64_uin.set(l);
    paramIntent.uint32_idc_id.set(0);
    paramIntent.uint32_appid.set(16);
    paramIntent.uint32_login_sig_type.set(1);
    paramIntent.uint32_request_flag.set(3);
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(5));
    paramIntent.rpt_uint32_service_types.set((List)localObject);
    localObject = new subcmd0x501.ReqBody();
    ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramIntent);
    paramPacket.setSSOCommand("HttpConn.0x6ff_501");
    paramIntent = ((subcmd0x501.ReqBody)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    return true;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool3 = paramIntent.getBooleanExtra("param_switch_value", true);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_searchable", bool3);
    if (bool1) {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$respSetSwitch | is success, value = " + bool3);
      }
    }
    label188:
    for (;;)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i == 0) {
          break label188;
        }
        bool1 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("Q.richstatus.", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, 181, bool1, localBundle, CircleObserver.class);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$respSetSwtich | is not success");
      }
    }
  }
  
  private void b(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "$reqGetSwitch");
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1272);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(253);
    long l = paramIntent.getLongExtra("param_uin", 0L);
    paramIntent = ByteBuffer.allocate(6);
    paramIntent.putShort((short)1).putInt((int)l);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.array()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.setSSOCommand("OidbSvc.0x4f8_253");
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    if (bool2) {}
    for (;;)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg.getInt();
        paramFromServiceMsg.getShort();
        long l = paramFromServiceMsg.getInt();
        if (paramFromServiceMsg.get() != 0) {
          continue;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "$respGetSwitch | isSearchable = " + bool1);
        }
        localBundle.putBoolean("is_searchable", bool1);
        bool1 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("Q.richstatus.", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, 182, bool1, localBundle, CircleObserver.class);
      return;
      boolean bool1 = false;
      continue;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CircleManager", 2, "$respGetSwitch | is not success");
        bool1 = bool2;
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {}
    label97:
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label97;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("CircleManager", 2, str1 + " success");
        if (!str2.equals("OidbSvc.0x4f7_253")) {
          break;
        }
        b(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str2.equals("OidbSvc.0x4f8_253"))
      {
        c(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("HttpConn.0x6ff_501"));
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    switch (localBundle.getInt("param_req_type", 0))
    {
    default: 
      return;
    case 181: 
      a(paramIntent, paramPacket);
      return;
    case 182: 
      b(paramIntent, paramPacket);
      return;
    }
    a(paramIntent, paramPacket, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\CircleServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */