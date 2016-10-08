package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;

public class C2CPicDownHandler
  extends BaseHandler
{
  public C2CPicDownHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: bipush 16
    //   2: istore 7
    //   4: aload_2
    //   5: checkcast 23	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq
    //   8: astore 5
    //   10: new 25	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   13: dup
    //   14: invokespecial 26	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   17: astore 6
    //   19: aload 6
    //   21: iconst_1
    //   22: invokevirtual 30	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   25: aload 6
    //   27: getfield 34	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   30: aload 5
    //   32: getfield 38	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:d	Ljava/lang/String;
    //   35: invokestatic 44	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   38: invokevirtual 48	java/lang/Long:longValue	()J
    //   41: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   44: aload 6
    //   46: getfield 58	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_pic_up_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: aload 5
    //   51: getfield 62	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_b_of_type_Int	I
    //   54: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   57: aload 5
    //   59: getfield 70	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:c	Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: astore_2
    //   67: aload 4
    //   69: ldc 72
    //   71: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +10 -> 84
    //   77: aload 4
    //   79: iconst_1
    //   80: invokevirtual 82	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 44	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 48	java/lang/Long:longValue	()J
    //   91: lstore 8
    //   93: aload 6
    //   95: getfield 85	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: lload 8
    //   100: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   103: aload 5
    //   105: getfield 87	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: ldc 89
    //   110: invokevirtual 93	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   113: astore_2
    //   114: aload 6
    //   116: getfield 97	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: aload_2
    //   120: invokestatic 103	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 108	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   126: aload 6
    //   128: getfield 112	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   131: aload 5
    //   133: getfield 114	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Boolean	Z
    //   136: invokevirtual 118	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   139: ldc 120
    //   141: aload 5
    //   143: getfield 122	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +138 -> 287
    //   152: aload 6
    //   154: getfield 129	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: iconst_2
    //   158: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   161: aload 6
    //   163: getfield 132	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   166: iconst_5
    //   167: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   170: aload 6
    //   172: getfield 112	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   175: aload 5
    //   177: getfield 114	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Boolean	Z
    //   180: invokevirtual 118	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   183: aload 6
    //   185: getfield 135	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: bipush 9
    //   190: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: aload 6
    //   195: getfield 138	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: iconst_1
    //   199: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   202: aload 5
    //   204: getfield 140	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Int	I
    //   207: istore_1
    //   208: iload_1
    //   209: ldc -115
    //   211: if_icmpne +123 -> 334
    //   214: invokestatic 146	com/tencent/mobileqq/statistics/GeneralConfigUtils:a	()Z
    //   217: ifeq +109 -> 326
    //   220: bipush 16
    //   222: istore_1
    //   223: iconst_4
    //   224: istore 7
    //   226: aload 6
    //   228: getfield 149	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: iload 7
    //   233: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   236: aload 6
    //   238: getfield 152	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   241: iload_1
    //   242: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   245: aload 6
    //   247: getfield 155	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokestatic 160	com/tencent/mobileqq/transfile/RichMediaUtil:a	()Ljava/lang/String;
    //   253: invokestatic 164	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 108	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   259: aload_3
    //   260: getfield 170	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   263: aload 6
    //   265: invokevirtual 176	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   268: return
    //   269: astore_2
    //   270: aload_2
    //   271: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   274: goto -171 -> 103
    //   277: astore_2
    //   278: aload_2
    //   279: invokevirtual 180	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   282: aconst_null
    //   283: astore_2
    //   284: goto -170 -> 114
    //   287: ldc -74
    //   289: aload 5
    //   291: getfield 122	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   294: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   297: ifeq +15 -> 312
    //   300: aload 6
    //   302: getfield 129	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: iconst_1
    //   306: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   309: goto -148 -> 161
    //   312: aload 6
    //   314: getfield 129	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   317: sipush 255
    //   320: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   323: goto -162 -> 161
    //   326: iconst_1
    //   327: istore_1
    //   328: iconst_4
    //   329: istore 7
    //   331: goto -105 -> 226
    //   334: iload_1
    //   335: iconst_1
    //   336: if_icmpne +13 -> 349
    //   339: bipush 6
    //   341: istore 7
    //   343: bipush 8
    //   345: istore_1
    //   346: goto -120 -> 226
    //   349: iload_1
    //   350: ldc -73
    //   352: if_icmpne +8 -> 360
    //   355: iconst_2
    //   356: istore_1
    //   357: goto -131 -> 226
    //   360: iconst_0
    //   361: istore_1
    //   362: iconst_0
    //   363: istore 7
    //   365: goto -139 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	C2CPicDownHandler
    //   0	368	1	paramInt	int
    //   0	368	2	paramReqCommon	RichProto.RichProtoReq.ReqCommon
    //   0	368	3	paramReqBody	cmd0x352.ReqBody
    //   62	16	4	str	String
    //   8	282	5	localC2CPicDownReq	RichProto.RichProtoReq.C2CPicDownReq
    //   17	296	6	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    //   2	362	7	i	int
    //   91	8	8	l	long
    // Exception table:
    //   from	to	target	type
    //   57	64	269	java/lang/Exception
    //   67	84	269	java/lang/Exception
    //   84	103	269	java/lang/Exception
    //   103	114	277	java/io/UnsupportedEncodingException
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        a(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label263;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, 56009, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label263:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        cmd0x352.GetImgUrlRsp localGetImgUrlRsp = (cmd0x352.GetImgUrlRsp)localIterator.next();
        try
        {
          localPicDownResp = (RichProto.RichProtoResp.PicDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            RichProto.RichProtoResp.PicDownResp localPicDownResp;
            RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq;
            label422:
            Object localObject2;
            label450:
            localObject1 = null;
            continue;
            paramProtoResp = null;
            continue;
            i = 0;
            continue;
            i = 1;
            continue;
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject2 == null)
              {
                localObject2 = null;
                continue;
                if (paramProtoResp != null) {}
              }
            }
          }
        }
        try
        {
          localC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)localRichProtoReq.jdField_a_of_type_JavaUtilList.get(0);
          if (localPicDownResp == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            localPicDownResp.e = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label815;
          }
          if (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) {
            break label891;
          }
          if (localGetImgUrlRsp.rpt_uint32_down_port.size() > 0) {
            break label885;
          }
        }
        catch (Exception paramProtoResp)
        {
          localObject1 = localPicDownResp;
        }
        if (GeneralConfigUtils.a())
        {
          paramProtoResp = localGetImgUrlRsp.bytes_big_thumb_down_para.get();
          localObject1 = localGetImgUrlRsp.bytes_original_down_para.get();
          localObject2 = localGetImgUrlRsp.bytes_big_down_para.get();
          if (paramProtoResp != null) {
            break label564;
          }
          paramProtoResp = null;
          break label897;
          if (localC2CPicDownReq.jdField_a_of_type_Int != 65537) {
            break label590;
          }
        }
        for (;;)
        {
          if ((i == 0) || (localGetImgUrlRsp.bytes_down_domain.has())) {
            break label914;
          }
          throw new Exception("no ip");
          if (localObject1 == null) {
            break;
          }
          a(-1, 56009, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          break;
          paramProtoResp = localGetImgUrlRsp.bytes_thumb_down_para.get();
          break label422;
          label564:
          paramProtoResp = paramProtoResp.toStringUtf8();
          break label897;
          localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
          break label903;
          localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
          break label450;
          label590:
          if (localC2CPicDownReq.jdField_a_of_type_Int == 1)
          {
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject2;
          }
          else
          {
            if (localC2CPicDownReq.jdField_a_of_type_Int != 131075) {
              break label880;
            }
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
          }
        }
        localPicDownResp.jdField_a_of_type_JavaLangString = paramProtoResp;
        if (i == 0)
        {
          paramProtoResp = localGetImgUrlRsp.rpt_uint32_down_ip.get();
          localObject1 = localGetImgUrlRsp.rpt_uint32_down_port.get();
          i = 0;
          while (i < paramProtoResp.size())
          {
            localObject2 = new ServerAddr();
            ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = PkgTools.a(((Integer)paramProtoResp.get(i)).intValue() & 0xFFFFFFFF);
            ((ServerAddr)localObject2).jdField_b_of_type_Int = ((Integer)((List)localObject1).get(i)).intValue();
            localPicDownResp.jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
            i += 1;
          }
        }
        if (localGetImgUrlRsp.bytes_down_domain.has())
        {
          paramProtoResp = new ServerAddr();
          paramProtoResp.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
          paramProtoResp.jdField_b_of_type_Int = 80;
          localPicDownResp.jdField_a_of_type_JavaUtilArrayList.add(paramProtoResp);
          localPicDownResp.jdField_b_of_type_JavaLangString = paramProtoResp.jdField_a_of_type_JavaLangString;
        }
        a(0, 0, "", "", localStatictisInfo, localPicDownResp);
        continue;
        label815:
        if (C2CPicUpHandler.a(i))
        {
          this.aI += 1;
          if (this.aI < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, 56009, BaseTransProcessor.a(i), "", localStatictisInfo, localPicDownResp);
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "LongConn.OffPicDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (NetworkCenter.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = NetworkCenter.a().a();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.PicDownResp localPicDownResp = new RichProto.RichProtoResp.PicDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localPicDownResp);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\C2CPicDownHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */