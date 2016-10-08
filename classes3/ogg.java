import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTypeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.widget.CirclePageIndicator;
import java.util.ArrayList;

class ogg
  implements View.OnClickListener
{
  ogg(oge paramoge, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (BlessTypeActivity.b(this.jdField_a_of_type_Oge.a).size() == 1)
    {
      if (oge.a(this.jdField_a_of_type_Oge) == null)
      {
        oge.a(this.jdField_a_of_type_Oge, new ToastStyleDialog(this.jdField_a_of_type_Oge.a));
        oge.a(this.jdField_a_of_type_Oge).a(DisplayUtil.a(this.jdField_a_of_type_Oge.a, 200.0F));
        oge.a(this.jdField_a_of_type_Oge).a(this.jdField_a_of_type_Oge.a.getString(2131372360));
      }
      if (!oge.a(this.jdField_a_of_type_Oge).isShowing())
      {
        oge.a(this.jdField_a_of_type_Oge).show();
        this.jdField_a_of_type_Oge.a.a.postDelayed(new ogh(this), 1000L);
      }
      return;
    }
    BlessTypeActivity.b(this.jdField_a_of_type_Oge.a).remove(this.jdField_a_of_type_Int);
    BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).remove(this.jdField_a_of_type_Int);
    BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).b(BlessTypeActivity.a(this.jdField_a_of_type_Oge.a));
    BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).notifyDataSetChanged();
    this.jdField_a_of_type_Oge.a.a.setAdapter(BlessTypeActivity.a(this.jdField_a_of_type_Oge.a));
    BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).a();
    if (BlessTypeActivity.b(this.jdField_a_of_type_Oge.a).size() < 8) {
      BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).setVisibility(4);
    }
    for (;;)
    {
      BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).setText(String.valueOf(BlessTypeActivity.b(this.jdField_a_of_type_Oge.a).size()));
      int i = this.jdField_a_of_type_Int / 7;
      if ((i <= 0) || (i >= BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).getCount())) {
        break;
      }
      this.jdField_a_of_type_Oge.a.a.setCurrentItem(i, false);
      return;
      BlessTypeActivity.a(this.jdField_a_of_type_Oge.a).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ogg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */