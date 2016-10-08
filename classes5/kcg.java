import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kcg
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public kcg(QFindBLEScanMgr paramQFindBLEScanMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof kcg))) {
      return paramObject.hashCode() == hashCode();
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str);
      if (this.b != null) {
        break label54;
      }
    }
    label54:
    for (String str = "";; str = this.b)
    {
      return str.hashCode();
      str = this.jdField_a_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */