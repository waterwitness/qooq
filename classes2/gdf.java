import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class gdf
  implements Runnable
{
  public gdf(CreateArrageActivity paramCreateArrageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str;
    switch (CreateArrageActivity.a(this.a))
    {
    default: 
      str = String.format("%s:%d", new Object[] { this.a.getString(2131365102), Integer.valueOf(CreateArrageActivity.a(this.a)) });
    }
    for (;;)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
      localQQCustomDialog.setTitle(this.a.getString(2131365097));
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.setPositiveButton(2131365090, new gdg(this));
      localQQCustomDialog.show();
      return;
      this.a.finish();
      return;
      str = this.a.getString(2131365098);
      continue;
      str = this.a.getString(2131365099);
      continue;
      str = this.a.getString(2131365100);
      continue;
      str = this.a.getString(2131365101);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */