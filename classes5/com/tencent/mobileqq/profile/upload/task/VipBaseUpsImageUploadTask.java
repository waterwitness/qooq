package com.tencent.mobileqq.profile.upload.task;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class VipBaseUpsImageUploadTask
  extends VipBaseUploadTask
{
  public long b;
  protected boolean b;
  public byte[] e;
  public String n;
  public int o;
  public String o;
  public int p;
  protected String p;
  public int q;
  public int r;
  public int s;
  public int t;
  
  public VipBaseUpsImageUploadTask()
  {
    this.jdField_o_of_type_Int = 13;
    this.s = 3;
    this.t = 1;
  }
  
  public VipBaseUpsImageUploadTask(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    super(paramLong, paramString1, paramArrayOfByte);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_o_of_type_Int = 13;
    this.s = 3;
    this.t = 1;
    this.jdField_p_of_type_JavaLangString = paramString2;
  }
  
  public VipBaseUploadTask a()
  {
    UpsImageUploadTask localUpsImageUploadTask = new UpsImageUploadTask(this.jdField_b_of_type_Boolean);
    localUpsImageUploadTask.b2Gt = this.jdField_a_of_type_ArrayOfByte;
    localUpsImageUploadTask.dataType = this.jdField_o_of_type_Int;
    localUpsImageUploadTask.fileId = this.n;
    localUpsImageUploadTask.flowId = this.jdField_m_of_type_Int;
    localUpsImageUploadTask.hasRetried = this.jdField_a_of_type_Boolean;
    localUpsImageUploadTask.iBatchID = this.jdField_b_of_type_Long;
    localUpsImageUploadTask.iBatchUploadCount = this.jdField_p_of_type_Int;
    localUpsImageUploadTask.iBusiNessType = this.q;
    localUpsImageUploadTask.iCurrentUploadOrder = this.r;
    localUpsImageUploadTask.iLoginType = this.jdField_j_of_type_Int;
    localUpsImageUploadTask.iSync = this.jdField_k_of_type_Int;
    localUpsImageUploadTask.iUin = this.jdField_a_of_type_Long;
    localUpsImageUploadTask.iUploadType = this.s;
    localUpsImageUploadTask.keepRaw = this.t;
    localUpsImageUploadTask.md5 = this.jdField_m_of_type_JavaLangString;
    localUpsImageUploadTask.preupload = this.jdField_l_of_type_Int;
    localUpsImageUploadTask.progressListener = this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask$IProgressDelegate;
    localUpsImageUploadTask.reportRefer = this.i;
    localUpsImageUploadTask.sBusinessId = this.jdField_p_of_type_JavaLangString;
    localUpsImageUploadTask.sCommand = this.jdField_o_of_type_JavaLangString;
    localUpsImageUploadTask.sRefer = this.jdField_j_of_type_JavaLangString;
    localUpsImageUploadTask.transferData = this.jdField_a_of_type_JavaUtilMap;
    localUpsImageUploadTask.uiRefer = this.jdField_k_of_type_JavaLangString;
    localUpsImageUploadTask.uploadFilePath = this.jdField_l_of_type_JavaLangString;
    localUpsImageUploadTask.uploadTaskCallback = this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback;
    localUpsImageUploadTask.vBusiNessData = this.e;
    localUpsImageUploadTask.vLoginData = this.jdField_b_of_type_ArrayOfByte;
    localUpsImageUploadTask.vLoginKey = this.c;
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask = localUpsImageUploadTask;
    return this;
  }
  
  protected void a(int paramInt, Object... paramVarArgs) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\upload\task\VipBaseUpsImageUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */