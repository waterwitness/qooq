import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class tul
{
  public int a;
  public String a;
  public List a;
  public int b;
  public String b;
  
  public tul()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("BusiConfigParseResult: result=").append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(",resParseResultType=").append(this.b);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(",resList.size=");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder2.append(i);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */