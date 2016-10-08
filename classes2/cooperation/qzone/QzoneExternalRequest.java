package cooperation.qzone;

import QMF_PROTOCAL.RetryInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.qzone.util.ProtocolUtils;

public abstract class QzoneExternalRequest
{
  public static final String FIELD_REFER = "refer";
  public static final String FIELD_UIN = "hostuin";
  public static final int QZONE_BUSSINESS_ID = 1000027;
  public static final String TAIL_NAME = "tail_name";
  private String charset;
  private String deviceTail;
  protected long hostUin;
  private long loginUserId;
  protected boolean needCompress;
  private String refer;
  private RetryInfo retryInfo;
  
  public QzoneExternalRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.charset = "utf-8";
    this.needCompress = true;
  }
  
  protected static JceStruct decode(byte[] paramArrayOfByte, String paramString)
  {
    return ProtocolUtils.a(paramArrayOfByte, paramString);
  }
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = QUA.a();
    long l = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return WupUtil.a(((WNSStream)localObject1).a(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.needCompress));
    }
    return null;
  }
  
  public String getCharset()
  {
    return this.charset;
  }
  
  public abstract String getCmdString();
  
  public String getDeviceInfo()
  {
    return PlatformInfor.a().e();
  }
  
  public String getDeviceTail()
  {
    return this.deviceTail;
  }
  
  protected byte[] getEncodedUniParameter()
  {
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.setEncodeName("utf8");
    localUniAttribute.put("hostuin", Long.valueOf(getHostUin()));
    String str = uniKey();
    if (!TextUtils.isEmpty(str)) {
      localUniAttribute.put(str, getReq());
    }
    this.refer = getRefer();
    if (!TextUtils.isEmpty(this.refer)) {
      localUniAttribute.put("refer", this.refer);
    }
    str = getDeviceTail();
    if (!TextUtils.isEmpty(str)) {
      localUniAttribute.put("tail_name", str);
    }
    return localUniAttribute.encode();
  }
  
  protected long getHostUin()
  {
    return this.hostUin;
  }
  
  public long getLoginUserId()
  {
    return this.loginUserId;
  }
  
  public String getRefer()
  {
    return this.refer;
  }
  
  public abstract JceStruct getReq();
  
  public Object getRetryInfo()
  {
    return this.retryInfo;
  }
  
  public void setCharset(String paramString)
  {
    this.charset = paramString;
  }
  
  public void setDeviceTail(String paramString)
  {
    this.deviceTail = paramString;
  }
  
  public void setHostUin(long paramLong)
  {
    this.hostUin = paramLong;
  }
  
  public void setLoginUserId(long paramLong)
  {
    this.loginUserId = paramLong;
  }
  
  public void setRefer(String paramString)
  {
    this.refer = paramString;
  }
  
  public abstract String uniKey();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QzoneExternalRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */