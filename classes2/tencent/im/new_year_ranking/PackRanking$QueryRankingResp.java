package tencent.im.new_year_ranking;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PackRanking$QueryRankingResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rank_swipe", "rank_combo" }, new Object[] { null, null }, QueryRankingResp.class);
  public PackRanking.RankingInfo rank_combo = new PackRanking.RankingInfo();
  public PackRanking.RankingInfo rank_swipe = new PackRanking.RankingInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_ranking\PackRanking$QueryRankingResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */