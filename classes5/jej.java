import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView.FileData;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView.FilesViewHolder;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jej
  implements View.OnClickListener
{
  public jej(ZipFilesListAdapter paramZipFilesListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (ZipPreviewFileView.FilesViewHolder)paramView.getTag();
    if (paramView.a.jdField_a_of_type_Boolean)
    {
      localObject = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileZipPreviewActivity.class);
      ((Intent)localObject).putExtra("str_download_dns", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("int32_server_port", this.a.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("string_download_url", this.a.c);
      ((Intent)localObject).putExtra("str_cookie_val", this.a.d);
      ((Intent)localObject).putExtra("filepath", this.a.e + paramView.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("filename", "" + paramView.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("nSessionId", this.a.jdField_b_of_type_Long);
      ((Intent)localObject).putExtra("troop_uin", this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 10099);
      return;
    }
    Object localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).d(4);
    ((ForwardFileInfo)localObject).b(paramView.a.jdField_b_of_type_Long);
    ((ForwardFileInfo)localObject).d(paramView.a.jdField_a_of_type_JavaLangString);
    ((ForwardFileInfo)localObject).d(paramView.a.jdField_a_of_type_Long);
    ((ForwardFileInfo)localObject).b("");
    ((ForwardFileInfo)localObject).b(10000);
    paramView = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileDetailBrowserActivity.class);
    paramView.putExtra("fileinfo", (Parcelable)localObject);
    paramView.putExtra("forward_from_troop_file", true);
    paramView.putExtra("not_forward", true);
    paramView.putExtra("last_time", 0);
    paramView.putExtra("is_in_zip", true);
    this.a.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */