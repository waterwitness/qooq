package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.signature.SigActPb.Platform;
import com.tencent.pb.signature.SigActPb.ReqBody;
import com.tencent.pb.signature.SigActPb.SigauthReq;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StatusServlet
  extends MSFServlet
{
  private static final String A = "OidbSvc.0x50f_29";
  private static final String B = "OidbSvc.0x510_0";
  private static final String C = "Signature.auth";
  private static final String D = "k_uin";
  private static final String E = "k_cookie";
  static final int a = 1;
  public static final String a = "PersonalStateSvc.ReqGetHotState";
  static final int b = 2;
  public static final String b = "k_cmd";
  static final int jdField_c_of_type_Int = 3;
  static final String jdField_c_of_type_JavaLangString = "k_sync_ss";
  static final int jdField_d_of_type_Int = 4;
  static final String jdField_d_of_type_JavaLangString = "k_resp_mate";
  static final int jdField_e_of_type_Int = 5;
  static final String jdField_e_of_type_JavaLangString = "k_fetch_sex";
  static final int jdField_f_of_type_Int = 6;
  static final String jdField_f_of_type_JavaLangString = "k_is_first";
  static final int jdField_g_of_type_Int = 7;
  static final String jdField_g_of_type_JavaLangString = "k_action";
  static final int jdField_h_of_type_Int = 8;
  static final String jdField_h_of_type_JavaLangString = "k_data";
  static final int jdField_i_of_type_Int = 9;
  static final String jdField_i_of_type_JavaLangString = "k_end_time";
  private static final int jdField_j_of_type_Int = 50;
  static final String jdField_j_of_type_JavaLangString = "k_start_time";
  static final String k = "k_status_key";
  static final String l = "k_status_flag";
  static final String m = "k_error_code";
  static final String n = "k_resp_hot_status";
  static final String o = "k_source";
  static final String p = "k_rspbody";
  static final String q = "k_auth_code";
  static final String r = "k_act_url";
  static final String s = "k_tpl_id";
  static final String t = "k_sign_data";
  static final String u = "k_sign_len";
  private static final String v = "StatusServlet";
  private static final String w = "OidbSvc.0x515_2";
  private static final String x = "OidbSvc.0x53f_2";
  private static final String y = "OidbSvc.0x54f_0";
  private static final String z = "PersonalStateSvc.ReqGetSameStateList";
  
  public StatusServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static PersonalState.LBSInfo a(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.a(60000L, StatusServlet.class.getSimpleName());
    Object localObject1 = SosoInterface.a();
    paramQQAppInterface = null;
    if (localObject1 != null)
    {
      paramQQAppInterface = ((NearbyGroup.LBSInfo)localObject1).stGps;
      paramQQAppInterface = new PersonalState.GPS(paramQQAppInterface.iLat, paramQQAppInterface.iLon, paramQQAppInterface.iAlt, paramQQAppInterface.eType);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = ((NearbyGroup.LBSInfo)localObject1).vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new PersonalState.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      localObject1 = ((NearbyGroup.LBSInfo)localObject1).vCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (NearbyGroup.Cell)((Iterator)localObject1).next();
        ((ArrayList)localObject2).add(new PersonalState.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      paramQQAppInterface = new PersonalState.LBSInfo(paramQQAppInterface, localArrayList, (ArrayList)localObject2);
    }
    return paramQQAppInterface;
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_start_time", paramInt1);
    localNewIntent.putExtra("k_end_time", paramInt2);
    localNewIntent.putExtra("k_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    localNewIntent.putExtra("k_sync_ss", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 3);
    localNewIntent.putExtra("k_is_first", paramBoolean);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte);
    localNewIntent.putExtra("k_fetch_sex", paramInt1);
    localNewIntent.putExtra("k_action", paramInt2);
    localNewIntent.putExtra("k_data", paramInt3);
    localNewIntent.putExtra("k_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 7);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    localNewIntent.putExtra("k_data", paramArrayOfByte);
    localNewIntent.putExtra("k_source", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] a(List paramList, byte paramByte)
  {
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1359);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    Object localObject2 = paramList.iterator();
    int i1 = 7;
    byte[] arrayOfByte;
    if (((Iterator)localObject2).hasNext())
    {
      arrayOfByte = (byte[])((Iterator)localObject2).next();
      if (arrayOfByte == null) {
        break label222;
      }
      i1 = arrayOfByte.length + (i1 + 2) + 4;
    }
    label222:
    for (;;)
    {
      break;
      localObject2 = ByteBuffer.allocate(i1);
      ((ByteBuffer)localObject2).putInt(0);
      ((ByteBuffer)localObject2).put(paramByte);
      ((ByteBuffer)localObject2).putShort((short)paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        arrayOfByte = (byte[])paramList.next();
        if (arrayOfByte != null)
        {
          ((ByteBuffer)localObject2).putShort((short)arrayOfByte.length);
          ((ByteBuffer)localObject2).put(arrayOfByte);
          ((ByteBuffer)localObject2).putInt(0);
        }
      }
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      paramList = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject1 = ByteBuffer.allocate(paramList.length + 4);
      ((ByteBuffer)localObject1).putInt(paramList.length + 4);
      ((ByteBuffer)localObject1).put(paramList);
      return ((ByteBuffer)localObject1).array();
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1295);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(29);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length + 2);
    localByteBuffer.put((byte)0).put((byte)paramArrayOfByte.length).put(paramArrayOfByte);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    return ((ByteBuffer)localObject).array();
  }
  
  static void b(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 6);
    if (QLog.isColorLevel()) {
      QLog.d("get_hot_rich_status", 2, "StatusServlet.getHotRichStatus()");
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  byte[] a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1343);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(27);
    localByteBuffer.putLong(paramLong).put((byte)2).putInt(paramInt1).putInt(paramInt2).putInt(0).putInt(0).putShort((short)6);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  byte[] a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i2 = 1;
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1301);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(11);
    ByteBuffer localByteBuffer2 = localByteBuffer1.put((byte)2).putInt(293615363);
    if (paramBoolean1)
    {
      i1 = 1;
      localByteBuffer2.put((byte)i1);
      if (!paramBoolean2) {
        break label155;
      }
    }
    label155:
    for (int i1 = i2;; i1 = 0)
    {
      localByteBuffer1.put((byte)i1).putInt((int)paramLong);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer1.array()));
      localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      localByteBuffer1 = ByteBuffer.allocate(localObject.length + 4);
      localByteBuffer1.putInt(localObject.length + 4);
      localByteBuffer1.put((byte[])localObject);
      return localByteBuffer1.array();
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 29
    //   3: iconst_0
    //   4: invokevirtual 364	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore 10
    //   9: aload_2
    //   10: invokevirtual 369	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 15
    //   15: aload_0
    //   16: invokevirtual 373	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   19: bipush 14
    //   21: invokevirtual 379	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 381	com/tencent/mobileqq/richstatus/StatusManager
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +4 -> 33
    //   32: return
    //   33: new 383	android/os/Bundle
    //   36: dup
    //   37: invokespecial 384	android/os/Bundle:<init>	()V
    //   40: astore 4
    //   42: iload 10
    //   44: tableswitch	default:+52->96, 1:+67->111, 2:+67->111, 3:+772->816, 4:+218->262, 5:+876->920, 6:+1242->1286, 7:+1726->1770, 8:+2100->2144, 9:+1898->1942
    //   96: aload_0
    //   97: aload_1
    //   98: iload 10
    //   100: iload 15
    //   102: aload 4
    //   104: ldc_w 386
    //   107: invokevirtual 390	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   110: return
    //   111: aload_2
    //   112: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   115: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   123: iconst_4
    //   124: isub
    //   125: newarray <illegal type>
    //   127: astore_3
    //   128: aload_2
    //   129: aload_3
    //   130: invokevirtual 402	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   133: pop
    //   134: new 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   137: dup
    //   138: invokespecial 268	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   141: aload_3
    //   142: invokevirtual 406	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   145: checkcast 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   148: getfield 314	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   151: invokevirtual 409	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 410	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   157: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   165: istore 8
    //   167: aload_2
    //   168: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   171: i2l
    //   172: lstore 13
    //   174: aload_2
    //   175: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   178: iconst_1
    //   179: if_icmpne +2136 -> 2315
    //   182: iconst_1
    //   183: istore 16
    //   185: goto +2111 -> 2296
    //   188: aload 4
    //   190: ldc 33
    //   192: iload 17
    //   194: invokevirtual 417	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   197: iload 16
    //   199: istore 15
    //   201: goto -105 -> 96
    //   204: iload 16
    //   206: istore 17
    //   208: iload 15
    //   210: istore 16
    //   212: iload 10
    //   214: iconst_2
    //   215: if_icmpne -27 -> 188
    //   218: aload_1
    //   219: ldc 33
    //   221: iconst_0
    //   222: invokevirtual 421	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   225: istore 17
    //   227: iload 15
    //   229: istore 16
    //   231: goto -43 -> 188
    //   234: astore_2
    //   235: aload_2
    //   236: invokevirtual 424	java/lang/Exception:printStackTrace	()V
    //   239: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +14 -> 256
    //   245: ldc_w 426
    //   248: iconst_2
    //   249: aload_2
    //   250: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: istore 15
    //   259: goto -163 -> 96
    //   262: new 433	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   265: dup
    //   266: invokespecial 434	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   269: astore_3
    //   270: aload_3
    //   271: aload_1
    //   272: ldc 61
    //   274: iconst_0
    //   275: invokevirtual 364	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   278: putfield 437	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   281: aload_3
    //   282: aload_1
    //   283: ldc 57
    //   285: ldc_w 438
    //   288: invokevirtual 364	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   291: putfield 441	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   294: aload_3
    //   295: iconst_0
    //   296: putfield 444	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   299: aload 4
    //   301: ldc 53
    //   303: aload_3
    //   304: invokevirtual 448	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   307: aload_2
    //   308: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   311: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   314: astore_2
    //   315: aload_2
    //   316: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   319: iconst_4
    //   320: isub
    //   321: newarray <illegal type>
    //   323: astore 5
    //   325: aload_2
    //   326: aload 5
    //   328: invokevirtual 402	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   331: pop
    //   332: new 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   335: dup
    //   336: invokespecial 268	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   339: aload 5
    //   341: invokevirtual 406	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   344: checkcast 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   347: getfield 314	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   350: invokevirtual 409	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   353: invokevirtual 410	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   356: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   359: astore 5
    //   361: aload 5
    //   363: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   366: pop
    //   367: aload 5
    //   369: invokevirtual 452	java/nio/ByteBuffer:getLong	()J
    //   372: lstore 13
    //   374: aload 5
    //   376: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   379: pop
    //   380: aload 5
    //   382: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   385: pop
    //   386: aload 5
    //   388: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   391: istore 9
    //   393: aload 5
    //   395: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   398: pop
    //   399: aload 5
    //   401: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   404: ifeq +1926 -> 2330
    //   407: iconst_1
    //   408: istore 16
    //   410: aload 5
    //   412: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   415: istore 11
    //   417: aload_3
    //   418: new 164	java/util/ArrayList
    //   421: dup
    //   422: iload 11
    //   424: invokespecial 458	java/util/ArrayList:<init>	(I)V
    //   427: putfield 461	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   430: aload_0
    //   431: invokevirtual 373	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   434: checkcast 235	com/tencent/mobileqq/app/QQAppInterface
    //   437: astore_2
    //   438: iconst_0
    //   439: istore 8
    //   441: iload 8
    //   443: iload 11
    //   445: if_icmpge +162 -> 607
    //   448: aload 5
    //   450: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   453: newarray <illegal type>
    //   455: astore 6
    //   457: aload 5
    //   459: aload 6
    //   461: invokevirtual 402	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   464: pop
    //   465: aload 5
    //   467: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   470: newarray <illegal type>
    //   472: astore 7
    //   474: aload 5
    //   476: aload 7
    //   478: invokevirtual 402	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   481: pop
    //   482: aload 5
    //   484: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   487: pop
    //   488: aload 5
    //   490: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   493: istore 12
    //   495: aload 5
    //   497: aload 5
    //   499: invokevirtual 464	java/nio/ByteBuffer:position	()I
    //   502: bipush 8
    //   504: iadd
    //   505: invokevirtual 467	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   508: pop
    //   509: iload 12
    //   511: iload 9
    //   513: if_icmple +6 -> 519
    //   516: goto +1805 -> 2321
    //   519: aload 7
    //   521: invokestatic 473	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   524: astore 7
    //   526: aload 7
    //   528: iload 12
    //   530: i2l
    //   531: putfield 476	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   534: aload 7
    //   536: aload 6
    //   538: putfield 479	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   541: aload 7
    //   543: getfield 479	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   546: ifnull +20 -> 566
    //   549: aload 7
    //   551: new 481	java/lang/String
    //   554: dup
    //   555: aload 7
    //   557: getfield 479	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   560: invokespecial 484	java/lang/String:<init>	([B)V
    //   563: putfield 487	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   566: aload_3
    //   567: getfield 461	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   570: aload 7
    //   572: invokevirtual 202	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   575: pop
    //   576: goto +1745 -> 2321
    //   579: astore_2
    //   580: aload_2
    //   581: invokevirtual 424	java/lang/Exception:printStackTrace	()V
    //   584: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +14 -> 601
    //   590: ldc_w 426
    //   593: iconst_2
    //   594: aload_2
    //   595: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   598: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: iconst_0
    //   602: istore 15
    //   604: goto -508 -> 96
    //   607: aload_3
    //   608: getfield 461	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   611: invokevirtual 490	java/util/ArrayList:isEmpty	()Z
    //   614: ifeq +84 -> 698
    //   617: aload_3
    //   618: getfield 437	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   621: ifne +77 -> 698
    //   624: aload_3
    //   625: getfield 441	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   628: ldc_w 438
    //   631: if_icmpne +67 -> 698
    //   634: aload_0
    //   635: invokevirtual 373	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   638: bipush 50
    //   640: invokevirtual 379	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   643: checkcast 492	com/tencent/mobileqq/app/FriendsManager
    //   646: lload 13
    //   648: invokestatic 496	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   651: invokevirtual 499	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   654: astore 5
    //   656: aload 5
    //   658: ifnull +40 -> 698
    //   661: aload 5
    //   663: invokevirtual 505	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   666: ifnull +32 -> 698
    //   669: aload 5
    //   671: invokevirtual 505	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   674: invokevirtual 506	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   677: ifne +21 -> 698
    //   680: aload_3
    //   681: getfield 461	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   684: aload 5
    //   686: invokevirtual 505	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   689: invokevirtual 202	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   692: pop
    //   693: aload_3
    //   694: iconst_1
    //   695: putfield 444	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   698: aload_2
    //   699: bipush 41
    //   701: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   704: checkcast 511	com/tencent/mobileqq/app/SignatureHandler
    //   707: astore 5
    //   709: aload_3
    //   710: getfield 461	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   713: invokevirtual 173	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   716: astore 6
    //   718: aload 6
    //   720: invokeinterface 179 1 0
    //   725: ifeq +42 -> 767
    //   728: aload 6
    //   730: invokeinterface 183 1 0
    //   735: checkcast 469	com/tencent/mobileqq/richstatus/RichStatus
    //   738: astore 7
    //   740: aload 5
    //   742: ifnull -24 -> 718
    //   745: aload 5
    //   747: lload 13
    //   749: invokestatic 496	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   752: aload 7
    //   754: getfield 487	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   757: sipush 255
    //   760: iconst_1
    //   761: invokevirtual 514	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   764: goto -46 -> 718
    //   767: aload_3
    //   768: iload 16
    //   770: putfield 517	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   773: aload_2
    //   774: bipush 57
    //   776: invokevirtual 518	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   779: checkcast 520	com/tencent/mobileqq/app/SignatureManager
    //   782: astore 5
    //   784: aload 5
    //   786: ifnull +27 -> 813
    //   789: aload_2
    //   790: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   793: lload 13
    //   795: invokestatic 525	java/lang/Long:toString	(J)Ljava/lang/String;
    //   798: invokevirtual 528	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   801: ifeq +12 -> 813
    //   804: aload 5
    //   806: aload_3
    //   807: getfield 461	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   810: invokevirtual 531	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   813: goto -717 -> 96
    //   816: aload 4
    //   818: ldc 45
    //   820: aload_1
    //   821: ldc 45
    //   823: iconst_1
    //   824: invokevirtual 421	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   827: invokevirtual 417	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   830: aload 4
    //   832: ldc 41
    //   834: aload_1
    //   835: ldc 41
    //   837: iconst_m1
    //   838: invokevirtual 364	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   841: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   844: new 536	com/qq/jce/wup/UniPacket
    //   847: dup
    //   848: iconst_1
    //   849: invokespecial 539	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   852: astore_3
    //   853: aload_3
    //   854: ldc_w 541
    //   857: invokevirtual 545	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   860: aload_3
    //   861: aload_2
    //   862: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   865: invokevirtual 548	com/qq/jce/wup/UniPacket:decode	([B)V
    //   868: aload_3
    //   869: ldc_w 550
    //   872: new 552	PersonalState/RespGetSameStateList
    //   875: dup
    //   876: invokespecial 553	PersonalState/RespGetSameStateList:<init>	()V
    //   879: invokevirtual 557	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   882: checkcast 552	PersonalState/RespGetSameStateList
    //   885: astore_2
    //   886: aload_2
    //   887: getfield 561	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   890: getfield 566	PersonalState/BusiRespHead:iReplyCode	I
    //   893: ifne +14 -> 907
    //   896: aload 4
    //   898: ldc 37
    //   900: aload_2
    //   901: invokevirtual 448	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   904: goto -808 -> 96
    //   907: iconst_0
    //   908: istore 15
    //   910: goto -6 -> 904
    //   913: astore_2
    //   914: iconst_0
    //   915: istore 15
    //   917: goto -821 -> 96
    //   920: iload 15
    //   922: ifeq -826 -> 96
    //   925: new 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   928: dup
    //   929: invokespecial 268	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   932: astore_3
    //   933: aload_3
    //   934: aload_2
    //   935: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   938: invokestatic 570	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   941: invokevirtual 406	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   944: checkcast 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   947: astore_2
    //   948: aload_2
    //   949: ifnull +321 -> 1270
    //   952: aload_2
    //   953: getfield 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   956: invokevirtual 576	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   959: ifeq +311 -> 1270
    //   962: aload_2
    //   963: getfield 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   966: invokevirtual 578	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   969: istore 8
    //   971: iload 8
    //   973: ifne +282 -> 1255
    //   976: aload_2
    //   977: getfield 314	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   980: invokevirtual 409	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   983: invokevirtual 410	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   986: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   989: astore 5
    //   991: aload 5
    //   993: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   996: istore 8
    //   998: iload 8
    //   1000: ifne +187 -> 1187
    //   1003: aload 5
    //   1005: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   1008: istore 11
    //   1010: iconst_0
    //   1011: istore 8
    //   1013: aconst_null
    //   1014: astore_2
    //   1015: iload 8
    //   1017: iload 11
    //   1019: if_icmpge +76 -> 1095
    //   1022: aload 5
    //   1024: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   1027: newarray <illegal type>
    //   1029: astore_2
    //   1030: aload 5
    //   1032: aload_2
    //   1033: invokevirtual 402	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1036: pop
    //   1037: iload 8
    //   1039: iconst_1
    //   1040: iadd
    //   1041: istore 8
    //   1043: goto -28 -> 1015
    //   1046: astore_2
    //   1047: aload_2
    //   1048: invokevirtual 579	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1051: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1054: ifeq +33 -> 1087
    //   1057: ldc_w 426
    //   1060: iconst_2
    //   1061: new 581	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 582	java/lang/StringBuilder:<init>	()V
    //   1068: ldc_w 584
    //   1071: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_2
    //   1075: invokevirtual 589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1078: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1087: iconst_0
    //   1088: istore 15
    //   1090: aload_3
    //   1091: astore_2
    //   1092: goto -144 -> 948
    //   1095: aload 5
    //   1097: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   1100: istore 12
    //   1102: aconst_null
    //   1103: astore_3
    //   1104: iconst_0
    //   1105: istore 9
    //   1107: iconst_0
    //   1108: istore 8
    //   1110: iload 8
    //   1112: iload 12
    //   1114: if_icmpge +34 -> 1148
    //   1117: aload 5
    //   1119: invokevirtual 456	java/nio/ByteBuffer:getShort	()S
    //   1122: newarray <illegal type>
    //   1124: astore_3
    //   1125: aload 5
    //   1127: aload_3
    //   1128: invokevirtual 402	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1131: pop
    //   1132: aload 5
    //   1134: invokevirtual 399	java/nio/ByteBuffer:getInt	()I
    //   1137: istore 9
    //   1139: iload 8
    //   1141: iconst_1
    //   1142: iadd
    //   1143: istore 8
    //   1145: goto -35 -> 1110
    //   1148: iload 11
    //   1150: ifle +14 -> 1164
    //   1153: aload 4
    //   1155: ldc 64
    //   1157: aload_2
    //   1158: invokevirtual 595	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1161: goto +1175 -> 2336
    //   1164: aload 4
    //   1166: ldc 64
    //   1168: aload_3
    //   1169: invokevirtual 595	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1172: aload 4
    //   1174: ldc 70
    //   1176: iload 9
    //   1178: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1181: iconst_0
    //   1182: istore 15
    //   1184: goto +1152 -> 2336
    //   1187: iconst_0
    //   1188: istore 15
    //   1190: aload 4
    //   1192: ldc 70
    //   1194: iload 8
    //   1196: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1199: goto +1137 -> 2336
    //   1202: astore_2
    //   1203: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1206: ifeq +33 -> 1239
    //   1209: ldc_w 426
    //   1212: iconst_2
    //   1213: new 581	java/lang/StringBuilder
    //   1216: dup
    //   1217: invokespecial 582	java/lang/StringBuilder:<init>	()V
    //   1220: ldc_w 597
    //   1223: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: aload_2
    //   1227: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1230: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: iconst_0
    //   1240: istore 15
    //   1242: aload 4
    //   1244: ldc 70
    //   1246: sipush 64534
    //   1249: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1252: goto +1084 -> 2336
    //   1255: iconst_0
    //   1256: istore 15
    //   1258: aload 4
    //   1260: ldc 70
    //   1262: iload 8
    //   1264: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1267: goto +1069 -> 2336
    //   1270: iconst_0
    //   1271: istore 15
    //   1273: aload 4
    //   1275: ldc 70
    //   1277: sipush 64535
    //   1280: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1283: goto +1053 -> 2336
    //   1286: new 536	com/qq/jce/wup/UniPacket
    //   1289: dup
    //   1290: iconst_1
    //   1291: invokespecial 539	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   1294: astore 5
    //   1296: aload 5
    //   1298: ldc_w 541
    //   1301: invokevirtual 545	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   1304: aload 5
    //   1306: aload_2
    //   1307: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1310: invokevirtual 548	com/qq/jce/wup/UniPacket:decode	([B)V
    //   1313: aload 5
    //   1315: ldc_w 599
    //   1318: new 601	PersonalState/RespGetHotState
    //   1321: dup
    //   1322: invokespecial 602	PersonalState/RespGetHotState:<init>	()V
    //   1325: invokevirtual 557	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1328: checkcast 601	PersonalState/RespGetHotState
    //   1331: astore 5
    //   1333: aload 5
    //   1335: getfield 603	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   1338: getfield 566	PersonalState/BusiRespHead:iReplyCode	I
    //   1341: ifne +407 -> 1748
    //   1344: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1347: ifeq +159 -> 1506
    //   1350: new 581	java/lang/StringBuilder
    //   1353: dup
    //   1354: ldc_w 605
    //   1357: invokespecial 607	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1360: astore 6
    //   1362: aload 6
    //   1364: ldc_w 609
    //   1367: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: astore 7
    //   1372: aload 5
    //   1374: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1377: ifnonnull +102 -> 1479
    //   1380: ldc_w 614
    //   1383: astore_2
    //   1384: aload 7
    //   1386: aload_2
    //   1387: invokevirtual 617	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1390: ldc_w 619
    //   1393: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 5
    //   1399: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1402: ifnull +92 -> 1494
    //   1405: aload 5
    //   1407: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1410: invokevirtual 620	java/util/ArrayList:size	()I
    //   1413: ifle +81 -> 1494
    //   1416: aload 5
    //   1418: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1421: invokevirtual 173	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1424: astore_2
    //   1425: aload_2
    //   1426: invokeinterface 179 1 0
    //   1431: ifeq +63 -> 1494
    //   1434: aload_2
    //   1435: invokeinterface 183 1 0
    //   1440: checkcast 622	PersonalState/HotRishState
    //   1443: astore 7
    //   1445: aload 6
    //   1447: ldc_w 624
    //   1450: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: aload 7
    //   1455: getfield 627	PersonalState/HotRishState:iActId	I
    //   1458: invokevirtual 630	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1461: ldc_w 632
    //   1464: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload 7
    //   1469: getfield 635	PersonalState/HotRishState:iDataId	I
    //   1472: invokevirtual 630	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1475: pop
    //   1476: goto -51 -> 1425
    //   1479: aload 5
    //   1481: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1484: invokevirtual 620	java/util/ArrayList:size	()I
    //   1487: invokestatic 640	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1490: astore_2
    //   1491: goto -107 -> 1384
    //   1494: ldc_w 340
    //   1497: iconst_2
    //   1498: aload 6
    //   1500: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1506: new 164	java/util/ArrayList
    //   1509: dup
    //   1510: bipush 6
    //   1512: invokespecial 458	java/util/ArrayList:<init>	(I)V
    //   1515: astore_2
    //   1516: aload 5
    //   1518: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1521: ifnull +216 -> 1737
    //   1524: aload 5
    //   1526: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1529: invokevirtual 620	java/util/ArrayList:size	()I
    //   1532: ifle +205 -> 1737
    //   1535: aload_3
    //   1536: ifnull +87 -> 1623
    //   1539: aload_3
    //   1540: invokevirtual 642	com/tencent/mobileqq/richstatus/StatusManager:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1543: astore 6
    //   1545: aload 5
    //   1547: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1550: invokevirtual 620	java/util/ArrayList:size	()I
    //   1553: iconst_1
    //   1554: isub
    //   1555: istore 8
    //   1557: iload 8
    //   1559: iflt +64 -> 1623
    //   1562: aload 5
    //   1564: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1567: iload 8
    //   1569: invokevirtual 645	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1572: checkcast 622	PersonalState/HotRishState
    //   1575: astore 7
    //   1577: aload 7
    //   1579: getfield 627	PersonalState/HotRishState:iActId	I
    //   1582: aload 6
    //   1584: getfield 648	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   1587: if_icmpne +27 -> 1614
    //   1590: aload 7
    //   1592: getfield 635	PersonalState/HotRishState:iDataId	I
    //   1595: aload 6
    //   1597: getfield 651	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   1600: if_icmpne +14 -> 1614
    //   1603: aload 5
    //   1605: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1608: iload 8
    //   1610: invokevirtual 654	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   1613: pop
    //   1614: iload 8
    //   1616: iconst_1
    //   1617: isub
    //   1618: istore 8
    //   1620: goto -63 -> 1557
    //   1623: iconst_0
    //   1624: istore 8
    //   1626: iload 8
    //   1628: bipush 6
    //   1630: if_icmpge +27 -> 1657
    //   1633: aload_2
    //   1634: aload 5
    //   1636: getfield 612	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1639: iload 8
    //   1641: invokevirtual 645	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1644: invokevirtual 202	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1647: pop
    //   1648: iload 8
    //   1650: iconst_1
    //   1651: iadd
    //   1652: istore 8
    //   1654: goto -28 -> 1626
    //   1657: new 581	java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial 582	java/lang/StringBuilder:<init>	()V
    //   1664: astore 5
    //   1666: aload_2
    //   1667: invokevirtual 173	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1670: astore 6
    //   1672: aload 6
    //   1674: invokeinterface 179 1 0
    //   1679: ifeq +49 -> 1728
    //   1682: aload 6
    //   1684: invokeinterface 183 1 0
    //   1689: checkcast 622	PersonalState/HotRishState
    //   1692: astore 7
    //   1694: aload 5
    //   1696: aload 7
    //   1698: getfield 627	PersonalState/HotRishState:iActId	I
    //   1701: invokevirtual 630	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1704: ldc_w 632
    //   1707: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: aload 7
    //   1712: getfield 635	PersonalState/HotRishState:iDataId	I
    //   1715: invokevirtual 630	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1718: ldc_w 656
    //   1721: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: pop
    //   1725: goto -53 -> 1672
    //   1728: aload_3
    //   1729: aload 5
    //   1731: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1734: invokevirtual 658	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   1737: aload 4
    //   1739: ldc 73
    //   1741: aload_2
    //   1742: invokevirtual 448	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1745: goto -1649 -> 96
    //   1748: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1751: ifeq +13 -> 1764
    //   1754: ldc_w 340
    //   1757: iconst_2
    //   1758: ldc_w 660
    //   1761: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1764: iconst_0
    //   1765: istore 15
    //   1767: goto -1671 -> 96
    //   1770: iload 15
    //   1772: ifeq -1676 -> 96
    //   1775: new 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1778: dup
    //   1779: invokespecial 268	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1782: astore_3
    //   1783: aload_3
    //   1784: aload_2
    //   1785: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1788: invokestatic 570	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   1791: invokevirtual 406	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1794: checkcast 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1797: astore_2
    //   1798: iload 15
    //   1800: istore 16
    //   1802: aload_2
    //   1803: ifnull +77 -> 1880
    //   1806: iload 15
    //   1808: istore 16
    //   1810: aload_2
    //   1811: getfield 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1814: invokevirtual 576	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1817: ifeq +63 -> 1880
    //   1820: aload_2
    //   1821: getfield 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1824: invokevirtual 578	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1827: ifne +66 -> 1893
    //   1830: aload_2
    //   1831: getfield 314	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1834: invokevirtual 409	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1837: invokevirtual 410	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1840: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1843: astore_2
    //   1844: aload_2
    //   1845: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   1848: ifne +39 -> 1887
    //   1851: aload 4
    //   1853: ldc 79
    //   1855: aload_2
    //   1856: invokevirtual 318	java/nio/ByteBuffer:array	()[B
    //   1859: invokevirtual 595	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1862: aload 4
    //   1864: ldc 76
    //   1866: aload_1
    //   1867: ldc 76
    //   1869: iconst_0
    //   1870: invokevirtual 364	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1873: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1876: iload 15
    //   1878: istore 16
    //   1880: iload 16
    //   1882: istore 15
    //   1884: goto -1788 -> 96
    //   1887: iconst_0
    //   1888: istore 16
    //   1890: goto -10 -> 1880
    //   1893: iconst_0
    //   1894: istore 16
    //   1896: goto -16 -> 1880
    //   1899: astore_2
    //   1900: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1903: ifeq +33 -> 1936
    //   1906: ldc_w 426
    //   1909: iconst_2
    //   1910: new 581	java/lang/StringBuilder
    //   1913: dup
    //   1914: invokespecial 582	java/lang/StringBuilder:<init>	()V
    //   1917: ldc_w 584
    //   1920: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload_2
    //   1924: invokevirtual 589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1927: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1933: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1936: iconst_0
    //   1937: istore 16
    //   1939: goto -59 -> 1880
    //   1942: iload 15
    //   1944: ifeq -1848 -> 96
    //   1947: aload_2
    //   1948: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1951: arraylength
    //   1952: iconst_4
    //   1953: isub
    //   1954: istore 8
    //   1956: iload 8
    //   1958: newarray <illegal type>
    //   1960: astore_3
    //   1961: aload_3
    //   1962: iconst_0
    //   1963: aload_2
    //   1964: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1967: iconst_4
    //   1968: iload 8
    //   1970: invokestatic 665	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   1973: new 667	com/tencent/pb/signature/SigActPb$RspBody
    //   1976: dup
    //   1977: invokespecial 668	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   1980: astore_2
    //   1981: aload_2
    //   1982: aload_3
    //   1983: invokevirtual 669	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1986: pop
    //   1987: aload_2
    //   1988: getfield 673	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1991: invokevirtual 676	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1994: istore 8
    //   1996: iload 8
    //   1998: ifne +55 -> 2053
    //   2001: aload_2
    //   2002: getfield 680	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2005: getfield 685	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2008: invokevirtual 409	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2011: invokevirtual 410	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2014: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2017: astore_2
    //   2018: aload_2
    //   2019: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   2022: ifne +320 -> 2342
    //   2025: aload 4
    //   2027: ldc 79
    //   2029: aload_2
    //   2030: invokevirtual 318	java/nio/ByteBuffer:array	()[B
    //   2033: invokevirtual 595	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   2036: aload 4
    //   2038: ldc 76
    //   2040: aload_1
    //   2041: ldc 76
    //   2043: iconst_0
    //   2044: invokevirtual 364	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2047: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2050: goto +289 -> 2339
    //   2053: iconst_0
    //   2054: istore 16
    //   2056: aload 4
    //   2058: ldc 82
    //   2060: iload 8
    //   2062: invokevirtual 534	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2065: iload 16
    //   2067: istore 15
    //   2069: iload 8
    //   2071: ldc_w 686
    //   2074: if_icmpne +265 -> 2339
    //   2077: aload 4
    //   2079: ldc 85
    //   2081: aload_2
    //   2082: getfield 680	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2085: getfield 690	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2088: invokevirtual 694	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2091: invokevirtual 698	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2094: iload 16
    //   2096: istore 15
    //   2098: goto +241 -> 2339
    //   2101: astore_2
    //   2102: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2105: ifeq +33 -> 2138
    //   2108: ldc_w 426
    //   2111: iconst_2
    //   2112: new 581	java/lang/StringBuilder
    //   2115: dup
    //   2116: invokespecial 582	java/lang/StringBuilder:<init>	()V
    //   2119: ldc_w 584
    //   2122: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: aload_2
    //   2126: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2129: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2135: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2138: iconst_0
    //   2139: istore 15
    //   2141: goto -2045 -> 96
    //   2144: iload 15
    //   2146: ifeq -2050 -> 96
    //   2149: new 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2152: dup
    //   2153: invokespecial 268	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2156: astore_3
    //   2157: aload_3
    //   2158: aload_2
    //   2159: invokevirtual 393	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2162: invokestatic 570	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2165: invokevirtual 406	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2168: checkcast 267	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2171: astore_2
    //   2172: iload 15
    //   2174: istore 16
    //   2176: aload_2
    //   2177: ifnull +57 -> 2234
    //   2180: iload 15
    //   2182: istore 16
    //   2184: aload_2
    //   2185: getfield 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2188: invokevirtual 576	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2191: ifeq +43 -> 2234
    //   2194: aload_2
    //   2195: getfield 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2198: invokevirtual 578	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2201: ifne +46 -> 2247
    //   2204: aload_2
    //   2205: getfield 314	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2208: invokevirtual 409	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2211: invokevirtual 410	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2214: invokestatic 396	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2217: invokevirtual 413	java/nio/ByteBuffer:get	()B
    //   2220: istore 8
    //   2222: iload 8
    //   2224: ifne +17 -> 2241
    //   2227: iconst_1
    //   2228: istore 15
    //   2230: iload 15
    //   2232: istore 16
    //   2234: iload 16
    //   2236: istore 15
    //   2238: goto -2142 -> 96
    //   2241: iconst_0
    //   2242: istore 15
    //   2244: goto -14 -> 2230
    //   2247: iconst_0
    //   2248: istore 16
    //   2250: goto -16 -> 2234
    //   2253: astore_2
    //   2254: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2257: ifeq +33 -> 2290
    //   2260: ldc_w 426
    //   2263: iconst_2
    //   2264: new 581	java/lang/StringBuilder
    //   2267: dup
    //   2268: invokespecial 582	java/lang/StringBuilder:<init>	()V
    //   2271: ldc_w 584
    //   2274: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: aload_2
    //   2278: invokevirtual 589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2281: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2284: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2287: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2290: iconst_0
    //   2291: istore 16
    //   2293: goto -59 -> 2234
    //   2296: iload 8
    //   2298: ifeq -2094 -> 204
    //   2301: iconst_0
    //   2302: istore 15
    //   2304: iload 16
    //   2306: istore 17
    //   2308: iload 15
    //   2310: istore 16
    //   2312: goto -2124 -> 188
    //   2315: iconst_0
    //   2316: istore 16
    //   2318: goto -22 -> 2296
    //   2321: iload 8
    //   2323: iconst_1
    //   2324: iadd
    //   2325: istore 8
    //   2327: goto -1886 -> 441
    //   2330: iconst_0
    //   2331: istore 16
    //   2333: goto -1923 -> 410
    //   2336: goto -2240 -> 96
    //   2339: goto -2243 -> 96
    //   2342: iconst_0
    //   2343: istore 15
    //   2345: goto -6 -> 2339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2348	0	this	StatusServlet
    //   0	2348	1	paramIntent	Intent
    //   0	2348	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   27	2131	3	localObject1	Object
    //   40	2038	4	localBundle	android.os.Bundle
    //   323	1407	5	localObject2	Object
    //   455	1228	6	localObject3	Object
    //   472	1239	7	localObject4	Object
    //   165	2161	8	i1	int
    //   391	786	9	i2	int
    //   7	209	10	i3	int
    //   415	734	11	i4	int
    //   493	622	12	i5	int
    //   172	622	13	l1	long
    //   13	2331	15	bool1	boolean
    //   183	2149	16	bool2	boolean
    //   192	2115	17	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   111	182	234	java/lang/Exception
    //   188	197	234	java/lang/Exception
    //   218	227	234	java/lang/Exception
    //   262	407	579	java/lang/Exception
    //   410	438	579	java/lang/Exception
    //   448	509	579	java/lang/Exception
    //   519	566	579	java/lang/Exception
    //   566	576	579	java/lang/Exception
    //   607	656	579	java/lang/Exception
    //   661	698	579	java/lang/Exception
    //   698	718	579	java/lang/Exception
    //   718	740	579	java/lang/Exception
    //   745	764	579	java/lang/Exception
    //   767	784	579	java/lang/Exception
    //   789	813	579	java/lang/Exception
    //   816	904	913	java/lang/Exception
    //   933	948	1046	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   976	998	1202	java/lang/Exception
    //   1003	1010	1202	java/lang/Exception
    //   1022	1037	1202	java/lang/Exception
    //   1095	1102	1202	java/lang/Exception
    //   1117	1139	1202	java/lang/Exception
    //   1153	1161	1202	java/lang/Exception
    //   1164	1181	1202	java/lang/Exception
    //   1190	1199	1202	java/lang/Exception
    //   1783	1798	1899	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1810	1876	1899	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1947	1996	2101	java/lang/Exception
    //   2001	2050	2101	java/lang/Exception
    //   2056	2065	2101	java/lang/Exception
    //   2077	2094	2101	java/lang/Exception
    //   2157	2172	2253	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2184	2222	2253	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i1 = 0;
    Object localObject1 = (QQAppInterface)getAppRuntime();
    int i2 = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject2;
    Object localObject3;
    switch (i2)
    {
    default: 
      paramIntent = null;
    case 2: 
    case 1: 
    case 4: 
      for (;;)
      {
        if (paramIntent != null) {
          paramPacket.setSSOCommand(paramIntent);
        }
        return;
        paramPacket.setTimeout(10000L);
        localObject1 = paramIntent.getStringExtra("k_uin");
        if (i2 == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramPacket.putSendData(a(bool, paramIntent.getBooleanExtra("k_sync_ss", false), Long.parseLong((String)localObject1)));
          paramIntent = "OidbSvc.0x515_2";
          break;
        }
        localObject1 = "OidbSvc.0x53f_2";
        localObject2 = paramIntent.getStringExtra("k_uin");
        i1 = paramIntent.getIntExtra("k_end_time", Integer.MAX_VALUE);
        i2 = paramIntent.getIntExtra("k_start_time", 0);
        paramPacket.putSendData(a(Long.parseLong((String)localObject2), Integer.valueOf(i2).intValue(), Integer.valueOf(i1).intValue()));
        paramIntent = (Intent)localObject1;
      }
    case 3: 
      localObject2 = new ReqGetSameStateList();
      ((ReqGetSameStateList)localObject2).oHead = new BusiReqHead();
      ((ReqGetSameStateList)localObject2).vCookie = paramIntent.getByteArrayExtra("k_cookie");
      if (((ReqGetSameStateList)localObject2).vCookie == null) {
        ((ReqGetSameStateList)localObject2).vCookie = new byte[0];
      }
      localObject3 = new RichStatus("");
      ((RichStatus)localObject3).actionText = "foo";
      ((RichStatus)localObject3).actionId = paramIntent.getIntExtra("k_action", 0);
      ((RichStatus)localObject3).dataText = "foo";
      ((RichStatus)localObject3).dataId = paramIntent.getIntExtra("k_data", 0);
      ((ReqGetSameStateList)localObject2).oSelfRishState = new stRishState(((RichStatus)localObject3).encode(), 0L);
      localObject3 = ((FriendsManager)((QQAppInterface)localObject1).getManager(50)).a(((QQAppInterface)localObject1).a());
      if (localObject3 != null) {
        if (((Card)localObject3).shGender != 0) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      ((ReqGetSameStateList)localObject2).eSelfSex = i1;
      ((ReqGetSameStateList)localObject2).iPageSize = 50;
      ((ReqGetSameStateList)localObject2).oLbsInfo = a((QQAppInterface)localObject1);
      ((ReqGetSameStateList)localObject2).eFetchSex = paramIntent.getIntExtra("k_fetch_sex", -1);
      paramIntent = paramIntent.getStringExtra("k_uin");
      if (!TextUtils.isEmpty(paramIntent)) {}
      try
      {
        ((ReqGetSameStateList)localObject2).lFriendUin = Long.parseLong(paramIntent);
        paramPacket.setServantName("PersonalStateSvc");
        paramPacket.setFuncName("ReqGetSameStateList");
        paramPacket.addRequestPacket("ReqGetSameStateList", (JceStruct)localObject2);
        paramIntent = "PersonalStateSvc.ReqGetSameStateList";
        break;
        if (((Card)localObject3).shGender != 1) {
          break label931;
        }
        i1 = 1;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
      localObject1 = "OidbSvc.0x54f_0";
      localObject2 = paramIntent.getByteArrayExtra("k_status_key");
      i1 = paramIntent.getIntExtra("k_status_flag", 1);
      paramIntent = new ArrayList();
      paramIntent.add(localObject2);
      paramPacket.putSendData(a(paramIntent, (byte)i1));
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "PersonalStateSvc.ReqGetHotState";
      paramIntent = new ReqGetHotState();
      paramIntent.oHead = new BusiReqHead();
      paramPacket.setServantName("PersonalStateSvc");
      paramPacket.setFuncName("ReqGetHotState");
      paramPacket.addRequestPacket("ReqGetHotState", paramIntent);
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("get_hot_rich_status", 2, "StatusServlet.onSend()");
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "OidbSvc.0x50f_29";
      paramPacket.putSendData(a(paramIntent.getByteArrayExtra("k_data")));
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "OidbSvc.0x510_0";
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1296);
      paramIntent.uint32_service_type.set(0);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.EMPTY);
      paramIntent = paramIntent.toByteArray();
      localObject2 = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject2).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject2).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject2).array());
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatusServlet", 2, "clearRichStatus...");
      paramIntent = (Intent)localObject1;
      break;
      i1 = paramIntent.getIntExtra("k_tpl_id", 0);
      i2 = paramIntent.getIntExtra("k_sign_len", 2);
      localObject3 = paramIntent.getByteArrayExtra("k_sign_data");
      paramIntent = new SigActPb.Platform();
      paramIntent.platform.set(109L);
      paramIntent.mqqver.set("6.5.5");
      paramIntent.osver.set(DeviceInfoUtil.e());
      localObject2 = new SigActPb.SigauthReq();
      ((SigActPb.SigauthReq)localObject2).uin_disable.set(Long.parseLong(((QQAppInterface)localObject1).a()));
      ((SigActPb.SigauthReq)localObject2).itemid.set(i1);
      ((SigActPb.SigauthReq)localObject2).data.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((SigActPb.SigauthReq)localObject2).len.set(i2);
      localObject1 = new SigActPb.ReqBody();
      ((SigActPb.ReqBody)localObject1).cmd.set(2);
      ((SigActPb.ReqBody)localObject1).plf.set(paramIntent);
      ((SigActPb.ReqBody)localObject1).auth_req.set((MessageMicro)localObject2);
      ((SigActPb.ReqBody)localObject1).seq.set(System.currentTimeMillis());
      paramIntent = ((SigActPb.ReqBody)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.a((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.a((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        QLog.d("StatusServlet", 2, "Signature.auth");
        paramIntent = "Signature.auth";
        break;
      }
      paramIntent = "Signature.auth";
      break;
      label931:
      i1 = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\StatusServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */