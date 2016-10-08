package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class UrlDownloader
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo a;
  
  public UrlDownloader(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void a()
  {
    e();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramNetResp.e == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a("onHttpResp", bool);
      this.b += paramNetResp.c;
      if (paramNetResp.e != 0) {
        break;
      }
      c();
      return;
    }
    b();
  }
  
  void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localTransferResult != null)
    {
      localTransferResult.d = -1;
      localTransferResult.jdField_a_of_type_Long = this.aU;
      localTransferResult.jdField_a_of_type_JavaLangString = this.bc;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      return;
    }
    finally {}
  }
  
  void c()
  {
    super.c();
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    if (localTransferResult != null)
    {
      localTransferResult.d = 0;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      return;
    }
    finally {}
  }
  
  void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
    localHttpNetReq.b = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localHttpNetReq.jdField_a_of_type_Long = this.b;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d)
    {
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-");
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    }
    localHttpNetReq.k = 4;
    localHttpNetReq.jdField_d_of_type_Long = 90000L;
    a("httpDown", " url:" + str + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\UrlDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */