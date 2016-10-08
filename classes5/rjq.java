import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class rjq
  implements Runnable
{
  public rjq(CommonUsedSystemEmojiManager paramCommonUsedSystemEmojiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      synchronized (CommonUsedSystemEmojiManager.a(this.a))
      {
        File localFile = new File(BaseApplicationImpl.a.getFilesDir(), "commonusedSystemEmojiInfoFile_v2_" + BaseApplicationImpl.a.a().getAccount());
        EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
        Object localObject1 = CommonUsedSystemEmojiManager.a(this.a);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localSubCmd0x13Rsp.itemlist.set((List)localObject1);
          if ((QLog.isColorLevel()) && (((List)localObject1).size() > 0))
          {
            StringBuilder localStringBuilder = new StringBuilder("saveSystemEmojiInfoToFile : itemsInfo = ");
            int i = 0;
            if (i < ((List)localObject1).size())
            {
              EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
              localStringBuilder.append(";type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
              i += 1;
              continue;
            }
            QLog.d(CommonUsedSystemEmojiManager.a, 2, localStringBuilder.toString());
          }
          FileUtils.a(localFile.getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */