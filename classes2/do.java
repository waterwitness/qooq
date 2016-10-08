import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.ItemHolder;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class do
  implements View.OnClickListener
{
  public do(PrinterSessionAdapter paramPrinterSessionAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (PrinterItemMsgRecord)((ItemHolder)paramView.getTag()).a();
    if (localObject != null)
    {
      paramView = FileManagerUtil.a((PrinterItemMsgRecord)localObject);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10009);
      localForwardFileInfo.d(6);
      localForwardFileInfo.b(paramView.nSessionId);
      localForwardFileInfo.d(paramView.fileName);
      localForwardFileInfo.c(((PrinterItemMsgRecord)localObject).uSessionID);
      localForwardFileInfo.d(paramView.fileSize);
      localForwardFileInfo.a(paramView.getFilePath());
      localObject = new Intent(this.a.a.getApplicationContext(), FileBrowserActivity.class);
      if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(paramView.nSessionId));
        ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      this.a.a.startActivityForResult((Intent)localObject, 102);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */