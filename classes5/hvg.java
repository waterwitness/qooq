import android.os.AsyncTask;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.IOException;

public class hvg
  extends AsyncTask
{
  public hvg(ImageCollectionActivity paramImageCollectionActivity, URLDrawable paramURLDrawable, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        ImageUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity, paramVarArgs);
        return this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getString(2131368777) + " " + paramVarArgs;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getString(2131368778);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      return this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getString(2131368778);
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getString(2131368778);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */