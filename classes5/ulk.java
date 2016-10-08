import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.FTSSearchResultItem;
import java.util.Comparator;

public class ulk
  implements Comparator
{
  public ulk(FTSMessageSearchEngine paramFTSMessageSearchEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.jdField_a_of_type_Int - paramFTSSearchResultItem2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramFTSSearchResultItem1.jdField_a_of_type_Long + paramFTSSearchResultItem2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */