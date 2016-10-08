package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneExternalRequest;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class WebSoRequest
  extends QzoneExternalRequest
{
  private JceStruct jdField_a_of_type_ComQqTafJceJceStruct;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public WebSoRequest() {}
  
  public WebSoRequest(String paramString1, long paramLong, HttpReq paramHttpReq, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setRefer(paramString2);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.jdField_a_of_type_ComQqTafJceJceStruct = paramHttpReq;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.needCompress = false;
    this.b = a(paramString1);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[(paramString.length - 1)];
  }
  
  public static HttpRsp a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramString = (HttpRsp)decode(paramArrayOfByte, paramString);
      paramArrayOfByte = paramString;
    } while (paramString != null);
    return null;
  }
  
  public String getCmdString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public String uniKey()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\webso\WebSoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */