import android.view.View;
import android.widget.TextView;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import java.util.List;

class shl
  implements TroopFileProtocol.OnGetZipFileList
{
  /* Error */
  shl(shk paramshk, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 14	shl:jdField_a_of_type_Shk	Lshk;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 16	shl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 18	shl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: aload_0
    //   16: invokespecial 21	java/lang/Object:<init>	()V
    //   19: getstatic 27	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   22: istore 4
    //   24: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	shl
    //   0	25	1	paramshk	shk
    //   0	25	2	paramString1	String
    //   0	25	3	paramString2	String
    //   22	1	4	bool	boolean
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_JavaUtilList = paramList;
      ZipFilesListAdapter localZipFilesListAdapter = new ZipFilesListAdapter(paramList, ZipPreviewFileView.a(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView));
      localZipFilesListAdapter.e = "/";
      localZipFilesListAdapter.jdField_b_of_type_Long = this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_Long;
      localZipFilesListAdapter.jdField_a_of_type_Long = this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
      localZipFilesListAdapter.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_c_of_type_JavaLangString;
      localZipFilesListAdapter.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.d;
      localZipFilesListAdapter.d = this.jdField_a_of_type_JavaLangString;
      localZipFilesListAdapter.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(localZipFilesListAdapter);
      this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_AndroidWidgetTextView.setText("共" + paramList.size() + "项  " + FileUtil.a(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize));
      ReportController.b(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, "" + this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, "", ZipPreviewFileView.a(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName), "1");
      return;
    }
    this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_AndroidViewView.setVisibility(0);
    ReportController.b(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, "" + this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_Int, ZipPreviewFileView.a(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName), "1");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */