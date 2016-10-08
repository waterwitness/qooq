package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.HashMap;

public class QlAndQQInterface$ReportPerformanceInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long mDuration;
  public HashMap mParams;
  public long mSize;
  public boolean mSuccess;
  public String mTagName;
  public String mUin;
  
  public QlAndQQInterface$ReportPerformanceInfo(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mUin = paramString1;
    this.mTagName = paramString2;
    this.mSuccess = paramBoolean;
    this.mDuration = paramLong1;
    this.mSize = paramLong2;
    this.mParams = paramHashMap;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlAndQQInterface$ReportPerformanceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */