import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import java.util.Comparator;

public class ulj
  implements Comparator
{
  public ulj(FTSMessageSearchEngine paramFTSMessageSearchEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(FTSEntity paramFTSEntity1, FTSEntity paramFTSEntity2)
  {
    long l = ((FTSMessageCodec.TextMsgExts)((FTSMessage)paramFTSEntity1).msgExts).time;
    return Long.signum(((FTSMessageCodec.TextMsgExts)((FTSMessage)paramFTSEntity2).msgExts).time - l);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */