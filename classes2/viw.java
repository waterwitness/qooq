import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class viw
  extends Handler
{
  public viw(TroopCreateAvatarActivity paramTroopCreateAvatarActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    boolean bool;
    Object localObject1;
    do
    {
      return;
      paramMessage = paramMessage.getData();
      Object localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
      bool = paramMessage.getBoolean("IS_DEFAULT_AVATAR");
      localObject1 = paramMessage.getStringArray("VERIFYING_PICTURE_LIST");
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = new String[0];
      }
      paramMessage = new HashSet(Arrays.asList(paramMessage));
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          localAvatarInfo.c = str;
          localAvatarInfo.d = "AVATAR_URL_STR";
          localAvatarInfo.b = paramMessage.contains(str);
          ((List)localObject1).add(localAvatarInfo);
        }
      }
    } while (this.a.a == null);
    this.a.a.a((List)localObject1, bool);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\viw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */