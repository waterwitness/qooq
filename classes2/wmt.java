import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.MusicPendantView;

public class wmt
  implements Runnable
{
  public wmt(MusicPendantView paramMusicPendantView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Card localCard = MusicPendantManager.a().a();
    if ((localCard != null) && (localCard.autoPlayMusicPendant) && (!NetworkUtil.c(BaseApplicationImpl.getContext()))) {
      MusicPendantManager.a().b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */