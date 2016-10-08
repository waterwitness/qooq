import android.os.AsyncTask;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class bk
  extends AsyncTask
{
  public bk(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Bundle... paramVarArgs)
  {
    Object localObject = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      paramVarArgs = (DataLineHandler)this.a.app.a(8);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
        localDataLineMsgRecord.path = str;
        localDataLineMsgRecord.msgtype = 63527;
        paramVarArgs.a(localDataLineMsgRecord, false);
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.a.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */