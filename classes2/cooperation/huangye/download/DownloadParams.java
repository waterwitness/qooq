package cooperation.huangye.download;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class DownloadParams
{
  public static final int a = 3;
  public static final int b = 5000;
  public static final int c = 60000;
  public static final int d = -2;
  public static final int e = -1;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public DownloadResult a;
  public Object a;
  public String a;
  public HashMap a;
  public int j;
  public int k;
  public int l;
  
  public DownloadParams()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 3;
    this.k = 5000;
    this.l = 60000;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrl = ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mConnectionTimeout = ").append(this.k);
    localStringBuilder.append(",mSocketTimeout = ").append(this.l);
    if (this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult != null)
    {
      localStringBuilder.append(",mResult.mIsSucc = ").append(this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_Boolean);
      localStringBuilder.append(",mResult.mFileLength = ").append(this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_Long);
      localStringBuilder.append(",mResult.mErrCode = ").append(this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_Int);
      localStringBuilder.append(",mResult.mErrStr = ").append(this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",mResult.mTryCount = ").append(this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_b_of_type_Int);
      localStringBuilder.append(",mResult.mCostTime = ").append(this.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_b_of_type_Long).append("ms");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(",mResult = null");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\download\DownloadParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */