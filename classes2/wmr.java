import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ArcImageView;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.qphone.base.util.QLog;

public class wmr
  implements View.OnClickListener
{
  public wmr(MusicPendantView paramMusicPendantView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject;
    do
    {
      return;
      for (;;)
      {
        try
        {
          paramView = MusicPendantManager.a().a();
          if (MusicPendantView.a(this.a) != null) {
            MusicPendantView.a(this.a).removeMessages(1001);
          }
          localObject = MusicPendantManager.a();
          if ((localObject != null) && (((MusicPendantManager)localObject).a()))
          {
            ReportController.b(paramView, "CliOper", "", "", "0X8006A78", "0X8006A78", 0, 0, "", "", "", "");
            if ((localObject == null) || (!((MusicPendantManager)localObject).a()) || ((((MusicPendantManager)localObject).a() != null) && (1 <= ((MusicPendantManager)localObject).a().length))) {
              break;
            }
            this.a.b();
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.e(MusicPendantView.a(), 1, "mPlayClickListener.onClick() exception", paramView);
          return;
        }
        ReportController.b(paramView, "CliOper", "", "", "0X8006A8C", "0X8006A8C", 0, 0, "", "", "", "");
      }
      if (localObject != null) {
        ((MusicPendantManager)localObject).c();
      }
      if (MusicPendantView.a(this.a) != null) {
        MusicPendantView.a(this.a).sendEmptyMessage(1005);
      }
    } while ((MusicPendantView.a(this.a) == null) || (!MusicPendantView.a(this.a).a()));
    MusicPendantView.a(this.a).a(false);
    MusicPendantView.a(true);
    label233:
    label246:
    MusicPendantManager localMusicPendantManager;
    if (paramView != null)
    {
      paramView = (FriendsManager)paramView.getManager(50);
      if (paramView == null) {
        break label308;
      }
      localObject = paramView.a(((MusicPendantManager)localObject).b());
      if ((localObject == null) || (!((Card)localObject).showRedPointMusicPendant)) {
        break label311;
      }
      localMusicPendantManager = MusicPendantManager.a();
      if (!((Card)localObject).showRedPointMusicPendant) {
        break label313;
      }
    }
    label308:
    label311:
    label313:
    for (int i = 0;; i = 1)
    {
      localMusicPendantManager.a(4059, i);
      ((Card)localObject).showRedPointMusicPendant = false;
      if (paramView.a((Card)localObject)) {
        break;
      }
      QLog.e(MusicPendantView.a(), 1, "onClick(): save card in db failed ");
      return;
      paramView = null;
      break label233;
      localObject = null;
      break label246;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */