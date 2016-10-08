import android.os.AsyncTask;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class bi
  implements FMDialogUtil.FMDialogInterface
{
  public bi(LiteActivity paramLiteActivity, AsyncTask paramAsyncTask, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Integer[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */