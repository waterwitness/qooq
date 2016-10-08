import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ugu
  extends ugs
{
  public int a;
  long jdField_a_of_type_Long;
  public String a;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  public int i;
  int j;
  int k;
  int l;
  int m;
  
  ugu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.j = -1;
    this.k = -1;
    this.l = 1001;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.m = -1;
  }
  
  public HashMap a(String paramString)
  {
    if ("ShortVideo.Send".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_DetailUrl", this.jdField_a_of_type_JavaLangString);
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_isForward", this.jdField_a_of_type_Boolean + "");
      paramString.put("param_isExist", this.jdField_b_of_type_Boolean + "");
      paramString.put("param_forwardSourceUinType", this.jdField_a_of_type_Int + "");
      paramString.put("param_forwardSourceGroupMemberCount", this.i + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_userType", this.l + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_shortVideoSourceType", this.j + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_fileInterval", this.k + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_md5", this.jdField_b_of_type_JavaLangString);
      paramString.put("param_fileSize", this.jdField_a_of_type_Long + "");
      paramString.put("param_duration", this.jdField_b_of_type_Long + "");
      paramString.put("param_status", this.m + "");
      return paramString;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */