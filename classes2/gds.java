import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;

public class gds
  implements View.OnClickListener
{
  public gds(EditMemberActivity paramEditMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    int i;
    String str;
    label272:
    label405:
    do
    {
      do
      {
        boolean bool1;
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d(EditMemberActivity.a(), 2, "mOnKickOutBtnClickListener onclick");
              }
              i = paramView.getId();
              str = (String)paramView.getTag();
              if (i != 2131298073) {
                break label272;
              }
              paramView = paramView.findViewById(2131298074);
              bool1 = bool2;
              if (paramView.getTag() != null)
              {
                bool1 = bool2;
                if ((paramView.getTag() instanceof Boolean)) {
                  bool1 = ((Boolean)paramView.getTag()).booleanValue();
                }
              }
              paramView = this.a.a(str, bool1);
              if (!bool1) {
                break;
              }
            } while (this.a.i.equals(str));
            if (paramView != null) {
              paramView.a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.i))
            {
              paramView = this.a.a(this.a.i, bool1);
              if (paramView != null) {
                paramView.a.b(true);
              }
            }
            this.a.i = str;
            return;
          } while (this.a.h.equals(str));
          if (paramView != null) {
            paramView.a.a(true);
          }
          if (!TextUtils.isEmpty(this.a.h))
          {
            paramView = this.a.a(this.a.h, bool1);
            if (paramView != null) {
              paramView.a.b(true);
            }
          }
          this.a.h = str;
          return;
          if (i != 2131298072) {
            break label405;
          }
          paramView = paramView.findViewById(2131301785);
          bool1 = bool3;
          if (paramView.getTag() != null)
          {
            bool1 = bool3;
            if ((paramView.getTag() instanceof Boolean)) {
              bool1 = ((Boolean)paramView.getTag()).booleanValue();
            }
          }
          if (!bool1) {
            break;
          }
          paramView = this.a.a(this.a.i, bool1);
        } while (paramView == null);
        paramView.a.b(true);
        this.a.i = "";
        return;
        paramView = this.a.a(this.a.h, bool1);
      } while (paramView == null);
      paramView.a.b(true);
      this.a.h = "";
      return;
    } while ((i != 2131301787) || (!this.a.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.d(EditMemberActivity.a(), 2, "delBtn onClick, uin=" + str);
    }
    EditMemberActivity.a(this.a, str);
    if (this.a.b)
    {
      EditMemberActivity.a(this.a).setText(2131367263);
      this.a.jdField_a_of_type_Geg.notifyDataSetChanged();
    }
    this.a.jdField_a_of_type_Ged.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */