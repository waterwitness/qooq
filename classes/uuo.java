import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.text.SimpleDateFormat;
import java.util.Date;

public class uuo
{
  public int a;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public uuo(long paramLong, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    int i;
    if (paramString1 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label72;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = (j + (i + 19 + 1) + 1);
      return;
      i = paramString1.getBytes().length;
      break;
      label72:
      j = paramString2.getBytes().length;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    Date localDate = new Date(this.jdField_a_of_type_Long);
    localStringBuilder.append(StatisticCollector.a().format(localDate));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */