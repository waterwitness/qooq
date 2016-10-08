import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jei
  implements HttpWebCgiAsyncTask.Callback
{
  public jei(List paramList, String paramString, FileManagerEntity paramFileManagerEntity, int paramInt, QQAppInterface paramQQAppInterface, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramJSONObject != null) {}
    try
    {
      ZipPreviewFileView.FileData localFileData;
      if (!paramJSONObject.isNull("dirs"))
      {
        paramBundle = paramJSONObject.getJSONArray("dirs");
        paramInt = 0;
        while (paramInt < paramBundle.length())
        {
          localFileData = new ZipPreviewFileView.FileData();
          localFileData.jdField_a_of_type_Boolean = true;
          localFileData.jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
          this.jdField_a_of_type_JavaUtilList.add(localFileData);
          paramInt += 1;
        }
      }
      if ((paramJSONObject != null) && (!paramJSONObject.isNull("files")))
      {
        paramBundle = paramJSONObject.getJSONArray("files");
        paramInt = 0;
        if (paramInt < paramBundle.length())
        {
          localFileData = new ZipPreviewFileView.FileData();
          paramJSONObject = paramBundle.getJSONObject(paramInt);
          localFileData.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
          localFileData.jdField_a_of_type_Long = paramJSONObject.getLong("size");
          if (this.jdField_a_of_type_JavaLangString.equals("/")) {}
          for (paramJSONObject = "/" + localFileData.jdField_a_of_type_JavaLangString;; paramJSONObject = this.jdField_a_of_type_JavaLangString + "/" + localFileData.jdField_a_of_type_JavaLangString)
          {
            if (0 == 0)
            {
              FileManagerEntity localFileManagerEntity = new FileManagerEntity();
              localFileManagerEntity.fileName = localFileData.jdField_a_of_type_JavaLangString;
              localFileManagerEntity.fileSize = localFileData.jdField_a_of_type_Long;
              localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
              localFileManagerEntity.strTroopFilePath = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath + this.jdField_a_of_type_JavaLangString + localFileData.jdField_a_of_type_JavaLangString);
              localFileManagerEntity.strTroopFileID = UUID.nameUUIDFromBytes(localFileManagerEntity.strTroopFilePath.getBytes()).toString();
              localFileManagerEntity.zipInnerPath = paramJSONObject;
              localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
              localFileManagerEntity.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
              localFileManagerEntity.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
              localFileManagerEntity.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
              localFileManagerEntity.cloudType = 4;
              localFileManagerEntity.isZipInnerFile = true;
              localFileManagerEntity.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
              localFileManagerEntity.zipType = this.jdField_a_of_type_Int;
              localFileManagerEntity.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
              localFileData.b = localFileManagerEntity.nSessionId;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
            }
            this.jdField_a_of_type_JavaUtilList.add(localFileData);
            paramInt += 1;
            break;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      if (this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList != null) {
        this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */