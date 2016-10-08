import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class mbl
  implements Comparator
{
  public mbl(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(mbu parammbu1, mbu parammbu2)
  {
    parammbu1 = parammbu1.a.name;
    parammbu2 = parammbu2.a.name;
    if ((parammbu1 == null) && (parammbu2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((parammbu1 == null) && (parammbu2 != null)) {
        return -1;
      }
      if ((parammbu1 != null) && (parammbu2 == null)) {
        return 1;
      }
      j = parammbu1.length();
      k = parammbu2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = parammbu1.charAt(i);
        char c2 = parammbu2.charAt(i);
        if (c1 != c2)
        {
          parammbu1 = ChnToSpell.a(c1, i);
          parammbu2 = ChnToSpell.a(c2, i);
          if (parammbu1.jdField_a_of_type_Int == parammbu2.jdField_a_of_type_Int) {
            return parammbu1.jdField_a_of_type_JavaLangString.compareTo(parammbu2.jdField_a_of_type_JavaLangString);
          }
          return parammbu1.jdField_a_of_type_Int - parammbu2.jdField_a_of_type_Int;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */