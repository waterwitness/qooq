package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import java.util.List;

public class SnapPicUpHandler
  extends BDHCommonUpHandler
{
  public SnapPicUpHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    boolean bool = false;
    ProtoReqManager.ProtoReq localProtoReq;
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localProtoReq = new ProtoReqManager.ProtoReq();
      if (!paramRichProtoReq.jdField_a_of_type_JavaUtilList.isEmpty()) {
        bool = ((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.jdField_a_of_type_JavaUtilList.get(0)).a;
      }
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (String str = "ImgStore.SecretMsgSnapPicUp";; str = "ImgStore.SecretMsgPicUp")
    {
      localProtoReq.jdField_a_of_type_JavaLangString = str;
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\SnapPicUpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */