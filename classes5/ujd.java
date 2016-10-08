import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ujd
  extends SignatureObserver
{
  public ujd(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    int i;
    long l;
    if ((this.a.isResume()) && (paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      i = ((Bundle)paramObject).getInt("unReadNum");
      l = ((Bundle)paramObject).getLong("lastUin");
      if ((i != 0) && (0L != l)) {}
    }
    else
    {
      return;
    }
    paramObject = (LinearLayout)this.a.findViewById(2131305026);
    TextView localTextView = (TextView)this.a.findViewById(2131305028);
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.a.app, 1, l + "");
    if (localFaceDrawable != null) {
      ((ImageView)this.a.findViewById(2131305027)).setImageDrawable(localFaceDrawable);
    }
    localTextView.setText(i + " 条新消息");
    ((LinearLayout)paramObject).setVisibility(0);
  }
  
  protected void d(boolean paramBoolean, Object arg2)
  {
    int i = 0;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      ??? = (Bundle)???;
      paramBoolean = ((Bundle)???).getBoolean("firstFlag", false);
      localObject1 = ((Bundle)???).getString("feedid");
      boolean bool = ((Bundle)???).getBoolean("overFlag", true);
      localObject3 = ((Bundle)???).getStringArrayList("uins");
      StatusHistoryActivity.a(this.a).put(localObject1, Boolean.valueOf(bool));
      ??? = (ArrayList)StatusHistoryActivity.b(this.a).get(localObject1);
      if (localObject3 != null) {}
    }
    else
    {
      return;
    }
    StatusHistoryActivity.b(this.a).put(localObject1, ???);
    for (;;)
    {
      RichStatus localRichStatus;
      synchronized (StatusHistoryActivity.a(this.a))
      {
        if (i >= StatusHistoryActivity.a(this.a).size()) {
          break label236;
        }
        localRichStatus = (RichStatus)StatusHistoryActivity.a(this.a).get(i);
        if (!localRichStatus.feedsId.equals(localObject1)) {
          break label287;
        }
        if (paramBoolean) {
          localRichStatus.mUins = null;
        }
        if (localRichStatus.mUins != null)
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label236;
          }
          localObject3 = (String)((Iterator)localObject1).next();
          if (localRichStatus.mUins.contains(localObject3)) {
            continue;
          }
          localRichStatus.mUins.add(localObject3);
        }
      }
      localRichStatus.mUins = ((List)localObject3);
      label236:
      if (this.a.a != null)
      {
        this.a.a.removeMessages(1);
        Message localMessage = this.a.a.obtainMessage(1);
        this.a.a.sendMessageDelayed(localMessage, 500L);
      }
      return;
      label287:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */