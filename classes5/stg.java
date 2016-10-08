import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class stg
  implements View.OnClickListener
{
  public stg(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String[]))) {}
    Object localObject;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("HotChatMemberListActivity", 2, "mOnKickOutBtnClickListener onclick");
            }
            i = paramView.getId();
            localObject = (String[])paramView.getTag();
            paramView = localObject[0];
            localObject = localObject[1];
            if (i != 2131301783) {
              break;
            }
            localObject = this.a.a(paramView, false);
          } while (this.a.f.equals(paramView));
          if (localObject != null) {
            ((stz)localObject).a.a(true);
          }
          if (!TextUtils.isEmpty(this.a.f))
          {
            localObject = this.a.a(this.a.f, false);
            if (localObject != null) {
              ((stz)localObject).a.b(true);
            }
          }
          this.a.f = paramView;
          return;
          if (i != 2131298072) {
            break;
          }
          paramView = this.a.a(this.a.f, false);
        } while (paramView == null);
        paramView.a.b(true);
        this.a.f = "";
        return;
      } while ((i != 2131301787) || (!this.a.d));
      if (QLog.isColorLevel()) {
        QLog.d("HotChatMemberListActivity", 2, "delBtn onClick, uin=" + paramView);
      }
      if (NetworkUtil.e(BaseApplication.getContext())) {
        break;
      }
    } while (!this.a.isResume());
    QQToast.a(this.a, this.a.getString(2131369008), 0).b(this.a.getTitleBarHeight());
    return;
    Dialog localDialog = new Dialog(this.a, 2131558973);
    localDialog.setContentView(2130903236);
    TextView localTextView = (TextView)localDialog.findViewById(2131296852);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText("删除成员后，该成员将无法再加入你的热聊房间，确认删除吗？");
    }
    localTextView = (TextView)localDialog.findViewById(2131297843);
    if (localTextView != null)
    {
      localTextView.setText(2131367262);
      localTextView.setOnClickListener(new sth(this, localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131297844);
    if (localTextView != null)
    {
      localTextView.setText("确认");
      localTextView.setOnClickListener(new sti(this, localDialog, paramView, (String)localObject));
    }
    localDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */