import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class oru
  extends Handler
{
  private final WeakReference a;
  
  public oru(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramPhotoListActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localObject = (PhotoListActivity)this.a.get();
      } while (localObject == null);
      localObject = ((PhotoListActivity)localObject).a;
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((orv)localObject).a);
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("ALBUMLIST_POSITION");
    long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
    paramMessage = (LocalMediaInfo)localArrayList.get(i);
    paramMessage.e = l;
    localArrayList.set(i, paramMessage);
    ((orv)localObject).a(localArrayList);
    ((orv)localObject).notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */