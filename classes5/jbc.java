import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jbc
  extends QRDisplayActivity.GetNicknameObserver
{
  public jbc(QRDisplayActivity paramQRDisplayActivity)
  {
    super(paramQRDisplayActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, List paramList1, List paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "onGetNicknameList: " + paramBoolean);
    }
    if ((paramBoolean) && (paramList1 != null) && (paramList2 != null))
    {
      int j = paramList2.size();
      if ((j > 0) && (paramList1.size() == j))
      {
        if (this.a.b == null) {
          this.a.b = new ArrayList();
        }
        this.a.b.addAll(paramList1);
        int i = 0;
        while (i < j)
        {
          if (this.a.a((String)paramList2.get(i)) == null) {
            this.a.a((String)paramList2.get(i), (String)paramList1.get(i));
          }
          i += 1;
        }
        Collections.sort(this.a.b, new jca(this.a));
      }
    }
    this.a.f = this.a.a(this.a.b);
    if (this.a.f != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.a.f + "," + this.a.g);
      this.a.c.post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */