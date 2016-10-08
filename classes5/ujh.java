import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ujh
  extends StatusObserver
{
  private ujh(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList paramArrayList, boolean paramBoolean3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onGetHistory.issuccess=").append(paramBoolean1).append(",start=").append(paramInt1).append(",end=").append(paramInt2).append(",over=").append(paramBoolean2).append(",datasize=");
      if (paramArrayList != null) {
        break label313;
      }
    }
    label313:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("Q.richstatus.history", 2, i + ",isaddfromcard=" + paramBoolean3);
      StatusHistoryActivity.a(this.a, paramBoolean1);
      if (!paramBoolean1) {
        break label458;
      }
      StatusHistoryActivity.a(this.a, false);
      if ((paramBoolean3) && (paramArrayList != null) && (paramArrayList.size() == 1)) {
        StatusHistoryActivity.a(this.a, true);
      }
      this.a.app.b(true, true);
      if ((paramInt1 != 0) || (paramArrayList == null)) {
        break label366;
      }
      if ((paramInt2 == Integer.MAX_VALUE) && (StatusHistoryActivity.a(this.a).size() > 0)) {
        StatusHistoryActivity.a(this.a).clear();
      }
      if (StatusHistoryActivity.a(this.a).size() <= 0) {
        break;
      }
      localObject = paramArrayList.iterator();
      RichStatus localRichStatus1 = (RichStatus)StatusHistoryActivity.a(this.a).get(StatusHistoryActivity.a(this.a).size() - 1);
      while (((Iterator)localObject).hasNext())
      {
        RichStatus localRichStatus2 = (RichStatus)((Iterator)localObject).next();
        if ((localRichStatus2.time <= localRichStatus1.time) && ((localRichStatus2.time != localRichStatus1.time) || (!Arrays.equals(localRichStatus2.encode(), localRichStatus1.encode())))) {
          break;
        }
        ((Iterator)localObject).remove();
      }
    }
    StatusHistoryActivity.a(this.a).addAll(StatusHistoryActivity.a(this.a).size(), paramArrayList);
    paramArrayList = this.a;
    if (!paramBoolean2)
    {
      paramInt1 = 1;
      StatusHistoryActivity.a(paramArrayList, paramInt1);
      label366:
      if (this.a.app.a().equals(StatusHistoryActivity.a(this.a))) {
        break label474;
      }
      this.a.a.setVisibility(0);
      label400:
      if (StatusHistoryActivity.a(this.a).size() != 0) {
        break label494;
      }
      paramArrayList = this.a;
      if (!paramBoolean1) {
        break label489;
      }
      paramInt1 = 3;
      label425:
      StatusHistoryActivity.a(paramArrayList, paramInt1);
    }
    for (;;)
    {
      StatusHistoryActivity.a(this.a).notifyDataSetChanged();
      this.a.a(true, 1000L);
      return;
      paramInt1 = 0;
      break;
      label458:
      if (paramInt1 != 0) {
        break label366;
      }
      StatusHistoryActivity.a(this.a, 3);
      break label366;
      label474:
      this.a.a.setVisibility(8);
      break label400;
      label489:
      paramInt1 = 2;
      break label425;
      label494:
      StatusHistoryActivity.a(this.a).setVisible(false, false);
      ((RelativeLayout)StatusHistoryActivity.a(this.a).findViewById(2131305006)).setVisibility(0);
    }
  }
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.history", 2, "onDeleteStatus. isSuccess=" + paramBoolean + ",key=" + paramArrayOfByte + ",errorCode=" + paramInt);
    }
    if ((StatusHistoryActivity.a(this.a) != null) && (StatusHistoryActivity.a(this.a).isShowing())) {
      StatusHistoryActivity.a(this.a).dismiss();
    }
    if (paramBoolean) {
      if (paramArrayOfByte != null)
      {
        Iterator localIterator = StatusHistoryActivity.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)localIterator.next();
          if ((localRichStatus != null) && (Arrays.equals(localRichStatus.key, paramArrayOfByte))) {
            localIterator.remove();
          }
        }
        if (StatusHistoryActivity.a(this.a).size() == 0) {
          StatusHistoryActivity.a(this.a, 3);
        }
        if (StatusHistoryActivity.a(this.a) != null)
        {
          StatusHistoryActivity.a(this.a).notifyDataSetChanged();
          this.a.a(true, 1000L);
        }
      }
    }
    for (;;)
    {
      StatusHistoryActivity.a(this.a, null);
      StatusHistoryActivity.b(this.a, false);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131371176, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */