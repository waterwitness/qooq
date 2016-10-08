import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanelAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;

public class vii
  implements View.OnClickListener
{
  public vii(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (((PlusPanelAdapter.ViewHolder)paramView.getTag()).a)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.a.k) {
                TroopBarUtils.a(this.a.n, this.a.o, "Clk_photo", this.a.p, "", "", "");
              }
            } while (this.a.a(1));
            if ((this.a.a.a() != 0) && (this.a.a.a() != 4))
            {
              this.a.a(1);
              return;
            }
            this.a.h();
            return;
            if (this.a.k) {
              TroopBarUtils.a(this.a.n, this.a.o, "Clk_shoot", this.a.p, "", "", "");
            }
          } while (this.a.a(1));
          if ((this.a.a.a() != 0) && (this.a.a.a() != 4))
          {
            this.a.a(0);
            return;
          }
          this.a.i();
          return;
          if (this.a.k)
          {
            TroopBarUtils.a(this.a.n, this.a.o, "Clk_record", this.a.p, "", "", "");
            TroopBarUtils.b("reply_page_new", "Clk_record", this.a.p, "", "", "");
          }
        } while (this.a.a(2));
        if ((this.a.a.a() != 0) && (this.a.a.a() != 2))
        {
          this.a.a(2);
          return;
        }
        if (this.a.a.a() == 2)
        {
          this.a.a(5);
          return;
        }
        TroopBarReplyActivity.a(this.a, 4);
        return;
        if (this.a.k)
        {
          TroopBarUtils.a(this.a.n, this.a.o, "Clk_music", this.a.p, "", "", "");
          TroopBarUtils.b("reply_page_new", "Clk_music", this.a.p, "", "", "");
        }
      } while (this.a.a(4));
      if ((this.a.a.a() != 0) && (this.a.a.a() != 1))
      {
        this.a.a(3);
        return;
      }
      this.a.b(4);
      return;
      if (this.a.k)
      {
        TroopBarUtils.a(this.a.n, this.a.o, "Clk_video", this.a.p, "", "", "");
        TroopBarUtils.b("reply_page_new", "Clk_video", this.a.p, "", "", "");
      }
    } while (this.a.a(8));
    if ((this.a.a.a() != 0) && (this.a.a.a() != 3))
    {
      this.a.a(7);
      return;
    }
    this.a.b(3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */