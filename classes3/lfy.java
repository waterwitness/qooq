import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class lfy
  extends MqqHandler
{
  public lfy(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label308:
    label459:
    label484:
    do
    {
      do
      {
        do
        {
          return;
          if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing())) {
            DiscussionInfoCardActivity.a(this.a).dismiss();
          }
          paramMessage = new Intent();
          paramMessage.putExtra("isNeedFinish", true);
          this.a.setResult(-1, paramMessage);
          this.a.finish();
          return;
        } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
        DiscussionInfoCardActivity.a(this.a).dismiss();
        return;
        int i;
        if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a) == 3000))
        {
          if ((this.a.a != null) && (this.a.a.hasRenamed())) {
            DiscussionInfoCardActivity.a(this.a).setRightText(DiscussionInfoCardActivity.b(this.a));
          }
        }
        else
        {
          paramMessage = (ArrayList)paramMessage.obj;
          i = paramMessage.size();
          if (i + 1 <= DiscussionInfoCardActivity.b(this.a) * 3) {
            break label459;
          }
          DiscussionInfoCardActivity.b(this.a).setVisibility(0);
          DiscussionInfoCardActivity.b(this.a).setRightText(i + "人");
          DiscussionInfoCardActivity.b(this.a).setOnClickListener(new lfz(this));
          DiscussionInfoCardActivity.a(this.a).setPadding(DiscussionInfoCardActivity.c(this.a), DiscussionInfoCardActivity.d(this.a), DiscussionInfoCardActivity.e(this.a), DiscussionInfoCardActivity.f(this.a));
          DiscussionInfoCardActivity.a(this.a, paramMessage);
          if (DiscussionInfoCardActivity.a(this.a) != null) {
            break label484;
          }
          DiscussionInfoCardActivity.a(this.a, new lgh(this.a));
          DiscussionInfoCardActivity.a(this.a).setAdapter(DiscussionInfoCardActivity.a(this.a));
        }
        for (;;)
        {
          DiscussionInfoCardActivity.c(this.a).setLeftText(this.a.getString(2131370169, new Object[] { Integer.valueOf(i) }));
          removeMessages(0);
          return;
          DiscussionInfoCardActivity.a(this.a).setRightText(this.a.getString(2131370167));
          break;
          if (DiscussionInfoCardActivity.b(this.a) == null) {
            break label308;
          }
          DiscussionInfoCardActivity.b(this.a).setVisibility(8);
          break label308;
          DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
        }
      } while (DiscussionInfoCardActivity.a(this.a) != 0);
      paramMessage = (String)paramMessage.obj;
    } while ((DiscussionInfoCardActivity.a(this.a) == null) || (paramMessage == null) || (!DiscussionInfoCardActivity.a(this.a).equals(paramMessage)));
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */