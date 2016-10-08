import com.tencent.biz.pubaccount.PublicAccountManageAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class hqc
{
  public long a;
  public PublicAccountInfo a;
  public String a;
  public String b;
  
  public hqc(PublicAccountManageAdapter paramPublicAccountManageAdapter, PublicAccountInfo paramPublicAccountInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    long l = PublicAccountUtil.b(paramPublicAccountInfo.lastAIOReadTime) / PublicAccountConfigUtil.c;
    this.jdField_a_of_type_Long = (PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis()) / PublicAccountConfigUtil.c - l);
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */