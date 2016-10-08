import com.tencent.biz.pubaccount.PublicAccountManageAdapter;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class hpy
  implements Comparator
{
  public hpy(PublicAccountManageAdapter paramPublicAccountManageAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(hqc paramhqc1, hqc paramhqc2)
  {
    long l1 = paramhqc1.jdField_a_of_type_Long;
    long l2 = paramhqc2.jdField_a_of_type_Long;
    if (l1 < l2) {}
    int j;
    int k;
    do
    {
      do
      {
        return 1;
        if (l1 > l2) {
          return -1;
        }
        paramhqc1 = paramhqc1.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
        paramhqc2 = paramhqc2.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
        if ((paramhqc1 == null) && (paramhqc2 == null)) {
          return 0;
        }
        if ((paramhqc1 == null) && (paramhqc2 != null)) {
          return -1;
        }
      } while ((paramhqc1 != null) && (paramhqc2 == null));
      j = paramhqc1.length();
      k = paramhqc2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramhqc1.charAt(i);
        char c2 = paramhqc2.charAt(i);
        if (c1 != c2)
        {
          paramhqc1 = ChnToSpell.a(c1, i);
          paramhqc2 = ChnToSpell.a(c2, i);
          if (paramhqc1.jdField_a_of_type_Int == paramhqc2.jdField_a_of_type_Int) {
            return paramhqc1.jdField_a_of_type_JavaLangString.compareTo(paramhqc2.jdField_a_of_type_JavaLangString);
          }
          return paramhqc1.jdField_a_of_type_Int - paramhqc2.jdField_a_of_type_Int;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j > k);
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */