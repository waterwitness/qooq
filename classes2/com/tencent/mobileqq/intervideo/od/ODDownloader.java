package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.txproxy.HostEventListener;

public class ODDownloader
  implements INetEngine.INetEngineListener
{
  private static final String jdField_a_of_type_JavaLangString = "ODSDK|ODPROXY";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public INetEngine a;
  HostEventListener jdField_a_of_type_ComTencentTxproxyHostEventListener;
  
  public ODDownloader(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    }
  }
  
  private void a()
  {
    new Bundle().putBoolean("issuccess", true);
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadResult(0, 200, "");
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    int i = paramNetResp.g;
    int j = paramNetResp.f;
    paramNetResp = paramNetResp.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadResult(j, i, paramNetResp);
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = new Bundle();
    paramNetReq.putLong("offset", paramLong1);
    paramNetReq.putLong("totallen", paramLong2);
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadProgress(paramLong1, paramLong2);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.e == 0)
    {
      a();
      return;
    }
    b(paramNetResp);
  }
  
  public boolean a(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString1;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.b = paramString2;
    localHttpNetReq.f = false;
    localHttpNetReq.k = 3;
    this.jdField_a_of_type_ComTencentTxproxyHostEventListener = paramHostEventListener;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\od\ODDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */