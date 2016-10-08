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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class GroupPttDownHandler
  extends BaseHandler
{
  public GroupPttDownHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    Object localObject = (RichProto.RichProtoReq.GroupPttDownReq)paramReqCommon;
    paramReqCommon = new cmd0x388.GetPttUrlReq();
    paramReqCommon.setHasFlag(true);
    paramReqCommon.uint64_file_id.set(paramInt);
    paramReqCommon.uint64_dst_uin.set(Long.valueOf(((RichProto.RichProtoReq.GroupPttDownReq)localObject).c).longValue());
    paramReqCommon.uint64_group_code.set(Long.parseLong(((RichProto.RichProtoReq.GroupPttDownReq)localObject).d));
    paramReqCommon.bytes_file_md5.set(ByteStringMicro.copyFrom(((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_ArrayOfByte));
    if (((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_Long != 0L) {
      paramReqCommon.uint64_fileid.set(((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_Long);
    }
    paramReqCommon.uint32_req_platform_type.set(9);
    paramReqCommon.uint32_req_term.set(5);
    paramReqCommon.uint32_inner_ip.set(0);
    PBUInt32Field localPBUInt32Field = paramReqCommon.uint32_bu_type;
    if (((RichProto.RichProtoReq.GroupPttDownReq)localObject).e == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      localPBUInt32Field.set(paramInt);
      paramReqCommon.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      paramReqCommon.uint32_codec.set(((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_Int);
      if (((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = ((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_JavaLangString.getBytes("utf-8");
        paramReqCommon.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        paramReqBody.rpt_msg_getptt_url_req.add(paramReqCommon);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;) {}
      }
    }
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
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        Iterator localIterator = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramProtoResp = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception paramProtoResp)
      {
        a(-1, 56009, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      try
      {
        localObject1 = (RichProto.RichProtoResp.GroupPttDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get((int)paramProtoResp.uint64_file_id.get());
        if ((localObject1 == null) || (localFromServiceMsg == null)) {}
      }
      catch (Exception paramProtoResp)
      {
        List localList;
        localObject1 = null;
        continue;
        i = 1;
        continue;
      }
      try
      {
        ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).e = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).e);
        }
        i = paramProtoResp.uint32_result.get();
        if (i != 0) {
          break label689;
        }
        i = 0;
        if ((paramProtoResp.rpt_uint32_down_ip.size() <= 0) || (paramProtoResp.rpt_uint32_down_port.size() <= 0)) {
          break label753;
        }
        localObject2 = paramProtoResp.bytes_down_para.get().toStringUtf8();
        ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
        if ((localObject2 != null) && ((i == 0) || (paramProtoResp.bytes_down_domain.has()))) {
          break label498;
        }
        throw new Exception("no url or ip");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, 56009, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
      }
      continue;
      break;
      label498:
      if (i == 0)
      {
        localObject2 = paramProtoResp.rpt_uint32_down_ip.get();
        localList = paramProtoResp.rpt_uint32_down_port.get();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          ServerAddr localServerAddr = new ServerAddr();
          localServerAddr.jdField_a_of_type_JavaLangString = PkgTools.a(((Integer)((List)localObject2).get(i)).intValue() & 0xFFFFFFFF);
          localServerAddr.b = ((Integer)localList.get(i)).intValue();
          ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localServerAddr);
          i += 1;
        }
      }
      if (paramProtoResp.bytes_down_domain.has())
      {
        localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = paramProtoResp.bytes_down_domain.get().toStringUtf8();
        ((ServerAddr)localObject2).b = 80;
        ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).b = ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString;
      }
      a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
      continue;
      label689:
      if (GroupPicUpHandler.a(i))
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
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
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
      RichProto.RichProtoResp.GroupPttDownResp localGroupPttDownResp = new RichProto.RichProtoResp.GroupPttDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localGroupPttDownResp);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\GroupPttDownHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */