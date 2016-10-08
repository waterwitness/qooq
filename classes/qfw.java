import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qfw
  implements Runnable
{
  qfw(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "transaction exception!", 1).show();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */