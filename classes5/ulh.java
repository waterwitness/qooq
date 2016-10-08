import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.FTSSearchResultItem;
import java.util.Comparator;

public class ulh
  implements Comparator
{
  public ulh(FTSMessageSearchEngine paramFTSMessageSearchEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramFTSSearchResultItem1.a + paramFTSSearchResultItem2.a);
      }
    }
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */