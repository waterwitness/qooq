package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp;

public class C2CPicUpHandler
  extends BaseHandler
{
  int aH;
  
  public C2CPicUpHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    RichProto.RichProtoReq.PicUpReq localPicUpReq = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localPicUpReq.jdField_c_of_type_JavaLangString).longValue());
    try
    {
      String str = localPicUpReq.jdField_d_of_type_JavaLangString;
      paramReqCommon = str;
      if (str.startsWith("+")) {
        paramReqCommon = str.substring(1);
      }
      long l = Long.valueOf(paramReqCommon).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramReqCommon)
    {
      for (;;)
      {
        paramReqCommon.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localPicUpReq.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localPicUpReq.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localPicUpReq.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localPicUpReq.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(localPicUpReq.jdField_b_of_type_Boolean);
    localTryUpImgReq.uint32_pic_width.set(localPicUpReq.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(localPicUpReq.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(localPicUpReq.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramProtoResp = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramProtoResp.equals("conSucc")) || (paramProtoResp.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject1 = MessageHandler.b(localFromServiceMsg);
          paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          a(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, String.valueOf(i), paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramProtoResp, localFromServiceMsg.getBusinessFailMsg(), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      cmd0x352.RspBody localRspBody;
      try
      {
        localRspBody = (cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte);
        paramProtoResp = localRspBody.rpt_msg_tryup_img_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label320;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, 56009, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label320:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localObject1 = (RichProto.RichProtoResp.C2CPicUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get((int)paramProtoResp.uint64_file_id.get());
          if (localObject1 == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).e = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramProtoResp.uint32_result.get();
            if (i != 0) {
              break label945;
            }
            if ((paramProtoResp.bytes_up_resid.has()) || (paramProtoResp.bytes_up_uuid.has())) {
              break label511;
            }
            throw new Exception("no resid and uuid");
          }
          catch (Exception paramProtoResp) {}
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            localObject1 = null;
            continue;
            boolean bool = true;
            continue;
            bool = false;
          }
        }
        a(-1, 56009, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
        continue;
        label511:
        localObject2 = paramProtoResp.bytes_up_resid.get().toStringUtf8();
        localObject3 = paramProtoResp.bytes_up_uuid.get().toStringUtf8();
        if (localObject2 != null) {
          break label1009;
        }
        bool = false;
        ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
        ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject3);
        ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_b_of_type_Boolean = bool;
        ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_a_of_type_Long = paramProtoResp.uint64_up_offset.get();
        if (QLog.isColorLevel()) {
          QLog.d("BDH_LOG", 2, " TryUpLoad : RespBody.bool_new_bigchan:" + localRspBody.bool_new_bigchan.has() + " Value:" + localRspBody.bool_new_bigchan.get() + " Offset:" + ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_a_of_type_Long + " Value:" + paramProtoResp.uint64_up_offset.get());
        }
        if ((localRspBody.bool_new_bigchan.has()) && (localRspBody.bool_new_bigchan.get() == true)) {
          ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).d = true;
        }
        if ((paramProtoResp.bool_file_exit.has()) && (paramProtoResp.bool_file_exit.get())) {
          ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_a_of_type_Boolean = true;
        }
        for (;;)
        {
          a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          break;
          localObject2 = paramProtoResp.bytes_up_ukey.get().toByteArray();
          if ((paramProtoResp.rpt_uint32_up_ip.size() <= 0) || (paramProtoResp.rpt_uint32_up_port.size() <= 0) || (localObject2 == null) || (localObject2.length == 0)) {
            throw new Exception("check ip,port,ukey");
          }
          ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_c_of_type_JavaLangString = HexUtil.bytes2HexStr((byte[])localObject2);
          ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_a_of_type_Int = ((int)paramProtoResp.uint64_block_size.get());
          localObject2 = paramProtoResp.rpt_uint32_up_ip.get();
          paramProtoResp = paramProtoResp.rpt_uint32_up_port.get();
          i = 0;
          while (i < ((List)localObject2).size())
          {
            long l1 = ((Integer)((List)localObject2).get(i)).intValue();
            long l2 = ((Integer)paramProtoResp.get(i)).intValue();
            localObject3 = new ServerAddr();
            ((ServerAddr)localObject3).jdField_a_of_type_JavaLangString = PkgTools.a(l1 & 0xFFFFFFFF);
            ((ServerAddr)localObject3).b = ((int)l2);
            ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localObject3);
            i += 1;
          }
          if (NetworkCenter.a().a() == this.aH) {
            break label1015;
          }
          bool = true;
          ((RichProto.RichProtoResp.C2CPicUpResp)localObject1).jdField_c_of_type_Boolean = bool;
        }
        label945:
        if (a(i))
        {
          this.aI += 1;
          if (this.aI < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, 56009, BaseTransProcessor.a(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "LongConn.OffPicUp";
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
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    i = NetworkCenter.a().a();
    this.aH = i;
    switch (i)
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
      RichProto.RichProtoResp.C2CPicUpResp localC2CPicUpResp = new RichProto.RichProtoResp.C2CPicUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localC2CPicUpResp);
      i += 1;
    }
  }
  
  void d(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    if (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback != null) {
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback.a(paramRichProtoReq, localRichProtoResp);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\C2CPicUpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */