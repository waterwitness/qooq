import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class rvl
  implements Runnable
{
  public rvl(QfileRecentPicFileTabView paramQfileRecentPicFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 0))
      {
        if ((!FileUtil.b(localFileManagerEntity.getFilePath())) && (!FileUtil.b(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label213;
          }
          if (localFileManagerEntity.peerType != 3000) {
            break label186;
          }
          QfileRecentPicFileTabView.a(this.a).a().a(localFileManagerEntity, 3);
        }
        for (;;)
        {
          String str = QfileTimeUtils.b(localFileManagerEntity.srvTime);
          if (!this.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
            this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
          }
          ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
          break;
          label186:
          QfileRecentPicFileTabView.b(this.a).a().a(localFileManagerEntity.Uuid, 3, localFileManagerEntity.bSend, localFileManagerEntity);
          continue;
          label213:
          if (localFileManagerEntity.getCloudType() == 2) {
            QfileRecentPicFileTabView.c(this.a).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.fileName, 3, localFileManagerEntity);
          }
        }
      }
    }
    this.a.j();
    this.a.setSelect(0);
    this.a.a(true);
    this.a.c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */